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

object ClaimDetailsRequests extends ServicesConfiguration with EUVATPerformanceTestBase {

  val getMakeANewEUVATClaimPage: HttpRequestBuilder =
    http("[get ] Make a claim for an EU VAT refund page")
      .get(euvatFilingFrontendUrl + "/make-a-claim-eu-vat-refund")
      .check(status.is(200))

  val getWhichEUMemberStateAreYouClaimingBackVATFrom: HttpRequestBuilder =
    http("[get ] Which EU member state are you claiming back VAT from?")
      .get(euvatFilingFrontendUrl + "/which-eu-member-state")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhichEUMemberStateAreYouClaimingBackVATFrom(name: String): HttpRequestBuilder =
    http("[post] Which EU member state are you claiming back VAT from page")
      .post(euvatFilingFrontendUrl + "/which-eu-member-state")
      .formParam("value", name)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeWhichEUMemberStateAreYouClaimingBackVATFrom: HttpRequestBuilder =
    http("[get ] Change Which EU member state are you claiming back VAT from?")
      .get(euvatFilingFrontendUrl + "/change-which-eu-member-state")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhichEUMemberStateAreYouClaimingBackVATFrom(name: String): HttpRequestBuilder =
    http("[post] Change Which EU member state are you claiming back VAT from page")
      .post(euvatFilingFrontendUrl + "/change-which-eu-member-state")
      .formParam("value", name)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhichLanguageDoYouWantToUseForThisClaim: HttpRequestBuilder =
    http("[get ] Which language do you want to use for this claim page")
      .get(euvatFilingFrontendUrl + "/which-language")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhichLanguageDoYouWantToUseForThisClaim(option: String): HttpRequestBuilder =
    http("[post] Which language do you want to use for this claim page")
      .post(euvatFilingFrontendUrl + "/which-language")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeWhichLanguageDoYouWantToUseForThisClaim: HttpRequestBuilder =
    http("[get ] Change Which language do you want to use for this claim page")
      .get(euvatFilingFrontendUrl + "/change-which-language")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhichLanguageDoYouWantToUseForThisClaim(option: String): HttpRequestBuilder =
    http("[post] Change Which language do you want to use for this claim page")
      .post(euvatFilingFrontendUrl + "/change-which-language")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhichCurrencyDoYouWantToUseForThisClaim: HttpRequestBuilder =
    http("[get ] Which currency do you want to use for this claim page")
      .get(euvatFilingFrontendUrl + "/which-currency")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhichCurrencyDoYouWantToUseForThisClaim(option: String): HttpRequestBuilder =
    http("[post] Which currency do you want to use for this claim page")
      .post(euvatFilingFrontendUrl + "/which-currency")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeWhichCurrencyDoYouWantToUseForThisClaim: HttpRequestBuilder =
    http("[get ] Which currency do you want to use for this claim page")
      .get(euvatFilingFrontendUrl + "/change-which-currency")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeWhichCurrencyDoYouWantToUseForThisClaim(option: String): HttpRequestBuilder =
    http("[post] Which currency do you want to use for this claim page")
      .post(euvatFilingFrontendUrl + "/change-which-currency")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getRefundPeriod: HttpRequestBuilder =
    http("[get ] Refund Period page")
      .get(euvatFilingFrontendUrl + "/refund-period")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRefundPeriod(
    startMonth: String,
    startYear: String,
    endMonth: String,
    endYear: String
  ): HttpRequestBuilder =
    http("[post] Refund Period page")
      .post(euvatFilingFrontendUrl + "/refund-period")
      .formParam("start.month", startMonth)
      .formParam("start.year", startYear)
      .formParam("end.month", endMonth)
      .formParam("end.year", endYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeRefundPeriod: HttpRequestBuilder =
    http("[get ] Change Refund Period page")
      .get(euvatFilingFrontendUrl + "/change-refund-period")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeRefundPeriod(
    startMonth: String,
    startYear: String,
    endMonth: String,
    endYear: String
  ): HttpRequestBuilder =
    http("[post] Change Refund Period page")
      .post(euvatFilingFrontendUrl + "/change-refund-period")
      .formParam("start.month", startMonth)
      .formParam("start.year", startYear)
      .formParam("end.month", endMonth)
      .formParam("end.year", endYear)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getHowShouldWeContactYouAboutThisClaim: HttpRequestBuilder =
    http("[get ] How should we contact you about this claim? page")
      .get(euvatFilingFrontendUrl + "/how-contact-you-about-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postHowShouldWeContactYouAboutThisClaim(email: String, telephone: String): HttpRequestBuilder =
    http("[post] How should we contact you about this claim? page")
      .post(euvatFilingFrontendUrl + "/how-contact-you-about-claim")
      .formParam("contactEmail", email)
      .formParam("contactTelephone", telephone)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeHowShouldWeContactYouAboutThisClaim: HttpRequestBuilder =
    http("[get ] Change How should we contact you about this claim? page")
      .get(euvatFilingFrontendUrl + "/change-how-contact-you-about-claim")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeHowShouldWeContactYouAboutThisClaim(email: String, telephone: String): HttpRequestBuilder =
    http("[post] Change How should we contact you about this claim? page")
      .post(euvatFilingFrontendUrl + "/change-how-contact-you-about-claim")
      .formParam("contactEmail", email)
      .formParam("contactTelephone", telephone)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getBusinessActivityOne: HttpRequestBuilder =
    http("[get ] Business activity (1) for this claim page")
      .get(euvatFilingFrontendUrl + "/business-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postBusinessActivityOne(option: String): HttpRequestBuilder =
    http("[post] Business activity (1) for this claim page")
      .post(euvatFilingFrontendUrl + "/business-activity")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeBusinessActivityOne: HttpRequestBuilder =
    http("[get ] Business activity (1) for this claim page")
      .get(euvatFilingFrontendUrl + "/change-business-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeBusinessActivityOne(option: String): HttpRequestBuilder =
    http("[post] Business activity (1) for this claim page")
      .post(euvatFilingFrontendUrl + "/change-business-activity")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheSecondSICCode: HttpRequestBuilder =
    http("[get ] What is the second SIC code? page")
      .get(euvatFilingFrontendUrl + "/what-is-the-second-SIC-code")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheSecondSICCode(businessActivityCode2: String): HttpRequestBuilder =
    http("[post] What is the second SIC code? page")
      .post(euvatFilingFrontendUrl + "/what-is-the-second-SIC-code")
      .formParam("value", businessActivityCode2)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeSecondSICCode: HttpRequestBuilder =
    http("[get ] Change What is the second SIC code? page")
      .get(euvatFilingFrontendUrl + "/change-what-is-the-second-SIC-code")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeSecondSICCode(businessActivityCode2: String): HttpRequestBuilder =
    http("[post] Change What is the second SIC code? page")
      .post(euvatFilingFrontendUrl + "/change-what-is-the-second-SIC-code")
      .formParam("value", businessActivityCode2)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getRemoveSecondSICCode: HttpRequestBuilder =
    http("[get ] Are you sure you want to remove the second SIC code? page")
      .get(euvatFilingFrontendUrl + "/remove-second-SIC-code")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRemoveSecondSICCode(option: String): HttpRequestBuilder =
    http("[post] Are you sure you want to remove the second SIC code? page")
      .post(euvatFilingFrontendUrl + "/remove-second-SIC-code")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getBusinessActivityTwo: HttpRequestBuilder =
    http("[get ] Business activity (2) for this claim page")
      .get(euvatFilingFrontendUrl + "/business-activity-2")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postBusinessActivityTwo(option: String): HttpRequestBuilder =
    http("[post] Business activity (2) for this claim page")
      .post(euvatFilingFrontendUrl + "/business-activity-2")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getWhatIsTheThirdSICCode: HttpRequestBuilder =
    http("[get ] What is the third SIC code?  page")
      .get(euvatFilingFrontendUrl + "/what-is-the-third-SIC-code")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsTheThirdSICCode(businessActivityCode3: String): HttpRequestBuilder =
    http("[post] What is the third SIC code?  page")
      .post(euvatFilingFrontendUrl + "/what-is-the-third-SIC-code")
      .formParam("value", businessActivityCode3)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getChangeThirdSICCode: HttpRequestBuilder =
    http("[get ] Change What is the third SIC code?  page")
      .get(euvatFilingFrontendUrl + "/change-what-is-the-third-SIC-code")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postChangeThirdSICCode(businessActivityCode3: String): HttpRequestBuilder =
    http("[post] Change What is the third SIC code?  page")
      .post(euvatFilingFrontendUrl + "/change-what-is-the-third-SIC-code")
      .formParam("value", businessActivityCode3)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getRemoveThirdSICCode: HttpRequestBuilder =
    http("[get ] Are you sure you want to remove the third SIC code? page")
      .get(euvatFilingFrontendUrl + "/remove-third-SIC-code")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRemoveThirdSICCode(option: String): HttpRequestBuilder =
    http("[post] Are you sure you want to remove the third SIC code? page")
      .post(euvatFilingFrontendUrl + "/remove-third-SIC-code")
      .formParam("value", option)
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getBusinessActivityThree: HttpRequestBuilder =
    http("[get ] Business activity (3) for this claim page")
      .get(euvatFilingFrontendUrl + "/business-activity-3")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postBusinessActivityThree: HttpRequestBuilder =
    http("[post] Business activity (3) for this claim page")
      .post(euvatFilingFrontendUrl + "/business-activity-3")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getCheckYourClaimDetails: HttpRequestBuilder =
    http("[get ] Check your claim details page")
      .get(euvatFilingFrontendUrl + "/check-your-claim-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCheckYourClaimDetails: HttpRequestBuilder =
    http("[post] Check your claim details page")
      .post(euvatFilingFrontendUrl + "/check-your-claim-details")
      .formParam("csrfToken", f"#{csrfToken}")
      .check(status.is(303))

  val getClaimDetails: HttpRequestBuilder =
    http("[get ] Check claim details page")
      .get(euvatFilingFrontendUrl + "/claim-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val AddClaimDetailsJourney: List[HttpRequestBuilder] = List(
    getMakeANewEUVATClaimPage,
    getWhichEUMemberStateAreYouClaimingBackVATFrom,
    postWhichEUMemberStateAreYouClaimingBackVATFrom("HR"),
    getRefundPeriod,
    postRefundPeriod("02", "2025", "04", "2025"),
    getHowShouldWeContactYouAboutThisClaim,
    postHowShouldWeContactYouAboutThisClaim("Test123@test.com", "01234567890"),
    getBusinessActivityOne,
    postBusinessActivityOne("false"),
//      Change member state
    getCheckYourClaimDetails,
    getChangeWhichEUMemberStateAreYouClaimingBackVATFrom,
    postChangeWhichEUMemberStateAreYouClaimingBackVATFrom("EE"),
    getChangeWhichLanguageDoYouWantToUseForThisClaim,
    postChangeWhichLanguageDoYouWantToUseForThisClaim("english"),
    getChangeWhichCurrencyDoYouWantToUseForThisClaim,
    postChangeWhichCurrencyDoYouWantToUseForThisClaim("euro"),
    getChangeRefundPeriod,
    postChangeRefundPeriod("05", "2025", "07", "2025"),
    getCheckYourClaimDetails,
//      Change language
    getChangeWhichLanguageDoYouWantToUseForThisClaim,
    postChangeWhichLanguageDoYouWantToUseForThisClaim("estonian"),
    getChangeWhichCurrencyDoYouWantToUseForThisClaim,
    postChangeWhichCurrencyDoYouWantToUseForThisClaim("estonianKroon"),
    getCheckYourClaimDetails,
//      Change currency
    getChangeWhichCurrencyDoYouWantToUseForThisClaim,
    postChangeWhichCurrencyDoYouWantToUseForThisClaim("euro"),
    getCheckYourClaimDetails,
//      Change refund period
    getChangeRefundPeriod,
    postChangeRefundPeriod("08", "2025", "10", "2025"),
    getCheckYourClaimDetails,
//      Change contact details
    getChangeHowShouldWeContactYouAboutThisClaim,
    postChangeHowShouldWeContactYouAboutThisClaim("Test123@test.com", "01234567890"),
    getCheckYourClaimDetails,
//      Change & remove Second SIC code
    getChangeBusinessActivityOne,
    postChangeBusinessActivityOne("true"),
    getChangeSecondSICCode,
    postChangeSecondSICCode("4711"),
    getBusinessActivityTwo,
    getChangeSecondSICCode,
    postChangeSecondSICCode("1101"),
    getBusinessActivityTwo,
    getRemoveSecondSICCode,
    postRemoveSecondSICCode("true"),
    getBusinessActivityOne,
    postBusinessActivityOne("true"),
    getWhatIsTheSecondSICCode,
    postWhatIsTheSecondSICCode("4532"),
    getBusinessActivityTwo,
    postBusinessActivityTwo("true"),
    getWhatIsTheThirdSICCode,
    postWhatIsTheThirdSICCode("2534"),
//      Change & remove Third SIC code
    getBusinessActivityThree,
    getChangeThirdSICCode,
    postChangeThirdSICCode("4533"),
    getBusinessActivityThree,
    getRemoveThirdSICCode,
    postRemoveThirdSICCode("true"),
    getBusinessActivityTwo,
    postBusinessActivityTwo("true"),
    getWhatIsTheThirdSICCode,
    postWhatIsTheThirdSICCode("4712"),
    getBusinessActivityThree,
    postBusinessActivityThree,
    getCheckYourClaimDetails,
    postCheckYourClaimDetails,
    getMakeANewEUVATClaimPage,
    getClaimDetails
  )

  val AddClaimDetailsJourneyForGermany: List[HttpRequestBuilder] = List(
    getMakeANewEUVATClaimPage,
    getWhichEUMemberStateAreYouClaimingBackVATFrom,
    postWhichEUMemberStateAreYouClaimingBackVATFrom("DE"),
    getWhichLanguageDoYouWantToUseForThisClaim,
    postWhichLanguageDoYouWantToUseForThisClaim("english"),
    getRefundPeriod,
    postRefundPeriod("02", "2025", "04", "2025"),
    getHowShouldWeContactYouAboutThisClaim,
    postHowShouldWeContactYouAboutThisClaim("Test123@test.com", "01234567890"),
    getBusinessActivityOne,
    postBusinessActivityOne("false"),
    getCheckYourClaimDetails,
    postCheckYourClaimDetails,
    getMakeANewEUVATClaimPage
  )
}
