package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Faculty_TC_05_BulkDeleteInitialTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "SheetName","rowNum" })
	public void Faculty_TC_05_BulkDelete(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Bulk Delete Functionality");
		try {
			faculty.PostRequestAuthenticate(SheetName, rowNum);
			faculty.DeleteFacultyOrMembership();
			testlog.pass("**Verifies Bulk Delete successfully**");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
