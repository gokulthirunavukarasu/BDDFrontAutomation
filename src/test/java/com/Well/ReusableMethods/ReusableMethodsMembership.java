package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsMembership extends BaseClass {

	public void RegisterMembership(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("MPUserMenu", 60);
		CommonMethod.RobustclickElementVisible("MPUserMenu", "MPMyMembership");
		CommonMethod.RobustclickElementVisible("MPMyMembership", "MPMembershipLanding");
		CommonMethod.WaitUntilVisibility("MPMembershipLanding", 60);
		CommonMethod.refreshBrowser();
		CommonMethod.scrolldowntoElement("MPCornerstoneAmount");
		testlog.info("MembershipName:" + MembershipName);
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.RobustclickElementVisible("MPCornerstonebtn", "MPorganization");
		} else if (MembershipName.equalsIgnoreCase("Keystone")) {
			CommonMethod.RobustclickElementVisible("MPKeystonebtn", "MPorganization");
		}
		CommonMethod.RobustclickElementVisible("MPorgcontinuebtn", "MPorganization");
		CommonMethod.negativesoftassertPageSource("Organization name* is required.",
				"Organization Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Logo* is required.",
				"Organization Logo Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Number of years* is required.", "Number of Years Error Mismatch");
		String firstName = USfaker.address().firstName();
		CommonMethod.sendKeys("MPorganization", firstName);
		data.setCellData(SheetName, "Organization", rowNum, CommonMethod.getattributeValue("MPorganization"));
		CommonMethod.uploadFile("WFProvideUpload", SampleJpgfile);
		CommonMethod.ClickCheckbox("MPNumberofyearsrtn");
		CommonMethod.sendKeys("MPorganizationwebsite", "https://test-nuxt.wellcertified.com/");
		data.setCellData(SheetName, "Organizationwebsite", rowNum,
				CommonMethod.getattributeValue("MPorganizationwebsite"));
		CommonMethod.WaitUntilVisibility("MPorgcontinuebtn", 30);
		testlog.info("organizationName: " + data.getCellData(SheetName, "Organization", rowNum));
		testlog.info("organizationwebsite: " + data.getCellData(SheetName, "Organizationwebsite", rowNum));
		CommonMethod.RobustclickElementVisible("MPorgcontinuebtn", "MPNamePointContact");
		CommonMethod.WaitUntilVisibility("MPNamePointContact", 30);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void EnrollMembership(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Point Contact
		 */
		CommonMethod.RobustclickElementVisible("MPContinuebutton", "MPNamePointContact");
		CommonMethod.negativesoftassertPageSource("Name is required.", "Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Email Address is required.", "Email Address Error Mismatch");
		CommonMethod.WaitUntilVisibility("MPNamePointContact", 30);
		String firstName = USfaker.address().firstName();
		String PhoneNumber = USfaker.number().digits(10);
		String email = USfaker.internet().emailAddress();
		testlog.info("website:" + "https://test-nuxt.wellcertified.com/");
		testlog.info("firstName:" + firstName);
		testlog.info("phonenumber: " + PhoneNumber);
		CommonMethod.sendKeys("MPNamePointContact", firstName);
		data.setCellData(SheetName, "Name", rowNum, CommonMethod.getattributeValue("MPNamePointContact"));
		CommonMethod.sendKeys("MPEmail", email);
		data.setCellData(SheetName, "Email", rowNum, CommonMethod.getattributeValue("MPEmail"));
		CommonMethod.sendKeys("MPJobtitle", "Testing");
		data.setCellData(SheetName, "JobTitle", rowNum, CommonMethod.getattributeValue("MPJobtitle"));
		CommonMethod.sendKeys("MPPhonenumber", PhoneNumber);
		data.setCellData(SheetName, "PhoneNumber", rowNum, CommonMethod.getattributeValue("MPPhonenumber"));
		CommonMethod.ClickCheckbox("MPContactdetailscheckbox");
		testlog.info("Name: " + data.getCellData(SheetName, "Name", rowNum));
		testlog.info("Email: " + data.getCellData(SheetName, "Email", rowNum));
		testlog.info("JobTitle: " + data.getCellData(SheetName, "JobTitle", rowNum));
		CommonMethod.RobustclickElementVisible("MPContinuebutton", "MPMembershipOwnerContinue");
		/*
		 * Owner details
		 */
		CommonMethod.RobustclickElementVisible("MPMembershipOwnerContinue", "MPOwnername");
		CommonMethod.negativesoftassertPageSource("Owner Name is required.", "Owner Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner Email Address is required.",
				"Owner Email Address Error Mismatch");
		CommonMethod.WaitUntilVisibility("MPOwnername", 30);
		CommonMethod.sendKeys("MPOwnername", firstName);
		data.setCellData(SheetName, "Name", rowNum, CommonMethod.getattributeValue("MPOwnername"));
		CommonMethod.sendKeys("MPOwnerEmail", email);
		data.setCellData(SheetName, "Email", rowNum, CommonMethod.getattributeValue("MPOwnerEmail"));
		testlog.info("Ownerjob:" + "Testing");
		CommonMethod.sendKeys("MPOwnerjob", "Testing");
		data.setCellData(SheetName, "JobTitle", rowNum, CommonMethod.getattributeValue("MPOwnerjob"));
		CommonMethod.sendKeys("MPOwnernumber", PhoneNumber);
		data.setCellData(SheetName, "PhoneNumber", rowNum, CommonMethod.getattributeValue("MPOwnernumber"));
		CommonMethod.RobustclickElementVisible("MPMembershipOwnerContinue", "MPOfficecontinuebtn");
		/*
		 * Office Address
		 */
		CommonMethod.RobustclickElementVisible("MPOfficecontinuebtn", "MPOfficecountry");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");

		CommonMethod.WaitUntilVisibility("MPOfficecountry", 30);
		CommonMethod.selectdropdownVisibletext("MPOfficecountry", "United States");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("MPOfficestate");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("MPOfficestate"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("MPOfficestreet", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("MPOfficestreet"));
		CommonMethod.sendKeys("MPOfficecity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("MPOfficecity"));
		CommonMethod.sendKeys("MPOfficePostalCode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("MPOfficePostalCode"));
		testlog.info("Country: " + data.getCellData(SheetName, "Country", rowNum));
		testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
		testlog.info("Street: " + data.getCellData(SheetName, "Street", rowNum));
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.RobustclickElementVisible("MPOfficecontinuebtn", "MPTermscheckbox");
		/*
		 * Term
		 */
		CommonMethod.RobustclickElementVisible("MPProcedtopaymentbtn", "MPTermscheckbox");
		CommonMethod.negativesoftassertPageSource("I accept the terms and conditions is required.",
				"Terms And Conditions Error Mismatch");
		CommonMethod.WaitUntilVisibility("MPTermscheckbox", 30);
		CommonMethod.ClickCheckbox("MPTermscheckbox");
		CommonMethod.scrolldowntoElement("MPProcedtopaymentbtn");
		CommonMethod.RobustclickElementVisible("MPProcedtopaymentbtn", "MPProcedtoConfirmationPaymentbtn");
		CommonMethod.RobustclickElementVisible("MPProcedtoConfirmationPaymentbtn", "BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies Enrollment successfully**");
	}

	public void BillingMembership(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		rc.Billing(SheetName, rowNum);
		testlog.info("MembershipName:" + MembershipName);
		CommonMethod.WaitUntilVisibility("MPValidMembershipeType", 60);
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.assertcontainsmessage("MPValidMembershipeType", "CORNERSTONE MEMBERSHIP",
					"Mismatch Cornerstone Membership Name");
		} else if (MembershipName.equalsIgnoreCase("Keystone")) {
			CommonMethod.assertcontainsmessage("MPValidMembershipeType", "KEYSTONE MEMBERSHIP",
					"Mismatch KEYSTONE Membership Name");
		}
		testlog.pass("**Verified Membership Name successfully**");
	}

	public void AdminMembershipNavigation(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminMembershipNavBar");
		CommonMethod.WaitUntilPresence("AdminMembershipNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminMembershipNavBar", "MPViewButton");
		CommonMethod.WaitUntilPresence("MPViewButton", 60);
		CommonMethod.RobustclickElementVisible("MPViewButton", "ProfileTab");
		CommonMethod.RobustclickElementVisible("ProfileTab", "MPLicensingProgramCheckbox");
		CommonMethod.RobustclickElementVisible("MPLicensingProgramCheckbox", "MPProfileUpdateButton");
		CommonMethod.RobustclickElementVisible("MPProfileUpdateButton", "MPLicensingTab");
		CommonMethod.RobustclickElementVisible("MPLicensingTab", "MPDownloadApplicationform");
		CommonMethod.WaitUntilVisibility("MPDownloadApplicationform", 120);
		CommonMethod.RobustclickElementVisible("MPDownloadApplicationform", "MPLicensingContinue");
		Thread.sleep(2000);
		CommonMethod.isFileExists(downloadPath);
		CommonMethod.RobustclickElementVisible("MPLicensingContinue", "MPApplicationform");
		testlog.pass("**Verifies Navigate to Product Licensing Page successfully**");
	}

	public void UploadDocumentInLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.uploadFile("MPProductUploadForm", ProductInfoFormfileUpload, "MPValidUploadFile");
		testlog.pass("**Verifies Uploaded File successfully**");
	}

	public void CreateLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.RobustclickElementVisible("MPSaveProductButton", "MPSelectProductCategories");
		CommonMethod.negativesoftassertPageSource("Categories is required.", "Categories Error Mismatch");
		CommonMethod.negativesoftassertPageSource("ProductType is required.", "ProductType Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Parts is required.", "Feature Parts Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Group name is required.", "Group Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Document is required.", "Document Error Mismatch");
		CommonMethod.negativesoftassertPageSource("At least one supporting document is required.",
				"At least one supporting document Error Mismatch");
		for (int i = 1; i <= 3; i++) {
			int j = i + 1;
			CommonMethod.uploadFile("MPApplicationform", ProductInfoFormfileUpload, "MPApplicationformDeleteIcon");
			CommonMethod.uploadFile("MPSupportingdocuments", ProductInfoFormfileUpload, "MPSupportingdocumentsIcon");
			CommonMethod.selectdropdownrandom("MPSelectProductCategories");
			String ProductCategories = CommonMethod.getSelectedDropdownValue("MPSelectProductCategories");
			testlog.info("ProductCategories: " + ProductCategories);
			data.setCellData(SheetName, "ProductCategories", j, ProductCategories);
			CommonMethod.selectdropdownrandom("MPSelectproductType");
			String getproductType = CommonMethod.getSelectedDropdownValue("MPSelectproductType");
			testlog.info("ProductType: " + getproductType);
			data.setCellData(SheetName, "ProductType", j, getproductType);
			CommonMethod.WaitUntilVisibility("MPSelectPartname", 120);
			CommonMethod.RobustclickElementVisible("MPSelectPartname", "MPSelectPartnameChild");
			CommonMethod.RobustclickElementVisible("MPSelectPartnameChild", "MPGroupName");
			data.setCellData(SheetName, "FeaturePart", j, CommonMethod.getText("MPLicenseValidFeaturePart"));
			CommonMethod.sendKeys("MPGroupName", data.getCellData(SheetName, "GroupName", j));
			CommonMethod.sendKeys("MPLicenseComment", "QA Team");
			String getComment = CommonMethod.getattributeValue("MPLicenseComment");
			data.setCellData(SheetName, "Comment", j, getComment);
			CommonMethod.RobustclickElementVisible("MPSaveProductButton", "MPValidGroupName");
			CommonMethod.scrolldowntoElement("MPValidUploadFile");
			CommonMethod.WaitUntilPresence("MPValidGroupName", 120);
		}
		List<WebElement> Feature = CommonMethod.findElements("MPLicenseValidGroupName");
		int tempRowNum = rowNum;
		for (WebElement ele : Feature) {
			String GroupName = ele.getText();
			CommonMethod.softAssertContainsMessage(GroupName, data.getCellData(SheetName, "GroupName", rowNum),
					"GroupName data mismatch");
			rowNum++;
		}
		rowNum = tempRowNum;
		List<WebElement> FeaturePart = CommonMethod.findElements("MPLicenseValidFeaturePartName");
		for (WebElement ele : FeaturePart) {
			String getFeaturePart = ele.getText();
			CommonMethod.softAssertContainsMessage(getFeaturePart, data.getCellData(SheetName, "FeaturePart", rowNum),
					"FeaturePart data mismatch");
			rowNum++;
		}
		CommonMethod.assertcountListWebelementFromIndex("MPLicenseProductCard", 3);
		CommonMethod.assertcountListWebelementFromIndex("MPLicenseEdit", 3);
		CommonMethod.assertcountListWebelementFromIndex("MPDeleteIcon", 4);
		softAssert.assertAll();
		testlog.pass("**Verifies Created Product Licensing successfully**");
		testlog.pass("**Verifies added 3 Product Licensing Group successfully**");
	}

	public void UpdateLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("MPValidUploadFile", 120);
		CommonMethod.clickOnListWebelementFromIndex("MPLicenseEdit", 0);
		CommonMethod.WaitUntilPresence("MPLicenseUpdateCloseFeaturePart", 60);
		CommonMethod.RobustclickElementVisible("MPLicenseUpdateCloseFeaturePart", "MPSelectUpdateProductCategories");
		CommonMethod.WaitUntilInVisibility("MPLicenseUpdateCloseFeaturePart", 120);
		CommonMethod.selectdropdownVisibletext("MPSelectUpdateProductCategories", "Communications");
		CommonMethod.selectdropdownVisibletext("MPSelectproductType", "Audio-Video Systems");
		CommonMethod.WaitUntilVisibility("MPSelectPartname", 30);
		CommonMethod.RobustclickElementVisible("MPSelectPartname", "MPSelectPartnameChild");
		CommonMethod.RobustclickElementVisible("MPSelectPartnameChild", "MPGroupName");
		CommonMethod.WaitUntilVisibility("MPLicenseComment", 60);
		Thread.sleep(2000);
		CommonMethod.scrolldowntoElement("MPLicenseComment");
		CommonMethod.WaitUntilVisibility("MPLicenseUpdateSaveButton", 120);
		CommonMethod.Robustclick("MPLicenseUpdateSaveButton", "MPLicenseUpdaateClosePopup");
		Thread.sleep(2000);
		CommonMethod.scrolldowntoElement("MPValidUploadFile");
		CommonMethod.WaitUntilPresence("MPValidGroupName", 120);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MPValidType"), "Audio-Video Systems",
				"GroupName doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MPValidCategory"), "Communications",
				"Category doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies Updated Product Licensing successfully**");
	}

	public void DeleteLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("MPValidUploadFile", 120);
		CommonMethod.clickOnListWebelementFromIndex("MPDeleteIcon", 2);
		CommonMethod.RobustclickElementVisible("MPLicenseProductDelete", "MPSelectProductCategories");
		CommonMethod.assertcountListWebelementFromIndex("MPDeleteIcon", 3);
		testlog.pass("**Verifies Delete Product Licensing Group successfully**");
		softAssert.assertAll();
	}

	public void SubmitProductLicensingReview(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("MPLicenseSubmitForReview", 120);
		CommonMethod.RobustclickElementVisible("MPLicenseSubmitForReview", "MPLicenseDeleteProduct");
		CommonMethod.assertcountListWebelementFromIndex("MPLicenseProductCard", 2);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MPLicenseReviewStatus"), "UNDER REVIEW",
				"Review Status doesn't match");
		CommonMethod.scrolldowntoElement("MPLicenseReviewStatus");
		CommonMethod.RobustclickElementVisible("MPLicenseDeleteProduct", "MPLicenseProductDelete");
		CommonMethod.RobustclickElementVisible("MPLicenseProductDelete", "MPLicensingProgramCheckbox");
		CommonMethod.WaitUntilPresence("MPLicensingProgramCheckbox", 120);
		CommonMethod.RobustclickElementVisible("MPLicensingTab", "MPDownloadApplicationform");
		CommonMethod.WaitUntilInVisibility("MPLicenseDeleteProduct", 120);
		softAssert.assertAll();
		testlog.info("**Verifies Product Licensing Review Status successfully**");
		testlog.info("**Verifies Deleted Product Licensing successfully**");
		testlog.pass("**Verifies Submitted Product Licensing Review successfully**");

	}
	public void PromotionCardValidation(String SheetName, int rowNum, String cardValue) throws Exception {
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, cardValue);
		testlog.info("Card count: " + cardCount);
		softAssert.assertAll();
		testlog.pass("**Verify card count successfully**");

	}
	public void ValidatePromtionCard(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("PromotionTab", 60);
		CommonMethod.RobustclickElementVisible("PromotionTab", "PromotionCardContainer");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MembershipPromotionMembershipName"),
				data.getCellData(SheetName, "Organization", rowNum), "Membership Name doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MembershipPromotionMembershipType"),
				"CORNERSTONE MEMBERSHIP", "Membership Type doesn't match");
		softAssert.assertAll();
		PromotionCardValidation(SheetName, rowNum, "6");
	}
	
	public void ValidateEducationCard(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EducationTab", 60);
		CommonMethod.RobustclickElementVisible("EducationTab", "PromotionCardContainer");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MembershipPromotionMembershipName"),
				data.getCellData(SheetName, "Organization", rowNum), "Membership Name doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MembershipPromotionMembershipType"),
				"CORNERSTONE MEMBERSHIP", "Membership Type doesn't match");
		softAssert.assertAll();
		PromotionCardValidation(SheetName, rowNum, "15");
	}
	
	public void AddTeamMember(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("TeamTab", 300);
		CommonMethod.RobustclickElementVisible("TeamTab","V2ProjectAddMemberbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn","MembershipTeamEmailAddress");
		String TeamEmail = data.getCellData(SheetName, "TeamEmailID", rowNum);
		CommonMethod.WaitUntilVisibility("MembershipTeamEmailAddress", 30);
		CommonMethod.sendKeys("MembershipTeamEmailAddress", TeamEmail);
		testlog.info("Team Email ID: " +TeamEmail);
		CommonMethod.ClickCheckbox("MembershipTeamRoleOption");
		CommonMethod.WaitUntilVisibility("V2ProjectInvitebtn", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn","V2ProjectDeleteIcon");
		CommonMethod.WaitUntilVisibility("V2ProjectDeleteIcon", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectDeleteIcon","V2ProjectAddMemberbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 300);
		softAssert.assertAll();
		testlog.pass("**Created Team member successfully**");		
	}
	
	public void ProfileUpdated(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("ProfileTab", 300);
		CommonMethod.RobustclickElementVisible("ProfileTab","MembershipProfileAboutYourOrg");
		CommonMethod.WaitUntilVisibility("MembershipProfileAboutYourOrg", 300);
		CommonMethod.sendKeys("MembershipProfileAboutYourOrg", "Tell us about your organization and what you do.");
		CommonMethod.sendKeys("MembershipProfileOrgHealthAndWellness", "Which of your organization’s health and wellness achievements have been the most impactful, or make you feel pride");
		CommonMethod.scrolldowntoElement("MembershipProfileWellnessValue");
		CommonMethod.sendKeys("MembershipProfileOrgMission", "What is your organization’s mission");
		CommonMethod.sendKeys("MembershipProfileIWBIMember", "Why is your organization an IWBI member");
		CommonMethod.sendKeys("MembershipProfileWellnessValue", "How does your team live their wellness values");
		CommonMethod.scrolldowntoElement("MembershipProfileUpdateButton");
		CommonMethod.RobustclickElementVisible("MembershipProfileUpdateButton", "MembershipProfileAboutYourOrg");
		CommonMethod.RobustclickElementVisible("ProfileTab","MembershipProfileAboutYourOrg");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MembershipProfileAboutYourOrg"),
				"Tell us about your organization and what you do.", "About Org Answer doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MembershipProfileOrgHealthAndWellness"),
				"Which of your organization’s health and wellness achievements have been the most impactful, or make you feel pride", "Org Health And Wellness Answer doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MembershipProfileOrgMission"),
				"What is your organization’s mission", "Org Mission Answer doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MembershipProfileIWBIMember"),
				"Why is your organization an IWBI member", "IWBI Member Answer doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MembershipProfileWellnessValue"),
				"How does your team live their wellness values", "Team Wellness Value Answer doesn't match");
		softAssert.assertAll();
	}
}