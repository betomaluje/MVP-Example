package com.betomaluje.mvpexample.base;

/**
 * Created by betomaluje on 7/19/17.
 */

public abstract class BasePresenter<T extends BaseView, U extends BaseModel> {

    private T mView;
    private U mModel;

    public BasePresenter(T mView, U mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public T getView() {
        return mView;
    }

    public U getModel() {
        return mModel;
    }
}
