package com.betomaluje.mvpexample.base;

import com.betomaluje.mvpexample.network.NetworkService;
import com.squareup.otto.Bus;

/**
 * Created by betomaluje on 8/3/17.
 */

public abstract class BaseModel {

    protected Bus bus;
    protected NetworkService networkService;

    public BaseModel(Bus bus) {
        this.bus = bus;
        networkService = NetworkService.getInstance();
    }
}
