package com.yanxing.weibo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.yanxing.weibo.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 格式化微博文本，话题、表情、全文、链接和@，改自http://www.tuicool.com/articles/qIJba2i
 * 针对链接中点击查看全文链接、视频链接、图片链接、一般网页链接作分类显示和处理
 * Created by lishuangxiang on 2016/12/26.
 */
public class WeiboTextUtil {

    // @人 正则表达式
    private static final String REGEX_AT = "@[\\w\\p{InCJKUnifiedIdeographs}-]{1,26}";
    // 话题
    private static final String REGEX_TOPIC = "#[\\p{Print}\\p{InCJKUnifiedIdeographs}&&[^#]]+#";
    // URL，这种是点击查看全文的，即详情，不使用webview  针对“全文: http://m.weibo.cn/  ”这样链接形式
    private static final String REGEX_URL = "全文： http://(m\\.weibo\\.cn){1}(/\\w*)*";
    // URL，这种链接是跳转内置web界面，针对微博文本中http://t.cn/ 这种链接形式 ，
    // 可能是图片链接（转发微博时，添加了图片，微博限制转发微博只能添加一张图片），也可能是视频链接，这里分三类
    private static final String REGEX_URL_WEB = "http://(t\\.cn){1}/\\w*";
    // [表情]
    private static final String REGEX_EMOTION = "\\[(\\S+?)\\]";

    private static final String SCHEME_TOPIC = "topic:";
    private static final String SCHEME_URL = "url:";
    private static final String SCHEME_URL_WEB = "web:";
    private static final String SCHEME_AT = "at:";

    /**
     * 格式化微博文本
     */
    public static void formatWeiboText(final Context context, String content, final TextView textView) {
        final int textSize = (int) textView.getTextSize();
        //设置textView部分可点击
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        final SpannableStringBuilder spannable = new SpannableStringBuilder(content);
        //设置正则表达式匹配@
        Linkify.addLinks(spannable, Pattern.compile(REGEX_AT), SCHEME_AT);
        //匹配话题#
        Linkify.addLinks(spannable, Pattern.compile(REGEX_TOPIC), SCHEME_TOPIC);
        //匹配详情链接
        Linkify.addLinks(spannable, Pattern.compile(REGEX_URL), SCHEME_URL);
        //匹配WEB链接
        Linkify.addLinks(spannable, Pattern.compile(REGEX_URL_WEB), SCHEME_URL_WEB);

        //表情单独格式化
        Matcher emotionMatcher = Pattern.compile(REGEX_EMOTION).matcher(spannable);
        while (emotionMatcher.find()) {
            String emotion = emotionMatcher.group();
            int start = emotionMatcher.start();
            int end = emotionMatcher.end();
            int resId = EmotionUtil.getImageByName(emotion);
            if (resId != -1) {  // 表情匹配
                Drawable drawable = context.getResources().getDrawable(resId);
                drawable.setBounds(0, 0, (int) (textSize * 1.3), textSize);
                //自定义的 VerticalImageSpan ，可解决默认的 ImageSpan 不垂直居中的问题
                VerticalImageSpan imageSpan = new VerticalImageSpan(context,
                        BitmapFactory.decodeResource(context.getResources(), resId));
                spannable.setSpan(imageSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        final MyClickableSpan[] myClickableSpan = new MyClickableSpan[1];
        // 获取上面到所有 addLinks 后的匹配部分(这里一个匹配项被封装成了一个 URLSpan 对象)
        URLSpan[] urlSpans = spannable.getSpans(0, content.length(), URLSpan.class);

//        Observable.from(urlSpans)
//                .map(new Func1<URLSpan, SpannableStringBuilder>() {
//                    @Override
//                    public SpannableStringBuilder call(URLSpan urlSpan) {
//                        myClickableSpan[0] = new MyClickableSpan();
//                        if (urlSpan.getURL().startsWith(SCHEME_AT)) {
//                            int start = spannable.getSpanStart(urlSpan);
//                            int end = spannable.getSpanEnd(urlSpan);
//                            spannable.removeSpan(urlSpan);
//                            spannable.setSpan(myClickableSpan[0], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                        } else if (urlSpan.getURL().startsWith(SCHEME_TOPIC)) {
//                            int start = spannable.getSpanStart(urlSpan);
//                            int end = spannable.getSpanEnd(urlSpan);
//                            spannable.removeSpan(urlSpan);
//                            spannable.setSpan(myClickableSpan[0], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                        } else if (urlSpan.getURL().contains(SCHEME_URL)) {
//                            int start = spannable.getSpanStart(urlSpan);
//                            int end = spannable.getSpanEnd(urlSpan);
//                            spannable.removeSpan(urlSpan);
//                            SpannableStringBuilder urlSpannableString = getUrlText(urlSpan.getURL());
//                            spannable.replace(start, end, urlSpannableString);
//                            // 格式化“全文”文本
//                            spannable.setSpan(myClickableSpan[0], start, start + urlSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                        } else if (urlSpan.getURL().contains(SCHEME_URL_WEB)) {
//                            int start = spannable.getSpanStart(urlSpan);
//                            int end = spannable.getSpanEnd(urlSpan);
//                            spannable.removeSpan(urlSpan);
//                            SpannableStringBuilder urlSpannableString = getWebUrlText(context, urlSpan.getURL(), textSize);
//                            spannable.replace(start, end, urlSpannableString);
//                            // 格式化Web链接部分文本
//                            spannable.setSpan(myClickableSpan[0], start, start + urlSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                        }
//                        return spannable;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<SpannableStringBuilder>() {
//                    @Override
//                    public void call(SpannableStringBuilder bitmap) {
//                        textView.setText(spannable);
//                    }
//                });

        for (URLSpan urlSpan : urlSpans) {
            myClickableSpan[0] = new MyClickableSpan();
            if (urlSpan.getURL().startsWith(SCHEME_AT)) {
                int start = spannable.getSpanStart(urlSpan);
                int end = spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                spannable.setSpan(myClickableSpan[0], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (urlSpan.getURL().startsWith(SCHEME_TOPIC)) {
                int start = spannable.getSpanStart(urlSpan);
                int end = spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                spannable.setSpan(myClickableSpan[0], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (urlSpan.getURL().contains(SCHEME_URL)) {
                int start = spannable.getSpanStart(urlSpan);
                int end = spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                SpannableStringBuilder urlSpannableString = getUrlText(urlSpan.getURL());
                spannable.replace(start, end, urlSpannableString);
                // 格式化“全文”文本
                spannable.setSpan(myClickableSpan[0], start, start + urlSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (urlSpan.getURL().contains(SCHEME_URL_WEB)) {
                int start = spannable.getSpanStart(urlSpan);
                int end = spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                SpannableStringBuilder urlSpannableString = getDefaultWebUrlText(context, urlSpan.getURL(), textSize);
                spannable.replace(start, end, urlSpannableString);
                // 格式化Web链接部分文本
                spannable.setSpan(myClickableSpan[0], start, start + urlSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        textView.setText(spannable);

        Observable.from(urlSpans)
                .filter(new Func1<URLSpan, Boolean>() {
                    @Override
                    public Boolean call(URLSpan urlSpan) {
                        return urlSpan.getURL().contains(SCHEME_URL_WEB);
                    }
                })
                .map(new Func1<URLSpan, SpannableStringBuilder>() {
                    @Override
                    public SpannableStringBuilder call(URLSpan urlSpan) {
                        myClickableSpan[0] = new MyClickableSpan();
                        int start = spannable.getSpanStart(urlSpan);
                        int end = spannable.getSpanEnd(urlSpan);
                        spannable.removeSpan(urlSpan);
                        SpannableStringBuilder urlSpannableString = getWebUrlText(context, urlSpan.getURL(), textSize);
                        spannable.replace(start, end, urlSpannableString);
                        // 格式化Web链接部分文本
                        spannable.setSpan(myClickableSpan[0], start, start + urlSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        return spannable;
                    }
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SpannableStringBuilder>() {
                    @Override
                    public void call(SpannableStringBuilder bitmap) {
                        textView.setText(spannable);
                    }
                });
    }

    /**
     * 格式化链接，详情链接（全文）
     *
     * @param source 文本
     * @return
     */
    private static SpannableStringBuilder getUrlText(String source) {
        SpannableStringBuilder builder = new SpannableStringBuilder(source);
        builder.clear();
        builder.append("全文");
        return builder;
    }

    /**
     * 格式化链接，web链接（包括一般web链接，图片、视频）
     *
     * @param context
     * @param source  文本
     * @param size    文字大小
     * @return
     */
    private static SpannableStringBuilder getWebUrlText(Context context, String source, int size) {
        SpannableStringBuilder builder = new SpannableStringBuilder(source);
        String url = source.substring(SCHEME_URL_WEB.length(), source.length());
        Document doc = null;
        String tip = " 网页链接";
        Drawable drawable = context.getResources().getDrawable(R.mipmap.link);
        ;
        try {
            doc = Jsoup.connect(url).get();
            Elements title = doc.select("title");
            if (title != null && title.size() > 0) {
                String temp = title.get(0).toString();
                if (temp.contains("视频") || temp.contains("秒拍")) {
                    tip = " 短视频";
                    drawable = context.getResources().getDrawable(R.mipmap.video);
                } else if (temp.contains("图片")) {
                    tip = " 查看图片";
                    drawable = context.getResources().getDrawable(R.mipmap.has_image);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String prefix = " ";
        builder.replace(0, prefix.length(), prefix);
        drawable.setBounds(0, 0, size, size);
        VerticalImageSpan imageSpan = new VerticalImageSpan(context,
                ((BitmapDrawable) drawable).getBitmap());
        builder.setSpan(imageSpan, prefix.length(), source.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(tip);
        return builder;
    }

    /**
     * 格式化链接，web链接（包括一般web链接，图片、视频）
     *
     * @param context
     * @param source  文本
     * @param size    文字大小
     * @return
     */
    private static SpannableStringBuilder getDefaultWebUrlText(Context context, String source, int size) {
        SpannableStringBuilder builder = new SpannableStringBuilder(source);
        String tip = " 网页链接";
        Drawable drawable = context.getResources().getDrawable(R.mipmap.link);
        ;
        String prefix = " ";
        builder.replace(0, prefix.length(), prefix);
        drawable.setBounds(0, 0, size, size);
        VerticalImageSpan imageSpan = new VerticalImageSpan(context,
                ((BitmapDrawable) drawable).getBitmap());
        builder.setSpan(imageSpan, prefix.length(), source.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(tip);
        return builder;
    }


    private static class MyClickableSpan extends ClickableSpan {

        @Override
        public void onClick(View widget) {

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(0xff507daf);//507daf
            ds.setUnderlineText(false);
        }

    }

    private static class VerticalImageSpan extends ImageSpan {

        public VerticalImageSpan(Context context, Bitmap b) {
            super(context, b);
        }

        /**
         * update the text line height
         */
        @Override
        public int getSize(Paint paint, CharSequence text, int start, int end,
                           Paint.FontMetricsInt fontMetricsInt) {
            Drawable drawable = getDrawable();
            Rect rect = drawable.getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fmPaint = paint.getFontMetricsInt();
                int fontHeight = fmPaint.descent - fmPaint.ascent;
                int drHeight = rect.bottom - rect.top;
                int centerY = fmPaint.ascent + fontHeight / 2;

                fontMetricsInt.ascent = centerY - drHeight / 2;
                fontMetricsInt.top = fontMetricsInt.ascent;
                fontMetricsInt.bottom = centerY + drHeight / 2;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
            return rect.right;
        }

        /**
         * see detail message in android.text.TextLine
         */
        @Override
        public void draw(Canvas canvas, CharSequence text, int start, int end,
                         float x, int top, int y, int bottom, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            Paint.FontMetricsInt fmPaint = paint.getFontMetricsInt();
            int fontHeight = fmPaint.descent - fmPaint.ascent;
            int centerY = y + fmPaint.descent - fontHeight / 2;
            int transY = centerY - (drawable.getBounds().bottom - drawable.getBounds().top) / 2;
            canvas.translate(x, transY);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

//    private static new
}
