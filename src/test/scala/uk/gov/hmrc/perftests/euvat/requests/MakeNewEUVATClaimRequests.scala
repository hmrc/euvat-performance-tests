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

  val getClickAddClaimDetailsLink: HttpRequestBuilder =
    http("[get ] Click Add Claim Details link")
      .get(euvatFilingFrontendUrl + "/make-eu-vat-claim")
      .check(status.is(200))

  val getWhichEUMemberStateAreYouClaimingBackVATFrom: HttpRequestBuilder =
    http("[get ] Which EU member state are you claiming back VAT from?")
      .get(euvatFilingFrontendUrl + "/which-eu-member-state")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhichEUMemberStateAreYouClaimingBackVATFrom(name: String): HttpRequestBuilder =
    http("[post] Which EU member state are you claiming back VAT from page")
      .post(euvatFilingFrontendUrl + "/which-eu-member-state")
      .formParam("value", name)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatLanguageDoYouWantToUseForThisClaim: HttpRequestBuilder =
    http("[get ] What language do you want to use for this claim page")
      .get(euvatFilingFrontendUrl + "/what-language")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatLanguageDoYouWantToUseForThisClaim(option: String): HttpRequestBuilder =
    http("[post] What language do you want to use for this claim page")
      .post(euvatFilingFrontendUrl + "/what-language")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheRefundPeriod: HttpRequestBuilder =
    http("[get ] What Is The Refund Period page")
      .get(euvatFilingFrontendUrl + "/what-refund-period")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheRefundPeriod(
    startMonth: String,
    startYear: String,
    endMonth: String,
    endYear: String
  ): HttpRequestBuilder =
    http("[post] What Is The Refund Period page")
      .post(euvatFilingFrontendUrl + "/what-refund-period")
      .formParam("start.month", startMonth)
      .formParam("start.year", startYear)
      .formParam("end.month", endMonth)
      .formParam("end.year", endYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhoShouldWeContactAboutThisClaim: HttpRequestBuilder =
    http("[get ] Who should we contact about this claim page")
      .get(euvatFilingFrontendUrl + "/who-contact-about-this-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhoShouldWeContactAboutThisClaim(
    email: String,
    first: String,
    last: String,
    telephone: String
  ): HttpRequestBuilder =
    http("[post] Who should we contact about this claim page")
      .post(euvatFilingFrontendUrl + "/who-contact-about-this-claim")
      .formParam("contactEmail", email)
      .formParam("contactFirstName", first)
      .formParam("contactLastName", last)
      .formParam("contactTelephone", telephone)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAddBusinessActivityForThisClaim: HttpRequestBuilder =
    http("[get ] Business activity for this claim page")
      .get(euvatFilingFrontendUrl + "/what-business-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddBusinessActivityForThisClaim(option: String): HttpRequestBuilder =
    http("[post] Business activity for this claim page")
      .post(euvatFilingFrontendUrl + "/what-business-activity")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAddSecondBusinessActivityForThisClaim: HttpRequestBuilder =
    http("[get ] Business activity for this claim page")
      .get(euvatFilingFrontendUrl + "/what-business-activity-two")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddSecondBusinessActivityForThisClaim(option: String): HttpRequestBuilder =
    http("[post] Business activity for this claim page")
      .post(euvatFilingFrontendUrl + "/what-business-activity-two")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAddingBusinessActivityCodeTwo: HttpRequestBuilder =
    http("[get ] Add a 2nd business activity code page")
      .get(euvatFilingFrontendUrl + "/business-activity-code-two")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddingBusinessActivityCodeTwo(businessActivityCode2: String): HttpRequestBuilder =
    http("[post] Add a 2nd business activity code page")
      .post(euvatFilingFrontendUrl + "/business-activity-code-two")
      .formParam("value", businessActivityCode2)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAddingBusinessActivityCodeThree: HttpRequestBuilder =
    http("[get ] Add a 3rd business activity code page")
      .get(euvatFilingFrontendUrl + "/business-activity-code-three")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddingBusinessActivityCodeThree(businessActivityCode3: String): HttpRequestBuilder =
    http("[post] Add a 3rd business activity code page")
      .post(euvatFilingFrontendUrl + "/business-activity-code-three")
      .formParam("value", businessActivityCode3)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getBusinessActivityCodeThree: HttpRequestBuilder =
    http("[get ] Business activity code three page")
      .get(euvatFilingFrontendUrl + "/business-activity-three")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postBusinessActivityCodeThree: HttpRequestBuilder =
    http("[post] Business activity code three page")
      .post(euvatFilingFrontendUrl + "/business-activity-three")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckYourClaimDetails: HttpRequestBuilder =
    http("[get ] Check your claim details page")
      .get(euvatFilingFrontendUrl + "/check-your-claim-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckYourClaimDetails: HttpRequestBuilder =
    http("[post] Check your claim details page")
      .post(euvatFilingFrontendUrl + "/check-your-claim-details")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAboutThePurchase: HttpRequestBuilder =
    http("[get ] About the purchase page")
      .get(euvatFilingFrontendUrl + "/about-the-purchase")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getPurchaseType: HttpRequestBuilder =
    http("[get ] Purchase type page")
      .get(euvatFilingFrontendUrl + "/purchase-type")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPurchaseType(option: String): HttpRequestBuilder =
    http("[post] Purchase type page")
      .post(euvatFilingFrontendUrl + "/purchase-type")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheSuppliersName: HttpRequestBuilder =
    http("[get ] What is the supplier's name page")
      .get(euvatFilingFrontendUrl + "/what-supplier-name")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheSuppliersName(supplierName: String): HttpRequestBuilder =
    http("[post] What is the supplier's name page")
      .post(euvatFilingFrontendUrl + "/what-supplier-name")
      .formParam("value", supplierName)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))
}
