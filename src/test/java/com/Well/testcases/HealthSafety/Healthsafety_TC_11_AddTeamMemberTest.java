package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_11_AddTeamMemberTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_16_DownloadBillingReceiptAndValidateTest.Healthsafety_TC_16_DownloadBillingReceiptAndValidate" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_11_AddTeamMember(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding Inviting Team member for Project Functionality");
		try {
			rc.clickOnTeamTab(SheetName, rowNum);
			rc.team(SheetName, rowNum);
			rc.deleteAddedTeamMember(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
