package com.Comply365.StepDefinition;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ClientApiException;

import com.Comply365.Engine.BaseClass;
import com.Comply365.Engine.CommonMethod;
import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Stepdef extends BaseClass  {
	
	@After
	public void addScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}
	
	@Given("User is on Hireprous login page")
	public void user_is_on_hireprous_login_page() throws InterruptedException, IOException, ClientApiException {
		setup();
	}
	@When("User enters username and password")
	public void user_enters_username_and_password() throws IOException, InterruptedException  {
		CommonMethod.WaitUntilPresence("UserName", 120);
		CommonMethod.sendKeys("UserName", data.getCellData("Login", "UserName", 2));
		CommonMethod.sendKeys("Password", data.getCellData("Login", "Password", 2));
	}
	@And("User clicks on Log IN button")
	public void user_clicks_on_log_in_button() throws InterruptedException, IOException {
		CommonMethod.RobustclickElementVisible("loginBtn","SuccessfulLogin");
		
	}
	@Then("User login must be successful")
	public void user_login_must_be_successful() throws InterruptedException, IOException {
		 CommonMethod.WaitUntilVisibility("SuccessfulLogin", 300);
	}

}
