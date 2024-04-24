package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CartPageTest extends TestBase
{ 
	LoginPage login;
	Inventory_Page invent; 
	CartPage cart;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page(); 
		cart=new CartPage();
		login.loginToApplication();
		invent.add6Products();
		invent.ClickOncartIcon();
	}
	@Test(enabled = true,groups = {"Sanity","Retesting"})
	public void verifyCartPageURLTest()
	{
		String expURL="https://www.saucedemo.com/cart.html"; 
		String actURL=cart.verifyCartPageURL();
		Assert.assertEquals(expURL,actURL);
		Reporter.log( "The URL of Cart Page = "+ actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.sc(it.getName());
		}
		driver.close();
	}

}
