package com.caimj.java.week02;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

/**
 * Http调用类 当前仅有get功能，可拓展post put delete等
 *
 * @author caimeijiao
 * @date 2020-10-27
 */
public class HttpClientInvoke {

    public String getInvoke(String url) throws IOException {

        GetMethod getMethod = new GetMethod(url);
        // 设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

        HttpClient httpClient = new HttpClient();
        int statusCode = httpClient.executeMethod(getMethod);
        if (statusCode == HttpStatus.SC_OK) {
            return getMethod.getResponseBodyAsString();
        } else {
            return String.format("接口[%s]调用异常，状态码：[%s]", url, statusCode);
        }

    }
}
