package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Resource.ResourceHelper;

public class LoggerHelper {

	private static boolean root = false;

	public static Logger getlogger(Class cls) {
		if (root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator
				.configure(ResourceHelper.getResourcePath("\\src\\main\\Resources\\ConfigFile\\log4J.properties"));
		root = true;
		return Logger.getLogger(cls);

	}

}
