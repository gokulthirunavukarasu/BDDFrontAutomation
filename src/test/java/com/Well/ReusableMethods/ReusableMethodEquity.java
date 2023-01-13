package com.Well.ReusableMethods;

import java.io.IOException;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodEquity extends BaseClass {

	public void RegisterEquity(String SheetName, int rowNum) throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 120);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERstartNewProject");
		CommonMethod.WaitUntilVisibility("WERstartNewProject", 60);
		CommonMethod.RobustclickElementVisible("WERstartNewProject","WEREnrollOption");
		CommonMethod.RobustclickElementVisible("WEREnrollOption", "WERenrollbtn");
		CommonMethod.RobustclickElementVisible("WERenrollbtn", "WEROrgContinebtn");
		String ProjectName = "Automation WER Project" + CommonMethod.randomNumber(8000000);
		testlog.info("ProjectName: " + ProjectName);
		data.setCellData(SheetName, "projectName", rowNum, ProjectName);
		CommonMethod.RobustclickElementVisible("WEROrgContinebtn", "WEREnrollName");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.", "Organization Industry Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		CommonMethod.WaitUntilPresence("WEREnrollName",60);
		CommonMethod.sendKeys("WEREnrollName", ProjectName);
		CommonMethod.ClickCheckbox("WEROwnerInfocbx");
		String OwnerName = USfaker.address().firstName();
		CommonMethod.sendKeys("WEROrgName", OwnerName);
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdownValue("WEROwnerCountry", "US");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("WEROwnerCountry"));
		CommonMethod.selectdropdownrandom("WEROwnerState");
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Organization Address: " + ProjectAddress);
		testlog.info("Organization City: " + ProjectCity);
		testlog.info("Organization Postalcode: " + PostalCode);
		CommonMethod.sendKeys("WEROrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WEROrgCity", ProjectCity);
		CommonMethod.sendKeys("WEROrgPostalcode", PostalCode);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("WEROwnerCountry"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getattributeValue("WEROwnerState"));
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WEROrgAddress"));
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WEROrgCity"));
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WEROrgPostalcode"));
		CommonMethod.ClickCheckbox("WEROwnercbx");
		CommonMethod.scrolldowntoElement("WEROwnercbx");
		CommonMethod.WaitUntilPresence("WEROrgContinebtn",60);
		CommonMethod.RobustclickElementVisible("WEROrgContinebtn", "WEROwnerRegContinuebtn");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn","WERBehalfCbx");
		CommonMethod.negativesoftassertPageSource("On behalf of owner is required.", "Owner CheckBox Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Is the Owner organization an IWBI member?* is required.", "Owner Organization Name Error Mismatch");
		CommonMethod.ClickCheckbox("WERBehalfCbx");
		CommonMethod.selectdropdownVisibletext("WERSelectMember", "No");
		data.setCellData(SheetName, "WERSelectMember", rowNum,
	    CommonMethod.getSelectedDropdownValue("WERSelectMember"));
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn","WERlocations");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.sendKeys("WERlocations", "10");
		data.setCellData(SheetName, "WERlocations", rowNum, CommonMethod.getattributeValue("WERlocations"));
		CommonMethod.RobustclickElementVisible("WERlocationsSpacetype","WERlocationsSpaceOption");
		CommonMethod.RobustclickElementVisible("WERlocationsSpaceOption","WERlocationsize");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		testlog.info("Locationsize: " + Area);
		CommonMethod.clearAndSendKey("WERlocationsize", Area);
		data.setCellData(SheetName, "WERlocationsize", rowNum, CommonMethod.getattributeValue("WERlocationsize"));
		CommonMethod.WaitUntilClickble("WEROwnerRegContinuebtn", 60);
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn", "WERReviewContinuebutton");
		if (CommonMethod.isElementsExist("WERYesMyOrganizationCbx", 2)) {
			CommonMethod.WaitUntilClickble("WERYesMyOrganizationCbx", 30);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
		}
		CommonMethod.RobustclickElementVisible("WERReviewContinuebutton", "WERtermContinuebutton");
		if (CommonMethod.isElementsExist("WERProgramFeePublicrbtn", 20)) {
			CommonMethod.WaitUntilClickble("WERProgramFeePublicrbtn", 60);
			CommonMethod.ClickCheckbox("WERProgramFeePublicrbtn");
		}
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilClickble("WERAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("WERAcknowledecbx");
		CommonMethod.RobustclickElementVisible("WERtermContinuebutton", "BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void StoreIdEquity(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("WPRHsrPortfolioDashboard", 180);
		CommonMethod.WaitUntilVisibility("StoreId", 30);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getWprId = stringArray[1].trim();
		testlog.info("Equity Id: " + getWprId);
		data.setCellData(SheetName, "ProjectID", rowNum, getWprId);
		testlog.info("Equity ID: " + getWprId);
		testlog.pass("**Stored the Registered id  into excel successfully**");
	}
	
	public void SearchEquityByID(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERIdClick");
		String werId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Equity ID: " + werId);
		CommonMethod.WaitUntilClickble("WERId", 60).sendKeys(werId);
		CommonMethod.RobustclickElementVisible("WERApplybtn","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Equity Search failed");
		CommonMethod.assertcontainsmessage("WERIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("WERIdClick","WERDashboard");
		CommonMethod.WaitUntilVisibility("WERDashboard", 300);
		testlog.pass("**Verifies the Search Equity ByID successfully**");
	}
	
	public void ValidDashboardWerField(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("WellV2DashboardTab", 60);
		CommonMethod.WaitUntilPresence("DocumentLibraryTab", 30);
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
	
	public void SearchEquityByRegisterStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERIdClick");
		String werId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Equity ID: " + werId);
		CommonMethod.WaitUntilClickble("WERId", 60).sendKeys(werId);
		CommonMethod.RobustclickElementVisible("WERApplybtn","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Equity Search failed");
		CommonMethod.assertcontainsmessage("WERIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " +status);
		CommonMethod.assertExpectedContainsActual(status,"REGISTERED","Performance Search failed");
		CommonMethod.RobustclickElementVisible("WERIdClick","WERDashboard");
		CommonMethod.WaitUntilVisibility("WERDashboard", 300);
		testlog.pass("**Verifies the Search Equity ByID successfully**");
	}
	
	public void WerProjectFieldValidationTest(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 120);
		CommonMethod.RobustclickElementVisible("EditTab","HsrWprOrganizationInformation");
		CommonMethod.WaitUntilVisibility("HsrWprOrganizationInformation", 60);
		CommonMethod.RobustclickElementVisible("HsrWprOrganizationInformation","HsrWprEditProjectName");
		CommonMethod.WaitUntilVisibility("HsrWprEditProjectName", 30);
		testlog.info("projectName: " + data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditProjectName"),
				data.getCellData(SheetName, "projectName", rowNum), "Project Name doesn't match");
		testlog.info("WPRlocationsize: " + data.getCellData(SheetName, "WPRlocationsize", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditArea").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "WERlocationsize", rowNum), "Area doesn't match");
		testlog.info("WPRlocations: " + data.getCellData(SheetName, "WPRlocations", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditLocation"),
				data.getCellData(SheetName, "WERlocations", rowNum), "Location count doesn't match");
		testlog.info("OrgName: " + data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "OrgName doesn't match");
		testlog.info("OrgIndustry: " + data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("HsrWprEditOrgIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "OrgIndustry doesn't match");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("HsrWprEditCountry"));
		  CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownAttribute(
		  "HsrWprEditCountry"), data.getCellData(SheetName, "Country", rowNum),
		  "Country doesn't match");
		 testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("HsrWprEditState"),
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
        testlog.pass("**Verifies the WELL Equity Field Validation successfully**");
	}
	
	public void CompleteScorecardWerById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ScorecardTab", 300);
		CommonMethod.RobustclickElementVisible("ScorecardTab","WPRPortfolioScorecardLanding");
		CommonMethod.WaitUntilVisibility("WPRPortfolioScorecardLanding", Scorecardtimeout);
		performance.ScorecardfillHSRWPR(21, 21, 49, 29, "WPRPurseYes", "WPRPurseNo");
		testlog.pass("**Verifies the 21 Purse Yes Scorecard Equity successfully**");
	}

	public void UploadWERDocForFeature(int LastFeatureNumber) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRPortfolioScorecardLanding", Scorecardtimeout);
		performance.uploadDocumentInFeature(LastFeatureNumber);
		testlog.pass("**Upload 21 Scorecard Documents successfully**");
	}
	
	public void WERSubmitReview(String SheetName, int rowNum, String ReviewName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab","WPRReviewSubmitbtn");
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitbtn","WPRReviewProjectPhase");
		CommonMethod.selectdropdownVisibletext("WPRReviewProjectPhase", ReviewName);
		CommonMethod.WaitUntilClickble("WPRReviewComment", 60).sendKeys(ReviewName);	
		CommonMethod.WaitUntilVisibility("WPRReviewSubmitDocbtn", 30);
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitDocbtn","ReviewViewButton");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 60);
		testlog.pass("**Submitted Preliminary Precertification Review successfully**");
	}
	public void WERCompleteReview(String SheetName, int rowNum, String ReviewName) throws IOException, InterruptedException {
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar","AdminWELLEquityNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLEquityNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminWELLEquityNavBar", "WPRAdminIdSearch");
		CommonMethod.WaitUntilClickble("WPRAdminIdSearch", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("WPRAdminApplybtn","WPRAdminIdClick");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("WPRAdminIdClick", data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("WPRAdminIdClick","WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 300);
		CommonMethod.RobustclickElementVisible("ReviewTab","ReviewViewButton");
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		CommonMethod.RobustclickElementVisible("ReviewViewButton","ReviewReturnButton");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 60);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton","ReturnComment");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys(ReviewName);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("DatePickerButton","DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","ReviewPaymentstatusRadio");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("ReviewPaymentstatusRadio","ReviewReturnSubmit");
		CommonMethod.WaitUntilPresence("AwardedDate", 120);
		CommonMethod.RobustclickElementVisible("AwardedDate","DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","ReviewReturnSubmit");
		CommonMethod.RobustclickElementVisible("ReviewReturnSubmit", "ReviewedStatus");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status successfully");
		testlog.pass("**Completed Reviewing Preliminary Precertification Review successfully**");
	}
	
	public void validateTeamsWER(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 120);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERIdClick");
		String werId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Equity ID: " + werId);
		CommonMethod.WaitUntilClickble("WERId", 60).sendKeys(werId);
		CommonMethod.RobustclickElementVisible("WERApplybtn","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Equity Search failed");
		CommonMethod.assertcontainsmessage("WERIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		testlog.pass("**Verifies the Search Equity ByID can access the Project successfully**");
	}
	
	public void SearchEquityByAchievedStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERIdClick");
		String werId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Equity ID: " + werId);
		CommonMethod.WaitUntilPresence("WPRId", 60);
		CommonMethod.clearAndSendKey("WPRId", werId);
		CommonMethod.RobustclickElementVisible("WERApplybtn","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Equity Search failed");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount),"1","Performance Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.RobustclickElementVisible("WPRApplybtn","V2ProjectSearchResultIDVerify");
		int ProjectCount1 = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount1),"1","Performance Search Count failed");
		CommonMethod.assertcontainsmessage("WERIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " +status);
		CommonMethod.assertExpectedContainsActual(status,"ACHIEVED","Performance Search failed");
		testlog.pass("**Verifies the Search Equity Achieved Status successfully**");
	}
}
