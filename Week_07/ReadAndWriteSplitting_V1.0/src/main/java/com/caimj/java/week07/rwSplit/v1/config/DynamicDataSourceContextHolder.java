package com.caimj.java.week07.rwSplit.v1.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源上下文.
 */
public class DynamicDataSourceContextHolder {
    /*
     * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /*
     * 管理所有的数据源id;
     * 主要是为了判断数据源是否存在;
     */
    public static Map<String, String> mapDataSource = new HashMap<>();

    public static void setDataSourceType(String dataSourceId) {
        contextHolder.set(dataSourceId);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

}
