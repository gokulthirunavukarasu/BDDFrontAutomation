package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_07_ScorecardTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_06_LocationTest.Performance_TC_06_Location" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07_00_CompleteScorecard(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Performance Scorecard Complete Functionality");
		try {
			performance.CompleteScorecardWprById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_00_CompleteScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07_01_UploadDocumentScorecard(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Document Scorecard Functionality");
		try {
		performance.UploadWPRDocForFeature();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_01_UploadDocumentScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07_02_AuditUploadDocumentScorecard(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Document Scorecard Functionality");
		try {
		performance.AudituploadDocumentInFeature(SheetName,"Survey for Thermal Comfort");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_02_AuditUploadDocumentScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07_03_ScoreCardSearchFilter(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Search Scorecard Filter Functionality");
		try {
			performance.searchFilterScoreCard("Meet Thresholds for Particulate Matter");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_03_ScoreCardSearchFilter" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07_04_ScoreCardOptionFilter(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Scorecard Filter Options Functionality");
		try {
			performance.verifyScoreCardFilter(SheetName, "Response", "22", 0, 0);
			performance.verifyScoreCardFilter(SheetName, "Verification", "4", 1, 3);
			performance.verifyScoreCardFilter(SheetName, "Document Scale", "33", 2, 24);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_04_ScoreCardOptionFilter" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07_05_ScoreCardCount(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Scorecard Count");
		try {
			rc.VerifyScorecardPurseStatusCount(SheetName, "36","22","14", rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
