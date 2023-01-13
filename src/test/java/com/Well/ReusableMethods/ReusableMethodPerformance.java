package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodPerformance extends BaseClass {
	public void RegisterPerformance(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLPerformanceRatingNavBar");
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar","WPRstartNewProject");
		CommonMethod.WaitUntilVisibility("WPRstartNewProject", 60);
		CommonMethod.RobustclickElementVisible("WPRstartNewProject","WPREnrollOption");
		CommonMethod.RobustclickElementVisible("WPREnrollOption", "WPRenrollbtn");
		CommonMethod.RobustclickElementVisible("WPRenrollbtn", "WPROrgContinebtn");
		String ProjectName = "Automation WPR Project" + CommonMethod.randomNumber(8000000);
		testlog.info("ProjectName: " + ProjectName);
		data.setCellData(SheetName, "projectName", rowNum, ProjectName);
		CommonMethod.RobustclickElementVisible("WPROrgContinebtn", "WPROrgName");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.", "Organization Industry Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		CommonMethod.sendKeys("WPROrgName", ProjectName);
		CommonMethod.ClickCheckbox("WPROwnerInfocbx");
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdownValue("WPRExamOwnerCountry", "US");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("WPRExamOwnerState");
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Organization Address: " + ProjectAddress);
		testlog.info("Organization City: " + ProjectCity);
		testlog.info("Organization Postalcode: " + PostalCode);
		CommonMethod.sendKeys("WPRExamOrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WPRExamOrgCity", ProjectCity);
		CommonMethod.sendKeys("WPRExamOrgPostalcode", PostalCode);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("WPRExamOwnerCountry"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getattributeValue("WPRExamOwnerState"));
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WPRExamOrgAddress"));
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WPRExamOrgCity"));
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WPRExamOrgPostalcode"));
		CommonMethod.ClickCheckbox("WPROwnercbx");
		CommonMethod.scrollDown();
		CommonMethod.RobustclickElementVisible("WPROrgContinebtn", "WPROwnerRegContinuebtn");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn","WPRBehalfCbx");
		CommonMethod.negativesoftassertPageSource("On behalf of owner is required.", "Owner CheckBox Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Is the Owner organization an IWBI member?* is required.", "Owner Organization Name Error Mismatch");
		CommonMethod.ClickCheckbox("WPRBehalfCbx");
		CommonMethod.selectdropdownVisibletext("WPRSelectMember", "No");
		data.setCellData(SheetName, "WPRSelectMember", rowNum,
				CommonMethod.getSelectedDropdownValue("WPRSelectMember"));
		CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn","WPRlocations");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.sendKeys("WPRlocations", "10");
		data.setCellData(SheetName, "WPRlocations", rowNum, CommonMethod.getattributeValue("WPRlocations"));
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpacetype","HsrWPRlocationsSpaceOption");
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpaceOption","WPRlocationsize");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		testlog.info("Locationsize: " + Area);
		CommonMethod.clearAndSendKey("WPRlocationsize", Area);
		data.setCellData(SheetName, "WPRlocationsize", rowNum, CommonMethod.getattributeValue("WPRlocationsize"));
		CommonMethod.WaitUntilClickble("WPROwnerRegContinuebtn", 60);
		CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn", "WPRReviewContinuebutton");
		if (CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 2)) {
			CommonMethod.RobustclickElementVisible("WPRReviewContinuebutton", "HsrWPRYesMyOrganizationCbx");
			CommonMethod.negativesoftassertPageSource("Yes, my organization meets the criteria of the listed discount category.* is required.", "My Organization CheckBox Error Name");
			CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 30);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
		}
		CommonMethod.RobustclickElementVisible("WPRReviewContinuebutton", "WPRtermContinuebutton");
		if (CommonMethod.isElementsExist("WPRProgramFeePublicrbtn", 20)) { 
			
			CommonMethod.WaitUntilClickble("WPRProgramFeePublicrbtn", 60);
			CommonMethod.ClickCheckbox("WPRProgramFeePublicrbtn");
		}
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilClickble("WPRAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("WPRAcknowledecbx");
		CommonMethod.RobustclickElementVisible("WPRtermContinuebutton", "BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void StoreIdPerformance(String SheetName, int rowNum) throws IOException, InterruptedException {
		if (CommonMethod.isElementsExist("HsrIframe", 60)) {
		CommonMethod.WaitUntilPresence("HsrIframe", 180);
		CommonMethod.switchToFrame("HsrIframe");
		CommonMethod.WaitUntilPresence("HsrCloseCard", 60);
		CommonMethod.Robustclick("HsrCloseCard");
		CommonMethod.switchToParentFrame();	
		}
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 300);
		CommonMethod.WaitUntilVisibility("StoreId", 30);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getWprId = stringArray[1].trim();
		testlog.info("Performance Id: " + getWprId);
		data.setCellData(SheetName, "ProjectID", rowNum, getWprId);
		testlog.info("Performance ID: " + getWprId);
		testlog.pass("**Stored the Registered id  into excel successfully**");
	}

	public void SearchPerformanceByID(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(wprId);
		CommonMethod.RobustclickElementVisible("WPRApplybtn","V2ProjectSearchResultIDVerify");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount),"1","HealthSafety Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.RobustclickElementVisible("WPRApplybtn","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Portfolio Search failed");
		CommonMethod.assertcontainsmessage("WPRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("WPRIdClick","WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 300);
		testlog.pass("**Verifies the Search Performance ByID successfully**");
	}

	public void SearchPerformanceFilterStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(wprId);
		CommonMethod.RobustclickElementVisible("WPRApplybtn","V2ProjectSearchResultIDVerify");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount),"1","HealthSafety Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.RobustclickElementVisible("WPRApplybtn","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Portfolio Search failed");
		CommonMethod.assertcontainsmessage("WPRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " +status);
		CommonMethod.assertExpectedContainsActual(status,"REGISTERED","Performance Search failed");
		CommonMethod.RobustclickElementVisible("WPRIdClick","WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 300);
		testlog.pass("**Verifies the Search Performance ByID successfully**");
	}
	
	public void ValidDashboardWprField(String SheetName, int rowNum) throws IOException, InterruptedException {
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
	
	public void ScorecardfillHSRWPR(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne, String purseYes,
			String purseNo) throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		YesButton = CommonMethod.findElements(purseYes);
		for (int i = 1; i <= YesEnd; i++) {
			int RemainingYes = YesButton.size();
			do {
				CommonMethod.WaitUntilClickble(purseYes, 60);
				CommonMethod.click(purseYes);
				CommonMethod.WaitUntilVisibility("WPRCloseIcon", 120);
				CommonMethod.WaitUntilInVisibility("WPRCloseIcon",60);
				YesButton = CommonMethod.findElements(purseYes);
			} while (YesButton.size() == RemainingYes);
			RemainingYes--;
		}
		NoButton = CommonMethod.findElements(purseNo);
		int j = DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			do {
				CommonMethod.WaitUntilClickble(NoButton.get(RemainingNo - j), 30);
				CommonMethod.click(NoButton.get(RemainingNo - j));
				CommonMethod.WaitUntilVisibility("WPRCloseIcon", 120);
				CommonMethod.WaitUntilInVisibility("WPRCloseIcon", 60);
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements(purseNo);
			} while (NoButton.size() == RemainingNo);
			RemainingNo--;
			j--;
		}
	}

	public void CompleteScorecardWprById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ScorecardTab", 300);
		CommonMethod.RobustclickElementVisible("ScorecardTab","WPRPortfolioScorecardLanding");
		CommonMethod.WaitUntilVisibility("WPRPortfolioScorecardLanding", Scorecardtimeout);
		ScorecardfillHSRWPR(21, 21, 36, 16, "WPRPurseYes", "WPRPurseNo");
		testlog.pass("**Verifies the 15 Purse Yes Scorecard Performance successfully**");
	}

	public void uploadDocumentInFeature(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
		for (WebElement f : Feature) {
			CommonMethod.WaitUntilClickble(f, 120);
			CommonMethod.JavascriptClickElement(f);
			CommonMethod.WaitUntilVisibility("WPRVerficationTab", 60);
			CommonMethod.RobustclickElementVisible("WPRVerficationTab","WPRAddOption");
			CommonMethod.WaitUntilVisibility("WPRAddOption", 60);
			CommonMethod.JavascriptClickElement("WPRAddOption");
			CommonMethod.WaitUntilVisibility("WPRAddOptionbtn", 60);
			CommonMethod.Robustclick("WPRAddOptionbtn");
			CommonMethod.WaitUntilPresence("WPRAddOptionCloseIcon", 120);
			CommonMethod.Robustclick("WPRAddOptionCloseIcon");
			CommonMethod.WaitUntilVisibility("WPRAssignLocbtn", 60);
			Thread.sleep(1000);
			CommonMethod.RobustclickElementVisible("WPRAssignLocbtn","WPRAssignLocCbx");
			CommonMethod.WaitUntilPresence("WPRAssignLocCbx", 60);
			CommonMethod.Robustclick("WPRAssignLocCbx", "WPRAssignDisabledbtn");
			CommonMethod.WaitUntilVisibility("WPRAssignSavebtn", 60);
			CommonMethod.RobustclickElementVisible("WPRAssignSavebtn","WPRUploadDocTaskbtn");
			CommonMethod.WaitUntilVisibility("WPRUploadDocTaskbtn", 60);
			CommonMethod.RobustclickElementVisible("WPRUploadDocTaskbtn","WPRDocUpload");
			CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
			CommonMethod.WaitUntilPresence("WPRUploadDocTaskSavebtn", 120);
			CommonMethod.Robustclick("WPRUploadDocTaskSavebtn");
			CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
			CommonMethod.JavascriptClickElement(f);
		}

	}

	public void AudituploadDocumentInFeature(String SheetName, String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		testlog.info("Fetching total no. of credits on page");
		CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
		if(SheetName.equalsIgnoreCase("Wer"))  {
			CommonMethod.RobustclickElementVisible("WERScorecardEB3Feature","PortfolioScorecardPursueToast");
		}
		if(SheetName.equalsIgnoreCase("Wpr"))  {
			CommonMethod.RobustclickElementVisible("WPRScorecardPX5","PortfolioScorecardPursueToast");
		}
		CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 60);
		CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		testlog.info("**Verifies Response selection Yes Toaster message successful**");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.click(ele);
			CommonMethod.WaitUntilVisibility("WPRVerficationTab", 60);
			CommonMethod.RobustclickElementVisible("WPRVerficationTab","WPRAddOption");
			CommonMethod.WaitUntilVisibility("WPRAddOption", 60);
			CommonMethod.JavascriptClickElement("WPRAddOption");
			CommonMethod.WaitUntilVisibility("WPRAddOptionbtn", 60);
			CommonMethod.Robustclick("WPRAddOptionbtn");
			CommonMethod.WaitUntilVisibility("WPRAddOptionCloseIcon", 60);
			CommonMethod.Robustclick("WPRAddOptionCloseIcon");
			CommonMethod.WaitUntilVisibility("WPRAssignLocbtn", 30);
			Thread.sleep(1000);
			CommonMethod.RobustclickElementVisible("WPRAssignLocbtn","WPRAssignLocCbx");
			CommonMethod.WaitUntilPresence("WPRAssignLocCbx", 60);
			CommonMethod.Robustclick("WPRAssignLocCbx", "WPRAssignDisabledbtn");
			CommonMethod.WaitUntilVisibility("WPRAssignSavebtn", 30);
			CommonMethod.RobustclickElementVisible("WPRAssignSavebtn","WPRUploadDocTaskbtn");
			CommonMethod.WaitUntilVisibility("WPRUploadDocTaskbtn", 60);
			if(SheetName.equalsIgnoreCase("Wer"))  {
				CommonMethod.RobustclickElementVisible("WPRUploadDocAditTaskbtn","WPRScorecardFeatureName");
			}
			if(SheetName.equalsIgnoreCase("Wpr"))  {
				CommonMethod.RobustclickElementVisible("WPRUploadDocTaskbtn","WPRScorecardFeatureName");
			}
			CommonMethod.scrolldowntoElement("WPRScorecardFeatureName");
			CommonMethod.RobustclickElementVisible("WPRScorecardConfirmLocation","WPRAssignLocCbx");
			CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
			CommonMethod.RobustclickElementVisible("WPRScorecardVerifyTaskUploadEditLocationsUpdateButton", "WPRDocUpload");
			CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload);
			CommonMethod.RobustclickElementVisible("WPRUploadDocTaskSavebtn","PortfolioScorecardDocumentUploadTable");
			if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
			}
			
			}
		}
	}
	public void UploadWPRDocForFeature() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRPortfolioScorecardLanding", Scorecardtimeout);
		uploadDocumentInFeature(21);
		testlog.pass("**Upload 21 Scorecard Documents successfully**");
	}

	public void SubmitWPRReview(String SheetName, int rowNum, String ReviewName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("ReviewTab", 120);
		CommonMethod.RobustclickElementVisible("ReviewTab","WPRReviewSubmitbtn");
		CommonMethod.WaitUntilPresence("WPRReviewSubmitbtn", 120);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("WPRReviewSubmitbtn", 120);
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitbtn","WPRReviewProjectPhase");
		CommonMethod.WaitUntilPresence("WPRReviewProjectPhase", 120);
		testlog.info("ReviewName: "+ReviewName);
		CommonMethod.selectdropdownValue("WPRReviewProjectPhase", ReviewName);
		CommonMethod.WaitUntilClickble("WPRReviewComment", 60).sendKeys(ReviewName);
		CommonMethod.WaitUntilPresence("WPRReviewSubmitDocbtn", 30);
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitDocbtn","Table");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 120);
		CommonMethod.WaitUntilPresence("Table", 300);
		testlog.pass("**Submitted Performance Review successfully**");
	}
	public void ClickBilling() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 120);
		CommonMethod.RobustclickElementVisible("BiilingTab", "BillingProjectInvoice");
		CommonMethod.WaitUntilPresence("BillingProjectInvoice", 120);
		CommonMethod.RobustclickElementVisible("BillingProjectInvoice", "BillingCurativeAction");
		CommonMethod.WaitUntilPresence("BillingCurativeAction", 120);
		CommonMethod.RobustclickElementVisible("BillingCurativeAction", "V2ProjectPreBillingPayNowButton");
		CommonMethod.WaitUntilPresence("V2ProjectPreBillingPayNowButton", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectPreBillingPayNowButton", "BillingLanding");
		CommonMethod.WaitUntilPresence("BillingLanding", 120);
		testlog.pass("**Nagavited to Billing successfully**");
	}
	
	public void CompleteWPRReview(String SheetName, int rowNum, String ReviewName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("AdminNavBar", 120);
		CommonMethod.RobustclickElementVisible("AdminNavBar","AdminWELLPerformanceNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLPerformanceNavBar", 120);
		CommonMethod.RobustclickElementVisible("AdminWELLPerformanceNavBar", "WPRAdminIdSearch");
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
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.RobustclickElementVisible("ReviewReturnSubmit", "ReviewedStatus");
		Thread.sleep(2000);
		CommonMethod.WaitUntilPresence("ReviewedStatus", 300);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status successfully");
		testlog.pass("**Completed Performance Review successfully**");
	}
	public void WprProjectFieldValidationTest(String SheetName, int rowNum) throws Exception {
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
				data.getCellData(SheetName, "WPRlocationsize", rowNum), "Area doesn't match");
		testlog.info("WPRlocations: " + data.getCellData(SheetName, "WPRlocations", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditLocation"),
				data.getCellData(SheetName, "WPRlocations", rowNum), "Location count doesn't match");
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
        testlog.pass("**Verifies the Wpr Field Validation successfully**");
	}
	
	public void validateTeamsWPR(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(wprId);
		CommonMethod.RobustclickElementVisible("WPRApplybtn","WELLPerformanceRatingNavBar");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("WELLPerformanceRatingNavBar", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Portfolio Search failed");
		CommonMethod.assertcontainsmessage("WPRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		testlog.pass("**Verifies user able to access the invited project**");
	}
	public void clikOnDocumentLibrary() throws InterruptedException, IOException {
		CommonMethod.WaitUntilPresence("DocumentLibraryTab", 300);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab","WPRUploadDocLib");
	}
	public void validateGeneralUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("WPRUploadDocLib", 120);
		CommonMethod.RobustclickElementVisible("WPRUploadDocLib","WPRSelectDocType");
		CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
		CommonMethod.selectdropdownValue("WPRSelectDocType", "general");
		CommonMethod.selectdropdownrandom("WPRHSRDocumentType");
		CommonMethod.scrollDown();
		CommonMethod.uploadFile("WPRDocUpload", GeneralfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WPRHSRAddNote", "Submitting Document");
		CommonMethod.Robustclick("WPRSumbitUploadDocLib");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "General", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload General Document successfully**");	
	}
	public void validateLegalUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("WPRUploadDocLib", 120);
		CommonMethod.RobustclickElementVisible("WPRUploadDocLib","WPRSelectDocType");
		CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
		CommonMethod.selectdropdownValue("WPRSelectDocType", "legal");
		CommonMethod.selectdropdownrandom("WPRHSRDocumentType");
		CommonMethod.scrollDown();
		CommonMethod.uploadFile("WPRDocUpload", LegalfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WPRHSRAddNote", "Submitting Document");
		CommonMethod.Robustclick("WPRSumbitUploadDocLib");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Legal", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Legal Document successfully**");	
	}
	public void validateAuditUploadDocument(String SheetName, int rowNum, String Featurename) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("WPRUploadDocLib", 120);
		CommonMethod.RobustclickElementVisible("WPRUploadDocLib","WPRSelectDocType");
		CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
		CommonMethod.selectdropdownValue("WPRSelectDocType", "audit");
		CommonMethod.WaitUntilPresence("WPRHSRDocumentType", 60);
		CommonMethod.WaitUntilPresence("WPRHSRDocumentType", 60);
		CommonMethod.selectdropdownVisibletext("WPRHSRDocumentType","Technical Document (Audited)");
		CommonMethod.WaitUntilPresence("WPRSelectFeaturePart", 60);
		CommonMethod.scrolldowntoElement("WPRHSRDocumentType");
		CommonMethod.selectdropdownVisibletext("WPRSelectFeaturePart",Featurename);
		CommonMethod.scrolldowntoElement("WPRSelectFeaturePart");
		CommonMethod.WaitUntilPresence("WPRAddPartButton", 60);
		CommonMethod.Robustclick("WPRAddPartButton","WPRSelectFeaturePart");
		CommonMethod.WaitUntilPresence("WPRDocUpload", 60);
		CommonMethod.uploadFile("WPRDocUpload", AuditfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WPRHSRAddNote", "Submitting Document");
		CommonMethod.WaitUntilPresence("WPRSumbitUploadDocLib", 60);
		CommonMethod.Robustclick("WPRSumbitUploadDocLib");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Audit", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Audit Document successfully**");	
	}
	public void validateFeatureUploadDocument(String SheetName, int rowNum, String Featurename) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("WPRUploadDocLib", 120);
		CommonMethod.RobustclickElementVisible("WPRUploadDocLib","WPRSelectDocType");
		CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
		CommonMethod.selectdropdownValue("WPRSelectDocType", "feature");
		CommonMethod.WaitUntilPresence("WPRHSRDocumentType", 60);
		CommonMethod.selectdropdownVisibletext("WPRHSRDocumentType","Policy and/or Operations Schedule");
		CommonMethod.WaitUntilPresence("WPRSelectFeaturePart", 60);
		CommonMethod.scrolldowntoElement("WPRSelectFeaturePart");
		CommonMethod.selectdropdownVisibletext("WPRSelectFeaturePart",Featurename);
		CommonMethod.WaitUntilPresence("WPRAddPartButton", 60);
		CommonMethod.Robustclick("WPRAddPartButton","WPRSelectFeaturePart");
		CommonMethod.WaitUntilPresence("WPRConfirmLocation", 60);
		CommonMethod.RobustclickElementVisible("WPRConfirmLocation","WPRAssignLocCbx");
		CommonMethod.ClickCheckbox("WPRAssignLocCbx");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAssignLocSavebtn","WPRDocUpload");
		CommonMethod.scrollDown();
		CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WPRHSRAddNote", "Submitting Document");
		CommonMethod.Robustclick("WPRSumbitUploadDocLib");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Feature", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Feature Document successfully**");		
	}
	
	public void searchFilterScoreCard(String FeatureName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("V2ProjectScoreCardSearchBox", 60);
		CommonMethod.sendKeys("V2ProjectScoreCardSearchBox", FeatureName);
		CommonMethod.WaitUntilPresence("V2ProjectWPRPFeature", 60);
		testlog.info(FeatureName+ ": " + FeatureName);
		CommonMethod.assertActualContainsExpected(CommonMethod.getText("V2ProjectWPRPFeature"),FeatureName);
		CommonMethod.softAssertEqualsMessage(Integer.toString(CommonMethod.ElementSize("V2ProjectWPRPFeature")), "1", "YesPurseCount doesn't match");
		softAssert.assertAll();
		CommonMethod.refreshBrowser();
		testlog.pass("**Verifies Search filter successfully**");
	}
	
	public void verifyScoreCardFilter(String SheetName, String filterName, String expectedResult, int filterIndex, int checkboxIndex)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("V2ProjectScoreCardFilterButton", 180);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
		CommonMethod.clickOnListWebelementFromIndex("V2ProjectScoreCardFilterOption", filterIndex);
		CommonMethod.clickListWebelementFromIndex("V2ProjectScoreCardFilterOptionCheckBox", checkboxIndex);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "V2ProjectScoreCardFilterButton");
		if (filterName.equalsIgnoreCase("Response")) {
			CommonMethod.WaitUntilPresence("WPRValidPurseYes", 60);
			int YesFeature = CommonMethod.ElementSize("WPRValidPurseYes");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info(filterName+ ": " + actualYesFeatureCount);
			CommonMethod.softAssertEqualsMessage(actualYesFeatureCount, expectedResult, "YesPurseCount doesn't match");
		}
		if (filterName.equalsIgnoreCase("Verification") || filterName.equalsIgnoreCase("Document Scale")) {
			CommonMethod.WaitUntilInVisibility("WPRValidTotalFeature", 120);
			CommonMethod.WaitUntilPresence("WPRValidVerification", 60);
		int FeatureCount = CommonMethod.ElementSize("V2ProjectWPRPFeature");
		String actualYesFeatureCount = Integer.toString(FeatureCount);
		testlog.info(filterName+": " + actualYesFeatureCount);
		CommonMethod.softAssertEqualsMessage(actualYesFeatureCount, expectedResult, "Feature Count doesn't match");
		}
		CommonMethod.refreshBrowser();
		softAssert.assertAll();
		testlog.pass("**Verifies filter " + filterName + " options successfully**");
	}
	
	public void SearchPerformanceByStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilPresence("WPRId", 60);
		CommonMethod.clearAndSendKey("WPRId", wprId);
		CommonMethod.RobustclickElementVisible("WPRApplybtn","V2ProjectSearchResultIDVerify");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount),"1","Performance Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.RobustclickElementVisible("WPRApplybtn","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Performance Search Count failed");
		CommonMethod.RobustclickElementVisible("WPRApplybtn","V2ProjectSearchResultIDVerify");
		int ProjectCount1 = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount1),"1","Performance Search Count failed");
		CommonMethod.assertcontainsmessage("WERIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " +status);
		CommonMethod.assertExpectedContainsActual(status,"ACHIEVED","Performance Search failed");
		CommonMethod.RobustclickElementVisible("WPRIdClick","WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 300);
		testlog.pass("**Verifies the Search Performance Status successfully**");
	}
}
