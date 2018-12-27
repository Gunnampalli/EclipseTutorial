package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Switch.FrameHelper;

public class WindowHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getlogger(WindowHelper.class);

	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This Method will Switch to ParentWindow
	 */

	public void SwitchToParentWindow() {
		log.info("Switching to Parent Window");
		driver.switchTo().defaultContent();
	}

	/**
	 * This Method Will Switch to Child Window based on index
	 * 
	 * @param index
	 */
	public void SwitchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				log.info("Switched to :" + index + "Window");
				driver.switchTo().window(window);
			} else {
				i++;
			}
		}
	}

	/**
	 * This method will switch to closed all tabs and switch to main window
	 */

	public void CloseAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String Mainwindow = driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(Mainwindow)) {
				driver.close();
			}

		}
		log.info("Switched to mainWindow");
		driver.switchTo().window(Mainwindow);

	}

	/**
	 * This method will do browser back navigation
	 */

	public void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * This method will do browser Forward navigation
	 */
	public void navigateForward() {
		driver.navigate().forward();
	}

}
