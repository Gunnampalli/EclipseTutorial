package com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Resource.ResourceHelper;

public class InternetExplorerBrowser {
/*	public InternetExplorerOptions getIExplorerCapabilites() {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		InternetExplorerOptions iexploreroptions = new InternetExplorerOptions(cap);
		return iexploreroptions;
	}

	public WebDriver getInternetExplorerDriver(InternetExplorerOptions cap) {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("WebDriver.ie.driver",
					ResourceHelper.getResourcePath("src/main/Resources/drivers/iedriver"));
			return new InternetExplorerDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("WebDriver.ie.driver",
					ResourceHelper.getResourcePath("src/main/Resources/drivers/iedriver.exe"));
			return new InternetExplorerDriver(cap);
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("WebDriver.ie.driver", ResourceHelper.getResourcePath("/usr/bin/iedriver"));
			return new InternetExplorerDriver(cap);
		}
		return null;
	}
*/
}
