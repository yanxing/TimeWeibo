package com.yanxing.weibo.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.yanxing.weibo.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.greenrobot.event.EventBus;

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
    private static final String REGEX_URL_WEB = "http://(t\\.cn){1}/\\w*";
    // [表情]
    private static final String REGEX_EMOTION = "\\[(\\S+?)\\]";

    private static final String SCHEME_TOPIC = "topic:";
    private static final String SCHEME_URL = "url:";
    private static final String SCHEME_URL_WEB = "web:";
    private static final String SCHEME_AT = "at:";
    private static final String FULL_TEXT="全文";
    private static final String WEB_LINK=" 网页链接";//前面有一个空格
    private static final String ACTION="com.at.user";
    private static final String WEB_ACTION="com.web.link";

    /**
     * 格式化微博文本
     */
    public static SpannableStringBuilder formatWeiboText(Context context, String content, TextView textView) {
        int textSize = (int) textView.getTextSize();
        //设置textView部分可点击
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableStringBuilder spannable = new SpannableStringBuilder(content);
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

        MyClickableSpan myClickableSpan;
        // 获取上面到所有 addLinks 后的匹配部分(这里一个匹配项被封装成了一个 URLSpan 对象)
        URLSpan[] urlSpans = spannable.getSpans(0, content.length(), URLSpan.class);

        for (URLSpan urlSpan : urlSpans) {
            myClickableSpan = new MyClickableSpan(urlSpan.getURL(),context);
            if (urlSpan.getURL().startsWith(SCHEME_AT)) {
                int start = spannable.getSpanStart(urlSpan);
                int end = spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                spannable.setSpan(myClickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (urlSpan.getURL().startsWith(SCHEME_TOPIC)) {
                int start = spannable.getSpanStart(urlSpan);
                int end = spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                spannable.setSpan(myClickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (urlSpan.getURL().contains(SCHEME_URL)) {
                int start = spannable.getSpanStart(urlSpan);
                int end = spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                SpannableStringBuilder urlSpannableString = getUrlText(urlSpan.getURL());
                spannable.replace(start, end, urlSpannableString);
                // 格式化“全文”文本
                spannable.setSpan(myClickableSpan, start, start + urlSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (urlSpan.getURL().contains(SCHEME_URL_WEB)) {
                int start = spannable.getSpanStart(urlSpan);
                int end = spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                SpannableStringBuilder urlSpannableString = getWebUrlText(context, urlSpan.getURL(), textSize);
                spannable.replace(start, end, urlSpannableString);
                // 格式化Web链接部分文本
                spannable.setSpan(myClickableSpan, start, start + urlSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return spannable;
    }

    /**
     * 格式化链接，详情链接（全文）
     */
    private static SpannableStringBuilder getUrlText(String source) {
        SpannableStringBuilder builder = new SpannableStringBuilder(source);
        builder.clear();
        builder.append(FULL_TEXT);
        return builder;
    }

    /**
     * 格式化链接，web链接（包括一般web链接，图片、视频）
     */
    private static SpannableStringBuilder getWebUrlText(Context context
            , String source, int size) {
        SpannableStringBuilder builder = new SpannableStringBuilder(source);
        Drawable drawable = context.getResources().getDrawable(R.mipmap.link);
        String prefix = " ";
        builder.replace(0, prefix.length(), prefix);
        drawable.setBounds(0, 0, size, size);
        VerticalImageSpan imageSpan = new VerticalImageSpan(context,
                ((BitmapDrawable) drawable).getBitmap());
        builder.setSpan(imageSpan, prefix.length(), source.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(WEB_LINK);
        return builder;
    }


    private static class MyClickableSpan extends ClickableSpan {
        private String text;
        private Context context;

        private MyClickableSpan(String value,Context context){
            text=value;
            this.context=context;
        }

        @Override
        public void onClick(View widget) {
            if (text.startsWith(SCHEME_AT)){//点击@的人
                Intent intent=new Intent(ACTION);
                intent.putExtra("screenName",text.substring(SCHEME_AT.length()+1,text.length()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }else if (text.startsWith(SCHEME_URL_WEB)){
                Intent intent=new Intent(WEB_ACTION);
                intent.putExtra("url",text.substring(SCHEME_URL_WEB.length(),text.length()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }else {
                EventBus.getDefault().post(widget);
            }
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

}
