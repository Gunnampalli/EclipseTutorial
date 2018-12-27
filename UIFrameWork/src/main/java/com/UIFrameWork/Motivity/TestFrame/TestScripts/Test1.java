package com.UIFrameWork.Motivity.TestFrame.TestScripts;

import org.testng.annotations.Test;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Assertion.AssertionHelper;
import com.UIFrameWork.Motivity.TestFrame.TestBase.TestBase;

public class Test1 extends TestBase {
	@Test
	public void testLogin() {
		new AssertionHelper().makeTrue();
	}

	@Test
	public void testLogin1() {
		new AssertionHelper().makeFalse();
	}

	@Test
	public void testLogin2() {
		new AssertionHelper().makeTrue();
	}

	@Test
	public void testLogin3() {
		new AssertionHelper().makeFalse();
	}

}
