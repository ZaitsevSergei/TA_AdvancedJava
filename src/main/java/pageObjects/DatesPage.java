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
     * Set sliders position*/
    public void setSlidersPosition(SlidersPosition slidersPosition) {
        // set left and right sliders position
        setSliderPosition(leftSlider, slidersPosition.getLeftSlider());
        setSliderPosition(rightSlider, slidersPosition.getRigthSlider());
        // check slider position and range
        checkSlidersPosition(slidersPosition);
    }

    // set position of specific slider
    private void setSliderPosition(SelenideElement slider, int position) {
        int xOffset = (position - getCurrentPosition(slider)) * getStep();
        actions().dragAndDropBy(slider, xOffset, 0).perform();
    }

    // check sliders position and range
    private void checkSlidersPosition(SlidersPosition slidersPosition) {
        // check positions
        int leftSliderPosition = getSliderPositionInPersentage(leftSlider);
        int rightSliderPosition = getSliderPositionInPersentage(rightSlider);
        assertEquals(leftSliderPosition, slidersPosition.getLeftSlider());
        assertEquals(rightSliderPosition, slidersPosition.getRigthSlider());

        //check range
        assertEquals(rightSliderPosition - leftSliderPosition,
                slidersPosition.getRigthSlider() - slidersPosition.getLeftSlider());
    }

    /**
     * Get step value in pixels
     */
    private Integer getStep() {
        return sliderTrack.getSize().width / 100;
    }

    /**
     * Get current position of slider
     */
    private int getCurrentPosition(SelenideElement slider) {

        int sliderCenterPx = getSliderPositionInPersentage(slider) + slider.getSize().width / 2;

        return sliderCenterPx / getStep() + 1;
    }

    // get current slider position in persentage
    private int getSliderPositionInPersentage(SelenideElement slider) {
        String value = slider.getCssValue("left").replaceAll("px", "");
        return (int) Double.parseDouble(value);
    }


}
