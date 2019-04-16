package m.google.daggerloginexample.login;

import org.junit.Before;
import org.junit.Test;

import m.google.daggerloginexample.model.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class LoginActivityPresenterTest {

    LoginActivityPresenter presenter;
    User user;

    LoginActivityMVP.View mockitView;
    LoginActivityMVP.Model mockitModel;


    @Before
    public void init(){
        mockitView= mock(LoginActivityMVP.View.class);
        mockitModel= mock(LoginActivityMVP.Model.class);

        user= new User("Pablo", "Escobar");

      //  when(mockitModel.getUser()).thenReturn(user);

       // when(mockitView.getFirstName()).thenReturn("Antonio");
       // when(mockitView.getLastName()).thenReturn("Bandera");

        presenter= new LoginActivityPresenter(mockitModel);
        presenter.setView(mockitView);

    }


    @Test
    public void noExistInteractionWithView(){
        presenter.getCurrentUser();
        verify(mockitView, times(1)).showNotAvailable();
    }

    @Test
    public void loadUserFromTheRepoWhenValidUserThisPresent(){

     when(mockitModel.getUser()).thenReturn(user);

     presenter.getCurrentUser();

     verify(mockitModel,times(1)).getUser();

     verify(mockitView,times(1)).setFirstName("Pablo");
     verify(mockitView,times(1)).setLastName("Escobar");

     verify(mockitView,never()).showNotAvailable();
    }


    @Test
    public void showErrorMessage(){

        when(mockitModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        verify(mockitModel,times(1)).getUser();

        verify(mockitView,never()).setFirstName("Pablo");
        verify(mockitView,never()).setLastName("Escobar");

        verify(mockitView,times(1)).showNotAvailable();
    }

    @Test
    public void createShowMessageErrorIfAnyFileEmpty(){
        //Primera prueba colocando en firstname vacio
        when(mockitView.getFirstName()).thenReturn("");

        presenter.loginButtonClicked();

        verify(mockitView,times(1)).getFirstName();
        verify(mockitView,never()).getLastName();
        verify(mockitView,times(1)).showError();

        //segunda prueba colocando el firstname con un valor y getlasname vacio
        when(mockitView.getFirstName()).thenReturn("Pablo");
        when(mockitView.getLastName()).thenReturn("");
        presenter.loginButtonClicked();

        verify(mockitView,times(2)).getFirstName();//el metodo se llama 2 veces, una en la prueba anterior y una en la actual
        verify(mockitView,times(1)).getLastName();
        verify(mockitView,times(2)).showError();

    }

    @Test
    public void SaveValidUser(){

        when(mockitView.getFirstName()).thenReturn("jose");
        when(mockitView.getLastName()).thenReturn("guerra");

        presenter.loginButtonClicked();

        verify(mockitView,times(2)).getFirstName();
        verify(mockitView,times(2)).getLastName();

        verify(mockitModel,times(1)).createUser("jose","guerra");

        verify(mockitView,times(1)).showSaveUser();
    }
}