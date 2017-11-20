package com.yanxing.weibo.common;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yanxing.titlebarlibrary.TitleBar;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.BasePresenterImpl;
import com.yanxing.weibo.view.ProgressWheel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 微博内容网页链接
 * Created by lishuangxiang on 2017/2/22.
 */
public class WebActivity extends BaseActivity {

    @BindView(R.id.detail)
    WebView mWebView;

    @BindView(R.id.titleBar)
    TitleBar mTitleBar;

    @BindView(R.id.load)
    ProgressWheel mLoad;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_web;
    }

    @Override
    protected void afterInstanceView() {
        final String url = getIntent().getStringExtra("url");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mLoad.setVisibility(View.GONE);
            }
        });
        mWebView.loadUrl(url);
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Document dom = Jsoup.connect(url).get();
                    String html = dom.toString();
                    dom = Jsoup.parse(html);
                    String title = dom.select("title").text();
                    subscriber.onNext(title);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(String s) {
                        if (s.length()>7){
                            mTitleBar.setTitle(s.substring(0,7)+"...");
                        }else {
                            mTitleBar.setTitle(s);
                        }
                    }
                });
    }

    @Override
    protected BasePresenterImpl initPresenter() {
        return null;
    }
}
