package com.yanxing.weibo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 * Created by 李双祥 on 2016/12/25.
 */
public class TimeUtil {

    /**
     * 根据美国东部时间获取Calendar
     * @param americaTime Sun Dec 25 11:12:03 +0800 2016
     * @return
     */
   public static Calendar format(String americaTime){
       SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy"
               , Locale.US);
       try {
           Date date=dateFormat.parse(americaTime);
           Calendar calendar = Calendar.getInstance();
           calendar.setTime(date);
           return calendar;
       } catch (ParseException e) {
           e.printStackTrace();
       }
       return null;
   }

    /**
     * 和当前时间比较，多久以前,1小时以内返回多少分钟，超出一天，返回原时间
     *
     * @param calendar 要比较的时间  格式：2016/9/20 17:49:38
     * @return
     */
    public static String getTimeAgo(Calendar calendar) {
        long l = System.currentTimeMillis() - calendar.getTimeInMillis();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        if (day == 0) {
            if (hour == 0) {
                return ((min==0?"1":min )+ "分钟前");
            } else  {
                int hourTemp=calendar.get(Calendar.HOUR_OF_DAY);
                int minTemp=calendar.get(Calendar.MINUTE);
                return "今天 " +hourTemp +":"+(minTemp<10?"0"+minTemp:minTemp);
            }
        }else if (day==1){
            int hourTemp=calendar.get(Calendar.HOUR_OF_DAY);
            int minTemp=calendar.get(Calendar.MINUTE);
            return "昨天 " +hourTemp +":"+(minTemp<10?"0"+minTemp:minTemp);
        }else {
            int month=calendar.get(Calendar.MONTH)+1;
            int dayTemp=calendar.get(Calendar.DAY_OF_MONTH);
            int hourTemp=calendar.get(Calendar.HOUR_OF_DAY);
            int minTemp=calendar.get(Calendar.MINUTE);
            return month+"-"+dayTemp+" "+hourTemp+":"+(minTemp<10?"0"+minTemp:minTemp);
        }
    }
}
