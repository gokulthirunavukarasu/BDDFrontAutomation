package com.Well.Engine;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.base.Verify;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class CommonMethod extends BaseClass {

	static Format formatter = new SimpleDateFormat("YYYY-MM-dd");
	static Date date = new Date();
	public static String fetchedID;
	public static String ProgramID;
	public static String signupID;
	public static String screenshotfile = System.getProperty("user.dir") + "/Screenshots/";
	public static File extentconfigfile = new File(
			System.getProperty("user.dir") + "/src/main/resources/extent-config.xml");
	public static String Reportfile = System.getProperty("user.dir") + "/Report/WELL-AutomationReport" + "_"
			+ formatter.format(date) + ".html";
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	static WebElement element;
	public static List<String> uploadedFilesList = new ArrayList<String>();
	public static ArrayList<String> narrativevalues = new ArrayList<String>();
	public static ArrayList<String> numericvalues = new ArrayList<String>();
	public static ArrayList<String> textvalues = new ArrayList<String>();
	public static ArrayList<String> dropdownvalues = new ArrayList<String>();
	public static ArrayList<String> datevalues = new ArrayList<String>();
	
	public static WebElement findElementWithRelative(final String objectLocaterFirst,final String objectLocaterSecond,String Type) throws IOException {

		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);

		String objecttypeandvalues = OR.getProperty(objectLocaterSecond);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		String objectvalue = splits[1];
		// System.out.println(objecttype);
		System.out.println("obj val: " + objectvalue);

		switch (objecttype) {

		case "id":
			return driver.findElement(By.id(objectvalue));

		case "xpath":
			switch (Type) {
			
			case "above":
			return driver.findElement(RelativeLocator.with(By.xpath(objectvalue)).above(LocatorStrategy(objectLocaterFirst)));
			}
		case "name":

			return driver.findElement(By.name(objectvalue));

		case "class":

			return driver.findElement(By.className(objectvalue));

		case "tagname":

			return driver.findElement(By.tagName(objectvalue));

		case "css":

			return driver.findElement(By.cssSelector(objectvalue));

		case "linkText":

			return driver.findElement(By.linkText(objectvalue));
		default:

			return null;
		}

	}
	
	public static By LocatorStrategy(final String objectLocater) throws IOException {

		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);
          
		String objecttypeandvalues = OR.getProperty(objectLocater);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		String objectvalue = splits[1];
		// System.out.println(objecttype);
		System.out.println("obj val: " + objectvalue);

		switch (objecttype) {

		case "id":
			return (By.id(objectvalue));

		case "xpath":

			return (By.xpath(objectvalue));

		case "name":

			return (By.name(objectvalue));

		case "class":

			return (By.className(objectvalue));

		case "tagname":

			return (By.tagName(objectvalue));

		case "css":

			return (By.cssSelector(objectvalue));

		case "linkText":

			return (By.linkText(objectvalue));
		default:

			return null;
		}

	}


	public static WebElement findElement(final String objectLocater) throws IOException {
		JSWaiter.waitAllRequest();
		waitForPageLoaded();
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);

		String objecttypeandvalues = OR.getProperty(objectLocater);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		String objectvalue = splits[1];
		// System.out.println(objecttype);
		System.out.println("obj val: " + objectvalue);

		switch (objecttype) {

		case "id":
			return driver.findElement(By.id(objectvalue));

		case "xpath":

			return driver.findElement(By.xpath(objectvalue));

		case "name":

			return driver.findElement(By.name(objectvalue));

		case "class":

			return driver.findElement(By.className(objectvalue));

		case "tagname":

			return driver.findElement(By.tagName(objectvalue));

		case "css":

			return driver.findElement(By.cssSelector(objectvalue));

		case "linkText":

			return driver.findElement(By.linkText(objectvalue));
		default:

			return null;
		}

	}

	public static List<WebElement> findElements(String objectLocater) throws IOException {
		JSWaiter.waitAllRequest();
		waitForPageLoaded();
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);
		String objecttypeandvalues = OR.getProperty(objectLocater);
		// System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		// System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);

		switch (objecttype) {

		case "id":
			return driver.findElements(By.id(objectvalue));

		case "xpath":

			return driver.findElements(By.xpath(objectvalue));

		case "name":

			return driver.findElements(By.name(objectvalue));

		case "class":

			return driver.findElements(By.className(objectvalue));

		case "tagname":

			return driver.findElements(By.tagName(objectvalue));

		case "css":

			return driver.findElements(By.cssSelector(objectvalue));

		case "linkText":

			return driver.findElements(By.linkText(objectvalue));
		default:

			return null;
		}

	}

	public static List<WebElement> findElementsCustom(String objectLocater) throws IOException {

		JSWaiter.waitAllRequest();
		waitForPageLoaded();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);
		String objecttypeandvalues = OR.getProperty(objectLocater);
		// System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		// System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);

		switch (objecttype) {

		case "id":
			return driver.findElements(By.id(objectvalue));

		case "xpath":

			return driver.findElements(By.xpath(objectvalue));

		case "name":

			return driver.findElements(By.name(objectvalue));

		case "class":

			return driver.findElements(By.className(objectvalue));

		case "tagname":

			return driver.findElements(By.tagName(objectvalue));

		case "css":

			return driver.findElements(By.cssSelector(objectvalue));

		case "linkText":

			return driver.findElements(By.linkText(objectvalue));
		default:

			return null;
		}

	}

	// user defined click Method
	public static void click(String objectLocater) throws IOException {

		CommonMethod.WaitUntilClickble(objectLocater, timeout);
		findElement(objectLocater).click();
		

	}
	
	public static void Robustclick(String objectLocater) throws IOException, InterruptedException {
		long startTime = System.currentTimeMillis();
		do {
			System.out.println("1");
			Thread.sleep(3000);
			if(CommonMethod.isElementsExist(objectLocater,5)) {
				try {
			findElement(objectLocater).click();
		    Thread.sleep(3000);
			System.out.println("Inside");
			}
			
			catch(Exception e) {
				
			}
			}
		}while(!(!CommonMethod.isElementsExist(objectLocater, 2) || !((System.currentTimeMillis()-startTime)<60000)));
        
	}
	
	public static void Robustclick(String objectLocater,String objectLocater1) throws IOException, InterruptedException {
		long startTime = System.currentTimeMillis();
		do {
			System.out.println("1");
			Thread.sleep(2000);
			if(CommonMethod.isElementsExist(objectLocater,5)) {
				try {
			findElement(objectLocater).click();
		    Thread.sleep(2000);
			System.out.println("Inside");
			}
			catch(Exception e) {	
			}
			}
		}while(!(!CommonMethod.isElementsExist(objectLocater1, 2) || !((System.currentTimeMillis()-startTime)<60000)));
        
	}
	
	public static void RobustclickElementVisible(String objectLocater,String objectLocater1) throws IOException, InterruptedException {
		long startTime = System.currentTimeMillis();
		do {
			System.out.println("1");
			Thread.sleep(2000);
			if(CommonMethod.isElementsExist(objectLocater,5)) {
				try {
			findElement(objectLocater).click();
		    Thread.sleep(2000);
			System.out.println("Inside");
			}
			
			catch(Exception e) {
				
			}
			}
		}while(!(CommonMethod.isElementsExist(objectLocater1, 2)  || !((System.currentTimeMillis()-startTime)<60000)));
        
	}
	

	public static void click(WebElement objectLocater) throws IOException {

		objectLocater.click();

	}

	// user defined sendkeys Method
	public static void sendKeys(String objectLocater, String value) throws IOException {
		CommonMethod.WaitUntilClickble(objectLocater, timeout);
		findElement(objectLocater).sendKeys(value);
		
	}
	public static void sendKeyEnter(String objectLocater) throws IOException {
		findElement(objectLocater).sendKeys( Keys.ENTER);
		
	}
	// user defined gettext Method
	public static String getText(String objectLocater) throws IOException {

		return findElement(objectLocater).getText();

	}

	public static String getText(WebElement objectLocater) throws IOException {

		return objectLocater.getText();

	}

	public static void refreshBrowser(){

		driver.navigate().refresh();

	}

	public static void GotoURL(String URL) throws IOException {

		// driver.navigate().to(URL);
		driver.get(URL);

	}

	public static String getattributeValue(String objectLocater) throws IOException {

		return findElement(objectLocater).getAttribute("value");

	}

	public static String getattributeValueWebElement(WebElement objectLocater, String attribute) throws IOException {

		return objectLocater.getAttribute(attribute);

	}

	public static String getattributeLabel(String objectLocater) throws IOException {

		return findElement(objectLocater).getAttribute("label");

	}

	// user defined clear Method
	public static void clear(String objectLocater) throws IOException {
		findElement(objectLocater).clear();
		testlog.pass("Clearing TextField");
		

	}

	public static void uploadFile(String objectLocater, String file) throws IOException {
		findElement(objectLocater).sendKeys(file);
		

	}
	
	public static void uploadFile(String objectLocater, String file, String VerifyobjectLocater) throws IOException {
		findElement(objectLocater).sendKeys(file);
		WaitUntilVisibility(VerifyobjectLocater, 60);
	}

	public static void uploadFile(WebElement objectLocater, String file) throws IOException {
		objectLocater.sendKeys(file);

	}

	public static void navigateBack() {

		driver.navigate().back();
	}

	
	/*
	 * public static void renameAndCopyfile(String CreditID) throws IOException{
	 * File oldfile = new File(CreditUploadFile1); v2009file =
	 * downloadPath+CreditID+"_"+CreditUploadFile; newfile = new File(v2009file);
	 * 
	 * FileUtils.copyFile(oldfile, newfile);
	 * 
	 * if(oldfile.renameTo(newfile)) {
	 * System.out.println("File name changed succesful"); } else {
	 * System.out.println("Rename failed"); } }
	 */
	 

	public static void assertcontainsmessage(ArrayList<String> Expected, String Actual, String message)
			throws IOException {

		// System.out.println(Arrays.toString(Expected.toArray()));
		// System.out.println(Actual);
		Assert.assertTrue(Expected.contains(Actual), message);
	}

	public static void assertTruegetAttributeComparision(String objectLocater, String name, String message)
			throws IOException {
		Assert.assertTrue(findElement(objectLocater).getAttribute("value").equalsIgnoreCase(name), message);
	}

	public static void moveToElement(String objectLocator) throws IOException {

		Actions action = new Actions(driver);
		action.moveToElement(findElement(objectLocator)).build().perform();

	}

	public static void moveToElementinLoop(String objectLocator, String objectLocator1) throws IOException {

		Actions action = new Actions(driver);
		do {

			action.click(findElement(objectLocator)).perform();
			;
		} while (!isElementsExist(objectLocator1, 3));

	}

	public static void PressKey() throws IOException {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).build().perform();
		System.out.println("Done");
	}

	public static void moveToElementAndClick(String objectLocator) throws IOException {

		Actions action = new Actions(driver);
		action.moveToElement(findElement(objectLocator)).click().perform();

	}

	public static void doublemoveToElementAndClick(String objectLocator, String objectLocator1) throws IOException {

		Actions action = new Actions(driver);
		action.moveToElement(findElement(objectLocator)).clickAndHold().moveToElement(findElement(objectLocator1))
				.click().build().perform();

	}

	public static void moveToElementAndClick(WebElement objectLocator) throws IOException {

		Actions action = new Actions(driver);
		action.moveToElement(objectLocator).click().build().perform();

	}
	
	public static void movedownaction() throws IOException {

		Actions actions = new Actions(driver);
		// Page Down
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		// Page Up
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).perform();

	}

	public static boolean isSelected(WebElement objectLocater) throws IOException {

		return objectLocater.isSelected();

	}

	public static boolean isEnabled(WebElement objectLocater) throws IOException {

		return objectLocater.isSelected();

	}

	public static boolean isSelected(String objectLocater) throws IOException {

		return findElement(objectLocater).isSelected();

	}

	public static void ClickFirstElementInList(String objectLocator) throws IOException, InterruptedException {

		if (IsDimensionOK(objectLocator)) {
			List<WebElement> li = findElements(objectLocator);
			if (!CommonMethod.isSelected(li.get(0))) {
				Thread.sleep(2000);
				li.get(0).click();
			}
		}
	}

	public static void ClickSecondElementInList(String objectLocator) throws IOException {

		List<WebElement> li = findElements(objectLocator);
		if (!CommonMethod.isSelected(li.get(1))) {
			li.get(1).click();
		}
	}

	public static void ClickLastElementInList(String objectLocator) throws IOException {

		List<WebElement> li = findElements(objectLocator);
		if (!CommonMethod.isSelected(li.get(li.size() - 1))) {
			(li.get(li.size() - 1)).click();
		}
	}

	public static void OpenNewTab(String objectLocator) throws IOException {

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		findElement(objectLocator).sendKeys(selectLinkOpeninNewTab);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

	public static void OpenNewTab(WebElement objectLocator) throws IOException {

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		objectLocator.sendKeys(selectLinkOpeninNewTab);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

	public static void OpenNewTab(WebElement objectLocator, String URL) throws IOException {

		// ((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		objectLocator.sendKeys(selectLinkOpeninNewTab);
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

		// driver.findElement(By.linkText("Team")).sendKeys(selectLinkOpeninNewTab);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		GotoURL(URL);
	}

	public static void OpenNewTabChild(WebElement objectLocator) throws IOException {

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		objectLocator.sendKeys(selectLinkOpeninNewTab);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(2));
	}

	public static void switchToParentTab() {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		for (String handle : tabs) {
			if (!handle.equals(tabs.get(0))) {

				driver.close();
			}
		}

		driver.switchTo().window(tabs.get(0));
	}

	public static void switchToChildTab() {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		for (String handle : tabs) {
			if (!handle.equals(tabs.get(1)) && !handle.equals(tabs.get(0))) {

				driver.close();
			}
		}

		driver.switchTo().window(tabs.get(1));
	}

	public static void checkTextFieldIsNotEmpty(String objectLocator, String Message) throws IOException {

		String textInsideInputBox = CommonMethod.getattributeValue(objectLocator);

		// Check whether input field is blank
		if (textInsideInputBox.isEmpty()) {
			testlog.fail(Message);
		}
	}

	public static void VerifyAllCheckboxesChecked() throws IOException {
		List<WebElement> checkbox = findElements("Checkbox");
		System.out.println("Checkbox size: " + checkbox.size());
		testlog.pass("Checking number of Checkboxes on Page - " + checkbox.size());

		for (WebElement check : checkbox) {

			if (!CommonMethod.isSelected(check)) {
				/*
				 * CommonMethod.scrolldowntoElement(check); testlog.pass("Moving to Checkbox");
				 * CommonMethod.click(check); testlog.pass("Checkbox is clicked");
				 */
				System.out.println("All Checkboxes are not checked");
			}
		}
	}

	public static void ClickParticularCheckbox(String objectlocator) throws IOException {
		List<WebElement> checkbox = findElements(objectlocator);
		System.out.println("Checkbox size: " + checkbox.size());
		testlog.pass("Checking number of Checkboxes on Page - " + checkbox.size());

		for (WebElement check : checkbox) {

			do {
				// CommonMethod.scrolldowntoElement(check);
				//testlog.pass("Moving to Checkbox");
				CommonMethod.click(check);
				//testlog.pass("Checkbox is clicked");
			} while (!CommonMethod.isSelected(check));

		}
	}
	
	public static void ClickCheckbox(String objectlocator) throws IOException {
	
			do {
				// CommonMethod.scrolldowntoElement(check);
				CommonMethod.WaitUntilClickble(objectlocator, 30);
				//testlog.pass("Moving to Checkbox");
				CommonMethod.click(objectlocator);
				//testlog.pass("Checkbox is clicked");
			} while (!CommonMethod.isSelected(objectlocator));

		}
	public static void softAssertEqualsMessage(String Actual, String expected, String message) {
       System.out.println("Actual: "+Actual +"expected: "+expected);
		softAssert.assertEquals(Actual, expected, message);
	}
	public static void negativesoftassertPageSource(String expectedtext, String message) {

		negativesoftAssert.assertTrue(driver.getPageSource().contains(expectedtext), message);

	}
	public static void softAssertContainsMessage(String Actual, String expected, String message) {
		System.out.println("Actual: "+Actual +"expected: "+expected);
		softAssert.assertTrue(Actual.contains(expected), message);
	}

	public static void assertTruebooleanCondition(boolean boo, String message) {

		Assert.assertTrue(boo, message);
	}

	public static void assertEqualsmessage(String objectLocator, String expected, String message) throws IOException {

		Assert.assertEquals(getText(objectLocator), expected, message);
	}

	public static void assertEqualsmessageWithoutCase(String Actual, String expected, String message)
			throws IOException {

		Assert.assertEquals(Actual.toLowerCase(), expected.toLowerCase(), message);
	}

	public static void assertEqualsmessageAttributevalue(String objectLocator, String expected, String message)
			throws IOException {

		Assert.assertEquals(getattributeValue(objectLocator), expected, message);
	}

	public static void assertNotSame(String objectLocator, String expected, String message) throws IOException {
		System.out.println(CommonMethod.getText("ErrorMessage"));
		Assert.assertNotSame((findElement(objectLocator)).getText(), expected, message);
	}

	public static void assertcontainsmessage(String objectLocater, String expected, String message) throws IOException, InterruptedException {
        Thread.sleep(2000);
		System.out.println(CommonMethod.getText(objectLocater));
		testlog.info("Message captured : " + CommonMethod.getText(objectLocater));
		Assert.assertTrue(getText(objectLocater).contains(expected), message);
	}

	public static void assertActualContainsExpected(String Actual, String expected) throws IOException {

		Assert.assertTrue(Actual.contains(expected), "Did not match --- Actual : "+Actual+ " Expected : "+expected);
	}

	public static void assertExpectedContainsActual(String Actual, String expected, String message) throws IOException {

		Assert.assertTrue(expected.contains(Actual), message);
	}

	public static void assertstringcontainsmessage(String actual, String expected, String message) throws IOException {

		Assert.assertTrue(actual.contains(expected), message);
	}

	public static void assertcontainsattributevalue(String objectLocator, String expected, String message)
			throws IOException {

		System.out.println((findElement(objectLocator)).getAttribute("value"));
		Assert.assertTrue((findElement(objectLocator)).getAttribute("value").contains(expected), message);
	}

	public static void assertisElementPresentTrue(String objectLocator, String message) throws IOException {

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean boo = findElements(objectLocator).size() > 0;
		System.out.println(boo);
		Assert.assertTrue(boo, message);

	}

	public static void assertisElementPresentTrueHandled(String objectLocator, String message, String SheetName)
			throws IOException {
		try {
			// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			boolean boo = findElements(objectLocator).size() > 0;
			System.out.println(boo);
			Assert.assertTrue(boo, message);
			//data.setCellData(SheetName, "Status", rownumber, "PASS");
		} catch (AssertionError err) {
			testlog.fail(err.toString());
			captureScreenshot();
			System.out.println("Inside Catch 3");
			//data.setCellData(SheetName, "Status", rownumber, "FAIL");
			/*
			 * switchToParentTab(); testlog.info("Switching back to parent tab");
			 */
		}
	}

	public static void assertisElementPresentTrueHandled(String objectLocator, String message, String SheetName,
			int rowNum) throws IOException {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			boolean boo = findElements(objectLocator).size() > 0;
			System.out.println(boo);
			Assert.assertTrue(boo, message);
			//data.setCellData(SheetName, "Status", rowNum, "PASS");
		} catch (AssertionError err) {
			testlog.fail(err.toString());
			//captureScreenshotGeneric(rowNum);
			System.out.println("Inside Catch 3");
			//data.setCellData(SheetName, "Status", rowNum, "FAIL");
			/*
			 * switchToParentTab(); testlog.info("Switching back to parent tab");
			 */
		}
	}

	public static void assertisElementPresentTrue(String objectLocator, String message, int time) throws IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		boolean boo = findElements(objectLocator).size() > 0;
		System.out.println(boo);
		Assert.assertTrue(boo, message);

	}

	public static boolean IsElementPresentTrue(String objectLocator) throws IOException {

		boolean boo = (findElement(objectLocator) != null);
		System.out.println(boo);
		return boo;

	}

	public static boolean isElementsExist(String objectLocator, int TimeInSec) throws IOException {
		boolean boo;
		long startTime = System.currentTimeMillis();
		long endTime = TimeInSec*1000;
		do {
		 boo = findElementsCustom(objectLocator).size() > 0;
		System.out.println(boo);
		}while(!(boo || !((System.currentTimeMillis()-startTime)<endTime)));
		return boo;
		
	}
	

	public static boolean isElementsExistRaw(String xpath, int TimeInSec) throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeInSec));
		boolean boo = driver.findElements(By.xpath(xpath)).size() > 0;
		System.out.println(boo);
		return boo;
	}

	public static void assertisElementPresentFalse(String objectLocator, String message) throws IOException {

		boolean boo = findElements(objectLocator).size() > 0;
		System.out.println(boo);
		Assert.assertFalse(boo, message);

	}

	public static void ListDropdownValues(String objectLocator) throws IOException, InterruptedException {

		Select se = new Select(findElement(objectLocator));
		List<WebElement> ele = se.getOptions();
		for (WebElement list : ele) {
			// System.out.println(list.getText());
			testlog.info("Rating System available : " + list.getText());
		}

	}

	public static void selectdropdownrandom(String objectLocator) throws IOException, InterruptedException {

		Select se = new Select(findElement(objectLocator));
		List<WebElement> ele = se.getOptions();
		int n = new Random().nextInt(ele.size());
		if (n == 0) {
			n = n + 1;
		}

		se.selectByIndex(n);
		Thread.sleep(2000);
		WebElement option = se.getFirstSelectedOption();
		System.out.println(option.getText());

	}

	public static void selectdropdownrandomCondition(String objectLocator, String Value)
			throws IOException, InterruptedException {

		Select se = new Select(findElement(objectLocator));
		List<WebElement> ele = se.getOptions();
		int n = new Random().nextInt(ele.size());
		if (n == 0) {
			n = n + 1;
		}

		se.selectByIndex(n);
		Thread.sleep(2000);
		WebElement option = se.getFirstSelectedOption();
		System.out.println(option.getText());

		if (option.getText().contains(Value)) {
			selectdropdownrandomCondition(objectLocator, Value);
		}
	}

	public static int getdropdownSize(String objectLocator) throws IOException, InterruptedException {

		Select se = new Select(findElement(objectLocator));
		List<WebElement> ele = se.getOptions();
		return ele.size();
	}

	public static void selectdropdownVisibletext(String objectLocator, String text) throws IOException {

		Select se = new Select(findElement(objectLocator));
		se.selectByVisibleText(text);

	}
	
	public static void selectdropdownValue(String objectLocator, String value) throws IOException {

		Select se = new Select(findElement(objectLocator));
		se.selectByValue(value);

	}

	public static void selectdropdownIndex(String objectLocator, int value) throws IOException {

		Select se = new Select(findElement(objectLocator));
		se.selectByIndex(value);

	}

	public static void selectdropdownWebelement(WebElement objectLocator, String value) throws IOException {

		Select se = new Select(objectLocator);
		se.selectByVisibleText(value);

	}
	
	public static void selectdropdownWebelementByValue(WebElement objectLocator, String value) throws IOException {

		Select se = new Select(objectLocator);
		se.selectByValue(value);

	}

	public static String getSelectedDropdownValue(String objectLocator) throws IOException {

		Select select = new Select(findElement(objectLocator));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		return defaultItem;

	}

	public static String getSelectedDropdownAttribute(String objectLocator) throws IOException {

		Select select = new Select(findElement(objectLocator));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getAttribute("value");
		return defaultItem;

	}

	public static void verifySelectedDropdownValue(String objectLocator, String value) throws IOException {

		Select select = new Select(findElement(objectLocator));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();

		Assert.assertEquals(defaultItem, value, "Dropdown selected value is not correct");

	}

	public static void switchToParentFrame() {

		driver.switchTo().parentFrame();
	}

	public static void switchToDefaultContent() {

		driver.switchTo().parentFrame();
	}

	public static void switchToFrame(String objectLocator) throws IOException {

		driver.switchTo().frame(CommonMethod.findElement(objectLocator));
	}

	public static void ClickRandomWebElement(String objectLocator) throws IOException {

		List<WebElement> options = CommonMethod.findElements(objectLocator);
		Random random = new Random();
		int index = random.nextInt(options.size());
		// options.get(index).click();
		scrolldowntoElement(options.get(index));
		WaitUntilClickble(objectLocator, 10);
		if (!CommonMethod.isSelected(options.get(index))) {
			options.get(index).click();
		}
	}

	public static void ClickRandomWebElementWithIterationCount(String objectLocator, int NumberOfTimes)
			throws IOException {

		List<WebElement> options = CommonMethod.findElements(objectLocator);
		for (int i = 0; i <= NumberOfTimes; i++) {
			System.out.println(NumberOfTimes);
			Random random = new Random();
			int index = random.nextInt(options.size());
			// options.get(index).click();
			scrolldowntoElement(options.get(index));
			WaitUntilClickble(objectLocator, 10);
			if (!CommonMethod.isSelected(options.get(index)) && !CommonMethod.isEnabled(options.get(index))) {
				options.get(index).click();
			} else {
				NumberOfTimes = NumberOfTimes + 1;
			}
		}
	}

	// Is displayed Method (Assertion)
	public static void Isdisplayed(String objectLocater, String message) throws IOException {

		Assert.assertTrue(findElement(objectLocater).isDisplayed(), message);

	}
	public static boolean Isdisplayed(String objectLocater, int Timeout) throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeout));
		Boolean boo = null;
		try {
			boo = findElement(objectLocater).isDisplayed();
			System.out.println(boo);

		}

		catch (Exception e) {
			System.out.println("Not displayed");
		}
		return boo;

	}

	public static void IsEnabled(String objectLocater, String message) throws IOException {

		Assert.assertTrue(findElement(objectLocater).isEnabled(), message);

	}

	public static boolean IsEnabled(String objectLocater) throws IOException {

		Boolean boo = findElement(objectLocater).isEnabled();
		System.out.println(boo);
		return boo;

	}

	public static boolean IsDimensionOK(String objectLocater) throws IOException {

		Dimension d = findElement(objectLocater).getSize();
		boolean isVisible = (d.getHeight() > 0 && d.getWidth() > 0);
		System.out.println(isVisible);
		return isVisible;

	}

	public static void assertcontentPageSource(String expectedtext, String message) {

		Assert.assertTrue(driver.getPageSource().contains(expectedtext), message);

	}

	public static void assertcontentPageSourceFalse(String expectedtext, String message) {

		Assert.assertFalse(driver.getPageSource().contains(expectedtext), message);

	}

	public static void assertcontainshandledPageSource(String expectedtext, String message) {
		try {

			Assert.assertTrue(driver.getPageSource().contains(expectedtext), message);
		} catch (AssertionError err) {
			testlog.fail(err.toString());
			System.out.println("Verification Failed");

			/*
			 * switchToParentTab(); testlog.info("Switching back to parent tab");
			 */
		}
	}

	public static void assertcontentPageSource(String expectedtext, String message, String SheetName) {
		try {

			Assert.assertTrue(driver.getPageSource().toLowerCase().contains(expectedtext.toLowerCase()), message);
		} catch (AssertionError err) {
			testlog.fail(err.toString());
			System.out.println("Inside Catch 2");
			//data.setCellData(SheetName, "Status", rownumber, "FAIL");
			/*
			 * switchToParentTab(); testlog.info("Switching back to parent tab");
			 */
		}
	}

	/*
	 * public static void assertFalse(Boolean boo, String message, String SheetName,
	 * String CreditName, String URL) { try {
	 * 
	 * System.out.println("Current RatingSystem : " + TestNGTestName);
	 * Assert.assertFalse(boo, message); System.out.println("Current Rownumber : " +
	 * rownumber); data.setCellData(SheetName, "RatingSystem", rownumber,
	 * TestNGTestName); data.setCellData(SheetName, "CreditName", rownumber,
	 * CreditName); data.setCellData(SheetName, "RedirectedCreditLink", rownumber,
	 * URL); data.setCellData(SheetName, "URLStatus", rownumber, "PASS"); } catch
	 * (AssertionError err) { testlog.fail(err.toString());
	 * System.out.println("Inside Catch 1"); System.out.println("Fail Rownumber : "
	 * + rownumber); data.setCellData(SheetName, "RatingSystem", rownumber,
	 * TestNGTestName); data.setCellData(SheetName, "CreditName", rownumber,
	 * CreditName); data.setCellData(SheetName, "RedirectedCreditLink", rownumber,
	 * URL); data.setCellData(SheetName, "URLStatus", rownumber, "URLBroken");
	 * 
	 * } }
	 */
	public static void verifycontentPageSource(String expectedtext, String message) {
		try {
			Verify.verify(driver.getPageSource().contains(expectedtext), message);
		} catch (Exception e) {
			System.out.println("Verification Failed");
			testlog.fail(e.toString());
		}
	}

	public static boolean verifycontentPageSource(String expectedtext) {

		Boolean boo = driver.getPageSource().contains(expectedtext);
		return boo;

	}

	public static void verifycontentPageSource(String[] expectedtext) {
		int i = 1;
		for (String str : expectedtext) {
			try {

				Verify.verify(driver.getPageSource().contains(str), str + "  doesn't exist on page");
			}

			catch (Exception e) {
				System.out.println(i);
				i = i + 1;
				testlog.fail(e.toString());
			}
		}
	}

	public static void assertcurrentUrl(String expectedUrl, String message) {
		System.out.println(driver.getCurrentUrl());
		System.out.println(expectedUrl);
		Assert.assertTrue(driver.getCurrentUrl().equals(expectedUrl), message);

	}

	public static void CheckExternalLink(String objectLink, String expectedUrl, String message)
			throws IOException, InterruptedException {

		moveToElement(objectLink);
		Thread.sleep(1000);
		click(objectLink);
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, message);

	}

	public static void CheckExternalLinkMiddleElements(String objectLink, String expectedUrl, String message)
			throws IOException, InterruptedException {

		scrolldowntoElement(objectLink);
		scrollUp();
		click(objectLink);
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, message);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);

	}

	public static void CheckExternalLinkNewTab(String objectLink, String expectedUrl, String message)
			throws IOException, InterruptedException {

		moveToElement(objectLink);
		Thread.sleep(1000);
		click(objectLink);
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, message);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);

	}

	public static void SwichToNewWindow() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
	}

	public static void switchToParentWindow() {
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());

		for (String handle : windows) {
			if (!handle.equals(windows.get(0))) {

				driver.close();
			}
		}

		driver.switchTo().window(windows.get(0));
	}

	public static void JavascriptClickElement(String Objectlocator) throws IOException {
		WebElement ele = findElement(Objectlocator);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", Objectlocator);
	}

	public static void JavascriptRemoveWebElement() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("return document.getElementsByTagName('h2').remove();");
	}
	
	public static void JavascriptRemoveWebElementByClassName() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("return document.getElementsByClassName('ml-64 pr-72 shadow bg-white fixed z-10 left-0 mt-16 top-0 w-full py-4 px-11')[0].remove();");
	}

	public static void scrolldowntoLast() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollUp() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 0)", "");
	}

	public static void scrollDown() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,1500)", "");
	}

	//

	public static void scrolldowntoElement(String objectLocater) throws IOException {

		//scrolldowntoLast();

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", findElement(objectLocater));
	}

	public static void scrolldowntoElement(WebElement objectLocater) throws IOException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", objectLocater);
	}

	public static String FileNameDownloaded(String downloadPath, int Time) throws InterruptedException {
		Thread.sleep(Time);
		String Filename = null;
		File file = new File(downloadPath);
		String[] fileList = file.list();
		for (String name : fileList) {
			System.out.println("Downloaded File name : " + name);
			Filename = name;
		}
		return Filename;
	}

	public static boolean isFileExists(String downloadPath) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].exists())
				return flag = true;
		}

		return flag;
	}

	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	public static boolean isFileDownloaded1(String downloadPath, String fileName) throws InterruptedException {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();
		System.out.println(dir_contents.length);

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().contains(fileName)) {
				File file = dir_contents[i];
				long lastModified;

				while (true) {
					lastModified = file.lastModified();
					System.out.println(lastModified);
					Thread.sleep(120000);
					System.out.println(file.lastModified());
					if (file.lastModified() == 0)
						Thread.sleep(10000);
					break;
				}

				/*
				 * lastModified = file.lastModified(); latestModified = file.lastModified();
				 * System.out.println(lastModified); System.out.println(latestModified); while
				 * (latestModified == lastModified) {
				 * 
				 * Thread.sleep(3000); latestModified = file.lastModified();
				 * System.out.println(lastModified); System.out.println(latestModified); if
				 * (lastModified != latestModified) Thread.sleep(20000); break;
				 * 
				 * }
				 */
				return flag = true;

			}

		}

		return flag;
	}

	public static int FileCountInsideZip(String FileName) {
		int numberOfEntries = 0;
		try {
			int count = 0;
			ZipFile zipFile = new ZipFile(downloadPath + File.separator + FileName);
			System.out.println(zipFile);

			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				System.out.println(entry.getName());
				if (!entry.isDirectory()) {
					count = count + 1;
				}

			}

			numberOfEntries = count;

			System.out.println("There are ");
			System.out.print(numberOfEntries);
			System.out.print(" entries in zip file :");
			System.out.print(zipFile.getName());

			zipFile.close();

		}

		catch (Exception e) {
			System.out.println("Error opening zip file" + e.getMessage());
		}
		return numberOfEntries;
	}

	public static void IsFilePresentInsideZip() throws IOException {
		int numberOfEntries = 0;
		File f = new File(downloadPath); // use here your file directory path
		String[] allFiles = f.list();
		for (String Files : allFiles) {

			int count = 0;
			ZipFile zipFile = new ZipFile(
					downloadPath + File.separator + "1000005741-Design_and_Construction_Preliminary_Review.zip");
			System.out.println(zipFile);

			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				System.out.println(entry.getName());

				if (entry.isDirectory()) {

					File dir = new File(entry.getName());
					File[] dir_contents = dir.listFiles();
					if (dir_contents != null) {
						System.out.println("HIIIII");
						for (int i = 0; i < dir_contents.length; i++) {
							if (dir_contents[i].getName().contains("CreditForm1.pdf")) {
								Assert.assertTrue(true);
							} else {
								Assert.fail("No credit form found");
							}
						}
					}
				}

				if (!entry.isDirectory()) {
					count = count + 1;

				}
			}
			numberOfEntries = count;

			System.out.println("There are ");
			System.out.print(numberOfEntries);
			System.out.print(" entries in zip file :");
			System.out.print(zipFile.getName());

			zipFile.close();
		}
	}

	public static void VerifyDownloadWithFileName(String filename) throws InterruptedException {

		Assert.assertTrue(isFileDownloaded(downloadPath, filename), "Failed to download Expected document");
	}

	public static void VerifyFileDownloadWithExtension(String filename, String extension) throws InterruptedException {

		Assert.assertTrue(isFileDownloaded(downloadPath, filename), "Failed to download Expected document");
	}

	public static String extractPDFContent(String PDFFile) throws IOException {

		PdfReader reader = new PdfReader(PDFFile);
		StringBuffer sb = new StringBuffer();
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		TextExtractionStrategy strategy;
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
			sb.append(strategy.getResultantText());
		}
		reader.close();
		return sb.toString();

	}

	public static String setDateFormat(String Dateformat) {

		Format formatter = new SimpleDateFormat(Dateformat);
		String date = formatter.format(new Date());
		return date;
	}

	public static String setDateFormatFuture(String Dateformat, int FutureDays) {

		Format formatter = new SimpleDateFormat(Dateformat);
		formatter.format(new Date());
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, FutureDays);
		String newDate = formatter.format(c.getTime());
		return newDate;
	}

	public static List<String> fetchTableData(String objectLocator) throws IOException {

		List<String> value = new ArrayList<String>();

		WebElement table = (findElement(objectLocator));

		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.println("content >>   " + cell.getText());
				//testlog.info("content >>   " + cell.getText());
				value.add(cell.getText());
			}
		}
		return value;

	}

	public static List<String> fetchTableHeaders(String objectLocator) throws IOException {

		List<String> value = new ArrayList<String>();

		WebElement table = (findElement(objectLocator));

		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("th"));
			for (WebElement cell : cells) {
				System.out.println("content >>   " + cell.getText());
				value.add(cell.getText());
			}
		}
		return value;

	}

	public static String takeScreenshot(String methodname) throws IOException {
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			String Dest = screenshotfile + methodname + ".png";
			File Destination = new File(Dest);
			FileUtils.copyFile(Source, Destination);
			return Dest;
		}

		catch (Exception e) {

			System.out.println("Exception Taking screenshot" + e.getMessage());
			return e.getMessage();
		}

	}

	public static String randomNumber() throws IOException, InterruptedException {

		int random_num = 1;
		Random t = new Random();

		// random integers in [1000, 800000]
		random_num = (t.nextInt(800000));
		ProgramID = String.valueOf(random_num);

		System.out.println(ProgramID);
		Thread.sleep(1000);
		return ProgramID;

	}

	public static String randomNumber(int lastnumber) throws IOException, InterruptedException {

		int random_num = 1;
		Random t = new Random();

		int lowest = 1000;
		random_num = (t.nextInt(lastnumber - lowest) + lowest);
		ProgramID = String.valueOf(random_num);

		return ProgramID;

	}

	public static String randomNumberBetweenRanges(int firstNum, int LastNum) throws IOException, InterruptedException {

		Random r = new Random();
		int low = firstNum;
		int high = LastNum;
		int result = r.nextInt(high - low) + low;
		ProgramID = String.valueOf(result);

		return ProgramID;

	}

	public static String removeSpecialCharFromNumber(String str) throws IOException, InterruptedException {

		ProgramID = str.replaceAll("[-+.^:,]", "");

		return ProgramID;

	}

	public static String randomnumberBNone(String Url) throws IOException, InterruptedException {

		int random_num = 1;
		Random t = new Random();

		// random integers in [1000, 800000]
		random_num = (t.nextInt(800000));
		ProgramID = String.valueOf(random_num);

		System.out.println(ProgramID);
		Thread.sleep(1000);

		File file = new File(Url);

		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("BuildingNone" + " " + ProgramID);
		bw.close();
		return ProgramID;

	}

	public static String randomnumber(String Url) throws IOException, InterruptedException {

		int random_num = 1;
		Random t = new Random();

		// random integers in [1000, 800000]
		random_num = (t.nextInt(800000));
		ProgramID = String.valueOf(random_num);

		System.out.println(ProgramID);
		Thread.sleep(1000);

		File file = new File(Url);

		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("MachineTestProject" + " " + ProgramID);
		bw.close();
		return ProgramID;

	}

	public static String filereadID(String url) throws IOException {

		FileReader inputFile = new FileReader(url);

		// Instantiate the BufferedReader Class
		BufferedReader bufferReader = new BufferedReader(inputFile);

		// Variable to hold the one line data

		String text;
		// Read file line by line and print on the console
		while ((text = bufferReader.readLine()) != null) {

			fetchedID = text;
			// System.out.println(CommonMethod.ProgramID);

		}

		// Close the buffer reader
		bufferReader.close();
		return fetchedID;
	}

	
	public static void waitForPageLoaded() throws IOException {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
			wait.until(expectation);
		} catch (Exception e) {
			System.out.println("Timeout waiting for Page Load Request to complete.");
			
		}
	}
	 
	
	


	public static WebElement WaitUntilPresence(String objectlocator, int TimeinSeconds) throws IOException {
		JSWaiter.waitAllRequest();
		waitForPageLoaded();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);

		String objecttypeandvalues = OR.getProperty(objectlocator);

		System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);
		switch (objecttype) {

		case "id":

			return (wait.until(ExpectedConditions.presenceOfElementLocated(By.id(objectvalue))));

		case "xpath":

			return (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectvalue))));

		case "name":

			return (wait.until(ExpectedConditions.presenceOfElementLocated(By.name(objectvalue))));

		case "class":

			return (wait.until(ExpectedConditions.presenceOfElementLocated(By.className(objectvalue))));

		case "tagname":

			return (wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(objectvalue))));

		case "css":

			return (wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(objectvalue))));

		case "linkText":

			return (wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(objectvalue))));
		default:

			return null;
		}
		// By css = findElement(objectlocator);

	}

	public static Boolean WaitUntilStaleness(WebElement objectlocator, int TimeinSeconds) throws IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
		return wait.until(ExpectedConditions.stalenessOf(objectlocator));

	}

	/***** Added on Nov 27 11.30 AM *****/
	public static Boolean WaitUntilInVisibility(String objectlocator, int TimeinSeconds) throws IOException {
		JSWaiter.waitAllRequest();
		waitForPageLoaded();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);

		String objecttypeandvalues = OR.getProperty(objectlocator);

		System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);
		switch (objecttype) {

		case "id":

			return (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(objectvalue))));

		case "xpath":

			return (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(objectvalue))));

		case "name":

			return (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(objectvalue))));

		case "class":

			return (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(objectvalue))));

		case "tagname":

			return (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(objectvalue))));

		case "css":

			return (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(objectvalue))));

		case "linkText":

			return (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(objectvalue))));
		default:

			return null;
		}

	}

	public static WebElement WaitUntilVisibility(String objectlocator, int TimeinSeconds) throws IOException {
		JSWaiter.waitAllRequest();
		waitForPageLoaded();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);

		String objecttypeandvalues = OR.getProperty(objectlocator);

		System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);
		switch (objecttype) {

		case "id":

			return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(objectvalue))));

		case "xpath":

			return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectvalue))));

		case "name":

			return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(objectvalue))));

		case "class":

			return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(objectvalue))));

		case "tagname":

			return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(objectvalue))));

		case "css":

			return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(objectvalue))));

		case "linkText":

			return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(objectvalue))));
		default:

			return null;
		}
		// By css = findElement(objectlocator);
		
	}

	public static WebElement WaitUntilClickble(String objectlocator, int TimeinSeconds) throws IOException {
		
		JSWaiter.waitAllRequest();
		waitForPageLoaded();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);

		String objecttypeandvalues = OR.getProperty(objectlocator);

		System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);
		switch (objecttype) {

		case "id":

			return (wait.until(ExpectedConditions.elementToBeClickable(By.id(objectvalue))));

		case "xpath":

			return (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectvalue))));

		case "name":

			return (wait.until(ExpectedConditions.elementToBeClickable(By.name(objectvalue))));

		case "class":

			return (wait.until(ExpectedConditions.elementToBeClickable(By.className(objectvalue))));

		case "tagname":

			return (wait.until(ExpectedConditions.elementToBeClickable(By.tagName(objectvalue))));

		case "css":

			return (wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(objectvalue))));

		case "linkText":

			return (wait.until(ExpectedConditions.elementToBeClickable(By.linkText(objectvalue))));
		default:

			return null;
		}
		// By css = findElement(objectlocator);

	}
public static  List<WebElement> WaitUntilNumberOfElementToBePresent(String objectlocator,int Number, int TimeinSeconds) throws IOException {
		
		JSWaiter.waitAllRequest();
		waitForPageLoaded();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);

		String objecttypeandvalues = OR.getProperty(objectlocator);

		System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);
		switch (objecttype) {

		case "id":

			return (wait.until(ExpectedConditions.numberOfElementsToBe(By.id(objectvalue),Number)));

		case "xpath":

			return (wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(objectvalue),Number)));

		case "name":

			return (wait.until(ExpectedConditions.numberOfElementsToBe(By.name(objectvalue),Number)));

		case "class":

			return (wait.until(ExpectedConditions.numberOfElementsToBe(By.className(objectvalue),Number)));

		case "tagname":

			return (wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName(objectvalue),Number)));

		case "css":

			return (wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(objectvalue),Number)));

		case "linkText":

			return (wait.until(ExpectedConditions.numberOfElementsToBe(By.linkText(objectvalue),Number)));
		default:

			return null;
		}
		// By css = findElement(objectlocator);

	}
	
	public static WebElement WaitUntilClickble(WebElement objectlocator, int TimeinSeconds) throws IOException {
		JSWaiter.waitAllRequest();
		waitForPageLoaded();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
		
			return (wait.until(ExpectedConditions.elementToBeClickable(objectlocator)));
			
	}

	public static void displayhiddenElement(String objectLocator) throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", findElement(objectLocator));
	}

	public static void hideElement(String objectLocator) throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'display:none')", findElement(objectLocator));
	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void removeReadOnly(String id) {

		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('" + id + "').removeAttribute('readonly',0);");

	}

	public static WebDriverWait waitSec(WebDriver driver, int sec) {
		return new WebDriverWait(driver, Duration.ofSeconds(sec));
	}

	public static File waitToDownloadFile(WebDriver driver, int sec, String fileName) {
		String filePath = downloadPath + fileName;
		waitSec(driver, 30).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				if (Files.exists(Paths.get(filePath))) {
					System.out.println("Downloading " + filePath + " finished.");
					return true;
				} else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Downloading " + filePath + " not finished yet.");
					}
				}
				return false;
			}
		});
		File downloadedFile = new File(filePath);
		return downloadedFile;
	}

	public static String getDownloadedDocumentName(String fileExtension) {
		String downloadedFileName = null;
		boolean valid = true;
		boolean found = false;

		// default timeout in seconds
		long timeOut = 300;
		try {
			Path downloadFolderPath = Paths.get(downloadPath);
			WatchService watchService = FileSystems.getDefault().newWatchService();
			downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			long startTime = System.currentTimeMillis();
			do {
				WatchKey watchKey;
				watchKey = watchService.poll(timeOut, TimeUnit.SECONDS);
				long currentTime = (System.currentTimeMillis() - startTime) / 1000;
				if (currentTime > timeOut) {
					System.out.println("Download operation timed out.. Expected file was not downloaded");
					return downloadedFileName;
				}

				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
						String fileName = event.context().toString();
						System.out.println("New File Created:" + fileName);
						if (fileName.endsWith(fileExtension) && fileName.length() > 10) {
							downloadedFileName = fileName;
							System.out.println(
									"Downloaded file found with extension " + fileExtension + ". File name is " +

											fileName);
							Thread.sleep(500);
							found = true;
							break;
						}
					}
				}
				if (found) {
					return downloadedFileName;
				} else {
					currentTime = (System.currentTimeMillis() - startTime) / 1000;
					if (currentTime > timeOut) {
						System.out.println("Failed to download expected file");
						return downloadedFileName;
					}
					valid = watchKey.reset();
				}
			} while (valid);
		}

		catch (InterruptedException e) {
			System.out.println("Interrupted error - " + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Download operation timed out.. Expected file was not downloaded");
		} catch (Exception e) {
			System.out.println("Error occured - " + e.getMessage());
			e.printStackTrace();
		}
		return downloadedFileName;
	}

	public static String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdeghijklmnopqrstuvxyz";

		// String SpCharString = "Here are a few other common escape codes: for double
		// quotation marks, © for the copyright symbol, ® for the registered ` trademark
		// ~ symbol, ¢ for the cent sign, ° for the degree sign, ¶ for the paragraph
		// symbol, and ÷ for the division 6:9 symbol.Remember that $ (browsers ignore)
		// extra spaces in your HTML. You've learned how to use the @formatted # text
		// tag ^ pair to get around this, but that can be $cumbersome if you want just
		// an extra space or two. In these cases, use the escape character for a
		// non-breaking space. To create an extra space in your HTML, type";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		// sb.append(SpCharString);
		return sb.toString();
	}

	public static void clear(WebElement objectLocater) throws IOException {
		objectLocater.clear();

	}

	public static void sendKeys(WebElement objectLocater, String value) throws IOException {
		objectLocater.sendKeys(value);
	}

	public static String randomNumber1To99() {
		int max = 100;
		int min = 1;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		String number = String.valueOf(randomNum);
		return number;
	}

	public static boolean Isdisplayed(WebElement objectLocater) throws IOException {

		Boolean boo = objectLocater.isDisplayed();
		return boo;

	}

	public static boolean Isdisplayed(String objectLocater) throws IOException {

		Boolean boo = findElement(objectLocater).isDisplayed();
		return boo;

	}

	public static void selectdropdownbyIndex(WebElement objectLocator, int index) throws IOException {
		Select se = new Select(objectLocator);
		List<WebElement> ele = se.getOptions();
		System.out.println(ele.size());
		if (ele.size() > 1) {
			se.selectByIndex(index);
		} else {
			se.selectByIndex(0);
		}

	}

	public static String getSelectedDropdownValue(WebElement objectLocator) throws IOException {

		Select select = new Select(objectLocator);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		return defaultItem;

	}

	public static void assertisElementPresentFalse(String objectLocator, String message, int TimeInSec)
			throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeInSec));
		boolean boo = findElements(objectLocator).size() > 0;
		System.out.println(boo);
		Assert.assertFalse(boo, message);

	}
	public static int ElementSize(String objectLocator) throws IOException {
		 int size = findElements(objectLocator).size();
		return size;
	}
	
	public static String getCurrentDateTime() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy:HH.mm.ss");
		return formatter.format(currentDate.getTime());
	}
	
	public static WebElement SelectRandomfromList(String objectLocator, int Startindex, int Endindex) throws IOException, NumberFormatException, InterruptedException {
		int index = Integer.parseInt(randomNumberBetweenRanges(Startindex, Endindex));
		List<WebElement> ele = CommonMethod.findElements(objectLocator);
		return ele.get(index);
	}
	public static void clearAndSendKey(String objectLocator, String value) throws IOException {

		findElement(objectLocator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
		System.out.println("Clear the input and updated the value");
	}
	public static boolean verifyTextPresentInElement(String Actual, String expected, String message)
			throws Exception {
		boolean flag = false;
		if (Actual.contains(expected)) {
			Assert.assertTrue(Actual.contains(expected), message);
			testlog.info(message);
			System.out.println("matched");
			flag = true;	
		}
		else {
		testlog.fail("Did not match --- Actual : "+Actual+ " Expected : "+expected);
		System.out.println("Not matching");
	}
		return flag;
	}
	
	public static void clickListWebelementFromIndex(String ObjectLocator, int Index) throws IOException, InterruptedException {
		List<WebElement> ele;
		WebElement ele1;
		ele = CommonMethod.findElements(ObjectLocator);
		ele1 = ele.get(Index);
		do {
			CommonMethod.WaitUntilClickble(ele1, 60);
			click(ele1);
			Thread.sleep(2000);
		} while (!CommonMethod.isSelected(ele1));


	}
	public static void clickOnListWebelementFromIndex(String ObjectLocator, int Index) throws IOException, InterruptedException {
		List<WebElement> ele;
		WebElement ele1;
		ele = CommonMethod.findElements(ObjectLocator);
		ele1 = ele.get(Index);
		CommonMethod.WaitUntilClickble(ele1, 60);
		click(ele1);
	}
	
	public static void declickListWebelementFromIndex(String ObjectLocator, int Index) throws IOException, InterruptedException {
		List<WebElement> ele;
		WebElement ele1;
		ele = CommonMethod.findElements(ObjectLocator);
		ele1 = ele.get(Index);
		do {
			CommonMethod.WaitUntilClickble(ele1, 60);
			click(ele1);
			Thread.sleep(2000);
		} while (CommonMethod.isSelected(ele1));


	}
	
	
	public static void clickListWebelementFromRange(String ObjectLocator, int Start,int End) throws IOException, InterruptedException {
		List<WebElement> ele;
		//WebElement ele1;
		ele = CommonMethod.findElements(ObjectLocator);
		ele = ele.subList(Start, End);
		for(WebElement ele1:ele) {
		do {
			CommonMethod.WaitUntilClickble(ele1, 60);
			click(ele1);
			Thread.sleep(2000);
		} while (!CommonMethod.isSelected(ele1));

		}

	}
	
	public static void assertcountListWebelementFromIndex(String ObjectLocator, int Count) throws IOException {
		List<WebElement> ele;
		
		ele = CommonMethod.findElements(ObjectLocator);
		System.out.println("Actual: "+ele.size()+" " +"Expected: "+Count);
		softAssert.assertEquals(ele.size(), Count,"Count Validation failed");
		
	}
	
	/*
	 * public static void clearDriverCache() { ((HasDevTools)
	 * driver).getDevTools().createSessionIfThereIsNotOne(); ((HasDevTools)
	 * driver).getDevTools().send(Network.clearBrowserCookies()); // you could also
	 * use ((HasDevTools) driver).getDevTools().send(Network.clearBrowserCache()); }
	 */


public static void JavascriptClickElement(WebElement Objectlocator) throws IOException {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", Objectlocator);
}
}