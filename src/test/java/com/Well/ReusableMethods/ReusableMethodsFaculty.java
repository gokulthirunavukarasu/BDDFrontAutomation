package com.Well.ReusableMethods;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ReusableMethodsFaculty extends BaseClass {
	static String username;
	static String admin_Header;

	public void RegisterFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TrainingNavBar", 60);
		CommonMethod.RobustclickElementVisible("TrainingNavBar","WELLFacultyNavBar");
		CommonMethod.RobustclickElementVisible("WELLFacultyNavBar","WFExamContinuebtn");
		CommonMethod.WaitUntilVisibility("WFExamContinuebtn", 30);
		CommonMethod.RobustclickElementVisible("WFExamContinuebtn","WPRExamOwnerCountry");
		CommonMethod.RobustclickElementVisible("WFAddrContinuebtn","WPRExamOwnerCountry");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Employer is required.", "Employer Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Position is required.", "Position Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Language Selection is required.", "Language Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please upload a CV/Resume with the file type of doc, docx, pdf, txt.", "Upload CV/Resume with the file type Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are a current USGBC Faculty member.", "USGBC Faculty member Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select a Credential or Certification.", "Credential or Certification Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are migrated from USGBC.", "Migrated from USGBC Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are an advisor.", "Select Advisor Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are a part of a Member organization.", "Select Member Organization Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are LEED Faculty.", "Select LEED Faculty Error Mismatch");
		CommonMethod.WaitUntilVisibility("WPRExamOwnerCountry", 60);
		CommonMethod.selectdropdownValue("WPRExamOwnerCountry", "US");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getattributeValue("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("WPRExamOwnerState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getattributeValue("WPRExamOwnerState"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("ProjectAddress"+ProjectAddress);
		testlog.info("ProjectCity"+ProjectCity);
		testlog.info("PostalCode"+PostalCode);
		CommonMethod.sendKeys("WPRExamOrgAddress", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WPRExamOrgAddress"));
		CommonMethod.sendKeys("WPRExamOrgCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WPRExamOrgCity"));
		CommonMethod.sendKeys("WPRExamOrgPostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WPRExamOrgPostalcode"));
		CommonMethod.sendKeys("WFEmp", "FullTime");
		data.setCellData(SheetName, "WFEmp", rowNum, CommonMethod.getattributeValue("WFEmp"));
		CommonMethod.sendKeys("WFPostion", "Testing");
		data.setCellData(SheetName, "WFPostion", rowNum, CommonMethod.getattributeValue("WFPostion"));
		testlog.info("Language : English");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick","OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
		CommonMethod.uploadFile("WFCvUpload", SamplePdffile);
		CommonMethod.ClickCheckbox("WFUsgbcFacultyrbtn");
		CommonMethod.ClickCheckbox("WFCredentialsrbtn");
		CommonMethod.ClickCheckbox("WFMigration");
		CommonMethod.ClickCheckbox("WFAdvisor");
		CommonMethod.ClickCheckbox("WFPartmemberOrg");
		CommonMethod.ClickCheckbox("WFLeedFaculty");
		CommonMethod.scrolldowntoElement("WFLeedFaculty");
		CommonMethod.WaitUntilVisibility("WFAddrContinuebtn", 30);
		CommonMethod.RobustclickElementVisible("WFAddrContinuebtn","WFFacultyApplication");
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 180);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void AgreementFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 60);
		CommonMethod.scrolldowntoElement("WFFacultyApplication");
		String sampleText = "WELL Faculty Application";
		CommonMethod.RobustclickElementVisible("WFAddrContinuebtn","WFFacilitation");
		CommonMethod.negativesoftassertPageSource("Please fill out the required fields.", "Qualification Required Fields Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Fileupload is required.", "Fileupload Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please confirm the terms and conditions.", "Terms And Conditions Error Mismatch");
		CommonMethod.sendKeys("WFFacilitation", sampleText);
		data.setCellData(SheetName, "WFFacilitation", rowNum, CommonMethod.getattributeValue("WFFacilitation"));
		CommonMethod.uploadFile("WFProvideUpload", SamplePdffile);
		CommonMethod.uploadFile("WFClientUpload", SamplePdffile);
		Thread.sleep(1000);
		CommonMethod.uploadFile("WFClientUpload", SamplePdffile1);
		
		CommonMethod.uploadFile("WFSurveyUpload", SamplePdffile);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WFExp", sampleText);
		data.setCellData(SheetName, "WFExp", rowNum, CommonMethod.getattributeValue("WFExp"));
		CommonMethod.sendKeys("WFTravel", sampleText);
		data.setCellData(SheetName, "WFTravel", rowNum, CommonMethod.getattributeValue("WFTravel"));
		CommonMethod.ClickCheckbox("WFTermcbx");
		CommonMethod.scrolldowntoElement("WFTermcbx");
		CommonMethod.WaitUntilVisibility("WFAddrContinuebtn", 60);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("WFAddrContinuebtn","WFFacultyApplication");
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 60);
		testlog.pass("**Verifies the Agreement Faculty successfully**");
	}
	public void SubmitReview(String SheetName, int rowNum, String assertion) throws IOException, InterruptedException {
		if(assertion.equalsIgnoreCase("assertion")) {
			CommonMethod.RobustclickElementVisible("WFExamContinuebtn","WFSubmitApplicationbtn");
			System.out.println("Status Radio button is selected");
			CommonMethod.negativesoftassertPageSource("Please select application status.", "Application Status Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Region is required.", "Region Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Source is required.", "Source Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Teaching Experience is required.", "Teaching Experience Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Teaching Experience Notes is required.", "Teaching Experience Notes Error Mismatch");
			CommonMethod.negativesoftassertPageSource("WELL Events Taught is required.", "WELL Events Taught Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Willingness to Train is required.", "Willingness to Train Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Technical is required.", "Technical Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Red Flag is required.", "Red Flag Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Workshops is required.", "Workshops Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Next Step is required.", "Next Step Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Admin Notes is required.", "Admin Notes Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Admin Notes 2 is required.", "Admin Notes 2 Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Admin Notes 3 is required.", "Admin Notes 3 Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Please upload Scorecard Documents.", "Scorecard Documents Error Mismatch");
		}
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 60);
		CommonMethod.scrolldowntoElement("WFFacultyApplication");
		CommonMethod.WaitUntilVisibility("WFStatus", 60);
		CommonMethod.ClickCheckbox("WFStatus");
		CommonMethod.RobustclickElementVisible("WFApprovedDate","DatePickerOkButton");
		CommonMethod.WaitUntilVisibility("DatePickerOkButton", 10);
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","WFApproved");
		Thread.sleep(1000);
		String FirstName = USfaker.address().firstName();
		testlog.info("firstName"+FirstName);
		CommonMethod.sendKeys("WFApproved", FirstName);
		data.setCellData(SheetName, "WFApproved", rowNum, CommonMethod.getattributeValue("WFApproved"));
		CommonMethod.WaitUntilVisibility("WFExpireDate", 10);
		CommonMethod.RobustclickElementVisible("WFExpireDate","DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","WFReasonnarration");
		String sampleText = "WELL Faculty Application";
		CommonMethod.sendKeys("WFReasonnarration", sampleText);
		CommonMethod.sendKeys("WFRegion", sampleText);
		CommonMethod.sendKeys("WFSource", sampleText);
		CommonMethod.ClickCheckbox("WFTeachingcbx");
		CommonMethod.sendKeys("WFWillingness", sampleText);
		CommonMethod.ClickCheckbox("WFTechrbn");
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("WFBusinessrbn");
		CommonMethod.ClickCheckbox("WFRedflagrbn");
		CommonMethod.ClickCheckbox("WFWorkshops");
		CommonMethod.RobustclickElementVisible("WFNextDate","DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","WFProvideUpload");
		CommonMethod.uploadFile("WFProvideUpload", SamplePdffile);
		CommonMethod.sendKeys("WFAdminNote3narration", sampleText);
		CommonMethod.sendKeys("WFAdminNote2narration", sampleText);
		CommonMethod.sendKeys("WFAdminnarration", sampleText);
		CommonMethod.sendKeys("WFNextnarration", sampleText);
		CommonMethod.WaitUntilClickble("WFEventsnarration", 60).sendKeys(sampleText);
		CommonMethod.sendKeys("WFTeachingnarration", sampleText);
		CommonMethod.RobustclickElementVisible("WFExamContinuebtn","WFSubmitApplicationbtn");
	}

	public void SubmitReviewFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		SubmitReview(SheetName, rowNum,"assertion");
		CommonMethod.WaitUntilVisibility("WFSubmitApplicationbtn", 60);
		CommonMethod.RobustclickElementVisible("WFSubmitApplicationbtn","WFReturnbtn");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("WFReturnbtn", 60);
		CommonMethod.RobustclickElementVisible("WFReturnbtn","AdminNavBar");
		testlog.pass("**Verifies Submitted Review successfully**");
		
	}
	public void ReviewSubmitResultFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar","AdminWELLFacultyNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLFacultyNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminWELLFacultyNavBar", "WFAdminEmail");
		CommonMethod.WaitUntilClickble("WFAdminEmail", 60)
				.sendKeys(data.getCellData("Login", "UserName", 5));
		CommonMethod.RobustclickElementVisible("ApplyButton","WFViewButton");
		CommonMethod.RobustclickElementVisible("WFViewButton","WFReviewApplicationButton");
		CommonMethod.RobustclickElementVisible("WFReviewApplicationButton","WFAddrContinuebtn");
		CommonMethod.RobustclickElementVisible("WFAddrContinuebtn","WFFacultyApplication");
		CommonMethod.ClickCheckbox("WFTermcbx");
		CommonMethod.scrolldowntoElement("WFTermcbx");
		CommonMethod.WaitUntilVisibility("WFAddrContinuebtn", 60);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("WFAddrContinuebtn","WFFacultyApplication");
		SubmitReview(SheetName, rowNum,"No Assertion");
		CommonMethod.RobustclickElementVisible("WFReturnSubmitButton","WFAdminReviewApprovedStatus");
		CommonMethod.assertcontainsmessage("WFAdminReviewApprovedStatus", "APPROVED", "Verified Review status");
		testlog.pass("**Verifies Review Result successfully**");
	}
	
	public void ReviewBillingFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TrainingNavBar", 60);
		CommonMethod.RobustclickElementVisible("TrainingNavBar","WELLFacultyNavBar");
		CommonMethod.RobustclickElementVisible("WELLFacultyNavBar","WFExamContinuebtn");
		CommonMethod.WaitUntilVisibility("WFExamContinuebtn", 30);
		CommonMethod.RobustclickElementVisible("WFExamContinuebtn","BillingLanding");
		rc.Billing(SheetName, rowNum);
	}
	
	public static void orientationCardValdationFaculty() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TrainingNavBar", 60);
		CommonMethod.RobustclickElementVisible("TrainingNavBar","WELLFacultyNavBar");
		CommonMethod.RobustclickElementVisible("WELLFacultyNavBar", "WFOrientationTab");
		CommonMethod.WaitUntilVisibility("WFOrientationTab", 60);
		CommonMethod.RobustclickElementVisible("WFOrientationTab", "FacultyRenew");
		CommonMethod.WaitUntilVisibility("FacultyRenew", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyRenew"), "Renew", "Renew doesn't match");
		CommonMethod.WaitUntilVisibility("FacultyDownloadCertificate", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyDownloadCertificate"),
				"Download certificate", "Download Ceritificate doesn't match");
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, "4");
		softAssert.assertAll();
		testlog.info("Card count: " + cardCount);
		testlog.pass("**Verify card count successfully**");
	}

	public static void keepLearingCardValdationFaculty() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WFKeepLearningTab", 60);
		CommonMethod.RobustclickElementVisible("WFKeepLearningTab", "FacultyRenew");
		CommonMethod.WaitUntilVisibility("FacultyRenew", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyRenew"), "Renew", "Renew doesn't match");
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, "3");
		softAssert.assertAll();
		testlog.info("Card count: " + cardCount);
		testlog.pass("**Verify card count successfully**");	
	}

	public static void resourcesCardValdationFaculty() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WFResourceTab", 60);
		CommonMethod.RobustclickElementVisible("WFResourceTab", "FacultyRenew");
		CommonMethod.WaitUntilVisibility("FacultyRenew", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyRenew"), "Renew", "Renew doesn't match");
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, "22");
		softAssert.assertAll();
		testlog.info("Card count: " + cardCount);
		testlog.pass("**Verify card count successfully**");
	}

	public static void marketingToolKitCardValdationFaculty() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WFMarketingToolkitTab", 60);
		CommonMethod.RobustclickElementVisible("WFMarketingToolkitTab", "FacultyRenew");
		CommonMethod.WaitUntilVisibility("FacultyRenew", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyRenew"), "Renew", "Renew doesn't match");
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, "2");
		softAssert.assertAll();
		testlog.info("Card count: " + cardCount);
		testlog.pass("**Verify card count successfully**");
	}
	
	public static void reportingCardValdationFaculty() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WFReportingTab", 60);
		CommonMethod.RobustclickElementVisible("WFReportingTab", "FacultyRenew");
		CommonMethod.WaitUntilVisibility("FacultyRenew", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyRenew"), "Renew", "Renew doesn't match");
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, "2");
		softAssert.assertAll();
		testlog.info("Card count: " + cardCount);
		testlog.pass("**Verify card count successfully**");
	}
	
	@SuppressWarnings("unchecked")
	public static Response PostRequestAuthenticate(String SheetName, int rowNum) {
		/*
		 * Get Token by authentication
		 */
        username = data.getCellData("Login", "UserName", 3);
		if (SheetName.equalsIgnoreCase("Faculty")) {
			username = data.getCellData("Login", "UserName", 5);
		}
		JSONObject param = new JSONObject();
		param.put("email", username);
		param.put("password", "initpass");
        Response res = given().accept("application/json").contentType("application/json").body(param).when()
				.post("https://test-v2-api.wellcertified.com/api/authenticate");
		admin_Header = (res.path("token")).toString();
		admin_Header = "Bearer " + admin_Header;
		return res;
	}

	public static Response DeleteFacultyOrMembership() {
        /*
		 * Delete Faculty/Membership using Token
		 */
		Response res = given().contentType("application/json").header("Authorization", admin_Header).when()
				.delete("https://test-v2-api.wellcertified.com/api/admin/qa/automation/bulk-delete/" + username);
		return res;
		
	}
}