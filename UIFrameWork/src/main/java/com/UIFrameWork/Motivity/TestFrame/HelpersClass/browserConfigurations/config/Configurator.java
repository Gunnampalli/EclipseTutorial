package com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations.config;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.browserConfigurations.BrowserType;

public interface Configurator {

	public int getImplicitWait();

	public int getExplicitWait();

	public int pageLoadTime();

	public BrowserType getBrowserType();
}
