package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_SF_01_SearchV2ProjectByNRStatusTest extends BaseClass {

	@Test(dependsOnMethods =  { "com.Well.testcases.V2Project.V2_TC_SF_00_RegisterV2ProjectTest.V2_TC_SF_00_RegisterV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType","Country" })
	public void V2_TC_SF_01_SearchV2ProjectByNRStatus(String SheetName,int rowNum,String ProjectType,String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Certification Enrollment list Functionality");
		try {
		v2project.SearchV2ById(SheetName, rowNum);	
		v2project.SearchV2ProjectFilterByStatus(SheetName, rowNum, "Not Registered", "NOT REGISTERED");
		v2project.ClickSearchV2ProjectById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
