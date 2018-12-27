package com.UIFrameWork.Motivity.TestFrame.TestBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Resource.ResourceHelper;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Wait.WaitHelper;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Window.WindowHelper;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations.BrowserType;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations.ChromeBrowser;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations.config.ObjectReader;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations.config.PropertyReader;
import com.UIFrameWork.Motivity.TestFrame.Utilis.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class TestBase {

	private Logger log = LoggerHelper.getlogger(TestBase.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	public static File reportDirectory;

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		ObjectReader.reader = new PropertyReader();
		reportDirectory = new File(ResourceHelper.getResourcePath("src\\main\\Resources\\Screenshots"));
		setUpDriver(ObjectReader.reader.getBrowserType());

	}

	@BeforeClass
	public void beforeClass() {
		test = extent.createTest(getClass().getName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "test started");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		String imagePath=	captureScreen(result.getName());
			test.addScreenCaptureFromPath(imagePath);

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + "is pass");
			String imagePath=	captureScreen(result.getName());
			test.addScreenCaptureFromPath(imagePath);

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());

		}
		extent.flush();
	}

	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try {
			ChromeBrowser chrome;
			switch (btype) {
			case Chrome:
				// get object of chrome driver class
				ChromeBrowser chrome1 = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome1.getChromeOptions();
				return chrome1.getChromeDriver(option);

			case FireFox:
				return null;

			case IExplorer:
				return null;

			default:
				throw new Exception("Driver not found..." + btype.name());

			}

		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;

		}
	}

	public void setUpDriver(BrowserType bType) throws Exception {
		driver = getBrowserObject(bType);
		log.info("Intialize Web Driver:" + driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.PageLoadTime(ObjectReader.reader.pageLoadTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String captureScreen(String fileName) {
		if (driver == null) {
			log.info("driver is null");
			return null;

		}
		if (fileName == "") {
			fileName = "blank";
		}
		File destinationFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destinationFile = new File(
					reportDirectory + "/" + fileName + "_" + formatter.format(calendar.getTime()) + ".png");
			Files.copy(SourceFile, destinationFile);
			Reporter.log("<a href='" + destinationFile.getAbsolutePath() + "'><img src='"
					+ destinationFile.getAbsolutePath() + "'height='100' width='100'/></a>);");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return destinationFile.toString();
	}

}
