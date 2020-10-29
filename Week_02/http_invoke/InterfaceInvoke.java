package com.caimj.java.week02;

import java.io.IOException;

/**
 * 通过http和okhttp方式访问http://localhost:8801/
 *
 * @author caimeijiao
 * @date 2020-10-27
 */
public class InterfaceInvoke {

    public static final String URL = "http://localhost:8801/";
    public static void main(String[] args) {

        try {
            //http 调用
            HttpClientInvoke httpClient = new HttpClientInvoke();

            long start = System.currentTimeMillis();
            String result1 = httpClient.getInvoke(URL);
            long end = System.currentTimeMillis();
            System.out.println(String.format("HTTP get方法调用耗时: %s 毫秒, 返回结果: %s", (end-start), result1));


            Thread.sleep(10000);

            //okhttp 调用
            OKHttpInvoke okHttpClient = new OKHttpInvoke();

            start = System.currentTimeMillis();
            String result2 = okHttpClient.getInvoke(URL);
            end = System.currentTimeMillis();
            System.out.println(String.format("OKHttp get方法调用耗时: %s 毫秒, 返回结果: %s", (end-start), result2));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
