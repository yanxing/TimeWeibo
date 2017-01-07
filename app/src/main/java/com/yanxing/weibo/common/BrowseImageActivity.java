package com.yanxing.weibo.common;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.util.ConstantValue;
import com.yanxing.weibo.util.FileUtil;
import com.yanxing.weibo.util.FrescoUtil;
import com.yanxing.weibo.weiboapi.ConstantAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

/**
 * 浏览微博图片，可放大
 * Created by lishuangxiang on 2017/1/5.
 */
public class BrowseImageActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.currentPage)
    TextView mCurrentPage;//当前第几个

    private List<String> mImageUrls = new ArrayList<>();
    private String mCurrentImagePath;
    //和清单文件中provider一致
    private static final String AUTHORITY = "com.yanxing.provider";

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_browse_image;
    }

    @Override
    protected void afterInstanceView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mImageUrls = bundle.getStringArrayList("imageUrl");
            int index = bundle.getInt("currentIndex");
            if (index >= mImageUrls.size()) {
                throw new IndexOutOfBoundsException("currentIndex must to <imageUrl.size");
            } else {
                if (mImageUrls.size() == 1) {
                    mCurrentPage.setVisibility(View.INVISIBLE);
                } else {
                    mCurrentPage.setText((index + 1) + "/" + mImageUrls.size());
                }
                mViewPager.setAdapter(new DraweePagerAdapter());
                mViewPager.setCurrentItem(index);
                mCurrentImagePath=mImageUrls.get(index).replaceAll(ConstantAPI.THUMBNAIL_PIC, ConstantAPI.ORIGINAL_PIC);
                mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {
                        mCurrentImagePath = mImageUrls.get(position).replaceAll(ConstantAPI.THUMBNAIL_PIC, ConstantAPI.ORIGINAL_PIC);
                        mCurrentPage.setText((position + 1) + "/" + mImageUrls.size());
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });
            }
        }
    }

    @OnClick(R.id.menu)
    public void onClick() {
        //保存图片
        File file=FrescoUtil.getDiskCache(Uri.parse(mCurrentImagePath));
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            long time=System.currentTimeMillis();
            String newImage="timeweibo"+time;
            if (mCurrentImagePath.contains("gif")){
                newImage+=".gif";
            }else {
                newImage+=".png";
            }
            FileUtil.writeStInput(FileUtil.getStoragePath() + ConstantValue.CAMERA
                    ,newImage,fileInputStream);
            showToast(getString(R.string.yi_save));
            //通知图库有新图片加入
            if (Build.VERSION.SDK_INT >= 24) {
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        FileProvider.getUriForFile(getApplicationContext(), AUTHORITY, file)));
            } else {
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public class DraweePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageUrls.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup viewGroup, int position) {
            final PhotoDraweeView photoDraweeView = new PhotoDraweeView(viewGroup.getContext());
            PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder()
                    //先加载中等图，再加载原图
                    .setLowResImageRequest(ImageRequest.fromUri(mImageUrls.get(position)
                            .replaceAll(ConstantAPI.THUMBNAIL_PIC, ConstantAPI.BMIDDLE_PIC)))
                    .setImageRequest(ImageRequest.fromUri(mImageUrls.get(position)
                            .replaceAll(ConstantAPI.THUMBNAIL_PIC, ConstantAPI.ORIGINAL_PIC)))
                    .setAutoPlayAnimations(true)
                    .setOldController(photoDraweeView.getController());
            controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    if (imageInfo == null) {
                        return;
                    }
                    photoDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
                }
            });
            photoDraweeView.setController(controller.build());
            photoDraweeView.setOnPhotoTapListener(new OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    finish();
                }
            });

            try {
                viewGroup.addView(photoDraweeView, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return photoDraweeView;
        }
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
