package hw4;

import base.BaseSelenide;
import enums.datesEnums.SlidersPosition;
import enums.elements.UserEnum;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DatesPage;
import pageObjects.IndexPageOnSelenide;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(AllureAttachmentListener.class)
@Features({"TestCase2"})
@Stories({"Dates Page Test"})
public class TestCase2 extends BaseSelenide {

    @BeforeMethod
    public void setUpMethod() {
        if (getWebDriver() != null) {
            getWebDriver().close();
        }
    }

    // 1. Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void DatesPageSlidersActionTest() {
        // 2. Open test site by URL
        IndexPageOnSelenide page = open("https://jdi-framework.github.io/tests", IndexPageOnSelenide.class);

        // 3. Perform login
        page.login(UserEnum.PITER_CHAILOVSKII);

        // 4. Assert User name in the left-top side of screen that user is loggined
        page.checkUserName(UserEnum.PITER_CHAILOVSKII);

        // 5. Open Service -> Dates
        DatesPage datesPage = page.navigateToDatesPage();
        // 6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setSlidersPosition(SlidersPosition.MAX_RANGE);

        // 7. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.setSlidersPosition(SlidersPosition.MIN_RANGE);

        // 8. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setSlidersPosition(SlidersPosition.MIN_RANGE2);

        // 9. Using drag-and-drop set Range sliders. left - 30, right - 70
        datesPage.setSlidersPosition(SlidersPosition.CUSTOM1);
    }
}
