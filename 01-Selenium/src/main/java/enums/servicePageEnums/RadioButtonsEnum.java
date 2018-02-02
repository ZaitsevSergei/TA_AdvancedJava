package enums.servicePageEnums;

public enum RadioButtonsEnum {
    GOLD("Gold", 0),
    SILVER("Silver", 1),
    BRONZE("Bronze", 2),
    SELEN("Selen", 3);

    private final String text;
    private final int index;

    RadioButtonsEnum(String text, int index) {
        this.text = text;
        this.index = index;

    }

    @Override
    public String toString() {
        return text;
    }

    public int toInt() {
        return index;
    }
}
