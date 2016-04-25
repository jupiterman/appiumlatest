package Android.Automation.Pages;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
public class LoginPage

{

   private static final String LOGIN_PAGE_URL = "m.homeshop18.com";

   private static final By USERNAME_INPUT = By.name("email");

   private static final By PASSWORD_INPUT = By.name("password");

   private static final By SIGN_IN_BUTTON = By.className("btAction hide-loader");

   private AndroidDriver driver;

   public LoginPage(AndroidDriver driver)
   
   {

      this.driver = driver;

   }

   public LoginPage open()
   
   {

	   driver.get(LOGIN_PAGE_URL);

      return this;

   }

   public HomePage loginAs(String username, String password) 
   
   {

      driver.findElement(USERNAME_INPUT).sendKeys(username);

      driver.findElement(PASSWORD_INPUT).sendKeys(password);
      driver.findElement(SIGN_IN_BUTTON).click();

      return new HomePage(driver);

   }

}
