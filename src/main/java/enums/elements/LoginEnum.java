package enums.elements;

public enum LoginEnum {
    EPAM("epam", "1234");


    private final String login;
    private final String password;

    LoginEnum(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
