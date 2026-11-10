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
import uk.gov.hmrc.perftests.euvat.requests.PurchaseRequests.{getAddPurchaseImport, getYourPurchaseImportSummary, postAddPurchaseImport}

object ImportRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getImportType: HttpRequestBuilder =
    http("[get ] Import type page")
      .get(euvatFilingFrontendUrl + "/import/category")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportType(option: String): HttpRequestBuilder =
    http("[post] Import type page")
      .post(euvatFilingFrontendUrl + "/import/category")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getImportFoodType: HttpRequestBuilder =
    http("[get ] What is the type of food, drink or restaurant cost? page")
      .get(euvatFilingFrontendUrl + "/import/food-drink-restaurant-cost")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportFoodType(option: String): HttpRequestBuilder =
    http("[post] What is the type of food, drink or restaurant cost? page")
      .post(euvatFilingFrontendUrl + "/import/food-drink-restaurant-cost")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getImportSubCategoryFood: HttpRequestBuilder =
    http("[get ] Who is the food and drink for? page")
      .get(euvatFilingFrontendUrl + "/import/cost-for-publicity-purposes")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportSubCategoryFood(option: String): HttpRequestBuilder =
    http("[post] Who is the food and drink for? page")
      .post(euvatFilingFrontendUrl + "/import/cost-for-publicity-purposes")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getImportTypeOther: HttpRequestBuilder =
    http("[get ] Import type other page")
      .get(euvatFilingFrontendUrl + "/import/other")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportTypeOther(option: String): HttpRequestBuilder =
    http("[post] Import type other page")
      .post(euvatFilingFrontendUrl + "/import/other")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getListImportDocumentItems: HttpRequestBuilder =
    http("[get ] List each item from your import document page")
      .get(euvatFilingFrontendUrl + "/import/list-items")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postListImportDocumentItems(option: String): HttpRequestBuilder =
    http("[post] List each item from your import document page")
      .post(euvatFilingFrontendUrl + "/import/list-items")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAddSADRefNumber: HttpRequestBuilder =
    http("[get ] SAD Reference number page")
      .get(euvatFilingFrontendUrl + "/import/sad-reference-check")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddSADRefNumber(option: String): HttpRequestBuilder =
    http("[post] SAD Reference number page")
      .post(euvatFilingFrontendUrl + "/import/sad-reference-check")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeAddSADRefNumber: HttpRequestBuilder =
    http("[get ] Change SAD Reference number page")
      .get(euvatFilingFrontendUrl + "/import/change-sad-reference-check")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeAddSADRefNumber(option: String): HttpRequestBuilder =
    http("[post] Change SAD Reference number page")
      .post(euvatFilingFrontendUrl + "/import/change-sad-reference-check")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheSADReferenceNumber: HttpRequestBuilder =
    http("[get ] What is your Single Administrative Document (SAD) reference number page")
      .get(euvatFilingFrontendUrl + "/import/sad-reference-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheSADReferenceNumber(SADRefNumber: String): HttpRequestBuilder =
    http("[post] What is your Single Administrative Document (SAD) reference number page")
      .post(euvatFilingFrontendUrl + "/import/sad-reference-number")
      .formParam("value", SADRefNumber)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeWhatIsTheSADReferenceNumber: HttpRequestBuilder =
    http("[get ] Change What is your Single Administrative Document (SAD) reference number page")
      .get(euvatFilingFrontendUrl + "/import/change-sad-reference-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhatIsTheSADReferenceNumber(SADRefNumber: String): HttpRequestBuilder =
    http("[post] Change What is your Single Administrative Document (SAD) reference number page")
      .post(euvatFilingFrontendUrl + "/import/change-sad-reference-number")
      .formParam("value", SADRefNumber)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getImportDocumentDetails: HttpRequestBuilder =
    http("[get ] Import document details page")
      .get(euvatFilingFrontendUrl + "/import/import-document-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportDocumentDetails(option: String): HttpRequestBuilder =
    http("[post] Import document details page")
      .post(euvatFilingFrontendUrl + "/import/import-document-details")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeImportDocumentDetails: HttpRequestBuilder =
    http("[get ] Import document details page")
      .get(euvatFilingFrontendUrl + "/import/change-import-document-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeImportDocumentDetails(option: String): HttpRequestBuilder =
    http("[post] Import document details page")
      .post(euvatFilingFrontendUrl + "/import/change-import-document-details")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhenIsTheImportDate: HttpRequestBuilder =
    http("[get ] When is the import date page")
      .get(euvatFilingFrontendUrl + "/import/import-date")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhenIsTheImportDate(importDay: String, importMonth: String, importYear: String): HttpRequestBuilder =
    http("[post] When is the import date page")
      .post(euvatFilingFrontendUrl + "/import/import-date")
      .formParam("value.day", importDay)
      .formParam("value.month", importMonth)
      .formParam("value.year", importYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeWhenIsTheImportDate: HttpRequestBuilder =
    http("[get ] Change When is the import date page")
      .get(euvatFilingFrontendUrl + "/import/change-import-date")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhenIsTheImportDate(importDay: String, importMonth: String, importYear: String): HttpRequestBuilder =
    http("[post] Change When is the import date page")
      .post(euvatFilingFrontendUrl + "/import/change-import-date")
      .formParam("value.day", importDay)
      .formParam("value.month", importMonth)
      .formParam("value.year", importYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getSupplierName: HttpRequestBuilder =
    http("[get ] What is the supplier’s name? page")
      .get(euvatFilingFrontendUrl + "/import/supplier-name")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postSubmitSupplierName(SupplierName: String): HttpRequestBuilder =
    http("[post] What is the supplier’s name? page")
      .post(euvatFilingFrontendUrl + "/import/supplier-name")
      .formParam("value", SupplierName)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeSupplierName: HttpRequestBuilder =
    http("[get ] Change What is the supplier’s name? page")
      .get(euvatFilingFrontendUrl + "/import/change-supplier-name")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeSubmitSupplierName(SupplierName: String): HttpRequestBuilder =
    http("[post] Change What is the supplier’s name? page")
      .post(euvatFilingFrontendUrl + "/import/change-supplier-name")
      .formParam("value", SupplierName)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getImportSupplierAddress: HttpRequestBuilder =
    http("[get ] What is the supplier’s address page")
      .get(euvatFilingFrontendUrl + "/import/supplier-address")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportSupplierAddress(
    addressLine1: String,
    addressLine2: String,
    addressLine3: String,
    country: String
  ): HttpRequestBuilder =
    http("[post] What is the supplier's address page")
      .post(euvatFilingFrontendUrl + "/import/supplier-address")
      .formParam("addressLine1", addressLine1)
      .formParam("addressLine2", addressLine2)
      .formParam("addressLine3", addressLine3)
      .formParam("country", country)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeImportSupplierAddress: HttpRequestBuilder =
    http("[get ] Change What is the supplier’s address page")
      .get(euvatFilingFrontendUrl + "/import/change-supplier-address")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeImportSupplierAddress(
    addressLine1: String,
    addressLine2: String,
    addressLine3: String,
    country: String
  ): HttpRequestBuilder =
    http("[post] Change What is the supplier's address page")
      .post(euvatFilingFrontendUrl + "/import/change-supplier-address")
      .formParam("addressLine1", addressLine1)
      .formParam("addressLine2", addressLine2)
      .formParam("addressLine3", addressLine3)
      .formParam("country", country)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getImportCurrency: HttpRequestBuilder =
    http("[get ] Which currency do you want to use for this import page")
      .get(euvatFilingFrontendUrl + "/import/currency")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportCurrency(option: String): HttpRequestBuilder =
    http("[post] Which currency do you want to use for this import page")
      .post(euvatFilingFrontendUrl + "/import/currency")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeImportCurrency: HttpRequestBuilder =
    http("[get ] Change Which currency do you want to use for this import page")
      .get(euvatFilingFrontendUrl + "/import/change-currency")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeImportCurrency(option: String): HttpRequestBuilder =
    http("[post] Change Which currency do you want to use for this import page")
      .post(euvatFilingFrontendUrl + "/import/change-currency")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getTotalImportAmount: HttpRequestBuilder =
    http("[get ] Total amount without VAT page")
      .get(euvatFilingFrontendUrl + "/import/amount-without-vat")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTotalImportAmount(option: String): HttpRequestBuilder =
    http("[post] Total amount without VAT page")
      .post(euvatFilingFrontendUrl + "/import/amount-without-vat")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeTotalImportAmount: HttpRequestBuilder =
    http("[get ] Change Total amount without VAT page")
      .get(euvatFilingFrontendUrl + "/import/change-amount-without-vat")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeTotalImportAmount(option: String): HttpRequestBuilder =
    http("[post] Total amount without VAT page")
      .post(euvatFilingFrontendUrl + "/import/change-amount-without-vat")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getTotalImportVATPaid: HttpRequestBuilder =
    http("[get ] Total VAT paid page")
      .get(euvatFilingFrontendUrl + "/import/vat-paid")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTotalImportVATPaid(option: String): HttpRequestBuilder =
    http("[post] Total VAT Paid page")
      .post(euvatFilingFrontendUrl + "/import/vat-paid")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeTotalImportVATPaid: HttpRequestBuilder =
    http("[get ] Change Total VAT paid page")
      .get(euvatFilingFrontendUrl + "/import/change-vat-paid")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeTotalImportVATPaid(option: String): HttpRequestBuilder =
    http("[post] Change Total VAT Paid page")
      .post(euvatFilingFrontendUrl + "/import/change-vat-paid")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getTotalImportVATClaim: HttpRequestBuilder =
    http("[get ] Total VAT claim page")
      .get(euvatFilingFrontendUrl + "/import/vat-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTotalImportVATClaim(option: String): HttpRequestBuilder =
    http("[post] Total VAT claim page")
      .post(euvatFilingFrontendUrl + "/import/vat-claim")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeTotalImportVATClaim: HttpRequestBuilder =
    http("[get ] Change Total VAT claim page")
      .get(euvatFilingFrontendUrl + "/import/change-vat-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeTotalImportVATClaim(option: String): HttpRequestBuilder =
    http("[post] Change Total VAT claim page")
      .post(euvatFilingFrontendUrl + "/import/change-vat-claim")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckImportVatClaim: HttpRequestBuilder =
    http("[get ] Are you sure the amount of VAT you’re claiming is correct page")
      .get(euvatFilingFrontendUrl + "/warning/vat-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckImportVatClaim: HttpRequestBuilder =
    http("[post] Are you sure the amount of VAT you’re claiming is correct page")
      .post(euvatFilingFrontendUrl + "/warning/vat-claim")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeCheckImportVatClaim: HttpRequestBuilder =
    http("[get ] Change Are you sure the amount of VAT you’re claiming is correct page")
      .get(euvatFilingFrontendUrl + "/warning/change-vat-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeCheckImportVatClaim: HttpRequestBuilder =
    http("[post] Are you sure the amount of VAT you’re claiming is correct page")
      .post(euvatFilingFrontendUrl + "/warning/change-vat-claim")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckImportVatAmount: HttpRequestBuilder =
    http("[get ] Are you sure the amount of VAT you paid is correct page")
      .get(euvatFilingFrontendUrl + "/warning/vat-paid")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckImportVatAmount: HttpRequestBuilder =
    http("[post] Are you sure the amount of VAT you paid is correct page")
      .post(euvatFilingFrontendUrl + "/warning/vat-paid")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeCheckImportVatAmount: HttpRequestBuilder =
    http("[get ] Change Are you sure the amount of VAT you paid is correct page")
      .get(euvatFilingFrontendUrl + "/warning/change-vat-paid")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeCheckImportVatAmount: HttpRequestBuilder =
    http("[post] Change Are you sure the amount of VAT you paid is correct page")
      .post(euvatFilingFrontendUrl + "/warning/change-vat-paid")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckYourImportDetails: HttpRequestBuilder =
    http("[get ] Check your answers page")
      .get(euvatFilingFrontendUrl + "/import/check-your-answers")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckYourImportDetails: HttpRequestBuilder =
    http("[post] Check your answers page")
      .post(euvatFilingFrontendUrl + "/import/check-your-answers")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeImportType: HttpRequestBuilder =
    http("[get ] Change Import type page")
      .get(euvatFilingFrontendUrl + "/import/change-category")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeImportType(option: String): HttpRequestBuilder =
    http("[post] Change Purchase type page")
      .post(euvatFilingFrontendUrl + "/import/change-category")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getLuxuryEntertainmentOrHospitalityCostImport: HttpRequestBuilder =
    http("[get ] What is the type of luxury entertainment or hospitality cost? page")
      .get(euvatFilingFrontendUrl + "/import/luxury-entertainment-hospitality-cost")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLuxuryEntertainmentOrHospitalityCostImport(option: String): HttpRequestBuilder =
    http("[post] What is the type of luxury entertainment or hospitality cost? page")
      .post(euvatFilingFrontendUrl + "/import/luxury-entertainment-hospitality-cost")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeYourImportAnswers: HttpRequestBuilder =
    http("[get ] Change your import details answers page")
      .get(euvatFilingFrontendUrl + "/import/change-your-answers/660/3")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeYourImportAnswers(): HttpRequestBuilder =
    http("[post ] Change your import details answers page")
      .post(euvatFilingFrontendUrl + "/import/change-your-answers/660/3")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val AddImportJourney: List[HttpRequestBuilder] = List(
    getAddPurchaseImport,
    postAddPurchaseImport("import"),
    getImportType,
    postImportType("foodAndDrink"),
    getImportFoodType,
    postImportFoodType("7.1"),
    getImportSubCategoryFood,
    postImportSubCategoryFood("7.1.2"),
    getAddSADRefNumber,
    postAddSADRefNumber("true"),
    getWhatIsTheSADReferenceNumber,
    postWhatIsTheSADReferenceNumber("98765"),
    getWhenIsTheImportDate,
    postWhenIsTheImportDate("01", "01", "2026"),
    getSupplierName,
    postSubmitSupplierName("Test Supplier"),
    getImportSupplierAddress,
    postImportSupplierAddress("Test Address 1", "", "Address Line 3", "BQ"),
    getImportCurrency,
    postImportCurrency("euro"),
    getTotalImportAmount,
    postTotalImportAmount("100.01"),
    getTotalImportVATPaid,
    postTotalImportVATPaid("200.01"),
    getCheckImportVatAmount,
    postCheckImportVatAmount,
    getTotalImportVATClaim,
    postTotalImportVATClaim("300.01"),
    getCheckImportVatClaim,
    postCheckImportVatClaim,
    getCheckYourImportDetails,
    //    Change import details
    getChangeImportType,
    postChangeImportType("luxuries"),
    getLuxuryEntertainmentOrHospitalityCostImport,
    postLuxuryEntertainmentOrHospitalityCostImport("9.3"),
    getCheckYourImportDetails,
    getChangeAddSADRefNumber,
    postChangeAddSADRefNumber("false"),
    getChangeImportDocumentDetails,
    postChangeImportDocumentDetails("Test import document information input"),
    getCheckYourImportDetails,
    getChangeWhenIsTheImportDate,
    postChangeWhenIsTheImportDate("01", "02", "2026"),
    getCheckYourImportDetails,
    getChangeSupplierName,
    postChangeSubmitSupplierName("Change Test Supplier name"),
    getCheckYourImportDetails,
    getChangeImportSupplierAddress,
    postChangeImportSupplierAddress("Change Test Address 1", "Add address line 2", "", "GS"),
    getCheckYourImportDetails,
    getImportCurrency,
    postImportCurrency("estonianKroon"),
    getTotalImportAmount,
    postTotalImportAmount("1000.01"),
    getCheckYourImportDetails,
    getChangeTotalImportAmount,
    postChangeTotalImportAmount("300.99"),
    getTotalImportVATPaid,
    postTotalImportVATPaid("5000.99"),
    getChangeCheckImportVatAmount,
    postChangeCheckImportVatAmount,
    getTotalImportVATClaim,
    postTotalImportVATClaim("6000.99"),
    getChangeCheckImportVatClaim,
    postChangeCheckImportVatClaim,
    getCheckYourImportDetails,
    postCheckYourImportDetails,
    getYourPurchaseImportSummary,
    getChangeYourImportAnswers,
    postChangeYourImportAnswers
  )

  val AddImportJourneyGermany: List[HttpRequestBuilder] = List(
    getAddPurchaseImport,
    postAddPurchaseImport("import"),
    getImportType,
    postImportType("other"),
    getImportTypeOther,
    postImportTypeOther("10.99"),
    getListImportDocumentItems,
    postListImportDocumentItems("Listed Items"),
    getAddSADRefNumber,
    postAddSADRefNumber("false"),
    getImportDocumentDetails,
    postImportDocumentDetails("Test Import Document Details"),
    getWhenIsTheImportDate,
    postWhenIsTheImportDate("01", "01", "2026"),
    getSupplierName,
    postSubmitSupplierName("Test Supplier"),
    getImportSupplierAddress,
    postImportSupplierAddress("Address Line 1", "Test Address 2", "ADDRESS Line 3", "VC"),
    getTotalImportAmount,
    postTotalImportAmount("1000.99"),
    getTotalImportVATPaid,
    postTotalImportVATPaid("200.99"),
    getTotalImportVATClaim,
    postTotalImportVATClaim("100.99"),
    getCheckYourImportDetails,
    getChangeAddSADRefNumber,
    postChangeAddSADRefNumber("true"),
    getChangeWhatIsTheSADReferenceNumber,
    postChangeWhatIsTheSADReferenceNumber("98765"),
    getCheckYourImportDetails
  )

}
