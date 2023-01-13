package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_12_EditTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_10_AlternativesTest.Healthsafety_TC_10_01_AAPAlternatives" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12_Edit(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Updating the Project field and validating");
		try {
			rc.editAndValidateOrganizationInformation(SheetName, rowNum);
			rc.editAndValidateAdmin(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
