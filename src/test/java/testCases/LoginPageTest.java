package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase
{
	LoginPage login; 
	@BeforeMethod (alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
	}
	@Test(enabled = false,groups = {"Sanity","Retesting"})
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0,0);//Swag Labs(0,0)
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test(enabled = false,groups = "Regreesion")
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL="https://www.saucedemo.com/";//ReadData.readExcel(1,9);(1,0)
		String actURL=login.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@Test(enabled = true)
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(2,0);//https://www.saucedemo.com/inventory.html(2,0) 
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.sc(it.getName());
		}
		report.flush();
		driver.close();
	}

}
