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

  val getChangeWhichEUMemberStateAreYouClaimingBackVATFrom: HttpRequestBuilder =
    http("[get ] Change Which EU member state are you claiming back VAT from?")
      .get(euvatFilingFrontendUrl + "/change-which-eu-member-state")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhichEUMemberStateAreYouClaimingBackVATFrom(name: String): HttpRequestBuilder =
    http("[post] Change Which EU member state are you claiming back VAT from page")
      .post(euvatFilingFrontendUrl + "/change-which-eu-member-state")
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

  val getChangeWhatLanguageDoYouWantToUseForThisClaim: HttpRequestBuilder =
    http("[get ] Change What language do you want to use for this claim page")
      .get(euvatFilingFrontendUrl + "/change-what-language")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhatLanguageDoYouWantToUseForThisClaim(option: String): HttpRequestBuilder =
    http("[post] Change What language do you want to use for this claim page")
      .post(euvatFilingFrontendUrl + "/change-what-language")
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

  val getChangeWhatIsTheRefundPeriod: HttpRequestBuilder =
    http("[get ] Change What Is The Refund Period page")
      .get(euvatFilingFrontendUrl + "/change-refund-period")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhatIsTheRefundPeriod(
    startMonth: String,
    startYear: String,
    endMonth: String,
    endYear: String
  ): HttpRequestBuilder =
    http("[post] Change What Is The Refund Period page")
      .post(euvatFilingFrontendUrl + "/change-refund-period")
      .formParam("start.month", startMonth)
      .formParam("start.year", startYear)
      .formParam("end.month", endMonth)
      .formParam("end.year", endYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getHowShouldWeContactYouAboutThisClaim: HttpRequestBuilder =
    http("[get ] How should we contact you about this claim? page")
      .get(euvatFilingFrontendUrl + "/how-contact-you-about-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postHowShouldWeContactYouAboutThisClaim(email: String, telephone: String): HttpRequestBuilder =
    http("[post] How should we contact you about this claim? page")
      .post(euvatFilingFrontendUrl + "/how-contact-you-about-claim")
      .formParam("contactEmail", email)
      .formParam("contactTelephone", telephone)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeHowShouldWeContactYouAboutThisClaim: HttpRequestBuilder =
    http("[get ] Change How should we contact you about this claim? page")
      .get(euvatFilingFrontendUrl + "/change-how-contact-you-about-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeHowShouldWeContactYouAboutThisClaim(email: String, telephone: String): HttpRequestBuilder =
    http("[post] Change How should we contact you about this claim? page")
      .post(euvatFilingFrontendUrl + "/change-how-contact-you-about-claim")
      .formParam("contactEmail", email)
      .formParam("contactTelephone", telephone)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getBusinessActivity: HttpRequestBuilder =
    http("[get ] Business activity (1) for this claim page")
      .get(euvatFilingFrontendUrl + "/business-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postBusinessActivity(option: String): HttpRequestBuilder =
    http("[post] Business activity (1) for this claim page")
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

  val getChangeAddBusinessActivityCodeTwo: HttpRequestBuilder =
    http("[get ] Change What is the 2nd business activity? page")
      .get(euvatFilingFrontendUrl + "/change-what-is-the-2nd-business-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeAddBusinessActivityCodeTwo(businessActivityCode2: String): HttpRequestBuilder =
    http("[post] Change What is the 2nd business activity? page")
      .post(euvatFilingFrontendUrl + "/change-what-is-the-2nd-business-activity")
      .formParam("value", businessActivityCode2)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getRemoveBusinessActivityCodeTwo: HttpRequestBuilder =
    http("[get ] Are you sure you want to remove the second SIC code? page")
      .get(euvatFilingFrontendUrl + "/remove-second-SIC-code")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRemoveBusinessActivityCodeTwo(option: String): HttpRequestBuilder =
    http("[post] Are you sure you want to remove the second SIC code? page")
      .post(euvatFilingFrontendUrl + "/remove-second-SIC-code")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))


  val getBusinessActivityTwo: HttpRequestBuilder =
    http("[get ] Business activities (2) for this claim page")
      .get(euvatFilingFrontendUrl + "/business-activity-2")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postBusinessActivityTwo(option: String): HttpRequestBuilder =
    http("[post] Business activities (2) for this claim page")
      .post(euvatFilingFrontendUrl + "/business-activity-2")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeBusinessActivityTwo: HttpRequestBuilder =
    http("[get ] Change Business activities (2) for this claim page")
      .get(euvatFilingFrontendUrl + "/change-business-activity-2")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeBusinessActivityTwo(option: String): HttpRequestBuilder =
    http("[post] Change Business activities (2) for this claim page")
      .post(euvatFilingFrontendUrl + "/change-business-activity-2")
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

  val getChangeAddBusinessActivityCodeThree: HttpRequestBuilder =
    http("[get ] Change What is the 3rd business activity?  page")
      .get(euvatFilingFrontendUrl + "/change-what-is-the-3rd-business-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeAddBusinessActivityCodeThree(businessActivityCode3: String): HttpRequestBuilder =
    http("[post] Change What is the 3rd business activity?  page")
      .post(euvatFilingFrontendUrl + "/change-what-is-the-3rd-business-activity")
      .formParam("value", businessActivityCode3)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getRemoveBusinessActivityCodeThree: HttpRequestBuilder =
    http("[get ] Are you sure you want to remove the third SIC code? page")
      .get(euvatFilingFrontendUrl + "/remove-third-SIC-code")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRemoveBusinessActivityCodeThree(option: String): HttpRequestBuilder =
    http("[post] Are you sure you want to remove the third SIC code? page")
      .post(euvatFilingFrontendUrl + "/remove-third-SIC-code")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getBusinessActivityThree: HttpRequestBuilder =
    http("[get ] Business activities (3) for this claim page")
      .get(euvatFilingFrontendUrl + "/business-activity-3")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postBusinessActivityThree: HttpRequestBuilder =
    http("[post] Business activities (3) for this claim page")
      .post(euvatFilingFrontendUrl + "/business-activity-3")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeBusinessActivityThree: HttpRequestBuilder =
    http("[get ] Change Business activities (3) for this claim page")
      .get(euvatFilingFrontendUrl + "/change-business-activity-3")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeBusinessActivityThree: HttpRequestBuilder =
    http("[post] Change Business activities (3) for this claim page")
      .post(euvatFilingFrontendUrl + "/change-business-activity-3")
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

  val postAboutThePurchase: HttpRequestBuilder =
    http("[post] About the purchase page")
      .post(euvatFilingFrontendUrl + "/about-the-purchase")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

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
      .formParam("addressLine1", addressLine1)
      .formParam("addressLine2", addressLine2)
      .formParam("addressLine3", addressLine3)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatTypeOfInvoiceDoYouHave: HttpRequestBuilder =
    http("[get ] What type of invoice do you have page")
      .get(euvatFilingFrontendUrl + "/invoice-type")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatTypeOfInvoiceDoYouHave(option: String): HttpRequestBuilder =
    http("[post] What type of invoice do you have page")
      .post(euvatFilingFrontendUrl + "/invoice-type")
      .formParam("value", option)
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
      .get(euvatFilingFrontendUrl + "/what-is-the-invoice-date")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheInvoiceDate(
    invoiceDay: String,
    invoiceMonth: String,
    invoiceYear: String
  ): HttpRequestBuilder =
    http("[post] What is the invoice date page")
      .post(euvatFilingFrontendUrl + "/what-is-the-invoice-date")
      .formParam("value.day", invoiceDay)
      .formParam("value.month", invoiceMonth)
      .formParam("value.year", invoiceYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAddVATRegistration: HttpRequestBuilder =
    http("[get ] Does the simplified invoice contain the supplier’s VAT registration number? page")
      .get(euvatFilingFrontendUrl + "/simplified-invoice-supplier-vat-registration-check")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddVATRegistration(option: String): HttpRequestBuilder =
    http("[post] Does the simplified invoice contain the supplier’s VAT registration number? page")
      .post(euvatFilingFrontendUrl + "/simplified-invoice-supplier-vat-registration-check")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))
}
