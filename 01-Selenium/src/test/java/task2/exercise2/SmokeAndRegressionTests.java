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

public class SmokeAndRegressionTests {
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
    public void tearDown() { driver.close(); }

    @Test(groups = {"smoke"})
    public void textsOnPageTest() {
        // get list of texts
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

    @Test(groups = {"regression"})
    public void headerAndMainTextsTest() {
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
