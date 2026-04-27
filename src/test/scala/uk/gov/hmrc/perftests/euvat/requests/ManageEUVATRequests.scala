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

package uk.gov.hmrc.perftests.euvat.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object ManageEUVATRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getManageEUVATClaimPage: HttpRequestBuilder =
    http("[get ] Manage your EUVAT claim page")
      .get(euvatMgmtFrontendUrl + "/manage-eu-vat-claim")
      .check(status.is(200))

//  val postManageEUVATClaimPage: HttpRequestBuilder =
//    http("[post] Manage your EUVAT claim page")
//      .post(euvatMgmtFrontendUrl + "/manage-eu-vat-claim")
//      .formParam("csrfToken", f"#{csrfToken}")
//      .check(status.is(303))

  val getClickMakeANewEUVATClaimLink: HttpRequestBuilder =
    http("[get ] Click Make a new EU VAT claim link")
      .get(euvatFilingFrontendUrl + "/make-eu-vat-claim")
      .check(status.is(200))

  val getWhichEUMemberStateAreYouClaimingBackVATFrom: HttpRequestBuilder =
    http("[get ] Which EU member state are you claiming back VAT from?")
      .get(euvatFilingFrontendUrl + "/which-eu-member-state")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhichEUMemberStateAreYouClaimingBackVATFrom(country: String): HttpRequestBuilder =
    http("[post] Which EU member state are you claiming back VAT from?")
      .post(euvatFilingFrontendUrl + "/which-eu-member-state")
      .formParam("value", country)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

}
