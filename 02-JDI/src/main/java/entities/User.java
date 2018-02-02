package entities;

import com.epam.commons.DataClass;

public class User extends DataClass {
    public String login;
    public String password;
    public String name;

    public User(String login, String password, String name){

        this.login = login;
        this.password = password;
        this.name = name;
    }

}
