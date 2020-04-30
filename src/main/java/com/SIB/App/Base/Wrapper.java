package com.SIB.App.Base;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

public class Wrapper extends Base{
	
public static void waitForVisibility(MobileElement e) {
		
		WebDriverWait wait = new WebDriverWait(driver,20) ;
		wait.until(ExpectedConditions.visibilityOf(e));
	}

public static void click(MobileElement e) {
	
		waitForVisibility(e);
		e.click();
	
}

public static void sendKeys(MobileElement e, String txt) {
	
		waitForVisibility(e);
		e.sendKeys(txt);
}

public static void clear(MobileElement e) {
	
	waitForVisibility(e);
	e.clear();
}

}
