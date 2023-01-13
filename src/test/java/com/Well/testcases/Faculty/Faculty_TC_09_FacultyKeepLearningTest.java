package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Faculty_TC_09_FacultyKeepLearningTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Faculty.Faculty_TC_08_FacultyOrientationTest.Faculty_TC_08_FacultyOrientation" })
	@Parameters({ "SheetName","rowNum" })
	public void Faculty_TC_09_FacultyKeepLearning(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Faculty KeepLearning Card Validation");
		try {
			faculty.keepLearingCardValdationFaculty();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
