package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_07_ScorecardV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_06_AgreementV2ProjectTest.V2_TC_06_AgreementV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_07_00_BuildScorecardV2ProjectById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2Project Build Scorecard Functionality");
		try {
		v2project.BuildScorecardV2ProjectById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_00_BuildScorecardV2ProjectById" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_07_01_CompleteScorecardV2ProjectById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Scorecard Complete Functionality");
		try {
		v2project.CompleteScorecardV2ProjectById(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_01_CompleteScorecardV2ProjectById" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_07_02_ScorecardPurseStatusCount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Scorecard Complete Functionality");
		try {
		v2project.ScorecardPurseStatusCount(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_02_ScorecardPurseStatusCount" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_07_03_UploadFeatureDocV2ProjectInsideScorecard(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Document in Scorecard Feature");
		try {
		v2project.UploadFeatureDocV2ProjectInsideScorecard(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_03_UploadFeatureDocV2ProjectInsideScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_07_04_UploadAuditDocV2ProjectInsideScorecard(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Audit Document in Scorecard Feature");
		try {
		v2project.UploadAuditDocV2ProjectInsideScorecard(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_04_UploadAuditDocV2ProjectInsideScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_07_05_ScoreCardSearchFilterV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate scorecard search filter successfully");
		try {
			v2project.searchFilterScoreCardV2Project();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_05_ScoreCardSearchFilterV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_07_06_ScoreCardOptionFilterV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate scorecard option filter successfully");
		try {
			v2project.scorecardOptionFilterV2Project(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
