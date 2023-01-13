package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_04A_SearchPerformanceByStatusTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_04_SearchPerformanceByIdTest.Performance_TC_04_SearchPerformanceById" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_04A_SearchPerformanceByStatus(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Performance Enrollment Search list Functionality");
		try {
        performance.SearchPerformanceFilterStatus(SheetName,rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
