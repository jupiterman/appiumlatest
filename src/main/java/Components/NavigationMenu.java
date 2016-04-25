package Android.Automation.Components;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Android.Automation.Pages.CartPage;
import Android.Automation.Pages.SearchResultsPage;

public class NavigationMenu

{

   private static final By SEARCH_DROPDOWN_BOX = By.className("suggestion-div");

   private static final By SEARCH_INPUT = By.id("srchKw");

   private static final By SEARCH_GO_BUTTON = By.xpath("//*[@value='Search']");

   private static final By NAVIGATION_ITEM_CART = By.id("nav-cart");

   private AndroidDriver driver;

 

   public NavigationMenu(AndroidDriver driver) 
   
   {

      this.driver = driver;

   }

 

   public SearchResultsPage searchFor(String category, String searchKey) 
   
   
   {

      new Select(driver.findElement(SEARCH_DROPDOWN_BOX)).selectByVisibleText(category);
      driver.findElement(SEARCH_INPUT).sendKeys(searchKey);
      driver.findElement(SEARCH_GO_BUTTON) .click();

      return new SearchResultsPage(driver);

   }

   public CartPage navigateToCartPage() 
   
   {

      driver.findElement(NAVIGATION_ITEM_CART).click();

      return new CartPage(driver);

   }

}
