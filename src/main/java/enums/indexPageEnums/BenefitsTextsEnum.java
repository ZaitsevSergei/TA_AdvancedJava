package enums.indexPageEnums;

public enum BenefitsTextsEnum {
    TEXT1("To include good practices\nand ideas from successful\nEPAM projec"),
    TEXT2("To be flexible and\ncustomizable"),
    TEXT3("To be multiplatform"),
    TEXT4("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    private final String text;

    BenefitsTextsEnum(String text) {
        this.text = text;

    }

    @Override
    public String toString() {
        return text;
    }
}
