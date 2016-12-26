package com.yanxing.weibo.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.yanxing.weibo.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 微博文本，话题、表情、链接和@
 * http://www.tuicool.com/articles/qIJba2i
 * Created by lishuangxiang on 2016/12/26.
 */
public class WeiboTextUtil {

    // @人 正则表达式
    public static final String REGEX_AT = "@[\\w\\p{InCJKUnifiedIdeographs}-]{1,26}";
    // 话题
    public static final String REGEX_TOPIC="#[\\p{Print}\\p{InCJKUnifiedIdeographs}&&[^#]]+#";
    // URL
    public static final String REGEX_URL = "http://[a-zA-Z0-9+&@#/%?=~_\\-|!:,\\.;]*[a-zA-Z0-9+&@#/%=~_|]";
    // [表情]
    public static final String REGEX_EMOTION = "\\[(\\S+?)\\]";

    /**
     * 格式化微博文本
     */
    public static SpannableStringBuilder formatWeiboText(Context context, String content, TextView textView){
        int textSize= (int) textView.getTextSize();
        //设置textView部分可点击
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableStringBuilder spannable=new SpannableStringBuilder(content);
        //设置正则表达式匹配@
        Linkify.addLinks(spannable, Pattern.compile(REGEX_AT),REGEX_AT);
        //匹配话题#
        Linkify.addLinks(spannable,Pattern.compile(REGEX_TOPIC),REGEX_TOPIC);
        //匹配链接
        Linkify.addLinks(spannable,Pattern.compile(REGEX_URL),REGEX_URL);

        MyClickableSpan myClickableSpan;
        // 获取上面到所有 addLinks 后的匹配部分(这里一个匹配项被封装成了一个 URLSpan 对象)
        URLSpan[] urlSpans = spannable.getSpans(0, content.length(), URLSpan.class);
        for (URLSpan urlSpan:urlSpans){
            myClickableSpan=new MyClickableSpan();
            if (urlSpan.getURL().startsWith(REGEX_AT)){
                int start=spannable.getSpanStart(urlSpan);
                int end=spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                spannable.setSpan(myClickableSpan,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (urlSpan.getURL().startsWith(REGEX_TOPIC)){
                int start=spannable.getSpanStart(urlSpan);
                int end=spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                spannable.setSpan(myClickableSpan,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (urlSpan.getURL().startsWith(REGEX_URL)){
                int start=spannable.getSpanStart(urlSpan);
                int end=spannable.getSpanEnd(urlSpan);
                spannable.removeSpan(urlSpan);
                SpannableStringBuilder urlSpannableString = getUrlTextSpannableString(context, urlSpan.getURL(), textSize);
                spannable.replace(start, end, urlSpannableString);
                // 格式化链接部分文本
                spannable.setSpan(myClickableSpan, start, start + urlSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        Matcher emotionMatcher=Pattern.compile(REGEX_EMOTION).matcher(spannable);
        while (emotionMatcher.find()){
            String emotion=emotionMatcher.group();
            int start = emotionMatcher.start();
            int end = emotionMatcher.end();
            int resId = EmotionUtil.getImageByName(emotion);
            if (resId != -1) {  // 表情匹配
                Drawable drawable = context.getResources().getDrawable(resId);
                drawable.setBounds(0, 0, (int) (textSize * 1.3), (int) (textSize * 1.3));
                // 自定义的 VerticalImageSpan ，可解决默认的 ImageSpan 不垂直居中的问题
//                VerticalImageSpan imageSpan = new VerticalImageSpan(drawable);
//                spannable.setSpan(imageSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return spannable;
    }

    /**
     * 格式化链接
     * @param context
     * @param source 文本
     * @param size 文字大小
     * @return
     */
    private static SpannableStringBuilder getUrlTextSpannableString(Context context, String source, int size) {
        SpannableStringBuilder builder = new SpannableStringBuilder(source);
        String prefix = " ";
        builder.replace(0, prefix.length(), prefix);
        Drawable drawable = context.getResources().getDrawable(R.mipmap.link);
        drawable.setBounds(0, 0, size, size);
//        builder.setSpan(new VerticalImageSpan(drawable), prefix.length(), source.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(" 网页链接");
        return builder;
    }

    private static class MyClickableSpan extends ClickableSpan{

        @Override
        public void onClick(View widget) {

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(0xff1FB6FF);
            ds.setUnderlineText(false);
        }
    }
}
