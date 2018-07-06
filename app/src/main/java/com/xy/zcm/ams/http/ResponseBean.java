/*******************************************************************************
 * Copyright (c) 2016.10.21 浙江钱美美金融信息服务有限公司版权所有
 ******************************************************************************/

package com.xy.zcm.ams.http;

import java.io.Serializable;

public class ResponseBean implements Serializable {

    private String code;
    private String message;
    private Object result;

    String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return String.valueOf(result);
    }

    void setResult(Object result) {
        this.result = result;
    }

}
