package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Provides method to work with web driver
 */
public class WebDriverTools {
    public static WebDriver driver;
    public static String driverPath = "windows-drivers/chromedriver.exe";

    /**
     * find first web element matches attribute
     *
     * @param attribute      attribute name
     * @param attributeValue value of element
     */
    public static WebElement findElement(How attribute, String attributeValue) {
        try {
            String methodName = getByClassMethodName(attribute);
            // Find method from By class with reflection by the name that after will be used if FindElement method of web driver instance
            Method findByMethod = By.class.getMethod(methodName, String.class);
            // Find the control by the element value and put test string into control

            return driver.findElement((By) findByMethod.invoke(null, attributeValue));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * find web elements with matching attributes
     *
     * @param attribute      attribute name
     * @param attributeValue value of element
     */
    public static List<WebElement> findElements(How attribute, String attributeValue) {
        try {
            String methodName = getByClassMethodName(attribute);
            // Find method from By class with reflection by the name that after will be used if FindElement method of web driver instance
            Method findByMethod = By.class.getMethod(methodName, String.class);
            // Find the control by the element value and put test string into control

            return driver.findElements((By) findByMethod.invoke(null, attributeValue));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    // gets method name of By class using How enum
    private static String getByClassMethodName(How attribute) {
        // to lower case
        String name = String.valueOf(attribute).toLowerCase();
        if (name == "css") {
            return "cssSelector";
        }
        // find '_' index
        int index;
        if ((index = name.indexOf('_')) != -1) {
            // changing next character to uupper case
            char charToChange = name.charAt(index + 1);
            StringBuilder stringBuilder = new StringBuilder(name);
            stringBuilder.setCharAt(index + 1, Character.toUpperCase(charToChange));
            // delete '_' character
            name = stringBuilder.deleteCharAt(index).toString();
        }

        return name;

    }
}
