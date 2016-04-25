package Android.Automation.Pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class SearchResultsPage {

private static final By SEARCH_RESULT_ITEM_TITLE = By.className("search-results");

private AndroidDriver driver;

 public SearchResultsPage(AndroidDriver driver) 
 
 {
     this.driver = driver;

   }

 public String getFirstResultTitle() 
 
 {

      return driver.findElement(SEARCH_RESULT_ITEM_TITLE).getText();
   }


   public ProductDetailsPage clickFirstResultTitle() 
   
   {

      driver.findElement(SEARCH_RESULT_ITEM_TITLE).click();

      return new ProductDetailsPage(driver);

   }

}
