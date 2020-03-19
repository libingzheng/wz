package com.example.myapplication.model;

import com.example.myapplication.api.ApiService;
import com.example.myapplication.contract.ShopContract;
import com.example.myapplication.entity.ShopBean;
import com.example.myapplication.utils.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShopModel implements ShopContract.ShopModel {
    @Override
    public void show(ShopCallBack callBack) {
        NetUtil.getInstance().createService(ApiService.class)
                .shop()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopBean shopBean) {
                        callBack.success(shopBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.error(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
