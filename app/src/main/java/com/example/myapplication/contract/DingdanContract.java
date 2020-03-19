package com.example.myapplication.contract;

public interface DingdanContract {
    interface DingdanView{
        void success(Object o);
        void error(String s);
    }
    interface DingdanModel{
        void dingdan(DingdanCallBack callBack);
        interface DingdanCallBack{
            void success(Object o);
            void error(String s);
        }
    }
    interface DingdanPresenter{
        void dingdan();
    }
}
