package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_03_SubscribeAndStoreIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_02_RegisterPerformanceTest.Performance_TC_02_RegisterPerformance" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_03_00_SubscribeAndStoreId(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Subscribe the Performance Functionality");

		try {
			rc.Billing(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_02_RegisterPerformanceTest.Performance_TC_02_RegisterPerformance" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_03_01_StoreId(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Store Performance Id");

		try {
			performance.StoreIdPerformance(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
