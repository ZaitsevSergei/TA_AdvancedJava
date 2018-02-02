package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class TestBase {

    public WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "windows-drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}
