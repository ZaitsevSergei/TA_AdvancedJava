package task2.exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class RegressionTests {
    WebDriver driver;
    String driverPath = "windows-drivers/chromedriver.exe";

    @BeforeMethod(alwaysRun = true)
    public void setUpWebDriver() {
        // set web driver property
        setProperty("webdriver.chrome.driver", driverPath);
        // create web driver instance
        driver = new ChromeDriver();
        // navigate to URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = {"regression"})
    public void indexPageTitleTest() {
        // 3. Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");
    }

    @Test(groups = {"regression"})
    public void imagesTest() {
        // get list of images
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='benefit-icon']//span"));
        int count = images.size();
        assertEquals(count, 4);
    }


}
