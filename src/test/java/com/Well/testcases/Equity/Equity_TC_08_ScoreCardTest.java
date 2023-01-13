package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_08_ScoreCardTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_07_LocationTest.Equity_TC_07_01_AddLocation" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_00_CompleteScorecardWerById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Performance Scorecard Complete Functionality");
		try {
			equity.CompleteScorecardWerById(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_00_CompleteScorecardWerById" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_01_UploadWERDocForFeature() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Upload Document Scorecard Functionality");
		try {
			equity.UploadWERDocForFeature(21);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_01_UploadWERDocForFeature" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_02_AuditUploadDocumentScorecard(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Document Scorecard Functionality");
		try {
		performance.AudituploadDocumentInFeature(SheetName,"Offer Accessible Health Services");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_02_AuditUploadDocumentScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_03_ScoreCardSearchFilter(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Search Scorecard Filter Functionality");
		try {
			performance.searchFilterScoreCard("Create DEI Assessment and Action Plan");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_03_ScoreCardSearchFilter" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_04_ScoreCardOptionFilter(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Scorecard Filter Options Functionality");
		try {
			performance.verifyScoreCardFilter(SheetName, "Response", "22", 0, 0);
			performance.verifyScoreCardFilter(SheetName, "Verification", "4", 1, 3);
			performance.verifyScoreCardFilter(SheetName, "Document Scale", "10", 2, 24);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_04_ScoreCardOptionFilter" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_05_ScoreCardCount(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate scorecard count");
		try {
			rc.VerifyScorecardPurseStatusCount(SheetName, "49", "22", "27", rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
