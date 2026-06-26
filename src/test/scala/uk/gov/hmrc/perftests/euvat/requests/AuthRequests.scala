/*
 * Copyright 2025 HM Revenue & Customs
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

object AuthRequests extends ServicesConfiguration with EUVATPerformanceTestBase with RequestUtils {

  val getAuthPage: HttpRequestBuilder = http("[get ] Auth page")
    .get(baseUrlAuthLoginStub + "/auth-login-stub/gg-sign-in")
    .disableFollowRedirect
    .check(status.is(200))
    .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAuthPage(affinityGroup: String, taxOfficeReference: String): HttpRequestBuilder = {
    val expectedRedirectUrl = euvatMgmtFrontendUrl

    val request = http("[post] Auth page")
      .post(baseUrlAuthLoginStub + "/auth-login-stub/gg-sign-in")
      .disableFollowRedirect
      .formParam("redirectionUrl", euvatMgmtFrontendUrl)
      .formParam("credentialStrength", "strong")
      .formParam("confidenceLevel", "50")
      .formParam("affinityGroup", affinityGroup)
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("authorityId", _ => generateCredId())
      .check(status.is(303))
      .check(header("Location").is(expectedRedirectUrl))

    affinityGroup match {
      case "Organisation" =>
        request
          .formParam("enrolment[0].name", "HMRC-EU-REF-ORG")
          .formParam("enrolment[0].taxIdentifier[0].name", "VATRegNo")
          .formParam("enrolment[0].taxIdentifier[0].value", taxOfficeReference)
          .formParam("enrolment[0].state", "Activated")

      case "Agent" =>
        request
          .formParam("enrolment[0].name", "HMCE-VAT-AGNT")
          .formParam("enrolment[0].taxIdentifier[0].name", "AgentRefNo")
          .formParam("enrolment[0].taxIdentifier[0].value", taxOfficeReference)
          .formParam("enrolment[0].state", "Activated")
    }
  }

  val getSession: HttpRequestBuilder = http("[get ] Auth session")
    .get(baseUrlAuthLoginStub + "/auth-login-stub/session")
    .check(status.is(200))
    .check(css("[data-session-id=\"authToken\"] > code").saveAs("accessToken"))
    .check(css("[data-session-id=\"sessionId\"] > code").saveAs("sessionId"))

  val loginJourney: List[HttpRequestBuilder] = List(
    getAuthPage,
    postAuthPage("Organisation", "999900104"),
    getSession
  )
}
