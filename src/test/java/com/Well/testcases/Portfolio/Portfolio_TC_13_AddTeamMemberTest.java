package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_13_AddTeamMemberTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_14_EditTest.Portfolio_TC_14_01_EditAndValidateAdminField"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_13_AddTeamMember(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify team updation and deletion");

		try {
			portfolio.clickOnTeamPortfolio(SheetName, rowNum);
			portfolio.teamPortfolio(SheetName, rowNum);
			portfolio.deleteAddedTeamMemberPortfolio(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
