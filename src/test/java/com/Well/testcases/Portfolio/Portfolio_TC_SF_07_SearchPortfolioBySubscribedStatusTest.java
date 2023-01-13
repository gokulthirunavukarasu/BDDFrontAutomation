package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_SF_07_SearchPortfolioBySubscribedStatusTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SF_09_ResourceTest.Portfolio_TC_SF_09_Resource" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_17_SearchPortfolioBySubscribedStatus(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL At Scale Enrollment List Functionality");
		try {
			portfolio.SearchPortfolioBySubcribedStatus(SheetName,rowNum,"SUBSCRIBED");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
