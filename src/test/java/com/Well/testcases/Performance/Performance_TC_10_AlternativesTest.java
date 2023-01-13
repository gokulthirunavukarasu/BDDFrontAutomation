package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_10_AlternativesTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_DocumentTest.Performance_TC_09_04_SearchFilterDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_10_EPAlternatives(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Adding feature in EP alternatives functionality");
		try {
			rc.clickOnAlternatives(SheetName, rowNum);
			rc.alternatives(SheetName, rowNum, "EP");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_10_AlternativesTest.Performance_TC_10_EPAlternatives" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_10_AAPAlternatives(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Adding feature in AAP alternatives functionality");
			try {
				rc.alternatives(SheetName, rowNum, "AAP");	
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
}
