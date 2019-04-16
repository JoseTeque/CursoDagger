package m.google.daggerloginexample.login;


import android.support.annotation.Nullable;

import m.google.daggerloginexample.model.User;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {
   @Nullable
   private LoginActivityMVP.View view;
   private LoginActivityMVP.Model model;

   public LoginActivityPresenter(LoginActivityMVP.Model model)
   {
       this.model= model;
   }


    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
       if (view!=null)
       {
           if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals(""))
           {
               view.showError();
           }
           else {
               model.createUser(view.getFirstName().trim(),view.getLastName().trim());
               view.showSaveUser();
           }
       }

    }

    @Override
    public void getCurrentUser() {
        User user= model.getUser();

        if (user==null){

            if (view!=null)
            {
                view.showNotAvailable();
            }
        }else {
            if (view!=null){
                view.setFirstName(user.getName());
                view.setLastName(user.getApellido());
            }
        }

    }
}
