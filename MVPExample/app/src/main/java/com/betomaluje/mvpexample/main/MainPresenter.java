package com.betomaluje.mvpexample.main;

import com.betomaluje.mvpexample.base.BasePresenter;
import com.betomaluje.mvpexample.events.MainEvents;
import com.squareup.otto.Subscribe;

/**
 * Created by betomaluje on 8/3/17.
 */

public class MainPresenter extends BasePresenter<MainView, MainModel> {

    public MainPresenter(MainView mView, MainModel mModel) {
        super(mView, mModel);
    }

    @Subscribe
    public void onRandomPokemonClicked(MainEvents.OnRandomClicked randomClicked) {
        getModel().getRandomPokemon();
    }

    @Subscribe
    public void onRandomPokemonStarted(MainEvents.OnRandomPokemonStarted randomPokemonStarted) {
        getView().hideUI();
    }

    @Subscribe
    public void onRandomPokemonReceived(MainEvents.OnRandomPokemonReceived randomPokemonReceived) {
        getView().setPokemonData(randomPokemonReceived.pokemon);
        getView().showUI();
    }

    @Subscribe
    public void onRandomPokemonFailed(MainEvents.OnRandomPokemonFailed randomPokemonFailed) {
        getView().showUI();
        getView().displayErrorMessage(randomPokemonFailed.error);
    }
}
