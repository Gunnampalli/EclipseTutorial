package com.UIFrameWork.Motivity.TestFrame.TestScripts;

import org.testng.annotations.Test;

import com.UIFrameWork.Motivity.TestFrame.TestBase.TestBase;

public class TestScreenshot extends TestBase {
	@Test
	public void testScreen() {
		driver.get("https://www.seleniumhq.org/download/");
		captureScreen("firstScreen");
	}

}
