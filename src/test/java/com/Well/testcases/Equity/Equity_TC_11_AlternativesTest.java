package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_11_AlternativesTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10_DocumentTest.Equity_TC_10_04_SearchFilterDocumentWER" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_11_00_EPAlternatives(String SheetName,int rowNum) throws IOException {

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

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_11_AlternativesTest.Equity_TC_11_00_EPAlternatives" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_11_01_AAPAlternatives(String SheetName,int rowNum) throws IOException {

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
