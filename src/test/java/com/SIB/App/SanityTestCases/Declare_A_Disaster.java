package com.SIB.App.SanityTestCases;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SIB.App.Base.Base;
import com.SIB.App.Pages.DashboardPage;
import com.SIB.App.Pages.LoginPage;

public class Declare_A_Disaster extends Base{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	InputStream loginInputStream;
	JSONTokener loginToken;
	JSONObject loginObject;
	
	@BeforeMethod
	public void initializePageObjects() throws Exception {
		
		try {
			
			String loginDataFile = "./TestData/Login.json";
			loginInputStream = getClass().getClassLoader().getResourceAsStream(loginDataFile);
			loginToken = new JSONTokener(loginInputStream);
			loginObject = new JSONObject(loginToken);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			if(loginInputStream != null) {
				
				loginInputStream.close();
			}
		}
		
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
	}
	
	@Test
	public void declareADisaster() {
		
		loginPage.clearAccountNameTextBox();
		loginPage.enterAccountName(loginObject.getString("instanceName"));
		loginPage.enterEmail(loginObject.getJSONObject("validUser").getString("userName"));
		loginPage.enterPassword(loginObject.getJSONObject("validUser").getString("password"));
		loginPage.clickLogin();
	}

}
