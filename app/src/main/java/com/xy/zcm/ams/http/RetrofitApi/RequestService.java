package com.xy.zcm.ams.http.RetrofitApi;


import com.xy.zcm.ams.http.ResponseBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 网络请求服务类
 * Created by Administrator on 2016/12/14 0014.
 */
public interface RequestService {


    String URL_SERVER = "http://mock.eolinker.com/" +
        "fI12rn1ff05f994e3f73d8107c2d8fff212a662831dbe06?uri=";
//    String URL_SERVER = "http://result.eolinker.com/" +
//        "fI12rn1ff05f994e3f73d8107c2d8fff212a662831dbe06?uri=";


    @POST(URL_SERVER + "app/homeAct.html")
    Observable<ResponseBean> initRequest();

    @POST(URL_SERVER + "app/update.html")
    Observable<ResponseBean> updateRequest();

//    @POST(URL_SERVER + "app/pastproject")
//    Observable<ResponseBean> getPastProductsListRequest();

    @FormUrlEncoded
    @POST(URL_SERVER + "app/pastproject")
    Observable<ResponseBean> getPastProductsListRequest(@FieldMap Map<String, Object> params);


    @POST(URL_SERVER + "app/update.html&resultType=failure")
    Observable<ResponseBean> updateFailRequest();

    @FormUrlEncoded
    @POST(URL_SERVER + "app/update.html&resultType=failure")
    Observable<ResponseBean> getPastProductsListFailRequest(@FieldMap Map<String, Object> params);

}
