package com.Well.ReusableMethods;

import java.io.IOException;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsExam extends BaseClass {

	public void RegisterExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TrainingNavBar", 60);
		CommonMethod.RobustclickElementVisible("TrainingNavBar","WELLExamRatingNavBar");
		CommonMethod.RobustclickElementVisible("WELLExamRatingNavBar","WFExamContinuebtn");
		CommonMethod.RobustclickElementVisible("WFExamContinuebtn","APRegContinue");
		CommonMethod.RobustclickElementVisible("APRegContinue","WPRExamOwnerCountry");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Phone number* is required.", "Phone number Error Mismatch");
		CommonMethod.selectdropdownValue("WPRExamOwnerCountry", "US");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("WPRExamOwnerState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("WPRExamOwnerState"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		String Phoneno = USfaker.number().digits(10);
		testlog.info("ProjectAddress :" + ProjectAddress);
		testlog.info("ProjectCity :" + ProjectCity);
		testlog.info("PostalCode :" + PostalCode);
		testlog.info("Phoneno :" + Phoneno);
		CommonMethod.sendKeys("WPRExamOrgAddress", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WPRExamOrgAddress"));
		CommonMethod.sendKeys("WPRExamOrgCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WPRExamOrgCity"));
		CommonMethod.sendKeys("WPRExamOrgPostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WPRExamOrgPostalcode"));
		CommonMethod.sendKeys("APPhoneNo", Phoneno);
		data.setCellData(SheetName, "PhoneNo", rowNum, CommonMethod.getattributeValue("APPhoneNo"));
		CommonMethod.RobustclickElementVisible("APRegContinue","APJobtitle");
		CommonMethod.WaitUntilVisibility("APJobtitle", 180);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void EnrollExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.RobustclickElementVisible("APJobtitleContinuebtn","APJobtitle");
		CommonMethod.negativesoftassertPageSource("Job title* is required.", "Job title Error Mismatch");
//		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Industry/Sector is required.", "Industry/Sector Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Do you hold any of the following designations? is required.", "Designations Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Gender* is required.", "Gender Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Date of birth* is required.", "Date of birth Error Mismatch");
		CommonMethod.WaitUntilVisibility("APJobtitle", 60);
		String firstName = USfaker.address().firstName();
		testlog.info("firstName: " + firstName);
		CommonMethod.sendKeys("APJobtitle", firstName);
		data.setCellData(SheetName, "APJobtitle", rowNum, CommonMethod.getattributeValue("APJobtitle"));
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("APIndustry");
		data.setCellData(SheetName, "APIndustry", rowNum, CommonMethod.getSelectedDropdownValue("APIndustry"));
		CommonMethod.ClickCheckbox("APDesignationscbx");
		CommonMethod.ClickCheckbox("APGender");
		CommonMethod.WaitUntilVisibility("DatePickerButton", 30);
		CommonMethod.RobustclickElementVisible("DatePickerButton","APYearDOB");
		CommonMethod.WaitUntilVisibility("APYearDOB", 30);
		CommonMethod.RobustclickElementVisible("APYearDOB","APSelctyear");
		CommonMethod.WaitUntilVisibility("APSelctyear", 30);
		CommonMethod.RobustclickElementVisible("APSelctyear","DatePickerOkButton");
		Thread.sleep(1000);
		CommonMethod.WaitUntilVisibility("DatePickerOkButton", 30);
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","APJobtitleContinuebtn");
		CommonMethod.RobustclickElementVisible("APJobtitleContinuebtn","APAlmostContinuebtn");

		CommonMethod.RobustclickElementVisible("APAlmostContinuebtn","APSelectWELLAP");
		CommonMethod.negativesoftassertPageSource("How did you hear about the WELL AP?* is required.", "How did you hear about the WELL AP Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Checkbox is required.", "Credentials Checkbox Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Exam language is required.", "Exam language Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Agreement is required.", "Agreement Error Mismatch");
		CommonMethod.selectdropdownIndex("APSelectWELLAP", 1);
		data.setCellData(SheetName, "APSelectWELLAP", rowNum, CommonMethod.getSelectedDropdownValue("APSelectWELLAP"));
		CommonMethod.ClickCheckbox("APPrimaryReason");
		CommonMethod.selectdropdownIndex("APLanguage", 1);
		data.setCellData(SheetName, "APLanguage", rowNum, CommonMethod.getSelectedDropdownValue("APLanguage"));
		CommonMethod.ClickCheckbox("APAgree");
		CommonMethod.RobustclickElementVisible("APAlmostContinuebtn","APPay");
		CommonMethod.RobustclickElementVisible("APPay","BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 180);
		testlog.pass("**Verifies the Enroll Exam successfully**");
	}

	public void BillingExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
		rc.Billing(SheetName, rowNum);
		CommonMethod.WaitUntilVisibility("APStoreExamId", 60);
		testlog.pass("**Completed Card Payment Billing successfully**");
	}

	public void StoreExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("APStoreExamId", 30);
		String getId = CommonMethod.getText("APStoreExamId");
		data.setCellData(SheetName, "examId", rowNum, getId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
	}

	public void CancelExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar","AdminWELLExamNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLExamNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminWELLExamNavBar","APId");
		CommonMethod.WaitUntilClickble("APId", 60).sendKeys(data.getCellData(SheetName, "examId", rowNum));
		CommonMethod.RobustclickElementVisible("APApplybtn","APClickId");
		CommonMethod.scrolldowntoLast();
		CommonMethod.WaitUntilVisibility("APClickId", 60);
		CommonMethod.RobustclickElementVisible("APClickId","APCancelExam");
		CommonMethod.WaitUntilVisibility("APCancelExam", 60);
		CommonMethod.Robustclick("APCancelExam");
		testlog.pass("**Verifies Cancel the Exam successfully**");
	}
}
