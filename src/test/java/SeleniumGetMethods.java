import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

/**
 * Provides methods to get data from elements*/
public class SeleniumGetMethods {

    /**
     * @param attribute attribute name
     * @param attributeValue value of element
     * */
    public static String getText(How attribute, String attributeValue)
    {
        WebElement webElement = WebDriverTools.findElement(attribute, attributeValue);
        return webElement.getAttribute("value");
    }
}
