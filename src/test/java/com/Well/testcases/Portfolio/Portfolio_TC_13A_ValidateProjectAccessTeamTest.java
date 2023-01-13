package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_13A_ValidateProjectAccessTeamTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_13_AddTeamMemberTest.Portfolio_TC_13_AddTeamMember"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_13A_ValidateProjectAccessTeam(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifies user able to access the invited Portfolio project");

		try {
			portfolio.teamPortfolio(SheetName, rowNum);
			rc.SignOut();
			rc.teamMemberLogin(SheetName, rowNum);
			portfolio.validateTeamsPortfolio(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
