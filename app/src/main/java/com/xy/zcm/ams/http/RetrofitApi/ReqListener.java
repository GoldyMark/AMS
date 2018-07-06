package com.xy.zcm.ams.http.RetrofitApi;

import com.xy.zcm.ams.http.ResponseBean;

/**
 * 网络请求监听器
 * Created by ZCM on 2018-01-23 10:28.
 */

public interface ReqListener {

    void onSuccess(ResponseBean response, int flag);

    void onError(Throwable e, int flag);
}
