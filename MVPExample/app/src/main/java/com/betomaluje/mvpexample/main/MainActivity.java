package com.betomaluje.mvpexample.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.betomaluje.mvpexample.R;
import com.betomaluje.mvpexample.base.BasePresenter;
import com.betomaluje.mvpexample.base.BasePresenterActivity;

/**
 * Created by betomaluje on 8/3/17.
 */

public class MainActivity extends BasePresenterActivity {

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return new MainPresenter(
                new MainView(MainActivity.this, bus),
                new MainModel(bus)
        );
    }

    @NonNull
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
