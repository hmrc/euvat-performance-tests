package uk.gov.hmrc.perftests.euvat.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.euvat.requests.ImportRequests.getWhatIsTheSingleAdminDocumentReferenceNumber
import uk.gov.hmrc.perftests.euvat.requests.PurchaseRequests.euvatFilingFrontendUrl

object ImportRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getImportFoodType: HttpRequestBuilder =
    http("[get ] What is the type of food, drink or restaurant cost? page")
      .get(euvatFilingFrontendUrl + "/import-food-drink-restaurant-cost")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postImportFoodType(option: String): HttpRequestBuilder =
    http("[post] What is the type of food, drink or restaurant cost? page")
      .post(euvatFilingFrontendUrl + "/import-food-drink-restaurant-cost")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheSingleAdminDocumentReferenceNumber: HttpRequestBuilder =
    http("[get ] What is your Single Administrative Document (SAD) reference number page")
      .get(euvatFilingFrontendUrl + "import/single-administrative-document-reference-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheSingleAdminDocumentReferenceNumber(SADRefNumber: String): HttpRequestBuilder =
    http("[post] What is your Single Administrative Document (SAD) reference number page")
      .post(euvatFilingFrontendUrl + "import/single-administrative-document-reference-number")
      .formParam("value", SADRefNumber)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val AddImportJourney: List[HttpRequestBuilder] = List(
    getImportFoodType,
    postImportFoodType("7.1"),
    getWhatIsTheSingleAdminDocumentReferenceNumber,
    postWhatIsTheSingleAdminDocumentReferenceNumber("SAD12345")
  )

  val AddImportJourneyGermany: List[HttpRequestBuilder] = List(
    getImportFoodType,
    postImportFoodType("7.1"),
    getWhatIsTheSingleAdminDocumentReferenceNumber,
    postWhatIsTheSingleAdminDocumentReferenceNumber("SAD12345")
  )

}