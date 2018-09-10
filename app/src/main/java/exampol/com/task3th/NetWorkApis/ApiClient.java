package exampol.com.task3th.NetWorkApis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alaa on 3/15/18.
 */

public class ApiClient {
    public static final String BASE_URL ="http://www.ourtest.somee.com/sitevisitapi/";


    public static Retrofit getClient(String baseUrl) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .setLenient()
                    .create();
            //change Time Out
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();
        return new Retrofit.
                Builder().
                baseUrl(baseUrl).client(okHttpClient).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
    }
}