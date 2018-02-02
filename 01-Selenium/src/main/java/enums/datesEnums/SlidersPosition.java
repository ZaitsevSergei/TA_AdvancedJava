package enums.datesEnums;

public enum SlidersPosition {
    MAX_RANGE(0, 100),
    MIN_RANGE(0, 0),
    MIN_RANGE2(100, 100),
    CUSTOM1(30, 70);

    private final int leftSlider;
    private final int rigthSlider;

    SlidersPosition(int leftSlider, int rigthSlider) {

        this.leftSlider = leftSlider;
        this.rigthSlider = rigthSlider;
    }

    public int getLeftSlider() {
        return leftSlider;
    }

    public int getRigthSlider() {
        return rigthSlider;
    }
}
