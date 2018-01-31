package enums.indexPageEnums;

public enum HeaderTextEnum {
    TEXT1("EPAM FRAMEWORK WISHES…");

    private final String text;

    HeaderTextEnum(String text) {
        this.text = text;

    }

    @Override
    public String toString() {
        return text;
    }
}
