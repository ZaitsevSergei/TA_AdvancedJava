import base.BaseSelenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import listeners.AllureAttachmentListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Login tests"})
public class SelenideTest extends BaseSelenide {

    @AfterMethod
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void loginTest1() {
        open("https://www.epam.com");
        assertEquals(getWebDriver().getTitle(), "EPAM | Software Product Development Services");

        $(".header-search__button").click();

        SelenideElement menuButton = $(".hamburger-menu__button");
        menuButton.click();
        menuButton.should(visible);

        menuButton.should(text("MENU"));
    }

    @Test
    public void loginTest2() {
        open("https://www.epam.com");
        assertEquals(getWebDriver().getTitle(), "EPAM | Software Product Development Services");

        $(".header-search__butto").click();

        SelenideElement menuButton = $(".hamburger-menu__button");
        menuButton.click();
        menuButton.should(visible);

        menuButton.should(text("MENU"));
    }

    @Test
    public void loginTest3() {
        open("https://www.epam.com");
        assertEquals(getWebDriver().getTitle(), "EPAM | Software Product Development Services");

        $(".header-search__button").click();

        SelenideElement menuButton = $(".hamburger-menu__button");
        menuButton.click();
        menuButton.should(visible);

        menuButton.should(text("MENU"));
    }
}
