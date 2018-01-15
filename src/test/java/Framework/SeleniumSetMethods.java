package Framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

public class SeleniumSetMethods {

    /**
     * Test method to put text into text control
     * @param attribute attribute name
     * @param attributeValue value of element
     */
    public static void enterText(How attribute, String attributeValue, String testValue)
    {
        WebElement webElement = WebDriverTools.findElement(attribute, attributeValue);
        webElement.sendKeys(testValue);
    }

    /**
     * Test method on the specified control
     * @param attribute attribute name
     * @param attributeValue value of element
     */
    public static void click(How attribute, String attributeValue)
    {
        WebElement webElement = WebDriverTools.findElement(attribute, attributeValue);
        webElement.click();
    }
}

