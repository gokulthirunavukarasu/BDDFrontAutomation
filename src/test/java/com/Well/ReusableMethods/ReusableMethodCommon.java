package com.Well.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodCommon extends BaseClass {

	public void SignOut() throws InterruptedException, IOException {

		if (Environment.equalsIgnoreCase("Test")) {
			driver.get("https://test-nuxt.wellcertified.com/logout");
		} else {
			driver.get("https://stg-nuxt.wellcertified.com/logout");
		}
		CommonMethod.WaitUntilPresence("Username", 10);
	}

	public void SelectCountryAndState(String Country, String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.selectdropdownValue("ProjectlocationCountry", Country);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("ProjectlocationCountry"));
		CommonMethod.selectdropdownrandom("ProjectlocationState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("ProjectlocationState"));
		testlog.info("Country: " + data.getCellData(SheetName, "Country", rowNum));
		testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
	}

	public void SelectOwnerOrg(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick","OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
		data.setCellData(SheetName, "OrgName", rowNum, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " + data.getCellData(SheetName, "OrgName", rowNum));

	}

	public void Billing(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BillingLanding", 300);
		CommonMethod.scrolldowntoElement("CardHolderName");
		CommonMethod.WaitUntilClickble("CardHolderName", 60);
		testlog.info("firstName:" + USfaker.address().firstName());
		CommonMethod.sendKeys("CardHolderName", USfaker.address().firstName());
		data.setCellData(SheetName, "CardHolderName", rowNum, CommonMethod.getattributeValue("CardHolderName"));
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardNumberIframe");
		CommonMethod.WaitUntilClickble("CardHolderNumber", 60);
		Thread.sleep(2000);
		testlog.info("CardHolderNumber:" + "4111111111111111");
		CommonMethod.sendKeys("CardHolderNumber", data.getCellData(SheetName, "CardNumber", rowNum));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardExpDateIframe");
		testlog.info("CardHolderExpDate:" + "0925");
		CommonMethod.WaitUntilClickble("CardHolderExpDate", 60).sendKeys("0");
		CommonMethod.sendKeys("CardHolderExpDate", "9");
		CommonMethod.sendKeys("CardHolderExpDate", "2");
		CommonMethod.sendKeys("CardHolderExpDate", "5");
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardCVVIframe");
		CommonMethod.WaitUntilClickble("CardHolderCVC", 60);
		testlog.info("CardHolderCVC:" + "999");
		CommonMethod.sendKeys("CardHolderCVC", data.getCellData(SheetName, "CardCVC", rowNum));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("PayNowButton", 10);
		CommonMethod.click("PayNowButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilInVisibility("CardHolderName", 180);
		testlog.pass("**Verifies the Completed Card Payment Billing successfully**");
	}

	public void LocationImport(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("LocationsTab", 60);
		CommonMethod.RobustclickElementVisible("LocationsTab","PortfolioLocationLanding");
		CommonMethod.WaitUntilVisibility("PortfolioLocationLanding", 60);
		CommonMethod.RobustclickElementVisible("PortfolioLocationsImportButton", "PortfolioUploadFileNextButton");
		CommonMethod.scrolldowntoElement("PortfolioUploadLocationButton");
		CommonMethod.uploadFile("PortfolioUploadLocationButton", PortfolioLocationImportfile);
		CommonMethod.click("PortfolioUploadFileNextButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("PortfolioUploadFileNextButton", 30);
		if (CommonMethod.isElementsExist("PortfolioUnmatchFieldcbx", 3)) {
			CommonMethod.WaitUntilVisibility("PortfolioUnmatchFieldcbx", 30);
			CommonMethod.ClickCheckbox("PortfolioUnmatchFieldcbx");
		}
		CommonMethod.WaitUntilVisibility("PortfolioUploadFileNextButton", 30);
		CommonMethod.RobustclickElementVisible("PortfolioUploadFileNextButton","PortfolioFinishImportButton");
		CommonMethod.WaitUntilVisibility("PortfolioFinishImportButton", 30);
		CommonMethod.RobustclickElementVisible("PortfolioFinishImportButton","PortfolioImportCloseButton");
		CommonMethod.WaitUntilVisibility("PortfolioImportCloseButton", 30);
		CommonMethod.RobustclickElementVisible("PortfolioImportCloseButton","PortfolioLocationLanding");
		CommonMethod.WaitUntilVisibility("PortfolioLocationLanding", 60);
		CommonMethod.refreshBrowser();
		/*
		 * Validate location added successfully
		 */
		CommonMethod.WaitUntilPresence("AddButton", 300);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilPresence("LocationResultCount", 60);
		testlog.info("LocationResultCount: "+CommonMethod.getText("LocationResultCount"));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("LocationResultCount"), "5",
				"Result location count doesn't match");
		softAssert.assertAll();
		testlog.pass("**Imported Locations successfully**");
	}

	public void clickOnAlternatives(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("AlternativesTab", 300);
		CommonMethod.RobustclickElementVisible("AlternativesTab", "V2ProjectEPSubmitButton");

	}

	public void alternatives(String SheetName, int rowNum, String alternativeOption)
			throws IOException, InterruptedException {
		if (alternativeOption.equalsIgnoreCase("EP")) {
			CommonMethod.RobustclickElementVisible("V2ProjectEPSubmitButton", "V2ProjectFeatureDropdown");
			
			CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectFeatureDropdown");
			CommonMethod.negativesoftassertPageSource("Feature* is required.", "Feature Name Error Mismatch");
			CommonMethod.scrollUp();
			CommonMethod.WaitUntilVisibility("V2ProjectFeatureDropdown", 60);
			CommonMethod.selectdropdownrandom("V2ProjectFeatureDropdown");
			data.setCellData(SheetName, "EPFeatureName", rowNum,
					CommonMethod.getSelectedDropdownValue("V2ProjectFeatureDropdown"));
			testlog.info("EPFeatureName: " + data.getCellData(SheetName, "EPFeatureName", rowNum));
			if (CommonMethod.isElementsExist("V2ProjectApplicablePartCheckBox", 10)) {
				
//				CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectFeatureDropdown");
//				CommonMethod.negativesoftassertPageSource("You need at least 1 Applicable part(s) *.", "Applicable Part Error Mismatch");
				CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			}
			CommonMethod.negativesoftassertPageSource("Regions/Countries where Equivalency may be Applicable * is required.", "Regions/Countries Equivalency Error Mismatch");
			
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyReason", 60).sendKeys("Reason for Equivalency Request");
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyCountriesInput", 60)
					.sendKeys("Regions/Countries where Equivalency may be Applicable");
			if (CommonMethod.isElementsExist("V2ProjectVerificationTextArea", 10)) {
				CommonMethod.negativesoftassertPageSource("Verification method within proposed equivalent * is required.", "Verification method within proposed equivalent Error Mismatch");
				CommonMethod.WaitUntilVisibility("V2ProjectVerificationTextArea", 60);
				CommonMethod.clearAndSendKey("V2ProjectVerificationTextArea",
						"Verification method within proposed equivalent");
			} else if (CommonMethod.isElementsExist("PortfolioVerificationTextArea", 10)) {
				CommonMethod.WaitUntilVisibility("PortfolioVerificationTextArea", 60);
				CommonMethod.clearAndSendKey("PortfolioVerificationTextArea",
						"Verification method within proposed equivalent");
			}
			if (CommonMethod.isElementsExist("V2ProjectSimilaritiesTextArea", 10)) {
				CommonMethod.negativesoftassertPageSource("Similarities to WELL feature requirement * is required.", "Similarities to WELL feature requirement Error Mismatch");
				CommonMethod.WaitUntilVisibility("V2ProjectSimilaritiesTextArea", 60);
				CommonMethod.clearAndSendKey("V2ProjectSimilaritiesTextArea",
						"Similarities to WELL feature requirement");
			} else if (CommonMethod.isElementsExist("PortfolioSimilaritiesTextArea", 10)) {
				CommonMethod.WaitUntilVisibility("PortfolioSimilaritiesTextArea", 60);
				CommonMethod.clearAndSendKey("PortfolioSimilaritiesTextArea",
						"Similarities to WELL feature requirement");
			}
			if (CommonMethod.isElementsExist("V2ProjectDifferencesTextArea", 10)) {
				CommonMethod.negativesoftassertPageSource("Differences from WELL feature requirement * is required.", "Differences from WELL feature Error Mismatch");
				CommonMethod.WaitUntilVisibility("V2ProjectDifferencesTextArea", 60);
				CommonMethod.clearAndSendKey("V2ProjectDifferencesTextArea",
						"Differences from WELL feature requirement");
			} else if (CommonMethod.isElementsExist("PortfolioDifferencesTextArea", 10)) {
				CommonMethod.WaitUntilVisibility("PortfolioDifferencesTextArea", 60);
				CommonMethod.clearAndSendKey("PortfolioDifferencesTextArea",
						"Differences from WELL feature requirement");
			}
		} else if (alternativeOption.equalsIgnoreCase("AAP")) {
			CommonMethod.refreshBrowser();
			CommonMethod.WaitUntilVisibility("V2ProjectAapSubmitButton", 60);
			CommonMethod.RobustclickElementVisible("V2ProjectAapSubmitButton", "V2ProjectFeatureDropdown");
			CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectFeatureDropdown");
			CommonMethod.negativesoftassertPageSource("Feature* is required.", "Feature Name Error Mismatch");
			CommonMethod.WaitUntilVisibility("V2ProjectFeatureDropdown", 60);
			CommonMethod.selectdropdownrandom("V2ProjectFeatureDropdown");
			data.setCellData(SheetName, "AAPFeatureName", rowNum,
					CommonMethod.getSelectedDropdownValue("V2ProjectFeatureDropdown"));
			testlog.info("AAPFeatureName: " + data.getCellData(SheetName, "AAPFeatureName", rowNum));
			if (CommonMethod.isElementsExist("V2ProjectApplicablePartCheckBox", 10)) {
				CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			}
			CommonMethod.WaitUntilClickble("V2ProjectAlternativesReasonTextArea", 60)
					.sendKeys("Reason for Alternative Means and Methods");
		}
		CommonMethod.negativesoftassertPageSource("Proposed Alternative Means of Compliance * is required.", "Proposed Alternative Means of Compliance Error Mismatch");
		CommonMethod.WaitUntilClickble("V2ProjectAlternativesProposedTextArea", 60)
				.sendKeys("Proposed Alternative Means of Compliance");
		CommonMethod.uploadFile("DocumentsUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilVisibility("SubmitButton", 60);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2projectEPTypeStatus");
		if (alternativeOption.equalsIgnoreCase("EP")) {
			CommonMethod.WaitUntilVisibility("V2projectEPTypeStatus", 60);
			CommonMethod.assertcontainsmessage("V2projectEPTypeStatus", "EP", "EP Alternative doesn't match");
			softAssert.assertAll();
			testlog.pass("**Added alternative EP documents successfully**");
		} else if (alternativeOption.equalsIgnoreCase("AAP")) {
			CommonMethod.WaitUntilVisibility("V2projectAAPTypeStatus", 60);
			CommonMethod.assertcontainsmessage("V2projectAAPTypeStatus", "AAP", "AAP Alternative doesn't match");
			softAssert.assertAll();
			testlog.pass("**Added alternative AAP documents successfully**");
		}
	}

	public void team(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn","V2ProjectEmailAddress");
		CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn","V2ProjectEmailAddress");
		CommonMethod.negativesoftassertPageSource("Email Address is required.", "Email Address Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Project Authorization is required.", "Project Authorization Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Role is required.", "Project Role Error Mismatch");
		String TeamEmail = data.getCellData(SheetName, "TeamEmailID", rowNum);
		CommonMethod.WaitUntilVisibility("V2ProjectEmailAddress", 30);
		CommonMethod.sendKeys("V2ProjectEmailAddress", TeamEmail);
		testlog.info("Team Email ID: " +TeamEmail);
		CommonMethod.selectdropdownVisibletext("V2ProjectRole", "Acoustician");
		CommonMethod.ClickCheckbox("V2ProjectMembercbx");
		CommonMethod.WaitUntilVisibility("V2ProjectInvitebtn", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn","V2ProjectDeleteIcon");
		softAssert.assertAll();
		testlog.pass("**Created Team member successfully**");
	}
	public void deleteAddedTeamMember(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("V2ProjectDeleteIcon", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectDeleteIcon","V2ProjectAddMemberbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 300);
		softAssert.assertAll();
		testlog.pass("**Created Team member successfully**");
	}
	public void editAndValidateOrganizationInformation(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectNameInput");
		if (CommonMethod.isElementsExist("V2ProjectProjectInformationButton", 10)) {
			CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
			CommonMethod.clearAndSendKey("V2ProjectProjectNameInput",
					data.getCellData(SheetName, "ProjectName", rowNum));
		} else if (CommonMethod.isElementsExist("HSROrganizationInformationButton", 10)) {
			CommonMethod.RobustclickElementVisible("HSROrganizationInformationButton", "V2ProjectProjectScope");
			CommonMethod.clearAndSendKey("V2ProjectProjectNameInput", data.getCellData(SheetName, "HsrName", rowNum));
		}
		CommonMethod.sendKeys("V2ProjectProjectScope", data.getCellData(SheetName, "ProjectScope", rowNum));
		CommonMethod.sendKeys("V2ProjectProjectGoals", data.getCellData(SheetName, "ProjectGoals", rowNum));
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "WPRHsrPortfolioDashboard");
		testlog.info("**Project Information data updated successfully**");
		/*
		 * Validate updated project information fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectNameInput");
		if (CommonMethod.isElementsExist("V2ProjectProjectInformationButton", 10)) {
			CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
		} else if (CommonMethod.isElementsExist("HSROrganizationInformationButton", 10)) {
			CommonMethod.RobustclickElementVisible("HSROrganizationInformationButton", "V2ProjectProjectScope");
		}
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectProjectScope"),
				data.getCellData(SheetName, "ProjectScope", rowNum), "Project scope data doesn't match");
		testlog.info("**Project scope data updated successfully**");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectProjectGoals"),
				data.getCellData(SheetName, "ProjectGoals", rowNum), "Project goals data doesn't match");
		softAssert.assertAll();
		testlog.pass("**Project goals data updated successfully**");
	}

	public void editAndValidateAdmin(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 180);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 120);
		CommonMethod.Robustclick("V2ProjectAdminFieldsButton", "V2ProjectProjectNameInput");
		CommonMethod.WaitUntilVisibility("CoachingContactsDropDown", 60);
		CommonMethod.selectdropdownVisibletext("CoachingContactsDropDown","Ui (welluiautomationtesting@gmail.com)");
		data.setCellData(SheetName, "CoachingContacts", rowNum,
				CommonMethod.getSelectedDropdownValue("CoachingContactsDropDown"));
		testlog.info("Coaching Contacts: " + data.getCellData(SheetName, "CoachingContacts", rowNum));
		CommonMethod.WaitUntilVisibility("RelationshipManagerDropDown", 60);
		CommonMethod.selectdropdownVisibletext("RelationshipManagerDropDown","Ui (welluiautomationtesting@gmail.com)");
		data.setCellData(SheetName, "RelationshipManager", rowNum,
				CommonMethod.getSelectedDropdownValue("RelationshipManagerDropDown"));
		testlog.info("Relationship Manager: " + data.getCellData(SheetName, "RelationshipManager", rowNum));
		CommonMethod.WaitUntilVisibility("WellReviewerDropDown", 60);
		CommonMethod.selectdropdownVisibletext("WellReviewerDropDown","Ui (welluiautomationtesting@gmail.com)");
		data.setCellData(SheetName, "WellReviewer", rowNum,
				CommonMethod.getSelectedDropdownValue("WellReviewerDropDown"));
		testlog.info("Well Reviewer: " + data.getCellData(SheetName, "WellReviewer", rowNum));
		if(SheetName.equalsIgnoreCase("Wer")|| SheetName.equalsIgnoreCase("Wpr") || SheetName.equalsIgnoreCase("Hsr")){
		CommonMethod.ClickCheckbox("EditAchievedStatus");
		CommonMethod.RobustclickElementVisible("DatePickerButton","DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","V2ProjectSaveChangesButton");
		}
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "WPRHsrPortfolioDashboard");
		testlog.pass("**Admin data updated successfully**");
		/*
		 * Validate updated admin fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.Robustclick("V2ProjectAdminFieldsButton", "V2ProjectProjectNameInput");
		CommonMethod.WaitUntilVisibility("CoachingContactsDropDown", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("CoachingContactsDropDown"),
				data.getCellData(SheetName, "CoachingContacts", rowNum), "Coaching contacts value doesn't match");
		testlog.pass("**Coaching contacts updated successfully**");
		CommonMethod.WaitUntilVisibility("RelationshipManagerDropDown", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("RelationshipManagerDropDown"),
				data.getCellData(SheetName, "RelationshipManager", rowNum), "Relationship Manager value doesn't match");
		testlog.pass("**Relationship Manager value updated successfully**");
		CommonMethod.WaitUntilVisibility("WellReviewerDropDown", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("WellReviewerDropDown"),
				data.getCellData(SheetName, "WellReviewer", rowNum), "Well Reviewer value doesn't match");
		softAssert.assertAll();
		testlog.pass("**Well Reviewer value updated successfully**");
	}

	public void promotionCardValidation(String SheetName, int rowNum, String cardValue) throws Exception {
		CommonMethod.WaitUntilVisibility("PromotionTab", 60);
		CommonMethod.RobustclickElementVisible("PromotionTab", "PromotionCardContainer");
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, cardValue);
		testlog.info("Card count: " + cardCount);
		softAssert.assertAll();
		testlog.pass("**Verify card count successfully**");
	}

	public void profile(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("ProfileTab", 60);
		CommonMethod.RobustclickElementVisible("ProfileTab", "V2ProjectGeneralInformation");
		CommonMethod.WaitUntilVisibility("V2ProjectGeneralInformation", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectGeneralInformation", "V2ProjectProjectBio");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectBio", 60);
		CommonMethod.clearAndSendKey("V2ProjectProjectBio", "Project bio testing");
		CommonMethod.uploadFile("V2ProjectLogo", SampleJpgfile);
		CommonMethod.uploadFile("V2ProjectProfileImage", SampleJpgfile);
		CommonMethod.WaitUntilVisibility("V2ProjectPrimaryProfileImageDeleteVerify", 120);
		CommonMethod.WaitUntilVisibility("V2ProjectProfileImageDeleteVerify", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectProfileUpdatedToastMessage");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Profile updated successfully.", "Verified profile updated toast message");
		testlog.pass("**General Information data updated successfully**");
		CommonMethod.WaitUntilVisibility("ProfileTab", 60);
		if(SheetName.equalsIgnoreCase("Wpr")) {
			CommonMethod.RobustclickElementVisible("ProfileTab", "WellPerformanceProfileButton");
			CommonMethod.WaitUntilVisibility("WellPerformanceProfileButton", 60);
			CommonMethod.RobustclickElementVisible("WellPerformanceProfileButton", "V2ProjectYourObjective");
		}
		if(SheetName.equalsIgnoreCase("Hsr")) {
			CommonMethod.RobustclickElementVisible("ProfileTab", "WellHealthSafty");
			CommonMethod.WaitUntilVisibility("WellHealthSafty", 60);
			CommonMethod.RobustclickElementVisible("WellHealthSafty", "V2ProjectYourObjective");
		}
		if(SheetName.equalsIgnoreCase("Wer")) {
			CommonMethod.RobustclickElementVisible("ProfileTab", "WERProfileWellEquityStoryButton");
			CommonMethod.WaitUntilVisibility("WERProfileWellEquityStoryButton", 60);
			CommonMethod.RobustclickElementVisible("WERProfileWellEquityStoryButton", "V2ProjectYourObjective");	
		}
		CommonMethod.WaitUntilVisibility("V2ProjectYourObjective", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourObjective", "Your objective testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourOrganization", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourOrganization", "Your organization testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourWellGoals", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourWellGoals", "Your well goals testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourWellProject", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourWellProject", "Your well project testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourWellFeatures", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourWellFeatures", "Your well features testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourWellCertification", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourWellCertification", "Your well certification testing");
		CommonMethod.WaitUntilVisibility("V2ProjectPostCertificationMetric", 60);
		CommonMethod.clearAndSendKey("V2ProjectPostCertificationMetric", "Post certification metric testing");
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectProfileUpdatedToastMessage");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Profile updated successfully.", "Verified profile updated toast message");
		softAssert.assertAll();
		testlog.pass("**Certification story data updated successfully**");
	}
	public void addLocation(String SheetName, int rowNum) throws Exception {
		if (SheetName.equalsIgnoreCase("Wpr") || SheetName.equalsIgnoreCase("Hsr") || SheetName.equalsIgnoreCase("Portfolio")) {
			CommonMethod.WaitUntilPresence("LocationTab", 120);
			CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");		
		}
        CommonMethod.WaitUntilPresence("AddButton", 120);
		CommonMethod.RobustclickElementVisible("AddButton", "AddLocationButton");
		CommonMethod.WaitUntilPresence("AddLocationButton", 120);
		if (SheetName.equalsIgnoreCase("Wpr") || SheetName.equalsIgnoreCase("Hsr") || SheetName.equalsIgnoreCase("Wer")) {
			CommonMethod.RobustclickElementVisible("AddLocationButton","LocationName");
			CommonMethod.RobustclickElementVisible("SubmitButton", "LocationName");
			CommonMethod.negativesoftassertPageSource("Location Name* is required.", "Location Name Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Location Area* is required.", "Location Area Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Space Type* is required.", "Space Type Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Ownership Type* is required.", "Ownership Type Error Mismatch");
			CommonMethod.WaitUntilVisibility("LocationName", 120);
			CommonMethod.sendKeys("LocationName", data.getCellData(SheetName, "LocationName", rowNum));
			CommonMethod.sendKeys("LocationArea", data.getCellData(SheetName, "Area", rowNum));
			CommonMethod.selectdropdownrandom("LocationSpaceType");
			data.setCellData(SheetName, "SpaceTypes", rowNum,
					CommonMethod.getSelectedDropdownValue("LocationSpaceType"));
			testlog.info("Space type: " + data.getCellData(SheetName, "SpaceTypes", rowNum));
			CommonMethod.selectdropdownrandom("LocationOwnershipType");
			data.setCellData(SheetName, "OwnerType", rowNum,
					CommonMethod.getSelectedDropdownValue("LocationOwnershipType"));
			testlog.info("Owner type: " + data.getCellData(SheetName, "OwnerType", rowNum));
		} else if (SheetName.equalsIgnoreCase("Portfolio")) {
			CommonMethod.RobustclickElementVisible("AddLocationButton","PortfolioLocationProjectName");
			CommonMethod.RobustclickElementVisible("SubmitButton", "PortfolioLocationProjectName");
			CommonMethod.WaitUntilVisibility("PortfolioLocationProjectName", 120);
			CommonMethod.sendKeys("PortfolioLocationProjectName", data.getCellData(SheetName, "ProjectName", rowNum));
			CommonMethod.selectdropdownrandom("PortfolioLocationProjectVersion");
			data.setCellData(SheetName, "ProjectVersion", rowNum,
					CommonMethod.getSelectedDropdownValue("PortfolioLocationProjectVersion"));
			testlog.info("Project Version: " + data.getCellData(SheetName, "ProjectVersion", rowNum));
			CommonMethod.sendKeys("PortfolioLocationProjectArea", data.getCellData(SheetName, "AreaSQFT", rowNum));
			CommonMethod.selectdropdownrandom("PortfolioLocationSpaceType");
			data.setCellData(SheetName, "SpaceTypes", rowNum,
					CommonMethod.getSelectedDropdownValue("PortfolioLocationSpaceType"));
			testlog.info("Space type: " + data.getCellData(SheetName, "SpaceTypes", rowNum));
			CommonMethod.selectdropdownrandom("PortfolioLocationOwnerType");
			data.setCellData(SheetName, "OwnerType", rowNum,
					CommonMethod.getSelectedDropdownValue("PortfolioLocationOwnerType"));
			testlog.info("Owner type: " + data.getCellData(SheetName, "OwnerType", rowNum));
		}
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Name Error Mismatch");
		CommonMethod.selectdropdownValue("LocationCountryName", "US");
		CommonMethod.selectdropdownrandom("LocationStateName");
		CommonMethod.sendKeys("LocationStreetName", data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("LocationCityName", data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("LocationPostalCode", data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.RobustclickElementVisible("SubmitButton", "LocationResultCount");
		CommonMethod.refreshBrowser();
		/*
		 * Validate location added successfully
		 */
		CommonMethod.WaitUntilPresence("AddButton", 300);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilPresence("LocationResultCount", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("LocationResultCount"), "6",
				"Result location count doesn't match");
		softAssert.assertAll();
		testlog.pass("**Added single location successfully**");
	}
	public void ClickBilling(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 120);
		CommonMethod.RobustclickElementVisible("BiilingTab", "DownloadReceipt");
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void DownloadBillingReceiptAndValidate(String SheetName, int rowNum, String Country)
			throws IOException, InterruptedException {
		String Amount = data.getCellData(SheetName, "EnrollFee", rowNum);
		testlog.info("Amount: "+ Amount);
		String Address = null;
		if (Country.equalsIgnoreCase("US")) {
			Address = "New York, NY 10014";
			testlog.info("Address: "+ Address);
		} else {
			Address = "IWBI China(HK) Limited";
			testlog.info("Address: "+ Address);
		}
		String[] ProjDetails = { Address, Amount };
		CommonMethod.WaitUntilVisibility("DownloadReceipt", 120);
		CommonMethod.click("DownloadReceipt");
		Thread.sleep(2000);
		if (CommonMethod.isFileExists(downloadPath)) {
			File path = new File(downloadPath);
			File[] files = path.listFiles();
			for (File file : files) {
				String ReceiptContent = CommonMethod.extractPDFContent(file.toString());
				for (String s : ProjDetails) {
					CommonMethod.assertActualContainsExpected(ReceiptContent, s);
				}
			}
		}
		testlog.pass("**Verifies Download Billing Receipt And Validate successfully**");
	}
	
	public void teamMemberLogin(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username",data.getCellData(SheetName, "TeamEmailID", rowNum));
		testlog.info("Sending Username " + data.getCellData(SheetName, "TeamEmailID", rowNum));
		CommonMethod.findElementWithRelative("LoginButton", "Password", "above").sendKeys(data.getCellData("Login", "Password", 3));;
		testlog.info("Sending Password " + data.getCellData("Login", "Password", 3));
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("LoginButton");
		CommonMethod.RobustclickElementVisible("LoginButton","SuccessfulLogin");
		testlog.info("Clicking on Submit Button");
		CommonMethod.WaitUntilVisibility("SuccessfulLogin", 300);
		testlog.pass("Verfies Login Successful");
	}
	public void validateTeams(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 120);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("WELLCertificationNavBar", "V2ProjectId");
		testlog.info("ProjectId: " + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilClickble("V2ProjectId", 60).click();
		CommonMethod.sendKeys("V2ProjectId",data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("V2ProjectApplybtn","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","V2 Search failed");
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify", data.getCellData(SheetName, "ProjectID", rowNum), "Project name doesn't matches in search");
		softAssert.assertAll();
		testlog.pass("**Verifies user able to access the invited project**");
	}
	public void clickOnTeamTab(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TeamTab", 300);
		CommonMethod.RobustclickElementVisible("TeamTab","V2ProjectAddMemberbtn");
	}
	public void errorMessageNegativeAssert() throws IOException, InterruptedException {
		negativesoftAssert.assertAll();
		testlog.pass("**Verifies Error Message for Madatory field**");
	}
	public void searchFilterDocument(String documentName, String fileCount)
			throws IOException, InterruptedException {
		CommonMethod.RobustclickElementVisible("WPRDocumentFilterOption", "WPRDocumentSearchBox");
		CommonMethod.clearAndSendKey("WPRDocumentSearchBox", documentName);
		CommonMethod.WaitUntilPresence("WPRDocumentSpinner", 120);
		CommonMethod.WaitUntilInVisibility("WPRDocumentSpinner", 60);
		CommonMethod.WaitUntilVisibility("PortfolioScorecardDocumentUploadTable", 60);
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(0), "FeatureFile", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Verifies search filter successfully **");
	}
	public void VerifyScorecardPurseStatusCount(String SheetName,String expectedPartCount,String expectedYesCount,String expectedNoCount, int rowNum) throws IOException, InterruptedException {
		/*
		 * Total FeaturePartCount
		 */
		CommonMethod.WaitUntilPresence("V2ProjectScorecardPartCount", 300);
		int ScorecardPart = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
		String FeatureScorecardPartCount = Integer.toString(ScorecardPart);
		testlog.info("FeatureScorecardPartCount: " + FeatureScorecardPartCount);
		data.setCellData(SheetName, "ScorecardPartCount", rowNum, FeatureScorecardPartCount);
		CommonMethod.softAssertEqualsMessage(data.getCellData(SheetName, "ScorecardPartCount", rowNum),expectedPartCount,
				"ScorecardPartCount doesn't match");

		/*
		 * YesPurseCount
		 */
		int YesFeature = CommonMethod.ElementSize("CommonSelectedPurseYes");
		String YesFeatureCount = Integer.toString(YesFeature);
		testlog.info("YesFeatureCount: " + YesFeatureCount);
		data.setCellData(SheetName, "YesPurseCount", rowNum, YesFeatureCount);
		CommonMethod.softAssertEqualsMessage(data.getCellData(SheetName, "YesPurseCount", rowNum), expectedYesCount,
				"YesPurseCount doesn't match");
		/*
		 * NoPurseCount
		 */
		int NoFeature = CommonMethod.ElementSize("CommonSelectedPurseNo");
		String NoFeatureCount = Integer.toString(NoFeature);
		testlog.info("NoFeatureCount: " + NoFeatureCount);
		data.setCellData(SheetName, "NoPurseCount", rowNum, NoFeatureCount);
		CommonMethod.softAssertEqualsMessage(data.getCellData(SheetName, "NoPurseCount", rowNum), expectedNoCount ,
				"NoPurseCount doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies the "+expectedPartCount+" Purse Yes Scorecard V2Project successfully**");
		testlog.pass("**Verifies the "+expectedYesCount+" Purse No Scorecard V2Project successfully**");
		testlog.pass("**Verifies the "+expectedNoCount+" Purse Scorecard Part Count V2Project successfully**");
	}
}
