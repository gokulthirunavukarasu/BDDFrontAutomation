package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_SF_06_SearchV2ProjectFiltersTest extends BaseClass {

	@Test(dependsOnMethods =  { "com.Well.testcases.V2Project.V2_TC_SF_05_SearchV2ProjectByRegisteredStatusTest.V2_TC_SF_05_SearchV2ProjectByRegisteredStatus" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_SF_06_SearchV2ProjectFilters(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Certification Enrollment list Functionality");
		try {
			v2project.SearchV2ProjectFilters(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
