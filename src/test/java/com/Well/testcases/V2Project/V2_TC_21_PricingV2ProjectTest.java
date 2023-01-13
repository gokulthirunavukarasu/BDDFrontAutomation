package com.Well.testcases.V2Project;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class V2_TC_21_PricingV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_04_EnrollV2ProjectTest.V2_TC_04_EnrollV2Project" })
	@Parameters({ "SheetName","rowNum","Discount","ProjectType" })
	public void V2_TC_21_PricingV2Project(String SheetName,int rowNum, String Discount, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Pricing Estimate in V2 Project");
		try {
			if (Discount.equalsIgnoreCase("SectorDiscount")) {
				v2project.CalculatePricingV2Project(SheetName, rowNum, ProjectType);
				v2project.PricingSectorDiscountValidationV2Project(SheetName, rowNum);
			}
			else if (Discount.equalsIgnoreCase("NoDiscount")) {
				v2project.CalculatePricingV2Project(SheetName, rowNum, ProjectType);
				v2project.PricingNoDiscountValidationV2Project(SheetName, rowNum);
			}
			
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
