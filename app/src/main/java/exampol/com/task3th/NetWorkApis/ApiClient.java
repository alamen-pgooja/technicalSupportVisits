package exampol.com.task3th.NetWorkApis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alaa on 3/15/18.
 */

public class ApiClient {
    public static final String BASE_URL ="http://www.ourtest.somee.com/sitevisitapi/";

    public static Retrofit getClient(String baseUrl) {
            Gson gson = new GsonBuilder()
                    .setLenient().setLenient()
                    .create();
        return new Retrofit.
                Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
    }
}