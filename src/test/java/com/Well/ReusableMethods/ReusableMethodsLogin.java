package com.Well.ReusableMethods;

import java.io.IOException;

import org.testng.ITestContext;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsLogin extends BaseClass {
	
	public void Login() throws IOException, InterruptedException {

		String Username=null;
		String Password=null;
		if(Environment.equalsIgnoreCase("Test")) {
			if(TestNGTestName.contains("Faculty")) {
				Username = data.getCellData("Login", "UserName", 5);
				Password = data.getCellData("Login", "Password", 5);
			}
			else {
			Username = data.getCellData("Login", "UserName", 3);
			Password = data.getCellData("Login", "Password", 3);
			}
		}
		else {
			Username = data.getCellData("Login", "UserName", 2);
		    Password = data.getCellData("Login", "Password", 2);
		}
		//CommonMethod.RobustclickElementVisible("LoginButton","Username");
		CommonMethod.WaitUntilVisibility("Username", 60);
		//CommonMethod.negativesoftassertPageSource("The given data was invalid.", "Data invalid error mismatch");
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", Username);
		testlog.info("Sending Username " + Username);
		CommonMethod.findElementWithRelative("LoginButton", "Password", "above").sendKeys(Password);;
		testlog.info("Sending Password " + Password);
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("LoginButton");
		CommonMethod.RobustclickElementVisible("LoginButton","SuccessfulLogin");
		testlog.info("Clicking on Submit Button");
		CommonMethod.WaitUntilVisibility("SuccessfulLogin", 300);
		testlog.pass("Verfies Login Successful");	
	}
	}


