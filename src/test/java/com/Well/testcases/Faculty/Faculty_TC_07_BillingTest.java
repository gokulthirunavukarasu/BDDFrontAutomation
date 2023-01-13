package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Faculty_TC_07_BillingTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Faculty.Faculty_TC_06_ResultReviewTest.Faculty_TC_06_ResultReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Faculty_TC_07_Billing(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Faculty Card Payment Functionality");
		try {
			faculty.ReviewBillingFaculty(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
