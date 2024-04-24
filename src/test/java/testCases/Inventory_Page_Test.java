package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page(); 
		login.loginToApplication();
	}
	@Test(enabled = true,priority = 1,groups = {"Sanity","Retesting"}) 
	public void verifyPageTitle()
	{
		String expTitle="Products"; 
		String actTitle=invent.verifyPageTitle();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log( "The Title of Inventory page = "+ actTitle);
	}
	@Test(enabled = true,groups = "Regreesion")
	public void verifyTwitterLogo()
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Twitter Logo is Present = " + result);
	} 
	@Test(enabled = true,groups = {"Regreesion","Retesting"}) 
	public void add6ProductsTest()
	{
		String expCount="6";
		String actCount=invent.add6Products();//6 
		Assert.assertEquals(expCount,actCount); 
		Reporter.log("Total product added to the Cart = " + actCount);
	}
	@Test(enabled = true,groups = {"Regreesion","Retesting"}) 
	public void remove2ProductsTest()
	{
		String expCount="4";
		String actCount=invent.remove2Products(); 
		Assert.assertEquals(expCount,actCount); 
		Reporter.log("Total product removed to the Cart = " + actCount);
		
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