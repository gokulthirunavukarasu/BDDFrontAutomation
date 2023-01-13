package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_05_BillingV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_04_EnrollV2ProjectTest.V2_TC_04_EnrollV2Project" })
	@Parameters({ "SheetName","rowNum","Country" })
	public void V2_TC_05_00_BillingV2Project(String SheetName,int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL v2 Project Card Payment Functionality");
		try {
		v2project.ClickBilling(SheetName, rowNum);
		rc.Billing(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_05_BillingV2ProjectTest.V2_TC_05_00_BillingV2Project" })
	@Parameters({ "SheetName","rowNum","Country" })
	public void V2_TC_05_01_DownloadBillingReceiptAndValidate(String SheetName,int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Download and Validate Billing Receipt");
		try {	
		v2project.DownloadBillingReceiptAndValidate(SheetName, rowNum,Country);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
