package m.google.daggerloginexample.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public    LoginActivityMVP.Presenter providesPresenter(LoginActivityMVP.Model model){
        return  new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model providesModel(LoginActivityRepository repository){
        return new LoginActivityModel(repository);
    }

    @Provides
    public LoginActivityRepository providesRepository(){
        return new MemoryRepository(); //cambiaar aqui si queremos un reposi en momoria a una base de datos, firebase
    }

}
