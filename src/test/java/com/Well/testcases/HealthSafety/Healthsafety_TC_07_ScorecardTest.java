package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_07_ScorecardTest extends BaseClass {


	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_06_LocationTest.Healthsafety_TC_06_Location" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_07_00_CompleteScorecard(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"HealthSafety Scorecard Complete Functionality");
		try {
		hsr.CompleteScorecardHsrById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_00_CompleteScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_07_01_UploadScorecardDocument(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Scorecard Document Functionality");
		try {
		hsr.UploadHsrDocForFeature();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_01_UploadScorecardDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_07_02_FilterResponse(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Scorecard Filter Response Functionality");
		try {
		hsr.validateScorecardFilterResponse();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_02_FilterResponse" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_07_03_FilterVerification(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Scorecard Filter Verification Functionality");
		try {
		hsr.validateScorecardFilterVerification();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_03_FilterVerification" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_07_04_ScorecardCount(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate scorecard count");
		try {
		rc.VerifyScorecardPurseStatusCount(SheetName, "27", "15", "12", rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
