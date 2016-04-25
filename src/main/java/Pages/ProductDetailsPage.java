package Android.Automation.Pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class ProductDetailsPage 

{

   private static final By PRODUCT_TITLE_FIELD = By.className("product-title");

   private static final By BUY_NOW = By.id("btnText");

   private AndroidDriver driver;

 

   public ProductDetailsPage(AndroidDriver driver) 
   
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
