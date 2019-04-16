package m.google.daggerloginexample.root;

import android.app.Application;

import m.google.daggerloginexample.http.interfaces.TwitchModule;
import m.google.daggerloginexample.login.LoginModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component= DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .twitchModule(new TwitchModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
