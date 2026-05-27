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

  def postWhoShouldWeContactAboutThisClaim(email: String, telephone: String): HttpRequestBuilder =
    http("[post] Who should we contact about this claim page")
      .post(euvatFilingFrontendUrl + "/who-contact-about-this-claim")
      .formParam("contactEmail", email)
      .formParam("contactTelephone", telephone)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getBusinessActivity: HttpRequestBuilder =
    http("[get ] Business activity 1 for this claim page")
      .get(euvatFilingFrontendUrl + "/business-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postBusinessActivity(option: String): HttpRequestBuilder =
    http("[post] Business activity 1 for this claim page")
      .post(euvatFilingFrontendUrl + "/business-activity")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAddBusinessActivityCodeTwo: HttpRequestBuilder =
    http("[get ] What is the 2nd business activity? page")
      .get(euvatFilingFrontendUrl + "/what-is-the-2nd-business-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddBusinessActivityCodeTwo(businessActivityCode2: String): HttpRequestBuilder =
    http("[post] What is the 2nd business activity? page")
      .post(euvatFilingFrontendUrl + "/what-is-the-2nd-business-activity")
      .formParam("value", businessActivityCode2)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getBusinessActivityTwo: HttpRequestBuilder =
    http("[get ] Business activity 2 for this claim page")
      .get(euvatFilingFrontendUrl + "/business-activity-2")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postBusinessActivityTwo(option: String): HttpRequestBuilder =
    http("[post] Business activity 2 for this claim page")
      .post(euvatFilingFrontendUrl + "/business-activity-2")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAddBusinessActivityCodeThree: HttpRequestBuilder =
    http("[get ] What is the 3rd business activity?  page")
      .get(euvatFilingFrontendUrl + "/what-is-the-3rd-business-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddBusinessActivityCodeThree(businessActivityCode3: String): HttpRequestBuilder =
    http("[post] What is the 3rd business activity?  page")
      .post(euvatFilingFrontendUrl + "/what-is-the-3rd-business-activity")
      .formParam("value", businessActivityCode3)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getBusinessActivityThree: HttpRequestBuilder =
    http("[get ] Business activity 3 for this claim page")
      .get(euvatFilingFrontendUrl + "/business-activity-3")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postBusinessActivityThree: HttpRequestBuilder =
    http("[post] Business activity 3 for this claim page")
      .post(euvatFilingFrontendUrl + "/business-activity-3")
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

  val getWhatIsTheSuppliersAddress: HttpRequestBuilder =
    http("[get ] What is the supplier's address page")
      .get(euvatFilingFrontendUrl + "/what-supplier-address")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheSuppliersAddress(
    addressLine1: String,
    addressLine2: String,
    addressLine3: String
  ): HttpRequestBuilder =
    http("[post] What is the supplier's address page")
      .post(euvatFilingFrontendUrl + "/what-supplier-address")
      .formParam("supplierAddressLine1", addressLine1)
      .formParam("supplierAddressLine2", addressLine2)
      .formParam("supplierAddressLine3", addressLine3)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheInvoiceNumber: HttpRequestBuilder =
    http("[get ] What is the invoice number page")
      .get(euvatFilingFrontendUrl + "/invoice-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheInvoiceNumber(invoiceNumber: String): HttpRequestBuilder =
    http("[post] What is the invoice number page")
      .post(euvatFilingFrontendUrl + "/invoice-number")
      .formParam("value", invoiceNumber)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheInvoiceDate: HttpRequestBuilder =
    http("[get ] What is the invoice date page")
      .get(euvatFilingFrontendUrl + "/invoice-date")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheInvoiceDate(
    invoiceDate: String,
    invoiceMonth: String,
    invoiceYear: String
  ): HttpRequestBuilder =
    http("[post] What is the invoice date page")
      .post(euvatFilingFrontendUrl + "/invoice-date")
      .formParam("invoice.date", invoiceDate)
      .formParam("invoice.month", invoiceMonth)
      .formParam("invoice.year", invoiceYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))
}
