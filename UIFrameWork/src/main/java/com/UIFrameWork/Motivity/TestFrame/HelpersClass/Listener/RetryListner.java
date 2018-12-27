package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;

public class RetryListner implements IAnnotationTransformer {
	private Logger log = LoggerHelper.getlogger(RetryListner.class);

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		// TODO Auto-generated method stub
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if (retry == null) {
			annotation.setRetryAnalyzer(Retry.class);
		}

	}

}
