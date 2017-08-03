package com.betomaluje.mvpexample.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.betomaluje.mvpexample.BusManager;
import com.squareup.otto.Bus;

/**
 * Created by betomaluje on 8/3/17.
 */

public abstract class BasePresenterActivity<T extends BasePresenter> extends BaseActivity {

    protected Bus bus = BusManager.getInstance();
    protected T mPresenter;

    @NonNull
    protected abstract T getPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = getPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            BusManager.getInstance().register(mPresenter);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null) {
            BusManager.getInstance().unregister(mPresenter);
        }
    }
}