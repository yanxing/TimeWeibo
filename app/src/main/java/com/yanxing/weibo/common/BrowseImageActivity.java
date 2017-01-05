package com.yanxing.weibo.common;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
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
import com.yanxing.weibo.common.model.DownloadImage;
import com.yanxing.weibo.util.ConstantValue;
import com.yanxing.weibo.util.DownloadImageUtil;
import com.yanxing.weibo.util.FileUtil;
import com.yanxing.weibo.weiboapi.ConstantAPI;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
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

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_browse_image;
    }

    @Override
    protected void afterInstanceView() {
        EventBus.getDefault().register(this);
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
        ImageMenuDialog imageMenuDialog = new ImageMenuDialog();
        imageMenuDialog.show(getSupportFragmentManager(), "ImageMenuDialog");
    }

    /**
     * 保存图片
     */
    public void onEvent(DownloadImage downloadImage) {
        if (downloadImage.isDownload()) {
            DownloadImageUtil.getInstance().downloadImage(mCurrentImagePath,
                    FileUtil.getStoragePath() + ConstantValue.CACHE_IMAGE,
                    new DownloadImageUtil.DownloadListener() {
                        @Override
                        public void success(String path) {
                            showToast(getString(R.string.yi_save) + path);
                        }

                        @Override
                        public void error(String message) {
                            showToast(message);
                        }
                    });
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
