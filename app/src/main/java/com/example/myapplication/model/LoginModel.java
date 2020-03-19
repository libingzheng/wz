package com.example.myapplication.model;

import com.example.myapplication.api.ApiService;
import com.example.myapplication.contract.Contract;
import com.example.myapplication.entity.LoginBean;
import com.example.myapplication.utils.NetUtil;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements Contract.LoginModel {
    @Override
    public void login(Map<String, String> map, LoginModelCallback callback) {
        NetUtil.getInstance().createService(ApiService.class).login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        callback.success(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.error(throwable);
                    }
                });
    }

    @Override
    public void register(Map<String, String> map, LoginModelCallback callback) {
        NetUtil.getInstance().createService(ApiService.class).register(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        callback.success(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.error(throwable);
                    }
                });
    }
}
