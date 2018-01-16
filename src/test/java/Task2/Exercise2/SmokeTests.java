package Task2.Exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests
{
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = {"smoke"})
    public void test1() {
        driver.manage().window().maximize();

        driver.navigate().to("https://www.epam.com");
        assertEquals(driver.getTitle() ,"EPAM | Software Product Development Services");

        WebElement searchButton = driver.findElement(By.cssSelector(".header-search__button"));
        searchButton.click();

        WebElement menuButton = driver.findElement(By.cssSelector(".hamburger-menu__button"));

        assertTrue(menuButton.isDisplayed());
        assertEquals(menuButton.getText(), "MENU");
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][]
                {
                        {1, "string1"},
                        {2, "string2"}
                };
    }

    @Test(dataProvider = "dp", groups = {"smoke"})
    public void dpTest(int i, String s) {
        System.out.println("int: " + i + " " + "String: " + s);
    }
}
