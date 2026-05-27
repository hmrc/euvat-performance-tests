/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.euvat.simulations

import io.gatling.core.scenario.Simulation
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.euvat.requests.AuthRequests._
import uk.gov.hmrc.perftests.euvat.requests.MakeNewEUVATClaimRequests._
import uk.gov.hmrc.perftests.euvat.requests.ManageEUVATRequests._

class EUVATSimulation extends Simulation with PerformanceTestRunner {

  setup("manage-organisation", "Manage organisation").withRequests(
    getAuthPage,
    postAuthPage("Organisation", "123456"),
    getSession,
    getManageEUVATFrontend,
    getManageEUVATClaimPage
  )

  setup("new-EUVAT-claim", "New claim").withRequests(
    getMakeANewEUVATClaimPage,
    getWhichEUMemberStateAreYouClaimingBackVATFrom,
    postWhichEUMemberStateAreYouClaimingBackVATFrom("France"),
    getWhatLanguageDoYouWantToUseForThisClaim,
    postWhatLanguageDoYouWantToUseForThisClaim("english"),
    getWhatIsTheRefundPeriod,
    postWhatIsTheRefundPeriod("08", "2025", "12", "2025"),
    getWhoShouldWeContactAboutThisClaim,
    postWhoShouldWeContactAboutThisClaim("Test123@test.com", "01234567890"),
    getBusinessActivity,
    postBusinessActivity("true"),
    getAddBusinessActivityCodeTwo,
    postAddBusinessActivityCodeTwo("47110 (Retail sale in non-specialised stores)"),
    getBusinessActivityTwo,
    postBusinessActivityTwo("true"),
    getAddBusinessActivityCodeThree,
    postAddBusinessActivityCodeThree("11010 (Manufacture of beverages)"),
    getBusinessActivityThree,
    postBusinessActivityThree,
    getCheckYourClaimDetails,
    postCheckYourClaimDetails,
    getMakeANewEUVATClaimPage,
    getAboutThePurchase,
    getPurchaseType,
    postPurchaseType("fuel"),
    getWhatIsTheSuppliersName,
    postWhatIsTheSuppliersName("Testing")
//    getWhatIsTheSuppliersAddress,
//    postWhatIsTheSuppliersAddress("Test Address Line 1", "Test Address Line 2", "Test Address Line 3"),
//    getWhatIsTheInvoiceNumber,
//    postWhatIsTheInvoiceNumber(""),
//    getWhatIsTheInvoiceDate,
//    postWhatIsTheInvoiceDate("15","05","2026")
  )

  runSimulation()
}
