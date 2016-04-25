package Android.Automation.Pages;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

public class PaymentPage 

	{

		   private static final By PRODUCT_TITLE_FIELD = By.className("btn pay");

		   private static final By BUY_NOW = By.id("btnText");

		   private AndroidDriver driver;

		 

		   public PaymentPage(AndroidDriver driver)
		   
		   {

		      this.driver = driver;

		   }

		 

		   public String getProductTitle() 
		   
		   {

		      return driver.findElement(PRODUCT_TITLE_FIELD).getText();

		   }

		 

		   public AddToCartConfirmPage addToCart() 
		   
		   
		   {

		      driver.findElement(BUY_NOW).click();

		      return new AddToCartConfirmPage(driver);

		   }

		}

