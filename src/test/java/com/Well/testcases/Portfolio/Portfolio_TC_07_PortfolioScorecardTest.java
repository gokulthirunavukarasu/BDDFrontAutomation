package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_07_PortfolioScorecardTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_07_00_PortfolioBuildScorecard(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Build WELL At Scale Scorecard Functionality");
        try {
          portfolio.PortfolioBuildScorecard();
         } catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_00_PortfolioBuildScorecard" })
    @Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_07_01_UploadFileInFeatureScorecard() throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document In Feature Scorecard Functionality");
		try {
			portfolio.UploadFileinFeature("Meet Thresholds for Organic Gases");
         } catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_01_UploadFileInFeatureScorecard" })
    @Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_07_02_UploadFileInAudit() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document In Audit Functionality");
		try {
			portfolio.UploadFileinFeature("Support Mindful Eating");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_02_UploadFileInAudit" })
    @Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_07_03_ScorecardSearchFilter() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document In Audit Functionality");
		try {
			portfolio.searchFilterScoreCardV2Project();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_03_ScorecardSearchFilter" })
    @Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_07_04_ScorecardOptionFilter() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document In Audit Functionality");
		try {
			portfolio.scorecardOptionFilterPortfolio();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_04_ScorecardOptionFilter" })
    @Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_07_05_ScorecardCount(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate scorecard count");
		try {
			rc.VerifyScorecardPurseStatusCount(SheetName, "222", "3", "0", rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
