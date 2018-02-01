package pageObjects;

import enums.elements.UserEnum;
import enums.indexPageEnums.BenefitsTextsEnum;
import enums.indexPageEnums.HeaderTextEnum;
import enums.indexPageEnums.MainTextEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

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

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    private String pageTitle = "Index Page";

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();
    }

    @Step
    public void checkTitle() {
        Assert.assertEquals(pageTitle, driver.getTitle());
    }

    @Step
    public void login(UserEnum user) {
        loginFormButton.click();

        loginInput.sendKeys(user.getLogin());
        passordInput.sendKeys(user.getPassword());
        submitButton.click();
    }

    @Step
    public void checkUserName(UserEnum user) {
        // Assert User name is visible
        boolean userNameVisibility = driver.findElement(By.cssSelector(".profile-photo span")).isDisplayed();
        assertTrue(userNameVisibility);
        // get User name
        String userName = driver.findElement(By.cssSelector(".profile-photo span")).getAttribute("innerHTML");
        assertEquals(userName, user.getUserName());
    }

    @Step
    public void checkBenefitsIconsCount(int expectedCount) {
        int displayedCount = 0;
        for (WebElement benefitIcon : benefitsIcons) {
            if (benefitIcon.isDisplayed()) {
                displayedCount++;
            }
        }
        assertEquals(expectedCount, displayedCount);
    }

    @Step
    public void checkBenefitsTexts(BenefitsTextsEnum[] expectedTexts) {
        for (int i = 0; i < benefitsIcons.size(); i++) {
            assertTrue(benefitsTexts.get(i).isDisplayed());
            assertEquals(expectedTexts[i].toString(), benefitsTexts.get(i).getText());
        }
    }

    @Step
    public void checkHeader(HeaderTextEnum expectedHeaderText) {
        assertEquals(expectedHeaderText.toString(), header.getText());
    }

    @Step
    public void checkMainText(MainTextEnum expectedMainText) {
        assertEquals(expectedMainText.toString(), mainText.getText());
    }
}
