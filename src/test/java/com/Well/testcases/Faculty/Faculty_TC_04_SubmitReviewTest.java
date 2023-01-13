package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Faculty_TC_04_SubmitReviewTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Faculty.Faculty_TC_03_AgreementFacultyTest.Faculty_TC_03_AgreementFaculty" })
	@Parameters({ "SheetName","rowNum" })
	public void Faculty_TC_04_SubmitReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Submit Review Faculty Functionality");

		try {
			faculty.SubmitReviewFaculty(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
