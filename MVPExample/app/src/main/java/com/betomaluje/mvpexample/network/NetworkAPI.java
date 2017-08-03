package com.betomaluje.mvpexample.network;

import com.betomaluje.mvpexample.models.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by betomaluje on 6/23/17.
 */

public interface NetworkAPI {

    @GET("pokemon/{id}")
    Call<Pokemon> getRandomPokemon(@Path("id") int pokemonId);

}
