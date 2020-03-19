package com.example.myapplication.utils;

import com.example.myapplication.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtil {
    private final Retrofit retrofit;

    private NetUtil() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static class SingleHolder {
        private static final NetUtil UTIL = new NetUtil();
    }

    public static NetUtil getInstance() {
        return SingleHolder.UTIL;
    }

    public <T> T createService(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
