package com.betomaluje.mvpexample.base;

import android.support.annotation.Nullable;

import com.squareup.otto.Bus;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;

/**
 * Created by betomaluje on 8/3/17.
 */

public abstract class BaseView<T extends BaseActivity> {

    protected Bus bus;
    private WeakReference<T> activityRef;

    public BaseView(T activity, Bus bus) {
        ButterKnife.bind(this, activity);

        this.bus = bus;
        this.activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public T getActivity() {
        return activityRef.get();
    }

}
