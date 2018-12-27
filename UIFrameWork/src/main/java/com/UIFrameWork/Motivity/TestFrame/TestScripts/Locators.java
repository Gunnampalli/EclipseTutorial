package com.UIFrameWork.Motivity.TestFrame.TestScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.UIFrameWork.Motivity.TestFrame.TestBase.TestBase;

public class Locators extends TestBase {

	@Test
	public void Loca() throws InterruptedException {
		driver.get("https://login.yahoo.com/");
		// id
		// WebElement user=driver.findElement(By.id("login-Username"));
		String Main = driver.getWindowHandle().toString();
		Set<String> sys = driver.getWindowHandles();
		System.out.println(Main + "    " + "No of handle=....." + sys.size());
		Iterator<String> ab = sys.iterator();
		while (ab.hasNext()) {
			String Chil = ab.next();
			if (!Main.equals(Chil)) {
				driver.switchTo().window(Chil);
				driver.get("http://motivitylabs.com/");
				Thread.sleep(200);
			}
		}
		driver.switchTo().window(Main);
		WebElement user = driver.findElement(By.cssSelector("input#login-username"));
		user.sendKeys("Venky@yahoo.com");
		Thread.sleep(200);
		driver.quit();
	}

}
