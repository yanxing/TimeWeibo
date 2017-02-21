package com.yanxing.weibo.weiboapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lishuangxiang on 2017/2/21.
 */
public class StatusesUpdate {

    /**
     * created_at : Tue Feb 21 14:56:26 +0800 2017
     * id : 4077604720331320
     * mid : 4077604720331320
     * idstr : 4077604720331320
     * text : test[doge] ​
     * textLength : 10
     * source_allowclick : 0
     * source_type : 1
     * source : <a href="http://open.weibo.com" rel="nofollow">未通过审核应用</a>
     * favorited : false
     * truncated : false
     * in_reply_to_status_id : 
     * in_reply_to_user_id : 
     * in_reply_to_screen_name : 
     * pic_urls : []
     * geo : null
     * user : {"id":2334691000,"idstr":"2334691000","class":1,"screen_name":"困2011","name":"困2011","province":"31","city":"12","location":"上海 闵行区","description":"","url":"","profile_image_url":"http://tva1.sinaimg.cn/crop.0.0.996.996.50/8b288eb8jw8f9okbep13hj20ro0romz3.jpg","cover_image_phone":"http://ww2.sinaimg.cn/crop.0.0.640.640.640/a1d3feabjw1ecassls6b2j20hs0hsq50.jpg","profile_url":"u/2334691000","domain":"","weihao":"","gender":"m","followers_count":34,"friends_count":76,"pagefriends_count":0,"statuses_count":103,"favourites_count":15,"created_at":"Wed Aug 24 12:38:14 +0800 2011","following":false,"allow_all_act_msg":false,"geo_enabled":true,"verified":false,"verified_type":-1,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva1.sinaimg.cn/crop.0.0.996.996.180/8b288eb8jw8f9okbep13hj20ro0romz3.jpg","avatar_hd":"http://tva1.sinaimg.cn/crop.0.0.996.996.1024/8b288eb8jw8f9okbep13hj20ro0romz3.jpg","verified_reason":"","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","follow_me":false,"online_status":0,"bi_followers_count":19,"lang":"zh-cn","star":0,"mbtype":0,"mbrank":0,"block_word":0,"block_app":0,"credit_score":80,"user_ability":0,"urank":22}
     * annotations : [{"source":"TimeWeiBo"}]
     * reposts_count : 0
     * comments_count : 0
     * attitudes_count : 0
     * isLongText : false
     * mlevel : 0
     * visible : {"type":0,"list_id":0}
     * biz_feature : 0
     * hasActionTypeCard : 0
     * darwin_tags : []
     * hot_weibo_tags : []
     * text_tag_tips : []
     * userType : 590081
     * positive_recom_flag : 0
     * gif_ids : null
     * is_show_bulletin : 2
     */

    /**
     * error : repeat content!
     * error_code : 20019
     * request : /2/comments/create.json
     */

    private String error;
    private int error_code;
    private String request;

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
    private UserBean user;
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
    private Object gif_ids;
    private long is_show_bulletin;
    private List<?> pic_urls;
    private List<AnnotationsBean> annotations;
    private List<?> darwin_tags;
    private List<?> hot_weibo_tags;
    private List<?> text_tag_tips;

    public boolean isLongText() {
        return isLongText;
    }

    public void setLongText(boolean longText) {
        isLongText = longText;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
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

    public Object getGif_ids() {
        return gif_ids;
    }

    public void setGif_ids(Object gif_ids) {
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

    public List<AnnotationsBean> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<AnnotationsBean> annotations) {
        this.annotations = annotations;
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

    public static class UserBean {
        /**
         * id : 2334691000
         * idstr : 2334691000
         * class : 1
         * screen_name : 困2011
         * name : 困2011
         * province : 31
         * city : 12
         * location : 上海 闵行区
         * description : 
         * url : 
         * profile_image_url : http://tva1.sinaimg.cn/crop.0.0.996.996.50/8b288eb8jw8f9okbep13hj20ro0romz3.jpg
         * cover_image_phone : http://ww2.sinaimg.cn/crop.0.0.640.640.640/a1d3feabjw1ecassls6b2j20hs0hsq50.jpg
         * profile_url : u/2334691000
         * domain : 
         * weihao : 
         * gender : m
         * followers_count : 34
         * friends_count : 76
         * pagefriends_count : 0
         * statuses_count : 103
         * favourites_count : 15
         * created_at : Wed Aug 24 12:38:14 +0800 2011
         * following : false
         * allow_all_act_msg : false
         * geo_enabled : true
         * verified : false
         * verified_type : -1
         * remark : 
         * insecurity : {"sexual_content":false}
         * ptype : 0
         * allow_all_comment : true
         * avatar_large : http://tva1.sinaimg.cn/crop.0.0.996.996.180/8b288eb8jw8f9okbep13hj20ro0romz3.jpg
         * avatar_hd : http://tva1.sinaimg.cn/crop.0.0.996.996.1024/8b288eb8jw8f9okbep13hj20ro0romz3.jpg
         * verified_reason : 
         * verified_trade : 
         * verified_reason_url : 
         * verified_source : 
         * verified_source_url : 
         * follow_me : false
         * online_status : 0
         * bi_followers_count : 19
         * lang : zh-cn
         * star : 0
         * mbtype : 0
         * mbrank : 0
         * block_word : 0
         * block_app : 0
         * credit_score : 80
         * user_ability : 0
         * urank : 22
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

    public static class AnnotationsBean {
        /**
         * source : TimeWeiBo
         */

        private String source;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
