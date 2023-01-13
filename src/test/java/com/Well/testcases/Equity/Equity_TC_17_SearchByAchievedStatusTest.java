package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_17_SearchByAchievedStatusTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_15A_ValidateProjectAccessTeamTest.Equity_TC_15A_ValidateProjectAccessTeam" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_17_SearchByAchievedStatus(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Equity Enrollment Search list Functionality");

		try {
			equity.SearchEquityByAchievedStatus(SheetName,rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
