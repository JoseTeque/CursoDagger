package m.google.daggerloginexample.login;

import m.google.daggerloginexample.model.User;

public interface LoginActivityRepository {

    void saveUser(User user);
    User getUser();
}
