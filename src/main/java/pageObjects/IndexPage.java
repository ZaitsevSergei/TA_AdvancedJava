package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * page object of index page
 */
public class IndexPage {

    private final WebDriver driver;

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> benefitsIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitsTexts;

    @FindBy(css = ".main-title")
    private WebElement header;

    @FindBy(css = ".main-title")
    private WebElement mainText;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    public void login(String name, String password) {
        loginFormButton.click();

        loginInput.sendKeys(name);
        passordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserName(String expectedUserName) {
        // Assert User name is visible
        boolean userNameVisibility = driver.findElement(By.cssSelector(".profile-photo span")).isDisplayed();
        assertTrue(userNameVisibility);
        // get User name
        String userName = driver.findElement(By.cssSelector(".profile-photo span")).getAttribute("innerHTML");
        assertEquals(expectedUserName, userName);
    }

    public void checkBeniftsIConsCount(int expectedCount)
    {
        assertEquals(expectedCount, benefitsIcons.size());
    }

    public void checkBenefitsTexts(String[] expectedTexts){
        for (int i = 0; i < benefitsIcons.size(); i++) {
            assertEquals(expectedTexts[i], benefitsTexts.get(i).getText());
        }
    }
}
