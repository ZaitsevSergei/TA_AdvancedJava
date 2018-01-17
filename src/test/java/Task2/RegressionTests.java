package Task2;

import Framework.WebDriverTools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class RegressionTests {

    @BeforeMethod(alwaysRun = true)
    public void setUpWebDriver() {
        // set web driver property
        setProperty("webdriver.chrome.driver", WebDriverTools.driverPath);
        // create web driver instance
        WebDriverTools.driver = new ChromeDriver();
        // navigate to URL
        WebDriverTools.driver.navigate().to("https://jdi-framework.github.io/tests");
        WebDriverTools.driver.manage().window().maximize();
    }

    @Test(groups = {"regression"})
    public void indexPageTitleTest() {
        // maximize window
        WebDriverTools.driver.manage().window().maximize();
        // 3. Assert Browser title
        assertEquals(WebDriverTools.driver.getTitle(), "Index Page");
    }

    @Test(groups = {"regression"})
    public void imagesTest() {
        // get list of images
        List<WebElement> images = WebDriverTools.findElements(How.XPATH, "//div[@class='benefit-icon']//span");
        int count = images.size();
        assertEquals(count, 4);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverTools.driver.close();
    }
}
