package hw4;

import base.BaseSelenide;
import enums.datesEnums.SlidersPosition;
import enums.elements.UserEnum;
import listeners.AllureAttachmentListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DatesPage;
import pageObjects.IndexPageOnSelenide;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;

@Listeners(AllureAttachmentListener.class)
@Features({"TestCase2"})
@Stories({"Dates Page Test"})
public class DatesPageTest extends BaseSelenide {

    // Page Objects instances
    private IndexPageOnSelenide indexPage;
    private DatesPage datesPage;

    @BeforeClass(alwaysRun = true)
    public void setUpTest() {
        // 2. Open test site by URL
        indexPage = page(IndexPageOnSelenide.class);
        datesPage = page(DatesPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        close();
    }

    // 1. Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void DatesPageSlidersActionTest() {
        // 2.Open test site by URL
        indexPage.open();

        // 3. Perform login
        indexPage.login(UserEnum.PITER_CHAILOVSKII);

        // 4. Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserName(UserEnum.PITER_CHAILOVSKII);

        // 5. Open Service -> Dates
        indexPage.navigateToDatesPage();
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
