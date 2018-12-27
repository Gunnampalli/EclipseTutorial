package com.UIFrameWork.Motivity.TestFrame.HelpersClass.SelectClass;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;

public class DropDownHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getlogger(DropDownHelper.class);

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void selectUsingValue(WebElement element, String Value) {
		Select select = new Select(element);
		log.info("SelectUsing Value and value is " + Value);
		select.selectByValue(Value);
	}

	public void selectByIndex(WebElement element, int Index) {
		Select select = new Select(element);
		log.info("SelectUsingIndex and Index is " + Index);
		select.selectByIndex(Index);
	}

	public void selectUsingVisibleText(WebElement element, String Text) {
		Select select = new Select(element);
		log.info("SelectUsing VisibleText and Text is " + Text);
		select.selectByVisibleText(Text);
	}

	public void deselectUsingValue(WebElement element, String Value) {
		Select select = new Select(element);
		log.info("DeselectUsing Value and value is " + Value);
		select.deselectByValue(Value);
	}

	public void deselectByIndex(WebElement element, int Index) {
		Select select = new Select(element);
		log.info("DeselectUsingIndex and Index is " + Index);
		select.deselectByIndex(Index);
	}

	public void deselectUsingVisibleText(WebElement element, String Text) {
		Select select = new Select(element);
		log.info("DeselectUsing VisibleText and Text is " + Text);
		select.deselectByVisibleText(Text);
	}

	public List<String> getAllDropDownData(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valuelist = new LinkedList<String>();
		for (WebElement ele : elementList) {
			log.info(ele.getText());
			valuelist.add(ele.getText());
		}
		return valuelist;
	}
}
