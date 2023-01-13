package com.Well.Engine;

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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;
import org.zaproxy.clientapi.gen.Ascan;
import com.Well.ReusableMethods.ReusableMethodCommon;
import com.Well.ReusableMethods.ReusableMethodEquity;
import com.Well.ReusableMethods.ReusableMethodPerformance;
import com.Well.ReusableMethods.ReusableMethodsCustomPortfolio;
import com.Well.ReusableMethods.ReusableMethodsExam;
import com.Well.ReusableMethods.ReusableMethodsFaculty;
import com.Well.ReusableMethods.ReusableMethodsHealthSafety;
import com.Well.ReusableMethods.ReusableMethodsLogin;
import com.Well.ReusableMethods.ReusableMethodsMembership;
import com.Well.ReusableMethods.ReusableMethodsPortfolio;
import com.Well.ReusableMethods.ReusableMethodsV2Project;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class BaseClass {

	public static String Environment;
	public static WebDriver driver;
	public static XlsReader data;
	public static int timeout=60;
	public static int Scorecardtimeout=900;
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
	public static String SamplePdffile1 = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"SampleResume.pdf";
	public static String SampleJpgfile = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"Favicon.jpg";
	public static String AuditfileUpload = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"AuditFile.xlsx";
	public static String PortfolioLocationImportfile = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"portfoliolocations.xlsm";
	public static String FeaturefileUpload = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"FeatureFile.xlsx";
	public static String GeneralfileUpload = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"GeneralFile.xlsx";
	public static String LegalfileUpload = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"LegalFile.xlsx";
	public static String OngoingfileUpload = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"OngoingFile.xlsx";
	public static String ProductInfoFormfileUpload = System.getProperty("user.dir") +File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"Files"+File.separator +"UploadProductInfoForm.xlsx";
	public static Faker USfaker = new Faker(new Locale("en-US"));
	public static String downloadPath = System.getProperty("user.dir") +File.separator +"Downloads"+File.separator;
	public static String BillingReceiptPdffile = System.getProperty("user.dir") +File.separator +"Downloads"+File.separator;
	public static ReusableMethodsLogin login = new ReusableMethodsLogin();
	public static ReusableMethodsPortfolio portfolio = new ReusableMethodsPortfolio();
	public static ReusableMethodsCustomPortfolio pf = new ReusableMethodsCustomPortfolio();
	public static ReusableMethodsV2Project v2project = new ReusableMethodsV2Project();
	public static ReusableMethodsHealthSafety hsr = new ReusableMethodsHealthSafety();
	public static ReusableMethodPerformance performance = new ReusableMethodPerformance();
	public static ReusableMethodsFaculty faculty = new ReusableMethodsFaculty();
	public static ReusableMethodsExam exam = new ReusableMethodsExam();
	public static ReusableMethodsMembership membership = new ReusableMethodsMembership();
	public static ReusableMethodEquity equity = new ReusableMethodEquity();
	public static ReusableMethodCommon rc = new ReusableMethodCommon();

	@BeforeSuite
	@Parameters({ "browserName", "environment","SecurtiyTest" })
	public void setup(String browserName, String environment,@Optional("false") String SecurtiyTest) throws InterruptedException, IOException, ClientApiException {
		
		
		data= new XlsReader(System.getProperty("user.dir")+"/TestData.xlsx");
		Properties prop = new Properties();
		if ((System.getenv("browserName") != null && !System.getenv("browserName").isEmpty())

				&& System.getenv("environment") != null && !System.getenv("environment").isEmpty()) {

			browserName = System.getenv("browserName");
			environment = System.getenv("environment");
			Environment = environment;
			System.out.println(browserName);
			System.out.println(environment);

		}

		else {

			Environment = environment;
		}
		
		

		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("chrome") && SecurtiyTest.equalsIgnoreCase("true")) {
			SecurityAssesment = "true";
			String ProxyServerURL = ZAP_PROXY_ADDRESS +":"+ ZAP_PROXY_PORT;
			Proxy proxy = new Proxy();
			proxy.setAutodetect(false);
			proxy.setHttpProxy(ProxyServerURL);
			proxy.setSslProxy(ProxyServerURL);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--proxy-bypass-list=<-loopback>");
			options.setAcceptInsecureCerts(true);
			options.setProxy(proxy);
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
		
		else if (browserName.equalsIgnoreCase("chrome") && SecurtiyTest.equalsIgnoreCase("false")) {
			SecurityAssesment = "false";
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

		}
		//DevTools chromeDevTools = ((HasDevTools) driver).getDevTools();
	    //chromeDevTools.createSession();
		//driver.manage().window().maximize();
		//((HasDevTools) driver).getDevTools().send(Network.clearBrowserCookies());
		//((HasDevTools) driver).getDevTools().send(Network.clearBrowserCache());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(120));
		

		prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Environment.properties");

		prop.load(file);
		String qasurl=prop.getProperty("ENV_QAS");
		String stgurl=prop.getProperty("ENV_STAGING");
		String testurl=prop.getProperty("ENV_TEST");
		
		
		if(environment.equalsIgnoreCase("QAS")){
			
			driver.get(qasurl);
			
		}
		else if(environment.equalsIgnoreCase("STG")){
			driver.get(stgurl);
			
		}
		else if(environment.equalsIgnoreCase("TEST")){
			do {
			driver.get(testurl);
			//CommonMethod.waitForPageLoaded(120);
			}while(driver.getPageSource().contains("Project Error"));
			
		}
		
		Thread.sleep(2000);
		
		
	
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
			 extent.setSystemInfo("User Name", "Abhishek Gupta");
				ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")
						+ "/Report/WELL_AutomationReport" + /* TestNGTestName  +*/ ".html");
			 extent.attachReporter(spark);
			 spark.loadJSONConfig(CONF);
		 
		 
		    }
		    return extent;
		}
	
public void StartTest(String TestcaseName, String Description) {
		
		testlog = extent.createTest(TestcaseName, "This Test is intented to verify -"+Description);
		//System.out.println("Starting TestSuite : "+ SuiteName+" and Test : "+ TestNGTestName);
		//testlog.info("Starting TestSuite : "+ SuiteName+" and Test : "+ TestNGTestName);
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

//System.out.println(OwnerCountry);
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
	/*String RS = RatingSystem;
	System.out.println(RS);*/
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
		//search.SearchProjectOnFailure(SheetName, rowNum);
	} else if (result.getStatus() == ITestResult.SKIP) {
		// testlog.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		testlog.log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	}
	
}

@AfterClass(alwaysRun = true)
public void flushReport() {
	
	extent.flush();
	//extent=null;
	System.out.println("EndClass");
	
}

@AfterTest(alwaysRun = true)
public void quit() throws InterruptedException, IOException {
	
	System.out.println("EndTest");
	rc.SignOut();
	FileUtils.cleanDirectory(new File(downloadPath)); 
}

@AfterSuite(alwaysRun = true)
public void end(){	
	
	System.out.println("EndSuite");
		driver.quit();
}
	}