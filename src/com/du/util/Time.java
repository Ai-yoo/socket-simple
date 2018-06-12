package com.du.util;

import java.text.SimpleDateFormat;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/6/12
 * @Time 14:59
 */
public class Time {
    public static String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(System.currentTimeMillis());
    }
}
