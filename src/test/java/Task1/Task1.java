package Task1;

import Framework.SeleniumGetMethods;
import Framework.SeleniumSetMethods;
import Framework.WebDriverTools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

// Class for first task
public class Task1 {


    // 1. Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void TestLoginPage()
    {
        // maximize window
        WebDriverTools.driver.manage().window().maximize();
        // 3. Assert Browser title
        assertEquals(WebDriverTools.driver.getTitle(), "Index Page");

        // 4. Perform login
        performLogin();

        // 5. Assert User name in the left-top side of screen that user is loggined
        assertUserName();

        // 6. Assert Browser title
        assertEquals(WebDriverTools.driver.getTitle(), "Index Page");

        // 7. Assert that there are 4 images on the Home Page and they are displayed
        assertImagesOnPage();

        // 8. Assert that there are 4 texts on the Home Page and check them by getting texts
        assertTextsOnPage();

        // 9. Assert that there are the main header and the text below it on the Home Page
        assertHeaderAndMainTexts();
        WebDriverTools.driver.close();
    }

    // 4. Perform login
    private void performLogin()
    {
        // click on link to display login form
        //SeleniumSetMethods.click(How.XPATH, "//a[@href='#' AND @class='dropdown-toggle']");
        SeleniumSetMethods.click(How.XPATH, "//a[@href='#']");
        // Filling login form
        SeleniumSetMethods.enterText(How.ID, "Login", "epam");
        SeleniumSetMethods.enterText(How.ID, "Password", "1234");
        // Submit data
        SeleniumSetMethods.click(How.XPATH, "//button[@class='uui-button dark-blue btn-login']");
    }

    // 5. Assert User name in the left-top side of screen that user is logged
    private void assertUserName()
    {
        // Assert User name is visible
        boolean userNamevisibility = WebDriverTools.findElement(How.XPATH, "//div[@class='profile-photo']//span").isDisplayed();
        assertEquals( userNamevisibility, true);
        // get User name
        String userName = SeleniumGetMethods.getTagInnerHTML(How.XPATH, "//div[@class='profile-photo']//span");
        assertEquals(userName, "Piter Chailovskii");
    }

    // 7. Assert that there are 4 images on the Home Page and they are displayed
    private void assertImagesOnPage()
    {
        // get list of images
        List<WebElement> images = WebDriverTools.findElements(How.XPATH, "//div[@class='benefit-icon']//span");
        int count = images.size();
        assertEquals(count, 4);
    }

    // 8. Assert that there are 4 texts on the Home Page and check them by getting texts
    private void assertTextsOnPage()
    {
        // get list of texts
        List<String> textWebElements = SeleniumGetMethods.getListOfElementsInnerText(How.XPATH,
                                                                                    "//span[@class='benefit-txt']");
        String[] assertTexts = {"To include good practices\nand ideas from successful\nEPAM projec",
                                "To be flexible and\ncustomizable",
                                "To be multiplatform",
                                "Already have good base\n(about 20 internal and\nsome external projects),\n" +
                                "wish to get more…"
                                };
        // assert texts
        for(int i = 0; i < assertTexts.length; i++)
        {
            assertEquals(textWebElements.get(i), assertTexts[i]);
        }

    }

    // 7. Assert that there are the main header and the text below it on the Home Page
    private void assertHeaderAndMainTexts()
    {
        // get header text
        String headerText = SeleniumGetMethods.getTagInnerText(How.XPATH, "//div[@class='main-content']//h3");
        String assertHeaderText = "EPAM FRAMEWORK WISHES…";
        assertEquals(headerText, assertHeaderText);

        // get main text
        String mainText = SeleniumGetMethods.getTagInnerText(How.XPATH, "//div[@class='main-content']//p");
        String assertMainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        assertEquals(mainText, assertMainText);
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
