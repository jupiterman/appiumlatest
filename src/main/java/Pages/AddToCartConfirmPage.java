package Android.Automation.Pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import Android.Automation.Components.NavigationMenu;

public class AddToCartConfirmPage 

{

   private static final By CONFIRM_TEXT_FIELD = By.id("confirm-text");

   private final NavigationMenu navigationMenu;

   private AndroidDriver driver;

 

   public AddToCartConfirmPage(AndroidDriver driver)
   
   {

      this.driver = driver;

      this.navigationMenu = new NavigationMenu(driver);

   }

 

   public String getConfirmationText() 
   
   {

      return driver.findElement(CONFIRM_TEXT_FIELD).getText();

   }

 

   public NavigationMenu navigationMenu() 
   
   {

      return navigationMenu;

   }

}
