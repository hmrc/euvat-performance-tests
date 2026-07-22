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

object PurchaseRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getBeforeYouStart: HttpRequestBuilder =
    http("[get ] Before you start page")
      .get(euvatFilingFrontendUrl + "/before-you-start")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postBeforeYouStart: HttpRequestBuilder =
    http("[post] Before you start page")
      .post(euvatFilingFrontendUrl + "/before-you-start")
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

  val getInvoiceItemDescription: HttpRequestBuilder =
    http("[get ] Describe the items on your invoice page")
      .get(euvatFilingFrontendUrl + "/describe-items-on-invoice")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postInvoiceItemDescription(itemDescription: String): HttpRequestBuilder =
    http("[post] Describe the items on your invoice page")
      .post(euvatFilingFrontendUrl + "/describe-items-on-invoice")
      .formParam("value", itemDescription)
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

  val getWhatIsTheSuppliersTaxID: HttpRequestBuilder =
    http("[get ] What is the supplier's tax identifier number page")
      .get(euvatFilingFrontendUrl + "/supplier-tax-identifier-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheSuppliersTaxID(option: String): HttpRequestBuilder =
    http("[post] What is the supplier's tax identifier number page")
      .post(euvatFilingFrontendUrl + "/supplier-tax-identifier-number")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getSuppliersTaxNumbers: HttpRequestBuilder =
    http("[get ] Select the supplier tax numbers shown on the invoice page")
      .get(euvatFilingFrontendUrl + "/supplier-tax-numbers")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postSuppliersTaxNumbers(suppliersTaxNumber: String): HttpRequestBuilder =
    http("[post] Select the supplier tax numbers shown on the invoice page")
      .post(euvatFilingFrontendUrl + "/supplier-tax-numbers")
      .formParam("value", suppliersTaxNumber)
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

  val getVATRegistrationNumber: HttpRequestBuilder =
    http("[get ] What is the supplier’s VAT registration number? page")
      .get(euvatFilingFrontendUrl + "/what-supplier-vat-registration-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postVATRegistrationNumber(option: String): HttpRequestBuilder =
    http("[post] What is the supplier’s VAT registration number? page")
      .post(euvatFilingFrontendUrl + "/what-supplier-vat-registration-number")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getTotalPurchaseAmount: HttpRequestBuilder =
    http("[get ] Total purchase amount before VAT page")
      .get(euvatFilingFrontendUrl + "/total-purchase-amount-before-vat")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTotalPurchaseAmount(option: String): HttpRequestBuilder =
    http("[post] Total purchase amount before VAT page")
      .post(euvatFilingFrontendUrl + "/total-purchase-amount-before-vat")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getTotalVatPaid: HttpRequestBuilder =
    http("[get ] Total VAT paid page")
      .get(euvatFilingFrontendUrl + "/total-vat-paid")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTotalVatPaid(option: String): HttpRequestBuilder =
    http("[post] Total VAT paid page")
      .post(euvatFilingFrontendUrl + "/total-vat-paid")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getTotalVatClaim: HttpRequestBuilder =
    http("[get ] Total VAT claim page")
      .get(euvatFilingFrontendUrl + "/total-vat-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTotalVatClaim(option: String): HttpRequestBuilder =
    http("[post] Total VAT claim page")
      .post(euvatFilingFrontendUrl + "/total-vat-claim")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val AddPurchaseJourney: List[HttpRequestBuilder] = List(
    getBeforeYouStart,
    postBeforeYouStart,
    getPurchaseType,
    postPurchaseType("fuel"),
    getInvoiceItemDescription,
    postInvoiceItemDescription("Test item description"),
    getWhatTypeOfInvoiceDoYouHave,
    postWhatTypeOfInvoiceDoYouHave("standard invoice"),
    getWhatIsTheInvoiceNumber,
    postWhatIsTheInvoiceNumber("ABC1234567890"),
    getWhatIsTheInvoiceDate,
    postWhatIsTheInvoiceDate("08", "12", "2025"),
    getWhatIsTheSuppliersName,
    postWhatIsTheSuppliersName("Testing"),
    getWhatIsTheSuppliersAddress,
    postWhatIsTheSuppliersAddress("Test Address Line 1", "Test Address Line 2", "Test Address Line 3"),
    getAddVATRegistration,
    postAddVATRegistration("true"),
    getVATRegistrationNumber,
    postVATRegistrationNumber("AB1234567890"),
    getTotalPurchaseAmount,
    postTotalPurchaseAmount("1000"),
    getTotalVatPaid,
    postTotalVatPaid("300"),
    getTotalVatClaim,
    postTotalVatClaim("100")
  )

  val AddPurchaseJourneyForGermany: List[HttpRequestBuilder] = List(
    getBeforeYouStart,
    postBeforeYouStart,
    getPurchaseType,
    postPurchaseType("fuel"),
    getInvoiceItemDescription,
    postInvoiceItemDescription("Test item description"),
    getWhatTypeOfInvoiceDoYouHave,
    postWhatTypeOfInvoiceDoYouHave("standard invoice"),
    getWhatIsTheInvoiceNumber,
    postWhatIsTheInvoiceNumber("ABC1234567890"),
    getWhatIsTheInvoiceDate,
    postWhatIsTheInvoiceDate("08", "12", "2025"),
    getWhatIsTheSuppliersName,
    postWhatIsTheSuppliersName("Testing"),
    getWhatIsTheSuppliersAddress,
    postWhatIsTheSuppliersAddress("Test Address Line 1", "Test Address Line 2", "Test Address Line 3"),
    getSuppliersTaxNumbers,
    postSuppliersTaxNumbers("taxIdentifierNumber"),
    getWhatIsTheSuppliersTaxID,
    postWhatIsTheSuppliersTaxID("12/345/67890")
  )

}
