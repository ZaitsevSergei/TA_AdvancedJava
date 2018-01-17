package Task2.Exercise2;

import Framework.SeleniumGetMethods;
import Framework.WebDriverTools;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SmokeAndRegressionTests {

    @BeforeMethod(alwaysRun = true)
    public void setUpWebDriver() {
        // set web driver property
        setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        // create web driver instance
        WebDriverTools.driver = new ChromeDriver();
        // navigate to URL
        WebDriverTools.driver.navigate().to("https://jdi-framework.github.io/tests");
        WebDriverTools.driver.manage().window().maximize();
    }

    @Test(groups = {"smoke"})
    public void textsOnPageTest() {
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
        for (int i = 0; i < assertTexts.length; i++) {
            assertEquals(textWebElements.get(i), assertTexts[i]);
        }
    }

    @Test(groups = {"regression"})
    public void headerAndMainTextsTest() {
        // get header text
        String headerText = SeleniumGetMethods.getTagInnerText(How.XPATH, "//div[@class='main-content']//h3");
        String assertHeaderText = "EPAM FRAMEWORK WISHES…";
        assertEquals(headerText, assertHeaderText);

        // get main text
        String mainText = SeleniumGetMethods.getTagInnerText(How.XPATH, "//div[@class='main-content']//p");
        String assertMainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        assertEquals(mainText, assertMainText);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverTools.driver.close();
    }
}
