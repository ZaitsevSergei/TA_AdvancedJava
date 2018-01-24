package enums.elements;

public enum  UserName {
    PITER_CHAILOVSKII("Piter Chailovskii");

    private final String text;

    UserName(String text) {
        this.text = text;

    }

    @Override
    public String toString() {
        return text;
    }
}
