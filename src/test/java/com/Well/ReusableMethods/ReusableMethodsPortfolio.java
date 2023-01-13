package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsPortfolio extends BaseClass {

	public void RegisterPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellAtScaleNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioCreateAccountButton");
		CommonMethod.WaitUntilVisibility("PortfolioCreateAccountButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountButton", "PortfolioAccountName");
		String AccountName = "Automation portfolio " + CommonMethod.randomNumber(8000000);
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 30);
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountSubmit", "PortfolioAccountName");
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 60);
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.",
				"Organization Industry Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Locations Questionaire is required.",
				"Locations Questionaire Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Total number of assets is required.",
				"Total number of assets Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Number of locations is required.",
				"Number of locations Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Area is required.", "Area Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Area in Meter is required.", "Area in Meter Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Primary Locations is required.", "Primary Locations Error Mismatch");
		CommonMethod.negativesoftassertPageSource("SpaceTypes is required.", "SpaceTypes Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 120);
		CommonMethod.sendKeys("PortfolioAccountName", AccountName);
		data.setCellData(SheetName, "AccountName", rowNum, AccountName);
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		testlog.info("OrgIndustry: " + data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.ClickCheckbox("PortfolioNotSureRadio");
		CommonMethod.sendKeys("PortfolioNumberOfLocation", "15");
		data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("PortfolioNumberOfLocation"));
		testlog.info("PortfolioNumberOfLocation: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.sendKeys("PortfolioEstimatedNumberOfLocation", "10");
		data.setCellData(SheetName, "EstimatedNumberOfLocation", rowNum,
				CommonMethod.getattributeValue("PortfolioEstimatedNumberOfLocation"));
		testlog.info("EstimatedNumberOfLocation: " + data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum));
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		CommonMethod.sendKeys("PortfolioGrossAreaSQFT", Area);
		data.setCellData(SheetName, "AreaSQFT", rowNum, CommonMethod.getattributeValue("PortfolioGrossAreaSQFT"));
		testlog.info("PortfolioGrossAreaSQFT: " + data.getCellData(SheetName, "AreaSQFT", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioPrimarlyLocated");
		CommonMethod.RobustclickElementVisible("PortfolioPrimarlyLocated", "SelectOwnerOrg");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.RobustclickElementVisible("SelectOwnerOrg", "PortfolioSpaceType");
		CommonMethod.RobustclickElementVisible("PortfolioSpaceType", "PortfolioSelectSpaceType");
		CommonMethod.RobustclickElementVisible("PortfolioSelectSpaceType", "PortfolioOwnerCountry");
		CommonMethod.selectdropdownValue("PortfolioOwnerCountry", "US");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerCountry"));
		testlog.info("PortfolioOwnerCountry: " + data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioOwnerState", 10);
		CommonMethod.selectdropdownrandom("PortfolioOwnerState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerState"));
		testlog.info("PortfolioOwnerCountry: " + data.getCellData(SheetName, "State", rowNum));
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("PortfolioOwnerStreetAddress", ProjectAddress1);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("PortfolioOwnerStreetAddress"));
		testlog.info("PortfolioOwnerStreetAddress: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("PortfolioOwnerCity"));
		testlog.info("PortfolioOwnerCity: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPostalCode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountSubmit", "WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getProjectId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getProjectId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
		testlog.pass("**Verifies the Registration successful**");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void SearchPortfolioById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellAtScaleNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("Portfolio Name:" + data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var), "1", "Portfolio Search failed");
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify", "WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Search Portfolio Name successfully**");
	}

	public void SignAgreementPortfolio() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("PortfolioClickSignNow", 60);
		CommonMethod.Robustclick("PortfolioClickSignNow");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Portfolio Sign Agreement successfully**");
	}

	public void SubscribePortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("SubscribeTab", 30);
		CommonMethod.RobustclickElementVisible("SubscribeTab", "PortfolioAccountValidName");
		String OwnerName = USfaker.address().firstName();
		String OwnerEmail = USfaker.internet().emailAddress();
		String OwnerPhone = USfaker.number().digits(10);
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton", "PortfolioOwnerName");
		CommonMethod.WaitUntilPresence("PortfolioOwnerName", 120);
		CommonMethod.scrolldowntoElement("PortfolioOwnerName");
		CommonMethod.negativesoftassertPageSource("Owner Name is required.", "Owner Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner Email is required.", "Owner Email Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner Phone is required.", "Owner Phone Error Mismatch");
		CommonMethod.sendKeys("PortfolioOwnerName", OwnerName);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("PortfolioOwnerName"));
		testlog.info("OwnerName: " + data.getCellData(SheetName, "OwnerName", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerEmail", OwnerEmail);
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("PortfolioOwnerEmail"));
		testlog.info("OwnerEmail: " + data.getCellData(SheetName, "OwnerEmail", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPhone", OwnerPhone);
		data.setCellData(SheetName, "OwnerPhone", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPhone"));
		testlog.info("OwnerPhone: " + data.getCellData(SheetName, "OwnerPhone", rowNum));
		CommonMethod.WaitUntilPresence("PortfolioenterpriseRadioButton", 60);
		CommonMethod.ClickCheckbox("PortfolioenterpriseRadioButton");
		CommonMethod.WaitUntilPresence("PortfolioconsultantsRadioButton", 60);
		CommonMethod.ClickCheckbox("PortfolioconsultantsRadioButton");
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton", "PortfolioSubcribeContinueButton2");
		CommonMethod.ClickCheckbox("PortfolioQuestionRadio");
		CommonMethod.WaitUntilVisibility("PortfolioLocationDescriptionTextbox", 20);
		CommonMethod.sendKeys("PortfolioLocationDescriptionTextbox", "Test Description");
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton2");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton2", "PortfolioSubscribeDone");
		CommonMethod.RobustclickElementVisible("PortfolioSubscribeDone", "PortfolioGoToBilling");
		CommonMethod.WaitUntilVisibility("PortfolioGoToBilling", 60);
		CommonMethod.Robustclick("PortfolioGoToBilling");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.navigateBack();
		testlog.pass("**Verifies Subscribe Portfolio successfully**");
	}

	public void PortfolioClickOnBilling() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 60);
		CommonMethod.RobustclickElementVisible("BiilingTab", "V2ProjectPreBillingPayNowButton");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.RobustclickElementVisible("V2ProjectPreBillingPayNowButton", "BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void PortfolioBuildScorecard() throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2Tab", 120);
		CommonMethod.RobustclickElementVisible("WellV2Tab", "ScorecardTab");
		CommonMethod.RobustclickElementVisible("ScorecardTab", "PortfolioScorecardFinishedButton");
		if (CommonMethod.isElementsExist("PortfolioScorecardFinishedButton", 30)) {
			Thread.sleep(2000);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardFinishedButton", "PortfolioScorecardPopupButton");
			Thread.sleep(2000);
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPopupButton", 30);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardPopupButton", "PortFolioScoreCardPageLand");
		}
		CommonMethod.WaitUntilVisibility("PortFolioScoreCardPageLand", Scorecardtimeout);
		testlog.pass("**Verfies Scorecard Page successfully**");
	}

	public void UploadFileinFeature(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddButton", 10);
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
							"PortfolioScorecardValidDisable");
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
							"PortfolioScoreCardVerificationAssignLocCancelbtn");
				}
				CommonMethod.scrollDown();
				CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton",
						"PortfolioScorecardUploadFeatureName");
				CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureName", 60);
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadFeatureName");
				CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload);
				if (FeatureName.equalsIgnoreCase("Support Mindful Eating")) {
					CommonMethod.WaitUntilVisibility("PortfolioScorecardUploadEditLocationA05.2", 60);
					CommonMethod.RobustclickElementVisible("PortfolioScorecardUploadEditLocationA05.2",
							"PortfolioScoreCardEditLocationCbx");
					CommonMethod.WaitUntilClickble("PortfolioScoreCardEditLocationCbx", 30);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardEditLocationCbx",
							"PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton");
					CommonMethod.RobustclickElementVisible(
							"PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton",
							"PortfolioScoreCardVerificationAddNote");
				}
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
						"PortfolioScoreCardVerificationAddNote");
				if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
					CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
				}
				CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Upload Scorecard Documents in feature successfully**");
	}

	public void UploadFileinAudit() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ScoreCardSupportOrgFeature", 60);
		CommonMethod.RobustclickElementVisible("ScoreCardSupportOrgFeature",
				"PortfolioScorecardFeatureVerificationTab");
		CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
				"PortfolioScoreCardAddOptionbutton");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton", "PortfolioScoreCardAddButton");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddButton", 10);
		CommonMethod.Robustclick("PortfolioScoreCardAddButton");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignbtn", 60);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAssignbtn",
				"PortfolioScoreCardVerificationAssignChildLocCbx");
		CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx", "PortfolioScorecardValidDisable");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAssignLocSavebtn",
				"PortfolioScoreCardVerificationUploadbtn");
		Thread.sleep(2000);
		CommonMethod.scrolldowntoLast();
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadbtn", 60);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadbtn",
				"PortfolioScoreCardVerificationUpload");
		CommonMethod.scrolldowntoLast();
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", AuditfileUpload);
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn", "PortfolioScoreCardVerificationAddNote");
		testlog.pass("**Upload Scorecard Documents in Audit successfully**");
	}

	public void clickDocument() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("WellV2Tab", 120);
		CommonMethod.RobustclickElementVisible("WellV2Tab", "DocumentLibraryTab");
		CommonMethod.WaitUntilVisibility("DocumentLibraryTab", 60);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab", "PortfolioDocumentUploadbutton");
		testlog.pass("**Navigate Document successfully**");
	}

	public void ValidatingLegalUploadDocument() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadbutton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "legal");
		CommonMethod.selectdropdownVisibletext("PortfolioSelectdocumenttype", "Signed certification agreement");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", LegalfileUpload, "UploadFileVerifyScorecard");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Legal", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Legal Document successfully**");
	}

	public void ValidatingAuditUploadDocument() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "audit");
		CommonMethod.selectdropdownVisibletext("PortfolioSelectverificationMethod", "Technical Document (Audited)");
		CommonMethod.WaitUntilPresence("WPRSelectFeaturePart", 60);
		CommonMethod.scrolldowntoElement("PortfolioSelectverificationMethod");
		CommonMethod.selectdropdownVisibletext("WPRSelectFeaturePart", "N08.1");
		CommonMethod.scrolldowntoElement("WPRSelectFeaturePart");
		CommonMethod.WaitUntilPresence("WPRAddPartButton", 60);
		CommonMethod.Robustclick("WPRAddPartButton", "WPRSelectFeaturePart");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", AuditfileUpload, "UploadFileVerifyScorecard");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadSubmitbutton", "PortfolioDocumentListLink");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Audit", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Audit Document successfully**");
	}

	public void ValidatingFeatureUploadDocument() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", 120);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "feature");
		CommonMethod.selectdropdownVisibletext("PortfolioSelectverificationMethod",
				"Policy and/or Operations Schedule");
		CommonMethod.WaitUntilPresence("WPRSelectFeaturePart", 60);
		CommonMethod.scrolldowntoElement("PortfolioSelectverificationMethod");
		CommonMethod.selectdropdownVisibletext("WPRSelectFeaturePart", "A02.1");
		CommonMethod.scrolldowntoElement("WPRSelectFeaturePart");
		CommonMethod.WaitUntilPresence("WPRAddPartButton", 60);
		CommonMethod.Robustclick("WPRAddPartButton", "WPRSelectFeaturePart");
		CommonMethod.WaitUntilPresence("WPRConfirmLocation", 60);
		CommonMethod.RobustclickElementVisible("WPRConfirmLocation", "WPRAssignLocCbx");
		CommonMethod.ClickCheckbox("WPRAssignLocCbx");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAssignLocSavebtn",
				"PortfolioScoreCardVerificationUpload");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadSubmitbutton", "PortfolioDocumentListLink");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Feature", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Feature Document successfully**");

	}

	public void ReviewDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 30);
		CommonMethod.WaitUntilVisibility("PortfolioReviewSubmitButton", 30);
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitButton", "PortfolioReviewTextbox");
		CommonMethod.sendKeys("PortfolioReviewTextbox", "Submit Documentation for Year 1, Review Cycle #1");
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitDocButton", "PortfolioReviewListStatus");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListStatus", 120);
		CommonMethod.assertcontainsmessage("PortfolioReviewListStatus", "ROUND 1 REVIEW IN PROGRESS",
				"Verified Submitted Review list status");
		testlog.pass("**Submitted Documentation for Year 1, Review Cycle #1 successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLAtScaleNavBar");
		CommonMethod.WaitUntilPresence("AdminWELLAtScaleNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminWELLAtScaleNavBar", "PortfolioSearchByID");
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioAdminApplybtn", "PortfolioIDVerify");
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with excel in search");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify", "ReviewTab");
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab", "PortfolioReviewListViewButton");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListViewButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioReviewListViewButton", "PortfolioReturnReview");
		CommonMethod.WaitUntilVisibility("PortfolioReturnReview", 60);
		CommonMethod.RobustclickElementVisible("PortfolioReturnReview", "PortfolioScoreCardVerificationUpload");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitResponse", "PortfolioReviewStatus");
		CommonMethod.WaitUntilVisibility("PortfolioReviewStatus", 60);
		testlog.pass("**Completed Reviewed Preliminary Precertification Review successfully**");
	}

	public void registerFieldValidationTest(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 30);
		CommonMethod.RobustclickElementVisible("EditTab", "PortfolioEditAccounttab");
		CommonMethod.WaitUntilVisibility("PortfolioEditAccounttab", 30);
		CommonMethod.RobustclickElementVisible("PortfolioEditAccounttab", "PortfolioEditAccountName");
		CommonMethod.WaitUntilVisibility("PortfolioEditAccountName", 30);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditAccountName"),
				data.getCellData(SheetName, "AccountName", rowNum), "Portfolio Project Name doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditApproximatelyLoc"),
				data.getCellData(SheetName, "Location", rowNum), "Portfolio Approximately Location doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditLocationSubscribing"),
				data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum),
				"Portfolio Location Subscribing doesn't match");
		CommonMethod.softAssertEqualsMessage(
				CommonMethod.getattributeValue("PortfolioEditAreaSqft").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "AreaSQFT", rowNum), "Portfolio AreaSqft doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "Portfolio Organization Name doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("PortfolioEditOrganizationIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "Portfolio OrganizationIndustry doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("PortfolioEditCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Portfolio Country doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("PortfolioEditState"),
				data.getCellData(SheetName, "State", rowNum), "Portfolio State doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditStreetAddress"),
				data.getCellData(SheetName, "Street", rowNum), "Portfolio StreetAddress doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditCity"),
				data.getCellData(SheetName, "City", rowNum), "Portfolio City doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Portfolio postal code matched with excel");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditOrganizationOverview"),
				data.getCellData(SheetName, "Overview", rowNum), "Portfolio OrganizationOverview doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditOwnerName"),
				data.getCellData(SheetName, "OwnerName", rowNum), "Portfolio OwnerName doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditOwnerEmail"),
				data.getCellData(SheetName, "OwnerEmail", rowNum), "Portfolio OwnerEmail doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditOwnerPhone"),
				data.getCellData(SheetName, "OwnerPhone", rowNum), "Portfolio OwnerPhone doesn't match");
		softAssert.assertAll();
		testlog.pass("**Register Field Validation successfully**");
	}

	public void editAndValidateAccountInformationPortfolio(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "PortfolioAccountNameEdit");
		CommonMethod.WaitUntilVisibility("PortfolioAccountInformation", 60);
		CommonMethod.RobustclickElementVisible("PortfolioAccountInformation", "PortfolioGoal");
		CommonMethod.WaitUntilVisibility("PortfolioAccountNameEdit", 60);
		CommonMethod.clearAndSendKey("PortfolioAccountNameEdit", data.getCellData(SheetName, "AccountName", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioGoal", 60);
		CommonMethod.sendKeys("PortfolioGoal", data.getCellData(SheetName, "Goals", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioScope", 60);
		CommonMethod.sendKeys("PortfolioScope", data.getCellData(SheetName, "Scope", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioSaveButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioSaveButton", "WPRHsrPortfolioDashboard");
		testlog.info("**Project Information data updated successfully**");
		/*
		 * Validate updated account information fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "PortfolioAccountInformation");
		CommonMethod.WaitUntilVisibility("PortfolioAccountInformation", 60);
		CommonMethod.RobustclickElementVisible("PortfolioAccountInformation", "PortfolioGoal");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioGoal"),
				data.getCellData(SheetName, "Goals", rowNum), "Goals data doesn't match");
		testlog.info("**Goals data updated successfully**");
		CommonMethod.WaitUntilVisibility("PortfolioScope", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioScope"),
				data.getCellData(SheetName, "Scope", rowNum), "Scope data doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies Project Information data updated successfully**");
	}

	public void editAndValidateAdmin(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "PortfolioCoachingContacts");
		CommonMethod.WaitUntilVisibility("PortfolioCoachingContacts", 60);
		testlog.info("Coaching Contacts: " + data.getCellData(SheetName, "CoachingContacts", rowNum));
		CommonMethod.selectdropdownVisibletext("PortfolioCoachingContacts", data.getCellData(SheetName, "CoachingContacts", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioExternalReview", "OwnerOrg");
		CommonMethod.WaitUntilPresence("OwnerOrg", 60);
		CommonMethod.sendKeys("OwnerOrg","Ui");
		CommonMethod.WaitUntilPresence("PortfolioExternalReviewChild", 60);
		CommonMethod.RobustclickElementVisible("PortfolioExternalReviewChild", "PortfolioExternalReview");
		CommonMethod.clearAndSendKey("PortfolioChallengesNotes", data.getCellData(SheetName, "ChallengeNote", rowNum));
		CommonMethod.clearAndSendKey("PortfolioCommunicationNotes", data.getCellData(SheetName, "CommunicationNotes", rowNum));
		CommonMethod.clearAndSendKey("PortfolioAccountNotes", data.getCellData(SheetName, "AccountNotes", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioSaveButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioSaveButton", "WPRHsrPortfolioDashboard");
		testlog.pass("**Admin data updated successfully**");
		/*
		 * Validate updated admin fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "PortfolioCoachingContacts");
		CommonMethod.WaitUntilVisibility("PortfolioCoachingContacts", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("PortfolioCoachingContacts"),
				data.getCellData(SheetName, "CoachingContacts", rowNum), "Coaching contacts value doesn't match");
		testlog.info("**Coaching contacts updated successfully**");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("PortfolioExternalReviewValid"),
				data.getCellData(SheetName, "ExternalReview", rowNum), "ExternalReview value doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioChallengesNotes"),
				data.getCellData(SheetName, "ChallengeNote", rowNum), "Challenges notes value doesn't match");
		testlog.info("**Challenges notes value updated successfully**");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioCommunicationNotes"),
				data.getCellData(SheetName, "CommunicationNotes", rowNum), "Communication notes value doesn't match");
		testlog.info("**Communication notes value updated successfully**");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioAccountNotes"),
				data.getCellData(SheetName, "AccountNotes", rowNum), "Account notes value doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies Admin fields updated successfully**");
	}

	public void teamPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn", "PortfolioEmailAddress");
		String TeamEmail = data.getCellData(SheetName, "TeamEmailID", rowNum);
		CommonMethod.WaitUntilVisibility("PortfolioEmailAddress", 30);
		CommonMethod.sendKeys("PortfolioEmailAddress", TeamEmail);
		data.setCellData(SheetName, "TeamEmailID", rowNum, TeamEmail);
		CommonMethod.selectdropdownVisibletext("PortfolioRole", "Acoustician");
		CommonMethod.ClickCheckbox("V2ProjectMembercbx");
		CommonMethod.WaitUntilVisibility("V2ProjectInvitebtn", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn", "V2ProjectAddMemberbtn");
		testlog.pass("**Created Team member successfully**");
	}

	public void deleteAddedTeamMemberPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("V2ProjectDeleteIcon", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectDeleteIcon", "V2ProjectAddMemberbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 300);
	}

	public void validateTeamsPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellAtScaleNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("Portfolio Name:" + data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var), "1", "Portfolio Search failed");
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		testlog.pass("**Verifies user able to access the invited project**");
	}

	public void clickOnTeamPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TeamTab", 300);
		CommonMethod.RobustclickElementVisible("TeamTab", "V2ProjectAddMemberbtn");
	}

	public void verifyScoreCardOptionFilter(String filterName, String expectedResult, int filterIndex, int checkboxIndex)
			throws IOException, InterruptedException {
		if (filterName.equalsIgnoreCase("GRESB")) {
			CommonMethod.RobustclickElementVisible("PortfolioScorecardGresbFilter", "V2ProjectScoreCardFilterButton");
		} else {
			CommonMethod.clickOnListWebelementFromIndex("V2ProjectScoreCardFilterOption", filterIndex);
		}
		CommonMethod.clickListWebelementFromIndex("V2ProjectScoreCardFilterOptionCheckBox", checkboxIndex);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "V2ProjectScoreCardFilterButton");

		if (filterName.equalsIgnoreCase("Response")) {
			CommonMethod.WaitUntilPresence("PortfolioScoreCardValidatePurseYes", 60);
			int YesFeature = CommonMethod.ElementSize("PortfolioSelectedPurseYes");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("YesFeatureCount: " + actualYesFeatureCount);
			CommonMethod.softAssertEqualsMessage(actualYesFeatureCount, expectedResult, "YesPurseCount doesn't match");
		}
		if (filterName.equalsIgnoreCase("Verification")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("PortfolioScorecardFeatureVerification", 60);

		}
		if (filterName.equalsIgnoreCase("Document Scale")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("PortfolioScorecardFeatureDocumentScale", 60);	
		}

		if (filterName.equalsIgnoreCase("Part type")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			try{
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			}
			catch(Exception e) {
				CommonMethod.refreshBrowser();
				CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
				CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
				CommonMethod.clickOnListWebelementFromIndex("V2ProjectScoreCardFilterOption", filterIndex);
				CommonMethod.clickListWebelementFromIndex("V2ProjectScoreCardFilterOptionCheckBox", checkboxIndex);
				CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "V2ProjectScoreCardFilterButton");
				
			}
			CommonMethod.WaitUntilPresence("V2ProjectScorecardPartTypePartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Priorities")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardPrioritiesPartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Space Type")) {
			try {
				CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			}
			catch(Exception e) {
			}
			
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardSpaceTypePartCount", 60);
		}
		if (filterName.equalsIgnoreCase("GRESB")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("PortfolioScorecardFeatureGRESB", 60);
		}

		if (filterName.equalsIgnoreCase("Ratings")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardRatingsPartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Strategy Type")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardStrategyTypePartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Cross walk")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardCrossWalkPartCount", 60);
		}
		if (filterName.equalsIgnoreCase("SDG")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
			try{
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			}
			catch(Exception e) {
				CommonMethod.refreshBrowser();
				CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
				CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
				CommonMethod.clickOnListWebelementFromIndex("V2ProjectScoreCardFilterOption", filterIndex);
				CommonMethod.clickListWebelementFromIndex("V2ProjectScoreCardFilterOptionCheckBox", checkboxIndex);
				CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "V2ProjectScoreCardFilterButton");	
			}
			CommonMethod.WaitUntilPresence("PortfolioScorecardFeatureSDG", 60);
		}
		if (filterName.equalsIgnoreCase("Responsible Party")) {
			try{
				CommonMethod.WaitUntilVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			}
			catch(Exception e) {
				CommonMethod.refreshBrowser();
				CommonMethod.WaitUntilPresence("PortfolioScorecardValidateRatingsPartCount", 120);
				CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
				CommonMethod.clickOnListWebelementFromIndex("V2ProjectScoreCardFilterOption", filterIndex);
				CommonMethod.clickListWebelementFromIndex("V2ProjectScoreCardFilterOptionCheckBox", checkboxIndex);
				CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "V2ProjectScoreCardFilterButton");	
			}
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("PortfolioScorecardResponsiblePartyPartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Verification") || filterName.equalsIgnoreCase("Document Scale")
				|| filterName.equalsIgnoreCase("Part type") || filterName.equalsIgnoreCase("Priorities")
				|| filterName.equalsIgnoreCase("Space Type") || filterName.equalsIgnoreCase("Ratings")
				|| filterName.equalsIgnoreCase("GRESB") || filterName.equalsIgnoreCase("Strategy Type")
				|| filterName.equalsIgnoreCase("Cross walk") || filterName.equalsIgnoreCase("SDG")
				|| filterName.equalsIgnoreCase("Responsible Party")) {
			int ScorecardPart = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualFeaturePartCount = Integer.toString(ScorecardPart);
			testlog.info("FeatureScorecardPartCount: " + actualFeaturePartCount);
			CommonMethod.softAssertEqualsMessage(actualFeaturePartCount, expectedResult,"ScorecardPartCount doesn't match");
		}
		CommonMethod.click("V2ProjectScorecardClearbutton");
		CommonMethod.clickOnListWebelementFromIndex("V2ProjectScoreCardFilterOption", filterIndex);
		softAssert.assertAll();
		testlog.pass("**All Scorecard filter options successfully**");
	}

	public void searchFilterScoreCardV2Project() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectScoreCardSearchBox", 120);
		CommonMethod.sendKeys("V2ProjectScoreCardSearchBox", "Meet Thresholds for Particulate Matter");
		CommonMethod.assertActualContainsExpected(CommonMethod.getText("PortfolioScoreCardOptionValue"),"Meet Thresholds for Particulate Matter");
		CommonMethod.softAssertEqualsMessage(Integer.toString(CommonMethod.ElementSize("PortfolioScoreCardOptionValue")), "1",
				"Search Feature Count doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies Scorecard Search filter successfully**");
	}

	public void scorecardOptionFilterPortfolio() throws IOException, InterruptedException {
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardRefreshButton", "V2ProjectScoreCardFilterButton");
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
		verifyScoreCardOptionFilter("Response", "2", 0, 0);
		verifyScoreCardOptionFilter("Verification", "40", 1, 3);
		verifyScoreCardOptionFilter("Document Scale", "36", 2, 24);
		verifyScoreCardOptionFilter("Part type", "48", 3, 27);
		verifyScoreCardOptionFilter("Priorities", "34", 4, 29);
		verifyScoreCardOptionFilter("Space Type", "208", 5, 32);
		verifyScoreCardOptionFilter("Ratings", "27", 6, 69);
		verifyScoreCardOptionFilter("GRESB", "38", 11, 123);
		verifyScoreCardOptionFilter("Strategy Type", "18", 7, 72);
		verifyScoreCardOptionFilter("Cross walk", "21", 8, 76);
		verifyScoreCardOptionFilter("SDG", "8", 9, 96);
		verifyScoreCardOptionFilter("Responsible Party", "30", 10, 113);
	}
	
	public void SearchPortfolioBySubcribedStatus(String SheetName, int rowNum, String Status) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellAtScaleNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("Portfolio Name:" + data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		/*
		 * ProjectID
		 */
		CommonMethod.WaitUntilVisibility("PortfolioSearchByID", 60);
		CommonMethod.clearAndSendKey("PortfolioSearchByID",data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.softAssertContainsMessage(String.valueOf(var), "1", "Portfolio Search failed");
		/*
		 * AccountName
		 */
		CommonMethod.WaitUntilVisibility("PortfolioSearchByName", 60);
		CommonMethod.clearAndSendKey("PortfolioSearchByName",data.getCellData(SheetName, "AccountName", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		int ProjectIDCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.softAssertContainsMessage(String.valueOf(ProjectIDCount), "1", "Portfolio Search failed");
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioNameVerify"), data.getCellData(SheetName, "AccountName", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		/*
		 * OrgName
		 */
		CommonMethod.WaitUntilVisibility("PortfolioOrganizationList", 60);
		CommonMethod.clearAndSendKey("PortfolioOrganizationList",data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioOrgNameResultList"), data.getCellData(SheetName, "OrgName", rowNum), "Portfolio Search failed");
		/*
		 * Status
		 */
		if (Status.equalsIgnoreCase("SUBSCRIBED") || Status.equalsIgnoreCase("NOT SUBSCRIBED")){
			CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioStatusResultList"), Status, "Portfolio Search failed");
		}
		if (Status.equalsIgnoreCase("IN PROGRESS")) {
			CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioSubInProgressResultList"), Status, "Portfolio Search failed");
		}
		int ProjectIDCount1 = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.softAssertContainsMessage(String.valueOf(ProjectIDCount1), "1", "Portfolio Search failed");
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify", "WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		softAssert.assertAll();
		testlog.pass("**Verifies the Search Portfolio Name successfully**");
	}
	
	public void ValidDashboardPortfolioField(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("WellV2DashboardTab", 60);
		CommonMethod.WaitUntilPresence("PortfolioClickSignNow", 30);
		CommonMethod.WaitUntilPresence("SubscribeTab", 30);
		CommonMethod.WaitUntilPresence("ResourcesTab", 30);
		CommonMethod.WaitUntilPresence("BiilingTab", 30);
		CommonMethod.WaitUntilPresence("TeamTab", 30);
		CommonMethod.WaitUntilPresence("EditTab", 30);
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
}
	
	public void ResorceCardValidation(String SheetName, int rowNum, String cardValue) throws Exception {
		CommonMethod.WaitUntilVisibility("ResourcesTab", 60);
		CommonMethod.RobustclickElementVisible("ResourcesTab", "PromotionCardContainer");
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, cardValue);
		testlog.info("Card count: " + cardCount);
		testlog.pass("**Verify card count successfully**");

	}
}
