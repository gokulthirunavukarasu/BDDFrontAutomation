package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsCustomPortfolio extends BaseClass {
	public void MeetThresholdsforParticulateMatter(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Scorecard Document for Air A01.1");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardA01PursueYesButton","PortfolioScorecardPursueToast");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardWeightPHighlighted", 1);
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardAddButton", 0);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardRemoveButton", 1);
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 1);
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx","PortfolioScorecardValidDisable");
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn","PortfolioScoreCardVerificationAssignLocCancelbtn");
				}
				CommonMethod.scrollDown();
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreVerifyUploadVerificationMethod");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 60);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationSelectFeature");
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A01.3");
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPart", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart", "PortfolioScoreCardVerificationSelectFeature");
				CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadAddfeature", "PortfolioScoreCardVerificationSelectFeature");
				/*
				 * Edit location and verify count
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScorecardUploadEditLocationA05.2", "PortfolioScorecardUncheckLoc");
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
						"PortfolioScoreCardVerificationAddNote");
				if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
					CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
				}
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
				CommonMethod.softAssertContainsMessage(val.get(2), "A01.3", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				CommonMethod.WaitUntilPresence("PortfolioDocListEditIcon", 60);
				CommonMethod.WaitUntilPresence("PortfolioDocListDeleteIcon", 60);
				testlog.info("**Verifies Task Count successful**");
				testlog.info("**Verifies Option Count successful**");
				testlog.info("**Verifies Toaster message successful**");
				testlog.info("**Verifies Document table data successful**");
				testlog.info("Review Status is correct in Table in UplaodTab");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document for Air A01.1 Feature successful**");
	}
	
	public void MeetThresholdsforOrganicGases(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Scorecard Document for Air A01.2");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 30);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton","PortfolioScoreCardAddButton");
				/*
				 * ScoreCard Add option
				 */
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardRemoveButton", 2);
				testlog.info("**Verifies RemoveButton Count successful**");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 2);
				testlog.info("**Verifies Task Count successful**");
				testlog.info("**Verifies Option Count successful**");
				
				/*
				 * Assign 3 Location
				 */
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1,
							4);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
							"PortfolioScoreCardVerificationAssignLocCancelbtn");
				}
				Thread.sleep(2000);
				CommonMethod.WaitUntilPresence("PortfolioScorecardOptionPurseLocation", 60);
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "3 Pursuing",
							"PurseLocationCount doesn't match");
				}
				List<WebElement> TaskAssignLocation;
				TaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskAssignLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/3 Locations",
							"Task Assign Location Count doesn't match");
				}
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionPurseLocation", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskPurseLocation", 2);
				testlog.info("**Verifies Option Purse Location successful**");
				testlog.info("**Verifies Task Purse Location successful**");
				/*
				 * Upload Document for Tasks
				 */
				CommonMethod.scrollDown();
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
					/*
					 * Valid FeatureName, DocumentType and VerificationMethod
					 */
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureName", 60);
					CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardUploadFeatureName"),
							"Meet Thresholds for Organic Gases", "Feature Name doesn't match");
					testlog.info("FeatureName: " + CommonMethod.getText("PortfolioScorecardUploadFeatureName"));
					CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardDocumentType"),
							"Feature verification", "Document Type doesn't match");
					testlog.info("DocumentType: " + CommonMethod.getText("PortfolioScorecardDocumentType"));
					String VerificationMethod = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
					testlog.info("VerificationMethod: " + VerificationMethod);
					/*
					 * Adding part A05.2
					 */
					if (VerificationMethod.equalsIgnoreCase("Performance Test")) {
						CommonMethod.softAssertContainsMessage(VerificationMethod, "Performance Test",
								"Verification Method doesn't match");
						testlog.info("**Verifies Verification Method successful**");
						CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
						CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 60);
						CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
								"PortfolioScoreCardVerificationSelectFeature");
						CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A05.2");
						CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPart", 60);
						CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
								"PortfolioScoreCardVerificationSelectFeature");
						CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadAddfeature",
								"PortfolioScoreCardVerificationSelectFeature");
						/*
						 * Valid Added part remove link
						 */
						CommonMethod.scrolldowntoElement("PortfolioScoreVerifyUploadVerificationMethod");
						CommonMethod.WaitUntilVisibility("PortfolioScorecardUploadRemovelink", 60);
						testlog.info("**Verifies Remove link in Upload Feature successful**");
					}
					CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadDocbtn",
							"PortfolioScorecardDocumentAddedPopup");
					if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
						CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
					}
				
				/*
				 * Edit Upload Document
				 */
				CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon",
						"PortfolioScoreVerifyUploadVerificationMethod");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				/*
				 * Edit location and verify count
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLoc", "PortfolioScorecardUncheckLoc");
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyUpdateLocation"),
						"2 Locations assigned", "Task Upload Update Location Count doesn't match");
				CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.scrolldowntoElement("PortfolioScorecardCompletedTaskLocCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCompletedTaskLocCount", 2);
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.softAssertContainsMessage(val.get(4), "Implementation", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				testlog.info("**Verifies Upload Document Toaster message successful**");
				testlog.info("**Verifies Option Purse Location Count successful**");
				testlog.info("**Verifies Task Assign Location Count successful**");
				testlog.info("**Verifies updated Task Assigned Location Count successful**");
				testlog.info("**Verifies Document table data successful**");
				testlog.info("**Verifies Completed Task Location Count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
			}
		testlog.pass("**Verifies Scorecard Uploaded Document for Air A01.2 Feature successful**");
	}
	
	public void MeetEnhancedThresholdsforOrganicGases(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Document for Air A05.2");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioDocListEditIcon1");
				/*
				 * Edit Upload Document
				 */
				CommonMethod.scrollDown();
				CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon1",
						"PortfolioScoreVerifyUploadVerificationMethod");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				/*
				 * Edit location and verify count
				 */
				CommonMethod.WaitUntilVisibility("PortfolioScorecardUploadEditLocationA05.2", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardUploadEditLocationA05.2", "PortfolioScorecardUncheckLoc");
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
						"PortfolioScorecardValidDisable");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadIntentStage",
						"PortfolioScorecardVerifyTaskUploadUpdateButton");
				CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "5 Pursuing",
							"PurseLocationCount doesn't match");
				}
				CommonMethod.scrolldowntoElement("PortfolioScorecardCompletedTaskLocCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCompletedTaskLocCount", 1);
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				testlog.info("Fetching Data from Upload Table");
				testlog.info("**Verifies updated Task Assigned Location Count successful**");
				testlog.info("**Verifies Document table data successful**");
				testlog.info("**Verifies Completed Task Location Count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
				}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A05.2 Feature successful**");
		
	}
	
	public void MeetThresholdsforInOrganicGases(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Document for Air A01.3");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 120);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioScorecardDocumentCompleteGreenCircleValid");
				/*
				 * Validate Task completion and green circle
				 */
				CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentCompleteGreenCircleValid", 120);
				testlog.info("Validate Task Completed green circle");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentCompleteLink","PortfolioScorecardDocumentCompleteCount");
				CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentCompleteCount", 120);
				testlog.info("Validate Completed Location count for Task Completed model");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentCompleteCount","PortfolioScorecardDocumentCompleteGreenCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardDocumentCompleteGreenCount", 4);
				testlog.info("Validate count for Task Completed green colour for location list");
				CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentCompleteClose", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentCompleteClose","PortfolioScorecardDocumentUploadTable");
				CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
				CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.softAssertContainsMessage(val.get(2), "A01.3", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				testlog.pass("**Verifies Document table data successful**");
				testlog.info("Review Status is correct in Table in UploadTab");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
				
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A01.3 Feature successful**");
	}

	public void MitigateConstructionPollution(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Document for Air A04.1");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton","PortfolioScoreCardAddButton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardMigrationOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardMigrationOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 1);
				softAssert.assertAll();
				testlog.info("**Verifies Option Count successful**");
				testlog.info("**Verifies Task count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A04.1 Feature successful**");
	}

	public void ManageWindowUse(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Scorecard Document for Air A07.2");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton","PortfolioScoreCardAddButton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardMangeOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardMigrationOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 3);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 3);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 1);
				String VerifyAndText = CommonMethod.getText("PortfolioScorecardVerifyAndOption");
				testlog.info("And Condition: " + VerifyAndText);
				CommonMethod.assertActualContainsExpected(VerifyAndText, "AND");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardManageWeightHightlighting", 1);
				softAssert.assertAll();
				testlog.info("**Verifies Option Count successful**");
				testlog.info("**Verifies Task count successful**");
				testlog.info("**Verifies Assign button count successful**");
				testlog.info("**Verifies Task Upload disable button count successful**");
				testlog.info("**Verifies Enable Weight highlightling count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A07.2 Feature successful**");
	}
	
	public void InstallIndoorAirMonitors(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Scorecard Document for Air A08.1");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				/*
				 * Response selection Yes for optimization
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScorecardA08PurseStatus","PortfolioScorecardPursueToast");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
				testlog.info("**Verifies Response selection Yes Toaster message successful**");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton","PortfolioScoreCardAddButton");
				 /*
				 * Test by adding the core point
				 */
				 CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0,1);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton","PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCorePointCheckbox", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 1);
				testlog.info("**Verifies CorePoint Checkbox Count successful**");
				testlog.info("**Verifies Assign button Count successful**");
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlightA08", 30);
				CommonMethod.scrolldowntoElement("PortfolioScorecardWeightHighlightA08");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlightA08"),"2", "Weight Point for doesn't match");
				softAssert.assertAll();
				testlog.info("**Verifies Weight Point Count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A08.1 Feature successful**");
	}
	
	public void EnhanceOccupantControllability(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Scorecard Document for Light L09.1");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				/*
				 * Response selection Yes for optimization
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScorecardL09PurseStatus","PortfolioScorecardPursueToast");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
				testlog.pass("**Verifies Response selection Yes Toaster message successful**");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				/*
				 * Test by adding Light L09.1 feature option 1 And option 2
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton","PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddButton", 120);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCorePointCheckbox", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardVerifyTierDropdownValue", 2);
				CommonMethod.softAssertContainsMessage(CommonMethod.getSelectedDropdownValue("PortfolioScorecardTierDropdownValue"), "Tier 1",
						"TierDropdown Defualt value doesn't match");
				CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0, 1);
				CommonMethod.selectdropdownValue("PortfolioScorecardTierDropdownValue", "2");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton","PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 60);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				 /*
				 * Test by adding the core point
				 */
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"),"3", "Weight Point for 2 doesn't match");
				
				testlog.pass("**Verifies Core Weight Point successful**");
				/*
				 * Verify Upload button disable
				 */
				CommonMethod.scrollDown();
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 2);
			    CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAssignbtn", 120);
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					/*
					 * Assign Location
					 */
					CommonMethod.WaitUntilVisibility("PortfolioScorecardVerifyTotalLocationCount", 120);
					CommonMethod.softAssertContainsMessage(
					CommonMethod.getText("PortfolioScorecardAssignLocationCountInModel"), "LOCATIONS (5)", "Location Count in model doesn't match");
					
					/*
					 * Assign Location filter
					 */
					CommonMethod.RobustclickElementVisible("PortfolioScorecardFilters", "OwnerOrgClick");
					CommonMethod.RobustclickElementVisible("OwnerOrgClick","OwnerOrg");
					CommonMethod.sendKeys("OwnerOrg", "India");
					CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10).click();
					CommonMethod.WaitUntilVisibility("PortfolioScorecardVerifyCountryFilter", 120);
					CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyCountryFilter"), "India", "Country doesn't match");
					CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyFilterReset","PortfolioScoreCardVerificationAssignChildLocCbx");
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1, 4);
					/*
					 * Verify selected Location
					 */
					CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation", "PortfolioScoreCardVerificationAssignLocCbxGeneral");
					CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScoreCardVerifyAssignedLocation"), "3 locations assigned", "Assigned Location Count doesn't match");
					/*
					 * Verify Tag New status
					 */
					CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerifyAssignedLocationNewStatus", 3);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn", "PortfolioScoreCardVerificationAssignLocCancelbtn");
}
				/*
				 * Verifies Assign Button and verify Purse Location Count
				 */
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "3 Pursuing",
							"Option Purse Location Count doesn't match");
				}
				
				/*
				 * Verifies Assign Button change to Edit Location
				 */
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 60);
				/*
				 * Verify Task Location count
				 */
				List<WebElement> TaskAssignLocation;
				TaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskAssignLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/1 Locations",
							"Task Assign Location Count doesn't match");
				}
				/*
				 * Edit location and verify the updated location
				 */
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation",
						"PortfolioScoreCardVerificationAssignLocCbxGeneral");
				/*
				 * Verify Assigned to Unassigned
				 */
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAssignLocCbx", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAssignLocCbx", "PortfolioScorecardUnassignedStatus");
				CommonMethod.WaitUntilPresence("PortfolioScorecardUnassignedStatus", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardUnassignedStatus", 3);
				CommonMethod.ClickCheckbox("PortfolioScoreCardVerificationAssignLocCbx");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn", "PortfolioScoreCardVerificationAssignLocCancelbtn");
                List<WebElement> EditTaskAssignLocation;
				EditTaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : EditTaskAssignLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/2 Locations","Task Assign Location Count doesn't match");
				}
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				/*
				 * Test by removing the core point from option 1
				 */
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1);
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlighted", 30);
				Thread.sleep(2000);
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"),"2", "Weight Point for 2 doesn't match");
				/*
				 * Test by modifying tier point to 1 for option 1 and 2
				 */
				List<WebElement> dropdown = CommonMethod.findElements("PortfolioScorecardTierDropdownValueGeneral");
				for (WebElement drop : dropdown) {
					CommonMethod.selectdropdownWebelementByValue(drop, "1");
					Thread.sleep(1000);
					CommonMethod.softAssertContainsMessage(CommonMethod.getSelectedDropdownValue(drop), "1", "TierDropdown value doesn't match");
				}
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlighted", 30);
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"),"1", "Weight Point for 2 doesn't match");		
				softAssert.assertAll();
				testlog.info("**Verifies Core Weight Point successful**");
				testlog.info("**Verifies CorePoint Checkbox count successful**");
				testlog.info("**Verifies TierDropdown count successful**");
				testlog.info("**Verifies TierDropdown value successful**");
				testlog.info("**Verifies Core Weight Point successful**");
				testlog.info("**Verifies Upload button disable successful**");
				testlog.info("**Verifies Total Location Count successful**");
				testlog.info("**Verifies Location Filter successful**");
				testlog.info("**Verifies Assigned Location New Status Count successful**");
				testlog.info("**Verifies Assign Button change to Edit Location successful**");
				testlog.info("**Verifies Option Purse Location Count successful**");
				testlog.info("**Verifies Unassigned Status Count successful**");
				testlog.info("**Verifies updated Location Count successful**");
				testlog.info("**Verifies Task location count successful**");
				testlog.info("**Verifies Selected Assigned Location successful**");
				testlog.pass("**Verifies Core Weight Point successful**");
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
                CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Light L09.1 Feature successful**");
	}

	public void ConductDaylightSimulation(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Scorecard Document for Light L06.1");
		 List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton","PortfolioScoreCardAddButton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardVerifyAuditInOptionTask", 2);
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1,
							5);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
							"PortfolioScoreCardVerificationAssignLocCancelbtn");
				}
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "4 Pursuing",
							"PurseLocationCount doesn't match");
				}
				
				List<WebElement> TaskPurseLocation;
				TaskPurseLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/2 Locations",
							"Task Assign Location Count doesn't match");
				}
				Thread.sleep(2000);
				CommonMethod.scrollDown();
				CommonMethod.ClickFirstElementInList("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,
						"UploadFileVerifyScorecard");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
						"PortfolioScoreCardVerificationAddNote");
				if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
					CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
				}
				/*
				 * Edit Upload Document
				 */
				CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon",
						"PortfolioScoreVerifyUploadVerificationMethod");
				
				/*
				 * Edit location and verify count
				 */
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadFeatureName");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLoc", "PortfolioScorecardUncheckLoc");
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 60);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
						"PortfolioScorecardValidDisable");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyUpdateLocation"),
						"2 Locations assigned", "Task Upload Update Location Count doesn't match");
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
				CommonMethod.WaitUntilInVisibility("PortfolioScoreCardVerificationUpload", 60);
				testlog.info("**Verifies attach file option removed successful**");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadIntentStage",
						"PortfolioScorecardVerifyTaskUploadUpdateButton");
				CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
    			CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				testlog.pass("**Verifies Option Purse Location Count successful**");
				testlog.pass("**Verifies Task Location Count successful**");
				testlog.pass("**Verifies Location Count successful**");
				testlog.info("Fetching Data from Upload Table");
				testlog.info("Verifies Task Upload Update Location Count");
				testlog.info("Verifies Task Upload Update Location Count");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioDocListTaskUploadList", 1);
				CommonMethod.RobustclickElementVisible("PortfolioDocListDeleteIcon", "PortfolioDocListDeleteNoButton");
				CommonMethod.WaitUntilVisibility("PortfolioDocListDeleteNoButton", 60);
				CommonMethod.RobustclickElementVisible("PortfolioDocListDeleteNoButton","PortfolioDocListTaskUploadList");
				CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioDocListTaskUploadList", 1);
				softAssert.assertAll();
				CommonMethod.WaitUntilPresence("PortfolioDocListDeleteIcon", 120);
				CommonMethod.RobustclickElementVisible("PortfolioDocListDeleteIcon", "PortfolioDocListDeleteYesButton");
				CommonMethod.WaitUntilPresence("PortfolioDocListDeleteYesButton", 120);
				CommonMethod.Robustclick("PortfolioDocListDeleteYesButton");
				if (CommonMethod.isElementsExist("PortfolioDocListTaskUploadListDeleteToastMessage", 12)) {
					CommonMethod.WaitUntilInVisibility("PortfolioDocListTaskUploadListDeleteToastMessage", 30);
				}
				CommonMethod.WaitUntilPresence("PortfolioDocListTaskUploadVerifyNoList", 120);
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Ligght L06.1 Feature successful**");
	}
	public void OfferPhysicalActivityIncentives(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Scorecard Document for Movement V09.1");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton","PortfolioScoreCardAddButton");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardAddOptionbutton", 1);
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 1);
				testlog.info("**Verifies Option Count successful**");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskOptionV09", 3);
				testlog.info("**Verifies Task Option Count successful**");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 3);
				softAssert.assertAll();
				testlog.info("**Verifies Upload button disable successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
	}
		testlog.pass("**Verifies Scorecard Uploaded Document Movement V09.1 Feature successful**");
	}
	public void RestrictVOCEmissionsfromFurnitureArchitecturalandInteriorProducts(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Upload Scorecard Document for Materials X06.2");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab","PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton","PortfolioScorecardTierDropdownValue");
				CommonMethod.softAssertContainsMessage(CommonMethod.getSelectedDropdownValue("PortfolioScorecardTierDropdownValue"), "1",
						"TierDropdown Defualt value doesn't match");
				testlog.info("**Verifies Tier Dropdown Value successful**");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlightX06"),"2", "Weight Point for 3 doesn't match");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.pass("**Verifies Core Weight Point successful**");
				softAssert.assertAll();
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
}
		testlog.pass("**Verifies Scorecard Uploaded Document Materials X06.2 Feature successful**");
}
	public void A01_1_FeatureDocumentUploadInDocumentLibrary() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 120);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab","PortfolioTaskListPendingTab");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListPendingTab", 30);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab","PortfolioDocListA1.1");
		CommonMethod.scrolldowntoElement("PortfolioTaskListPendingTab");
		CommonMethod.WaitUntilPresence("PortfolioDocListA1.1", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocListA1.1","PortfolioScoreVerifyUploadVerificationMethod");
		CommonMethod.WaitUntilVisibility("PortfolioScoreVerifyUploadVerificationMethod", 60);
		String VerificationMethod = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
		CommonMethod.softAssertContainsMessage(VerificationMethod, "Performance Test OR Sensor Data","Verification Method doesn't match");
		testlog.info("VerificationMethod: " + VerificationMethod);
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardUploadFeatureName"),"Meet Thresholds for Particulate Matter", "Feature Name doesn't match");
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyUpdateLocation"),"5 Locations assigned", "Selected Location Count doesn't match");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn","PortfolioScoreCardVerificationAddNote");
		if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
		}
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon", "PortfolioScoreVerifyUploadVerificationMethod");
		CommonMethod.WaitUntilPresence("PortfolioScoreVerifyUploadVerificationMethod", 60);
		CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
		CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton","PortfolioScoreCardVerificationAddNote");
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", 60);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab","PortfolioTaskListPendingTab");
		CommonMethod.WaitUntilVisibility("PortfolioDocListTaskFullFilledTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab", "PortfolioDocumentVerifyCompleteTask");
		CommonMethod.WaitUntilPresence("PortfolioDocumentVerifyCompleteTask", 60);
		CommonMethod.assertcontainshandledPageSource("A01.1", "A01.1 task doesn't match");
		CommonMethod.WaitUntilPresence("PortfolioDocumentVerifyCompleteTask", 60);
		softAssert.assertAll();
		CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab","PortfolioTaskListPendingTab");
	    CommonMethod.click("PortfolioTaskListPendingTab");
		testlog.info("**Verifies Feature Name in Docuement Upload successfully**");
		testlog.info("**Verifies Verification Method in Docuement Upload successfully**");
		testlog.info("**Verifies Table Content successfully**");
		testlog.info("**Verifies Location Count successfully**");
		testlog.pass("**Verifies the Attach and Completed Document for successful**");
	}
	
public void L09_AuditDocumentUploadInDocumentLibrary() throws IOException, InterruptedException {
	CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
	CommonMethod.RobustclickElementVisible("PortfolioTaskListTab","PortfolioTaskListPendingTab");
	CommonMethod.WaitUntilVisibility("PortfolioTaskListPendingTab", 30);
	CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab","PortfolioDocListUploadTaskL09Technical");
	CommonMethod.scrolldowntoElement("PortfolioTaskListPendingTab");
	CommonMethod.RobustclickElementVisible("PortfolioDocListUploadTaskL09Technical","PortfolioScoreVerifyUploadVerificationMethod");
	CommonMethod.WaitUntilVisibility("PortfolioScoreVerifyUploadVerificationMethod", 60);
	String VerificationMethod = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
	CommonMethod.softAssertContainsMessage(VerificationMethod, "Technical Document (Audited)",
			"Verification Method doesn't match");
	testlog.info("VerificationMethod: " + VerificationMethod);
	CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardUploadFeatureName"),"Enhance Occupant Controllability", "Feature name doesn't match");
	CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyUpdateLocation"),"2 Locations assigned", "Selected Location Count doesn't match");
	CommonMethod.WaitUntilVisibility("PortfolioTaskListEditLocation", 30);
	CommonMethod.RobustclickElementVisible("PortfolioTaskListEditLocation", "PortfolioScorecardUncheckLoc");
	CommonMethod.WaitUntilPresence("PortfolioTaskListVerifySelectedLoctionCount", 60);
	CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
	CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
	CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn", "PortfolioScoreCardVerificationAddNote");
	if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
		CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
	}
	CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
	CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
	List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
	testlog.info("Fetching Data from Upload Table");
	CommonMethod.softAssertContainsMessage(val.get(1), "2 Assigned", "Document table Location data mismatch");
	CommonMethod.softAssertContainsMessage(val.get(2), "L09.1", "Document table Feature name data mismatch");
	softAssert.assertAll();
	testlog.info("**Verifies Feature Name in Docuement Upload successfully**");
	testlog.info("**Verifies Verification Method in Docuement Upload successfully**");
	testlog.info("**Verifies Table Content successfully**");
	testlog.info("**Verifies Location Count successfully**");
	testlog.pass("**Verifies the Attach Docuement for Audit successful**");
	}

public void UpdateAuditDocumentUploadInDocumentLibrary() throws IOException, InterruptedException {
	/*
	 * Edit Audit Upload Document
	 */
	CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
	CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon", "PortfolioScoreVerifyUploadVerificationMethod");
	CommonMethod.WaitUntilPresence("PortfolioScoreVerifyUploadVerificationMethod", 60);
	CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
	CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadIntentStage", "PortfolioScorecardVerifyTaskUploadUpdateButton");
	CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton","PortfolioScoreCardVerificationAddNote");
	CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", 60);
	CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
	CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
	List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
	testlog.info("Fetching Data from Upload Table");
	CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
	CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
	softAssert.assertAll();
	testlog.info("**Verifies Table Content successfully**");
	testlog.pass("**Updated feature Document successfully**");
}

public void A01_2_DocumentUploadInDocumentLibrary() throws IOException, InterruptedException {
	CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
	CommonMethod.RobustclickElementVisible("PortfolioTaskListTab","PortfolioTaskListPendingTab");
	CommonMethod.WaitUntilVisibility("PortfolioTaskListPendingTab", 30);
	CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab","PortfolioDocListA1.2");
	CommonMethod.scrolldowntoElement("PortfolioTaskListPendingTab");
	CommonMethod.WaitUntilPresence("PortfolioDocListA1.2", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocListA1.2","PortfolioScoreVerifyUploadVerificationMethod");
	CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureName", 60);
	CommonMethod.scrolldowntoElement("PortfolioScorecardUploadFeatureName");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListEditLocation", 60);
	CommonMethod.RobustclickElementVisible("PortfolioTaskListEditLocation", "PortfolioScorecardUncheckLoc");
	CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
	CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton","PortfolioScoreCardVerificationAddNote");
	CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyUpdateLocation"),
			"4 Locations assigned", "Task Upload Update 4 Location Count doesn't match");
	CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
	CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
	CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn","PortfolioScoreCardVerificationAddNote");
	if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
		CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
	}
	CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
	CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
	List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
	testlog.info("Fetching Data from Upload Table");
	CommonMethod.softAssertContainsMessage(val.get(2), "A01.2", "Document table data mismatch");
	softAssert.assertAll();
	testlog.info("**Verifies Location Count successfully**");
	testlog.info("**Verifies Table Content successfully**");
	testlog.pass("**Upload feature Document successfully**");
}

public void UpdateFeatureDocumentUploadInDocumentLibrary() throws IOException, InterruptedException {
	/*
	 * Edit Feature Upload Document
	 */
	CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
	CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon",
			"PortfolioScoreVerifyUploadVerificationMethod");
	CommonMethod.WaitUntilPresence("PortfolioScoreVerifyUploadVerificationMethod", 60);
	CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
	CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadIntentStage",
			"PortfolioScorecardVerifyTaskUploadUpdateButton");
	CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton",
			"PortfolioScoreCardVerificationAddNote");
	CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
	CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
	List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
	testlog.info("Fetching Data from Upload Table");
	CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
	CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
		softAssert.assertAll();
	testlog.info("**Verifies Table Content successfully**");
	testlog.pass("**Updated feature Document successfully**");
}

public void ValidatingLegalUploadDocument() throws IOException, InterruptedException {
	CommonMethod.refreshBrowser();
	CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadbutton", 60);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton", "V2ProjectPortfolioDocType");
	CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "legal");
	CommonMethod.selectdropdownVisibletext("PortfolioSelectdocumenttype", "Signed certification agreement");
	CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", LegalfileUpload, "UploadFileVerifyScorecard");
	CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
	CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
	CommonMethod.refreshBrowser();
	CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
	CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
	CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
	testlog.info("Fetching Data from Upload Table");
	List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
	CommonMethod.softAssertContainsMessage(val.get(6), "Legal", "Document table data mismatch");
	softAssert.assertAll();
	CommonMethod.WaitUntilInVisibility("PortfolioDocListDisableEditIcon", 30);
	testlog.info("**Verifies Table Content successfully**");
	testlog.info("**Verifies Edit icon Should not visible successfully**");
	testlog.pass("**Upload Legal Document successfully**");
}
public void FilterInDocumentLibrary() throws IOException, InterruptedException {
	CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
	CommonMethod.RobustclickElementVisible("PortfolioTaskListTab","PortfolioTaskListPendingTab");
	CommonMethod.scrolldowntoElement("PortfolioTaskListTab");
	CommonMethod.RobustclickElementVisible("PortfolioDocFliterByLocation","PortfolioSelectFliterByLocation");
	CommonMethod.RobustclickElementVisible("PortfolioSelectFliterByLocation","PortfolioDocListFilterLocationValid");
	CommonMethod.WaitUntilPresence("PortfolioDocListFilterLocationValid", 120);
	List<WebElement> FliterVerifyLocation;
	FliterVerifyLocation = CommonMethod.findElements("PortfolioFliterVerifyLocation");
	for (WebElement f : FliterVerifyLocation) {
		CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/1 Locations",
				"Filter Verify Location doesn't match");
	}
	CommonMethod.Robustclick("PortfolioFliterClearFilter");
	CommonMethod.RobustclickElementVisible("PortfolioFliterButton","PortfolioFliterVerificationOption");
	CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioFliterVerificationOption"), "Verification", "Document table data mismatch");
	CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioFliterPartTypeOption"), "Part Type", "Document table data mismatch");
	CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioFliterConceptOption"), "Concept", "Document table data mismatch");
	//Verification
	CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOption","PortfolioFliterVerificationOptionCheckbox");
	CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOptionCheckbox","PortfolioFliterOptionApply");
	CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOption","PortfolioFliterOptionApply");
	CommonMethod.RobustclickElementVisible("PortfolioFliterOptionApply", "PortfolioFliterVerificationAuditTask");
	CommonMethod.WaitUntilPresence("PortfolioDocListFilterPreOption", 120);
	CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioFliterVerificationAuditTask"), "Technical Document (Audited)", "Verification option didn't match");
	CommonMethod.RobustclickElementVisible("PortfolioFliterButton","PortfolioFliterVerificationOption");
	CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear","PortfolioFliterButton");
	//PartType
	CommonMethod.RobustclickElementVisible("PortfolioFliterButton","PortfolioFliterPartTypeOption");
	CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOption","PortfolioFliterPartTypeOptionCheckbox");
	CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOptionCheckbox","PortfolioFliterOptionApply");
	CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOption","PortfolioFliterOptionApply");
	CommonMethod.RobustclickElementVisible("PortfolioFliterOptionApply","PortfolioDocListFilterPreOption");
	CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioDocListFilterPreOption"), "A01.2", "Precondition option didn't match");
	CommonMethod.RobustclickElementVisible("PortfolioFliterButton","PortfolioFliterVerificationOption");
	CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear","PortfolioFliterButton");
	//Concept
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton","PortfolioFliterConceptOption");
		CommonMethod.RobustclickElementVisible("PortfolioFliterConceptOption","PortfolioFliterPartTypeConceptCheckbox");
	CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeConceptCheckbox","PortfolioFliterOptionApply");
	CommonMethod.RobustclickElementVisible("PortfolioFliterConceptOption","PortfolioFliterOptionApply");
	CommonMethod.RobustclickElementVisible("PortfolioFliterOptionApply","PortfolioDocListFilterPreOption");
	CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioDocListFilterPreOption"), "A01.2", "Precondition option didn't match");
	CommonMethod.RobustclickElementVisible("PortfolioFliterButton","PortfolioFliterOptionClear");
	CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear","PortfolioFliterButton");
	
	//Multiple option
	CommonMethod.RobustclickElementVisible("PortfolioFliterButton","PortfolioFliterConceptOption");
	CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOption","PortfolioFliterVerificationOptionCheckbox");
	CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOptionCheckbox","PortfolioFliterOptionApply");
	CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOption","PortfolioFliterPartTypeOptionCheckbox");
	CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOptionCheckbox","PortfolioFliterOptionApply");
	CommonMethod.RobustclickElementVisible("PortfolioFliterConceptOption","PortfolioFliterPartTypeConceptCheckbox");
	CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeConceptCheckbox","PortfolioFliterOptionApply");
	CommonMethod.RobustclickElementVisible("PortfolioFliterOptionApply","PortfolioDocListFilterNoTaskShow");
	CommonMethod.WaitUntilPresence("PortfolioDocListFilterNoTaskShow", 120);
	CommonMethod.RobustclickElementVisible("PortfolioFliterButton","PortfolioFliterOptionClear");
	CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear","PortfolioFliterButton");
	//Filter By Name
	CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
	CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioDocListFilterName");
	CommonMethod.sendKeys("PortfolioDocListFilterName", "Feature");
	CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
	CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
	testlog.info("Fetching Data from Upload Table");
	List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
	CommonMethod.softAssertContainsMessage(val.get(0), "FeatureFile", "Document table data mismatch");
	softAssert.assertAll();
	testlog.info("**verifies search by location filter successfully**");
	testlog.info("**Verifies search filter options successfully**");
	testlog.info("**Verifies search filter by Verification Task successfully**");
	testlog.info("**Verifies search filter by Part Type Task successfully**");
	testlog.info("**verifies search by Name filter successfully**");
	testlog.info("**Verifies search filter Mutiple options successfully**");
	testlog.pass("**Verifies search filter successfully**");
}

public void DeleteInDocumentLibrary() throws IOException, InterruptedException {
	CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
	CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
	CommonMethod.WaitUntilPresence("PortfolioDocListDeleteIcon", 120);
	CommonMethod.RobustclickElementVisible("PortfolioDocListDeleteIcon", "PortfolioDocListVerifyCancelIcon");
	CommonMethod.WaitUntilPresence("PortfolioDocumentListDeleteYesButton", 120);
	CommonMethod.Robustclick("PortfolioDocumentListDeleteYesButton");
	if (CommonMethod.isElementsExist("PortfolioDocListTaskUploadListDeleteToastMessage", 12)) {
		CommonMethod.WaitUntilInVisibility("PortfolioDocListTaskUploadListDeleteToastMessage", 30);
	}
	testlog.info("**Verifies Task Deleted successfully**");
}
}