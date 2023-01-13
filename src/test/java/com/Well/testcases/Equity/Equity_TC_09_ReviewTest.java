package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_09_ReviewTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_05_ScoreCardCount" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_09_00_PreliminarySubmitReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Equity Review Submit Functionality");
		try {
			equity.WERSubmitReview(SheetName, rowNum, "Preliminary Equity Rating Review");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_09_ReviewTest.Equity_TC_09_00_PreliminarySubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_09_01_PreliminaryCompleteReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Equity Completing Review Functionality");
		try {
			equity.WERCompleteReview(SheetName, rowNum,"Preliminary Equity Rating Review");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_09_01_PreliminaryCompleteReview" })
		@Parameters({ "SheetName","rowNum" })
		public void Equity_TC_09_02_FinalSubmitReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	        StartTest(TestCaseName, "Equity Review Submit Functionality");
			try {
				equity.SearchEquityByID(SheetName,rowNum);
				equity.WERSubmitReview(SheetName, rowNum, "Final Equity Rating Review");	
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}	
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_09_ReviewTest.Equity_TC_09_02_FinalSubmitReview" })
		@Parameters({ "SheetName","rowNum" })
		public void Equity_TC_09_03_FinalCompleteReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	        StartTest(TestCaseName, "Equity Completing Review Functionality");
			try {
				equity.WERCompleteReview(SheetName, rowNum, "Final Equity Rating Review");	
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_09_03_FinalCompleteReview" })
		@Parameters({ "SheetName","rowNum" })
		public void Equity_TC_09_04_CurativeSubmitReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	        StartTest(TestCaseName, "Equity Review Submit Functionality");
			try {
				equity.SearchEquityByID(SheetName,rowNum);
				performance.ClickBilling();
				rc.Billing(SheetName, rowNum);
				equity.WERSubmitReview(SheetName, rowNum,"Curative Action Review");	
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}	
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_09_ReviewTest.Equity_TC_09_04_CurativeSubmitReview" })
		@Parameters({ "SheetName","rowNum" })
		public void Equity_TC_09_05_CurativeCompleteReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	        StartTest(TestCaseName, "Equity Completing Review Functionality");
			try {
				equity.WERCompleteReview(SheetName, rowNum, "Curative Action Review");	
				equity.SearchEquityByID(SheetName,rowNum);
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
}
