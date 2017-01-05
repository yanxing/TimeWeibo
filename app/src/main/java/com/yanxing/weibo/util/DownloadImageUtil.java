package com.yanxing.weibo.util;

import android.os.Handler;
import android.os.Looper;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 下载图片到相册
 * Created by lishuangxiang on 2016/11/24.
 */

public class DownloadImageUtil {

    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private DownloadListener mDownloadListener;

    public static DownloadImageUtil getInstance() {
        return SingleHolder.mDownloadUtils.get();
    }

    private static class SingleHolder {
        private final static WeakReference<DownloadImageUtil> mDownloadUtils
                =new WeakReference<>(new DownloadImageUtil());
    }

    private DownloadImageUtil() {
    }

    /**
     * 下载图片
     * @param url 图片路径
     * @param savePath 图片保存路径
     * @param downloadListener
     */
    public void downloadImage(final String url, final String savePath, DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Charset", "UTF-8");
                    conn.connect();
                    if (conn.getResponseCode() == 200) {
                        InputStream inStream = conn.getInputStream();
                        final String imageName=System.currentTimeMillis() + ".jpg";
                        FileUtil.writeStInput(savePath,imageName, inStream);
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                mDownloadListener.success(savePath+imageName);
                            }
                        });
                    }else {
                        mDownloadListener.error(conn.getResponseMessage());
                    }
                } catch (Exception e) {
                    mDownloadListener.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    public interface DownloadListener {
        /**
         * @param path 下载成功保存的路径
         */
        void success(String path);
        void error(String message);
    }
}
