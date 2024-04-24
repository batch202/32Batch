package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutComplete;
import pages.CheckOutPage1;
import pages.CheckOutPage22;
import pages.Inventory_Page;
import pages.LoginPage;

public class CheckOutCompleteTest extends TestBase
{
	LoginPage login;
Inventory_Page invent; 
CartPage cart;
CheckOutPage1 check1;
CheckOutPage22 check2;
CheckOutComplete complete;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page(); 
		cart=new CartPage();
		check1=new CheckOutPage1();
		check2=new CheckOutPage22();
		complete=new CheckOutComplete();
		login.loginToApplication(); 
		invent.add6Products();
		//invent.ClickcartCount();
		cart.clickOncheckOutBtn();
		check1.inputInfo();
		check2.clickOnFinishBtn();
	}
	@Test
	public void verifyURLTest()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=complete.verifyURL();
		Assert.assertEquals(expURL,actURL); 
		Reporter.log("URL of check out complete page = " + actURL);
	}
	@Test
	public void verifyImgTest()
	{
		boolean result=complete.verifyImg();
		Assert.assertEquals(result,true);
		Reporter.log("Visibility of Pony Logo = " + result);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}





}
