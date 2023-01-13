package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_09_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_08_ReviewTest.Performance_TC_08_05_CompleteCurativeReview" })
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_09_00_GeneralDocument(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Document in Document");
		try {
			performance.clikOnDocumentLibrary();
			performance.validateGeneralUploadDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_09_DocumentTest.Performance_TC_09_00_GeneralDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_09_01_LegalDocument(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Document in Document");
		try {
			performance.validateLegalUploadDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	

	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_09_DocumentTest.Performance_TC_09_01_LegalDocument" })
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_09_03_FeatureDocument(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Document in Document");
		try {
			performance.validateFeatureUploadDocument(SheetName, rowNum,"PX1.1");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_09_DocumentTest.Performance_TC_09_03_FeatureDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_09_02_AuditDocument(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Document in Document");
		try {
			performance.validateAuditUploadDocument(SheetName, rowNum,"PX5");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_09_DocumentTest.Performance_TC_09_02_AuditDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_09_04_SearchFilterDocument(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Document in Document");
		try {
			rc.searchFilterDocument("FeatureFile","1");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
