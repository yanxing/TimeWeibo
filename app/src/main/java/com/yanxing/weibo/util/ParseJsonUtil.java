package com.yanxing.weibo.util;

import android.content.Context;

import com.google.gson.Gson;
import java.io.InputStream;

/**
 * 解析json
 * Created by lishuangxiang on 2016/4/8.
 */
public class ParseJsonUtil {


    /**
     * 读取Json文件
     * @param context
     * @param jsonFileName
     * @return String
     */
    public static String getJsonFileString(Context context,String jsonFileName) {
        StringBuilder stringBuffer = new StringBuilder();
        try {
            InputStream inputStream = context.getAssets().open(jsonFileName);
            int len;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer)) != -1) {
                stringBuffer.append(new String(buffer, 0, len, "UTF-8"));
            }
            inputStream.close();
            return stringBuffer.toString();
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 转化json为bean
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T convertJson(String json,Class<T> clazz){
        Gson gson = new Gson();
        T t = gson.fromJson(json,clazz);
        return t;
    }
}
