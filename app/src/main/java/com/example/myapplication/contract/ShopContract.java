package com.example.myapplication.contract;

public interface ShopContract {
    interface ShopView{
        void success(Object o);
        void error(String s);
    }
    interface ShopModel{
        void show(ShopCallBack callBack);
        interface ShopCallBack{
            void success(Object o);
            void error(String s);
        }
    }
    interface ShopPresenter{
        void success(Object o);
        void error(String s);
    }
}
