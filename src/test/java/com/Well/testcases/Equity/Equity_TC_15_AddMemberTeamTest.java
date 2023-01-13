package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_15_AddMemberTeamTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_14_ProfileTest.Equity_TC_14_Profile" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_15_00_AddMemberTeam(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Adding Inviting Team member for Project Functionality");
		try {
			rc.clickOnTeamTab(SheetName, rowNum);
			rc.team(SheetName, rowNum);
			rc.deleteAddedTeamMember(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_15_AddMemberTeamTest.Equity_TC_15_00_AddMemberTeam" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_15_01_DeleteTeam(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Adding Inviting Team member for Project Functionality");
		try {
			rc.clickOnTeamTab(SheetName, rowNum);
			rc.team(SheetName, rowNum);
			rc.deleteAddedTeamMember(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
