package com.yanxing.weibo.weiboapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 李双祥 on 2016/12/23.
 */

public class FriendTimeLine {

    private boolean hasvisible;
    private long previous_cursor;
    private long next_cursor;
    private long total_number;
    private long interval;
    private long uve_blank;
    private long since_id;
    private long max_id;
    private long has_unread;
    private List<StatusesBean> statuses;
    private List<?> advertises;
    private List<?> ad;

    public boolean isHasvisible() {
        return hasvisible;
    }

    public void setHasvisible(boolean hasvisible) {
        this.hasvisible = hasvisible;
    }

    public long getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(long previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public long getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(long next_cursor) {
        this.next_cursor = next_cursor;
    }

    public long getTotal_number() {
        return total_number;
    }

    public void setTotal_number(long total_number) {
        this.total_number = total_number;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public long getUve_blank() {
        return uve_blank;
    }

    public void setUve_blank(long uve_blank) {
        this.uve_blank = uve_blank;
    }

    public long getSince_id() {
        return since_id;
    }

    public void setSince_id(long since_id) {
        this.since_id = since_id;
    }

    public long getMax_id() {
        return max_id;
    }

    public void setMax_id(long max_id) {
        this.max_id = max_id;
    }

    public long getHas_unread() {
        return has_unread;
    }

    public void setHas_unread(long has_unread) {
        this.has_unread = has_unread;
    }

    public List<StatusesBean> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<StatusesBean> statuses) {
        this.statuses = statuses;
    }

    public List<?> getAdvertises() {
        return advertises;
    }

    public void setAdvertises(List<?> advertises) {
        this.advertises = advertises;
    }

    public List<?> getAd() {
        return ad;
    }

    public void setAd(List<?> ad) {
        this.ad = ad;
    }

    public static class StatusesBean {

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
        private Geo geo;
        private UserBean user;
        private long reposts_count;
        private long comments_count;
        private long attitudes_count;
        private boolean isLongText;
        private long mlevel;
        private VisibleBean visible;
        private long biz_feature;
        private long hasActionTypeCard;
        private String rid;
        private long userType;
        private String cardid;
        private long positive_recom_flag;
        private String gif_ids;
        private long is_show_bulletin;
        private RetweetedStatusBean retweeted_status;
        private String thumbnail_pic;
        private String bmiddle_pic;
        private String original_pic;
        private String picStatus;
        private long page_type;
        private List<?> pic_urls;
        private List<AnnotationsBeanX> annotations;
        private List<Integer> biz_ids;
        private List<?> darwin_tags;
        private List<?> hot_weibo_tags;
        private List<?> text_tag_tips;
        private String location;

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
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

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
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

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
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

        public RetweetedStatusBean getRetweeted_status() {
            return retweeted_status;
        }

        public void setRetweeted_status(RetweetedStatusBean retweeted_status) {
            this.retweeted_status = retweeted_status;
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

        public String getPicStatus() {
            return picStatus;
        }

        public void setPicStatus(String picStatus) {
            this.picStatus = picStatus;
        }

        public long getPage_type() {
            return page_type;
        }

        public void setPage_type(long page_type) {
            this.page_type = page_type;
        }

        public List<?> getPic_urls() {
            return pic_urls;
        }

        public void setPic_urls(List<?> pic_urls) {
            this.pic_urls = pic_urls;
        }

        public List<AnnotationsBeanX> getAnnotations() {
            return annotations;
        }

        public void setAnnotations(List<AnnotationsBeanX> annotations) {
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

        public static class Geo{

            /**
             * type : Point
             * coordinates : [31.117314637,121.49860864]
             */

            private String type;
            private List<Double> coordinates;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Double> getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(List<Double> coordinates) {
                this.coordinates = coordinates;
            }
        }

        public static class UserBean {
            /**
             * id : 2087169013
             * idstr : 2087169013
             * class : 1
             * screen_name : 法制日报
             * name : 法制日报
             * province : 11
             * city : 5
             * location : 北京 朝阳区
             * description : 中央政法委机关报，权威发布及解读国家政策法规、及时发布法制新闻资讯
             * url :
             * profile_image_url : http://tva1.sinaimg.cn/crop.0.0.512.512.50/7c67abf5jw8ev8z1qovngj20e80e874p.jpg
             * cover_image : http://ww2.sinaimg.cn/crop.0.0.920.300/7c67abf5gw1eoyznpt0t0j20pk08c407.jpg
             * cover_image_phone : http://ww2.sinaimg.cn/crop.0.0.640.640.640/7c67abf5jw1f2ial5le4lj20yi0yk782.jpg;http://ww4.sinaimg.cn/crop.0.0.640.640.640/7c67abf5jw1f2iae17gqij20yi0ykwgq.jpg
             * profile_url : u/2087169013
             * domain :
             * weihao :
             * gender : m
             * followers_count : 1479903
             * friends_count : 1734
             * pagefriends_count : 6
             * statuses_count : 44361
             * favourites_count : 372
             * created_at : Fri Apr 15 16:53:15 +0800 2011
             * following : true
             * allow_all_act_msg : false
             * geo_enabled : false
             * verified : true
             * verified_type : 3
             * remark :
             * ptype : 0
             * allow_all_comment : false
             * avatar_large : http://tva1.sinaimg.cn/crop.0.0.512.512.180/7c67abf5jw8ev8z1qovngj20e80e874p.jpg
             * avatar_hd : http://tva1.sinaimg.cn/crop.0.0.512.512.1024/7c67abf5jw8ev8z1qovngj20e80e874p.jpg
             * verified_reason : 法制日报官方微博
             * verified_trade :
             * verified_reason_url :
             * verified_source :
             * verified_source_url :
             * verified_state : 0
             * verified_level : 3
             * verified_type_ext : 0
             * verified_reason_modified :
             * verified_contact_name :
             * verified_contact_email :
             * verified_contact_mobile :
             * follow_me : false
             * online_status : 0
             * bi_followers_count : 1180
             * lang : zh-cn
             * star : 0
             * mbtype : 12
             * mbrank : 5
             * block_word : 0
             * block_app : 1
             * credit_score : 80
             * user_ability : 516
             * cardid : star_063
             * avatargj_id : gj_vip_091
             * urank : 37
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
            private long credit_score;
            private long user_ability;
            private String cardid;
            private String avatargj_id;
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

            public String getAvatargj_id() {
                return avatargj_id;
            }

            public void setAvatargj_id(String avatargj_id) {
                this.avatargj_id = avatargj_id;
            }

            public long getUrank() {
                return urank;
            }

            public void setUrank(long urank) {
                this.urank = urank;
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

        public static class RetweetedStatusBean {
            /**
             * created_at : Tue Dec 27 11:39:56 +0800 2016
             * id : 4057261549125878
             * mid : 4057261549125878
             * idstr : 4057261549125878
             * text : 『旅行游记』贵州：肇兴侗寨-镇远古镇-西江千户苗寨-青岩古镇-黄果树
             [照相机] 美好回忆：http://t.cn/RIQ0WH3
             [爱你] 有你，我们的旅行更加精彩
             [围观] 微博群：http://t.cn/RtO6oml 💎群主@旅行者晓强
             🌟 点击 #深圳# 加入微博深圳社区
             * textLength : 224
             * source_allowclick : 0
             * source_type : 1
             * source : <a href="http://app.weibo.com/t/feed/3jskmg" rel="nofollow">iPhone 6s</a>
             * favorited : false
             * truncated : false
             * in_reply_to_status_id :
             * in_reply_to_user_id :
             * in_reply_to_screen_name :
             * pic_urls : [{"thumbnail_pic":"http://ww3.sinaimg.cn/thumbnail/67b61440gw1fb575nn0mtj20p00go4gv.jpg"},{"thumbnail_pic":"http://ww1.sinaimg.cn/thumbnail/67b61440gw1fb575o4o2sj20p00gok2q.jpg"},{"thumbnail_pic":"http://ww4.sinaimg.cn/thumbnail/67b61440gw1fb575opqeej20p00gond7.jpg"},{"thumbnail_pic":"http://ww3.sinaimg.cn/thumbnail/67b61440gw1fb575nbix4j20p00godt5.jpg"},{"thumbnail_pic":"http://ww4.sinaimg.cn/thumbnail/67b61440gw1fb575tdrqvj22gw1e01l0.jpg"},{"thumbnail_pic":"http://ww1.sinaimg.cn/thumbnail/67b61440gw1fb575ty5ncj20p00gowqh.jpg"},{"thumbnail_pic":"http://ww4.sinaimg.cn/thumbnail/67b61440gw1fb575v05ivj20p00p0wwb.jpg"},{"thumbnail_pic":"http://ww1.sinaimg.cn/thumbnail/67b61440gw1fb575vi13bj20p00p04jk.jpg"},{"thumbnail_pic":"http://ww1.sinaimg.cn/thumbnail/67b61440gw1fb575wamsbj20p00p0qnc.jpg"}]
             * thumbnail_pic : http://ww3.sinaimg.cn/thumbnail/67b61440gw1fb575nn0mtj20p00go4gv.jpg
             * bmiddle_pic : http://ww3.sinaimg.cn/bmiddle/67b61440gw1fb575nn0mtj20p00go4gv.jpg
             * original_pic : http://ww3.sinaimg.cn/large/67b61440gw1fb575nn0mtj20p00go4gv.jpg
             * geo : null
             * user : {"id":1739985984,"idstr":"1739985984","class":1,"screen_name":"深圳同城会","name":"深圳同城会","province":"44","city":"3","location":"广东 深圳","description":"#深圳# 超级话题 微博深圳同城社区","url":"","profile_image_url":"http://tva4.sinaimg.cn/crop.0.0.600.600.50/67b61440jw1f07fbj17okj20go0go75s.jpg","cover_image":"http://ww1.sinaimg.cn/crop.0.0.920.300/67b61440gw1el85d9ls5vj20pk08c0wc.jpg","cover_image_phone":"http://ww2.sinaimg.cn/crop.0.0.640.640.640/67b61440gw1f6e6bqnke0j20ku0kuq5n.jpg","profile_url":"shenzhen","domain":"shenzhen","weihao":"","gender":"m","followers_count":186323,"friends_count":199,"pagefriends_count":6,"statuses_count":5931,"favourites_count":0,"created_at":"Mon May 10 16:09:31 +0800 2010","following":false,"allow_all_act_msg":true,"geo_enabled":true,"verified":true,"verified_type":3,"remark":"","ptype":0,"allow_all_comment":true,"avatar_large":"http://tva4.sinaimg.cn/crop.0.0.600.600.180/67b61440jw1f07fbj17okj20go0go75s.jpg","avatar_hd":"http://tva4.sinaimg.cn/crop.0.0.600.600.1024/67b61440jw1f07fbj17okj20go0go75s.jpg","verified_reason":"深圳同城会官方微博","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":0,"verified_reason_modified":"深圳同城会官方微博","verified_contact_name":"谢定强","verified_contact_email":"13424200545@qq.com","verified_contact_mobile":"13424200545","follow_me":false,"online_status":0,"bi_followers_count":66,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":4,"block_word":0,"block_app":1,"location_rights":1,"credit_score":80,"user_ability":8,"urank":32}
             * annotations : [{"client_mblogid":"iPhone-46D64D9C-86E8-452F-ACD9-361D8CEA2A1A"},{"mapi_request":true}]
             * picStatus : 0:1,1:1,2:1,3:1,4:1,5:1,6:1,7:1,8:1
             * reposts_count : 5
             * comments_count : 5
             * attitudes_count : 12
             * isLongText : false
             * mlevel : 0
             * visible : {"type":0,"list_id":0}
             * biz_ids : [230940,230491]
             * biz_feature : 4294967300
             * topic_id : 1022:1008087a399889b9a4aed64afd0cf95941b975
             * sync_mblog : true
             * is_imported_topic : false
             * page_type : 32
             * hasActionTypeCard : 0
             * darwin_tags : []
             * hot_weibo_tags : []
             * text_tag_tips : []
             * userType : 0
             * extend_info : {"weibo_camera":{"c":["27235472_27235473_27235474_27235475_25631572_27235477"]}}
             * positive_recom_flag : 0
             * gif_ids :
             * is_show_bulletin : 1
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
            private VisibleBeanX visible;
            private long biz_feature;
            private String topic_id;
            private boolean sync_mblog;
            private boolean is_imported_topic;
            private long page_type;
            private long hasActionTypeCard;
            private long userType;
            private ExtendInfoBean extend_info;
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

            public String getTopic_id() {
                return topic_id;
            }

            public void setTopic_id(String topic_id) {
                this.topic_id = topic_id;
            }

            public boolean isSync_mblog() {
                return sync_mblog;
            }

            public void setSync_mblog(boolean sync_mblog) {
                this.sync_mblog = sync_mblog;
            }

            public boolean isIs_imported_topic() {
                return is_imported_topic;
            }

            public void setIs_imported_topic(boolean is_imported_topic) {
                this.is_imported_topic = is_imported_topic;
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

            public ExtendInfoBean getExtend_info() {
                return extend_info;
            }

            public void setExtend_info(ExtendInfoBean extend_info) {
                this.extend_info = extend_info;
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
                 * id : 1739985984
                 * idstr : 1739985984
                 * class : 1
                 * screen_name : 深圳同城会
                 * name : 深圳同城会
                 * province : 44
                 * city : 3
                 * location : 广东 深圳
                 * description : #深圳# 超级话题 微博深圳同城社区
                 * url :
                 * profile_image_url : http://tva4.sinaimg.cn/crop.0.0.600.600.50/67b61440jw1f07fbj17okj20go0go75s.jpg
                 * cover_image : http://ww1.sinaimg.cn/crop.0.0.920.300/67b61440gw1el85d9ls5vj20pk08c0wc.jpg
                 * cover_image_phone : http://ww2.sinaimg.cn/crop.0.0.640.640.640/67b61440gw1f6e6bqnke0j20ku0kuq5n.jpg
                 * profile_url : shenzhen
                 * domain : shenzhen
                 * weihao :
                 * gender : m
                 * followers_count : 186323
                 * friends_count : 199
                 * pagefriends_count : 6
                 * statuses_count : 5931
                 * favourites_count : 0
                 * created_at : Mon May 10 16:09:31 +0800 2010
                 * following : false
                 * allow_all_act_msg : true
                 * geo_enabled : true
                 * verified : true
                 * verified_type : 3
                 * remark :
                 * ptype : 0
                 * allow_all_comment : true
                 * avatar_large : http://tva4.sinaimg.cn/crop.0.0.600.600.180/67b61440jw1f07fbj17okj20go0go75s.jpg
                 * avatar_hd : http://tva4.sinaimg.cn/crop.0.0.600.600.1024/67b61440jw1f07fbj17okj20go0go75s.jpg
                 * verified_reason : 深圳同城会官方微博
                 * verified_trade :
                 * verified_reason_url :
                 * verified_source :
                 * verified_source_url :
                 * verified_state : 0
                 * verified_level : 3
                 * verified_type_ext : 0
                 * verified_reason_modified : 深圳同城会官方微博
                 * verified_contact_name : 谢定强
                 * verified_contact_email : 13424200545@qq.com
                 * verified_contact_mobile : 13424200545
                 * follow_me : false
                 * online_status : 0
                 * bi_followers_count : 66
                 * lang : zh-cn
                 * star : 0
                 * mbtype : 12
                 * mbrank : 4
                 * block_word : 0
                 * block_app : 1
                 * location_rights : 1
                 * credit_score : 80
                 * user_ability : 8
                 * urank : 32
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
                private long location_rights;
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

                public long getLocation_rights() {
                    return location_rights;
                }

                public void setLocation_rights(long location_rights) {
                    this.location_rights = location_rights;
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

            public static class ExtendInfoBean {
                /**
                 * weibo_camera : {"c":["27235472_27235473_27235474_27235475_25631572_27235477"]}
                 */

                private WeiboCameraBean weibo_camera;

                public WeiboCameraBean getWeibo_camera() {
                    return weibo_camera;
                }

                public void setWeibo_camera(WeiboCameraBean weibo_camera) {
                    this.weibo_camera = weibo_camera;
                }

                public static class WeiboCameraBean {
                    private List<String> c;

                    public List<String> getC() {
                        return c;
                    }

                    public void setC(List<String> c) {
                        this.c = c;
                    }
                }
            }

            public static class PicUrlsBean {
                /**
                 * thumbnail_pic : http://ww3.sinaimg.cn/thumbnail/67b61440gw1fb575nn0mtj20p00go4gv.jpg
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
                 * client_mblogid : iPhone-46D64D9C-86E8-452F-ACD9-361D8CEA2A1A
                 * mapi_request : true
                 */

                private String client_mblogid;
                private boolean mapi_request;

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
            }
        }

        public static class AnnotationsBeanX {

            /**
             * shooting : 1
             * place : {"lon":121.49860864,"poiid":"B2094757D06FA0F5429C","title":"芦恒路地铁站","type":"checkin","lat":31.117314637}
             * client_mblogid : be0f4839-b322-4808-8585-568fec3d4c8a
             * mapi_request : true
             */

            private int shooting;
            private PlaceBean place;
            private String client_mblogid;
            private boolean mapi_request;

            public int getShooting() {
                return shooting;
            }

            public void setShooting(int shooting) {
                this.shooting = shooting;
            }

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
                 * lon : 121.49860864
                 * poiid : B2094757D06FA0F5429C
                 * title : 芦恒路地铁站
                 * type : checkin
                 * lat : 31.117314637
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
}
