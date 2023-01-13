package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsHealthSafety extends BaseClass {

	public void RegisterHealthSafety(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLHealthSafetyNavBar");
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar","HsrWellhealthstartprojectbtn");
		CommonMethod.RobustclickElementVisible("HsrWellhealthstartprojectbtn","HsrEnrollnowbtn");
		CommonMethod.RobustclickElementVisible("HsrEnrollnowbtn", "HsrEnrollbtn");
		CommonMethod.RobustclickElementVisible("HsrEnrollbtn", "Hsrenrollcontinuebtn");
		CommonMethod.WaitUntilClickble("HsrenrollName", 30);
		String erollName = "Automation HSR Project " + CommonMethod.randomNumber(8000000);
		CommonMethod.RobustclickElementVisible("Hsrenrollcontinuebtn", "HsrenrollName");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.", "Organization Industry Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		CommonMethod.sendKeys("HsrenrollName", erollName);
		data.setCellData(SheetName, "HsrName", rowNum, CommonMethod.getattributeValue("HsrenrollName"));
		testlog.info("HsrName: " + data.getCellData(SheetName, "HsrName", rowNum));
		CommonMethod.ClickCheckbox("Hsrenrollcheckbox");
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdownValue("Hsrenrollcountry", "US");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("Hsrenrollcountry"));
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("Hsrenrollcountry"));
		CommonMethod.selectdropdownrandom("Hsrenrollstate");
		testlog.info("State: " + CommonMethod.getSelectedDropdownAttribute("Hsrenrollstate"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("Hsrenrollstate"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("Hsrenrollstreet", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("Hsrenrollstreet"));
		testlog.info("Hsrenrollstreet: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("Hsrenrollcity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("Hsrenrollcity"));
		testlog.info("City: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("Hsrenrollpostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("Hsrenrollpostalcode"));
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.ClickCheckbox("Hsrbilladdcheckbox");
		CommonMethod.RobustclickElementVisible("Hsrenrollcontinuebtn", "HsrRegcontinuebtn");
		CommonMethod.RobustclickElementVisible("HsrRegcontinuebtn", "Hsrregcheckbox");
		CommonMethod.negativesoftassertPageSource("On behalf of owner is required.", "Owner CheckBox Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Is the Owner organization an IWBI member?* is required.", "Owner Organization Name Error Mismatch");
		CommonMethod.ClickCheckbox("Hsrregcheckbox");
		CommonMethod.selectdropdownVisibletext("HsrIwbimemberdropdown", "No");
		CommonMethod.RobustclickElementVisible("HsrRegcontinuebtn", "HsrTypeoneEnrollbtn");
		CommonMethod.RobustclickElementVisible("HsrTypeoneEnrollbtn", "HsrLocContinuebutton");
		CommonMethod.scrollUp();
		CommonMethod.sendKeys("Hsrlocations", "10");
		data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("Hsrlocations"));
		testlog.info("Hsrlocations: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpacetype","HsrWPRlocationsSpaceOption");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpaceOption","Hsrlocationsize");
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		CommonMethod.clearAndSendKey("Hsrlocationsize", Area);
		data.setCellData(SheetName, "Area", rowNum, CommonMethod.getattributeValue("Hsrlocationsize"));
		testlog.info("Hsrlocations: " + data.getCellData(SheetName, "Area", rowNum));
		CommonMethod.WaitUntilVisibility("HsrLocContinuebutton", 120);
		CommonMethod.RobustclickElementVisible("HsrLocContinuebutton", "HSRApplyButton");
		if (CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 20)) {
			CommonMethod.RobustclickElementVisible("HsrLocContinuebutton", "HsrWPRYesMyOrganizationCbx");
			CommonMethod.negativesoftassertPageSource("Yes, my organization meets the criteria of the listed discount category.* is required.", "My Organization CheckBox Error Name");
			CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 60);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
		}
		CommonMethod.RobustclickElementVisible("HsrLocContinuebutton", "HsrReviewbtn");
		CommonMethod.WaitUntilClickble("HsrProgramFeePublicrbtn", 60);
		CommonMethod.ClickCheckbox("HsrProgramFeePublicrbtn");
		CommonMethod.WaitUntilVisibility("HsrAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("HsrAcknowledecbx");
		CommonMethod.RobustclickElementVisible("HsrReviewbtn", "BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies the Registration successful**");
	}
	
	public void StoreIdHealthSafety(String SheetName, int rowNum) throws IOException, InterruptedException {
		if (CommonMethod.isElementsExist("HsrIframe", 60)) {
		CommonMethod.WaitUntilPresence("HsrIframe", 180);
		CommonMethod.switchToFrame("HsrIframe");
		CommonMethod.WaitUntilPresence("HsrCloseCard", 60);
		CommonMethod.Robustclick("HsrCloseCard");
		CommonMethod.switchToParentFrame();	
		}
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("StoreId", 300);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getHsrId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getHsrId);
		testlog.info("HealthSafety Id:" + getHsrId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
	}

	public void SearchHealthSafetyByID(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrIdSearch","HsrIdSearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch","V2ProjectSearchResultIDVerify");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount),"1","HealthSafety Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "HsrName", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch","V2ProjectSearchResultIDVerify");
		int ProjectCount1 = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount1),"1","HealthSafety Search failed");
		CommonMethod.assertcontainsmessage("HSRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("HSRIdClick","WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Search HealthSafety ByID successfully**");
	}
	
	public void SearchFilterRegisteredStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrIdSearch","HsrIdSearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch","V2ProjectSearchResultIDVerify");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount),"1","HealthSafety Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "HsrName", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch","V2ProjectSearchResultIDVerify");
		int ProjectCount1 = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount1),"1","HealthSafety Search failed");
		CommonMethod.assertcontainsmessage("HSRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " +status);
		CommonMethod.assertExpectedContainsActual(status,"REGISTERED","HealthSafety Search failed");
		CommonMethod.RobustclickElementVisible("HSRIdClick","WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Search HealthSafety ByID successfully**");
		testlog.pass("**Verifies the Search filter status successfully**");
	}

	public void ScorecardfillHSRWPR(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne)
			throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
		int j = DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			do {
				CommonMethod.click(NoButton.get(RemainingNo - j));
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
				Thread.sleep(2000);
			} while (NoButton.size() == RemainingNo);
			RemainingNo--;
			j--;
		}
		CommonMethod.scrolldowntoElement("HsrScorecard");
		YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
		for (int i = 1; i <= YesEnd; i++) {
			int RemainingYes = YesButton.size();
			do {
				CommonMethod.WaitUntilClickble("V2ProjectHsrPurseYes", 60);
				CommonMethod.click("V2ProjectHsrPurseYes");
				Thread.sleep(1000);
				YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
				Thread.sleep(2000);
			} while (YesButton.size() == RemainingYes);
			RemainingYes--;
		}

	}

	public void CompleteScorecardHsrById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ScorecardTab", 300);
		CommonMethod.RobustclickElementVisible("ScorecardTab","HsrScorecard");
		CommonMethod.WaitUntilVisibility("HsrScorecard", Scorecardtimeout);
		ScorecardfillHSRWPR(15, 1, 27, 27);
		testlog.pass("**Verifies the 15 Purse Yes Scorecard HealthSafety in V2Project successfully**");
	}

	public void uploadDocumentInFeature(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("HsrScorecard");
		for (WebElement f : Feature) {
			CommonMethod.WaitUntilClickble(f, 30).click();
			CommonMethod.WaitUntilPresence("V2ProjectWPRPDocIcon", 120);
			CommonMethod.RobustclickElementVisible("V2ProjectWPRPDocIcon", "HsrSelectTypeDoc");
			CommonMethod.WaitUntilVisibility("HsrSelectTypeDoc", 60);
			CommonMethod.selectdropdownIndex("HsrSelectTypeDoc", 1);
			if (CommonMethod.isElementsExist("HsrLocationrtn", 3)) {
				CommonMethod.WaitUntilClickble("HsrLocationrtn", 10);
				CommonMethod.ClickCheckbox("HsrLocationrtn");
			}
			CommonMethod.WaitUntilVisibility("V2ProjectWPRVerificationMethod", 60);
			CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
			CommonMethod.scrolldowntoElement("V2ProjectWPRVerificationMethod");
			if (CommonMethod.isElementsExist("HsrSelectLoc", 3)) {
				CommonMethod.WaitUntilClickble("HsrSelectLoc", 10);
				CommonMethod.selectdropdownIndex("HsrSelectLoc", 1);
			}
			CommonMethod.uploadFile("V2ProjectDocUpload", FeaturefileUpload);
			Thread.sleep(2000);
			CommonMethod.Robustclick("HsrUploadDocFeature");
			CommonMethod.scrolldowntoElement("HsrScorecard");
			CommonMethod.click(f);
		}
	}

	public void UploadHsrDocForFeature() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("HsrScorecard", Scorecardtimeout);
		uploadDocumentInFeature(15);
		testlog.pass("**Upload 15 Scorecard Documents successfully**");
	}

	public void SubmitHsrReview(String SheetName, int rowNum, String ReviewName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 120);
		CommonMethod.RobustclickElementVisible("ReviewTab","Reviewlanding");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 120);
		CommonMethod.WaitUntilVisibility("HsrSubmitReview", 60);
		CommonMethod.RobustclickElementVisible("HsrSubmitReview","HsrSubmitDocReview");
		CommonMethod.WaitUntilVisibility("HsrSubmitDocReview", 60);
		CommonMethod.WaitUntilVisibility("HsrCommentReview", 60).sendKeys(ReviewName);
		CommonMethod.WaitUntilPresence("HsrSelectedProjectPhaseReview", 60);
		CommonMethod.selectdropdownVisibletext("HsrSelectedProjectPhaseReview", ReviewName);
		CommonMethod.WaitUntilClickble("HsrSubmitDocReview", 60);
		CommonMethod.RobustclickElementVisible("HsrSubmitDocReview","ReviewViewButton");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 60);
		testlog.pass("**Submitted Health-Safety Review successfully**");
	}
		
	public void CompleteHsrReview(String SheetName, int rowNum, String ReviewName) throws IOException, InterruptedException {
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 120);
		CommonMethod.RobustclickElementVisible("AdminNavBar","AdminWELLHealthsafetyNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLHealthsafetyNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminWELLHealthsafetyNavBar", "HsrAdminIdSearch");
		CommonMethod.WaitUntilVisibility("HsrAdminIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrAdminIdSearch","HsrAdminApplybtn");
		CommonMethod.sendKeys("HsrAdminIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrAdminApplybtn","HsrAdminIdClick");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("HsrAdminIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("HsrAdminIdClick","ReviewTab");
		CommonMethod.WaitUntilVisibility("ReviewTab", 300);
		CommonMethod.RobustclickElementVisible("ReviewTab","ReviewViewButton");
	    CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
	    CommonMethod.RobustclickElementVisible("ReviewViewButton","ReviewReturnButton");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 60);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "ReviewReturnSubmit");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys(ReviewName);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "DatePickerOkButton");
		CommonMethod.Robustclick("DatePickerOkButton");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.Robustclick("ReviewReturnSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Completed Reviewed Health-Safety Review successfully**");
	}

	public void HsrProjectFieldValidationTest(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 120);
		CommonMethod.RobustclickElementVisible("EditTab", "HsrWprOrganizationInformation");
		CommonMethod.WaitUntilVisibility("HsrWprOrganizationInformation", 60);
		CommonMethod.RobustclickElementVisible("HsrWprOrganizationInformation", "HsrWprEditProjectName");
		CommonMethod.WaitUntilVisibility("HsrWprEditProjectName", 30);
		testlog.info("HsrName: " + data.getCellData(SheetName, "HsrName", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditProjectName"),
				data.getCellData(SheetName, "HsrName", rowNum), "Project Name doesn't match");
		testlog.info("Area: " + data.getCellData(SheetName, "Area", rowNum));
		CommonMethod.softAssertEqualsMessage(
				CommonMethod.getattributeValue("HsrWprEditArea").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "Area", rowNum), "Area doesn't match");
		testlog.info("Location: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditLocation"),
				data.getCellData(SheetName, "Location", rowNum), "Location count doesn't match");
		testlog.info("OrgName: " + data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "OrgName doesn't match");
		testlog.info("OrgIndustry: " + data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("HsrWprEditOrgIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "OrgIndustry doesn't match");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("HsrWprEditCountry"));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownAttribute("HsrWprEditCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Country doesn't match");
		testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditState"),
				data.getCellData(SheetName, "State", rowNum), "State Name doesn't match");
		testlog.info("Street: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Street Name doesn't match");
		testlog.info("City: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditCity"),
				data.getCellData(SheetName, "City", rowNum), "City doesn't match");
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "PostalCode doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies the Hsr Field Validation successfully**");
	}
	public void validateTeamsHSR(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrIdSearch","HsrapplySearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","HealthSafety Search failed");
		CommonMethod.assertcontainsmessage("HSRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		testlog.pass("**Verifies user able to access the invited project**");
	}
	public void clikOnDocumentLibrary() throws InterruptedException, IOException {
		CommonMethod.WaitUntilPresence("WPRHSRDocumentTab", 300);
		CommonMethod.RobustclickElementVisible("WPRHSRDocumentTab","HsrAddDoc");
	}
	public void validateGeneralUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 120);
		CommonMethod.RobustclickElementVisible("HsrAddDoc","HsrDocType");
		CommonMethod.WaitUntilVisibility("HsrDocType", 60);
		CommonMethod.selectdropdownValue("HsrDocType", "general");
		CommonMethod.selectdropdownValue("HsrType","Project overview");
		CommonMethod.uploadFile("WPRDocUpload", GeneralfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("HsrReasonnarration", "Submitting Document");
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn","HsrGeneralLink");
		CommonMethod.WaitUntilPresence("HsrGeneralLink", 120);
		CommonMethod.RobustclickElementVisible("HsrGeneralLink", "HsrGeneralTable");
		CommonMethod.WaitUntilPresence("HsrGeneralTable", 120);
		CommonMethod.scrolldowntoElement("HsrGeneralTable");
		List<String> val = CommonMethod.fetchTableData("HsrGeneralTable");
		CommonMethod.softAssertContainsMessage(val.get(0), "PROJECT OVERVIEW", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload General Document successfully**");	
	}
	public void validateLegalUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 120);
		CommonMethod.RobustclickElementVisible("HsrAddDoc","HsrDocType");
		CommonMethod.WaitUntilVisibility("HsrDocType", 60);
		CommonMethod.selectdropdownValue("HsrDocType", "legal");
		CommonMethod.selectdropdownValue("HsrType","Signed certification agreement");
		CommonMethod.uploadFile("WPRDocUpload", LegalfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("HsrReasonnarration", "Submitting Document");
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn","HsrGeneralLink");
		CommonMethod.WaitUntilPresence("HsrGeneralLink", 120);
		CommonMethod.RobustclickElementVisible("HsrGeneralLink", "HsrGeneralTable");
		CommonMethod.WaitUntilPresence("HsrGeneralTable", 120);
		CommonMethod.scrolldowntoElement("HsrGeneralTable");
		List<String> val = CommonMethod.fetchTableData("HsrGeneralTable");
		CommonMethod.softAssertContainsMessage(val.get(0), "SIGNED CERTIFICATION AGREEMENT", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Legal Document successfully**");	
	}
	public void validateAuditUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 60);
		CommonMethod.RobustclickElementVisible("HsrAddDoc","HsrDocType");
		CommonMethod.WaitUntilVisibility("HsrDocType", 60);
		CommonMethod.selectdropdownValue("HsrDocType", "audit");
		CommonMethod.click("HsrLocationRadiobutton");
		CommonMethod.selectdropdownValue("HsrType","2");
		CommonMethod.scrolldowntoElement("HsrType");
		CommonMethod.RobustclickElementVisible("HsrContainedDocument","HsrContainedDocumentOption");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick","OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 2).click();
		CommonMethod.selectdropdownrandom("HsrLocationVerificationDoc");
	    CommonMethod.uploadFile("WPRDocUpload", AuditfileUpload, "UploadFileVerifyScorecard");
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn","HsrAddDoc");
		CommonMethod.scrolldowntoElement("HsrAddDoc");
		CommonMethod.WaitUntilPresence("HsrAuditLinkTab", 120);
    	CommonMethod.RobustclickElementVisible("HsrAuditLinkTab", "HsrAuditTable");
		CommonMethod.WaitUntilPresence("HsrAddDoc", 120);
		CommonMethod.scrolldowntoElement("HsrAuditTable");
		List<String> val = CommonMethod.fetchTableData("HsrAuditTable");
		CommonMethod.softAssertContainsMessage(val.get(3), "Audit Document", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Audit Document successfully**");	
	}
	
	public void validateFeatureUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {		
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 60);
		CommonMethod.RobustclickElementVisible("HsrAddDoc","HsrDocType");
		CommonMethod.WaitUntilVisibility("HsrDocType", 60);
		CommonMethod.selectdropdownValue("HsrDocType", "feature");
		CommonMethod.click("HsrLocationRadiobutton");
		CommonMethod.selectdropdownValue("HsrType","2");
		CommonMethod.scrolldowntoElement("HsrType");
		CommonMethod.RobustclickElementVisible("HsrContainedDocument","HsrContainedDocumentOption");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick","OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 2).click();
		CommonMethod.selectdropdownrandom("HsrLocationVerificationDoc");
	    CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn","HsrAddDoc");
		CommonMethod.scrolldowntoElement("HsrAddDoc");
		CommonMethod.WaitUntilPresence("HsrLibraryLinkTab", 120);
    	CommonMethod.RobustclickElementVisible("HsrLibraryLinkTab", "HsrAuditTable");
		CommonMethod.WaitUntilPresence("HsrAddDoc", 120);
		CommonMethod.scrolldowntoElement("HsrAuditTable");
		List<String> val = CommonMethod.fetchTableData("HsrAuditTable");
		CommonMethod.softAssertContainsMessage(val.get(3), "On-site Photographs", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Audit Document successfully**");	
		
	}
	public void validateScorecardFilterResponse() throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("HsrScorecardResponseFilter", 120);
		CommonMethod.RobustclickElementVisible("HsrScorecardResponseFilter", "HsrScorecardYesPurseResponseFilterCbx");
		CommonMethod.WaitUntilPresence("HsrScorecardYesPurseResponseFilterCbx", 120);
		CommonMethod.clickListWebelementFromIndex("HsrScorecardYesPurseResponseFilterCbx", 0);
		int YesResponseCount = CommonMethod.ElementSize("V2ProjectWPRPFeature");
		CommonMethod.assertExpectedContainsActual(String.valueOf(YesResponseCount),"15","Scorecard Filter Response doesn't match");
		softAssert.assertAll();
		CommonMethod.refreshBrowser();
		testlog.pass("**Verifies Scorecard Filter Response successfully**");
	}
	
	public void validateScorecardFilterVerification() throws IOException, InterruptedException {	
		CommonMethod.WaitUntilPresence("HsrScorecardVerificationFilter", 120);
		CommonMethod.RobustclickElementVisible("HsrScorecardVerificationFilter", "HsrScorecardFilterSelectbyVerification");
		CommonMethod.WaitUntilPresence("HsrScorecardFilterSelectbyVerification", 120);
		CommonMethod.selectdropdownVisibletext("HsrScorecardFilterSelectbyVerification", "On-site Photographs");
		int FeatureCount = CommonMethod.ElementSize("V2ProjectWPRPFeature");
		CommonMethod.assertExpectedContainsActual(String.valueOf(FeatureCount),"4","Verification filter doesn't match");
		softAssert.assertAll();
		CommonMethod.refreshBrowser();
		testlog.pass("**Verifies Scorecard Filter Verification successfully**");
	}
	
	public void SearchHealthSafetyByStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrIdSearch","HsrIdSearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilPresence("HsrIdSearch", 60);
		CommonMethod.clearAndSendKey("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch","V2ProjectSearchResultIDVerify");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " +status);
		CommonMethod.assertExpectedContainsActual(status,"ACHIEVED","HealthSafety Search failed");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount),"1","HealthSafety Search failed");
		testlog.pass("**Verifies search filter status successfully**");
	}
	
	public void searchFilterDocumentHSR(String documentName, String filterOption, String fileCount)
			throws IOException, InterruptedException {
		if (filterOption.equalsIgnoreCase("Audit")) {
			CommonMethod.RobustclickElementVisible("HsrAuditLinkTab", "V2ProjectDecumentSearchBox");
			CommonMethod.WaitUntilVisibility("V2ProjectDecumentSearchBox", 60);
		}
		if (filterOption.equalsIgnoreCase("General")) {
			CommonMethod.RobustclickElementVisible("HsrGeneralLink","V2ProjectDecumentSearchBox");
			CommonMethod.WaitUntilVisibility("V2ProjectDecumentSearchBox", 60);
		}
		CommonMethod.WaitUntilVisibility("V2ProjectDecumentSearchBox", 60);
		CommonMethod.clearAndSendKey("V2ProjectDecumentSearchBox", documentName);
		CommonMethod.RobustclickElementVisible("HSRDocumentSearchButton","V2ProjectDecumentSearchBox");
		if (filterOption.equalsIgnoreCase("General")) {
			CommonMethod.WaitUntilVisibility("HSRDocumentGeneralFileCount", 60);
			int V2ProjectScoreDocCount = CommonMethod.ElementSize("HSRDocumentGeneralFileCount");
			String V2ProjectDocCounts = Integer.toString(V2ProjectScoreDocCount);
			CommonMethod.assertActualContainsExpected(V2ProjectDocCounts, fileCount);
		} else {
			CommonMethod.WaitUntilVisibility("V2ProjectDocumentGeneralFileCount", 60);
			int V2ProjectScoreDocCount = CommonMethod.ElementSize("V2ProjectDocumentGeneralFileCount");
			String V2ProjectDocCounts = Integer.toString(V2ProjectScoreDocCount);
			CommonMethod.assertActualContainsExpected(V2ProjectDocCounts, fileCount);
		}
		softAssert.assertAll();
		testlog.pass("**Verifies search filter successfully **");
	}
	
	public void ValidDashboardHsrField() throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("WellV2DashboardTab", 60);
		CommonMethod.WaitUntilPresence("WellV2ProjectDocumentTab", 30);
		CommonMethod.WaitUntilPresence("ScorecardTab", 30);
		CommonMethod.WaitUntilPresence("ReviewTab", 30);
		CommonMethod.WaitUntilPresence("V2ProjectSupportButton", 30);
		CommonMethod.WaitUntilPresence("AlternativesTab", 30);
		CommonMethod.WaitUntilPresence("LocationTab", 30);
		CommonMethod.WaitUntilPresence("ProfileTab", 30);
		CommonMethod.WaitUntilPresence("BiilingTab", 30);
		CommonMethod.WaitUntilPresence("TeamTab", 30);
		CommonMethod.WaitUntilPresence("PromotionTab", 30);
		CommonMethod.WaitUntilPresence("EditTab", 30);
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
}
}
