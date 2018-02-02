package task2.exercise3;

import framework.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise3 {
    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        setProperty("webdriver.chrome.driver", WebDriverTools.driverPath);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite(){
        if(driver.toString().contains("null"))
        {
            driver.quit();
        }
    }

    @BeforeTest(alwaysRun = true)
    public void setUpTests()
    {
        driver = new ChromeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void tearDownTest()
    {
        driver.close();
    }

    @BeforeMethod
    public void setUpBeforeMethod()
    {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.epam.com");
        System.out.println(driver.getTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        System.out.println(System.currentTimeMillis());
    }

    @Test(groups = {"smoke"})
    public void test1() {
        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");

        WebElement searchButton = driver.findElement(By.cssSelector(".header-search__button"));
        searchButton.click();

        WebElement menuButton = driver.findElement(By.cssSelector(".hamburger-menu__button"));

        assertTrue(menuButton.isDisplayed());
        assertEquals(menuButton.getText(), "MENU");
    }
}
