package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_16_AlternativesV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_15_SupportV2ProjectTest.V2_TC_15_SupportV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_16_00_EPAlternativesV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"EP Alternatives V2Project Functionality");
		try {
			rc.clickOnAlternatives(SheetName, rowNum);
			rc.alternatives(SheetName, rowNum, "EP");
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_16_AlternativesV2ProjectTest.V2_TC_16_00_EPAlternativesV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_16_01_AAPAlternativesV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"AAP Alternatives V2Project Functionality");
		try {
			rc.alternatives(SheetName, rowNum, "AAP");
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
