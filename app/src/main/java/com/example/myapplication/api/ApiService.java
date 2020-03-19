package com.example.myapplication.api;

import com.example.myapplication.entity.DingdanBean;
import com.example.myapplication.entity.LoginBean;
import com.example.myapplication.entity.ShopBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiService {
    @POST(Api.login)
    Observable<LoginBean> login(@QueryMap Map<String, String> map);

    @POST(Api.register)
    Observable<LoginBean> register(@QueryMap Map<String, String> map);

    @GET(Api.shop)
    Observable<ShopBean> shop();

    @GET(Api.dingdan)
    Observable<DingdanBean> dingdan();
}
