package framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods to get data from elements
 */
public class SeleniumGetMethods {

    /**
     * Gets value of input tag
     *
     * @param attribute      attribute name
     * @param attributeValue value of element
     */
    public static String getInputValue(How attribute, String attributeValue) {
        WebElement webElement = WebDriverTools.findElement(attribute, attributeValue);
        return webElement.getAttribute("value");
    }

    /**
     * Gets element's inner html
     *
     * @param attribute      attribute name
     * @param attributeValue value of element
     */
    public static String getTagInnerHTML(How attribute, String attributeValue) {
        WebElement webElement = WebDriverTools.findElement(attribute, attributeValue);
        return webElement.getAttribute("innerHTML");
    }

    /**
     * Gets element's inner html
     *
     * @param attribute      attribute name
     * @param attributeValue value of element
     */
    public static String getTagInnerText(How attribute, String attributeValue) {
        WebElement webElement = WebDriverTools.findElement(attribute, attributeValue);
        return webElement.getText();
    }

    /**
     * Gets lists of texts of elements
     *
     * @param attribute      attribute name
     * @param attributeValue value of element
     */
    public static List<String> getListOfElementsInnerText(How attribute, String attributeValue) {
        // get text elements
        List<WebElement> webElements = WebDriverTools.findElements(attribute, attributeValue);
        // create list of text strings
        List<String> texts = new ArrayList<String>();

        // initilize list
        for (WebElement webElement : webElements) {
            texts.add(webElement.getText());
        }

        return texts;
    }
}
