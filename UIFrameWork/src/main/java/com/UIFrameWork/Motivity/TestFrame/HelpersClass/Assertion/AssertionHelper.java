package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;

public class AssertionHelper {
	private static Logger log = LoggerHelper.getlogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2) {
		log.info("Verifying Test:" + s1 + "With " + s2);
		Assert.assertEquals(s1, s2);
	}

	public static void makeTrue() {
		log.info("making Script Pass...");
		Assert.assertTrue(true);
	}

	public static void makeTrue(String message) {
		log.info("making Script Pass..." + message);
		Assert.assertTrue(true, message);
	}

	public static void makeFalse() {
		log.info("making Script Fail...");
		Assert.assertTrue(false);
	}

	public static void makeFalse(String message) {
		log.info("making Script Fail..." + message);
		Assert.assertTrue(false, message);
	}

	public static void verifyTrue(boolean status) {
		Assert.assertTrue(status);
	}

	public static void verifyFalse(boolean status) {
		Assert.assertFalse(status);
	}

	public static void verifyNull(String s1) {
		log.info("Verify Object is null");
		Assert.assertNull(s1);

	}

	public static void verifyNotNull(String s1) {
		log.info("Verify Object is not null");
		Assert.assertNotNull(s1);
	}

}
