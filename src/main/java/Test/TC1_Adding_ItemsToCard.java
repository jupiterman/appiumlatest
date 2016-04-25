package Android.Automation.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Android.Automation.Pages.AddToCartConfirmPage;
import Android.Automation.Pages.CartPage;
import Android.Automation.Pages.HomePage;
import Android.Automation.Pages.ProductDetailsPage;
import Android.Automation.Pages.SearchResultsPage;

public class TC1_Adding_ItemsToCard 

{

private HomePage homepage;

public class FirstTests 

{

   private AndroidDriver driver;
   
   private HomePage homePage;

   @BeforeClass(alwaysRun = true)

   public void setUp() throws MalformedURLException 
   
   {

	   DesiredCapabilities cap =  DesiredCapabilities.android();
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.ANDROID);
    	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
    	cap.setCapability(MobileCapabilityType.VERSION, "6");
		cap.setCapability("appPackage","com.android.chrome");
		cap.setCapability("appActivity","com.google.android.apps.chrome.Main");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Google Nexus 5-6.0.0" );
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		

   }

   @BeforeMethod(alwaysRun = true)

   public void openHomePage() {

      homePage = new HomePage(driver).open();

   }

 

   @AfterClass(alwaysRun = true)
   
   public void tearDown() 
   {

      driver.quit();

   }

 

   @Test

   public void testAddingItemToCard() 
   
   {

      SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor("Elecronics", "Nikon");

      String itemTitle = searchResultsPage.getFirstResultTitle();

      ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();

      assert (productDetailsPage.getProductTitle().equals(itemTitle));

      AddToCartConfirmPage addToCartConfirmPage = productDetailsPage.addToCart();

      assert (addToCartConfirmPage.getConfirmationText().equals("1 item added to Cart"));

      CartPage cartPage = addToCartConfirmPage.navigationMenu().navigateToCartPage();

      assert (cartPage.getFirstItemText().contains(itemTitle));

   }

 

   @Test

   public void testSignInSignOut() 
   
   { 

  

      driver.findElement(By.id("signInHeaderLink")) .click();
          
      //Enter e-mail address

      driver.findElement(By.id("emailId")).sendKeys("thinkdifferent30@gmail.com");

 

      //Enter password

      driver.findElement(By.id("password")).sendKeys("8loversden");

 

      //Click 'Sign in using our secure server' button

      driver.findElement(By.className("btn signin-btn")).click();

 
      //Verify 'Your Account' button contains the name of the user

      assert (driver.findElement(By.id("myAccountHeaderLink")).getText().contains("Hello Guest"));

 

      //Hover over a "Your account" button and click on "Sign Out"

      Actions action = new Actions(driver);

      action.moveToElement(driver.findElement(By.id("signOutHeaderLink"))).perform();

      driver.findElement(By.linkText("Not Automat...? Sign Out")).click();

 

      //Verify "Sign In" form appear
      assert (driver.findElement(By.name("signIn")) .isDisplayed());

   }

}
}

   
