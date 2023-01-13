package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Faculty_TC_12_FacultyResourcesTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Faculty.Faculty_TC_11_FacultyMarketingToolkitTest.Faculty_TC_11_FacultyMarketingToolkit" })
	@Parameters({ "SheetName","rowNum" })
	public void Faculty_TC_12_FacultyResources(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Faculty Resources Card validation");
		try {
			faculty.resourcesCardValdationFaculty();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
