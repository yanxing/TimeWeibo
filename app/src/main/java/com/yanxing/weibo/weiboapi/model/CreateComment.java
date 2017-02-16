package com.yanxing.weibo.weiboapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lishuangxiang on 2017/2/15.
 */
public class CreateComment {



    /**
     * created_at : Thu Feb 16 11:20:28 +0800 2017
     * id : 4075738431432650
     * rootid : 4075738431432650
     * floor_number : 23
     * text : [doge]
     * source_allowclick : 0
     * source_type : 1
     * source : <a href="http://open.weibo.com" rel="nofollow">未通过审核应用</a>
     * user : {"id":1935306844,"idstr":"1935306844","class":1,"screen_name":"lyxtime","name":"lyxtime","province":"34","city":"16","location":"安徽 亳州","description":"Follow your heart and intuition","url":"http://blog.sina.com.cn/u/1935306844","profile_image_url":"http://tva2.sinaimg.cn/crop.0.0.180.180.50/735a705cjw1e8qgp5bmzyj2050050aa8.jpg","cover_image_phone":"http://ww1.sinaimg.cn/crop.0.0.640.640.640/549d0121tw1egm1kjly3jj20hs0hsq4f.jpg","profile_url":"lishuangxiang","domain":"lishuangxiang","weihao":"","gender":"m","followers_count":138,"friends_count":41,"pagefriends_count":0,"statuses_count":2255,"favourites_count":56,"created_at":"Wed Feb 09 19:08:19 +0800 2011","following":false,"allow_all_act_msg":false,"geo_enabled":false,"verified":false,"verified_type":-1,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva2.sinaimg.cn/crop.0.0.180.180.180/735a705cjw1e8qgp5bmzyj2050050aa8.jpg","avatar_hd":"http://tva2.sinaimg.cn/crop.0.0.180.180.1024/735a705cjw1e8qgp5bmzyj2050050aa8.jpg","verified_reason":"","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","follow_me":false,"online_status":0,"bi_followers_count":7,"lang":"zh-cn","star":0,"mbtype":2,"mbrank":2,"block_word":0,"block_app":0,"credit_score":80,"user_ability":0,"cardid":"star_044","urank":27}
     * mid : 4075738431432650
     * idstr : 4075738431432650
     * status : {"created_at":"Thu Feb 16 11:15:31 +0800 2017","id":4075737185110013,"mid":"4075737185110013","idstr":"4075737185110013","text":"话说。。圆通是不是有个大新闻？[衰][衰]\n\u201c我的8件快递在北京花园桥站点停了半个多月了 一直收不到 今天我就去这个站点取 地点在：北京市海淀区杏石口路43号，到了以后 没有工作人员，几万件快递说让我自己翻。我和家人找了两个小时，一件都没找到，同时也有几个和我一样的收件人来找自己的件儿。基本...全文： http://m.weibo.cn/1750070171/4075737185110013 \u200b","textLength":544,"source_allowclick":0,"source_type":1,"source":"<a href=\"http://app.weibo.com/t/feed/6vtZb0\" rel=\"nofollow\">微博 weibo.com<\/a>","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","pic_urls":[],"geo":null,"user":{"id":1750070171,"idstr":"1750070171","class":1,"screen_name":"36氪","name":"36氪","province":"11","city":"8","location":"北京 海淀区","description":"36氪是中国最具影响力的互联网创投媒体，提供最新锐最具深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。","url":"http://www.36kr.com","profile_image_url":"http://tva3.sinaimg.cn/crop.133.113.754.754.50/684ff39bgw1f6wlmiignrj20rt0rtta8.jpg","cover_image":"http://ww1.sinaimg.cn/crop.0.0.980.300/684ff39bjw1e441ux8kdxj20r808c78p.jpg","cover_image_phone":"http://ww1.sinaimg.cn/crop.0.0.640.640.640/a1d3feabjw1ecat4uqw77j20hs0hsacp.jpg","profile_url":"wow36kr","domain":"wow36kr","weihao":"","gender":"m","followers_count":1162047,"friends_count":577,"pagefriends_count":44,"statuses_count":63329,"favourites_count":229,"created_at":"Wed Jun 02 18:57:27 +0800 2010","following":true,"allow_all_act_msg":true,"geo_enabled":true,"verified":true,"verified_type":3,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva3.sinaimg.cn/crop.133.113.754.754.180/684ff39bgw1f6wlmiignrj20rt0rtta8.jpg","avatar_hd":"http://tva3.sinaimg.cn/crop.133.113.754.754.1024/684ff39bgw1f6wlmiignrj20rt0rtta8.jpg","verified_reason":"36氪官方微博","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":0,"verified_reason_modified":"","verified_contact_name":"投稿或爆料","verified_contact_email":"tips@36kr.com","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":411,"lang":"zh-cn","star":0,"mbtype":2,"mbrank":4,"block_word":0,"block_app":0,"dianping":"stock","credit_score":80,"user_ability":772,"urank":40},"reposts_count":10,"comments_count":21,"attitudes_count":5,"isLongText":true,"mlevel":0,"visible":{"type":0,"list_id":0},"biz_feature":0,"hasActionTypeCard":0,"darwin_tags":[],"hot_weibo_tags":[],"text_tag_tips":[],"userType":0,"positive_recom_flag":0,"gif_ids":"","is_show_bulletin":2}
     * appKey : 1669946568
     */

    private String created_at;
    private long id;
    private long rootid;
    private long floor_number;
    private String text;
    private long source_allowclick;
    private long source_type;
    private String source;
    private UserBean user;
    private String mid;
    private String idstr;
    private StatusBean status;
    private String appKey;
    /**
     * error : repeat content!
     * error_code : 20019
     * request : /2/comments/create.json
     */

    private String error;
    private int error_code;
    private String request;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRootid() {
        return rootid;
    }

    public void setRootid(long rootid) {
        this.rootid = rootid;
    }

    public long getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(long floor_number) {
        this.floor_number = floor_number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getSource_allowclick() {
        return source_allowclick;
    }

    public void setSource_allowclick(long source_allowclick) {
        this.source_allowclick = source_allowclick;
    }

    public long getSource_type() {
        return source_type;
    }

    public void setSource_type(long source_type) {
        this.source_type = source_type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public static class UserBean {
        /**
         * id : 1935306844
         * idstr : 1935306844
         * class : 1
         * screen_name : lyxtime
         * name : lyxtime
         * province : 34
         * city : 16
         * location : 安徽 亳州
         * description : Follow your heart and intuition
         * url : http://blog.sina.com.cn/u/1935306844
         * profile_image_url : http://tva2.sinaimg.cn/crop.0.0.180.180.50/735a705cjw1e8qgp5bmzyj2050050aa8.jpg
         * cover_image_phone : http://ww1.sinaimg.cn/crop.0.0.640.640.640/549d0121tw1egm1kjly3jj20hs0hsq4f.jpg
         * profile_url : lishuangxiang
         * domain : lishuangxiang
         * weihao : 
         * gender : m
         * followers_count : 138
         * friends_count : 41
         * pagefriends_count : 0
         * statuses_count : 2255
         * favourites_count : 56
         * created_at : Wed Feb 09 19:08:19 +0800 2011
         * following : false
         * allow_all_act_msg : false
         * geo_enabled : false
         * verified : false
         * verified_type : -1
         * remark : 
         * insecurity : {"sexual_content":false}
         * ptype : 0
         * allow_all_comment : true
         * avatar_large : http://tva2.sinaimg.cn/crop.0.0.180.180.180/735a705cjw1e8qgp5bmzyj2050050aa8.jpg
         * avatar_hd : http://tva2.sinaimg.cn/crop.0.0.180.180.1024/735a705cjw1e8qgp5bmzyj2050050aa8.jpg
         * verified_reason : 
         * verified_trade : 
         * verified_reason_url : 
         * verified_source : 
         * verified_source_url : 
         * follow_me : false
         * online_status : 0
         * bi_followers_count : 7
         * lang : zh-cn
         * star : 0
         * mbtype : 2
         * mbrank : 2
         * block_word : 0
         * block_app : 0
         * credit_score : 80
         * user_ability : 0
         * cardid : star_044
         * urank : 27
         */

        private long id;
        private String idstr;
        @SerializedName("class")
        private long classX;
        private String screen_name;
        private String name;
        private String province;
        private String city;
        private String location;
        private String description;
        private String url;
        private String profile_image_url;
        private String cover_image_phone;
        private String profile_url;
        private String domain;
        private String weihao;
        private String gender;
        private long followers_count;
        private long friends_count;
        private long pagefriends_count;
        private long statuses_count;
        private long favourites_count;
        private String created_at;
        private boolean following;
        private boolean allow_all_act_msg;
        private boolean geo_enabled;
        private boolean verified;
        private long verified_type;
        private String remark;
        private InsecurityBean insecurity;
        private long ptype;
        private boolean allow_all_comment;
        private String avatar_large;
        private String avatar_hd;
        private String verified_reason;
        private String verified_trade;
        private String verified_reason_url;
        private String verified_source;
        private String verified_source_url;
        private boolean follow_me;
        private long online_status;
        private long bi_followers_count;
        private String lang;
        private long star;
        private long mbtype;
        private long mbrank;
        private long block_word;
        private long block_app;
        private long credit_score;
        private long user_ability;
        private String cardid;
        private long urank;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getIdstr() {
            return idstr;
        }

        public void setIdstr(String idstr) {
            this.idstr = idstr;
        }

        public long getClassX() {
            return classX;
        }

        public void setClassX(long classX) {
            this.classX = classX;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProfile_image_url() {
            return profile_image_url;
        }

        public void setProfile_image_url(String profile_image_url) {
            this.profile_image_url = profile_image_url;
        }

        public String getCover_image_phone() {
            return cover_image_phone;
        }

        public void setCover_image_phone(String cover_image_phone) {
            this.cover_image_phone = cover_image_phone;
        }

        public String getProfile_url() {
            return profile_url;
        }

        public void setProfile_url(String profile_url) {
            this.profile_url = profile_url;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getWeihao() {
            return weihao;
        }

        public void setWeihao(String weihao) {
            this.weihao = weihao;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public long getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(long followers_count) {
            this.followers_count = followers_count;
        }

        public long getFriends_count() {
            return friends_count;
        }

        public void setFriends_count(long friends_count) {
            this.friends_count = friends_count;
        }

        public long getPagefriends_count() {
            return pagefriends_count;
        }

        public void setPagefriends_count(long pagefriends_count) {
            this.pagefriends_count = pagefriends_count;
        }

        public long getStatuses_count() {
            return statuses_count;
        }

        public void setStatuses_count(long statuses_count) {
            this.statuses_count = statuses_count;
        }

        public long getFavourites_count() {
            return favourites_count;
        }

        public void setFavourites_count(long favourites_count) {
            this.favourites_count = favourites_count;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public boolean isAllow_all_act_msg() {
            return allow_all_act_msg;
        }

        public void setAllow_all_act_msg(boolean allow_all_act_msg) {
            this.allow_all_act_msg = allow_all_act_msg;
        }

        public boolean isGeo_enabled() {
            return geo_enabled;
        }

        public void setGeo_enabled(boolean geo_enabled) {
            this.geo_enabled = geo_enabled;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public long getVerified_type() {
            return verified_type;
        }

        public void setVerified_type(long verified_type) {
            this.verified_type = verified_type;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public InsecurityBean getInsecurity() {
            return insecurity;
        }

        public void setInsecurity(InsecurityBean insecurity) {
            this.insecurity = insecurity;
        }

        public long getPtype() {
            return ptype;
        }

        public void setPtype(long ptype) {
            this.ptype = ptype;
        }

        public boolean isAllow_all_comment() {
            return allow_all_comment;
        }

        public void setAllow_all_comment(boolean allow_all_comment) {
            this.allow_all_comment = allow_all_comment;
        }

        public String getAvatar_large() {
            return avatar_large;
        }

        public void setAvatar_large(String avatar_large) {
            this.avatar_large = avatar_large;
        }

        public String getAvatar_hd() {
            return avatar_hd;
        }

        public void setAvatar_hd(String avatar_hd) {
            this.avatar_hd = avatar_hd;
        }

        public String getVerified_reason() {
            return verified_reason;
        }

        public void setVerified_reason(String verified_reason) {
            this.verified_reason = verified_reason;
        }

        public String getVerified_trade() {
            return verified_trade;
        }

        public void setVerified_trade(String verified_trade) {
            this.verified_trade = verified_trade;
        }

        public String getVerified_reason_url() {
            return verified_reason_url;
        }

        public void setVerified_reason_url(String verified_reason_url) {
            this.verified_reason_url = verified_reason_url;
        }

        public String getVerified_source() {
            return verified_source;
        }

        public void setVerified_source(String verified_source) {
            this.verified_source = verified_source;
        }

        public String getVerified_source_url() {
            return verified_source_url;
        }

        public void setVerified_source_url(String verified_source_url) {
            this.verified_source_url = verified_source_url;
        }

        public boolean isFollow_me() {
            return follow_me;
        }

        public void setFollow_me(boolean follow_me) {
            this.follow_me = follow_me;
        }

        public long getOnline_status() {
            return online_status;
        }

        public void setOnline_status(long online_status) {
            this.online_status = online_status;
        }

        public long getBi_followers_count() {
            return bi_followers_count;
        }

        public void setBi_followers_count(long bi_followers_count) {
            this.bi_followers_count = bi_followers_count;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public long getStar() {
            return star;
        }

        public void setStar(long star) {
            this.star = star;
        }

        public long getMbtype() {
            return mbtype;
        }

        public void setMbtype(long mbtype) {
            this.mbtype = mbtype;
        }

        public long getMbrank() {
            return mbrank;
        }

        public void setMbrank(long mbrank) {
            this.mbrank = mbrank;
        }

        public long getBlock_word() {
            return block_word;
        }

        public void setBlock_word(long block_word) {
            this.block_word = block_word;
        }

        public long getBlock_app() {
            return block_app;
        }

        public void setBlock_app(long block_app) {
            this.block_app = block_app;
        }

        public long getCredit_score() {
            return credit_score;
        }

        public void setCredit_score(long credit_score) {
            this.credit_score = credit_score;
        }

        public long getUser_ability() {
            return user_ability;
        }

        public void setUser_ability(long user_ability) {
            this.user_ability = user_ability;
        }

        public String getCardid() {
            return cardid;
        }

        public void setCardid(String cardid) {
            this.cardid = cardid;
        }

        public long getUrank() {
            return urank;
        }

        public void setUrank(long urank) {
            this.urank = urank;
        }

        public static class InsecurityBean {
            /**
             * sexual_content : false
             */

            private boolean sexual_content;

            public boolean isSexual_content() {
                return sexual_content;
            }

            public void setSexual_content(boolean sexual_content) {
                this.sexual_content = sexual_content;
            }
        }
    }

    public static class StatusBean {
        /**
         * created_at : Thu Feb 16 11:15:31 +0800 2017
         * id : 4075737185110013
         * mid : 4075737185110013
         * idstr : 4075737185110013
         * text : 话说。。圆通是不是有个大新闻？[衰][衰]
         “我的8件快递在北京花园桥站点停了半个多月了 一直收不到 今天我就去这个站点取 地点在：北京市海淀区杏石口路43号，到了以后 没有工作人员，几万件快递说让我自己翻。我和家人找了两个小时，一件都没找到，同时也有几个和我一样的收件人来找自己的件儿。基本...全文： http://m.weibo.cn/1750070171/4075737185110013 ​
         * textLength : 544
         * source_allowclick : 0
         * source_type : 1
         * source : <a href="http://app.weibo.com/t/feed/6vtZb0" rel="nofollow">微博 weibo.com</a>
         * favorited : false
         * truncated : false
         * in_reply_to_status_id : 
         * in_reply_to_user_id : 
         * in_reply_to_screen_name : 
         * pic_urls : []
         * geo : null
         * user : {"id":1750070171,"idstr":"1750070171","class":1,"screen_name":"36氪","name":"36氪","province":"11","city":"8","location":"北京 海淀区","description":"36氪是中国最具影响力的互联网创投媒体，提供最新锐最具深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。","url":"http://www.36kr.com","profile_image_url":"http://tva3.sinaimg.cn/crop.133.113.754.754.50/684ff39bgw1f6wlmiignrj20rt0rtta8.jpg","cover_image":"http://ww1.sinaimg.cn/crop.0.0.980.300/684ff39bjw1e441ux8kdxj20r808c78p.jpg","cover_image_phone":"http://ww1.sinaimg.cn/crop.0.0.640.640.640/a1d3feabjw1ecat4uqw77j20hs0hsacp.jpg","profile_url":"wow36kr","domain":"wow36kr","weihao":"","gender":"m","followers_count":1162047,"friends_count":577,"pagefriends_count":44,"statuses_count":63329,"favourites_count":229,"created_at":"Wed Jun 02 18:57:27 +0800 2010","following":true,"allow_all_act_msg":true,"geo_enabled":true,"verified":true,"verified_type":3,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva3.sinaimg.cn/crop.133.113.754.754.180/684ff39bgw1f6wlmiignrj20rt0rtta8.jpg","avatar_hd":"http://tva3.sinaimg.cn/crop.133.113.754.754.1024/684ff39bgw1f6wlmiignrj20rt0rtta8.jpg","verified_reason":"36氪官方微博","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":0,"verified_reason_modified":"","verified_contact_name":"投稿或爆料","verified_contact_email":"tips@36kr.com","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":411,"lang":"zh-cn","star":0,"mbtype":2,"mbrank":4,"block_word":0,"block_app":0,"dianping":"stock","credit_score":80,"user_ability":772,"urank":40}
         * reposts_count : 10
         * comments_count : 21
         * attitudes_count : 5
         * isLongText : true
         * mlevel : 0
         * visible : {"type":0,"list_id":0}
         * biz_feature : 0
         * hasActionTypeCard : 0
         * darwin_tags : []
         * hot_weibo_tags : []
         * text_tag_tips : []
         * userType : 0
         * positive_recom_flag : 0
         * gif_ids : 
         * is_show_bulletin : 2
         */

        private String created_at;
        private long id;
        private String mid;
        private String idstr;
        private String text;
        private long textLength;
        private long source_allowclick;
        private long source_type;
        private String source;
        private boolean favorited;
        private boolean truncated;
        private String in_reply_to_status_id;
        private String in_reply_to_user_id;
        private String in_reply_to_screen_name;
        private Object geo;
        private UserBeanX user;
        private long reposts_count;
        private long comments_count;
        private long attitudes_count;
        private boolean isLongText;
        private long mlevel;
        private VisibleBean visible;
        private long biz_feature;
        private long hasActionTypeCard;
        private long userType;
        private long positive_recom_flag;
        private String gif_ids;
        private long is_show_bulletin;
        private List<?> pic_urls;
        private List<?> darwin_tags;
        private List<?> hot_weibo_tags;
        private List<?> text_tag_tips;

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getIdstr() {
            return idstr;
        }

        public void setIdstr(String idstr) {
            this.idstr = idstr;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public long getTextLength() {
            return textLength;
        }

        public void setTextLength(long textLength) {
            this.textLength = textLength;
        }

        public long getSource_allowclick() {
            return source_allowclick;
        }

        public void setSource_allowclick(long source_allowclick) {
            this.source_allowclick = source_allowclick;
        }

        public long getSource_type() {
            return source_type;
        }

        public void setSource_type(long source_type) {
            this.source_type = source_type;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }

        public boolean isTruncated() {
            return truncated;
        }

        public void setTruncated(boolean truncated) {
            this.truncated = truncated;
        }

        public String getIn_reply_to_status_id() {
            return in_reply_to_status_id;
        }

        public void setIn_reply_to_status_id(String in_reply_to_status_id) {
            this.in_reply_to_status_id = in_reply_to_status_id;
        }

        public String getIn_reply_to_user_id() {
            return in_reply_to_user_id;
        }

        public void setIn_reply_to_user_id(String in_reply_to_user_id) {
            this.in_reply_to_user_id = in_reply_to_user_id;
        }

        public String getIn_reply_to_screen_name() {
            return in_reply_to_screen_name;
        }

        public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
            this.in_reply_to_screen_name = in_reply_to_screen_name;
        }

        public Object getGeo() {
            return geo;
        }

        public void setGeo(Object geo) {
            this.geo = geo;
        }

        public UserBeanX getUser() {
            return user;
        }

        public void setUser(UserBeanX user) {
            this.user = user;
        }

        public long getReposts_count() {
            return reposts_count;
        }

        public void setReposts_count(long reposts_count) {
            this.reposts_count = reposts_count;
        }

        public long getComments_count() {
            return comments_count;
        }

        public void setComments_count(long comments_count) {
            this.comments_count = comments_count;
        }

        public long getAttitudes_count() {
            return attitudes_count;
        }

        public void setAttitudes_count(long attitudes_count) {
            this.attitudes_count = attitudes_count;
        }

        public boolean isIsLongText() {
            return isLongText;
        }

        public void setIsLongText(boolean isLongText) {
            this.isLongText = isLongText;
        }

        public long getMlevel() {
            return mlevel;
        }

        public void setMlevel(long mlevel) {
            this.mlevel = mlevel;
        }

        public VisibleBean getVisible() {
            return visible;
        }

        public void setVisible(VisibleBean visible) {
            this.visible = visible;
        }

        public long getBiz_feature() {
            return biz_feature;
        }

        public void setBiz_feature(long biz_feature) {
            this.biz_feature = biz_feature;
        }

        public long getHasActionTypeCard() {
            return hasActionTypeCard;
        }

        public void setHasActionTypeCard(long hasActionTypeCard) {
            this.hasActionTypeCard = hasActionTypeCard;
        }

        public long getUserType() {
            return userType;
        }

        public void setUserType(long userType) {
            this.userType = userType;
        }

        public long getPositive_recom_flag() {
            return positive_recom_flag;
        }

        public void setPositive_recom_flag(long positive_recom_flag) {
            this.positive_recom_flag = positive_recom_flag;
        }

        public String getGif_ids() {
            return gif_ids;
        }

        public void setGif_ids(String gif_ids) {
            this.gif_ids = gif_ids;
        }

        public long getIs_show_bulletin() {
            return is_show_bulletin;
        }

        public void setIs_show_bulletin(long is_show_bulletin) {
            this.is_show_bulletin = is_show_bulletin;
        }

        public List<?> getPic_urls() {
            return pic_urls;
        }

        public void setPic_urls(List<?> pic_urls) {
            this.pic_urls = pic_urls;
        }

        public List<?> getDarwin_tags() {
            return darwin_tags;
        }

        public void setDarwin_tags(List<?> darwin_tags) {
            this.darwin_tags = darwin_tags;
        }

        public List<?> getHot_weibo_tags() {
            return hot_weibo_tags;
        }

        public void setHot_weibo_tags(List<?> hot_weibo_tags) {
            this.hot_weibo_tags = hot_weibo_tags;
        }

        public List<?> getText_tag_tips() {
            return text_tag_tips;
        }

        public void setText_tag_tips(List<?> text_tag_tips) {
            this.text_tag_tips = text_tag_tips;
        }

        public static class UserBeanX {
            /**
             * id : 1750070171
             * idstr : 1750070171
             * class : 1
             * screen_name : 36氪
             * name : 36氪
             * province : 11
             * city : 8
             * location : 北京 海淀区
             * description : 36氪是中国最具影响力的互联网创投媒体，提供最新锐最具深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。
             * url : http://www.36kr.com
             * profile_image_url : http://tva3.sinaimg.cn/crop.133.113.754.754.50/684ff39bgw1f6wlmiignrj20rt0rtta8.jpg
             * cover_image : http://ww1.sinaimg.cn/crop.0.0.980.300/684ff39bjw1e441ux8kdxj20r808c78p.jpg
             * cover_image_phone : http://ww1.sinaimg.cn/crop.0.0.640.640.640/a1d3feabjw1ecat4uqw77j20hs0hsacp.jpg
             * profile_url : wow36kr
             * domain : wow36kr
             * weihao : 
             * gender : m
             * followers_count : 1162047
             * friends_count : 577
             * pagefriends_count : 44
             * statuses_count : 63329
             * favourites_count : 229
             * created_at : Wed Jun 02 18:57:27 +0800 2010
             * following : true
             * allow_all_act_msg : true
             * geo_enabled : true
             * verified : true
             * verified_type : 3
             * remark : 
             * insecurity : {"sexual_content":false}
             * ptype : 0
             * allow_all_comment : true
             * avatar_large : http://tva3.sinaimg.cn/crop.133.113.754.754.180/684ff39bgw1f6wlmiignrj20rt0rtta8.jpg
             * avatar_hd : http://tva3.sinaimg.cn/crop.133.113.754.754.1024/684ff39bgw1f6wlmiignrj20rt0rtta8.jpg
             * verified_reason : 36氪官方微博
             * verified_trade : 
             * verified_reason_url : 
             * verified_source : 
             * verified_source_url : 
             * verified_state : 0
             * verified_level : 3
             * verified_type_ext : 0
             * verified_reason_modified : 
             * verified_contact_name : 投稿或爆料
             * verified_contact_email : tips@36kr.com
             * verified_contact_mobile : 
             * follow_me : false
             * online_status : 0
             * bi_followers_count : 411
             * lang : zh-cn
             * star : 0
             * mbtype : 2
             * mbrank : 4
             * block_word : 0
             * block_app : 0
             * dianping : stock
             * credit_score : 80
             * user_ability : 772
             * urank : 40
             */

            private long id;
            private String idstr;
            @SerializedName("class")
            private long classX;
            private String screen_name;
            private String name;
            private String province;
            private String city;
            private String location;
            private String description;
            private String url;
            private String profile_image_url;
            private String cover_image;
            private String cover_image_phone;
            private String profile_url;
            private String domain;
            private String weihao;
            private String gender;
            private long followers_count;
            private long friends_count;
            private long pagefriends_count;
            private long statuses_count;
            private long favourites_count;
            private String created_at;
            private boolean following;
            private boolean allow_all_act_msg;
            private boolean geo_enabled;
            private boolean verified;
            private long verified_type;
            private String remark;
            private InsecurityBeanX insecurity;
            private long ptype;
            private boolean allow_all_comment;
            private String avatar_large;
            private String avatar_hd;
            private String verified_reason;
            private String verified_trade;
            private String verified_reason_url;
            private String verified_source;
            private String verified_source_url;
            private long verified_state;
            private long verified_level;
            private long verified_type_ext;
            private String verified_reason_modified;
            private String verified_contact_name;
            private String verified_contact_email;
            private String verified_contact_mobile;
            private boolean follow_me;
            private long online_status;
            private long bi_followers_count;
            private String lang;
            private long star;
            private long mbtype;
            private long mbrank;
            private long block_word;
            private long block_app;
            private String dianping;
            private long credit_score;
            private long user_ability;
            private long urank;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getIdstr() {
                return idstr;
            }

            public void setIdstr(String idstr) {
                this.idstr = idstr;
            }

            public long getClassX() {
                return classX;
            }

            public void setClassX(long classX) {
                this.classX = classX;
            }

            public String getScreen_name() {
                return screen_name;
            }

            public void setScreen_name(String screen_name) {
                this.screen_name = screen_name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getProfile_image_url() {
                return profile_image_url;
            }

            public void setProfile_image_url(String profile_image_url) {
                this.profile_image_url = profile_image_url;
            }

            public String getCover_image() {
                return cover_image;
            }

            public void setCover_image(String cover_image) {
                this.cover_image = cover_image;
            }

            public String getCover_image_phone() {
                return cover_image_phone;
            }

            public void setCover_image_phone(String cover_image_phone) {
                this.cover_image_phone = cover_image_phone;
            }

            public String getProfile_url() {
                return profile_url;
            }

            public void setProfile_url(String profile_url) {
                this.profile_url = profile_url;
            }

            public String getDomain() {
                return domain;
            }

            public void setDomain(String domain) {
                this.domain = domain;
            }

            public String getWeihao() {
                return weihao;
            }

            public void setWeihao(String weihao) {
                this.weihao = weihao;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public long getFollowers_count() {
                return followers_count;
            }

            public void setFollowers_count(long followers_count) {
                this.followers_count = followers_count;
            }

            public long getFriends_count() {
                return friends_count;
            }

            public void setFriends_count(long friends_count) {
                this.friends_count = friends_count;
            }

            public long getPagefriends_count() {
                return pagefriends_count;
            }

            public void setPagefriends_count(long pagefriends_count) {
                this.pagefriends_count = pagefriends_count;
            }

            public long getStatuses_count() {
                return statuses_count;
            }

            public void setStatuses_count(long statuses_count) {
                this.statuses_count = statuses_count;
            }

            public long getFavourites_count() {
                return favourites_count;
            }

            public void setFavourites_count(long favourites_count) {
                this.favourites_count = favourites_count;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public boolean isFollowing() {
                return following;
            }

            public void setFollowing(boolean following) {
                this.following = following;
            }

            public boolean isAllow_all_act_msg() {
                return allow_all_act_msg;
            }

            public void setAllow_all_act_msg(boolean allow_all_act_msg) {
                this.allow_all_act_msg = allow_all_act_msg;
            }

            public boolean isGeo_enabled() {
                return geo_enabled;
            }

            public void setGeo_enabled(boolean geo_enabled) {
                this.geo_enabled = geo_enabled;
            }

            public boolean isVerified() {
                return verified;
            }

            public void setVerified(boolean verified) {
                this.verified = verified;
            }

            public long getVerified_type() {
                return verified_type;
            }

            public void setVerified_type(long verified_type) {
                this.verified_type = verified_type;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public InsecurityBeanX getInsecurity() {
                return insecurity;
            }

            public void setInsecurity(InsecurityBeanX insecurity) {
                this.insecurity = insecurity;
            }

            public long getPtype() {
                return ptype;
            }

            public void setPtype(long ptype) {
                this.ptype = ptype;
            }

            public boolean isAllow_all_comment() {
                return allow_all_comment;
            }

            public void setAllow_all_comment(boolean allow_all_comment) {
                this.allow_all_comment = allow_all_comment;
            }

            public String getAvatar_large() {
                return avatar_large;
            }

            public void setAvatar_large(String avatar_large) {
                this.avatar_large = avatar_large;
            }

            public String getAvatar_hd() {
                return avatar_hd;
            }

            public void setAvatar_hd(String avatar_hd) {
                this.avatar_hd = avatar_hd;
            }

            public String getVerified_reason() {
                return verified_reason;
            }

            public void setVerified_reason(String verified_reason) {
                this.verified_reason = verified_reason;
            }

            public String getVerified_trade() {
                return verified_trade;
            }

            public void setVerified_trade(String verified_trade) {
                this.verified_trade = verified_trade;
            }

            public String getVerified_reason_url() {
                return verified_reason_url;
            }

            public void setVerified_reason_url(String verified_reason_url) {
                this.verified_reason_url = verified_reason_url;
            }

            public String getVerified_source() {
                return verified_source;
            }

            public void setVerified_source(String verified_source) {
                this.verified_source = verified_source;
            }

            public String getVerified_source_url() {
                return verified_source_url;
            }

            public void setVerified_source_url(String verified_source_url) {
                this.verified_source_url = verified_source_url;
            }

            public long getVerified_state() {
                return verified_state;
            }

            public void setVerified_state(long verified_state) {
                this.verified_state = verified_state;
            }

            public long getVerified_level() {
                return verified_level;
            }

            public void setVerified_level(long verified_level) {
                this.verified_level = verified_level;
            }

            public long getVerified_type_ext() {
                return verified_type_ext;
            }

            public void setVerified_type_ext(long verified_type_ext) {
                this.verified_type_ext = verified_type_ext;
            }

            public String getVerified_reason_modified() {
                return verified_reason_modified;
            }

            public void setVerified_reason_modified(String verified_reason_modified) {
                this.verified_reason_modified = verified_reason_modified;
            }

            public String getVerified_contact_name() {
                return verified_contact_name;
            }

            public void setVerified_contact_name(String verified_contact_name) {
                this.verified_contact_name = verified_contact_name;
            }

            public String getVerified_contact_email() {
                return verified_contact_email;
            }

            public void setVerified_contact_email(String verified_contact_email) {
                this.verified_contact_email = verified_contact_email;
            }

            public String getVerified_contact_mobile() {
                return verified_contact_mobile;
            }

            public void setVerified_contact_mobile(String verified_contact_mobile) {
                this.verified_contact_mobile = verified_contact_mobile;
            }

            public boolean isFollow_me() {
                return follow_me;
            }

            public void setFollow_me(boolean follow_me) {
                this.follow_me = follow_me;
            }

            public long getOnline_status() {
                return online_status;
            }

            public void setOnline_status(long online_status) {
                this.online_status = online_status;
            }

            public long getBi_followers_count() {
                return bi_followers_count;
            }

            public void setBi_followers_count(long bi_followers_count) {
                this.bi_followers_count = bi_followers_count;
            }

            public String getLang() {
                return lang;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public long getStar() {
                return star;
            }

            public void setStar(long star) {
                this.star = star;
            }

            public long getMbtype() {
                return mbtype;
            }

            public void setMbtype(long mbtype) {
                this.mbtype = mbtype;
            }

            public long getMbrank() {
                return mbrank;
            }

            public void setMbrank(long mbrank) {
                this.mbrank = mbrank;
            }

            public long getBlock_word() {
                return block_word;
            }

            public void setBlock_word(long block_word) {
                this.block_word = block_word;
            }

            public long getBlock_app() {
                return block_app;
            }

            public void setBlock_app(long block_app) {
                this.block_app = block_app;
            }

            public String getDianping() {
                return dianping;
            }

            public void setDianping(String dianping) {
                this.dianping = dianping;
            }

            public long getCredit_score() {
                return credit_score;
            }

            public void setCredit_score(long credit_score) {
                this.credit_score = credit_score;
            }

            public long getUser_ability() {
                return user_ability;
            }

            public void setUser_ability(long user_ability) {
                this.user_ability = user_ability;
            }

            public long getUrank() {
                return urank;
            }

            public void setUrank(long urank) {
                this.urank = urank;
            }

            public static class InsecurityBeanX {
                /**
                 * sexual_content : false
                 */

                private boolean sexual_content;

                public boolean isSexual_content() {
                    return sexual_content;
                }

                public void setSexual_content(boolean sexual_content) {
                    this.sexual_content = sexual_content;
                }
            }
        }

        public static class VisibleBean {
            /**
             * type : 0
             * list_id : 0
             */

            private long type;
            private long list_id;

            public long getType() {
                return type;
            }

            public void setType(long type) {
                this.type = type;
            }

            public long getList_id() {
                return list_id;
            }

            public void setList_id(long list_id) {
                this.list_id = list_id;
            }
        }
    }
}
