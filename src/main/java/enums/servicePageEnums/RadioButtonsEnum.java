package enums.servicePageEnums;

public enum RadioButtonsEnum {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private final String text;

    RadioButtonsEnum(String text) {
        this.text = text;

    }

    @Override
    public String toString() {
        return text;
    }
}
