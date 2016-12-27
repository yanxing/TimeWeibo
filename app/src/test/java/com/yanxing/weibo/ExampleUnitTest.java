package com.yanxing.weibo;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {

        String REGEX_URL_WEB = "http://[\\t\\.cn]{1}[a-zA-Z0-9+&@#/%=~_|]";
//        String REGEX_URL_WEB = "http://[a-zA-Z0-9+&@#/%?=~_\\-|!:,\\.;]*[a-zA-Z0-9+&@#/%=~_|]";
//        assertEquals(4, 2 + 2);
        Pattern pattern=Pattern.compile(REGEX_URL_WEB);
        boolean re=pattern.matcher("http://t.cn/RtjD4uC").matches();
        System.out.print(re);
    }
}