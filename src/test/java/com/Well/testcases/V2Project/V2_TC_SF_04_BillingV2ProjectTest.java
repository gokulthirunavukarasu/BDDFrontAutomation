package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_SF_04_BillingV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_SF_03_SearchV2ProjectByRIPStatusTest.V2_TC_SF_03_SearchV2ProjectByRIPStatus" })
	@Parameters({ "SheetName","rowNum","Country" })
	public void V2_TC_SF_04_BillingV2Project(String SheetName,int rowNum, String Country) throws IOException {

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
}
