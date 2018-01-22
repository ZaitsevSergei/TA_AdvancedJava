package enums.servicePageEnums;

public enum CheckboxesEnum {
    WATER("Water"),
    ERTH("Erth"),
    WIND("Wind"),
    FIRE("Fire");

    private final String text;

    CheckboxesEnum(String text) {
        this.text = text;

    }

    @Override
    public String toString() {
        return text;
    }
}
