package m.google.daggerloginexample.http.interfaces;

import io.reactivex.Observable;
import m.google.daggerloginexample.http.interfaces.TwitchGame.TwitchGame;
import m.google.daggerloginexample.http.interfaces.twitchStream.TwitchStream;
import m.google.daggerloginexample.http.interfaces.twitchTop.ResponseTwitch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TwitchInterface {

    @GET("games/top")
    Call<ResponseTwitch> getTwitch(@Header("Client-Id") String clientid);

    @GET("games")
    Observable<TwitchGame> getTwitchGame(@Header("Client-Id") String clienid, @Query("id") String id );

    @GET("games/top")
    Observable<ResponseTwitch> getTwitchObservable(@Header("Client-Id") String clientId);

    @GET("streams")
    Observable<TwitchStream> getTwichStreamsObservable(@Header("Client-Id") String cliendId);

}
