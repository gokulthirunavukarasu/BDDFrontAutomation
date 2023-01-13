package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_05A_PortfolioValidateBillingReceiptTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_05_PortfolioPaymentTest.Portfolio_TC_05_PortfolioPayment" })
	@Parameters({ "SheetName","rowNum","Country" })
	public void Portfolio_TC_05A_PortfolioValidateBillingReceipt(String SheetName, int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate billing receipt");
		try {
			rc.DownloadBillingReceiptAndValidate(SheetName, rowNum, Country);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
}
