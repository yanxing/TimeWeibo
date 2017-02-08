package com.yanxing.weibo.weiboapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 用不到的、不确定的字段已注释掉，不然不便于序列化
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
    //用不到的、不确定的字段已注释掉
//    private List<?> advertises;
//    private List<?> ad;

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

//    public List<?> getAdvertises() {
//        return advertises;
//    }
//
//    public void setAdvertises(List<?> advertises) {
//        this.advertises = advertises;
//    }
//
//    public List<?> getAd() {
//        return ad;
//    }
//
//    public void setAd(List<?> ad) {
//        this.ad = ad;
//    }

    public static class StatusesBean implements Parcelable {

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
        private int isAttitudes;//默认0代表当前登录用户没有赞这条微博，1代表赞了
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
        private List<PicUrl> pic_urls;

        public List<PicUrl> getPic_urls() {
            return pic_urls;
        }

        public void setPic_urls(List<PicUrl> pic_urls) {
            this.pic_urls = pic_urls;
        }

        private List<AnnotationsBeanX> annotations;
        private List<Integer> biz_ids;
//        private List<?> darwin_tags;
//        private List<?> hot_weibo_tags;
//        private List<?> text_tag_tips;
        private String location;

        public static class PicUrl implements Parcelable {

            /**
             * thumbnail_pic : http://wx4.sinaimg.cn/thumbnail/61ff32dely1fb8nai7t14g20c806rk5y.gif
             */

            private String thumbnail_pic;

            public String getThumbnail_pic() {
                return thumbnail_pic;
            }

            public void setThumbnail_pic(String thumbnail_pic) {
                this.thumbnail_pic = thumbnail_pic;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.thumbnail_pic);
            }

            public PicUrl() {
            }

            protected PicUrl(Parcel in) {
                this.thumbnail_pic = in.readString();
            }

            public static final Creator<PicUrl> CREATOR = new Creator<PicUrl>() {
                @Override
                public PicUrl createFromParcel(Parcel source) {
                    return new PicUrl(source);
                }

                @Override
                public PicUrl[] newArray(int size) {
                    return new PicUrl[size];
                }
            };
        }

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

//        public List<?> getPic_urls() {
//            return pic_urls;
//        }
//
//        public void setPic_urls(List<?> pic_urls) {
//            this.pic_urls = pic_urls;
//        }

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

//        public List<?> getDarwin_tags() {
//            return darwin_tags;
//        }
//
//        public void setDarwin_tags(List<?> darwin_tags) {
//            this.darwin_tags = darwin_tags;
//        }
//
//        public List<?> getHot_weibo_tags() {
//            return hot_weibo_tags;
//        }
//
//        public void setHot_weibo_tags(List<?> hot_weibo_tags) {
//            this.hot_weibo_tags = hot_weibo_tags;
//        }
//
//        public List<?> getText_tag_tips() {
//            return text_tag_tips;
//        }
//
//        public void setText_tag_tips(List<?> text_tag_tips) {
//            this.text_tag_tips = text_tag_tips;
//        }

        public int getIsAttitudes() {
            return isAttitudes;
        }

        public void setIsAttitudes(int isAttitudes) {
            this.isAttitudes = isAttitudes;
        }

        public static class Geo implements Parcelable {

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.type);
                dest.writeList(this.coordinates);
            }

            public Geo() {
            }

            protected Geo(Parcel in) {
                this.type = in.readString();
                this.coordinates = new ArrayList<Double>();
                in.readList(this.coordinates, Double.class.getClassLoader());
            }

            public static final Creator<Geo> CREATOR = new Creator<Geo>() {
                @Override
                public Geo createFromParcel(Parcel source) {
                    return new Geo(source);
                }

                @Override
                public Geo[] newArray(int size) {
                    return new Geo[size];
                }
            };
        }

        public static class UserBean implements Parcelable {
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(this.id);
                dest.writeString(this.idstr);
                dest.writeLong(this.classX);
                dest.writeString(this.screen_name);
                dest.writeString(this.name);
                dest.writeString(this.province);
                dest.writeString(this.city);
                dest.writeString(this.location);
                dest.writeString(this.description);
                dest.writeString(this.url);
                dest.writeString(this.profile_image_url);
                dest.writeString(this.cover_image);
                dest.writeString(this.cover_image_phone);
                dest.writeString(this.profile_url);
                dest.writeString(this.domain);
                dest.writeString(this.weihao);
                dest.writeString(this.gender);
                dest.writeLong(this.followers_count);
                dest.writeLong(this.friends_count);
                dest.writeLong(this.pagefriends_count);
                dest.writeLong(this.statuses_count);
                dest.writeLong(this.favourites_count);
                dest.writeString(this.created_at);
                dest.writeByte(this.following ? (byte) 1 : (byte) 0);
                dest.writeByte(this.allow_all_act_msg ? (byte) 1 : (byte) 0);
                dest.writeByte(this.geo_enabled ? (byte) 1 : (byte) 0);
                dest.writeByte(this.verified ? (byte) 1 : (byte) 0);
                dest.writeLong(this.verified_type);
                dest.writeString(this.remark);
                dest.writeLong(this.ptype);
                dest.writeByte(this.allow_all_comment ? (byte) 1 : (byte) 0);
                dest.writeString(this.avatar_large);
                dest.writeString(this.avatar_hd);
                dest.writeString(this.verified_reason);
                dest.writeString(this.verified_trade);
                dest.writeString(this.verified_reason_url);
                dest.writeString(this.verified_source);
                dest.writeString(this.verified_source_url);
                dest.writeLong(this.verified_state);
                dest.writeLong(this.verified_level);
                dest.writeLong(this.verified_type_ext);
                dest.writeString(this.verified_reason_modified);
                dest.writeString(this.verified_contact_name);
                dest.writeString(this.verified_contact_email);
                dest.writeString(this.verified_contact_mobile);
                dest.writeByte(this.follow_me ? (byte) 1 : (byte) 0);
                dest.writeLong(this.online_status);
                dest.writeLong(this.bi_followers_count);
                dest.writeString(this.lang);
                dest.writeLong(this.star);
                dest.writeLong(this.mbtype);
                dest.writeLong(this.mbrank);
                dest.writeLong(this.block_word);
                dest.writeLong(this.block_app);
                dest.writeLong(this.credit_score);
                dest.writeLong(this.user_ability);
                dest.writeString(this.cardid);
                dest.writeString(this.avatargj_id);
                dest.writeLong(this.urank);
            }

            public UserBean() {
            }

            protected UserBean(Parcel in) {
                this.id = in.readLong();
                this.idstr = in.readString();
                this.classX = in.readLong();
                this.screen_name = in.readString();
                this.name = in.readString();
                this.province = in.readString();
                this.city = in.readString();
                this.location = in.readString();
                this.description = in.readString();
                this.url = in.readString();
                this.profile_image_url = in.readString();
                this.cover_image = in.readString();
                this.cover_image_phone = in.readString();
                this.profile_url = in.readString();
                this.domain = in.readString();
                this.weihao = in.readString();
                this.gender = in.readString();
                this.followers_count = in.readLong();
                this.friends_count = in.readLong();
                this.pagefriends_count = in.readLong();
                this.statuses_count = in.readLong();
                this.favourites_count = in.readLong();
                this.created_at = in.readString();
                this.following = in.readByte() != 0;
                this.allow_all_act_msg = in.readByte() != 0;
                this.geo_enabled = in.readByte() != 0;
                this.verified = in.readByte() != 0;
                this.verified_type = in.readLong();
                this.remark = in.readString();
                this.ptype = in.readLong();
                this.allow_all_comment = in.readByte() != 0;
                this.avatar_large = in.readString();
                this.avatar_hd = in.readString();
                this.verified_reason = in.readString();
                this.verified_trade = in.readString();
                this.verified_reason_url = in.readString();
                this.verified_source = in.readString();
                this.verified_source_url = in.readString();
                this.verified_state = in.readLong();
                this.verified_level = in.readLong();
                this.verified_type_ext = in.readLong();
                this.verified_reason_modified = in.readString();
                this.verified_contact_name = in.readString();
                this.verified_contact_email = in.readString();
                this.verified_contact_mobile = in.readString();
                this.follow_me = in.readByte() != 0;
                this.online_status = in.readLong();
                this.bi_followers_count = in.readLong();
                this.lang = in.readString();
                this.star = in.readLong();
                this.mbtype = in.readLong();
                this.mbrank = in.readLong();
                this.block_word = in.readLong();
                this.block_app = in.readLong();
                this.credit_score = in.readLong();
                this.user_ability = in.readLong();
                this.cardid = in.readString();
                this.avatargj_id = in.readString();
                this.urank = in.readLong();
            }

            public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
                @Override
                public UserBean createFromParcel(Parcel source) {
                    return new UserBean(source);
                }

                @Override
                public UserBean[] newArray(int size) {
                    return new UserBean[size];
                }
            };
        }

        public static class VisibleBean implements Parcelable {
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(this.type);
                dest.writeLong(this.list_id);
            }

            public VisibleBean() {
            }

            protected VisibleBean(Parcel in) {
                this.type = in.readLong();
                this.list_id = in.readLong();
            }

            public static final Creator<VisibleBean> CREATOR = new Creator<VisibleBean>() {
                @Override
                public VisibleBean createFromParcel(Parcel source) {
                    return new VisibleBean(source);
                }

                @Override
                public VisibleBean[] newArray(int size) {
                    return new VisibleBean[size];
                }
            };
        }

        public static class RetweetedStatusBean implements Parcelable {

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
            private Geo geo;
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
//            private List<?> darwin_tags;
//            private List<?> hot_weibo_tags;
//            private List<?> text_tag_tips;

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

            public void setGeo(Geo geo) {
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

//            public List<?> getDarwin_tags() {
//                return darwin_tags;
//            }
//
//            public void setDarwin_tags(List<?> darwin_tags) {
//                this.darwin_tags = darwin_tags;
//            }
//
//            public List<?> getHot_weibo_tags() {
//                return hot_weibo_tags;
//            }
//
//            public void setHot_weibo_tags(List<?> hot_weibo_tags) {
//                this.hot_weibo_tags = hot_weibo_tags;
//            }
//
//            public List<?> getText_tag_tips() {
//                return text_tag_tips;
//            }
//
//            public void setText_tag_tips(List<?> text_tag_tips) {
//                this.text_tag_tips = text_tag_tips;
//            }

            public static class UserBeanX implements Parcelable {

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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeLong(this.id);
                    dest.writeString(this.idstr);
                    dest.writeLong(this.classX);
                    dest.writeString(this.screen_name);
                    dest.writeString(this.name);
                    dest.writeString(this.province);
                    dest.writeString(this.city);
                    dest.writeString(this.location);
                    dest.writeString(this.description);
                    dest.writeString(this.url);
                    dest.writeString(this.profile_image_url);
                    dest.writeString(this.cover_image);
                    dest.writeString(this.cover_image_phone);
                    dest.writeString(this.profile_url);
                    dest.writeString(this.domain);
                    dest.writeString(this.weihao);
                    dest.writeString(this.gender);
                    dest.writeLong(this.followers_count);
                    dest.writeLong(this.friends_count);
                    dest.writeLong(this.pagefriends_count);
                    dest.writeLong(this.statuses_count);
                    dest.writeLong(this.favourites_count);
                    dest.writeString(this.created_at);
                    dest.writeByte(this.following ? (byte) 1 : (byte) 0);
                    dest.writeByte(this.allow_all_act_msg ? (byte) 1 : (byte) 0);
                    dest.writeByte(this.geo_enabled ? (byte) 1 : (byte) 0);
                    dest.writeByte(this.verified ? (byte) 1 : (byte) 0);
                    dest.writeLong(this.verified_type);
                    dest.writeString(this.remark);
                    dest.writeLong(this.ptype);
                    dest.writeByte(this.allow_all_comment ? (byte) 1 : (byte) 0);
                    dest.writeString(this.avatar_large);
                    dest.writeString(this.avatar_hd);
                    dest.writeString(this.verified_reason);
                    dest.writeString(this.verified_trade);
                    dest.writeString(this.verified_reason_url);
                    dest.writeString(this.verified_source);
                    dest.writeString(this.verified_source_url);
                    dest.writeLong(this.verified_state);
                    dest.writeLong(this.verified_level);
                    dest.writeLong(this.verified_type_ext);
                    dest.writeString(this.verified_reason_modified);
                    dest.writeString(this.verified_contact_name);
                    dest.writeString(this.verified_contact_email);
                    dest.writeString(this.verified_contact_mobile);
                    dest.writeByte(this.follow_me ? (byte) 1 : (byte) 0);
                    dest.writeLong(this.online_status);
                    dest.writeLong(this.bi_followers_count);
                    dest.writeString(this.lang);
                    dest.writeLong(this.star);
                    dest.writeLong(this.mbtype);
                    dest.writeLong(this.mbrank);
                    dest.writeLong(this.block_word);
                    dest.writeLong(this.block_app);
                    dest.writeLong(this.location_rights);
                    dest.writeLong(this.credit_score);
                    dest.writeLong(this.user_ability);
                    dest.writeLong(this.urank);
                }

                public UserBeanX() {
                }

                protected UserBeanX(Parcel in) {
                    this.id = in.readLong();
                    this.idstr = in.readString();
                    this.classX = in.readLong();
                    this.screen_name = in.readString();
                    this.name = in.readString();
                    this.province = in.readString();
                    this.city = in.readString();
                    this.location = in.readString();
                    this.description = in.readString();
                    this.url = in.readString();
                    this.profile_image_url = in.readString();
                    this.cover_image = in.readString();
                    this.cover_image_phone = in.readString();
                    this.profile_url = in.readString();
                    this.domain = in.readString();
                    this.weihao = in.readString();
                    this.gender = in.readString();
                    this.followers_count = in.readLong();
                    this.friends_count = in.readLong();
                    this.pagefriends_count = in.readLong();
                    this.statuses_count = in.readLong();
                    this.favourites_count = in.readLong();
                    this.created_at = in.readString();
                    this.following = in.readByte() != 0;
                    this.allow_all_act_msg = in.readByte() != 0;
                    this.geo_enabled = in.readByte() != 0;
                    this.verified = in.readByte() != 0;
                    this.verified_type = in.readLong();
                    this.remark = in.readString();
                    this.ptype = in.readLong();
                    this.allow_all_comment = in.readByte() != 0;
                    this.avatar_large = in.readString();
                    this.avatar_hd = in.readString();
                    this.verified_reason = in.readString();
                    this.verified_trade = in.readString();
                    this.verified_reason_url = in.readString();
                    this.verified_source = in.readString();
                    this.verified_source_url = in.readString();
                    this.verified_state = in.readLong();
                    this.verified_level = in.readLong();
                    this.verified_type_ext = in.readLong();
                    this.verified_reason_modified = in.readString();
                    this.verified_contact_name = in.readString();
                    this.verified_contact_email = in.readString();
                    this.verified_contact_mobile = in.readString();
                    this.follow_me = in.readByte() != 0;
                    this.online_status = in.readLong();
                    this.bi_followers_count = in.readLong();
                    this.lang = in.readString();
                    this.star = in.readLong();
                    this.mbtype = in.readLong();
                    this.mbrank = in.readLong();
                    this.block_word = in.readLong();
                    this.block_app = in.readLong();
                    this.location_rights = in.readLong();
                    this.credit_score = in.readLong();
                    this.user_ability = in.readLong();
                    this.urank = in.readLong();
                }

                public static final Creator<UserBeanX> CREATOR = new Creator<UserBeanX>() {
                    @Override
                    public UserBeanX createFromParcel(Parcel source) {
                        return new UserBeanX(source);
                    }

                    @Override
                    public UserBeanX[] newArray(int size) {
                        return new UserBeanX[size];
                    }
                };
            }

            public static class VisibleBeanX implements Parcelable {
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeLong(this.type);
                    dest.writeLong(this.list_id);
                }

                public VisibleBeanX() {
                }

                protected VisibleBeanX(Parcel in) {
                    this.type = in.readLong();
                    this.list_id = in.readLong();
                }

                public static final Creator<VisibleBeanX> CREATOR = new Creator<VisibleBeanX>() {
                    @Override
                    public VisibleBeanX createFromParcel(Parcel source) {
                        return new VisibleBeanX(source);
                    }

                    @Override
                    public VisibleBeanX[] newArray(int size) {
                        return new VisibleBeanX[size];
                    }
                };
            }

            public static class ExtendInfoBean implements Parcelable {
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

                public static class WeiboCameraBean implements Parcelable {
                    private List<String> c;

                    public List<String> getC() {
                        return c;
                    }

                    public void setC(List<String> c) {
                        this.c = c;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeStringList(this.c);
                    }

                    public WeiboCameraBean() {
                    }

                    protected WeiboCameraBean(Parcel in) {
                        this.c = in.createStringArrayList();
                    }

                    public static final Creator<WeiboCameraBean> CREATOR = new Creator<WeiboCameraBean>() {
                        @Override
                        public WeiboCameraBean createFromParcel(Parcel source) {
                            return new WeiboCameraBean(source);
                        }

                        @Override
                        public WeiboCameraBean[] newArray(int size) {
                            return new WeiboCameraBean[size];
                        }
                    };
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeParcelable(this.weibo_camera, flags);
                }

                public ExtendInfoBean() {
                }

                protected ExtendInfoBean(Parcel in) {
                    this.weibo_camera = in.readParcelable(WeiboCameraBean.class.getClassLoader());
                }

                public static final Creator<ExtendInfoBean> CREATOR = new Creator<ExtendInfoBean>() {
                    @Override
                    public ExtendInfoBean createFromParcel(Parcel source) {
                        return new ExtendInfoBean(source);
                    }

                    @Override
                    public ExtendInfoBean[] newArray(int size) {
                        return new ExtendInfoBean[size];
                    }
                };
            }

            public static class PicUrlsBean implements Parcelable {
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.thumbnail_pic);
                }

                public PicUrlsBean() {
                }

                protected PicUrlsBean(Parcel in) {
                    this.thumbnail_pic = in.readString();
                }

                public static final Creator<PicUrlsBean> CREATOR = new Creator<PicUrlsBean>() {
                    @Override
                    public PicUrlsBean createFromParcel(Parcel source) {
                        return new PicUrlsBean(source);
                    }

                    @Override
                    public PicUrlsBean[] newArray(int size) {
                        return new PicUrlsBean[size];
                    }
                };
            }

            public static class AnnotationsBean implements Parcelable {
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.client_mblogid);
                    dest.writeByte(this.mapi_request ? (byte) 1 : (byte) 0);
                }

                public AnnotationsBean() {
                }

                protected AnnotationsBean(Parcel in) {
                    this.client_mblogid = in.readString();
                    this.mapi_request = in.readByte() != 0;
                }

                public static final Creator<AnnotationsBean> CREATOR = new Creator<AnnotationsBean>() {
                    @Override
                    public AnnotationsBean createFromParcel(Parcel source) {
                        return new AnnotationsBean(source);
                    }

                    @Override
                    public AnnotationsBean[] newArray(int size) {
                        return new AnnotationsBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.created_at);
                dest.writeLong(this.id);
                dest.writeString(this.mid);
                dest.writeString(this.idstr);
                dest.writeString(this.text);
                dest.writeLong(this.textLength);
                dest.writeLong(this.source_allowclick);
                dest.writeLong(this.source_type);
                dest.writeString(this.source);
                dest.writeByte(this.favorited ? (byte) 1 : (byte) 0);
                dest.writeByte(this.truncated ? (byte) 1 : (byte) 0);
                dest.writeString(this.in_reply_to_status_id);
                dest.writeString(this.in_reply_to_user_id);
                dest.writeString(this.in_reply_to_screen_name);
                dest.writeString(this.thumbnail_pic);
                dest.writeString(this.bmiddle_pic);
                dest.writeString(this.original_pic);
                dest.writeParcelable(this.geo, flags);
                dest.writeParcelable(this.user, flags);
                dest.writeString(this.picStatus);
                dest.writeLong(this.reposts_count);
                dest.writeLong(this.comments_count);
                dest.writeLong(this.attitudes_count);
                dest.writeByte(this.isLongText ? (byte) 1 : (byte) 0);
                dest.writeLong(this.mlevel);
                dest.writeParcelable(this.visible, flags);
                dest.writeLong(this.biz_feature);
                dest.writeString(this.topic_id);
                dest.writeByte(this.sync_mblog ? (byte) 1 : (byte) 0);
                dest.writeByte(this.is_imported_topic ? (byte) 1 : (byte) 0);
                dest.writeLong(this.page_type);
                dest.writeLong(this.hasActionTypeCard);
                dest.writeLong(this.userType);
                dest.writeParcelable(this.extend_info, flags);
                dest.writeLong(this.positive_recom_flag);
                dest.writeString(this.gif_ids);
                dest.writeLong(this.is_show_bulletin);
                dest.writeList(this.pic_urls);
                dest.writeList(this.annotations);
                dest.writeList(this.biz_ids);
            }

            public RetweetedStatusBean() {
            }

            protected RetweetedStatusBean(Parcel in) {
                this.created_at = in.readString();
                this.id = in.readLong();
                this.mid = in.readString();
                this.idstr = in.readString();
                this.text = in.readString();
                this.textLength = in.readLong();
                this.source_allowclick = in.readLong();
                this.source_type = in.readLong();
                this.source = in.readString();
                this.favorited = in.readByte() != 0;
                this.truncated = in.readByte() != 0;
                this.in_reply_to_status_id = in.readString();
                this.in_reply_to_user_id = in.readString();
                this.in_reply_to_screen_name = in.readString();
                this.thumbnail_pic = in.readString();
                this.bmiddle_pic = in.readString();
                this.original_pic = in.readString();
                this.geo = in.readParcelable(Geo.class.getClassLoader());
                this.user = in.readParcelable(UserBeanX.class.getClassLoader());
                this.picStatus = in.readString();
                this.reposts_count = in.readLong();
                this.comments_count = in.readLong();
                this.attitudes_count = in.readLong();
                this.isLongText = in.readByte() != 0;
                this.mlevel = in.readLong();
                this.visible = in.readParcelable(VisibleBeanX.class.getClassLoader());
                this.biz_feature = in.readLong();
                this.topic_id = in.readString();
                this.sync_mblog = in.readByte() != 0;
                this.is_imported_topic = in.readByte() != 0;
                this.page_type = in.readLong();
                this.hasActionTypeCard = in.readLong();
                this.userType = in.readLong();
                this.extend_info = in.readParcelable(ExtendInfoBean.class.getClassLoader());
                this.positive_recom_flag = in.readLong();
                this.gif_ids = in.readString();
                this.is_show_bulletin = in.readLong();
                this.pic_urls = new ArrayList<PicUrlsBean>();
                in.readList(this.pic_urls, PicUrlsBean.class.getClassLoader());
                this.annotations = new ArrayList<AnnotationsBean>();
                in.readList(this.annotations, AnnotationsBean.class.getClassLoader());
                this.biz_ids = new ArrayList<Integer>();
                in.readList(this.biz_ids, Integer.class.getClassLoader());
            }

            public static final Creator<RetweetedStatusBean> CREATOR = new Creator<RetweetedStatusBean>() {
                @Override
                public RetweetedStatusBean createFromParcel(Parcel source) {
                    return new RetweetedStatusBean(source);
                }

                @Override
                public RetweetedStatusBean[] newArray(int size) {
                    return new RetweetedStatusBean[size];
                }
            };
        }

        public static class AnnotationsBeanX implements Parcelable {

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

            public static class PlaceBean implements Parcelable {
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeDouble(this.lon);
                    dest.writeString(this.poiid);
                    dest.writeString(this.title);
                    dest.writeString(this.type);
                    dest.writeDouble(this.lat);
                }

                public PlaceBean() {
                }

                protected PlaceBean(Parcel in) {
                    this.lon = in.readDouble();
                    this.poiid = in.readString();
                    this.title = in.readString();
                    this.type = in.readString();
                    this.lat = in.readDouble();
                }

                public static final Creator<PlaceBean> CREATOR = new Creator<PlaceBean>() {
                    @Override
                    public PlaceBean createFromParcel(Parcel source) {
                        return new PlaceBean(source);
                    }

                    @Override
                    public PlaceBean[] newArray(int size) {
                        return new PlaceBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.shooting);
                dest.writeParcelable(this.place, flags);
                dest.writeString(this.client_mblogid);
                dest.writeByte(this.mapi_request ? (byte) 1 : (byte) 0);
            }

            public AnnotationsBeanX() {
            }

            protected AnnotationsBeanX(Parcel in) {
                this.shooting = in.readInt();
                this.place = in.readParcelable(PlaceBean.class.getClassLoader());
                this.client_mblogid = in.readString();
                this.mapi_request = in.readByte() != 0;
            }

            public static final Creator<AnnotationsBeanX> CREATOR = new Creator<AnnotationsBeanX>() {
                @Override
                public AnnotationsBeanX createFromParcel(Parcel source) {
                    return new AnnotationsBeanX(source);
                }

                @Override
                public AnnotationsBeanX[] newArray(int size) {
                    return new AnnotationsBeanX[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.created_at);
            dest.writeLong(this.id);
            dest.writeString(this.mid);
            dest.writeString(this.idstr);
            dest.writeString(this.text);
            dest.writeLong(this.textLength);
            dest.writeLong(this.source_allowclick);
            dest.writeLong(this.source_type);
            dest.writeString(this.source);
            dest.writeByte(this.favorited ? (byte) 1 : (byte) 0);
            dest.writeByte(this.truncated ? (byte) 1 : (byte) 0);
            dest.writeString(this.in_reply_to_status_id);
            dest.writeString(this.in_reply_to_user_id);
            dest.writeString(this.in_reply_to_screen_name);
            dest.writeParcelable(this.geo, flags);
            dest.writeParcelable(this.user, flags);
            dest.writeLong(this.reposts_count);
            dest.writeLong(this.comments_count);
            dest.writeLong(this.attitudes_count);
            dest.writeByte(this.isLongText ? (byte) 1 : (byte) 0);
            dest.writeLong(this.mlevel);
            dest.writeParcelable(this.visible, flags);
            dest.writeLong(this.biz_feature);
            dest.writeLong(this.hasActionTypeCard);
            dest.writeString(this.rid);
            dest.writeLong(this.userType);
            dest.writeString(this.cardid);
            dest.writeLong(this.positive_recom_flag);
            dest.writeString(this.gif_ids);
            dest.writeLong(this.is_show_bulletin);
            dest.writeParcelable(this.retweeted_status, flags);
            dest.writeString(this.thumbnail_pic);
            dest.writeString(this.bmiddle_pic);
            dest.writeString(this.original_pic);
            dest.writeString(this.picStatus);
            dest.writeLong(this.page_type);
            dest.writeList(this.pic_urls);
            dest.writeList(this.annotations);
            dest.writeList(this.biz_ids);
            dest.writeString(this.location);
        }

        public StatusesBean() {
        }

        protected StatusesBean(Parcel in) {
            this.created_at = in.readString();
            this.id = in.readLong();
            this.mid = in.readString();
            this.idstr = in.readString();
            this.text = in.readString();
            this.textLength = in.readLong();
            this.source_allowclick = in.readLong();
            this.source_type = in.readLong();
            this.source = in.readString();
            this.favorited = in.readByte() != 0;
            this.truncated = in.readByte() != 0;
            this.in_reply_to_status_id = in.readString();
            this.in_reply_to_user_id = in.readString();
            this.in_reply_to_screen_name = in.readString();
            this.geo = in.readParcelable(Geo.class.getClassLoader());
            this.user = in.readParcelable(UserBean.class.getClassLoader());
            this.reposts_count = in.readLong();
            this.comments_count = in.readLong();
            this.attitudes_count = in.readLong();
            this.isLongText = in.readByte() != 0;
            this.mlevel = in.readLong();
            this.visible = in.readParcelable(VisibleBean.class.getClassLoader());
            this.biz_feature = in.readLong();
            this.hasActionTypeCard = in.readLong();
            this.rid = in.readString();
            this.userType = in.readLong();
            this.cardid = in.readString();
            this.positive_recom_flag = in.readLong();
            this.gif_ids = in.readString();
            this.is_show_bulletin = in.readLong();
            this.retweeted_status = in.readParcelable(RetweetedStatusBean.class.getClassLoader());
            this.thumbnail_pic = in.readString();
            this.bmiddle_pic = in.readString();
            this.original_pic = in.readString();
            this.picStatus = in.readString();
            this.page_type = in.readLong();
            this.pic_urls = new ArrayList<PicUrl>();
            in.readList(this.pic_urls, PicUrl.class.getClassLoader());
            this.annotations = new ArrayList<AnnotationsBeanX>();
            in.readList(this.annotations, AnnotationsBeanX.class.getClassLoader());
            this.biz_ids = new ArrayList<Integer>();
            in.readList(this.biz_ids, Integer.class.getClassLoader());
            this.location = in.readString();
        }

        public static final Parcelable.Creator<StatusesBean> CREATOR = new Parcelable.Creator<StatusesBean>() {
            @Override
            public StatusesBean createFromParcel(Parcel source) {
                return new StatusesBean(source);
            }

            @Override
            public StatusesBean[] newArray(int size) {
                return new StatusesBean[size];
            }
        };
    }
}
