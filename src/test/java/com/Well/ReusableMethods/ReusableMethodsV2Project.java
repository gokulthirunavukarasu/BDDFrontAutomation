package com.Well.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsV2Project extends BaseClass {

	public void RegisterV2Project(String SheetName, int rowNum, String ProjectType, String Country)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("WELLCertificationNavBar", "V2Projectstartav2projectbtn");
		CommonMethod.WaitUntilVisibility("V2Projectstartav2projectbtn", 300);
		CommonMethod.Robustclick("V2Projectstartav2projectbtn");
		CommonMethod.Robustclick("V2ProjectstartProjectcontinuebtn");
		CommonMethod.RobustclickElementVisible("V2ProjectnicknameContinuebtn", "MandatoryFieldErrorMessage");
		CommonMethod.negativesoftassertPageSource("Project nickname is required.", "Project Name Error Mismatch");
		String ProjectName = "Automation V2 Project" + CommonMethod.randomNumber(8000000);
		testlog.info("V2 ProjectName is: " + ProjectName);
		data.setCellData(SheetName, "ProjectName", rowNum, ProjectName);
		CommonMethod.sendKeys("V2Projectprojectnickname", ProjectName);
		CommonMethod.RobustclickElementVisible("V2ProjectnicknameContinuebtn", "V2ProjectlocationContinuebtn");
		CommonMethod.RobustclickElementVisible("V2ProjectlocationContinuebtn", "V2ProjectlocationStreet");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		rc.SelectCountryAndState(Country, SheetName, rowNum);
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Street: " + ProjectAddress);
		testlog.info("City: " + ProjectCity);
		testlog.info("Postalcode: " + PostalCode);
		CommonMethod.sendKeys("V2ProjectlocationStreet", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("V2ProjectlocationStreet"));
		CommonMethod.sendKeys("V2ProjectlocationCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("V2ProjectlocationCity"));
		CommonMethod.sendKeys("V2ProjectlocationPostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum,
				CommonMethod.getattributeValue("V2ProjectlocationPostalcode"));
		CommonMethod.RobustclickElementVisible("V2ProjectlocationContinuebtn", "V2ProjectareaContinuebtn");
		String Area = CommonMethod.randomNumberBetweenRanges(100, 85000);
		CommonMethod.clearAndSendKey("V2ProjectareaSize", Area);
		data.setCellData(SheetName, "Area", rowNum, CommonMethod.getattributeValue("V2ProjectareaSize"));
		testlog.info("Area: " + data.getCellData(SheetName, "Area", rowNum));
		CommonMethod.RobustclickElementVisible("V2ProjectareaContinuebtn", "V2ProjectspacetypeContinuebtn");
		CommonMethod.RobustclickElementVisible("V2ProjectspacetypeContinuebtn", "V2ProjectspaceType");
		CommonMethod.negativesoftassertPageSource("You need at least 1 checkbox.", "CheckBox Error Mismatch");
		CommonMethod.ClickCheckbox("V2ProjectspaceType");
		CommonMethod.WaitUntilVisibility("V2ProjectspacetypeContinuebtn", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectspacetypeContinuebtn", "V2Projectwellcorecertification");
		if (ProjectType.equalsIgnoreCase("WELLCore")) {
			CommonMethod.WaitUntilVisibility("V2Projectwellcorecertification", 30);
			CommonMethod.Robustclick("V2Projectwellcorecertification");
			if (CommonMethod.isElementsExist("HsrIframe", 60)) {
			CommonMethod.WaitUntilPresence("HsrIframe", 180);
			CommonMethod.switchToFrame("HsrIframe");
			CommonMethod.WaitUntilPresence("HsrCloseCard", 60);
			CommonMethod.Robustclick("HsrCloseCard");
			CommonMethod.switchToParentFrame();
			}
		} else if (ProjectType.equalsIgnoreCase("WELLCertification")) {
			CommonMethod.WaitUntilVisibility("V2ProjectwellCertification", 30);
			CommonMethod.RobustclickElementVisible("V2ProjectwellCertification", "V2ProjectownershipOflocation");
			CommonMethod.WaitUntilVisibility("V2ProjectownershipOflocation", 30);
			CommonMethod.RobustclickElementVisible("V2ProjectownershipContinuebtn", "V2ProjectownershipOflocation");
			CommonMethod.negativesoftassertPageSource("Ownership type is required.", "CheckBox Error Mismatch");
			CommonMethod.ClickCheckbox("V2ProjectownershipOflocation");
			CommonMethod.RobustclickElementVisible("V2ProjectownershipContinuebtn", "DatePickerButton");
		}
		CommonMethod.WaitUntilVisibility("DatePickerButton", 300);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilVisibility("V2ProjectnextYearbtn", 120);
		CommonMethod.Robustclick("V2ProjectnextYearbtn", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilVisibility("V2ProjectselectNextYear", 120);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("V2ProjectselectNextYear", "DatePickerOkButton");
		Thread.sleep(1000);
		CommonMethod.WaitUntilVisibility("DatePickerOkButton", 120);
		CommonMethod.Robustclick("DatePickerOkButton", "V2ProjectselectNextYear");
		CommonMethod.WaitUntilVisibility("V2ProjectnextMonthbtn", 120);
		CommonMethod.Robustclick("V2ProjectnextMonthbtn", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilVisibility("V2ProjectselectNextMonth", 120);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("V2ProjectselectNextMonth", "DatePickerOkButton");
		Thread.sleep(1000);
		CommonMethod.WaitUntilVisibility("DatePickerOkButton", 120);
		CommonMethod.Robustclick("DatePickerOkButton", "V2ProjectselectNextMonth");
		CommonMethod.WaitUntilPresence("DatePickerOkButton", 120);
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "V2ProjectdocsubConfirmbtn");
		CommonMethod.WaitUntilClickble("V2ProjectdocsubConfirmbtn", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectdocsubConfirmbtn", "V2Projectcontinuethejourneybtn");
		CommonMethod.RobustclickElementVisible("V2Projectcontinuethejourneybtn", "EnrollTab");
		CommonMethod.WaitUntilVisibility("EnrollTab", 300);
		CommonMethod.WaitUntilVisibility("StoreId", 60);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getProjectId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getProjectId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void SearchV2ById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 120);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("WELLCertificationNavBar", "V2ProjectId");
		CommonMethod.WaitUntilClickble("V2ProjectId", 60);
		testlog.info("ProjectId:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("V2ProjectId", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("V2ProjectApplybtn", "V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var), "1", "V2 Search failed");
	}

	public void ClickSearchV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "ProjectID", rowNum), "Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "V2ProjectStartBuilding");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 300);
	}

	public void SearchV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		SearchV2ById(SheetName, rowNum);
		ClickSearchV2ProjectById(SheetName, rowNum);
		testlog.pass("**Verifies the Search V2Project ByID successfully**");
	}

	public void SearchV2ProjectFilterByStatus(String SheetName, int rowNum, String Status, String Status1)
			throws IOException, InterruptedException {
		testlog.info("StatusList: " + Status);
		CommonMethod.selectdropdownVisibletext("V2ProjectIdStatusList", Status);
		CommonMethod.RobustclickElementVisible("V2ProjectApplybtn", "V2ProjectStatusResultList");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectStatusResultList"), Status1,
				"V2 CountryList Search failed");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var), "1", "V2 Search failed");
		softAssert.assertAll();
		testlog.pass("**Verifies the Search V2Project By StatusName successfully**");
	}

	public void SearchV2ProjectFilters(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * FilterByProjectName
		 */
		CommonMethod.WaitUntilVisibility("V2ProjectIdNameList", 120);
		testlog.info("ProjectName: " + data.getCellData(SheetName, "ProjectName", rowNum));
		CommonMethod.sendKeys("V2ProjectIdNameList", data.getCellData(SheetName, "ProjectName", rowNum));
		CommonMethod.RobustclickElementVisible("V2ProjectApplybtn", "V2ProjectProjectNameResultList");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectNameResultList"),
				data.getCellData(SheetName, "ProjectName", rowNum), "V2 ProjectName Search failed");
		int ProjectName = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60)
				.size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectName), "1", "V2 Search failed");
		/*
		 * FilterByCountryName
		 */
		testlog.info("CountryList: " + data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectIdCountryList", 120);
		CommonMethod.selectdropdownVisibletext("V2ProjectIdCountryList",
				data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.RobustclickElementVisible("V2ProjectApplybtn", "V2ProjectCountryResultList");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectCountryResultList"),
				data.getCellData(SheetName, "Country", rowNum), "V2 CountryList Search failed");
		int Country = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(Country), "1", "V2 Search failed");
		/*
		 * FilterByOrganizationName
		 */
		testlog.info("OwnerOrganizationName: " + data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.sendKeys("V2ProjectIdOwnerOrganizationList", data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectOrgResultList"),
				data.getCellData(SheetName, "OrgName", rowNum), "V2 CountryList Search failed");
		int OrgName = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(OrgName), "1", "V2 Search failed");
		softAssert.assertAll();
		testlog.pass("**Verifies the Search V2Project By Country Name successfully**");
		testlog.pass("**Verifies the Search V2Project By Project Name successfully**");
		testlog.pass("**Verifies the Search V2Project By Organisation Name successfully**");
	}

	public void EnrollV2ProjectById(String SheetName, int rowNum, String ProjectType, String Country)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("EnrollTab", 60);
		CommonMethod.RobustclickElementVisible("EnrollTab", "V2ProjectprojectOwnerContinuebtn");
		CommonMethod.RobustclickElementVisible("V2ProjectprojectOwnerContinuebtn", "MandatoryFieldErrorMessage");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner name* is required.", "Owner name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner email* is required.", "Owner email Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.",
				"Organization Industry Error Mismatch");
		CommonMethod.negativesoftassertPageSource(
				"Are you planning to undergo construction or renovation?* is required.", "construction Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Estimated date of document submission* is required",
				"Estimated Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Anticipated date of construction completion* is required.",
				"Anticipated date Error Mismatch");
		CommonMethod.refreshBrowser();
		rc.SelectOwnerOrg(SheetName, rowNum);
		String Ownername = USfaker.address().firstName();
		String Email = USfaker.internet().emailAddress();
		String Phoneno = USfaker.number().digits(10);
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Ownername: " + Ownername);
		CommonMethod.sendKeys("V2ProjectownerName", Ownername);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("V2ProjectownerName"));
		testlog.info("OwnerEmail: " + Email);
		CommonMethod.sendKeys("V2ProjectownerEmail", Email);
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("V2ProjectownerEmail"));
		CommonMethod.sendKeys("V2Projectownerphone", Phoneno);
		data.setCellData(SheetName, "PhoneNum", rowNum, CommonMethod.getattributeValue("V2Projectownerphone"));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.sendKeys("V2Projectorganizationwebsite",
				"https://test-nuxt.wellcertified.com/projects/v2/2202266385/register");
		data.setCellData(SheetName, "Website", rowNum, CommonMethod.getattributeValue("V2Projectorganizationwebsite"));
		CommonMethod.sendKeys("V2ProjectorganizationOverview", Ownername);
		data.setCellData(SheetName, "Overview", rowNum,
				CommonMethod.getattributeValue("V2ProjectorganizationOverview"));
		CommonMethod.ClickCheckbox("V2ProjectconstructionOrrenovation");
		CommonMethod.RobustclickElementVisible("V2ProjectdocsubEstidate", "V2ProjectdocsubEstidateOkbtn");
		CommonMethod.RobustclickElementVisible("V2ProjectdocsubEstidateOkbtn", "V2ProjectdocsubAnticdate");
		CommonMethod.RobustclickElementVisible("V2ProjectdocsubAnticdate", "V2ProjectdocsubEstidateOkbtn");
		CommonMethod.click("V2ProjectdocsubEstidateOkbtn");
		if (ProjectType.equalsIgnoreCase("WELLCore")) {
			CommonMethod.selectdropdownValue("V2ProjectSector", "government/municipal-buildings");
			data.setCellData(SheetName, "MarketSectorName", rowNum,
					CommonMethod.getSelectedDropdownValue("V2ProjectSector"));
			testlog.info("MarketSector: " + data.getCellData(SheetName, "MarketSectorName", rowNum));
		}
		CommonMethod.RobustclickElementVisible("V2ProjectprojectOwnerContinuebtn",
				"V2ProjectprojectaddressContinuebtn");
		CommonMethod.RobustclickElementVisible("V2ProjectprojectaddressContinuebtn", "V2ProjectprojectaddressCountry");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "CPostal Code Error Mismatch");
		testlog.info("Country: " + Country);
		CommonMethod.selectdropdownValue("V2ProjectprojectaddressCountry", Country);
		data.setCellData(SheetName, "OwnerCountry", rowNum,
				CommonMethod.getSelectedDropdownValue("V2ProjectprojectaddressCountry"));
		CommonMethod.WaitUntilVisibility("V2ProjectprojectState", 10);
		CommonMethod.selectdropdownrandom("V2ProjectprojectState");
		data.setCellData(SheetName, "OwnerState", rowNum,
				CommonMethod.getSelectedDropdownValue("V2ProjectprojectState"));
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		testlog.info("Organization Address:" + ProjectAddress1);
		testlog.info("Organization City:" + ProjectCity);
		testlog.info("Organization Postalcode:" + PostalCode);
		CommonMethod.sendKeys("V2ProjectprojectaddressStreet", ProjectAddress1);
		CommonMethod.sendKeys("V2ProjectprojectaddressCity", ProjectCity);
		CommonMethod.sendKeys("V2ProjectprojectaddressPostalcode", PostalCode);
		CommonMethod.selectdropdownValue("V2ProjectowneraddressCountry", Country);
		CommonMethod.WaitUntilVisibility("V2ProjectowneraddressState", 10);
		CommonMethod.selectdropdownrandom("V2ProjectowneraddressState");
		CommonMethod.sendKeys("V2ProjectowneraddressStreet", ProjectAddress1);
		CommonMethod.sendKeys("V2ProjectowneraddressCity", ProjectCity);
		CommonMethod.sendKeys("V2ProjectowneraddressPostalcode", PostalCode);
		data.setCellData(SheetName, "OwnerStreet", rowNum,
				CommonMethod.getattributeValue("V2ProjectowneraddressStreet"));
		data.setCellData(SheetName, "OwnerCity", rowNum, CommonMethod.getattributeValue("V2ProjectowneraddressCity"));
		data.setCellData(SheetName, "OwnerPostalCode", rowNum,
				CommonMethod.getattributeValue("V2ProjectowneraddressPostalcode"));
		CommonMethod.ClickCheckbox("V2Projectisthisapublicproject");
		CommonMethod.RobustclickElementVisible("V2ProjectprojectaddressContinuebtn", "BiilingTab");
		CommonMethod.WaitUntilVisibility("BiilingTab", 300);
		testlog.pass("**Verifies the Enrolling successfully**");
	}

	public void ClickBilling(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 120);
		CommonMethod.RobustclickElementVisible("BiilingTab", "V2ProjectPreBillingPayNowButton");
		CommonMethod.RobustclickElementVisible("V2ProjectPreBillingPayNowButton", "BillingLanding");
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void DownloadBillingReceiptAndValidate(String SheetName, int rowNum, String Country)
			throws IOException, InterruptedException {
		// String Amount = data.getCellData(SheetName, "EnrollFee", rowNum);
		String Email = data.getCellData("Login", "UserName", 3);
		String Address = null;
		if (Country.equalsIgnoreCase("US")) {
			Address = "New York, NY 10014";
		} else {
			Address = "IWBI China(HK) Limited";
		}
		String[] ProjDetails = { Email, Address };
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

	public void AgreementV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 300);
		CommonMethod.RobustclickElementVisible("WellV2DashboardTab", "V2ProjectSignNow");
		CommonMethod.WaitUntilClickble("V2ProjectSignNow", 60);
		CommonMethod.Robustclick("V2ProjectSignNow");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 30);
		testlog.pass("**Verifies Agreement V2Project successfully**");
	}

	public void CalculatePricingV2Project(String SheetName, int rowNum, String ProjectType)
			throws IOException, InterruptedException {
		long Enroll;
		long Programfee;
		Double Area = Double.valueOf(data.getCellData(SheetName, "Area", rowNum));
		if (ProjectType.equalsIgnoreCase("WellCore")) {
			Enroll = Math.round(2500 - (2500 * .35));
			data.setCellData(SheetName, "EnrollFee", rowNum, String.valueOf(Enroll));
			Double InterimProgramfee = Area * 0.08;
			if (InterimProgramfee <= 6500) {
				Programfee = (6500 - Math.round(6500 * .35));
			} else if (InterimProgramfee >= 98000) {
				Programfee = (98000 - Math.round(98000 * .35));
			} else {
				Programfee = Math.round(InterimProgramfee - (InterimProgramfee * .35));
			}
			data.setCellData(SheetName, "ProgramFee", rowNum, String.valueOf(Programfee));
			long TotalFee = Programfee + Enroll;
			data.setCellData(SheetName, "TotalFee", rowNum, String.valueOf(TotalFee));
		}

		else if (ProjectType.equalsIgnoreCase("WELLCertification")) {
			rowNum = rowNum - 1;
			data.setCellData(SheetName, "NoDiscEnrollFee", rowNum, "2500");
			Double InterimProgramfee = Area * 0.16;
			if (InterimProgramfee <= 6500) {
				Programfee = 6500;
			} else if (InterimProgramfee >= 98000) {
				Programfee = 98000;
			} else {
				Programfee = Math.round(InterimProgramfee);
			}
			data.setCellData(SheetName, "NoDiscProgramFee", rowNum, String.valueOf(Programfee));
			long NoDiscTotalFee = Programfee + 2500;
			data.setCellData(SheetName, "NoDiscTotalFee", rowNum, String.valueOf(NoDiscTotalFee));
		}
	}

	public void PricingSectorDiscountValidationV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PricingTab", 300);
		CommonMethod.RobustclickElementVisible("PricingTab", "V2ProjectPricingLanding");
		CommonMethod.WaitUntilPresence("V2ProjectPricingLanding", 120);
		String PricingEnrollFee = CommonMethod.getText("V2ProjectPricingEnrollFee").replaceAll("USD", "")
				.replaceAll("\\W", "");
		testlog.info("PricingEnrollFee: " + PricingEnrollFee);
		CommonMethod.softAssertEqualsMessage(PricingEnrollFee, data.getCellData(SheetName, "EnrollFee", rowNum),
				"PricingEnrollFee data doesn't match");
		String DiscountName = CommonMethod.getText("V2ProjectPricingSectorDiscountName").split(":")[1].toString()
				.trim();
		testlog.info("Sector DiscountName:" + DiscountName);
		DiscountName = DiscountName.replace("(-35%)", "").trim();
		CommonMethod.softAssertEqualsMessage(DiscountName, data.getCellData(SheetName, "MarketSectorName", rowNum),
				"Pricing Sector DiscountName data doesn't match");
		String ProgramFee = CommonMethod.getText("V2ProjectPricingProgramFee").replaceAll("USD", "").replaceAll("\\W",
				"");
		testlog.info("ProgramFee: " + ProgramFee);
		CommonMethod.softAssertEqualsMessage(ProgramFee, data.getCellData(SheetName, "ProgramFee", rowNum),
				"Pricing ProgramFee data doesn't match");
		String TotalFee = CommonMethod.getText("V2ProjectPricingTotalWellFees").replaceAll("USD", "").replaceAll("\\W",
				"");
		testlog.info("TotalFee: " + TotalFee);
		CommonMethod.softAssertEqualsMessage(TotalFee, data.getCellData(SheetName, "TotalFee", rowNum),
				"Pricing Total WellFees data doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies Pricing Sector Discount successfully**");
	}

	public void PricingNoDiscountValidationV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PricingTab", 300);
		CommonMethod.RobustclickElementVisible("PricingTab", "V2ProjectPricingLanding");
		CommonMethod.WaitUntilVisibility("V2ProjectPricingLanding", 120);
		rowNum = rowNum - 1;
		String PricingEnrollFee = CommonMethod.getText("V2ProjectPricingEnrollFee").replaceAll("USD", "")
				.replaceAll("\\W", "");
		testlog.info("PricingEnrollFee: " + PricingEnrollFee);
		CommonMethod.softAssertEqualsMessage(PricingEnrollFee, data.getCellData(SheetName, "NoDiscEnrollFee", rowNum),
				"PricingEnrollFee data doesn't match");
		String ProgramFee = CommonMethod.getText("V2ProjectPricingProgramFee").replaceAll("USD", "").replaceAll("\\W",
				"");
		testlog.info("ProgramFee: " + ProgramFee);
		CommonMethod.softAssertEqualsMessage(ProgramFee, data.getCellData(SheetName, "NoDiscProgramFee", rowNum),
				"Pricing ProgramFee data doesn't match");
		String TotalFee = CommonMethod.getText("V2ProjectPricingNoTotalWellFees").replaceAll("USD", "")
				.replaceAll("\\W", "");
		testlog.info("TotalFee: " + TotalFee);
		CommonMethod.softAssertEqualsMessage(TotalFee, data.getCellData(SheetName, "NoDiscTotalFee", rowNum),
				"Pricing Total WellFees data doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies Pricing No Discount successfully**");
	}

	public void BuildScorecardV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectStartBuilding", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectStartBuilding", "ScoreCardPageLand");
		CommonMethod.WaitUntilVisibility("ScoreCardPageLand", Scorecardtimeout);
		testlog.pass("**Verfies Scorecard Page successfully**");
	}

	public void RefreshScorecard() throws IOException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("ScoreCardPageLand", Scorecardtimeout);
	}
	
	public void Scorecardfill(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne)
			throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
		for (int i = 1; i <= YesEnd; i++) {
			int RemainingYes = YesButton.size();
			System.out.println(RemainingYes);
			do {
				CommonMethod.WaitUntilClickble("V2ProjectHsrPurseYes", 60);
				CommonMethod.click("V2ProjectHsrPurseYes");
				Thread.sleep(1000);
				YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
				System.out.println(YesButton);
			} while (YesButton.size() == RemainingYes);
			RemainingYes--;
		}

		NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
		int j = DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			do {
				CommonMethod.click(NoButton.get(RemainingNo - j));
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
			} while (NoButton.size() == RemainingNo);
			RemainingNo--;
			j--;
		}
		RefreshScorecard();
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
				CommonMethod.JavascriptClickElement(NoButton.get(RemainingNo - j));
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
			} while (NoButton.size() == RemainingNo);
			RemainingNo--;
			j--;
		}
		YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
		for (int i = 1; i <= YesEnd; i++) {
			int RemainingYes = YesButton.size();
			do {
				CommonMethod.WaitUntilClickble("V2ProjectHsrPurseYes", 60);
				CommonMethod.JavascriptClickElement("V2ProjectHsrPurseYes");
				Thread.sleep(1000);
				YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
			} while (YesButton.size() == RemainingYes);
			RemainingYes--;
		}

	}

	public void CompleteScorecardHsrById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WellV2ScorecardTab", 300);
		CommonMethod.RobustclickElementVisible("WellV2ScorecardTab", "V2ProjectHsrScorecard");
		Scorecardfill(15, 16, 27, 8);
		testlog.pass("**Verifies the 15 Purse Yes Scorecard HealthSafety ByID successfully**");
	}

	public void CompleteScorecardV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectAirconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAirconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(15, 16, 25, 10);
		testlog.pass("**Completed Scorecard Air concept Purse Status V2Project successfully**");
		/*
		 * Water concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectWaterconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectWaterconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(13, 14, 17, 4);
		testlog.pass("**Completed Scorecard Water concept Purse Status V2Project successfully**");
		/*
		 * Nourisement concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectNourisementconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectNourisementconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(14, 15, 15, 1);
		testlog.pass("**Completed Scorecard Nourisement concept Purse Status V2Project successfully**");
		/*
		 * Light concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectLightconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectLightconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(6, 7, 12, 6);
		testlog.pass("**Completed Scorecard Light concept Purse Status V2Project successfully**");
		/*
		 * Movement concept
		 */
		CommonMethod.WaitUntilClickble("V2Projectmovementconcept", 60);
		CommonMethod.RobustclickElementVisible("V2Projectmovementconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(11, 12, 22, 11);
		testlog.pass("**Completed Scorecard Movement concept Purse Status V2Project successfully**");
		/*
		 * Thermal concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectThermalconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectThermalconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(10, 11, 15, 5);
		testlog.pass("**Completed Scorecard Thermal concept Purse Status V2Project successfully**");
		/*
		 * Sound concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectSoundconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSoundconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(9, 10, 14, 5);
		testlog.pass("**Completed Scorecard Sound concept Purse Status V2Project successfully**");
		/*
		 * Material concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectMaterialconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectMaterialconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(17, 18, 24, 7);
		testlog.pass("**Completed Scorecard Material concept Purse Status V2Project successfully**");
		/*
		 * Mind concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectMindconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectMindconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(8, 9, 19, 11);
		testlog.pass("**Completed Scorecard Mind concept Purse Status V2Project successfully**");
		/*
		 * Community concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectCommunityconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectCommunityconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(17, 18, 35, 18);
		testlog.pass("**Completed Scorecard Community concept Purse Status V2Project successfully**");
		/*
		 * Innovation concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectInnovationconcept", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectInnovationconcept", "WPRPortfolioScorecardLanding");
		Scorecardfill(10, 11, 18, 8);
		testlog.pass("**Completed Scorecard Innovation concept Purse Status V2Project successfully**");
	}

	public void ScorecardPurseStatusCount(String SheetName, int rowNum) throws IOException {
		/*
		 * Total FeaturePartCount
		 */
		RefreshScorecard();
		int ScorecardPart = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
		String FeatureScorecardPartCount = Integer.toString(ScorecardPart);
		testlog.info("FeatureScorecardPartCount: " + FeatureScorecardPartCount);
		data.setCellData(SheetName, "ScorecardPartCount", rowNum, FeatureScorecardPartCount);
		CommonMethod.softAssertEqualsMessage("216", data.getCellData(SheetName, "ScorecardPartCount", rowNum),
				"ScorecardPartCount doesn't match");

		/*
		 * YesPurseCount
		 */
		int YesFeature = CommonMethod.ElementSize("V2ProjectSelectedPurseYes");
		String YesFeatureCount = Integer.toString(YesFeature);
		testlog.info("YesFeatureCount: " + YesFeatureCount);
		data.setCellData(SheetName, "YesPurseCount", rowNum, YesFeatureCount);
		CommonMethod.softAssertEqualsMessage("130", data.getCellData(SheetName, "YesPurseCount", rowNum),
				"YesPurseCount doesn't match");
		/*
		 * NoPurseCount
		 */
		int NoFeature = CommonMethod.ElementSize("V2ProjectSelectedPurseNo");
		String NoFeatureCount = Integer.toString(NoFeature);
		testlog.info("NoFeatureCount: " + NoFeatureCount);
		data.setCellData(SheetName, "NoPurseCount", rowNum, NoFeatureCount);
		CommonMethod.softAssertEqualsMessage("86", data.getCellData(SheetName, "NoPurseCount", rowNum),
				"NoPurseCount doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies the 130 Purse Yes Scorecard V2Project successfully**");
		testlog.pass("**Verifies the 86 Purse No Scorecard V2Project successfully**");
		testlog.pass("**Verifies the 216 Purse Scorecard Part Count V2Project successfully**");
	}

	public void UploadFeatureDocV2ProjectInsideScorecard(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectScorecardFeature", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardFeature", "V2ProjectscorecardDocbtn");
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectscorecardDocbtn", "V2Projectscorecardverificationdropdown");
		testlog.info("TaskName : Performance Test OR Sensor Data");
		CommonMethod.selectdropdownVisibletext("V2Projectscorecardverificationdropdown",
				"Performance Test OR Sensor Data");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", FeaturefileUpload);
		CommonMethod.WaitUntilVisibility("UploadFileVerifyScorecard", 120);
		CommonMethod.RobustclickElementVisible("V2Projectscorecarddocuploadsubmit",
				"V2ProjectscorecardVerifyUploadDoc");
		CommonMethod.Isdisplayed("V2ProjectscorecardVerifyUploadDoc", 60);
		CommonMethod.refreshBrowser();
		testlog.pass("**Verifies the Upload Document in Scorecard Feature successfully**");

	}

	public void UploadAuditDocV2ProjectInsideScorecard(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectScorecardAuditFeature", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardAuditFeature", "V2ProjectscorecardDocbtn");
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectscorecardDocbtn", "V2Projectscorecardverificationdropdown");
		testlog.info("TaskName : Technical Document (Audited)");
		CommonMethod.selectdropdownVisibletext("V2Projectscorecardverificationdropdown",
				"Technical Document (Audited)");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", AuditfileUpload);
		CommonMethod.WaitUntilVisibility("UploadFileVerifyScorecard", 120);
		CommonMethod.RobustclickElementVisible("V2Projectscorecarddocuploadsubmit",
				"V2ProjectscorecardVerifyUploadDoc");
		CommonMethod.Isdisplayed("V2ProjectscorecardVerifyUploadDoc", 60);
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		testlog.pass("**Verifies the Upload Document in Scorecard Audit Feature successfully**");

	}

	public void UploadLegalAndGeneralDocumentFromDocumentLibrary(String SheetName, int rowNum, String DocumentType,
			String FileName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2ProjectDocumentTab", 60);
		CommonMethod.RobustclickElementVisible("WellV2ProjectDocumentTab", "V2ProjectDocUploadbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectDocUploadbtn", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectDocUploadbtn", "V2ProjectPortfolioDocType");
		testlog.info("Document Type : General");
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", DocumentType);
		CommonMethod.uploadFile("V2Projectscorecarddocupload", FileName);
		CommonMethod.WaitUntilClickble("V2ProjectDocSubmit", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectDocSubmit", "V2ProjectScorecardWaitUntilDocUploaded");
		Thread.sleep(2000);
		CommonMethod.WaitUntilInVisibility("V2ProjectScorecardWaitUntilDocUploaded", 120);
		CommonMethod.WaitUntilClickble("V2ProjectDocUploadbtn", 30);
		testlog.pass("**Upload Document successfully**");
	}

	public void UploadOngoingDocumentInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectDocUploadbtn", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectDocUploadbtn", "V2ProjectPortfolioDocType");
		testlog.info("Document Type: Ongoing data reports");
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", "Ongoing data reports");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("V2ProjectResetbtn", "V2ProjectPortfolioDocType");
		Thread.sleep(1000);
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", "Legal");
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("V2ProjectResetbtn", "V2ProjectPortfolioDocType");
		Thread.sleep(2000);
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", "Ongoing data reports");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
		CommonMethod.selectdropdownVisibletext("V2ProjectDocPeriod", "Year 1 reporting");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", OngoingfileUpload);
		CommonMethod.WaitUntilClickble("V2ProjectDocSubmit", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectDocSubmit", "V2ProjectScorecardWaitUntilDocUploaded");
		Thread.sleep(2000);
		CommonMethod.WaitUntilInVisibility("V2ProjectScorecardWaitUntilDocUploaded", 120);
		CommonMethod.WaitUntilClickble("V2ProjectDocUploadbtn", 30);
		testlog.pass("**Upload Document successfully**");
	}

	public void UploadFeatureDocumentInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectDocUploadbtn", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectDocUploadbtn", "V2ProjectPortfolioDocType");
		Thread.sleep(2000);
		testlog.info("Document Type: " + "Feature");
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", "Feature");
		Thread.sleep(2000);
		rc.SelectOwnerOrg(SheetName, rowNum);
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("V2ProjectPart", "V2ProjectSelectPartDoc");
		Thread.sleep(1000);
		CommonMethod.Robustclick("V2ProjectSelectPartDoc");
		Thread.sleep(1000);
		CommonMethod.uploadFile("V2Projectscorecarddocupload", FeaturefileUpload);
		CommonMethod.WaitUntilClickble("V2ProjectDocSubmit", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectDocSubmit", "V2ProjectScorecardWaitUntilDocUploaded");
		Thread.sleep(2000);
		CommonMethod.WaitUntilInVisibility("V2ProjectScorecardWaitUntilDocUploaded", 120);
		CommonMethod.WaitUntilClickble("V2ProjectDocUploadbtn", 30);
		testlog.pass("**Upload Document successfully**");
	}

	public void UploadDocumentCountInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.scrolldowntoElement("V2ProjectDocUploadbtn");
		CommonMethod.RobustclickElementVisible("V2ProjectGeneralDoc", "V2ProjectDocumentValid");
		int V2ProjectDocCount = CommonMethod.ElementSize("V2ProjectGeneralDocCount");
		String V2ProjectDocuCounts = Integer.toString(V2ProjectDocCount);
		CommonMethod.assertActualContainsExpected(V2ProjectDocuCounts, "2");
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardDoc", "V2ProjectDocumentValid");
		int V2ProjectScoreDocCount = CommonMethod.ElementSize("V2ProjectScorecardDocCount");
		String V2ProjectDocCounts = Integer.toString(V2ProjectScoreDocCount);
		CommonMethod.assertActualContainsExpected(V2ProjectDocCounts, "4");
		testlog.pass("**Verifies Uploaded Document successfully**");
	}

	public void ReviewV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 30);
		CommonMethod.WaitUntilVisibility("V2ProjectsubmitReview", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectsubmitReview", "V2ProjectcommentReview");
		CommonMethod.WaitUntilClickble("V2ProjectcommentReview", 60).sendKeys("Preliminary Precertification Review");
		CommonMethod.WaitUntilPresence("V2ProjectSelectPhase", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectSelectPhase", "Preliminary Precertification Review");
		CommonMethod.RobustclickElementVisible("V2ProjectSubmitPhaseReview", "ReviewViewButton");
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("AdminWELLCertificationNavBar", "AdminV2ProjectId");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("AdminV2ProjectApplybtn", "V2ProjectSearchResultIDVerify");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "ProjectID", rowNum), "ProjectID doesn't matches in search");
		CommonMethod.WaitUntilPresence("V2ProjectIdCompare", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "V2ProjectStartBuilding");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		CommonMethod.RobustclickElementVisible("ReviewViewButton", "ReviewReturnButton");
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "V2ProjectReviewCommentNarrative");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60)
				.sendKeys("Preliminary Precertification Review");
		CommonMethod.sendKeys("V2ProjectGeneralCommentNarrative", "Preliminary Precertification Review");
		CommonMethod.WaitUntilClickble("DatePickerButton", 60);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "ReviewPaymentstatusRadio");
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilPresence("ReviewPaymentstatusRadio", 60);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.RobustclickElementVisible("ReviewReturnSubmit", "ReviewedStatus");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Reviewed Preliminary Precertification Review successfully**");
		testlog.pass("**Completed Reviewed Preliminary Precertification Review successfully**");
	}

	public void HealthSafetyV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("HealthSafetyTab", 300);
		CommonMethod.RobustclickElementVisible("HealthSafetyTab", "V2ProjectHsrContinuebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrContinuebtn", 60);
		CommonMethod.Robustclick("V2ProjectHsrContinuebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectHsrTermscbx", "V2ProjectHsrTermsbtn");
		CommonMethod.RobustclickElementVisible("V2ProjectHsrTermsbtn", "V2ProjectHsrTermscbx");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectHsrTermscbx", "V2ProjectHsrProceedbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrProceedbtn", 60);
		CommonMethod.Robustclick("V2ProjectHsrProceedbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrAccountbtn", 60);
		CommonMethod.Robustclick("V2ProjectHsrAccountbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrScorecard", 300);
		ScorecardfillHSRWPR(15, 1, 27, 27);
		testlog.pass("**Verifies the 15 Purse Yes Scorecard Performance ByID successfully**");
	}

	public void uploadDocumentInFeature(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		for (WebElement f : Feature) {
			CommonMethod.WaitUntilClickble(f, 120);
			CommonMethod.JavascriptClickElement(f);
			CommonMethod.WaitUntilPresence("V2ProjectWPRPDocIcon", 60);
			CommonMethod.RobustclickElementVisible("V2ProjectWPRPDocIcon", "V2ProjectWPRVerificationMethod");
			CommonMethod.WaitUntilVisibility("V2ProjectWPRVerificationMethod", 60);
			CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
			CommonMethod.uploadFile("V2ProjectDocUpload", FeaturefileUpload);
			CommonMethod.WaitUntilVisibility("FeatureFileUploadedVisible", 60);
			CommonMethod.Robustclick("V2ProjectWPRUploadbtn");
			CommonMethod.WaitUntilPresence("V2ProjectWPRScorecardLanding", 60);
			CommonMethod.scrolldowntoElement("V2ProjectWPRScorecardLanding");
			CommonMethod.JavascriptClickElement(f);
		}
	}

	public void uploadHsrDocV2Project() throws IOException, InterruptedException {
		uploadDocumentInFeature(16);
		testlog.pass("**Upload 15 Scorecard Documents successfully**");
	}

	public void hsrReviewV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature", 600);
		CommonMethod.Robustclick("ReviewTab", "V2ProjectsubmitReview");
		CommonMethod.RobustclickElementVisible("V2ProjectsubmitReview", "V2ProjectcommentReview");
		CommonMethod.WaitUntilClickble("V2ProjectcommentReview", 60).sendKeys("Final Documentation Review");
		CommonMethod.selectdropdownVisibletext("V2ProjectSelectPhase", "Final Documentation Review");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingHsrcbx");
		CommonMethod.RobustclickElementVisible("V2ProjectSubmitPhaseReview", "V2ProjectHSRReviewViewbtn");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectHSRReviewViewbtn", 120);
		testlog.pass("**Reviewed Final Precertification Review successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilClickble("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("AdminWELLCertificationNavBar", "AdminV2ProjectId");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("AdminV2ProjectApplybtn", "V2ProjectSearchResultIDVerify");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "ProjectID", rowNum), "Project ID doesn't matches");
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "ReviewTab");
		CommonMethod.RobustclickElementVisible("ReviewTab", "V2ProjectHSRReviewViewbtn");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectHSRReviewViewbtn", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectHSRReviewViewbtn", "ReviewReturnButton");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "ReturnComment");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Final Review");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60).sendKeys("Final Precertification Review");
		CommonMethod.WaitUntilClickble("DatePickerButton", 60).click();
		CommonMethod.WaitUntilClickble("DatePickerOkButton", 60).click();
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.RobustclickElementVisible("ReviewReturnSubmit", "ReviewedStatus");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Completed Final Precertification Review successfully**");
	}

	public void performanceV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PerformanceTab", 300);
		CommonMethod.RobustclickElementVisible("PerformanceTab", "V2ProjectWPRContinuebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRContinuebtn", 60);
		CommonMethod.Robustclick("V2ProjectWPRContinuebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRTermscbx", 60);
		CommonMethod.ClickCheckbox("V2ProjectWPRTermscbx");
		CommonMethod.RobustclickElementVisible("V2ProjectWPRTermsbtn", "V2ProjectHsrTermscbx");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 60);
		CommonMethod.ClickCheckbox("V2ProjectHsrTermscbx");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRProceedbtn", 60);
		CommonMethod.Robustclick("V2ProjectWPRProceedbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRAccountbtn", 60);
		CommonMethod.Robustclick("V2ProjectWPRAccountbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRScorecardLanding", 300);
		ScorecardfillHSRWPR(21, 1, 38, 38);
		testlog.pass("**Verifies the 21 Purse Yes Scorecard Performance successfully**");
	}

	public void uploadPerformanceDocV2Project() throws IOException, InterruptedException {
		uploadDocumentInFeature(21);
		testlog.pass("**Upload 21 Scorecard Documents successfully**");
	}

	public void wprReviewV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature", 600);
		CommonMethod.Robustclick("ReviewTab", "V2ProjectsubmitReview");
		CommonMethod.WaitUntilVisibility("V2ProjectsubmitReview", 300);
		CommonMethod.RobustclickElementVisible("V2ProjectsubmitReview", "V2ProjectcommentReview");
		CommonMethod.WaitUntilClickble("V2ProjectcommentReview", 60).sendKeys("Final Performance Review");
		CommonMethod.WaitUntilPresence("V2ProjectsubmitReview", 30);
		CommonMethod.selectdropdownVisibletext("V2ProjectSelectPhase", "Final Performance Review");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingHsrcbx");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingWprcbx");
		CommonMethod.RobustclickElementVisible("V2ProjectSubmitPhaseReview", "V2ProjectWPRReviewViewbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRReviewViewbtn", 30);
		testlog.pass("**Reviewed Final Precertification Review successfully**");

		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 300);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("AdminWELLCertificationNavBar", "AdminV2ProjectId");
		CommonMethod.WaitUntilVisibility("AdminV2ProjectId", 300)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("AdminV2ProjectApplybtn", "V2ProjectSearchResultIDVerify");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "ProjectID", rowNum), "Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "ReviewTab");
		CommonMethod.RobustclickElementVisible("ReviewTab", "V2ProjectWPRReviewViewbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRReviewViewbtn", 30);
		CommonMethod.RobustclickElementVisible("V2ProjectWPRReviewViewbtn", "ReviewReturnButton");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 30);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "ReturnComment");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Final Review");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60).sendKeys("Final Precertification Review");
		CommonMethod.WaitUntilVisibility("DatePickerButton", 300);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "ReviewPaymentstatusRadio");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.WaitUntilVisibility("ReviewReturnSubmit", 300);
		CommonMethod.RobustclickElementVisible("ReviewReturnSubmit", "ReviewedStatus");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Completed Final Precertification Review successfully**");
	}

	public void supportV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectSupportButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSupportButton", "V2ProjectGetHelpButton");
		CommonMethod.WaitUntilVisibility("V2ProjectGetHelpButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectGetHelpButton", "V2ProjectQuestionAboutDropdown");

		CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectQuestionAboutDropdown");
		CommonMethod.negativesoftassertPageSource("Question About is required.", "Question About Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Subject is required.", "Subject Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Description is required.", "Description Error Mismatch");

		CommonMethod.WaitUntilVisibility("V2ProjectQuestionAboutDropdown", 60);
		CommonMethod.selectdropdownValue("V2ProjectQuestionAboutDropdown", "well-v2-feature");
		CommonMethod.WaitUntilVisibility("V2ProjectIssueSubTypeDropdown", 60);
		CommonMethod.selectdropdownValue("V2ProjectIssueSubTypeDropdown", "A01 Air Quality");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
		CommonMethod.WaitUntilClickble("V2ProjectSubjectInputField", 60).sendKeys("Testing");
		data.setCellData(SheetName, "Subject", rowNum, CommonMethod.getattributeValue("V2ProjectSubjectInputField"));
		testlog.info("FeatureName" + data.getCellData(SheetName, "Subject", rowNum));
		CommonMethod.WaitUntilClickble("V2ProjectDescriptionTextArea", 60).sendKeys("Testing");
		CommonMethod.uploadFile("DocumentsUpload", FeaturefileUpload);
		CommonMethod.WaitUntilVisibility("V2ProjectUploadFeatureVerify", 120);
		CommonMethod.WaitUntilVisibility("SubmitButton", 60);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectBackToTicket");
		CommonMethod.RobustclickElementVisible("V2ProjectBackToTicket", "V2ProjectTicketListStatus");
		CommonMethod.WaitUntilPresence("V2ProjectTicketListStatus", 60);
		String TicketStatus = CommonMethod.getText("V2ProjectTicketListStatus");
		testlog.info("TicketStatus: " + TicketStatus);
		CommonMethod.assertActualContainsExpected(TicketStatus, "NEW");
		testlog.pass("**Raised support ticket successfully**");
	}

	public void alternativesV2Project(String SheetName, int rowNum, String alternativeOption)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectAlternativesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAlternativesButton", "V2ProjectEPSubmitButton");
		if (alternativeOption.equalsIgnoreCase("EP")) {
			CommonMethod.RobustclickElementVisible("V2ProjectEPSubmitButton", "V2ProjectFeatureDropdown");
			CommonMethod.WaitUntilVisibility("V2ProjectFeatureDropdown", 60);
			CommonMethod.selectdropdownVisibletext("V2ProjectFeatureDropdown", "A01 Air Quality");
			CommonMethod.WaitUntilVisibility("V2ProjectApplicablePartCheckBox", 60);
			CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyReason", 60).sendKeys("Reason for Equivalency Request");
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyCountriesInput", 60)
					.sendKeys("Regions/Countries where Equivalency may be Applicable");
			CommonMethod.WaitUntilClickble("V2ProjectVerificationTextArea", 60)
					.sendKeys("Verification method within proposed equivalent");
			CommonMethod.WaitUntilClickble("V2ProjectSimilaritiesTextArea", 60)
					.sendKeys("Similarities to WELL feature requirement");
			CommonMethod.WaitUntilClickble("V2ProjectDifferencesTextArea", 60)
					.sendKeys("Differences from WELL feature requirement");
		} else if (alternativeOption.equalsIgnoreCase("AAP")) {
			CommonMethod.scrolldowntoElement("V2ProjectAditionalButton");
			CommonMethod.WaitUntilVisibility("V2ProjectAapSubmitButton", 60);
			CommonMethod.RobustclickElementVisible("V2ProjectAapSubmitButton", "V2ProjectFeatureDropdown");
			CommonMethod.WaitUntilVisibility("V2ProjectFeatureDropdown", 60);
			CommonMethod.selectdropdownVisibletext("V2ProjectFeatureDropdown", "A01 Air Quality");
			data.setCellData(SheetName, "FeatureName", rowNum,
					CommonMethod.getSelectedDropdownValue("V2ProjectFeatureDropdown"));
			testlog.info("FeatureName" + data.getCellData(SheetName, "FeatureName", rowNum));
			CommonMethod.WaitUntilVisibility("V2ProjectApplicablePartCheckBox", 60);
			CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			CommonMethod.WaitUntilClickble("V2ProjectAlternativesReasonTextArea", 60)
					.sendKeys("Reason for Alternative Means and Methods");
		}
		CommonMethod.WaitUntilClickble("V2ProjectAlternativesProposedTextArea", 60)
				.sendKeys("Proposed Alternative Means of Compliance");
		CommonMethod.uploadFile("DocumentsUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilVisibility("SubmitButton", 60);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2projectEPTypeStatus");
		if (alternativeOption.equalsIgnoreCase("EP")) {
			CommonMethod.WaitUntilVisibility("V2projectEPTypeStatus", 60);
			CommonMethod.assertcontainsmessage("V2projectEPTypeStatus", "EP", "Verified EP status");
			softAssert.assertAll();
			testlog.pass("**Added alternative EP documents successfully**");
		} else if (alternativeOption.equalsIgnoreCase("AAP")) {
			CommonMethod.WaitUntilVisibility("V2projectAAPTypeStatus", 60);
			CommonMethod.assertcontainsmessage("V2projectAAPTypeStatus", "AAP", "Verified AAP status");
			softAssert.assertAll();
			testlog.pass("**Added alternative AAP documents successfully**");
		}
	}

	public void editAndValidateProjectInformationV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectInformationButton");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectInformationButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectNameInput", 60);
		CommonMethod.clearAndSendKey("V2ProjectProjectNameInput", data.getCellData(SheetName, "ProjectName", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectProjectScope", 60);
		CommonMethod.sendKeys("V2ProjectProjectScope", data.getCellData(SheetName, "ProjectScope", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectProjectGoals", 60);
		CommonMethod.sendKeys("V2ProjectProjectGoals", data.getCellData(SheetName, "ProjectGoals", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "V2ProjectNextStep");
		testlog.info("**Project Information data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
		/*
		 * Validate updated project information fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectInformationButton");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectInformationButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectProjectScope"),
				data.getCellData(SheetName, "ProjectScope", rowNum), "Project scope data doesn't match");
		testlog.info("**Project scope data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectGoals", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectProjectGoals"),
				data.getCellData(SheetName, "ProjectGoals", rowNum), "Project goals data doesn't match");
		softAssert.assertAll();
		testlog.pass("**Project goals data updated successfully**");
	}

	public void editAndValidateOwnerInformationV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectOwnerInformationButton");
		CommonMethod.WaitUntilVisibility("V2ProjectOwnerInformationButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectOwnerInformationButton", "V2ProjectOrganizationIndustry");
		CommonMethod.WaitUntilVisibility("V2ProjectOrganizationIndustry", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectOrganizationIndustry",
				data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectCountry", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectCountry", data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectState", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectState", data.getCellData(SheetName, "State", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "V2ProjectNextStep");
		testlog.pass("**Owner Information data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
		/*
		 * Validate updated owner information fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectOwnerInformationButton");
		CommonMethod.WaitUntilVisibility("V2ProjectOwnerInformationButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectOwnerInformationButton", "V2ProjectOrganizationIndustry");
		CommonMethod.WaitUntilVisibility("V2ProjectCountry", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("V2ProjectCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Country name doesn't match");
		testlog.info("**Country name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectState", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectState"),
				data.getCellData(SheetName, "State", rowNum), "State name doesn't match");
		softAssert.assertAll();
		testlog.info("**State name updated successfully**");
		testlog.pass("**Verifies Information data updated successfully**");
	}

	public void editAndValidateAddressV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAddressButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAddressButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAddressButton", "V2ProjectBillingName");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingName", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingName", data.getCellData(SheetName, "BillingName", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingOrganization", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingOrganization",
				data.getCellData(SheetName, "BillingOrganization", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingCountry", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectBillingCountry",
				data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingStreetAddress", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingStreetAddress", data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingCity", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingCity", data.getCellData(SheetName, "City", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingPostalCode", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingPostalCode", data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "V2ProjectNextStep");
		testlog.pass("**Address data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
		/*
		 * Validate updated address fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAddressButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAddressButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAddressButton", "V2ProjectBillingName");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingName", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingName"),
				data.getCellData(SheetName, "BillingName", rowNum), "Billing name doesn't match");
		testlog.info("**Billing name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingOrganization", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingOrganization"),
				data.getCellData(SheetName, "BillingOrganization", rowNum), "Billing organization name doesn't match");
		testlog.info("**Billing organization name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingCountry", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("V2ProjectBillingCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Billing country name doesn't match");
		testlog.info("**Country name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingStreetAddress", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingStreetAddress"),
				data.getCellData(SheetName, "Street", rowNum), "Billing street name doesn't match");
		testlog.info("**Street address name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingCity", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingCity"),
				data.getCellData(SheetName, "City", rowNum), "Billing city name doesn't match");
		testlog.info("**City name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingPostalCode", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Billing postal code doesn't match");
		softAssert.assertAll();
		testlog.info("**Postal code updated successfully**");
		testlog.pass("**Verifies Address data updated successfully**");
	}

	public void editAndValidateAdminV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "V2projectAdminBillingStatus");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingStatus", 60);
		CommonMethod.sendKeys("V2projectAdminBillingStatus", data.getCellData(SheetName, "BillingStatus", rowNum));
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingChallengeNote", 60);
		CommonMethod.sendKeys("V2projectAdminBillingChallengeNote",
				data.getCellData(SheetName, "ChallengeNote", rowNum));
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingCommunicationNote", 60);
		CommonMethod.sendKeys("V2projectAdminBillingCommunicationNote",
				data.getCellData(SheetName, "CommunicationNote", rowNum));
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingNote", 60);
		CommonMethod.sendKeys("V2projectAdminBillingNote", data.getCellData(SheetName, "BillingNote", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "V2ProjectNextStep");
		testlog.pass("**Admin data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
		/*
		 * Validate updated admin fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "V2projectAdminBillingStatus");
		CommonMethod.scrolldowntoElement("V2projectAdminBillingStatus");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingStatus", 120);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2projectAdminBillingStatus"),
				data.getCellData(SheetName, "BillingStatus", rowNum), "Billing status value doesn't match");
		testlog.info("**Billing status updated successfully**");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingChallengeNote", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2projectAdminBillingChallengeNote"),
				data.getCellData(SheetName, "ChallengeNote", rowNum), "Challenge note value doesn't match");
		testlog.info("**Challenge note updated successfully**");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingCommunicationNote", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2projectAdminBillingCommunicationNote"),
				data.getCellData(SheetName, "CommunicationNote", rowNum), "Communication note value doesn't match");
		testlog.info("**Communication updated successfully**");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingNote", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2projectAdminBillingNote"),
				data.getCellData(SheetName, "BillingNote", rowNum), "Billing note value doesn't match");
		softAssert.assertAll();
		testlog.info("**Billing note updated successfully**");
		testlog.pass("**Verifies Admin data updated successfully**");
	}

	public void overviewV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("OverviewTab", 60);
		CommonMethod.RobustclickElementVisible("OverviewTab", "V2ProjectProjectID");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectID", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectID"),
				data.getCellData(SheetName, "ProjectID", rowNum), "Product id value doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectName", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectName"),
				data.getCellData(SheetName, "ProjectName", rowNum), "Product name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectArea", 60);
		String getArea = CommonMethod.getText("V2ProjectProjectArea").replace("sq ft", "").replace(",", "").trim();
		CommonMethod.softAssertEqualsMessage(getArea, data.getCellData(SheetName, "Area", rowNum),
				"Project area value doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectStreet", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Street name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectCity", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectCity"),
				data.getCellData(SheetName, "City", rowNum), "City name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectState", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectState"),
				data.getCellData(SheetName, "State", rowNum), "State name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectCountry", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Country name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectOwnerIndustry", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectOwnerIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "Owner industry name doesn't match");
		softAssert.assertAll();
		testlog.pass("**Project id matched successfully**");
		testlog.pass("**State name matched successfully**");
		testlog.pass("**Street name matched successfully**");
		testlog.pass("**Product area matched successfully**");
		testlog.pass("**ProjectName matched successfully**");
		testlog.pass("**City name matched successfully**");
		testlog.pass("**Country name matched successfully**");
		testlog.pass("**Owner industry name matched successfully**");
		testlog.pass("**verifies overview fields successfully**");
	}

	public void profileV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("ProfileTab", 60);
		CommonMethod.RobustclickElementVisible("ProfileTab", "V2ProjectGeneralInformation");
		CommonMethod.WaitUntilVisibility("V2ProjectGeneralInformation", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectGeneralInformation", "V2ProjectProjectBio");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectBio", 60);
		CommonMethod.clearAndSendKey("V2ProjectProjectBio", "Project bio testing");
		CommonMethod.uploadFile("V2ProjectLogo", SampleJpgfile);
		CommonMethod.WaitUntilVisibility("V2ProjectFeviconLogo", 60);
		CommonMethod.uploadFile("V2ProjectLogo", SampleJpgfile);
		CommonMethod.WaitUntilVisibility("V2ProjectPrimaryProfileImageDeleteVerify", 120);
		CommonMethod.uploadFile("V2ProjectProfileImage", SampleJpgfile);
		CommonMethod.WaitUntilVisibility("V2ProjectFeviconLogo", 60);
		CommonMethod.WaitUntilVisibility("V2ProjectPrimaryProfileImageDeleteVerify", 120);
		CommonMethod.WaitUntilVisibility("V2ProjectProfileImageDeleteVerify", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectGeneralInformation");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Updated Profile!", "Verified profile updated toast message");
		testlog.pass("**General Information data updated successfully**");
		CommonMethod.WaitUntilInVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		/*
		 * V2ProjectCertificationStory
		 */
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("V2ProjectCertificationStory", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectCertificationStory", "V2ProjectYourObjective");
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
		CommonMethod.WaitUntilVisibility("V2ProjectYourCompanyCulture", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourCompanyCulture", "Your company culture testing");
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectProfileUpdatedToastMessage");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Updated Profile!", "Verified profile updated toast message");
		softAssert.assertAll();
		testlog.pass("**Certification story data updated successfully**");
	}

	public void validateTeamsV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 120);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("WELLCertificationNavBar", "V2ProjectId");
		CommonMethod.WaitUntilClickble("V2ProjectId", 60);
		testlog.info("ProjectId: " + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("V2ProjectId", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("V2ProjectApplybtn", "V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var), "1", "V2 Search failed");
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "ProjectID", rowNum), "Project name doesn't matches in search");
		testlog.pass("**Verifies user able to access the invited project**");
	}

	public void searchFilterScoreCardV2Project() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectScoreCardSearchBox", 60);
		CommonMethod.sendKeys("V2ProjectScoreCardSearchBox", "Meet Thresholds for Particulate Matter");
		CommonMethod.assertActualContainsExpected(CommonMethod.getText("V2ProjectScoreCardOptionValue"),
				"Meet Thresholds for Particulate Matter");
		CommonMethod.softAssertEqualsMessage(Integer.toString(CommonMethod.ElementSize("V2ProjectSelectedPurseYes")),
				"1", "YesPurseCount doesn't match");
		softAssert.assertAll();
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardRefreshButton", "V2ProjectScoreCardFilterButton");
		testlog.pass("**Verifies Scorecard Search filter successfully**");
	}

	public void verifyScoreCardFilter(String filterName, String expectedResult, int filterIndex, int checkboxIndex)
			throws IOException, InterruptedException {
		CommonMethod.clickOnListWebelementFromIndex("V2ProjectScoreCardFilterOption", filterIndex);
		CommonMethod.WaitUntilPresence("V2ProjectScorecardApplybutton", 120);
		CommonMethod.clickListWebelementFromIndex("V2ProjectScoreCardFilterOptionCheckBox", checkboxIndex);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "V2ProjectScoreCardFilterButton");
		if (filterName.equalsIgnoreCase("Response")) {
			CommonMethod.WaitUntilPresence("V2ProjectScoreCardValidatePurseYes", 60);
			int YesFeature = CommonMethod.ElementSize("V2ProjectSelectedPurseYes");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("YesFeatureCount: " + actualYesFeatureCount);
			CommonMethod.softAssertEqualsMessage(actualYesFeatureCount, expectedResult, "YesPurseCount doesn't match");
		}
		if (filterName.equalsIgnoreCase("Verification")) {
			CommonMethod.WaitUntilVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardVerificationPartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Part type")) {
			CommonMethod.WaitUntilInVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardPartTypePartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Priorities")) {
			CommonMethod.WaitUntilVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardPrioritiesPartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Space Type")) {
			CommonMethod.WaitUntilVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardSpaceTypePartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Ratings")) {
			CommonMethod.WaitUntilVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardRatingsPartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Strategy Type")) {
			CommonMethod.WaitUntilVisibility("V2ProjectScorecardRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("V2ProjectScorecardRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardStrategyTypePartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Cross walk")) {
			CommonMethod.WaitUntilVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilInVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardCrossWalkPartCount", 60);
		}
		if (filterName.equalsIgnoreCase("Responsible Party")) {
			CommonMethod.WaitUntilInVisibility("V2ProjectScorecardValidateRatingsPartCount", 120);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardResponsiblePartyPartCount", 180);
			CommonMethod.RobustclickElementVisible("V2projectScorecardResponsibleParty",
					"V2ProjectScoreCardFilterOption");
		}
		if (filterName.equalsIgnoreCase("Verification") || filterName.equalsIgnoreCase("Part type")
				|| filterName.equalsIgnoreCase("Priorities") || filterName.equalsIgnoreCase("Space Type")
				|| filterName.equalsIgnoreCase("Ratings") || filterName.equalsIgnoreCase("Strategy Type")
				|| filterName.equalsIgnoreCase("Cross walk") || filterName.equalsIgnoreCase("Responsible Party")) {
			int ScorecardPart = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualFeaturePartCount = Integer.toString(ScorecardPart);
			testlog.info(filterName + " FeatureScorecardPartCount: " + actualFeaturePartCount);
			CommonMethod.softAssertEqualsMessage(actualFeaturePartCount, expectedResult,
					"ScorecardPartCount doesn't match");
		}
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
		CommonMethod.clickOnListWebelementFromIndex("V2ProjectScoreCardFilterOption", filterIndex);
		softAssert.assertAll();
		testlog.pass("**All Scorecard filter options successfully**");
	}

	public void scorecardOptionFilterV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("V2ProjectScoreCardFilterButton", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
		verifyScoreCardFilter("Responsible Party", "30", 8, 93);
		verifyScoreCardFilter("Response", "130", 0, 0);
		verifyScoreCardFilter("Verification", "40", 1, 3);
		verifyScoreCardFilter("Part type", "48", 2, 24);
		verifyScoreCardFilter("Priorities", "34", 3, 26);
		verifyScoreCardFilter("Space Type", "208", 4, 29);
		verifyScoreCardFilter("Ratings", "27", 5, 66);
		verifyScoreCardFilter("Strategy Type", "18", 6, 69);
		verifyScoreCardFilter("Cross walk", "21", 7, 73);
	}

	public void SearchFilterDocument(String documentName, String filterOption, String fileCount)
			throws IOException, InterruptedException {
		if (filterOption.equalsIgnoreCase("Scorecard")) {
			CommonMethod.click("V2ProjectScorecardDoc");
			CommonMethod.WaitUntilVisibility("V2ProjectDecumentSearchBox", 60);
		}
		CommonMethod.WaitUntilVisibility("V2ProjectDecumentSearchBox", 60);
		CommonMethod.clearAndSendKey("V2ProjectDecumentSearchBox", documentName);
		CommonMethod.WaitUntilVisibility("V2ProjectDocumentGeneralFileCount", 60);
		int V2ProjectScoreDocCount = CommonMethod.ElementSize("V2ProjectDocumentGeneralFileCount");
		String V2ProjectDocCounts = Integer.toString(V2ProjectScoreDocCount);
		CommonMethod.assertActualContainsExpected(V2ProjectDocCounts, fileCount);
		softAssert.assertAll();
		testlog.pass("**Verifies search filter successfully **");
	}

	public void DashboardV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("V2ProjectEstimatePriceButton", 60);
		CommonMethod.WaitUntilPresence("V2ProjectReviewAgreeButton", 30);
		CommonMethod.WaitUntilPresence("V2ProjectSignNow", 30);
		CommonMethod.WaitUntilPresence("V2ProjectStartBuilding", 30);
		CommonMethod.WaitUntilPresence("V2ProjectDashboardEnrollButton", 30);
		CommonMethod.WaitUntilPresence("V2ProjectDashboardLearnMoreButton", 30);
		CommonMethod.WaitUntilPresence("V2ProjectDashboardLearnMoreButton1", 30);
		CommonMethod.WaitUntilPresence("EnrollTab", 30);
		CommonMethod.WaitUntilPresence("BiilingTab", 30);
		CommonMethod.WaitUntilPresence("TeamTab", 30);
		CommonMethod.WaitUntilPresence("OverviewTab", 30);
		CommonMethod.WaitUntilPresence("PricingTab", 30);
		CommonMethod.WaitUntilPresence("EditTab", 30);
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
	}
}