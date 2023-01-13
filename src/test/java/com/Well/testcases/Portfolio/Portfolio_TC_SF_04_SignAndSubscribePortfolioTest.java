package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_SF_04_SignAndSubscribePortfolioTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SF_08_DashboardTest.Portfolio_TC_SF_08_Dashboard" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_SF_04_00_SignAgreementPortfolio(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Portfolio Agreement Sign Functionality");
		try {
			portfolio.SignAgreementPortfolio();	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SF_04_SignAndSubscribePortfolioTest.Portfolio_TC_SF_04_00_SignAgreementPortfolio" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_SF_04_01_SubscribePortfolio(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"WELL At Scale Subscribe Functionality");

		try {
			portfolio.SubscribePortfolio(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
