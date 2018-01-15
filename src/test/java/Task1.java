import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

// Class for first task
public class Task1 {


    // 1. Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void TestJDIWebPageContent()
    {
        // maximize window
        WebDriverTools.driver.manage().window().maximize();
        // 3. Assert Browser title
        Assert.assertEquals(WebDriverTools.driver.getTitle(), "Index Page");

        // 4. Perform login
        // click on link to display login form
        //SeleniumSetMethods.click(How.XPATH, "//a[@href='#' AND @class='dropdown-toggle']");
        SeleniumSetMethods.click(How.XPATH, "//a[@href='#']");
        // Filling login form
        SeleniumSetMethods.enterText(How.ID, "Login", "epam");
        SeleniumSetMethods.enterText(How.ID, "Password", "1234");
        // Submit data
        SeleniumSetMethods.click(How.XPATH, "//button[@class='uui-button dark-blue btn-login']");

        // 5. Assert User name in the left-top side of screen that user is loggined
        // Assert User name is visible
        boolean userNamevisibility = WebDriverTools.findElement(How.XPATH, "//div[@class='profile-photo']//span").isDisplayed();
        Assert.assertEquals( userNamevisibility, true);
        // get User name
        String userName = SeleniumGetMethods.getTagInnerHTML(How.XPATH, "//div[@class='profile-photo']//span");
        Assert.assertEquals(userName, "Piter Chailovskii");

        // 6. Assert Browser title
        Assert.assertEquals(WebDriverTools.driver.getTitle(), "Index Page");

        WebDriverTools.driver.close();
    }

    // 2.Open test site by URL
    @BeforeTest
    public void setUpWebDriver()
    {
         // set web driver property
        setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        // create web driver instance
        WebDriverTools.driver = new ChromeDriver();
        // navigate to URL
        WebDriverTools.driver.navigate().to("https://jdi-framework.github.io/tests");
    }

}
