package com.Well.testcases.Membership;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Membership_TC_09_TeamTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_08_EducationTest.Membership_TC_08_Education" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_09_Team(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Added and Deleted Team Member");
		try {
			membership.AddTeamMember(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
