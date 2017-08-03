package com.betomaluje.mvpexample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by betomaluje on 6/23/17.
 */

public class NetworkService {

    private static volatile NetworkService instance = null;

    private static String baseUrl = "http://pokeapi.co/api/v2/";
    private NetworkAPI networkAPI;

    private NetworkService() {
        this(baseUrl);
    }

    private NetworkService(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkAPI = retrofit.create(NetworkAPI.class);
    }

    private NetworkAPI getAPI() {
        return networkAPI;
    }

    /**
     * Retrieves the single instance of {@link NetworkService}
     *
     * @return the NetworkService instance
     */
    public static NetworkAPI getInstance() {
        if (instance == null) {    // check 1
            synchronized (NetworkService.class) {
                if (instance == null) {    // check 2
                    instance = new NetworkService();
                }
            }
        }
        return instance.getAPI();
    }
}
