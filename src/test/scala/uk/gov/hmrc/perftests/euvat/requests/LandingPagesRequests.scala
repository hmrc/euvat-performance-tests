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

object LandingPagesRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getManageFrontend: HttpRequestBuilder =
    http("[get ] Manage Frontend")
      .get(euvatManageFrontendUrl)
      .check(status.is(303))

  val getSignIntoCISPage: HttpRequestBuilder =
    http("[get ] EUVAT Landing page")
      .get(euvatManageFrontendUrl + "/sign-into-cis")
      .check(status.is(200))


}
