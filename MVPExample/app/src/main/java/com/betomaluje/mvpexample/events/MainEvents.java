package com.betomaluje.mvpexample.events;

import com.betomaluje.mvpexample.models.Pokemon;

/**
 * Created by betomaluje on 8/3/17.
 */

public class MainEvents {

    public static class OnRandomClicked {

    }

    public static class OnRandomPokemonStarted {

    }

    public static class OnRandomPokemonReceived {
        public Pokemon pokemon;

        public OnRandomPokemonReceived(Pokemon pokemon) {
            this.pokemon = pokemon;
        }
    }

    public static class OnRandomPokemonFailed {
        public String error;

        public OnRandomPokemonFailed(String error) {
            this.error = error;
        }
    }

}
