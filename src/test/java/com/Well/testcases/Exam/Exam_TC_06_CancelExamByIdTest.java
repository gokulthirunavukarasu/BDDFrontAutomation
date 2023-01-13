package com.Well.testcases.Exam;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Exam_TC_06_CancelExamByIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Exam.Exam_TC_05_StoreExamIdTest.Exam_TC_05_StoreExamId" })
	@Parameters({ "SheetName","rowNum" })
	public void Exam_TC_06_CancelExamById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Admin Cancel Exam functionality");
		try {
		exam.CancelExam(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
