package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_03_SubscribeAndStoreIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_02_RegisterHealthSafetyTest.Healthsafety_TC_02_RegisterHealthSafety" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_03_00_Subscribe(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Subscribe the HealthSafety Functionality");

		try {
			rc.Billing(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_03_SubscribeAndStoreIdTest.Healthsafety_TC_03_00_Subscribe" })
		@Parameters({ "SheetName","rowNum" })
		public void Healthsafety_TC_03_01_StoreId(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Store Health Safety Id");

			try {
				hsr.StoreIdHealthSafety(SheetName, rowNum);	
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
}
