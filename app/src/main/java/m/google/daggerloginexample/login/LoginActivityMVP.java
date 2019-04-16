package m.google.daggerloginexample.login;

import m.google.daggerloginexample.model.User;

public interface LoginActivityMVP {

    interface View{

        String getFirstName();
        String getLastName();

        void  showNotAvailable();
        void  showError();
        void showSaveUser();

        void setFirstName(String name);
        void setLastName(String apellido);

    }

    interface Presenter{
        void setView(LoginActivityMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();


    }

    interface Model{

        void createUser(String name, String apellido);

        User getUser();

    }


}
