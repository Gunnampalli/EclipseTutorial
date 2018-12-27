package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;

public class VerificationHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getlogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Element is Displayed or not
	 * 
	 * @param element
	 * @return
	 */

	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is present" + element.getText());
			return true;
		} catch (Exception e) {
			log.error("Element is not Present..", e.getCause());
			return false;
		}

	}

	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is present" + element.getText());
			return false;
		} catch (Exception e) {
			log.error("Element is not Present..");
			return true;
		}

	}

	/**
	 * Get Text from WebElement
	 * 
	 * @param element
	 * @return
	 */

	public String getText(WebElement element) {
		if (null == element) {
			log.info("WebElement is null");
			return null;
		}
		boolean status = isDisplayed(element);

		if (status) {
			log.info("element text is .." + element.getText());
			return element.getText();
		} else {
			return null;
		}

	}

	/**
	 * Get Title from the Page
	 * 
	 * @return
	 */
	public String getTitle() {
		log.info("Page Title is " + driver.getTitle());
		return driver.getTitle();
	}

}
