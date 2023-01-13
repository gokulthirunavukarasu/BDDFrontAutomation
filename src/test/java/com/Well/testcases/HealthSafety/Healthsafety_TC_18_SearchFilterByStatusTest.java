package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_18_SearchFilterByStatusTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_11A_ValidateProjectAccessTeamTest.Healthsafety_TC_11A_ValidateProjectAccessTeam" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_18_SearchFilterByStatus(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"HealthSafety Enrollment Search list Functionality");
		try {
         hsr.SearchHealthSafetyByStatus(SheetName,rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
