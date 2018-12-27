package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Resource;

import org.apache.log4j.Logger;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;

public class ResourceHelper {

	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");
		return basePath + "/" + path;
	}

}
