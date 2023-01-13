package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Faculty_TC_06_ResultReviewTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Faculty.Faculty_TC_04_SubmitReviewTest.Faculty_TC_04_SubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Faculty_TC_06_ResultReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Result Submitted Review Functionality");

		try {
			faculty.ReviewSubmitResultFaculty(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
