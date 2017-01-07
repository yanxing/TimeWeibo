package com.yanxing.weibo.util;

import android.net.Uri;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

/**
 * Fresco工具类
 * Created by 李双祥 on 2017/1/7.
 */
public class FrescoUtil {

    /**
     * 获取本地存储缓存的图片路径
     * @param uri 图片网址
     * @return
     */
    public static File getDiskCache(Uri uri){
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(uri).build();
        CacheKey cacheKey= DefaultCacheKeyFactory.getInstance()
                .getEncodedCacheKey(imageRequest,null);
        BinaryResource bRes= ImagePipelineFactory.getInstance().getMainFileCache()
                .getResource(cacheKey);
        return ((FileBinaryResource)bRes).getFile();
    }
}
