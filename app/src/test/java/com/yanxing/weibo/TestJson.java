package com.yanxing.weibo;

import com.yanxing.weibo.util.ParseJsonUtil;
import com.yanxing.weibo.weiboapi.model.WeiboComment;

import org.junit.Test;

/**
 * Created by lishuangxiang on 2017/1/4.
 */
public class TestJson {


    @Test
    public void testT(){
        String test="{\n" +
                "    \"Data\": [\n" +
                "        {\n" +
                "            \"Age\": 25,\n" +
                "            \"ApplyStatus\": 0,\n" +
                "            \"AttNums\": 48,\n" +
                "            \"Company\": \"\",\n" +
                "            \"FansNums\": 67,\n" +
                "            \"Gender\": 0,\n" +
                "            \"IsAtt\": 0,\n" +
                "            \"IsAuthentication\": 0,\n" +
                "            \"IsBlack\": 0,\n" +
                "            \"IsForbid\": 0,\n" +
                "            \"IsOfficial\": 0,\n" +
                "            \"IsShowV\": 0,\n" +
                "            \"Job\": \"\",\n" +
                "            \"Mobile\": \"18291479008\",\n" +
                "            \"NBaoNums\": 0,\n" +
                "            \"NBi\": 0,\n" +
                "            \"NickName\": \"不羁的北风\",\n" +
                "            \"RegisterTime\": \"2016/6/15 0:00:00\",\n" +
                "            \"RoomSource\": 0,\n" +
                "            \"UserDescription\": \"无论你处于什么位置或状态，都不必太过在意，人生就是一场马拉松。\",\n" +
                "            \"UserId\": 11026,\n" +
                "            \"UserLevel\": 10,\n" +
                "            \"UserPortrait\": \"https://staticqiniu.newzhibo.cn/images/20161217/20161217233246047a6ed6.jpg\",\n" +
                "            \"VNums\": 0,\n" +
                "            \"WeekStarRankGift\": [],\n" +
                "            \"YxToken\": \"42e499e591496cb71d9a11ae109dc962\",\n" +
                "            \"list\": [],\n" +
                "            \"msgList\": [],\n" +
                "            \"rechargeList\": []\n" +
                "        }\n" +
                "    ],\n" +
                "    \"IsSingle\": 0,\n" +
                "    \"PageCount\": 0,\n" +
                "    \"PageSize\": 0,\n" +
                "    \"ReturnCode\": 0,\n" +
                "    \"ReturnMsgID\": \"\",\n" +
                "    \"UserID\": \"11026\"\n" +
                "}";

        test="{\"Data\":null,\"IsSingle\":0,\"PageCount\":0,\"PageSize\":0,\"ReturnCode\":1203,\"ReturnMsgID\":\"20170116094656\",\"UserID\":\"\"}";
        com.yanxing.weibo.Test result=ParseJsonUtil.convertJson(test, com.yanxing.weibo.Test.class);
        if (result.getData()==null){
            System.out.println("result is null");
        }else {
            System.out.println(result.getData().get(0).getUserDescription());
        }
    }

    @Test
    public void testCommentJson(){
        WeiboComment result=ParseJsonUtil.convertJson("{\n" +
                "    \"comments\": [\n" +
                "        {\n" +
                "            \"created_at\": \"Wed Jan 04 15:21:39 +0800 2017\",\n" +
                "            \"id\": 4060216452865764,\n" +
                "            \"rootid\": 4060216452865764,\n" +
                "            \"floor_number\": 9,\n" +
                "            \"text\": \"@碎珏骷 适合你\",\n" +
                "            \"source_allowclick\": 0,\n" +
                "            \"source_type\": 1,\n" +
                "            \"source\": \"<a href=\\\"http://app.weibo.com/t/feed/187dRB\\\" rel=\\\"nofollow\\\">魅蓝 3s</a>\",\n" +
                "            \"user\": {\n" +
                "                \"id\": 1341007741,\n" +
                "                \"idstr\": \"1341007741\",\n" +
                "                \"class\": 1,\n" +
                "                \"screen_name\": \"赵小爷家的解放牌拖拉机\",\n" +
                "                \"name\": \"赵小爷家的解放牌拖拉机\",\n" +
                "                \"province\": \"100\",\n" +
                "                \"city\": \"1000\",\n" +
                "                \"location\": \"其他\",\n" +
                "                \"description\": \"预测未来的最好方式是去创造它。\",\n" +
                "                \"url\": \"\",\n" +
                "                \"profile_image_url\": \"http://tva2.sinaimg.cn/crop.0.0.720.720.50/4fee277djw8elwptjg9a8j20k00k0myb.jpg\",\n" +
                "                \"cover_image_phone\": \"http://ww1.sinaimg.cn/crop.0.0.640.640.640/a1d3feabjw1ecat4uqw77j20hs0hsacp.jpg\",\n" +
                "                \"profile_url\": \"u/1341007741\",\n" +
                "                \"domain\": \"\",\n" +
                "                \"weihao\": \"\",\n" +
                "                \"gender\": \"m\",\n" +
                "                \"followers_count\": 196,\n" +
                "                \"friends_count\": 253,\n" +
                "                \"pagefriends_count\": 2,\n" +
                "                \"statuses_count\": 1255,\n" +
                "                \"favourites_count\": 590,\n" +
                "                \"created_at\": \"Tue Dec 20 17:26:35 +0800 2011\",\n" +
                "                \"following\": false,\n" +
                "                \"allow_all_act_msg\": false,\n" +
                "                \"geo_enabled\": true,\n" +
                "                \"verified\": false,\n" +
                "                \"verified_type\": -1,\n" +
                "                \"remark\": \"\",\n" +
                "                \"ptype\": 0,\n" +
                "                \"allow_all_comment\": true,\n" +
                "                \"avatar_large\": \"http://tva2.sinaimg.cn/crop.0.0.720.720.180/4fee277djw8elwptjg9a8j20k00k0myb.jpg\",\n" +
                "                \"avatar_hd\": \"http://tva2.sinaimg.cn/crop.0.0.720.720.1024/4fee277djw8elwptjg9a8j20k00k0myb.jpg\",\n" +
                "                \"verified_reason\": \"\",\n" +
                "                \"verified_trade\": \"\",\n" +
                "                \"verified_reason_url\": \"\",\n" +
                "                \"verified_source\": \"\",\n" +
                "                \"verified_source_url\": \"\",\n" +
                "                \"follow_me\": false,\n" +
                "                \"online_status\": 0,\n" +
                "                \"bi_followers_count\": 83,\n" +
                "                \"lang\": \"zh-cn\",\n" +
                "                \"star\": 0,\n" +
                "                \"mbtype\": 0,\n" +
                "                \"mbrank\": 0,\n" +
                "                \"block_word\": 0,\n" +
                "                \"block_app\": 0,\n" +
                "                \"credit_score\": 80,\n" +
                "                \"user_ability\": 0,\n" +
                "                \"urank\": 26\n" +
                "            },\n" +
                "            \"mid\": \"4060216452865764\",\n" +
                "            \"idstr\": \"4060216452865764\",\n" +
                "            \"status\": {\n" +
                "                \"created_at\": \"Wed Jan 04 15:15:02 +0800 2017\",\n" +
                "                \"id\": 4060214787455271,\n" +
                "                \"mid\": \"4060214787455271\",\n" +
                "                \"idstr\": \"4060214787455271\",\n" +
                "                \"text\": \"【一款黑科技防抖勺 让手抖人群进食无忧】你身边有手抖的帕金森患者吗？你见过手抖患者是如何进餐的吗？“睿餐”防抖勺是一款专门帮助帕金森等手抖患者实现自主进餐的科技产品。#黑科技防抖勺#多神奇，我们一起看视频→→http://t.cn/RMAUTa2\",\n" +
                "                \"textLength\": 224,\n" +
                "                \"source_allowclick\": 0,\n" +
                "                \"source_type\": 1,\n" +
                "                \"source\": \"<a href=\\\"http://app.weibo.com/t/feed/6vtZb0\\\" rel=\\\"nofollow\\\">微博 weibo.com</a>\",\n" +
                "                \"favorited\": false,\n" +
                "                \"truncated\": false,\n" +
                "                \"in_reply_to_status_id\": \"\",\n" +
                "                \"in_reply_to_user_id\": \"\",\n" +
                "                \"in_reply_to_screen_name\": \"\",\n" +
                "                \"pic_urls\": [],\n" +
                "                \"geo\": null,\n" +
                "                \"user\": {\n" +
                "                    \"id\": 1314608344,\n" +
                "                    \"idstr\": \"1314608344\",\n" +
                "                    \"class\": 1,\n" +
                "                    \"screen_name\": \"新闻晨报\",\n" +
                "                    \"name\": \"新闻晨报\",\n" +
                "                    \"province\": \"31\",\n" +
                "                    \"city\": \"12\",\n" +
                "                    \"location\": \"上海 闵行区\",\n" +
                "                    \"description\": \"新媒体合作：qq:2549671421； 曝料热线：021-63529999 ； 客服热线：8008190000、4006200000\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"profile_image_url\": \"http://tva4.sinaimg.cn/crop.49.65.610.610.50/4e5b54d8jw8ev7lxmkc5nj20j60isq4r.jpg\",\n" +
                "                    \"cover_image\": \"http://ww4.sinaimg.cn/crop.0.0.920.300/4e5b54d8gw1e9qkzwowpyj20r80cytf5.jpg\",\n" +
                "                    \"cover_image_phone\": \"http://ww3.sinaimg.cn/crop.0.0.640.640.640/4e5b54d8gw1f5ht4jiiqqj20e80e275d.jpg;http://ww3.sinaimg.cn/crop.0.0.640.640.640/4e5b54d8gw1f5ht50z9rnj20dw0e8abd.jpg;http://ww3.sinaimg.cn/crop.0.0.640.640.640/4e5b54d8gw1f5ht2rqc0cj20e80e875a.jpg;http://ww4.sinaimg.cn/crop.0.0.640.640.640/4e5b54d8gw1f5ht187x2yj20e50e8gnj.jpg;http://ww3.sinaimg.cn/crop.0.0.640.640.640/6ce2240djw1e9oae3wb1pj20hs0hs77c.jpg\",\n" +
                "                    \"profile_url\": \"shmorningpost\",\n" +
                "                    \"domain\": \"shmorningpost\",\n" +
                "                    \"weihao\": \"\",\n" +
                "                    \"gender\": \"m\",\n" +
                "                    \"followers_count\": 28264574,\n" +
                "                    \"friends_count\": 764,\n" +
                "                    \"pagefriends_count\": 116,\n" +
                "                    \"statuses_count\": 85014,\n" +
                "                    \"favourites_count\": 3818,\n" +
                "                    \"created_at\": \"Fri Aug 28 16:35:43 +0800 2009\",\n" +
                "                    \"following\": true,\n" +
                "                    \"allow_all_act_msg\": false,\n" +
                "                    \"geo_enabled\": false,\n" +
                "                    \"verified\": true,\n" +
                "                    \"verified_type\": 3,\n" +
                "                    \"remark\": \"\",\n" +
                "                    \"ptype\": 0,\n" +
                "                    \"allow_all_comment\": true,\n" +
                "                    \"avatar_large\": \"http://tva4.sinaimg.cn/crop.49.65.610.610.180/4e5b54d8jw8ev7lxmkc5nj20j60isq4r.jpg\",\n" +
                "                    \"avatar_hd\": \"http://tva4.sinaimg.cn/crop.49.65.610.610.1024/4e5b54d8jw8ev7lxmkc5nj20j60isq4r.jpg\",\n" +
                "                    \"verified_reason\": \"《新闻晨报》官方微博\",\n" +
                "                    \"verified_trade\": \"\",\n" +
                "                    \"verified_reason_url\": \"\",\n" +
                "                    \"verified_source\": \"\",\n" +
                "                    \"verified_source_url\": \"\",\n" +
                "                    \"verified_state\": 0,\n" +
                "                    \"verified_level\": 3,\n" +
                "                    \"verified_type_ext\": 0,\n" +
                "                    \"verified_reason_modified\": \"\",\n" +
                "                    \"verified_contact_name\": \"\",\n" +
                "                    \"verified_contact_email\": \"\",\n" +
                "                    \"verified_contact_mobile\": \"\",\n" +
                "                    \"follow_me\": false,\n" +
                "                    \"online_status\": 0,\n" +
                "                    \"bi_followers_count\": 493,\n" +
                "                    \"lang\": \"zh-cn\",\n" +
                "                    \"star\": 0,\n" +
                "                    \"mbtype\": 12,\n" +
                "                    \"mbrank\": 5,\n" +
                "                    \"block_word\": 0,\n" +
                "                    \"block_app\": 1,\n" +
                "                    \"credit_score\": 80,\n" +
                "                    \"user_ability\": 99844,\n" +
                "                    \"urank\": 41\n" +
                "                },\n" +
                "                \"reposts_count\": 0,\n" +
                "                \"comments_count\": 0,\n" +
                "                \"attitudes_count\": 0,\n" +
                "                \"isLongText\": false,\n" +
                "                \"mlevel\": 0,\n" +
                "                \"visible\": {\n" +
                "                    \"type\": 0,\n" +
                "                    \"list_id\": 0\n" +
                "                },\n" +
                "                \"biz_ids\": [\n" +
                "                    230442\n" +
                "                ],\n" +
                "                \"biz_feature\": 0,\n" +
                "                \"page_type\": 32,\n" +
                "                \"hasActionTypeCard\": 0,\n" +
                "                \"darwin_tags\": [],\n" +
                "                \"hot_weibo_tags\": [],\n" +
                "                \"text_tag_tips\": [],\n" +
                "                \"userType\": 0,\n" +
                "                \"positive_recom_flag\": 0,\n" +
                "                \"gif_ids\": \"\",\n" +
                "                \"is_show_bulletin\": 2\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"marks\": [],\n" +
                "    \"hasvisible\": false,\n" +
                "    \"previous_cursor\": 0,\n" +
                "    \"next_cursor\": 4060216071432556,\n" +
                "    \"total_number\": 9,\n" +
                "    \"since_id\": 0,\n" +
                "    \"max_id\": 4060216071432556,\n" +
                "    \"status\": {\n" +
                "        \"created_at\": \"Wed Jan 04 15:15:02 +0800 2017\",\n" +
                "        \"id\": 4060214787455271,\n" +
                "        \"mid\": \"4060214787455271\",\n" +
                "        \"idstr\": \"4060214787455271\",\n" +
                "        \"text\": \"【一款黑科技防抖勺 让手抖人群进食无忧】你身边有手抖的帕金森患者吗？你见过手抖患者是如何进餐的吗？“睿餐”防抖勺是一款专门帮助帕金森等手抖患者实现自主进餐的科技产品。#黑科技防抖勺#多神奇，我们一起看视频→→http://t.cn/RMAUTa2\",\n" +
                "        \"textLength\": 224,\n" +
                "        \"source_allowclick\": 0,\n" +
                "        \"source_type\": 1,\n" +
                "        \"source\": \"<a href=\\\"http://app.weibo.com/t/feed/6vtZb0\\\" rel=\\\"nofollow\\\">微博 weibo.com</a>\",\n" +
                "        \"favorited\": false,\n" +
                "        \"truncated\": false,\n" +
                "        \"in_reply_to_status_id\": \"\",\n" +
                "        \"in_reply_to_user_id\": \"\",\n" +
                "        \"in_reply_to_screen_name\": \"\",\n" +
                "        \"pic_urls\": [],\n" +
                "        \"geo\": null,\n" +
                "        \"user\": {\n" +
                "            \"id\": 1314608344,\n" +
                "            \"idstr\": \"1314608344\",\n" +
                "            \"class\": 1,\n" +
                "            \"screen_name\": \"新闻晨报\",\n" +
                "            \"name\": \"新闻晨报\",\n" +
                "            \"province\": \"31\",\n" +
                "            \"city\": \"12\",\n" +
                "            \"location\": \"上海 闵行区\",\n" +
                "            \"description\": \"新媒体合作：qq:2549671421； 曝料热线：021-63529999 ； 客服热线：8008190000、4006200000\",\n" +
                "            \"url\": \"\",\n" +
                "            \"profile_image_url\": \"http://tva4.sinaimg.cn/crop.49.65.610.610.50/4e5b54d8jw8ev7lxmkc5nj20j60isq4r.jpg\",\n" +
                "            \"cover_image\": \"http://ww4.sinaimg.cn/crop.0.0.920.300/4e5b54d8gw1e9qkzwowpyj20r80cytf5.jpg\",\n" +
                "            \"cover_image_phone\": \"http://ww3.sinaimg.cn/crop.0.0.640.640.640/4e5b54d8gw1f5ht4jiiqqj20e80e275d.jpg;http://ww3.sinaimg.cn/crop.0.0.640.640.640/4e5b54d8gw1f5ht50z9rnj20dw0e8abd.jpg;http://ww3.sinaimg.cn/crop.0.0.640.640.640/4e5b54d8gw1f5ht2rqc0cj20e80e875a.jpg;http://ww4.sinaimg.cn/crop.0.0.640.640.640/4e5b54d8gw1f5ht187x2yj20e50e8gnj.jpg;http://ww3.sinaimg.cn/crop.0.0.640.640.640/6ce2240djw1e9oae3wb1pj20hs0hs77c.jpg\",\n" +
                "            \"profile_url\": \"shmorningpost\",\n" +
                "            \"domain\": \"shmorningpost\",\n" +
                "            \"weihao\": \"\",\n" +
                "            \"gender\": \"m\",\n" +
                "            \"followers_count\": 28264574,\n" +
                "            \"friends_count\": 764,\n" +
                "            \"pagefriends_count\": 116,\n" +
                "            \"statuses_count\": 85014,\n" +
                "            \"favourites_count\": 3818,\n" +
                "            \"created_at\": \"Fri Aug 28 16:35:43 +0800 2009\",\n" +
                "            \"following\": true,\n" +
                "            \"allow_all_act_msg\": false,\n" +
                "            \"geo_enabled\": false,\n" +
                "            \"verified\": true,\n" +
                "            \"verified_type\": 3,\n" +
                "            \"remark\": \"\",\n" +
                "            \"ptype\": 0,\n" +
                "            \"allow_all_comment\": true,\n" +
                "            \"avatar_large\": \"http://tva4.sinaimg.cn/crop.49.65.610.610.180/4e5b54d8jw8ev7lxmkc5nj20j60isq4r.jpg\",\n" +
                "            \"avatar_hd\": \"http://tva4.sinaimg.cn/crop.49.65.610.610.1024/4e5b54d8jw8ev7lxmkc5nj20j60isq4r.jpg\",\n" +
                "            \"verified_reason\": \"《新闻晨报》官方微博\",\n" +
                "            \"verified_trade\": \"\",\n" +
                "            \"verified_reason_url\": \"\",\n" +
                "            \"verified_source\": \"\",\n" +
                "            \"verified_source_url\": \"\",\n" +
                "            \"verified_state\": 0,\n" +
                "            \"verified_level\": 3,\n" +
                "            \"verified_type_ext\": 0,\n" +
                "            \"verified_reason_modified\": \"\",\n" +
                "            \"verified_contact_name\": \"\",\n" +
                "            \"verified_contact_email\": \"\",\n" +
                "            \"verified_contact_mobile\": \"\",\n" +
                "            \"follow_me\": false,\n" +
                "            \"online_status\": 0,\n" +
                "            \"bi_followers_count\": 493,\n" +
                "            \"lang\": \"zh-cn\",\n" +
                "            \"star\": 0,\n" +
                "            \"mbtype\": 12,\n" +
                "            \"mbrank\": 5,\n" +
                "            \"block_word\": 0,\n" +
                "            \"block_app\": 1,\n" +
                "            \"credit_score\": 80,\n" +
                "            \"user_ability\": 99844,\n" +
                "            \"urank\": 41\n" +
                "        },\n" +
                "        \"reposts_count\": 5,\n" +
                "        \"comments_count\": 9,\n" +
                "        \"attitudes_count\": 32,\n" +
                "        \"isLongText\": false,\n" +
                "        \"mlevel\": 0,\n" +
                "        \"visible\": {\n" +
                "            \"type\": 0,\n" +
                "            \"list_id\": 0\n" +
                "        },\n" +
                "        \"biz_ids\": [\n" +
                "            230442\n" +
                "        ],\n" +
                "        \"biz_feature\": 0,\n" +
                "        \"page_type\": 32,\n" +
                "        \"hasActionTypeCard\": 0,\n" +
                "        \"darwin_tags\": [],\n" +
                "        \"hot_weibo_tags\": [],\n" +
                "        \"text_tag_tips\": [],\n" +
                "        \"userType\": 0,\n" +
                "        \"positive_recom_flag\": 0,\n" +
                "        \"gif_ids\": \"\",\n" +
                "        \"is_show_bulletin\": 2\n" +
                "    }\n" +
                "}", WeiboComment.class);
        System.out.print(result.getComments().size());
    }
}
