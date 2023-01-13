package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Faculty_TC_03_AgreementFacultyTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Faculty.Faculty_TC_02_RegisterFacultyTest.Faculty_TC_02_RegisterFaculty" })
	@Parameters({ "SheetName","rowNum" })
	public void Faculty_TC_03_AgreementFaculty(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Agreement Faculty Functionality");

		try {
			faculty.AgreementFaculty(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
