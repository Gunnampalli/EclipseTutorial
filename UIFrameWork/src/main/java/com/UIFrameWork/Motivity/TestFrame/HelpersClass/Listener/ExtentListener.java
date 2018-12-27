package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Listener;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;
import com.UIFrameWork.Motivity.TestFrame.Utilis.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentListener implements ITestListener {
	public static ExtentReports extent;
	public static ExtentTest test;
	private Logger log = LoggerHelper.getlogger(ExtentListener.class);

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// test.log(Status.INFO, result.getName() + "Started...");
		Reporter.log(result.getMethod().getMethodName() + "Test Started...");
		log.info(result.getMethod().getMethodName() + "Test Started...");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// test.log(Status.PASS, result.getName() + "Passed...");
		Reporter.log(result.getMethod().getMethodName() + "Test Passed...");
		log.info(result.getMethod().getMethodName() + "Test Passed...");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// test.log(Status.FAIL, result.getName() + "Failed...");
		Reporter.log(result.getMethod().getMethodName() + "Test Failed..." + result.getThrowable());
		log.error(result.getMethod().getMethodName() + "Test Failed..." + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		// test.log(Status.SKIP, result.getName() + "Skipped...");
		Reporter.log(result.getMethod().getMethodName() + "Test Skipped..." + result.getThrowable());
		log.warn(result.getMethod().getMethodName() + "Test Skipped..." + result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		// extent = ExtentManager.getInstance();
		// test = extent.createTest(context.getName());
		// test = extent.createTest(context.getCurrentXmlTest().getName());
		Reporter.log(context.getName() + "Test Started...");
		log.info(context.getName() + "Test Started...");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// extent.flush();
		Reporter.log(context.getName() + "Test Finished...");
		log.info(context.getName() + "Test Finished...");

	}

}
