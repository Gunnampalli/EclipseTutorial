package com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Resource.ResourceHelper;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations.BrowserType;

public class PropertyReader implements Configurator {
	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {

		String filepath = ResourceHelper.getResourcePath("src/main/Resources/ConfigFile/config.properties");

		try {
			file = new FileInputStream(new File(filepath));
			OR = new Properties();

			OR.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getImplicitWait() {
		// TODO Auto-generated method stub

		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int pageLoadTime() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {
		// TODO Auto-generated method stub
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

}
