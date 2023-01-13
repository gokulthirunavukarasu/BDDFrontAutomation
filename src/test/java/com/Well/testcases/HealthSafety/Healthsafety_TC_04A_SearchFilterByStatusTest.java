package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_04A_SearchFilterByStatusTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_04_SearchHealthSafetyByIdTest.Healthsafety_TC_04_SearchHealthSafetyById" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_04A_SearchFilterByStatus(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"HealthSafety Enrollment Search list Functionality");
		try {
         hsr.SearchFilterRegisteredStatus(SheetName,rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
