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
     * @param calendar
     * @return
     */
    public static String getTimeAgo(Calendar calendar) {
        Calendar currentCalendar = Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH)+1;
        int dayTemp=calendar.get(Calendar.DAY_OF_MONTH);
        int hourTemp=calendar.get(Calendar.HOUR_OF_DAY);
        int minTemp=calendar.get(Calendar.MINUTE);
        //今年
        if (currentCalendar.get(Calendar.YEAR)==calendar.get(Calendar.YEAR)){
            if ((currentCalendar.get(Calendar.MONTH)+1)==month){
                if (dayTemp==currentCalendar.get(Calendar.DAY_OF_MONTH)){//今天的
                    long c=currentCalendar.getTimeInMillis()-calendar.getTimeInMillis();
                    long min=c/1000/60;
                    if (min>=60){
                        return "今天 " +hourTemp +":"+(minTemp<10?"0"+minTemp:minTemp);
                    }else {
                        return ((min==0?"1":min )+ "分钟前");
                    }
                }else if ((dayTemp+1)==(currentCalendar.get(Calendar.DAY_OF_MONTH))){
                    return "昨天 " +hourTemp +":"+(minTemp<10?"0"+minTemp:minTemp);
                }else {
                    return month+"-"+dayTemp+" "+hourTemp+":"+(minTemp<10?"0"+minTemp:minTemp);
                }
            }else {
                return month+"-"+dayTemp+" "+hourTemp+":"+(minTemp<10?"0"+minTemp:minTemp);
            }
        }else {
            return calendar.get(Calendar.YEAR)+"-"+month+"-"+dayTemp+" "+hourTemp+":"+(minTemp<10?"0"+minTemp:minTemp);
        }
    }

    /**
     * 格式化时间
     *
     * @param calendar
     * @return
     */
    public static String getTimeDetail(Calendar calendar) {
        Calendar currentCalendar = Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH)+1;
        int dayTemp=calendar.get(Calendar.DAY_OF_MONTH);
        int hourTemp=calendar.get(Calendar.HOUR_OF_DAY);
        int minTemp=calendar.get(Calendar.MINUTE);
        //今年
        if (currentCalendar.get(Calendar.YEAR)==calendar.get(Calendar.YEAR)){
            return month+"-"+dayTemp+" "+hourTemp+":"+(minTemp<10?"0"+minTemp:minTemp);
        }else {
            return calendar.get(Calendar.YEAR)+"-"+month+"-"+dayTemp+" "+hourTemp+":"+(minTemp<10?"0"+minTemp:minTemp);
        }
    }
}
