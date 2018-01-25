package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.datesEnums.SlidersPosition;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.actions;
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

    /**
     * Set sliders position
     */
    public void setSlidersPosition(SlidersPosition slidersPosition) {
        // set left and right sliders position
        setSliderPosition(leftSlider, slidersPosition.getLeftSlider());
        setSliderPosition(rightSlider, slidersPosition.getRigthSlider());
        // check slider position and range
        checkSlidersPosition(slidersPosition);
    }

    // set position of specific slider
    private void setSliderPosition(SelenideElement slider, int position) {
        double positionPx = getPositionOnPx(position);
        double currentPosition = getCurrentPosition(slider);
        double offset = positionPx - currentPosition;
        int xOffset;
        if (offset < 0) {
            xOffset = (int) Math.floor(offset);
        } else {
            xOffset = (int) Math.ceil(offset);
        }
        actions().dragAndDropBy(slider, xOffset, 0).perform();
    }

    // get position in pixels appropriate position in percentage
    private double getPositionOnPx(int positionPct) {
        return sliderTrack.getSize().width * positionPct / 100;
    }

    // check sliders position and range
    private void checkSlidersPosition(SlidersPosition slidersPosition) {
        // check positions
        double leftSliderPosition = getPositionOnPx(slidersPosition.getLeftSlider());
        double rightSliderPosition = getPositionOnPx(slidersPosition.getRigthSlider());
        assertEquals(leftSliderPosition, getPositionOnPx(slidersPosition.getLeftSlider()));
        assertEquals(rightSliderPosition, getPositionOnPx(slidersPosition.getRigthSlider()));

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
