package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class TestBase {

    public static WebDriver driver;
    public static String driverPath = ;
    @BeforeSuite
    public void setUp() {
        setProperty("webdriver.chrome.driver", framework.WebDriverTools.driverPath);
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
