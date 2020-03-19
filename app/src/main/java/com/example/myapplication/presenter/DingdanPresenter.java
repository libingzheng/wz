package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.contract.DingdanContract;
import com.example.myapplication.model.DingdanModel;

import java.util.Map;

public class DingdanPresenter extends BasePresenter implements DingdanContract.DingdanPresenter {

    private DingdanModel dingdanModel;

    @Override
    public void requestLogin(Map<String, String> map) {

    }

    @Override
    public void requestRegister(Map<String, String> map) {

    }

    @Override
    public void dingdan() {
        new DingdanModel().dingdan(new DingdanContract.DingdanModel.DingdanCallBack() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(String s) {

            }
        });
    }
}
