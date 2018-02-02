package enums.servicePageEnums;

public enum DropdownEnum {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private final String text;

    DropdownEnum(String text) {
        this.text = text;

    }

    @Override
    public String toString() {
        return text;
    }
}
