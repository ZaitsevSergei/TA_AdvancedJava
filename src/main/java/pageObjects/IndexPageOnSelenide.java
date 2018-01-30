package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.elements.UserEnum;
import enums.indexPageEnums.BenefitsTextsEnum;
import enums.indexPageEnums.ServiceContentEnum;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

/**
 * page object of index page
 */
public class IndexPageOnSelenide {

    // button to show login form
    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFormButton;

    // user's login field
    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    // user's password field
    @FindBy(css = "#Password")
    private SelenideElement passordInput;

    // button to user log in
    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    // element displays user name
    @FindBy(css = ".profile-photo span")
    private SelenideElement userName;

    // list of benefits icons
    @FindBy(css = ".icons-benefit")
    private ElementsCollection benefitsIcons;

    // list of texts under benefits icons
    @FindBy(css = ".benefit-txt")
    private ElementsCollection benefitsTexts;

    // header text
    @FindBy(css = ".main-title")
    private SelenideElement header;

    // main text
    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    // service link in left-side menu
    @FindBy(css = ".sub-menu a[href='page1.htm']")
    private SelenideElement serviceSideMenuLink;

    // service link in header menu
    @FindBy(css = ".dropdown a[href='page1.htm']")
    private SelenideElement serviceHeaderLink;

    // elements in service category in left-side menu
    @FindBy(css = ".sub a")
    private ElementsCollection serviceSideMenuElements;

    // elements in service category in header menu
    @FindBy(css = ".dropdown-menu a")
    private ElementsCollection serviceHeaderElements;

    // link to different elements page
    @FindBy(css = ".dropdown-menu a[href='page8.htm']")
    private SelenideElement differentElementsLink;

    // link to dates page
    @FindBy(css = ".dropdown-menu a[href='page4.htm']")
    private SelenideElement datesLink;

    // perform login action
    public void login(UserEnum login) {
        try {
            // open login form
            loginFormButton.click();

            // fill form and submit data
            loginInput.sendKeys(login.getLogin());
            passordInput.sendKeys(login.getPassword());
            submitButton.click();
        }
        catch (ElementNotVisibleException e) {
            // user already loggined. Check userName
            System.out.println("blabla");
            checkUserName(login);
        }

    }

    // check user name
    public void checkUserName(UserEnum user) {
        // Assert User name is visible
        userName.shouldHave(text(user.getUserName()));
    }

    // check benefits icons count
    public void checkBenefitsIconsCount(int expectedCount) {
        assertEquals(benefitsIcons.size(), expectedCount);
    }

    // check benefits texts
    public void checkBenefitsTexts(BenefitsTextsEnum[] expectedTexts) {
        for (int i = 0; i < benefitsIcons.size(); i++) {
            benefitsTexts.get(i).shouldHave(text(expectedTexts[i].toString()));
        }
    }

    // check header text
    public void checkHeader(String expectedHeaderText) {
        header.shouldHave(text(expectedHeaderText));
    }

    // check main text
    public void checkMainText(String expectedMainText) {
        mainText.shouldHave(text(expectedMainText));
    }

    // check elements in service category in header menu
    public void checkHeaderServiceContent(ServiceContentEnum[] expectedServiceContent) {
        // click on link
        serviceHeaderLink.click();

        // check content
        for (int i = 0; i < serviceHeaderElements.size(); i++) {
            serviceHeaderElements.get(i).shouldHave(text(expectedServiceContent[i].toString()));
        }
    }

    // check elements in service category in left-side menu
    public void checkSideMenuServiceContent(ServiceContentEnum[] expectedServiceContent) {
        // click on link
        serviceSideMenuLink.click();

        // check content
        for (int i = 0; i < serviceSideMenuElements.size(); i++) {
            serviceSideMenuElements.get(i).shouldHave(text(expectedServiceContent[i].toString()));
        }
    }

    // navigate to different elements page from header
    public DifferentElementsPage navigateToDifferentElementsPage() {
        // click on menu
        serviceHeaderLink.click();
        // navigate to page
        differentElementsLink.click();
        // return page object of page
        return Selenide.page(DifferentElementsPage.class);
    }

    // navigate to dates page
    public DatesPage navigateToDatesPage() {
        // click on menu
        serviceHeaderLink.click();
        // navigate to page
        datesLink.click();
        // return page object of page
        return Selenide.page(DatesPage.class);
    }
}