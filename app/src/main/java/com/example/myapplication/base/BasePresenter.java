package com.example.myapplication.base;

import com.example.myapplication.contract.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseActivity> implements Contract.LoginPresenter {
    protected WeakReference<V> v;

    protected void attachView(V v) {
        this.v = new WeakReference<>(v);
    }

    protected void detachView() {
        v.clear();
        v = null;
    }

    protected V getView() {
        return v.get();
    }
}
