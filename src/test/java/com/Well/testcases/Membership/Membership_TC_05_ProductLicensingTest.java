package com.Well.testcases.Membership;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Membership_TC_05_ProductLicensingTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_04_BillingTest.Membership_TC_04_Billing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_00_NavigationToProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Navigating to Product Licensing Functionality");
		try {
		membership.AdminMembershipNavigation(SheetName, rowNum,MembershipName);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_05_ProductLicensingTest.Membership_TC_05_00_NavigationToProductLicensing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_01_UploadDocumentInProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Document In Product Licensing Functionality");
		try {
		membership.UploadDocumentInLicensing(SheetName, rowNum,MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_05_ProductLicensingTest.Membership_TC_05_01_UploadDocumentInProductLicensing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_02_CreateProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Create Product Licensing Functionality");
		try {
      membership.CreateLicensing(SheetName, rowNum,MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_05_ProductLicensingTest.Membership_TC_05_02_CreateProductLicensing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_03_UpdateProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Update Product Licensing Functionality");
		try {
		membership.UpdateLicensing(SheetName, rowNum,MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_05_ProductLicensingTest.Membership_TC_05_03_UpdateProductLicensing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_04_DeleteProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Deleting Product Licensing Functionality");
		try {
		membership.DeleteLicensing(SheetName, rowNum,MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_05_ProductLicensingTest.Membership_TC_05_04_DeleteProductLicensing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_05_SubmitProductLicensingReview(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Submit for Product Licensing Review Functionality");
		try {
		membership.SubmitProductLicensingReview(SheetName, rowNum,MembershipName);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
