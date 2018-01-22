package enums.indexPageEnums;

public enum ServiceContentEnum {
    TEXT1("Support"),
    TEXT2("Dates"),
    TEXT3("Complex Table"),
    TEXT4("Simple Table"),
    TEXT5("Tables With Wages"),
    TEXT6("Different Elements");

    private final String text;

    ServiceContentEnum(String text) {
        this.text = text;

    }

    @Override
    public String toString() {
        return text;
    }
}
