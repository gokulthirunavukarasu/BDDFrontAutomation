package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_08_ReviewTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_05_ScoreCardCount" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_08_00_SubmitPreliminaryReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
		performance.SubmitWPRReview(SheetName, rowNum, "Preliminary Performance Rating Review");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_08_ReviewTest.Performance_TC_08_00_SubmitPreliminaryReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_08_01_CompletePreliminaryReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
		performance.CompleteWPRReview(SheetName, rowNum, "Preliminary Performance Rating Review");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_08_ReviewTest.Performance_TC_08_01_CompletePreliminaryReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_08_02_FinalSubmitReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
	    performance.SearchPerformanceByID(SheetName,rowNum);
		performance.SubmitWPRReview(SheetName, rowNum,"Final Performance Rating Review");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_08_ReviewTest.Performance_TC_08_02_FinalSubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_08_03_CompleteFinalReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Complete Performance Review Functionality");
		try {
		performance.CompleteWPRReview(SheetName, rowNum,"Final Performance Rating Review");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_08_ReviewTest.Performance_TC_08_03_CompleteFinalReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_08_04_CurativeSubmitReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
		performance.SearchPerformanceByID(SheetName,rowNum);
		performance.ClickBilling();
		rc.Billing(SheetName, rowNum);
		performance.SubmitWPRReview(SheetName, rowNum,"Curative Action Review");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_08_ReviewTest.Performance_TC_08_04_CurativeSubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_08_05_CompleteCurativeReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Complete Performance Review Functionality");
		try {
		performance.CompleteWPRReview(SheetName, rowNum,"Curative Action Review");	
		performance.SearchPerformanceByID(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
