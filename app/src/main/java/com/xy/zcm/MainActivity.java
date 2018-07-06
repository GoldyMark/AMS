package com.xy.zcm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.xy.zcm.ams.R;
import com.xy.zcm.ams.SubscriberImpl;
import com.xy.zcm.ams.http.ResponseBean;
import com.xy.zcm.ams.http.RetrofitApi.ApiFactory;
import com.xy.zcm.ams.http.RetrofitApi.ReqListener;
import com.xy.zcm.ams.http.RetrofitApi.RequestService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ReqListener {

    private TextView tv0;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv0 = findViewById(R.id.tv0);
        tv1 = findViewById(R.id.tv1);

        RequestService reqService = ApiFactory.getRequestService();
        req(this, reqService.updateRequest(), 0);

        Map<String, Object> params = new HashMap<>();
        params.put("page", 0);
        params.put("name", 0);
        req(this, reqService.getPastProductsListRequest(params), 1);

    }


    private void req(ReqListener listener, Observable<ResponseBean> observable, int flag) {
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new SubscriberImpl(flag, listener));
    }

    @Override
    public void onSuccess(ResponseBean response, int flag) {
        try {
            String result = response.getResult();
            JSONObject resultJOB = new JSONObject(result);
            switch (flag) {
                case 0:// 版本更新
                    tv0.setText(resultJOB + "");
                    String appName = resultJOB.optString("appName");
                    String createTime = resultJOB.optString("createTime");
                    String createTimeFormat = resultJOB.optString("createTimeFormat");
                    Log.e("resultContent0", "appName == " + appName + "\ncreateTime == " +
                        createTime + "\ncreateTimeFormat == " + createTimeFormat);
                    break;
                case 1:// 往期产品
                    tv1.setText(resultJOB + "");
                    break;
            }
            Log.i("resultString", "===resultString===" + result);
            Log.i("resultObject", "===resultObject===" + resultJOB);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onError(Throwable e, int flag) {
        Toast.makeText(this, "网络错误!", Toast.LENGTH_LONG).show();
    }
}
