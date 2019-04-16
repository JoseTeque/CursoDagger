package m.google.daggerloginexample.login;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import m.google.daggerloginexample.R;
import m.google.daggerloginexample.http.interfaces.TwitchGame.DataItemGame;
import m.google.daggerloginexample.http.interfaces.TwitchGame.TwitchGame;
import m.google.daggerloginexample.http.interfaces.TwitchInterface;
import m.google.daggerloginexample.http.interfaces.twitchStream.DataItemStreams;
import m.google.daggerloginexample.http.interfaces.twitchStream.TwitchStream;
import m.google.daggerloginexample.http.interfaces.twitchTop.DataItem;
import m.google.daggerloginexample.http.interfaces.twitchTop.ResponseTwitch;
import m.google.daggerloginexample.root.App;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    @Inject
    TwitchInterface twitchInterface;

    @BindView(R.id.IdEdtxNombre)
    EditText edtxName;

    @BindView(R.id.IdEdtxApellido)
    EditText edtxApellido;

    @BindView(R.id.IdButton)
    Button btnLogin;

    @BindString(R.string.app_name)
    String name_app;

    @BindDrawable(R.drawable.ic_launcher_background)
    Drawable Image;

    @BindColor(R.color.colorPrimary)
    ColorStateList ColorFace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((App) getApplicationContext()).getComponent().inject(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });

        //Ejemplo de uso de la api de twitch con retrofit
 /* Call<ResponseTwitch> call= twitchInterface.getTwitch("78iv2426a62op27tuxl2ov2iqrtw39");
        call.enqueue(new Callback<ResponseTwitch>() {
            @Override
            public void onResponse(Call<ResponseTwitch> call, Response<ResponseTwitch> response) {
                List<DataItem> data= response.body().getData();

                for (DataItem item: data){
                    System.out.println("Nombre: " + item.getName());
                }
            }

            @Override
            public void onFailure(Call<ResponseTwitch> call, Throwable t) {
                t.getMessage();
            }
        });


        Call<TwitchGame> callGame = twitchInterface.getTwitchGame("78iv2426a62op27tuxl2ov2iqrtw39","Dota 2");

        callGame.enqueue(new Callback<TwitchGame>() {
            @Override
            public void onResponse(Call<TwitchGame> call, Response<TwitchGame> response) {
                List<DataItemGame> list= response.body().getData();

                for (DataItemGame data: list){
                    System.out.println(data.getId());
                    System.out.println(data.getName());
                    System.out.println(data.getBoxArtUrl());
                }
            }

            @Override
            public void onFailure(Call<TwitchGame> call, Throwable t) {

            }
        }); */

    /*    twitchInterface.getTwitchObservable("78iv2426a62op27tuxl2ov2iqrtw39").flatMap(new Function<ResponseTwitch, ObservableSource<DataItem>>() {
            @Override
            public ObservableSource<DataItem> apply(ResponseTwitch responseTwitch) {
                return Observable.fromIterable(responseTwitch.getData());
            }
        }).flatMap(new Function<DataItem, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(DataItem dataItem) {
                return Observable.just(dataItem.getName());
            }
        }).filter(new Predicate<String>() {
            @Override
            public boolean test(String s)  {
                return s.contains("w");
            }
        })
                .subscribeOn(Schedulers.io())//Schedulers.io() es la entrada y salida de datos de rxjava
                .observeOn(AndroidSchedulers.mainThread())// para que la subscripcion se haga en hilo pricipal es decir se rellene la vista
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String name) {
                        System.out.println("Name the Game : " + name);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                }); */


    twitchInterface.getTwichStreamsObservable("78iv2426a62op27tuxl2ov2iqrtw39").flatMap(new Function<TwitchStream, ObservableSource<DataItemStreams>>() {
        @Override
        public ObservableSource<DataItemStreams> apply(TwitchStream twitchStream) {
            return Observable.fromIterable(twitchStream.getData());
        }
    }).flatMap(new Function<DataItemStreams, ObservableSource<String>>() {
        @Override
        public ObservableSource<String> apply(DataItemStreams dataItemStreams) throws Exception {
            return Observable.just(dataItemStreams.getGameId());
        }
    })            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<String>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(String id) {

                 twitchInterface.getTwitchGame("78iv2426a62op27tuxl2ov2iqrtw39", id).flatMap(new Function<TwitchGame, ObservableSource<DataItemGame>>() {
                     @Override
                     public ObservableSource<DataItemGame> apply(TwitchGame twitchGame){
                         return Observable.fromIterable(twitchGame.getData());
                     }
                 }).flatMap(new Function<DataItemGame, ObservableSource<String>>() {
                     @Override
                     public ObservableSource<String> apply(DataItemGame dataItemGame) throws Exception {
                         return Observable.just(dataItemGame.getName());
                     }
                 }).subscribeOn(Schedulers.io())
                         .observeOn(AndroidSchedulers.mainThread())
                         .subscribe(new Observer<String>() {
                             @Override
                             public void onSubscribe(Disposable d) {

                             }

                             @Override
                             public void onNext(String s) {
                               System.out.println("Id es: "+ id +" Name es: " + s);
                             }

                             @Override
                             public void onError(Throwable e) {

                             }

                             @Override
                             public void onComplete() {

                             }
                         });
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });


    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return this.edtxName.getText().toString();
    }

    @Override
    public String getLastName() {
        return this.edtxApellido.getText().toString();
    }

    @Override
    public void showNotAvailable() {
        Toast.makeText(this, "El usuario no esta disponible", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error, Ingrese Nombre y Apellido..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSaveUser() {
        Toast.makeText(this, "Usuario Guardado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String name) {
        this.edtxName.setText(name);
    }

    @Override
    public void setLastName(String apellido) {
        this.edtxApellido.setText(apellido);

    }
}
