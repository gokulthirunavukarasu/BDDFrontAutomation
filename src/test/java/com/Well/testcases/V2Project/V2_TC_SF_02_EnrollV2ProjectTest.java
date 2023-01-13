package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_SF_02_EnrollV2ProjectTest extends BaseClass {
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_SF_07_DashboardV2ProjectTest.V2_TC_SF_07_DashboardV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType","Country" })
	public void V2_TC_SF_02_EnrollV2Project(String SheetName,int rowNum, String ProjectType, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Enroll WELL Certification Project");
		try {
		v2project.EnrollV2ProjectById(SheetName, rowNum, ProjectType, Country);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
