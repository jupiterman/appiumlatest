package Android.Automation.Pages;

import Android.Automation.Components.NavigationMenu;
import io.appium.java_client.android.AndroidDriver;

public class HomePage 

{
	   private static final String HS18_HOME_PAGE_URL = "http://m.homeshop18.com";

	   private final NavigationMenu navigationMenu;
	
	   private AndroidDriver driver;
	
	   public HomePage(AndroidDriver driver) 
	   
	   {
	
	      this.driver = driver;
	
	      this.navigationMenu = new NavigationMenu(driver);
	
	   }
	
	 
	
	   public HomePage open() 
	   
	   {
	
	      driver.get(HS18_HOME_PAGE_URL);
	
	      return this;
	
	   }
	
	 
	
	   public NavigationMenu navigationMenu() 
	   
	   {
	
	      return navigationMenu;
	
	   }
	
	}
