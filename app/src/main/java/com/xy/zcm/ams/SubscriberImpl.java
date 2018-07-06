package com.xy.zcm.ams;

import com.xy.zcm.ams.http.ResponseBean;
import com.xy.zcm.ams.http.RetrofitApi.ReqListener;

import rx.Subscriber;

/**
 * 订阅者实现类
 * Created by ZCM on 2018-06-289:14.
 */

public class SubscriberImpl extends Subscriber<ResponseBean> {

    private int flag;
    private ReqListener listener;

    public SubscriberImpl(int flag, ReqListener listener) {
        this.flag = flag;
        this.listener = listener;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        listener.onError(e, flag);
    }

    @Override
    public void onNext(ResponseBean responseBean) {
        listener.onSuccess(responseBean, flag);
    }
}
