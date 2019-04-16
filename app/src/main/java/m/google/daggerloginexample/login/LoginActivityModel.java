package m.google.daggerloginexample.login;

import m.google.daggerloginexample.model.User;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginActivityRepository repository;

    public LoginActivityModel(LoginActivityRepository repository){
        this.repository= repository;
    }

    @Override
    public void createUser(String name, String apellido) {
        //logica de business
     repository.saveUser(new User(name,apellido));
    }

    @Override
    public User getUser() {

        //logica de business
        return repository.getUser();
    }
}
