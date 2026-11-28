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
import uk.gov.hmrc.perftests.euvat.requests.ClaimDetailsRequests.getMakeANewEUVATClaimPage

object SupportingDocumentsRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getBeforeYouStartSupportingDocuments: HttpRequestBuilder =
    http("[get ] Before you start (Supporting documents) page")
      .get(euvatFilingFrontendUrl + "/supporting-documents/before-you-start")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postBeforeYouStartSupportingDocuments: HttpRequestBuilder =
    http("[post] Before you start (Supporting documents) page")
      .post(euvatFilingFrontendUrl + "/supporting-documents/before-you-start")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getAnySupportingDocuments: HttpRequestBuilder =
    http("[get ] Do you have any supporting documents to upload? page")
      .get(euvatFilingFrontendUrl + "/supporting-documents/any-documents")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAnySupportingDocuments(option: String): HttpRequestBuilder =
    http("[post] Do you have any supporting documents to upload? page")
      .post(euvatFilingFrontendUrl + "/supporting-documents/any-documents")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getUploadFile: HttpRequestBuilder =
    http("[get ] Upload file page")
      .get(euvatFilingFrontendUrl + "/supporting-documents/upload-file")
//      .check(regex("""name="x-amz-meta-callback-url"\s+value="([^"]+)"""").saveAs("xAmzMetaCallbackURL"))
//      .check(regex("""name="x-amz-date"\s+value="([^"]+)"""").saveAs("xAmzDate"))
//      .check(regex("""name="x-amz-credential"\s+value="([^"]+)"""").saveAs("xAmzCredential"))
//      .check(regex("""name="x-amz-meta-original-filename"\s+value="([^"]+)"""").saveAs("xAmzMetaOriginalFilename"))
//      .check(regex("""name="x-amz-algorithm"\s+value="([^"]+)"""").saveAs("xAmzAlgorithm"))
//      .check(regex("""name="key"\s+value="([^"]+)"""").saveAs("key"))
//      .check(regex("""name="acl"\s+value="([^"]+)"""").saveAs("acl"))
//      .check(regex("""name="x-amz-signature"\s+value="([^"]+)"""").saveAs("xAmzSignature"))
//      .check(regex("""name="x-amz-meta-session-id"\s+value="([^"]+)"""").saveAs("xAmzMetaSessionId"))
//      .check(regex("""name="x-amz-meta-request-id"\s+value="([^"]+)"""").saveAs("xAmzMetaRequestId"))
//      .check(regex("""name="x-amz-meta-consuming-service"\s+value="([^"]+)"""").saveAs("xAmzMetaConsumingService"))
//      .check(regex("""name="x-amz-meta-upscan-initiate-received"\s+value="([^"]+)"""").saveAs("xAmzMetaUpscanInitiateReceived"))
//      .check(regex("""name="x-amz-meta-upscan-initiate-response"\s+value="([^"]+)"""").saveAs("xAmzMetaUpscanInitiateResponse"))
//      .check(regex("""name="success_action_redirect"\s+value="([^"]+)"""").saveAs("successActionRedirect"))
//      .check(regex("""name="error_action_redirect"\s+value="([^"]+)"""").saveAs("errorActionRedirect"))
//      .check(regex("""name="policy"\s+value="([^"]+)"""").saveAs("policy"))
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(200))

  def postUploadFile(fileName: String): HttpRequestBuilder =
    http("[post] Upload file page")
      .post(euvatFilingFrontendUrl + "/supporting-documents/upload-file")
      .asMultipartForm
      .bodyPart(StringBodyPart("x-amz-meta-callback-url", "#{xAmzMetaCallbackURL}"))
      .bodyPart(StringBodyPart("x-amz-date", "#{xAmzDate}"))
      .bodyPart(StringBodyPart("x-amz-credential", "#{xAmzCredential}"))
      .bodyPart(StringBodyPart("x-amz-meta-original-filename", fileName))
      .bodyPart(StringBodyPart("x-amz-algorithm", "#{xAmzAlgorithm}"))
      .bodyPart(StringBodyPart("key", "#{key}"))
      .bodyPart(StringBodyPart("acl", "#{acl}"))
      .bodyPart(StringBodyPart("x-amz-signature", "#{xAmzSignature}"))
      .bodyPart(StringBodyPart("x-amz-meta-session-id", "#{xAmzMetaSessionId}"))
      .bodyPart(StringBodyPart("x-amz-meta-request-id", "#{xAmzMetaRequestId}"))
      .bodyPart(StringBodyPart("x-amz-meta-consuming-service", "#{xAmzMetaConsumingService}"))
      .bodyPart(StringBodyPart("x-amz-meta-upscan-initiate-received", "#{xAmzMetaUpscanInitiateReceived}"))
      .bodyPart(StringBodyPart("x-amz-meta-upscan-initiate-response", "#{xAmzMetaUpscanInitiateResponse}"))
      .bodyPart(StringBodyPart("success_action_redirect", "#{successActionRedirect}"))
      .bodyPart(StringBodyPart("error_action_redirect", "#{errorActionRedirect}"))
      .bodyPart(StringBodyPart("policy", "#{policy}"))
      .bodyPart(RawFileBodyPart("file", fileName))
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))
      .check(header("Location").saveAs("UpscanUploadResponse"))

  val getUpscanUploadResponse: HttpRequestBuilder =
    http(s"[get ] Upscan upload redirect")
      .get("#{UpscanUploadResponse}")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.in(303))

  val getUploadedFiles: HttpRequestBuilder =
    http("[get ] Uploaded files page")
      .get(euvatFilingFrontendUrl + "/supporting-documents/uploaded-files")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(200))

  val postUploadedFiles: HttpRequestBuilder =
    http("[post] Uploaded files page")
      .post(euvatFilingFrontendUrl + "/supporting-documents/uploaded-files")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val AddSupportingDocumentsJourney: List[HttpRequestBuilder] = List(
    getBeforeYouStartSupportingDocuments,
    postBeforeYouStartSupportingDocuments,
    getAnySupportingDocuments,
    postAnySupportingDocuments("true"),
    getUploadFile,
//    postUploadFile("data/Test1MbPDF.pdf"),
//    getUpscanUploadResponse
    getUploadedFiles,
    postUploadedFiles,
    getMakeANewEUVATClaimPage
  )

  val NoSupportingDocumentsJourney: List[HttpRequestBuilder] = List(
    getBeforeYouStartSupportingDocuments,
    postBeforeYouStartSupportingDocuments,
    getAnySupportingDocuments,
    postAnySupportingDocuments("false"),
    getMakeANewEUVATClaimPage
  )

}
