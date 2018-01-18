package task2.exercise1;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise1 extends TestBase {
    // simple comment to try merge into master
    List<WebElement> texts;

    @DataProvider(parallel = true)
    private Object[][] textsDP() {
        return new Object[][]
                {
                        {0, "To include good practices\nand ideas from successful\nEPAM projec"},
                        {1, "To be flexible and\ncustomizable"},
                        {2, "To be multiplatform"},
                        {3, "Already have good base\n(about 20 internal and\nsome external projects),\n" +
                                "wish to get more…"}
                };
    }

    @BeforeTest
    public void setUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        texts = driver.findElements(By.xpath("//span[@class='benefit-txt']"));
    }

    @Test(dataProvider = "textsDP", threadPoolSize = 4)
    public void TestIndexPageTexts(int index, String assertString) {
        System.out.println(index);
        assertEquals(texts.get(index).getText(), assertString);
    }


}
