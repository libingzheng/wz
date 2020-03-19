package com.example.myapplication.model;

import com.example.myapplication.api.ApiService;
import com.example.myapplication.contract.DingdanContract;
import com.example.myapplication.entity.DingdanBean;
import com.example.myapplication.utils.NetUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DingdanModel implements DingdanContract.DingdanModel {
    @Override
    public void dingdan(DingdanCallBack callBack) {
        ApiService apiService = NetUtil.getInstance().createService(ApiService.class);
        Observable<DingdanBean> dingdan = apiService.dingdan();
        dingdan.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DingdanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DingdanBean dingdanBean) {
                        callBack.success(dingdanBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
