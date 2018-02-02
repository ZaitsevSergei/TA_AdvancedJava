package enums.servicePageEnums;

public enum CheckboxesEnum {
    WATER("Water", 0),
    ERTH("Erth", 1),
    WIND("Wind", 2),
    FIRE("Fire", 3);

    private final String text;
    private final int index;

    CheckboxesEnum(String text, int index) {
        this.text = text;
        this.index = index;

    }

    @Override
    public String toString() {
        return text;
    }

    public  int toInt(){
        return index;
    }
}
