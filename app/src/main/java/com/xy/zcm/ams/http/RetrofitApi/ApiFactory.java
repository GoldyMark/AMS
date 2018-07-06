package com.xy.zcm.ams.http.RetrofitApi;

/**
 *
 * Created by Administrator on 2017/3/14 0014.
 */
public class ApiFactory {
    private static final Object moniter = new Object();
    private static RequestService requestService = null;


    public static RequestService getRequestService() {
        synchronized (moniter) {
            if (null == requestService) {
                requestService = new RetrofitFactory().getRequestService(RequestService.class);
            }
            return requestService;
        }
    }
}
