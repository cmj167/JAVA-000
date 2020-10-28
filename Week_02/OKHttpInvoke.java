package com.caimj.java.week02;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * OKHttp调用类 当前仅有get功能，可拓展post put delete等
 *
 * @author caimeijiao
 * @date 2020-10-27
 */
public class OKHttpInvoke {

    /**
     * get方式调用
     * @param url
     * @return
     * @throws IOException
     */
    public String getInvoke(String url) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(request);

        Response response = call.execute();
        if (response.code() == 200 ) {
            return response.body().string();
        } else {
            return String.format("接口[%s]调用异常，状态码：[%s]", url, response.code());
        }


    }
}
