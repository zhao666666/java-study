package com.example.java.day23;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 16:50
 * @Version: 1.0
 * @Description:
 */
public class DateDemo {
    public static void main(String[] args) {

        //opreateTime();
        //initCalendar();
        setTimeManually();
    }

    private static void setTimeManually() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(2020,1,10);
        SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
        System.out.println(a.format(cal.getTime()));

    }

    private static void initCalendar() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(10));
        System.out.println(sdf.format(cal.getTime()));
        cal.setTime(new Date());
        System.out.println(sdf.format(cal.getTime()));
    }

    private static void opreateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        // 对当前时间操作
        System.out.println(sdf.format(cal.getTime()));

        cal.add(Calendar.DAY_OF_MONTH,1);
        System.out.println(sdf.format(cal.getTime()));

        cal.add(Calendar.MINUTE,1);
        System.out.println(sdf.format(cal.getTime()));
    }
}
