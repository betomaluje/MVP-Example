package com.betomaluje.mvpexample.main;

import com.betomaluje.mvpexample.base.BaseModel;
import com.betomaluje.mvpexample.events.MainEvents;
import com.betomaluje.mvpexample.models.Pokemon;
import com.squareup.otto.Bus;

import java.io.IOException;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by betomaluje on 8/3/17.
 */

public class MainModel extends BaseModel {

    public MainModel(Bus bus) {
        super(bus);
    }

    public void getRandomPokemon() {
        bus.post(new MainEvents.OnRandomPokemonStarted());

        Random random = new Random();

        Call<Pokemon> call = networkService.getRandomPokemon(random.nextInt(151));
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    bus.post(new MainEvents.OnRandomPokemonReceived(response.body()));
                } else {
                    try {
                        bus.post(new MainEvents.OnRandomPokemonFailed(response.errorBody().string()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                bus.post(new MainEvents.OnRandomPokemonFailed(t.getMessage()));
            }
        });
    }
}
