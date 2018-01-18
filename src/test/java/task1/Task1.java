package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// Class for first task
public class Task1 {

    WebDriver driver;
    String driverPath = "windows-drivers/chromedriver.exe";

    // 2.Open test site by URL
    @BeforeTest
    public void setUpWebDriver() {
        // set web driver property
        setProperty("webdriver.chrome.driver", driverPath);
        // create web driver instance
        driver = new ChromeDriver();
        // navigate to URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    // 1. Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void testLoginAction() {
        // maximize window
        driver.manage().window().maximize();
        // 3. Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        // 4. Perform login
        performLogin();

        // 5. Assert User name in the left-top side of screen that user is loggined
        checkUserName();

        // 6. Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        // 7. Assert that there are 4 images on the Home Page and they are displayed
        checkImagesOnPage();

        // 8. Assert that there are 4 texts on the Home Page and check them by getting texts
        checkTextsOnPage();

        // 9. Assert that there are the main header and the text below it on the Home Page
        checkHeaderAndMainTexts();
        driver.close();
    }

    // 4. Perform login
    private void performLogin() {
        // click on link to display login form
        driver.findElement(By.xpath("//a[@href='#']")).click();
        // Filling login form
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        // Submit data
        driver.findElement(By.xpath("//button[@class='uui-button dark-blue btn-login']")).click();
    }

    // 5. Assert User name in the left-top side of screen that user is logged
    private void checkUserName() {
        // Assert User name is visible
        boolean userNameVisibility = driver.findElement(By.xpath("//div[@class='profile-photo']//span")).isDisplayed();
        assertTrue(userNameVisibility);
        // get User name
        String userName = driver.findElement(By.xpath("//div[@class='profile-photo']//span")).getAttribute("innerHTML");
        assertEquals(userName, "Piter Chailovskii");
    }

    // 7. Assert that there are 4 images on the Home Page and they are displayed
    private void checkImagesOnPage() {
        // get list of images
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='benefit-icon']//span"));
        int count = images.size();
        assertEquals(count, 4);
    }

    // 8. Assert that there are 4 texts on the Home Page and check them by getting texts
    private void checkTextsOnPage() {
        // get list of text elements
        List<WebElement> textWebElements = driver.findElements(By.xpath("//span[@class='benefit-txt']"));
        String[] assertTexts = {"To include good practices\nand ideas from successful\nEPAM projec",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\n" +
                        "wish to get more…"
        };
        // assert texts
        for (int i = 0; i < assertTexts.length; i++) {
            assertEquals(textWebElements.get(i).getText(), assertTexts[i]);
        }

    }

    // 7. Assert that there are the main header and the text below it on the Home Page
    private void checkHeaderAndMainTexts() {
        // get header text
        String headerText = driver.findElement(By.xpath("//div[@class='main-content']//h3")).getText();
        String assertHeaderText = "EPAM FRAMEWORK WISHES…";
        assertEquals(headerText, assertHeaderText);

        // get main text
        String mainText = driver.findElement(By.xpath("//div[@class='main-content']//p")).getText();
        String assertMainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        assertEquals(mainText, assertMainText);
    }

}
