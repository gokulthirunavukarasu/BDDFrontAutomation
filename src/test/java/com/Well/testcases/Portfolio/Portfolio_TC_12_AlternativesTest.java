package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_12_AlternativesTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_11_SupportTest.Portfolio_TC_11_Support" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_12_Alternatives(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify alternatives fields values");

		try {
			rc.clickOnAlternatives(SheetName, rowNum);
			rc.alternatives(SheetName, rowNum, "EP");
			rc.alternatives(SheetName, rowNum, "AAP");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
