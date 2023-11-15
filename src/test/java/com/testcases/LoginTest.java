package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.PageObjects.Login_functionality;
import com.Utils.Utils1;
import com.base.Testbase;

public class LoginTest extends Testbase {

	Login_functionality lf;
	private String Sheetname= "Sheet1";

	public LoginTest() throws Throwable {
		super();
	}

	@BeforeMethod

	public void setup() throws Throwable {

		Initialization();

		lf = new Login_functionality(driver);

	}

	@Test

	public void Verifylogin() throws Throwable {

		lf.Dologin();

		String url = driver.getCurrentUrl();

		Assert.assertEquals("http://empirehome.myprojectsonline.co.in/EmpireHome/", url);
 
	}
	    @Test(dataProvider="getdata",dataProviderClass=LoginTest.class)
	    public void login(String Username,String Password) throws Throwable {
	    	lf.DologinwithExcel(Username, Password);
	    	String url = driver.getCurrentUrl();
			Assert.assertEquals(url,"http://empirehome.myprojectsonline.co.in/EmpireHome/Dashboard");
		 }
	    
	    @DataProvider
	    
	    public Object[][] getdata() throws IOException {
	    
	    	return Utils1.readDataFromExcel(Sheetname);
	    }

	@AfterMethod

	public void teardown() {

		//driver.close();

	}

}
