package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Switch;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;

public class FrameHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getlogger(FrameHelper.class);

	public FrameHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will switchtoFrame based on frame Index
	 * 
	 * @param Frameindex
	 */
	public void SwitchToFrame(int Frameindex) {
		driver.switchTo().frame(Frameindex);
		log.info("Switched to " + Frameindex + "Frame");
	}

	/**
	 * This method will switchtoFrame based on frame Name
	 * 
	 * @param FrameName
	 */

	public void SwitchToFrame(String FrameName) {
		driver.switchTo().frame(FrameName);
		log.info("Switched to " + FrameName + "Frame");
	}

	/**
	 * This method will switchtoFrame based on frame WebElement
	 * 
	 * @param frameElement
	 */
	public void SwitchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		log.info("Switched to " + frameElement + "Frame");
	}
}
