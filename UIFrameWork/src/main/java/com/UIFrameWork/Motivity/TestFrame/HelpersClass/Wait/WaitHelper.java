package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Wait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;

public class WaitHelper {
	private WebDriver driver;

	private Logger log = LoggerHelper.getlogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Implicit Wait
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit Wait has been set to : " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	/**
	 * This Method will help us to get webdriverwait object
	 * 
	 * @param TimeOutInSeconds
	 * @param PollingEveryInMilliSec
	 * @return
	 */
	private WebDriverWait getWait(int TimeOutInSeconds, int PollingEveryInMilliSec) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.pollingEvery(PollingEveryInMilliSec, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	/**
	 * This method will make sure element is visible
	 * 
	 * @param element
	 * @param timeoutinSeconds
	 * @param pollingEveryInMilliSec
	 */

	public void WaitForElementVisiblewithPollingTime(WebElement element, int timeoutinSeconds,
			int pollingEveryInMilliSec) {
		log.info("Waiting for " + element.toString() + "for:" + timeoutinSeconds + "seconds");
		WebDriverWait wait = getWait(timeoutinSeconds, pollingEveryInMilliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now");
	}

	/**
	 * This method will make sure element is clickable1
	 * 
	 * @param element
	 * @param timeoutinSeconds
	 */
	public void WaitForElementClickable(WebElement element, int timeoutinSeconds) {
		log.info("Waiting for " + element.toString() + "for:" + timeoutinSeconds + "seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutinSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clickable now");
	}

	/**
	 * ThiThis method will make sure invisibility of element
	 * 
	 * @param element
	 * @param timeoutinSeconds
	 * @return
	 */
	public boolean waitforElementNotPresent(WebElement element, long timeoutinSeconds) {
		log.info("Waiting for " + element.toString() + "for:" + timeoutinSeconds + "seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutinSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOfAllElements((List<WebElement>) element));
		log.info("Element is invisible now");
		return status;
	}

	/**
	 * This method will make sure frameToBeAvailableAndSwitchToIt
	 * 
	 * @param element
	 * @param timeoutinSeconds
	 */
	public void waitforElementNotPresent1(WebElement element, long timeoutinSeconds) {
		log.info("Waiting for " + element.toString() + "for:" + timeoutinSeconds + "seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutinSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Element is available and switched now");

	}

	/**
	 * this method will give fluentwait object
	 * 
	 * @param TimeOutInSeconds
	 * @param PollingEveryInMilliSec
	 * @return
	 */

	private Wait<WebDriver> getFluentWait(int TimeOutInSeconds, int PollingEveryInMilliSec) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(TimeOutInSeconds, TimeUnit.SECONDS);
		return fwait;

	}

	public WebElement WaitForElement(WebElement element, int TimeOutInSeconds, int PollingEveryInMilliSec) {
		Wait<WebDriver> fwait = getFluentWait(TimeOutInSeconds, PollingEveryInMilliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public void PageLoadTime(long timeout, TimeUnit unit) {
		log.info("Waiting for page to load for :" + unit + "seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page is loaded");
	}
}
