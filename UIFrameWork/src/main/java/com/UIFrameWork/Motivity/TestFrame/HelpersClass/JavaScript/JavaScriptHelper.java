package com.UIFrameWork.Motivity.TestFrame.HelpersClass.JavaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Switch.FrameHelper;

public class JavaScriptHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getlogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("JavaScriptHelper has been intialised");
	}

	public Object executeScript(String Script) {

		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(Script);

	}

	public Object executeScript(String Script, Object... args) {

		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(Script, args);

	}

	public void ScrollToElement(WebElement element) {
		log.info("Scroll to " + element);
		executeScript("window.scrollTo(arguments[0],arguments[1]", element.getLocation().x, element.getLocation().y);
	}

	public void scrollToElementAndClick(WebElement element) {
		ScrollToElement(element);
		element.click();
		log.info("Element is clicked" + element.toString());
	}

	public void scrollIntoView(WebElement element) {
		log.info("Scroll till webelement");
		executeScript("arguments[0].scrollIntoView()", element);

	}

	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("Element is clicked" + element.toString());

	}

	public void scrollDownVertically() {
		log.info("Scrolling down Vertically....");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollUpVertically() {
		log.info("Scrolling UP Vertically....");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
}
