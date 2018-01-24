package enums.elements;

public enum SelectedEnum {
    SELECTED(true),
    UNSELECTED(false);


    private final boolean state;

    SelectedEnum(boolean state) {
        this.state = state;
    }

    public boolean toBoolean() {
        return state;
    }
}
