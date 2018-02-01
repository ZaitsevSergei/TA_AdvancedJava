package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.datesEnums.SlidersPosition;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertEquals;

public class DatesPage {
    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all:nth-of-type(1)")
    private SelenideElement leftSlider;

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all:nth-of-type(2)")
    private SelenideElement rightSlider;

    @FindBy(css = ".uui-slider.blue")
    private SelenideElement sliderTrack;

    @FindBy(css = ".ui-slider-range")
    private SelenideElement sliderRange;

    @Step
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/page4.htm");
    }

    /**
     * Set sliders position
     */
    @Step
    public void setSlidersPosition(SlidersPosition slidersPosition) {
        // set left and right sliders position
        setSliderPosition(leftSlider, slidersPosition.getLeftSlider());
        setSliderPosition(rightSlider, slidersPosition.getRigthSlider());
        // check slider position and range
        checkSlidersPosition(slidersPosition);
    }

    // set position of specific slider
    private void setSliderPosition(SelenideElement slider, int desiredPosition) {
        // calculate desired slider position in pixels
        double desiredPositionPx = getPositionInPx(desiredPosition);
        // calculate current position in pixels
        double currentPosition = getCurrentPosition(slider);
        // calculate offset to move slider to desired position
        double offset = desiredPositionPx - currentPosition;

        // drag slider to desired position
        actions().dragAndDropBy(slider, (int) offset, 0).perform();

        // check position
        int currentPositionPct = Integer.parseInt(slider.getText());
        if (currentPositionPct > desiredPosition) {
            moveSliderByArrow(slider, Keys.ARROW_LEFT, desiredPosition);
        } else if (currentPosition < desiredPosition) {
            moveSliderByArrow(slider, Keys.ARROW_RIGHT, desiredPosition);
        }


    }

    // move slider to correct position by arrow
    private void moveSliderByArrow(SelenideElement slider, Keys arrow, int desiredPosition) {
        while (Integer.parseInt(slider.getText()) != desiredPosition) {
            slider.sendKeys(arrow);
        }
    }

    // convert position in percentage to pixels
    private double getPositionInPx(int positionPct) {
        return sliderTrack.getSize().width * positionPct / 100;
    }

    // check sliders position and range
    private void checkSlidersPosition(SlidersPosition slidersPosition) {
        // check positions
        int leftSliderPosition = slidersPosition.getLeftSlider();
        int rightSliderPosition = slidersPosition.getRigthSlider();
        assertEquals(leftSliderPosition, Integer.parseInt(leftSlider.getText()));
        assertEquals(rightSliderPosition, Integer.parseInt(rightSlider.getText()));

        //check range
        assertEquals(rightSliderPosition - leftSliderPosition,
                slidersPosition.getRigthSlider() - slidersPosition.getLeftSlider());
    }

    // get current slider position in pixels
    private double getCurrentPosition(SelenideElement slider) {
        String value = slider.getCssValue("left").replaceAll("px", "");
        return Double.parseDouble(value);
    }


}
