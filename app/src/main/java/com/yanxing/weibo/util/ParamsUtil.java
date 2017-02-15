package com.yanxing.weibo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by lishuangxiang on 2017/2/15.
 */
public class ParamsUtil {

    public static String encode(String value) {
        if (value == null)
            return "";
        String encoded = null;
        try {
            encoded = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException ignore) {
        }
        return encoded;
//        StringBuffer buf = new StringBuffer(encoded.length());
//        char focus;
//        for (int i = 0; i < encoded.length(); i++) {
//            focus = encoded.charAt(i);
//            if (focus == '*') {
//                buf.append("%2A");
//            } else if (focus == '+') {
//                buf.append("%20");
//            } else if (focus == '%' && (i + 1) < encoded.length() && encoded.charAt(i + 1) == '7' && encoded.charAt(i + 2) == 'E') {
//                buf.append('~');
//                i += 2;
//            } else {
//                buf.append(focus);
//            }
//        }
//        return buf.toString();
    }
}
