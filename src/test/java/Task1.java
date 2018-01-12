import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        WebDriverTools.driver.close();

        // 4. 

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
