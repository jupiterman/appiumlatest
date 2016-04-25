package Android.Automation.Pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class CartPage

{

   private static final By LIST_ITEM = By.className("a-list-item");

   private AndroidDriver driver;

 

   public CartPage(AndroidDriver driver) 
   
   {

      this.driver = driver;

   }

 

   public String getFirstItemText() 
   
   {

      return driver.findElement(LIST_ITEM) .getText();

   }

}
