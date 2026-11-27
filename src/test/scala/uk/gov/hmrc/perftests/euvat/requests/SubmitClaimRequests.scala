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

object SubmitClaimRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getDeclaration: HttpRequestBuilder =
    http("[get ] Make declaration and submit your claim page")
      .get(euvatFilingFrontendUrl + "/submit-claim/declaration")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postDeclaration: HttpRequestBuilder =
    http("[post] Make declaration and submit your claim page")
      .post(euvatFilingFrontendUrl + "/submit-claim/declaration")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val SubmitClaimJourney: List[HttpRequestBuilder] = List(
    getDeclaration,
    postDeclaration
  )

}
