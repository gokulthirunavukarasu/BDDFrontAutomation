package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_10_HealthSafetyV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_09_ReviewV2ProjectTest.V2_TC_09_ReviewV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_10_00_CompleteScorecardHealthSafetyV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Complete HealthSafety Scorecard for V2Project");
		try {
		v2project.HealthSafetyV2Project(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_10_HealthSafetyV2ProjectTest.V2_TC_10_00_CompleteScorecardHealthSafetyV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_10_01_UploadHealthSafetyScorecardDocV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload HealthSafety Scorecard Document V2Project");
		try {
		v2project.uploadHsrDocV2Project();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
