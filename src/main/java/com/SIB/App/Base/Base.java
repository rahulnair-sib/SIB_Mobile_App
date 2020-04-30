package com.SIB.App.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.SIB.App.Utils.XMLParser;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Base {
	
	protected static AppiumDriver driver;
	protected Properties props;
	protected static HashMap<String,String> strings = new HashMap<String,String>();
	FileInputStream inputStream;
	InputStream stringInputStream;
	XMLParser xmlParser;
	
	public Base() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@BeforeTest
	public void beforeTest() throws Exception {
		
		try {
			
			props = new Properties();
			String propFileName = "./src/main/resources/config.properties";
			String xmlFileName = "./Strings/Strings.xml";
			
			
			inputStream = new FileInputStream(propFileName);
			props.load(inputStream);
			
			stringInputStream = getClass().getClassLoader().getResourceAsStream(xmlFileName);
			xmlParser = new XMLParser();
			strings = xmlParser.parseXML(stringInputStream);
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", props.getProperty("platFormName"));
			cap.setCapability("platformVersion", props.getProperty("androidPlatformVersion"));
			cap.setCapability("deviceName", props.getProperty("androidDeviceName"));
			cap.setCapability("automationName", props.getProperty("androidAutomationName"));
			cap.setCapability("appPackage", props.getProperty("androidAppPackage"));
			cap.setCapability("appActivity", props.getProperty("androidAppActivity"));
			//cap.setCapability("noReset", true);
			//cap.setCapability("avd", props.getProperty("avdName"));
			cap.setCapability("autoGrantPermissions", true);
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			
			driver = new AndroidDriver(url,cap);
			String sessionId = driver.getSessionId().toString();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			
			if(inputStream != null) {
				
				inputStream.close();
				
			}
			
			if(stringInputStream != null) {
				
				stringInputStream.close();
			}
		}
		
		
		
	}
	
	
	
	@AfterTest
	public void afterTest() {
		
		
	}

}
