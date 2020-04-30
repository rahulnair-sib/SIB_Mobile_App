package com.SIB.App.Pages;

import com.SIB.App.Base.Base;
import com.SIB.App.Base.Wrapper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends Base{
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='_label-0']/../android.widget.EditText")
	private MobileElement accountName;
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='_label-1']/../android.widget.EditText")
	private MobileElement emailTextBox;
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='_label-2']/../android.widget.EditText")
	private MobileElement passwordTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Login ']")
	private MobileElement loginButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Declare an Emergency ']")
	private MobileElement declareEmergencyButton;
	
	public void clickLogin() {
		
		Wrapper.click(loginButton);
		
	}
	
	public void enterPassword(String password) {
		
		Wrapper.sendKeys(passwordTextBox, password);
	}
	
	public void enterEmail(String email) {
		
		Wrapper.sendKeys(emailTextBox, email);
	}
	
	public void clearAccountNameTextBox() {
		
		Wrapper.clear(accountName);
	}
	
	public void enterAccountName(String name) {
		
		Wrapper.sendKeys(accountName, name);
	}
	
	

}
