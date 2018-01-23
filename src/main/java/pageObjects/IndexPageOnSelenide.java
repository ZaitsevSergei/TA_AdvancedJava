package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.indexPageEnums.BenefitsTextsEnum;
import enums.indexPageEnums.ServiceContentEnum;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

/**
 * page object of index page
 */
public class IndexPageOnSelenide {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFormButton;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement userName;

    @FindBy(css = ".icons-benefit")
    private ElementsCollection benefitsIcons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection benefitsTexts;

    @FindBy(css = ".main-title")
    private SelenideElement header;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".sub-menu a[href='page1.htm']")
    private SelenideElement serviceSideMenuLink;

    @FindBy(css = ".dropdown a[href='page1.htm']")
    private SelenideElement serviceHeaderLink;

    @FindBy(css = ".sub a")
    private ElementsCollection serviceSideMenuElements;

    @FindBy(css = ".dropdown-menu a")
    private ElementsCollection serviceHeaderElements;

    @FindBy(css = ".dropdown-menu a[href='page8.htm']")
    private SelenideElement differentElementsOption;

    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests");

    }

    public void checkTitle(String expectedTitle) {
        Assert.assertEquals(getWebDriver().getTitle(), expectedTitle);
    }

    public void login(String name, String password) {
        loginFormButton.click();

        loginInput.sendKeys(name);
        passordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserName(String expectedUserName) {
        // Assert User name is visible
        userName.shouldHave(text(expectedUserName));
    }

    public void checkBenefitsIconsCount(int expectedCount) {
        assertEquals(benefitsIcons.size(), expectedCount);
    }

    public void checkBenefitsTexts(BenefitsTextsEnum[] expectedTexts) {
        for (int i = 0; i < benefitsIcons.size(); i++) {
            benefitsTexts.get(i).shouldHave(text(expectedTexts[i].toString()));
        }
    }

    public void checkHeader(String expectedHeaderText) {
        header.shouldHave(text(expectedHeaderText));

    }

    public void checkMainText(String expectedMainText) {
        mainText.shouldHave(text(expectedMainText));
    }

    public void checkHeaderServiceContent(ServiceContentEnum[] expectedServiceContent) {
        // click on link
        serviceHeaderLink.click();

        // check content
        for (int i = 0; i < serviceHeaderElements.size(); i++) {
            serviceHeaderElements.get(i).shouldHave(text(expectedServiceContent[i].toString()));
        }
    }

    public void checkSideMenuServiceContent(ServiceContentEnum[] expectedServiceContent) {
        // click on link
        serviceSideMenuLink.click();

        // check content
        for (int i = 0; i < serviceSideMenuElements.size(); i++) {
            serviceSideMenuElements.get(i).shouldHave(text(expectedServiceContent[i].toString()));
        }
    }

    public ServicePage navigateToDifferentElementsPage()
    {
        // click on menu
        serviceHeaderLink.click();
        // navigate to page
        differentElementsOption.click();
        // return page object of page
        return Selenide.page(ServicePage.class);
    }
}