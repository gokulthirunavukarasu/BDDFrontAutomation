package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_06_PortfolioLocationImportTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_05A_PortfolioValidateBillingReceiptTest.Portfolio_TC_05A_PortfolioValidateBillingReceipt" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_06_PortfolioLocationImport(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Importing Locations to WELL At Scale Project");

		try {

			rc.LocationImport(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
