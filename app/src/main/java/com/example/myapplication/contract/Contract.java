package com.example.myapplication.contract;

import java.util.Map;

public interface Contract {
    interface LoginView {
        void success(Object o);

        void error(Throwable t);
    }
    interface LoginModel {
        void login(Map<String, String> map, LoginModelCallback callback);

        void register(Map<String, String> map, LoginModelCallback callback);

        interface LoginModelCallback {
            void success(Object o);

            void error(Throwable t);
        }
    }

    interface LoginPresenter {
        void requestLogin(Map<String, String> map);

        void requestRegister(Map<String, String> map);
    }
}
