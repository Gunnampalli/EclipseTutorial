package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;

public class AlertHelper {
	private WebDriver driver;
	private static Logger log = LoggerHelper.getlogger(AlertHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Alert helper Object is created");
	}

	public Alert getAlert() {
		log.info("alert Test:" + driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		log.info("acceptAlert is done.....");
		getAlert().accept();
	}

	public void dismissAlert() {
		log.info("dismiss Alert is done.....");
		getAlert().dismiss();
		;
	}

	public String getAlertText() {
		String text = getAlert().getText();
		log.info("alert test:" + text);
		return text;

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("Alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
		}
	}

	public void acceptAlertIfPresent() {
		if (isAlertPresent()) {
			acceptAlert();
		} else
			log.info("Alert is not Present.....");
	}

	public void dismissAlertIfPresent() {
		if (isAlertPresent()) {
			dismissAlert();
		} else
			log.info("Alert is not Present.....");
	}

	public void acceptPrompt(String text) {
		if (isAlertPresent()) {
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert Text ...." + text);
		}
	}
}
