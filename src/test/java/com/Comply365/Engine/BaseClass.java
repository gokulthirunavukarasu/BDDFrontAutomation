package com.Comply365.Engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import  javax . imageio . ImageIO ;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class BaseClass {

	public static String Environment;
	public static WebDriver driver;
	public static XlsReader data;
	public static int timeout=60;
	public static ExtentTest testlog;
	public static ExtentReports extent;
	public static String TestCaseName;
	public static String TestNGTestName;
	public static String SecurityAssesment;
	private ClientApi api;
	private ApiResponse response;
	static final String ZAP_PROXY_ADDRESS = "localhost";
	static final int ZAP_PROXY_PORT = 8091;
	public static SoftAssert softAssert = new SoftAssert();
	public static SoftAssert negativesoftAssert = new SoftAssert();
	public static String SamplePdffile = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"Resume.pdf";
	public static Faker USfaker = new Faker(new Locale("en-US"));
	public static String downloadPath = System.getProperty("user.dir") +File.separator +"Downloads"+File.separator;
	public static String reportPath = System.getProperty("user.dir") +File.separator +"Reports"+File.separator;
	//public static ReusableMethodsLogin login = new ReusableMethodsLogin();
	 
	public String browserName() throws IOException{
		
		Properties prop = new Properties();
		prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Environment.properties");
		prop.load(file);
		String browserName=prop.getProperty("browserName");
		return browserName;
	}
	
    public String environment() throws IOException{
    	Properties prop = new Properties();
		prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Environment.properties");
		prop.load(file);
		String environment=prop.getProperty("environment");
			return environment;
	}

	@BeforeMethod
	public void setup() throws InterruptedException, IOException, ClientApiException {
		data= new XlsReader(System.getProperty("user.dir")+"/TestData.xlsx");
		System.out.println("StartTest");
		System.out.println("browserName: "+browserName());
		if (browserName().equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browserName().equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory",  downloadPath);
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("safebrowsing.enabled", "false");
			//options.addArguments("--incognito");
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("disable-infobars");	           
			 options.addArguments("--disable-notifications");
			 options.setExperimentalOption("useAutomationExtension", false);
			 //options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			 options.addArguments("--window-size=1920,1280");
			 options.addArguments("--window-position=0,0");
			 options.addArguments("--disable-web-security");
			options.setHeadless(false);
			driver = new ChromeDriver(options);
	        JSWaiter.setDriver(driver);
	        api = new ClientApi(ZAP_PROXY_ADDRESS,ZAP_PROXY_PORT);
	        
		}
		
		
		//DevTools chromeDevTools = ((HasDevTools) driver).getDevTools();
	    //chromeDevTools.createSession();
		//driver.manage().window().maximize();
		//((HasDevTools) driver).getDevTools().send(Network.clearBrowserCookies());
		//((HasDevTools) driver).getDevTools().send(Network.clearBrowserCache());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(120));
		Properties prop = new Properties();
		prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Environment.properties");
		prop.load(file);
		String qasurl=prop.getProperty("ENV_QAS");
		String stgurl=prop.getProperty("ENV_STAGING");
		String testurl=prop.getProperty("ENV_TEST");
		System.out.println("environment: "+environment());
		if(environment().equalsIgnoreCase("QAS")){
			driver.get(qasurl);
		}
		else if(environment().equalsIgnoreCase("STG")){
			driver.get(stgurl);
		}
		else if(environment().equalsIgnoreCase("TEST")){
			System.out.println("BaseUrl: "+ testurl);
			driver.get(testurl);	
		}
	}
	@BeforeTest(alwaysRun = true)
	public void getTestNGTestName(final ITestContext testContext) {
		TestNGTestName=testContext.getName();
	}
		

	@BeforeMethod(alwaysRun = true)
	public static ExtentReports ExtentReportConfig() throws IOException {
		softAssert = new SoftAssert();
		 if (extent == null) {
			 final File CONF = new File(System.getProperty("user.dir")+"/src/main/resources/Extentconfig.json");
			 extent = new ExtentReports();
			 extent.setSystemInfo("Host Name", "Jenkins");
			 extent.setSystemInfo("Environment", Environment);
			 extent.setSystemInfo("User Name", "Nagesh");
				ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")
						+ "/Report/WELL_AutomationReport" + /* TestNGTestName  +*/ ".html");
			 extent.attachReporter(spark);
			 spark.loadJSONConfig(CONF);
		 
		 
		    }
		    return extent;
		}
	
public void StartTest(String TestcaseName, String Description) {
		
		testlog = extent.createTest(TestcaseName, "This Test is intented to verify -"+Description);
			}

public void logTestFailure() throws IOException, NumberFormatException, InterruptedException {
	
	testlog.log(Status.FAIL,
			MarkupHelper.createLabel(TestCaseName + " - Test Case Failed", ExtentColor.RED));
	/*testlog.log(Status.FAIL,
			MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));*/
	  Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);             

	//File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//BufferedImage img = ImageIO.read(screenshot);
	File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
	int  num = Integer . parseInt ( CommonMethod.randomNumber ( 9999 ) ) ;
	ImageIO.write(screenshot.getImage(), "png", new File(filetest + File.separator + "Screenshots" + File.separator
			+ /* ScreenshotCreditName+ */"_"+num +".png"));
	/*testlog.info("Details of " + "Fail Test screenshot", MediaEntityBuilder
			.createScreenCaptureFromPath(System.getProperty("user.dir") +File.separator +"Screenshots"+File.separator  + TestCaseName +".png")
			.build());*/
}

public static void captureScreenshot() throws IOException {

File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
BufferedImage img = ImageIO.read(screen);
File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
ImageIO.write(img, "png", new File(
		filetest + File.separator + "Screenshots" + File.separator + /* SuiteName+"_"+TestNGTestName+ */".png"));


}


@AfterMethod(alwaysRun = true)
public void getResult(ITestResult result) throws Exception {
	
	if(api != null  && SecurityAssesment.equalsIgnoreCase("true")) {
		
		api.pscan.enableAllScanners();
        response = api.pscan.recordsToScan();
        while(!response.toString().equals("0")) {
        	response = api.pscan.recordsToScan();
        }
        String Title = "ZAP Security Report";
	    String Template = "traditional-html";
	    String Description = "ZAP Security Report";
	    String ReportFileName = "ZAP_report.html";
	    String TargetFolder = System.getProperty("user.dir")+ "/Report";
		
	    response = api.reports.generate(Title, Template, null, Description, null, null, null, null, null, ReportFileName, null, TargetFolder, null);
	System.out.println("ZAP report generated at this location : " + response.toString());
	}

	if (result.getStatus() == ITestResult.FAILURE) {
		testlog.log(Status.FAIL,
				MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		testlog.log(Status.FAIL,
				MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screen);
		File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
		ImageIO.write(img, "png", new File(filetest + File.separator + "Screenshots"
				+ File.separator /* +SuiteName+"_"+TestNGTestName +"-"+*/+TestCaseName +".png"));
		testlog.info("Details of " + "Test screenshot", MediaEntityBuilder
				.createScreenCaptureFromPath("." +System.getProperty("user.dir") + File.separator + "Screenshots"
						+ File.separator + TestCaseName +".png")
				.build());
		
	} else if (result.getStatus() == ITestResult.SKIP) {
		testlog.log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	}
	
}

@AfterClass(alwaysRun = true)
public void flushReport() {
	
	extent.flush();
	System.out.println("EndClass");
	
}

@AfterTest(alwaysRun = true)
public void quit() throws InterruptedException, IOException {
	
	System.out.println("EndTest");
	//logout
	FileUtils.cleanDirectory(new File(downloadPath)); 
}

@AfterSuite(alwaysRun = true)
public void end(){	
	
	System.out.println("EndSuite");
		driver.quit();
		
		
}
	}