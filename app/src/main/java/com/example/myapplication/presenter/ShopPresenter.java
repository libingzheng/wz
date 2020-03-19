package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.contract.ShopContract;
import com.example.myapplication.model.ShopModel;

import java.util.Map;

public class ShopPresenter extends BasePresenter implements ShopContract.ShopPresenter {
    @Override
    public void requestLogin(Map<String, String> map) {

    }

    @Override
    public void requestRegister(Map<String, String> map) {

    }

    @Override
    public void success(Object o) {
        new ShopModel().show(new ShopContract.ShopModel.ShopCallBack() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(String s) {

            }
        });
    }

    @Override
    public void error(String s) {

    }
}
