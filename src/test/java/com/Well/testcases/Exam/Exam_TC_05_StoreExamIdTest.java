package com.Well.testcases.Exam;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Exam_TC_05_StoreExamIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Exam.Exam_TC_04_BillingTest.Exam_TC_04_Billing" })
	@Parameters({ "SheetName","rowNum" })
	public void Exam_TC_05_StoreExamId(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Capturing of Exam ID");
		try {
		exam.StoreExam(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
