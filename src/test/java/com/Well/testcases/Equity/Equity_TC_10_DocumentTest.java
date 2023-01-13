package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_10_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_09_ReviewTest.Equity_TC_09_05_CurativeCompleteReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_10_00_GeneralDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Upload Document in Document");
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

	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_10_DocumentTest.Equity_TC_10_00_GeneralDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Equity_TC_10_01_LegalDocument(String SheetName, int rowNum) throws IOException {

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

	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_10_DocumentTest.Equity_TC_10_01_LegalDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Equity_TC_10_02_AuditDocument(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document in Document");
		try {
			performance.validateAuditUploadDocument(SheetName, rowNum,"EB3");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_10_DocumentTest.Equity_TC_10_02_AuditDocument" })
	@Parameters({ "SheetName", "rowNum" })
	public void Equity_TC_10_03_FeatureDocument(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document in Document");
		try {
			performance.validateFeatureUploadDocument(SheetName, rowNum,"EE1");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_10_DocumentTest.Equity_TC_10_03_FeatureDocument" })
	@Parameters({ "SheetName", "rowNum" })
	public void Equity_TC_10_04_SearchFilterDocumentWER(String SheetName, int rowNum) throws IOException {

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
