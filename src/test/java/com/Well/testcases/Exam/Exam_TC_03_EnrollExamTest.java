package com.Well.testcases.Exam;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Exam_TC_03_EnrollExamTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Exam.Exam_TC_02_RegisterExamTest.Exam_TC_02_RegisterExam" })
	@Parameters({ "SheetName","rowNum" })
	public void Exam_TC_03_EnrollExam(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Enroll Exam Functionality");

		try {
			exam.EnrollExam(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
