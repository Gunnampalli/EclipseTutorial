package com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Resource.ResourceHelper;
import com.mongodb.client.model.FindOptions;

public class FireFoxBrowser {
	/*
	public FirefoxOptions getFirefoxOptions() {

		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);

		FirefoxOptions firefoxoptions = new FirefoxOptions(firefox);
		if (System.getProperty("os.name").contains("Linux")) {
			option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return firefoxoptions;
	}

	public WebDriver getFirefoxDriver(FirefoxOptions cap) {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("WebDriver.firefox.driver",
					ResourceHelper.getResourcePath("src/main/Resources/drivers/geckodriver"));
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("WebDriver.firefox.driver",
					ResourceHelper.getResourcePath("src/main/Resources/drivers/geckodriver.exe"));
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("WebDriver.firefox.driver", ResourceHelper.getResourcePath("/usr/bin/geckodriver"));
			return new FirefoxDriver(cap);
		}
		return null;
	}
	*/

}
