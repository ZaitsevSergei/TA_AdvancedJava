import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Provides method to work with web driver
public class WebDriverTools {

    public static WebElement findElement(WebDriver driver, How attribute, String attributeValue)
    {
        try
        {
            // Find method from By class with reflection by the name that after will be used if FindElement method of web driver instance
            Method findByMethod = By.class.getMethod(String.valueOf(attribute));
            // Find the control by the element value and put test string into control
            return driver.findElement((By)findByMethod.invoke(null, new Object[]{(Object)attributeValue}));
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
