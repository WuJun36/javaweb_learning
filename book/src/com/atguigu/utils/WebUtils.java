package com.atguigu.utils;

public class WebUtils {

    /**
     * 将字符串转化为Int类型的数据
     * @param strInt
     * @param defaultInt
     * @return
     */
    public static int parseInt(String strInt,int defaultInt){

        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {

        }
        return defaultInt;
    }
}
