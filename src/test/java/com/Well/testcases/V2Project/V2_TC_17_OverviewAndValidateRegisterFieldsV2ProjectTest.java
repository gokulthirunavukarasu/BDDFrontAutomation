package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_17_OverviewAndValidateRegisterFieldsV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_16_AlternativesV2ProjectTest.V2_TC_16_01_AAPAlternativesV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_17_OverviewAndValidateRegisterFieldsV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Overview V2 Project And Validate Register Fields");
		try {
		v2project.overviewV2Project(SheetName, rowNum);	
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
