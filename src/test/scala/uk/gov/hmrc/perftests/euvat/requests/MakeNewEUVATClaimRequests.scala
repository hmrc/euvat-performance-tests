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

object MakeNewEUVATClaimRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getMakeANewEUVATClaim: HttpRequestBuilder =
    http("[get ] Adding Claim Details to EU VAT")
      .get(euvatFilingFrontendUrl)
      .check(status.is(303))

  val getMakeAnEUVATClaim: HttpRequestBuilder =
    http("[get ] Make An EU VAT Claim page")
      .get(euvatFilingFrontendUrl + "/make-eu-vat-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getClickAddClaimDetailsLink: HttpRequestBuilder =
    http("[get ] Click Add Claim Details link")
      .get(euvatFilingFrontendUrl + "/make-eu-vat-claim")
      .check(status.is(303))

  val getWhichEUMemberStateAreYouClaimingBackVATFrom: HttpRequestBuilder =
    http("[get ] Which EU Member State Are You Claiming Back VAT From page")
      .get(euvatFilingFrontendUrl + "/which-eu-member-state-claiming-back-vat")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhichEUMemberStateAreYouClaimingBackVATFrom(name: String): HttpRequestBuilder =
    http("[post] Which EU Member State Are You Claiming Back VAT From page")
      .post(euvatFilingFrontendUrl + "/which-eu-member-state-claiming-back-vat")
      .formParam("value", name)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheRefundPeriod: HttpRequestBuilder =
    http("[get ] What Is The Refund Period page")
      .get(euvatMgmtFrontendUrl + "/when-refund-period")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheRefundPeriod(
    startMonth: String,
    startYear: String,
    endMonth: String,
    endYear: String
  ): HttpRequestBuilder =
    http("[post] What Is The Refund Period page")
      .post(euvatMgmtFrontendUrl + "/when-refund-period")
      .formParam("When is the refund period start date?", startMonth)
      .formParam("When is the refund period start date?", startYear)
      .formParam("When is the refund period end date?", endMonth)
      .formParam("When is the refund period end date?", endYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhoShouldWeContactAboutThisClaim: HttpRequestBuilder =
    http("[get ] Who should we contact about this claim page")
      .get(euvatMgmtFrontendUrl + "/who-contact-about-this-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhoShouldWeContactAboutThisClaim(
    email: String,
    first: String,
    last: String,
    telephone: String
  ): HttpRequestBuilder =
    http("[post] Who should we contact about this claim page")
      .post(euvatMgmtFrontendUrl + "/who-contact-about-this-claim")
      .formParam("emailAddress", email)
      .formParam("firstName", first)
      .formParam("lastName", last)
      .formParam("telephoneNumber", telephone)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

}
