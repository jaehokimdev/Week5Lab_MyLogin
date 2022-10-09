package models;

import models.User;

/**
 *
 * @author joekim
 */
public class AccountService {
    public User login(String username, String password) {
        User user = null;
        if (username.equals("abe") && password.equals("password")) {
            user = new User(username, password);
        }else if (username.equals("barb") && password.equals("password")) {
            user = new User(username, password);
        }
       return user;
    }
}