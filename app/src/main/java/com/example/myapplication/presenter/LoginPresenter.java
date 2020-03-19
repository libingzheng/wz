package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.contract.Contract;
import com.example.myapplication.model.LoginModel;

import java.util.Map;

public class LoginPresenter extends BasePresenter {
    @Override
    public void requestLogin(Map<String, String> map) {
        new LoginModel().login(map, new Contract.LoginModel.LoginModelCallback() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(Throwable t) {
                getView().error(t);
            }
        });
    }

    @Override
    public void requestRegister(Map<String, String> map) {
        new LoginModel().register(map, new Contract.LoginModel.LoginModelCallback() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(Throwable t) {
                getView().error(t);
            }
        });
    }
}
