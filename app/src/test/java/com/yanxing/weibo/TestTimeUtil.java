package com.yanxing.weibo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 李双祥 on 2016/12/25.
 */
public class TestTimeUtil {

    @Test
    public void testTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy"
                , Locale.US);
        try {
            Date date=dateFormat.parse("Sun Dec 25 11:12:03 +0800 2016");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            System.out.println(calendar.get(Calendar.YEAR));
            System.out.println(calendar.get(Calendar.MONTH)+1);
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
