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
import uk.gov.hmrc.perftests.euvat.requests.PurchaseRequests.{getAddPurchaseImport, postAddPurchaseImport}

object ImportRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getImportType: HttpRequestBuilder =
    http("[get ] Import type page")
      .get(euvatFilingFrontendUrl + "/import/import-type")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportType(option: String): HttpRequestBuilder =
    http("[post] Import type page")
      .post(euvatFilingFrontendUrl + "/import/import-type")
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

  val getImportTypeOther: HttpRequestBuilder =
    http("[get ] Import type other page")
      .get(euvatFilingFrontendUrl + "/import/import-type-other")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportTypeOther(option: String): HttpRequestBuilder =
    http("[post] Import type other page")
      .post(euvatFilingFrontendUrl + "/import/import-type-other")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAddSADRefNumber: HttpRequestBuilder =
    http("[get ] SAD Reference number page")
      .get(euvatFilingFrontendUrl + "/import/single-administrative-document-reference-number-available")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def getAddSADRefNumber(option: String): HttpRequestBuilder =
    http("[post] SAD Reference number page")
      .post(euvatFilingFrontendUrl + "/import/single-administrative-document-reference-number-available")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val AddImportJourney: List[HttpRequestBuilder] = List(
    getAddPurchaseImport,
    postAddPurchaseImport("import"),
    getImportType,
    postImportType("foodAndDrink"),
    getImportFoodType,
    postImportFoodType("7.1"),
    getAddSADRefNumber,
    getAddSADRefNumber("true")
  )

  val AddImportJourneyGermany: List[HttpRequestBuilder] = List(
    getAddPurchaseImport,
    postAddPurchaseImport("import"),
    getImportType,
    postImportType("other"),
    getImportTypeOther,
    postImportTypeOther("10.99"),
    getAddSADRefNumber,
    getAddSADRefNumber("false")
  )

}
