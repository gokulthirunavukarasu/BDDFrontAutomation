package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_CTC_01_FeatureTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_01_Feature() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			portfolio.PortfolioBuildScorecard(); 
			/*Air A01.1 */
			 pf.MeetThresholdsforParticulateMatter("Meet Thresholds for Particulate Matter");
				
			/* Air A01.3 */
			 pf.MeetThresholdsforInOrganicGases("Meet Thresholds for Inorganic Gases");
			 
			/*
			 * Air A01.2
			 */
			pf.MeetThresholdsforOrganicGases("Meet Thresholds for Organic Gases");
			/*
			 * Air A04.1
			 */
			pf.MitigateConstructionPollution("Mitigate Construction Pollution");
			/*
			 * Air A05.2
			 */
			pf.MeetEnhancedThresholdsforOrganicGases("Meet Enhanced Thresholds for Organic Gases");
			/*
			 * Air A07.2
			 */
			pf.ManageWindowUse("Manage Window Use");
			/*
			 * Air A08.1
			 */
			pf.InstallIndoorAirMonitors("Install Indoor Air Monitors");
			/*
			 * Light L06.1
			 */
			pf.ConductDaylightSimulation("Conduct Daylight Simulation");
			/*
			 * Light L09.1
			 */
		   pf.EnhanceOccupantControllability("Enhance Occupant Controllability");
			/*
			 * V09.1
			 */
			pf.OfferPhysicalActivityIncentives("Offer Physical Activity Incentives");

			/*
			 * X06.2
			 */
			pf.RestrictVOCEmissionsfromFurnitureArchitecturalandInteriorProducts("Restrict VOC Emissions from Furniture, Architectural and Interior Products");
			 
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

}
