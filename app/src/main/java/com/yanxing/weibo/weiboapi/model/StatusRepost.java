package com.yanxing.weibo.weiboapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lishuangxiang on 2017/2/21.
 */
public class StatusRepost {

    /**
     * error : repeat content!
     * error_code : 20019
     * request : /2/comments/create.json
     */

    private String error;
    private int error_code;
    private String request;

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

    public void setError_code(int  error_code) {
        this.error_code = error_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     * created_at : Tue Feb 21 13:59:37 +0800 2017
     * id : 4077590421261958
     * mid : 4077590421261958
     * idstr : 4077590421261958
     * text : 转发微博
     * source_allowclick : 0
     * source_type : 1
     * source : <a href="http://open.weibo.com" rel="nofollow">未通过审核应用</a>
     * favorited : false
     * truncated : false
     * in_reply_to_status_id : 4077590056402268
     * in_reply_to_user_id : 3973518722
     * in_reply_to_screen_name : 合肥今天
     * pic_urls : []
     * geo : null
     * user : {"id":2334691000,"idstr":"2334691000","class":1,"screen_name":"困2011","name":"困2011","province":"31","city":"12","location":"上海 闵行区","description":"","url":"","profile_image_url":"http://tva1.sinaimg.cn/crop.0.0.996.996.50/8b288eb8jw8f9okbep13hj20ro0romz3.jpg","cover_image_phone":"http://ww2.sinaimg.cn/crop.0.0.640.640.640/a1d3feabjw1ecassls6b2j20hs0hsq50.jpg","profile_url":"u/2334691000","domain":"","weihao":"","gender":"m","followers_count":34,"friends_count":76,"pagefriends_count":0,"statuses_count":103,"favourites_count":15,"created_at":"Wed Aug 24 12:38:14 +0800 2011","following":false,"allow_all_act_msg":false,"geo_enabled":true,"verified":false,"verified_type":-1,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva1.sinaimg.cn/crop.0.0.996.996.180/8b288eb8jw8f9okbep13hj20ro0romz3.jpg","avatar_hd":"http://tva1.sinaimg.cn/crop.0.0.996.996.1024/8b288eb8jw8f9okbep13hj20ro0romz3.jpg","verified_reason":"","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","follow_me":false,"online_status":0,"bi_followers_count":19,"lang":"zh-cn","star":0,"mbtype":0,"mbrank":0,"block_word":0,"block_app":0,"credit_score":80,"user_ability":0,"urank":22}
     * retweeted_status : {"created_at":"Tue Feb 21 13:58:09 +0800 2017","id":4077590056402268,"mid":"4077590056402268","idstr":"4077590056402268","text":"#合肥身边事#【合肥上榜\u201c中国十大幸福城\u201d】20日下午，中国经济生活大调查2016-2017数据发布之夜在北京举行，现场发布了今年大调查幸福感最强的十大省会城市和直辖市，分别是拉萨、成都、长春、银川、天津、合肥、长沙、武汉、海口、石家庄。离家打拼的你在合肥生活的幸福吗？ http://t.cn/R2WxOni \u200b","textLength":277,"source_allowclick":1,"source_type":2,"source":"","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","pic_urls":[{"thumbnail_pic":"http://wx2.sinaimg.cn/thumbnail/ecd71582ly1fcy1s5zxpyj220w1iohdt.jpg"},{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/ecd71582ly1fcy1s7m5i7j220w1iohdu.jpg"},{"thumbnail_pic":"http://wx2.sinaimg.cn/thumbnail/ecd71582ly1fcy1roofh9j220w1iohdt.jpg"}],"thumbnail_pic":"http://wx2.sinaimg.cn/thumbnail/ecd71582ly1fcy1s5zxpyj220w1iohdt.jpg","bmiddle_pic":"http://wx2.sinaimg.cn/bmiddle/ecd71582ly1fcy1s5zxpyj220w1iohdt.jpg","original_pic":"http://wx2.sinaimg.cn/large/ecd71582ly1fcy1s5zxpyj220w1iohdt.jpg","geo":null,"user":{"id":3973518722,"idstr":"3973518722","class":1,"screen_name":"合肥今天","name":"合肥今天","province":"34","city":"1","location":"安徽 合肥","description":"有态度、有温度、有深度的本地资讯，大事、小事、身边事请@合肥今天！合作请私信。","url":"http://hflive.cc/","profile_image_url":"http://tva1.sinaimg.cn/crop.10.0.413.413.50/ecd71582jw8f5vjrz29t7j20bt0btgms.jpg","cover_image":"http://ww4.sinaimg.cn/crop.0.0.920.300/ecd71582gw1f5vk67tikvj20pk08cdhm.jpg","cover_image_phone":"http://ww2.sinaimg.cn/crop.0.0.640.640.640/ecd71582jw1erppokxq4uj20k00k0n1i.jpg","profile_url":"400156780","domain":"Zealsister","weihao":"400156780","gender":"m","followers_count":324593,"friends_count":174,"pagefriends_count":3,"statuses_count":9397,"favourites_count":3,"created_at":"Sat Jan 11 13:02:45 +0800 2014","following":false,"allow_all_act_msg":false,"geo_enabled":false,"verified":true,"verified_type":0,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva1.sinaimg.cn/crop.10.0.413.413.180/ecd71582jw8f5vjrz29t7j20bt0btgms.jpg","avatar_hd":"http://tva1.sinaimg.cn/crop.10.0.413.413.1024/ecd71582jw8f5vjrz29t7j20bt0btgms.jpg","verified_reason":"知名本地博主 微博本地资讯博主（合肥）拓展大使 资讯视频博主 微博社区委员会委员","verified_trade":"3376","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":1,"has_service_tel":false,"verified_reason_modified":"","verified_contact_name":"","verified_contact_email":"","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":125,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":6,"block_word":0,"block_app":1,"ability_tags":"新闻趣事","credit_score":80,"user_ability":2828,"cardid":"star_005","urank":36},"annotations":[{"place":{"lon":117.22746,"poiid":"8008634010000000000","title":"合肥","type":"checkin","lat":31.81634},"client_mblogid":"f27521ef-c765-43d9-a59e-942ab3f5c31e"},{"mapi_request":true}],"picStatus":"0:1,1:1,2:1","reposts_count":0,"comments_count":5,"attitudes_count":2,"isLongText":false,"mlevel":0,"visible":{"type":0,"list_id":0},"biz_ids":[100101],"biz_feature":4294967300,"page_type":40,"hasActionTypeCard":0,"darwin_tags":[],"hot_weibo_tags":[],"text_tag_tips":[],"userType":0,"cardid":"star_005","positive_recom_flag":0,"gif_ids":"","is_show_bulletin":2}
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

    private String created_at;
    private long id;
    private String mid;
    private String idstr;
    private String text;
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
    private RetweetedStatusBean retweeted_status;
    private long reposts_count;
    private long comments_count;
    private long attitudes_count;
    private boolean isLongText;
    private long mlevel;
    private VisibleBeanX visible;
    private long biz_feature;
    private long hasActionTypeCard;
    private long userType;
    private long positive_recom_flag;
    private Object gif_ids;
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

    public RetweetedStatusBean getRetweeted_status() {
        return retweeted_status;
    }

    public void setRetweeted_status(RetweetedStatusBean retweeted_status) {
        this.retweeted_status = retweeted_status;
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

    public VisibleBeanX getVisible() {
        return visible;
    }

    public void setVisible(VisibleBeanX visible) {
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

    public static class RetweetedStatusBean {
        /**
         * created_at : Tue Feb 21 13:58:09 +0800 2017
         * id : 4077590056402268
         * mid : 4077590056402268
         * idstr : 4077590056402268
         * text : #合肥身边事#【合肥上榜“中国十大幸福城”】20日下午，中国经济生活大调查2016-2017数据发布之夜在北京举行，现场发布了今年大调查幸福感最强的十大省会城市和直辖市，分别是拉萨、成都、长春、银川、天津、合肥、长沙、武汉、海口、石家庄。离家打拼的你在合肥生活的幸福吗？ http://t.cn/R2WxOni ​
         * textLength : 277
         * source_allowclick : 1
         * source_type : 2
         * source : 
         * favorited : false
         * truncated : false
         * in_reply_to_status_id : 
         * in_reply_to_user_id : 
         * in_reply_to_screen_name : 
         * pic_urls : [{"thumbnail_pic":"http://wx2.sinaimg.cn/thumbnail/ecd71582ly1fcy1s5zxpyj220w1iohdt.jpg"},{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/ecd71582ly1fcy1s7m5i7j220w1iohdu.jpg"},{"thumbnail_pic":"http://wx2.sinaimg.cn/thumbnail/ecd71582ly1fcy1roofh9j220w1iohdt.jpg"}]
         * thumbnail_pic : http://wx2.sinaimg.cn/thumbnail/ecd71582ly1fcy1s5zxpyj220w1iohdt.jpg
         * bmiddle_pic : http://wx2.sinaimg.cn/bmiddle/ecd71582ly1fcy1s5zxpyj220w1iohdt.jpg
         * original_pic : http://wx2.sinaimg.cn/large/ecd71582ly1fcy1s5zxpyj220w1iohdt.jpg
         * geo : null
         * user : {"id":3973518722,"idstr":"3973518722","class":1,"screen_name":"合肥今天","name":"合肥今天","province":"34","city":"1","location":"安徽 合肥","description":"有态度、有温度、有深度的本地资讯，大事、小事、身边事请@合肥今天！合作请私信。","url":"http://hflive.cc/","profile_image_url":"http://tva1.sinaimg.cn/crop.10.0.413.413.50/ecd71582jw8f5vjrz29t7j20bt0btgms.jpg","cover_image":"http://ww4.sinaimg.cn/crop.0.0.920.300/ecd71582gw1f5vk67tikvj20pk08cdhm.jpg","cover_image_phone":"http://ww2.sinaimg.cn/crop.0.0.640.640.640/ecd71582jw1erppokxq4uj20k00k0n1i.jpg","profile_url":"400156780","domain":"Zealsister","weihao":"400156780","gender":"m","followers_count":324593,"friends_count":174,"pagefriends_count":3,"statuses_count":9397,"favourites_count":3,"created_at":"Sat Jan 11 13:02:45 +0800 2014","following":false,"allow_all_act_msg":false,"geo_enabled":false,"verified":true,"verified_type":0,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva1.sinaimg.cn/crop.10.0.413.413.180/ecd71582jw8f5vjrz29t7j20bt0btgms.jpg","avatar_hd":"http://tva1.sinaimg.cn/crop.10.0.413.413.1024/ecd71582jw8f5vjrz29t7j20bt0btgms.jpg","verified_reason":"知名本地博主 微博本地资讯博主（合肥）拓展大使 资讯视频博主 微博社区委员会委员","verified_trade":"3376","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":1,"has_service_tel":false,"verified_reason_modified":"","verified_contact_name":"","verified_contact_email":"","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":125,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":6,"block_word":0,"block_app":1,"ability_tags":"新闻趣事","credit_score":80,"user_ability":2828,"cardid":"star_005","urank":36}
         * annotations : [{"place":{"lon":117.22746,"poiid":"8008634010000000000","title":"合肥","type":"checkin","lat":31.81634},"client_mblogid":"f27521ef-c765-43d9-a59e-942ab3f5c31e"},{"mapi_request":true}]
         * picStatus : 0:1,1:1,2:1
         * reposts_count : 0
         * comments_count : 5
         * attitudes_count : 2
         * isLongText : false
         * mlevel : 0
         * visible : {"type":0,"list_id":0}
         * biz_ids : [100101]
         * biz_feature : 4294967300
         * page_type : 40
         * hasActionTypeCard : 0
         * darwin_tags : []
         * hot_weibo_tags : []
         * text_tag_tips : []
         * userType : 0
         * cardid : star_005
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
        private String thumbnail_pic;
        private String bmiddle_pic;
        private String original_pic;
        private Object geo;
        private UserBeanX user;
        private String picStatus;
        private long reposts_count;
        private long comments_count;
        private long attitudes_count;
        private boolean isLongText;
        private long mlevel;
        private VisibleBean visible;
        private long biz_feature;
        private long page_type;
        private long hasActionTypeCard;
        private long userType;
        private String cardid;
        private long positive_recom_flag;
        private String gif_ids;
        private long is_show_bulletin;
        private List<PicUrlsBean> pic_urls;
        private List<AnnotationsBean> annotations;
        private List<Integer> biz_ids;
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

        public String getThumbnail_pic() {
            return thumbnail_pic;
        }

        public void setThumbnail_pic(String thumbnail_pic) {
            this.thumbnail_pic = thumbnail_pic;
        }

        public String getBmiddle_pic() {
            return bmiddle_pic;
        }

        public void setBmiddle_pic(String bmiddle_pic) {
            this.bmiddle_pic = bmiddle_pic;
        }

        public String getOriginal_pic() {
            return original_pic;
        }

        public void setOriginal_pic(String original_pic) {
            this.original_pic = original_pic;
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

        public String getPicStatus() {
            return picStatus;
        }

        public void setPicStatus(String picStatus) {
            this.picStatus = picStatus;
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

        public long getPage_type() {
            return page_type;
        }

        public void setPage_type(long page_type) {
            this.page_type = page_type;
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

        public String getCardid() {
            return cardid;
        }

        public void setCardid(String cardid) {
            this.cardid = cardid;
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

        public List<PicUrlsBean> getPic_urls() {
            return pic_urls;
        }

        public void setPic_urls(List<PicUrlsBean> pic_urls) {
            this.pic_urls = pic_urls;
        }

        public List<AnnotationsBean> getAnnotations() {
            return annotations;
        }

        public void setAnnotations(List<AnnotationsBean> annotations) {
            this.annotations = annotations;
        }

        public List<Integer> getBiz_ids() {
            return biz_ids;
        }

        public void setBiz_ids(List<Integer> biz_ids) {
            this.biz_ids = biz_ids;
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
             * id : 3973518722
             * idstr : 3973518722
             * class : 1
             * screen_name : 合肥今天
             * name : 合肥今天
             * province : 34
             * city : 1
             * location : 安徽 合肥
             * description : 有态度、有温度、有深度的本地资讯，大事、小事、身边事请@合肥今天！合作请私信。
             * url : http://hflive.cc/
             * profile_image_url : http://tva1.sinaimg.cn/crop.10.0.413.413.50/ecd71582jw8f5vjrz29t7j20bt0btgms.jpg
             * cover_image : http://ww4.sinaimg.cn/crop.0.0.920.300/ecd71582gw1f5vk67tikvj20pk08cdhm.jpg
             * cover_image_phone : http://ww2.sinaimg.cn/crop.0.0.640.640.640/ecd71582jw1erppokxq4uj20k00k0n1i.jpg
             * profile_url : 400156780
             * domain : Zealsister
             * weihao : 400156780
             * gender : m
             * followers_count : 324593
             * friends_count : 174
             * pagefriends_count : 3
             * statuses_count : 9397
             * favourites_count : 3
             * created_at : Sat Jan 11 13:02:45 +0800 2014
             * following : false
             * allow_all_act_msg : false
             * geo_enabled : false
             * verified : true
             * verified_type : 0
             * remark : 
             * insecurity : {"sexual_content":false}
             * ptype : 0
             * allow_all_comment : true
             * avatar_large : http://tva1.sinaimg.cn/crop.10.0.413.413.180/ecd71582jw8f5vjrz29t7j20bt0btgms.jpg
             * avatar_hd : http://tva1.sinaimg.cn/crop.10.0.413.413.1024/ecd71582jw8f5vjrz29t7j20bt0btgms.jpg
             * verified_reason : 知名本地博主 微博本地资讯博主（合肥）拓展大使 资讯视频博主 微博社区委员会委员
             * verified_trade : 3376
             * verified_reason_url : 
             * verified_source : 
             * verified_source_url : 
             * verified_state : 0
             * verified_level : 3
             * verified_type_ext : 1
             * has_service_tel : false
             * verified_reason_modified : 
             * verified_contact_name : 
             * verified_contact_email : 
             * verified_contact_mobile : 
             * follow_me : false
             * online_status : 0
             * bi_followers_count : 125
             * lang : zh-cn
             * star : 0
             * mbtype : 12
             * mbrank : 6
             * block_word : 0
             * block_app : 1
             * ability_tags : 新闻趣事
             * credit_score : 80
             * user_ability : 2828
             * cardid : star_005
             * urank : 36
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
            private boolean has_service_tel;
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
            private String ability_tags;
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

            public boolean isHas_service_tel() {
                return has_service_tel;
            }

            public void setHas_service_tel(boolean has_service_tel) {
                this.has_service_tel = has_service_tel;
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

            public String getAbility_tags() {
                return ability_tags;
            }

            public void setAbility_tags(String ability_tags) {
                this.ability_tags = ability_tags;
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

        public static class PicUrlsBean {
            /**
             * thumbnail_pic : http://wx2.sinaimg.cn/thumbnail/ecd71582ly1fcy1s5zxpyj220w1iohdt.jpg
             */

            private String thumbnail_pic;

            public String getThumbnail_pic() {
                return thumbnail_pic;
            }

            public void setThumbnail_pic(String thumbnail_pic) {
                this.thumbnail_pic = thumbnail_pic;
            }
        }

        public static class AnnotationsBean {
            /**
             * place : {"lon":117.22746,"poiid":"8008634010000000000","title":"合肥","type":"checkin","lat":31.81634}
             * client_mblogid : f27521ef-c765-43d9-a59e-942ab3f5c31e
             * mapi_request : true
             */

            private PlaceBean place;
            private String client_mblogid;
            private boolean mapi_request;

            public PlaceBean getPlace() {
                return place;
            }

            public void setPlace(PlaceBean place) {
                this.place = place;
            }

            public String getClient_mblogid() {
                return client_mblogid;
            }

            public void setClient_mblogid(String client_mblogid) {
                this.client_mblogid = client_mblogid;
            }

            public boolean isMapi_request() {
                return mapi_request;
            }

            public void setMapi_request(boolean mapi_request) {
                this.mapi_request = mapi_request;
            }

            public static class PlaceBean {
                /**
                 * lon : 117.22746
                 * poiid : 8008634010000000000
                 * title : 合肥
                 * type : checkin
                 * lat : 31.81634
                 */

                private double lon;
                private String poiid;
                private String title;
                private String type;
                private double lat;

                public double getLon() {
                    return lon;
                }

                public void setLon(double lon) {
                    this.lon = lon;
                }

                public String getPoiid() {
                    return poiid;
                }

                public void setPoiid(String poiid) {
                    this.poiid = poiid;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }
            }
        }
    }

    public static class VisibleBeanX {
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
