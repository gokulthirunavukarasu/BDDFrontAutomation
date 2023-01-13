package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_11_SupportTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_10_PortfolioProjectFieldValidationTest.Portfolio_TC_10_PortfolioProjectFieldValidation" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_11_Support(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Rasing the Ticket in Support Functionality");

		try {
			v2project.supportV2Project(SheetName, rowNum);;	

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
