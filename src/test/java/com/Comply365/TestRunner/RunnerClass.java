package com.Comply365.TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features"},  glue={"com.Comply365.StepDefinition"},
monochrome=true,
plugin={"pretty","junit:JunitReports/report.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
tags="@SmokeTest")



public class RunnerClass {

}
