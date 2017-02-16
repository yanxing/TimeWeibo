package com.yanxing.weibo;

import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.util.ParamsUtil;
import com.yanxing.weibo.weiboapi.CommentsApi;
import com.yanxing.weibo.weiboapi.interceptor.FixedParameterInterceptor;
import com.yanxing.weibo.weiboapi.model.CreateComment;

import org.junit.Test;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {

//        String REGEX_URL_WEB = "http://(t\\.cn){1}/\\w*";
        String REGEX_URL_WEB = "http://[a-zA-Z0-9+&@#/%?=~_\\-|!:,\\.;]*[a-zA-Z0-9+&@#/%=~_|]";
//        assertEquals(4, 2 + 2);
//        Pattern pattern=Pattern.compile(REGEX_URL_WEB);
//        boolean re=pattern.matcher("http://t.cn/RtjD4uC").find();
//        System.out.println(re);
//        System.out.println(System.currentTimeMillis()/1000);
//        Document doc = Jsoup.connect("http://t.cn/RIQ1T9W").get();
//        String string= doc.select("title").get(0).toString();
//        System.out.println(System.currentTimeMillis()/1000);
        Calendar currentCalendar = Calendar.getInstance();
        System.out.println(currentCalendar.get(Calendar.YEAR));
        System.out.println(URLEncoder.encode("李开复","UTF-8"));
    }
}