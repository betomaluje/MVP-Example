package com.betomaluje.mvpexample.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by betomaluje on 6/23/17.
 */

public interface NetworkAPI {

    @GET("cities")
    Call<List<String>> getCities();

}
