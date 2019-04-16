package m.google.daggerloginexample.root;

import javax.inject.Singleton;

import dagger.Component;
import m.google.daggerloginexample.http.interfaces.TwitchModule;
import m.google.daggerloginexample.login.LoginActivity;
import m.google.daggerloginexample.login.LoginModule;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, TwitchModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);

}
