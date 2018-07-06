package com.xy.zcm.ams.http.RetrofitApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Reterofit
 * Created by Administrator on 2016/12/26 0026.
 */
class RetrofitFactory {

    <T> T getRequestService(Class<T> clazz) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectTimeout(30000, TimeUnit.MILLISECONDS);

        builder.addInterceptor(chain -> {
            Request mRequest = chain.request().newBuilder()
                    .header("deviceType", "android")
                    .build();
            return chain.proceed(mRequest);
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.eolinker.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();

        return retrofit.create(clazz);
    }

}