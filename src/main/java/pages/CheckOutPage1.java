package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage1 extends TestBase
{
	//Object Repository 
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastNametxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipTxtBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	//Constructor 
	public CheckOutPage1()
	{
		PageFactory.initElements(driver,this);
	} 
	public String inputInfo()
	{
		firstNameTxtBox.sendKeys("Harry"); 
		lastNametxtBox.sendKeys("Potter"); 
		zipTxtBox.sendKeys("411032"); 
		continueBtn.click();
		return driver.getCurrentUrl();
	}

}
