package minhna.newmvp.base;

import android.app.Application;
import android.util.Log;

import retrofit.RestAdapter;

/**
 * Created by Administrator on 07-Jun-16.
 */
public class App extends Application {

    private static ServerAPI serverAPI;

    public static ServerAPI getServerAPI() {
        return serverAPI;
    }

    public static void buildServerAPI(){
        serverAPI = new RestAdapter.Builder()
                .setEndpoint(ServerAPI.ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        Log.v("Retrofit", message);
                    }
                })
                .build().create(ServerAPI.class);
    }
}
