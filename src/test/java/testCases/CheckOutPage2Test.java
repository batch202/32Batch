package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutPage1;
import pages.CheckOutPage22;
import pages.Inventory_Page;
import pages.LoginPage;
public class CheckOutPage2Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent; 
	CartPage cart;
	CheckOutPage1 check1;
	CheckOutPage22 check2;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page(); 
		cart=new CartPage();
		check1=new CheckOutPage1();
		check2=new CheckOutPage22();
		login.loginToApplication(); 
		invent.add6Products();
		invent.ClickOncartIcon();
		cart.clickOncheckOutBtn();
		check1.inputInfo();
	}
	@Test
	public void verifyLableTest()
	{
		String expLable="Checkout: Overview";
		String actLable=check2.verifyLable();
		Assert.assertEquals(expLable,actLable); 
		Reporter.log("Lable of check out page 2 = " + actLable);
	}
	@Test
	public void clickOnFinishBtnTest()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=check2.clickOnFinishBtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Url of Complete Page = " +actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}


}
