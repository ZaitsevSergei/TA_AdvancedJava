package enums.elements;

public enum UserEnum {
    PITER_CHAILOVSKII("epam", "1234", "Piter Chailovskii"),
    PITER("epam", "1234", "blabla");


    private final String login;
    private final String password;
    private final String userName;

    UserEnum(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() { return userName; }
}
