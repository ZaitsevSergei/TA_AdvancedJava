import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

/**
 * Provides methods to get data from elements*/
public class SeleniumGetMethods {

    /**
     * Gets value of input tag
     * @param attribute attribute name
     * @param attributeValue value of element
     * */
    public static String getInputValue(How attribute, String attributeValue)
    {
        WebElement webElement = WebDriverTools.findElement(attribute, attributeValue);
        return webElement.getAttribute("value");
    }

    /**
     * Gets element's inner html
     * @param attribute attribute name
     * @param attributeValue value of element
     * */
    public static String getTagInnerHTML(How attribute, String attributeValue)
    {
        WebElement webElement = WebDriverTools.findElement(attribute, attributeValue);
        return webElement.getAttribute("innerHTML");
    }

    /**
     * Gets element's inner html
     * @param attribute attribute name
     * @param attributeValue value of element
     * */
    public static String getTagInnerText(How attribute, String attributeValue)
    {
        WebElement webElement = WebDriverTools.findElement(attribute, attributeValue);
        return webElement.getText();
    }

}
