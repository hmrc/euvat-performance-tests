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

object ManageRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getManageEUVATFrontend: HttpRequestBuilder =
    http("[get ] Manage EUVAT Frontend")
      .get(euvatMgmtFrontendUrl)
      .check(status.is(303))

  val getManageEUVATClaimPage: HttpRequestBuilder =
    http("[get ] Claim an EU VAT refund")
      .get(euvatMgmtFrontendUrl + "/claim-eu-vat-refund")
      .check(status.is(200))

  val ManageJourney: List[HttpRequestBuilder] = List(
    // getManageEUVATFrontend,
    getManageEUVATClaimPage
  )

}
