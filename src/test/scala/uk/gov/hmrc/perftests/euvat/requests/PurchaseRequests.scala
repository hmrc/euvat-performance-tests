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

  val getChangePurchaseType: HttpRequestBuilder =
    http("[get ] Change Purchase type page")
      .get(euvatFilingFrontendUrl + "/change-purchase-type")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangePurchaseType(option: String): HttpRequestBuilder =
    http("[post] Change Purchase type page")
      .post(euvatFilingFrontendUrl + "/change-purchase-type")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getFoodDrinkOrRestaurantCostType: HttpRequestBuilder =
    http("[get ] What is the type of food, drink or restaurant cost? page")
      .get(euvatFilingFrontendUrl + "/food-drink-restaurant-cost")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postFoodDrinkOrRestaurantCostType(option: String): HttpRequestBuilder =
    http("[post] What is the type of food, drink or restaurant cost? page")
      .post(euvatFilingFrontendUrl + "/food-drink-restaurant-cost")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhoFoodDrinkFor: HttpRequestBuilder =
    http("[get ] Who is the food and drink for? page")
      .get(euvatFilingFrontendUrl + "/who-food-drink-for")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhoFoodDrinkFor(option: String): HttpRequestBuilder =
    http("[post] Who is the food and drink for? page")
      .post(euvatFilingFrontendUrl + "/who-food-drink-for")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getLuxuryEntertainmentOrHospitalityCost: HttpRequestBuilder =
    http("[get ] What is the type of luxury entertainment or hospitality cost? page")
      .get(euvatFilingFrontendUrl + "/luxury-entertainment-hospitality-cost")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLuxuryEntertainmentOrHospitalityCost(option: String): HttpRequestBuilder =
    http("[post] What is the type of luxury entertainment or hospitality cost? page")
      .post(euvatFilingFrontendUrl + "/luxury-entertainment-hospitality-cost")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeLuxuryEntertainmentOrHospitalityCost: HttpRequestBuilder =
    http("[get ] Change What is the type of luxury entertainment or hospitality cost? page")
      .get(euvatFilingFrontendUrl + "/change-luxury-entertainment-hospitality-cost")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeLuxuryEntertainmentOrHospitalityCost(option: String): HttpRequestBuilder =
    http("[post] Change What is the type of luxury entertainment or hospitality cost? page")
      .post(euvatFilingFrontendUrl + "/change-luxury-entertainment-hospitality-cost")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getPurchaseTypeOther: HttpRequestBuilder =
    http("[get ] Purchase type other page")
      .get(euvatFilingFrontendUrl + "/purchase-type-other")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPurchaseTypeOther(option: String): HttpRequestBuilder =
    http("[post] Purchase type other page")
      .post(euvatFilingFrontendUrl + "/purchase-type-other")
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

  val getCheckPurchaseDetails: HttpRequestBuilder =
    http("[get] Check purchase details page")
      .get(euvatFilingFrontendUrl + "/check-purchase-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckPurchaseDetails: HttpRequestBuilder =
    http("[post] Check purchase details page")
      .post(euvatFilingFrontendUrl + "/check-purchase-details")
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

  val getChangeWhatTypeOfInvoiceDoYouHave: HttpRequestBuilder =
    http("[get ] Change What type of invoice do you have page")
      .get(euvatFilingFrontendUrl + "/change-invoice-type")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhatTypeOfInvoiceDoYouHave(option: String): HttpRequestBuilder =
    http("[post] Change What type of invoice do you have page")
      .post(euvatFilingFrontendUrl + "/change-invoice-type")
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

  val getChangeWhatIsTheInvoiceNumber: HttpRequestBuilder =
    http("[get ] Change What is the invoice number page")
      .get(euvatFilingFrontendUrl + "/change-invoice-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhatIsTheInvoiceNumber(invoiceNumber: String): HttpRequestBuilder =
    http("[post] Change What is the invoice number page")
      .post(euvatFilingFrontendUrl + "/change-invoice-number")
      .formParam("value", invoiceNumber)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheInvoiceDate: HttpRequestBuilder =
    http("[get ] What is the invoice date page")
      .get(euvatFilingFrontendUrl + "/what-is-the-invoice-date")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheInvoiceDate(invoiceDay: String, invoiceMonth: String, invoiceYear: String): HttpRequestBuilder =
    http("[post] What is the invoice date page")
      .post(euvatFilingFrontendUrl + "/what-is-the-invoice-date")
      .formParam("value.day", invoiceDay)
      .formParam("value.month", invoiceMonth)
      .formParam("value.year", invoiceYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeWhatIsTheInvoiceDate: HttpRequestBuilder =
    http("[get ] Change What is the invoice date page")
      .get(euvatFilingFrontendUrl + "/change-what-is-the-invoice-date")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhatIsTheInvoiceDate(
    invoiceDay: String,
    invoiceMonth: String,
    invoiceYear: String
  ): HttpRequestBuilder =
    http("[post] Change What is the invoice date page")
      .post(euvatFilingFrontendUrl + "/change-what-is-the-invoice-date")
      .formParam("value.day", invoiceDay)
      .formParam("value.month", invoiceMonth)
      .formParam("value.year", invoiceYear)
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

  val getChangeWhatIsTheSuppliersName: HttpRequestBuilder =
    http("[get ] Change What is the supplier's name page")
      .get(euvatFilingFrontendUrl + "/change-what-supplier-name")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhatIsTheSuppliersName(supplierName: String): HttpRequestBuilder =
    http("[post] Change What is the supplier's name? page")
      .post(euvatFilingFrontendUrl + "/change-what-supplier-name")
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

  val getChangeWhatIsTheSuppliersAddress: HttpRequestBuilder =
    http("[get ] Change What is the supplier's address page")
      .get(euvatFilingFrontendUrl + "/change-what-supplier-address")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhatIsTheSuppliersAddress(
    addressLine1: String,
    addressLine2: String,
    addressLine3: String
  ): HttpRequestBuilder =
    http("[post] Change What is the supplier's address page")
      .post(euvatFilingFrontendUrl + "/change-what-supplier-address")
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

  val getChangeWhatIsTheSuppliersTaxID: HttpRequestBuilder =
    http("[get ] Change What is the supplier's tax identifier number page")
      .get(euvatFilingFrontendUrl + "/change-supplier-tax-identifier-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhatIsTheSuppliersTaxID(option: String): HttpRequestBuilder =
    http("[post] Change What is the supplier's tax identifier number page")
      .post(euvatFilingFrontendUrl + "/change-supplier-tax-identifier-number")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckSupplierTaxID: HttpRequestBuilder =
    http("[get ] Are you sure the supplier’s tax identifier number is correct?")
      .get(euvatFilingFrontendUrl + "/check-supplier-tax-identifier-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckSupplierTaxID: HttpRequestBuilder =
    http("[post] Are you sure the supplier’s tax identifier number is correct?")
      .post(euvatFilingFrontendUrl + "/check-supplier-tax-identifier-number")
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

  val getChangeSuppliersTaxNumbers: HttpRequestBuilder =
    http("[get ] Change Select the supplier tax numbers shown on the invoice page")
      .get(euvatFilingFrontendUrl + "/change-supplier-tax-numbers")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeSuppliersTaxNumbers(suppliersTaxNumber: String): HttpRequestBuilder =
    http("[post] Change Select the supplier tax numbers shown on the invoice page")
      .post(euvatFilingFrontendUrl + "/change-supplier-tax-numbers")
      .formParam("value", suppliersTaxNumber)
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

  val getChangeAddVATRegistration: HttpRequestBuilder =
    http("[get ] Change Does the simplified invoice contain the supplier’s VAT registration number? page")
      .get(euvatFilingFrontendUrl + "/change-simplified-invoice-supplier-vat-registration-check")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeAddVATRegistration(option: String): HttpRequestBuilder =
    http("[post] Change Does the simplified invoice contain the supplier’s VAT registration number? page")
      .post(euvatFilingFrontendUrl + "/change-simplified-invoice-supplier-vat-registration-check")
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

  val getChangeVATRegistrationNumber: HttpRequestBuilder =
    http("[get ] Change What is the supplier’s VAT registration number? page")
      .get(euvatFilingFrontendUrl + "/change-what-supplier-vat-registration-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeVATRegistrationNumber(option: String): HttpRequestBuilder =
    http("[post] Change What is the supplier’s VAT registration number? page")
      .post(euvatFilingFrontendUrl + "/change-what-supplier-vat-registration-number")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckSupplierVRN: HttpRequestBuilder =
    http("[get ] Are you sure the supplier’s VAT registration number is correct?")
      .get(euvatFilingFrontendUrl + "/check-supplier-vat-registration-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckSupplierVRN: HttpRequestBuilder =
    http("[post] Are you sure the supplier’s VAT registration number is correct?")
      .post(euvatFilingFrontendUrl + "/check-supplier-vat-registration-number")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhichCurrencyDoYouWantToUseForThisClaim: HttpRequestBuilder =
    http("[get ] Which currency do you want to use for this claim? page")
      .get(euvatFilingFrontendUrl + "/which-currency")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhichCurrencyDoYouWantToUseForThisClaim(option: String): HttpRequestBuilder =
    http("[post] Which currency do you want to use for this claim? page")
      .post(euvatFilingFrontendUrl + "/which-currency")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeCurrency: HttpRequestBuilder =
    http("[get ] Change Which currency do you want to use for this claim? page")
      .get(euvatFilingFrontendUrl + "/change-which-currency")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeCurrency(option: String): HttpRequestBuilder =
    http("[post] Change Which currency do you want to use for this claim? page")
      .post(euvatFilingFrontendUrl + "/change-which-currency")
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

  val getChangeTotalPurchaseAmount: HttpRequestBuilder =
    http("[get ] Change Total purchase amount before VAT page")
      .get(euvatFilingFrontendUrl + "/change-total-purchase-amount-before-vat")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeTotalPurchaseAmount(option: String): HttpRequestBuilder =
    http("[post] Change Total purchase amount before VAT page")
      .post(euvatFilingFrontendUrl + "/change-total-purchase-amount-before-vat")
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

  val getChangeTotalVatPaid: HttpRequestBuilder =
    http("[get ] Change Total VAT paid page")
      .get(euvatFilingFrontendUrl + "/change-total-vat-paid")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeTotalVatPaid(option: String): HttpRequestBuilder =
    http("[post] Change Total VAT paid page")
      .post(euvatFilingFrontendUrl + "/change-total-vat-paid")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckVatAmount: HttpRequestBuilder =
    http("[get ] Check VAT amount page")
      .get(euvatFilingFrontendUrl + "/check-vat-amount")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckVatAmount: HttpRequestBuilder =
    http("[post] Check VAT amount page")
      .post(euvatFilingFrontendUrl + "/check-vat-amount")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeCheckVatAmount: HttpRequestBuilder =
    http("[get ] Change Check VAT amount page")
      .get(euvatFilingFrontendUrl + "/change-check-vat-amount")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeCheckVatAmount: HttpRequestBuilder =
    http("[post] Change Check VAT amount page")
      .post(euvatFilingFrontendUrl + "/change-check-vat-amount")
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

  val getChangeTotalVatClaim: HttpRequestBuilder =
    http("[get ] Change Total VAT claim page")
      .get(euvatFilingFrontendUrl + "/change-total-vat-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeTotalVatClaim(option: String): HttpRequestBuilder =
    http("[post] Change Total VAT claim page")
      .post(euvatFilingFrontendUrl + "/change-total-vat-claim")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckVatClaim: HttpRequestBuilder =
    http("[get ] Check VAT claim page")
      .get(euvatFilingFrontendUrl + "/check-vat-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckVatClaim: HttpRequestBuilder =
    http("[post] Check VAT claim page")
      .post(euvatFilingFrontendUrl + "/check-vat-claim")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeCheckVatClaim: HttpRequestBuilder =
    http("[get ] Change Check VAT claim page")
      .get(euvatFilingFrontendUrl + "/change-check-vat-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeCheckVatClaim: HttpRequestBuilder =
    http("[post] Change Check VAT claim page")
      .post(euvatFilingFrontendUrl + "/change-check-vat-claim")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckYourPurchaseDetails: HttpRequestBuilder =
    http("[get ] Check your purchase details page")
      .get(euvatFilingFrontendUrl + "/check-your-purchase-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckYourPurchaseDetails: HttpRequestBuilder =
    http("[post] Check your purchase details page")
      .post(euvatFilingFrontendUrl + "/check-your-purchase-details")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val AddPurchaseJourney: List[HttpRequestBuilder] = List(
    getBeforeYouStart,
    postBeforeYouStart,
    getPurchaseType,
    postPurchaseType("foodAndDrink"),
    getFoodDrinkOrRestaurantCostType,
    postFoodDrinkOrRestaurantCostType("7.1"),
    getWhoFoodDrinkFor,
    postWhoFoodDrinkFor("7.1.1"),
    getWhatTypeOfInvoiceDoYouHave,
    postWhatTypeOfInvoiceDoYouHave("standard invoice"),
    getWhatIsTheInvoiceNumber,
    postWhatIsTheInvoiceNumber("DUP"),
    getWhatIsTheInvoiceDate,
    postWhatIsTheInvoiceDate("08", "12", "2025"),
    getWhatIsTheSuppliersName,
    postWhatIsTheSuppliersName("Test supplier name"),
    getWhatIsTheSuppliersAddress,
    postWhatIsTheSuppliersAddress("Test Address Line 1", "Test Address Line 2", "Test Address Line 3"),
    getVATRegistrationNumber,
    postVATRegistrationNumber("EE0000000111"),
    getCheckSupplierVRN,
    postCheckSupplierVRN,
    getWhichCurrencyDoYouWantToUseForThisClaim,
    postWhichCurrencyDoYouWantToUseForThisClaim("euro"),
    getTotalPurchaseAmount,
    postTotalPurchaseAmount("1000.01"),
    getTotalVatPaid,
    postTotalVatPaid("200.01"),
    getCheckVatAmount,
    postCheckVatAmount,
    getTotalVatClaim,
    postTotalVatClaim("100.01"),
    getCheckVatClaim,
    postCheckVatClaim,
//    Change purchase details
    getCheckYourPurchaseDetails,
    getChangePurchaseType,
    postChangePurchaseType("luxuries"),
    getChangeLuxuryEntertainmentOrHospitalityCost,
    postChangeLuxuryEntertainmentOrHospitalityCost("9.3"),
    getCheckYourPurchaseDetails,
    getChangeWhatTypeOfInvoiceDoYouHave,
    postChangeWhatTypeOfInvoiceDoYouHave("simplified invoice"),
    getChangeWhatIsTheInvoiceNumber,
    postChangeWhatIsTheInvoiceNumber("XR123456789"),
    getCheckYourPurchaseDetails,
    getChangeWhatIsTheInvoiceDate,
    postChangeWhatIsTheInvoiceDate("01", "01", "2026"),
    getCheckYourPurchaseDetails,
    getChangeWhatIsTheSuppliersName,
    postChangeWhatIsTheSuppliersName("Change supplier name"),
    getCheckYourPurchaseDetails,
    getChangeWhatIsTheSuppliersAddress,
    postChangeWhatIsTheSuppliersAddress("Change Address Line 1", "Change Address Line 2", "Change Address Line 3"),
    getCheckYourPurchaseDetails,
    getChangeAddVATRegistration,
    postChangeAddVATRegistration("true"),
    getChangeVATRegistrationNumber,
    postChangeVATRegistrationNumber("AA987654321"),
    getCheckYourPurchaseDetails,
    getChangeCurrency,
    postChangeCurrency("estonianKroon"),
    getTotalPurchaseAmount,
    postTotalPurchaseAmount("1000.01"),
    getCheckYourPurchaseDetails,
    getChangeTotalPurchaseAmount,
    postChangeTotalPurchaseAmount("300.99"),
    getChangeTotalVatPaid,
    postChangeTotalVatPaid("5000.99"),
    getChangeCheckVatAmount,
    postChangeCheckVatAmount,
    getChangeTotalVatClaim,
    postChangeTotalVatClaim("6000.99"),
    getChangeCheckVatClaim,
    postChangeCheckVatClaim,
    getCheckYourPurchaseDetails,
    postCheckYourPurchaseDetails
  )

  val AddPurchaseJourneyForGermany: List[HttpRequestBuilder] = List(
    getBeforeYouStart,
    postBeforeYouStart,
    getPurchaseType,
    postPurchaseType("other"),
    getPurchaseTypeOther,
    postPurchaseTypeOther("10.99"),
    getInvoiceItemDescription,
    postInvoiceItemDescription(""),
    getCheckPurchaseDetails,
    postCheckPurchaseDetails,
    getWhatTypeOfInvoiceDoYouHave,
    postWhatTypeOfInvoiceDoYouHave("simplified invoice"),
    getWhatIsTheInvoiceNumber,
    postWhatIsTheInvoiceNumber("INV-1"),
    getWhatIsTheInvoiceDate,
    postWhatIsTheInvoiceDate("08", "12", "2025"),
    getWhatIsTheSuppliersName,
    postWhatIsTheSuppliersName("Test supplier name"),
    getWhatIsTheSuppliersAddress,
    postWhatIsTheSuppliersAddress("Test Address Line 1", "Test Address Line 2", "Test Address Line 3"),
    getSuppliersTaxNumbers,
    postSuppliersTaxNumbers("taxIdentifierNumber"),
    getWhatIsTheSuppliersTaxID,
    postWhatIsTheSuppliersTaxID("TID-1"),
    getCheckSupplierTaxID,
    postCheckSupplierTaxID,
    getTotalPurchaseAmount,
    postTotalPurchaseAmount("1000.99"),
    getTotalVatPaid,
    postTotalVatPaid("200.99"),
    getTotalVatClaim,
    postTotalVatClaim("100.99"),
//    Change purchase details
    getCheckYourPurchaseDetails,
    getChangeWhatIsTheSuppliersTaxID,
    postChangeWhatIsTheSuppliersTaxID("TID-1"),
    getCheckYourPurchaseDetails,
    getChangeSuppliersTaxNumbers,
    postChangeSuppliersTaxNumbers("vatRegistrationNumber"),
    getVATRegistrationNumber,
    postVATRegistrationNumber("1234567890"),
    getCheckYourPurchaseDetails,
    postCheckYourPurchaseDetails
  )

}
