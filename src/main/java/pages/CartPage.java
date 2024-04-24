package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{ 
	//Object Repository
		@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button ']") private WebElement checkOutBtn;
		@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartlable;
		public CartPage()
		{
			PageFactory.initElements(driver,this);
		}
		public String verifyCartPageURL()
		{
			return driver.getCurrentUrl();
		} 
		public String verifyCartLable()
		{
			return cartlable.getText();
		} 
		public void clickOncheckOutBtn()
		{
			checkOutBtn.click();
		}

}
