package com.betomaluje.mvpexample.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.betomaluje.mvpexample.R;
import com.betomaluje.mvpexample.base.BaseView;
import com.betomaluje.mvpexample.events.MainEvents;
import com.betomaluje.mvpexample.models.Pokemon;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by betomaluje on 8/3/17.
 */

public class MainView extends BaseView<MainActivity> {

    @BindView(R.id.imageView_pokemon)
    ImageView imageViewPokemon;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.textView_result)
    TextView textViewResult;

    @BindView(R.id.button_getRandomPokemon)
    Button buttonGetRandomPokemon;

    public MainView(MainActivity activity, Bus bus) {
        super(activity, bus);
    }

    public void setPokemonData(Pokemon pokemon) {
        MainActivity activity = getActivity();

        if (activity != null) {
            textViewResult.setText(pokemon.getId() + ": " + pokemon.getName());

            if (!TextUtils.isEmpty(pokemon.getImageUrl())) {
                Picasso.with(activity)
                        .load(pokemon.getImageUrl())
                        .into(imageViewPokemon);
            }
        }
    }

    public void displayErrorMessage(String message) {
        MainActivity activity = getActivity();

        if (activity == null) {
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        // Add the buttons
        builder.setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.setMessage(message);
        builder.setTitle("Error Title");

        builder.create().show();
    }

    public void hideUI() {
        imageViewPokemon.setVisibility(View.INVISIBLE);
        textViewResult.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        ViewCompat.setAlpha(buttonGetRandomPokemon, 0.4f);
        buttonGetRandomPokemon.setEnabled(false);
    }

    public void showUI() {
        imageViewPokemon.setVisibility(View.VISIBLE);
        textViewResult.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

        ViewCompat.setAlpha(buttonGetRandomPokemon, 1f);
        buttonGetRandomPokemon.setEnabled(true);
    }

    @OnClick(R.id.button_getRandomPokemon)
    public void onRandomPokemonClicked() {
        bus.post(new MainEvents.OnRandomClicked());
    }

}
