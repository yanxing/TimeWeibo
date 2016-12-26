package com.yanxing.weibo.weiboapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 李双祥 on 2016/12/23.
 */

public class FriendTimeLine {
    /**
     * statuses : [{"created_at":"Sat Dec 24 23:32:03 +0800 2016","id":4056353594697867,"mid":"4056353594697867","idstr":"4056353594697867","text":"【他们一辈子，都在做自己喜欢的事[心]】\u201c剪花娘子\u201d库淑兰去世已12年，她是中国首位联合国授予的\u201c民间艺术大师\u201d，从没过过富足的生活，但一辈子都在做自己喜欢的事。无数这样的大师散落民间，不起眼地度过一生，唯有手艺带来自尊。愿民艺之路不孤，传承之人不独！http://t.cn/RINEtN4  @二更视频","textLength":278,"source_allowclick":0,"source_type":1,"source":"<a href=\"http://app.weibo.com/t/feed/6vtZb0\" rel=\"nofollow\">微博 weibo.com<\/a>","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","pic_urls":[],"geo":null,"user":{"id":1644114654,"idstr":"1644114654","class":1,"screen_name":"新京报","name":"新京报","province":"11","city":"1000","location":"北京","description":"一份以责任为灵魂的报纸；一份致力于记录时代步伐的报纸；一份进步、美好的报纸。新京报，品质源于责任。","url":"http://www.bjnews.com.cn/","profile_image_url":"http://tva3.sinaimg.cn/crop.0.0.512.512.50/61ff32dejw8ev91yl3hkdj20e80e8jrt.jpg","cover_image_phone":"http://ww4.sinaimg.cn/crop.0.0.640.640.640/61ff32dejw1f8w8sbo052j20hs0humxe.jpg","profile_url":"xjb","domain":"xjb","weihao":"","gender":"m","followers_count":22525279,"friends_count":1784,"pagefriends_count":890,"statuses_count":66937,"favourites_count":119,"created_at":"Mon Aug 31 20:26:42 +0800 2009","following":true,"allow_all_act_msg":true,"geo_enabled":true,"verified":true,"verified_type":3,"remark":"","ptype":0,"allow_all_comment":true,"avatar_large":"http://tva3.sinaimg.cn/crop.0.0.512.512.180/61ff32dejw8ev91yl3hkdj20e80e8jrt.jpg","avatar_hd":"http://tva3.sinaimg.cn/crop.0.0.512.512.1024/61ff32dejw8ev91yl3hkdj20e80e8jrt.jpg","verified_reason":"新京报官方微博","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":0,"verified_reason_modified":"","verified_contact_name":"","verified_contact_email":"","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":690,"lang":"zh-cn","star":0,"mbtype":2,"mbrank":5,"block_word":0,"block_app":0,"credit_score":80,"user_ability":516,"urank":40},"reposts_count":59,"comments_count":33,"attitudes_count":157,"isLongText":false,"mlevel":0,"visible":{"type":0,"list_id":0},"biz_ids":[230442],"biz_feature":0,"hasActionTypeCard":0,"darwin_tags":[],"hot_weibo_tags":[],"text_tag_tips":[],"rid":"0_0_1_2789447161294668613","userType":0,"positive_recom_flag":0,"gif_ids":"","is_show_bulletin":2}]
     * advertises : []
     * ad : []
     * hasvisible : false
     * previous_cursor : 0
     * next_cursor : 4056353108297146
     * total_number : 150
     * interval : 2000
     * uve_blank : -1
     * since_id : 4056353594697867
     * max_id : 4056353108297146
     * has_unread : 0
     */

    private boolean hasvisible;
    private long previous_cursor;
    private long next_cursor;
    private int total_number;
    private int interval;
    private int uve_blank;
    private long since_id;
    private long max_id;
    private int has_unread;
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

    public void setPrevious_cursor(int previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public long getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(long next_cursor) {
        this.next_cursor = next_cursor;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getUve_blank() {
        return uve_blank;
    }

    public void setUve_blank(int uve_blank) {
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

    public int getHas_unread() {
        return has_unread;
    }

    public void setHas_unread(int has_unread) {
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
        /**
         * created_at : Sat Dec 24 23:32:03 +0800 2016
         * id : 4056353594697867
         * mid : 4056353594697867
         * idstr : 4056353594697867
         * text : 【他们一辈子，都在做自己喜欢的事[心]】“剪花娘子”库淑兰去世已12年，她是中国首位联合国授予的“民间艺术大师”，从没过过富足的生活，但一辈子都在做自己喜欢的事。无数这样的大师散落民间，不起眼地度过一生，唯有手艺带来自尊。愿民艺之路不孤，传承之人不独！http://t.cn/RINEtN4  @二更视频
         * textLength : 278
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
         * user : {"id":1644114654,"idstr":"1644114654","class":1,"screen_name":"新京报","name":"新京报","province":"11","city":"1000","location":"北京","description":"一份以责任为灵魂的报纸；一份致力于记录时代步伐的报纸；一份进步、美好的报纸。新京报，品质源于责任。","url":"http://www.bjnews.com.cn/","profile_image_url":"http://tva3.sinaimg.cn/crop.0.0.512.512.50/61ff32dejw8ev91yl3hkdj20e80e8jrt.jpg","cover_image_phone":"http://ww4.sinaimg.cn/crop.0.0.640.640.640/61ff32dejw1f8w8sbo052j20hs0humxe.jpg","profile_url":"xjb","domain":"xjb","weihao":"","gender":"m","followers_count":22525279,"friends_count":1784,"pagefriends_count":890,"statuses_count":66937,"favourites_count":119,"created_at":"Mon Aug 31 20:26:42 +0800 2009","following":true,"allow_all_act_msg":true,"geo_enabled":true,"verified":true,"verified_type":3,"remark":"","ptype":0,"allow_all_comment":true,"avatar_large":"http://tva3.sinaimg.cn/crop.0.0.512.512.180/61ff32dejw8ev91yl3hkdj20e80e8jrt.jpg","avatar_hd":"http://tva3.sinaimg.cn/crop.0.0.512.512.1024/61ff32dejw8ev91yl3hkdj20e80e8jrt.jpg","verified_reason":"新京报官方微博","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":0,"verified_reason_modified":"","verified_contact_name":"","verified_contact_email":"","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":690,"lang":"zh-cn","star":0,"mbtype":2,"mbrank":5,"block_word":0,"block_app":0,"credit_score":80,"user_ability":516,"urank":40}
         * reposts_count : 59
         * comments_count : 33
         * attitudes_count : 157
         * isLongText : false
         * mlevel : 0
         * visible : {"type":0,"list_id":0}
         * biz_ids : [230442]
         * biz_feature : 0
         * hasActionTypeCard : 0
         * darwin_tags : []
         * hot_weibo_tags : []
         * text_tag_tips : []
         * rid : 0_0_1_2789447161294668613
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
        private int textLength;
        private int source_allowclick;
        private int source_type;
        private String source;
        private boolean favorited;
        private boolean truncated;
        private String in_reply_to_status_id;
        private String in_reply_to_user_id;
        private String in_reply_to_screen_name;
        private Object geo;
        private UserBean user;
        private int reposts_count;
        private int comments_count;
        private int attitudes_count;
        private boolean isLongText;
        private int mlevel;
        private VisibleBean visible;
        private long biz_feature;
        private int hasActionTypeCard;
        private String rid;
        private int userType;
        private int positive_recom_flag;
        private String gif_ids;
        private int is_show_bulletin;
        private List<?> pic_urls;
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

        public int getTextLength() {
            return textLength;
        }

        public void setTextLength(int textLength) {
            this.textLength = textLength;
        }

        public int getSource_allowclick() {
            return source_allowclick;
        }

        public void setSource_allowclick(int source_allowclick) {
            this.source_allowclick = source_allowclick;
        }

        public int getSource_type() {
            return source_type;
        }

        public void setSource_type(int source_type) {
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

        public int getReposts_count() {
            return reposts_count;
        }

        public void setReposts_count(int reposts_count) {
            this.reposts_count = reposts_count;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public int getAttitudes_count() {
            return attitudes_count;
        }

        public void setAttitudes_count(int attitudes_count) {
            this.attitudes_count = attitudes_count;
        }

        public boolean isIsLongText() {
            return isLongText;
        }

        public void setIsLongText(boolean isLongText) {
            this.isLongText = isLongText;
        }

        public int getMlevel() {
            return mlevel;
        }

        public void setMlevel(int mlevel) {
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

        public void setBiz_feature(int biz_feature) {
            this.biz_feature = biz_feature;
        }

        public int getHasActionTypeCard() {
            return hasActionTypeCard;
        }

        public void setHasActionTypeCard(int hasActionTypeCard) {
            this.hasActionTypeCard = hasActionTypeCard;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getPositive_recom_flag() {
            return positive_recom_flag;
        }

        public void setPositive_recom_flag(int positive_recom_flag) {
            this.positive_recom_flag = positive_recom_flag;
        }

        public String getGif_ids() {
            return gif_ids;
        }

        public void setGif_ids(String gif_ids) {
            this.gif_ids = gif_ids;
        }

        public int getIs_show_bulletin() {
            return is_show_bulletin;
        }

        public void setIs_show_bulletin(int is_show_bulletin) {
            this.is_show_bulletin = is_show_bulletin;
        }

        public List<?> getPic_urls() {
            return pic_urls;
        }

        public void setPic_urls(List<?> pic_urls) {
            this.pic_urls = pic_urls;
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

        public static class UserBean {
            /**
             * id : 1644114654
             * idstr : 1644114654
             * class : 1
             * screen_name : 新京报
             * name : 新京报
             * province : 11
             * city : 1000
             * location : 北京
             * description : 一份以责任为灵魂的报纸；一份致力于记录时代步伐的报纸；一份进步、美好的报纸。新京报，品质源于责任。
             * url : http://www.bjnews.com.cn/
             * profile_image_url : http://tva3.sinaimg.cn/crop.0.0.512.512.50/61ff32dejw8ev91yl3hkdj20e80e8jrt.jpg
             * cover_image_phone : http://ww4.sinaimg.cn/crop.0.0.640.640.640/61ff32dejw1f8w8sbo052j20hs0humxe.jpg
             * profile_url : xjb
             * domain : xjb
             * weihao :
             * gender : m
             * followers_count : 22525279
             * friends_count : 1784
             * pagefriends_count : 890
             * statuses_count : 66937
             * favourites_count : 119
             * created_at : Mon Aug 31 20:26:42 +0800 2009
             * following : true
             * allow_all_act_msg : true
             * geo_enabled : true
             * verified : true
             * verified_type : 3
             * remark :
             * ptype : 0
             * allow_all_comment : true
             * avatar_large : http://tva3.sinaimg.cn/crop.0.0.512.512.180/61ff32dejw8ev91yl3hkdj20e80e8jrt.jpg
             * avatar_hd : http://tva3.sinaimg.cn/crop.0.0.512.512.1024/61ff32dejw8ev91yl3hkdj20e80e8jrt.jpg
             * verified_reason : 新京报官方微博
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
             * bi_followers_count : 690
             * lang : zh-cn
             * star : 0
             * mbtype : 2
             * mbrank : 5
             * block_word : 0
             * block_app : 0
             * credit_score : 80
             * user_ability : 516
             * urank : 40
             */

            private long id;
            private String idstr;
            @SerializedName("class")
            private int classX;
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
            private int followers_count;
            private int friends_count;
            private int pagefriends_count;
            private int statuses_count;
            private int favourites_count;
            private String created_at;
            private boolean following;
            private boolean allow_all_act_msg;
            private boolean geo_enabled;
            private boolean verified;
            private int verified_type;
            private String remark;
            private int ptype;
            private boolean allow_all_comment;
            private String avatar_large;
            private String avatar_hd;
            private String verified_reason;
            private String verified_trade;
            private String verified_reason_url;
            private String verified_source;
            private String verified_source_url;
            private int verified_state;
            private int verified_level;
            private int verified_type_ext;
            private String verified_reason_modified;
            private String verified_contact_name;
            private String verified_contact_email;
            private String verified_contact_mobile;
            private boolean follow_me;
            private int online_status;
            private int bi_followers_count;
            private String lang;
            private int star;
            private int mbtype;
            private int mbrank;
            private int block_word;
            private int block_app;
            private int credit_score;
            private int user_ability;
            private int urank;

            public long getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIdstr() {
                return idstr;
            }

            public void setIdstr(String idstr) {
                this.idstr = idstr;
            }

            public int getClassX() {
                return classX;
            }

            public void setClassX(int classX) {
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

            public int getFollowers_count() {
                return followers_count;
            }

            public void setFollowers_count(int followers_count) {
                this.followers_count = followers_count;
            }

            public int getFriends_count() {
                return friends_count;
            }

            public void setFriends_count(int friends_count) {
                this.friends_count = friends_count;
            }

            public int getPagefriends_count() {
                return pagefriends_count;
            }

            public void setPagefriends_count(int pagefriends_count) {
                this.pagefriends_count = pagefriends_count;
            }

            public int getStatuses_count() {
                return statuses_count;
            }

            public void setStatuses_count(int statuses_count) {
                this.statuses_count = statuses_count;
            }

            public int getFavourites_count() {
                return favourites_count;
            }

            public void setFavourites_count(int favourites_count) {
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

            public int getVerified_type() {
                return verified_type;
            }

            public void setVerified_type(int verified_type) {
                this.verified_type = verified_type;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getPtype() {
                return ptype;
            }

            public void setPtype(int ptype) {
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

            public int getVerified_state() {
                return verified_state;
            }

            public void setVerified_state(int verified_state) {
                this.verified_state = verified_state;
            }

            public int getVerified_level() {
                return verified_level;
            }

            public void setVerified_level(int verified_level) {
                this.verified_level = verified_level;
            }

            public int getVerified_type_ext() {
                return verified_type_ext;
            }

            public void setVerified_type_ext(int verified_type_ext) {
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

            public int getOnline_status() {
                return online_status;
            }

            public void setOnline_status(int online_status) {
                this.online_status = online_status;
            }

            public int getBi_followers_count() {
                return bi_followers_count;
            }

            public void setBi_followers_count(int bi_followers_count) {
                this.bi_followers_count = bi_followers_count;
            }

            public String getLang() {
                return lang;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public int getStar() {
                return star;
            }

            public void setStar(int star) {
                this.star = star;
            }

            public int getMbtype() {
                return mbtype;
            }

            public void setMbtype(int mbtype) {
                this.mbtype = mbtype;
            }

            public int getMbrank() {
                return mbrank;
            }

            public void setMbrank(int mbrank) {
                this.mbrank = mbrank;
            }

            public int getBlock_word() {
                return block_word;
            }

            public void setBlock_word(int block_word) {
                this.block_word = block_word;
            }

            public int getBlock_app() {
                return block_app;
            }

            public void setBlock_app(int block_app) {
                this.block_app = block_app;
            }

            public int getCredit_score() {
                return credit_score;
            }

            public void setCredit_score(int credit_score) {
                this.credit_score = credit_score;
            }

            public int getUser_ability() {
                return user_ability;
            }

            public void setUser_ability(int user_ability) {
                this.user_ability = user_ability;
            }

            public int getUrank() {
                return urank;
            }

            public void setUrank(int urank) {
                this.urank = urank;
            }
        }

        public static class VisibleBean {
            /**
             * type : 0
             * list_id : 0
             */

            private int type;
            private int list_id;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getList_id() {
                return list_id;
            }

            public void setList_id(int list_id) {
                this.list_id = list_id;
            }
        }
    }
}
