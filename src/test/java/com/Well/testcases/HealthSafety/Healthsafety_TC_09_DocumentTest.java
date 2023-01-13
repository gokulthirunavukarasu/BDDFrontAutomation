package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_09_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_08_ReviewTest.Healthsafety_TC_08_05_CurativeCompleteReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_09_00_GeneralDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.clikOnDocumentLibrary();
			hsr.validateGeneralUploadDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_DocumentTest.Healthsafety_TC_09_00_GeneralDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_09_01_LegalDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.validateLegalUploadDocument(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_DocumentTest.Healthsafety_TC_09_01_LegalDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_09_02_AuditDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.validateAuditUploadDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_DocumentTest.Healthsafety_TC_09_02_AuditDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_09_03_FeatureDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.validateFeatureUploadDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_DocumentTest.Healthsafety_TC_09_03_FeatureDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_09_04_LibrarySearchFilterDocumentHSR(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.searchFilterDocumentHSR("FeatureFile", "Library", "1");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_DocumentTest.Healthsafety_TC_09_04_LibrarySearchFilterDocumentHSR" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_09_05_AuditSearchFilterDocumentHSR(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.searchFilterDocumentHSR("AuditFile", "Audit", "1");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_DocumentTest.Healthsafety_TC_09_05_AuditSearchFilterDocumentHSR" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_09_06_GeneralSearchFilterDocumentHSR(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.searchFilterDocumentHSR("LegalFile", "General", "1");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
