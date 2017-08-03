package com.betomaluje.mvpexample;

import com.squareup.otto.Bus;

/**
 * Created by betomaluje on 6/13/17.
 */

public class BusManager {

    private Bus bus;

    private static volatile BusManager instance = null;

    private BusManager() {
        bus = new Bus();
    }

    public static Bus getInstance() {
        if (instance == null) {    // check 1
            synchronized (BusManager.class) {
                if (instance == null) {    // check 2
                    instance = new BusManager();
                }
            }
        }
        return instance.getBus();
    }

    private Bus getBus() {
        return bus;
    }
}
