import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeTest;

import static java.lang.System.setProperty;

// Class for first task
public class Task1 {


    // 1. Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void TestJDIWebPageContent()
    {
        // 3. Assert Browser title
        Assert.assertEquals(WebDriverTools.driver.getTitle(), "Index Page");



        // 4. Perform login
        // click on link to display login form
        SeleniumSetMethods.click(How.CLASS_NAME, "dropdown-toggle");
        // Filling login form
        SeleniumSetMethods.enterText(How.ID, "Login", "epam");
        SeleniumSetMethods.enterText(How.ID, "Password", "1234");
        // Submit data
        SeleniumSetMethods.click(How.CLASS_NAME, "uui-button dark-blue btn-login");

        WebDriverTools.driver.close();
    }

    // 2.Open test site by URL
    @Before
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
