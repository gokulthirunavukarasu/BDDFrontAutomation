package com.Well.testcases.V2Project;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class V2_TC_SF_07_DashboardV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_SF_01_SearchV2ProjectByNRStatusTest.V2_TC_SF_01_SearchV2ProjectByNRStatus" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_SF_07_DashboardV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify Dashboard fields in V2 Project");
		try {
			v2project.DashboardV2Project(SheetName, rowNum);
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
