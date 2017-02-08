package com.yanxing.weibo;

import java.util.List;

/**
 * Created by lishuangxiang on 2017/1/16.
 */
public class Test {

    /**
     * Data : [{"Age":25,"ApplyStatus":0,"AttNums":48,"Company":"","FansNums":67,"Gender":0,"IsAtt":0,"IsAuthentication":0,"IsBlack":0,"IsForbid":0,"IsOfficial":0,"IsShowV":0,"Job":"","Mobile":"18291479008","NBaoNums":0,"NBi":0,"NickName":"不羁的北风","RegisterTime":"2016/6/15 0:00:00","RoomSource":0,"UserDescription":"无论你处于什么位置或状态，都不必太过在意，人生就是一场马拉松。","UserId":11026,"UserLevel":10,"UserPortrait":"https://staticqiniu.newzhibo.cn/images/20161217/20161217233246047a6ed6.jpg","VNums":0,"WeekStarRankGift":[],"YxToken":"42e499e591496cb71d9a11ae109dc962","list":[],"msgList":[],"rechargeList":[]}]
     * IsSingle : 0
     * PageCount : 0
     * PageSize : 0
     * ReturnCode : 0
     * ReturnMsgID :
     * UserID : 11026
     */

    private int IsSingle;
    private int PageCount;
    private int PageSize;
    private int ReturnCode;
    private String ReturnMsgID;
    private String UserID;
    private List<DataBean> Data;

    public int getIsSingle() {
        return IsSingle;
    }

    public void setIsSingle(int IsSingle) {
        this.IsSingle = IsSingle;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int PageCount) {
        this.PageCount = PageCount;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }

    public int getReturnCode() {
        return ReturnCode;
    }

    public void setReturnCode(int ReturnCode) {
        this.ReturnCode = ReturnCode;
    }

    public String getReturnMsgID() {
        return ReturnMsgID;
    }

    public void setReturnMsgID(String ReturnMsgID) {
        this.ReturnMsgID = ReturnMsgID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * Age : 25
         * ApplyStatus : 0
         * AttNums : 48
         * Company :
         * FansNums : 67
         * Gender : 0
         * IsAtt : 0
         * IsAuthentication : 0
         * IsBlack : 0
         * IsForbid : 0
         * IsOfficial : 0
         * IsShowV : 0
         * Job :
         * Mobile : 18291479008
         * NBaoNums : 0
         * NBi : 0
         * NickName : 不羁的北风
         * RegisterTime : 2016/6/15 0:00:00
         * RoomSource : 0
         * UserDescription : 无论你处于什么位置或状态，都不必太过在意，人生就是一场马拉松。
         * UserId : 11026
         * UserLevel : 10
         * UserPortrait : https://staticqiniu.newzhibo.cn/images/20161217/20161217233246047a6ed6.jpg
         * VNums : 0
         * WeekStarRankGift : []
         * YxToken : 42e499e591496cb71d9a11ae109dc962
         * list : []
         * msgList : []
         * rechargeList : []
         */

        private int Age;
        private int ApplyStatus;
        private int AttNums;
        private String Company;
        private int FansNums;
        private int Gender;
        private int IsAtt;
        private int IsAuthentication;
        private int IsBlack;
        private int IsForbid;
        private int IsOfficial;
        private int IsShowV;
        private String Job;
        private String Mobile;
        private int NBaoNums;
        private int NBi;
        private String NickName;
        private String RegisterTime;
        private int RoomSource;
        private String UserDescription;
        private int UserId;
        private int UserLevel;
        private String UserPortrait;
        private int VNums;
        private String YxToken;
        private List<?> WeekStarRankGift;
        private List<?> list;
        private List<?> msgList;
        private List<?> rechargeList;

        public int getAge() {
            return Age;
        }

        public void setAge(int Age) {
            this.Age = Age;
        }

        public int getApplyStatus() {
            return ApplyStatus;
        }

        public void setApplyStatus(int ApplyStatus) {
            this.ApplyStatus = ApplyStatus;
        }

        public int getAttNums() {
            return AttNums;
        }

        public void setAttNums(int AttNums) {
            this.AttNums = AttNums;
        }

        public String getCompany() {
            return Company;
        }

        public void setCompany(String Company) {
            this.Company = Company;
        }

        public int getFansNums() {
            return FansNums;
        }

        public void setFansNums(int FansNums) {
            this.FansNums = FansNums;
        }

        public int getGender() {
            return Gender;
        }

        public void setGender(int Gender) {
            this.Gender = Gender;
        }

        public int getIsAtt() {
            return IsAtt;
        }

        public void setIsAtt(int IsAtt) {
            this.IsAtt = IsAtt;
        }

        public int getIsAuthentication() {
            return IsAuthentication;
        }

        public void setIsAuthentication(int IsAuthentication) {
            this.IsAuthentication = IsAuthentication;
        }

        public int getIsBlack() {
            return IsBlack;
        }

        public void setIsBlack(int IsBlack) {
            this.IsBlack = IsBlack;
        }

        public int getIsForbid() {
            return IsForbid;
        }

        public void setIsForbid(int IsForbid) {
            this.IsForbid = IsForbid;
        }

        public int getIsOfficial() {
            return IsOfficial;
        }

        public void setIsOfficial(int IsOfficial) {
            this.IsOfficial = IsOfficial;
        }

        public int getIsShowV() {
            return IsShowV;
        }

        public void setIsShowV(int IsShowV) {
            this.IsShowV = IsShowV;
        }

        public String getJob() {
            return Job;
        }

        public void setJob(String Job) {
            this.Job = Job;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public int getNBaoNums() {
            return NBaoNums;
        }

        public void setNBaoNums(int NBaoNums) {
            this.NBaoNums = NBaoNums;
        }

        public int getNBi() {
            return NBi;
        }

        public void setNBi(int NBi) {
            this.NBi = NBi;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getRegisterTime() {
            return RegisterTime;
        }

        public void setRegisterTime(String RegisterTime) {
            this.RegisterTime = RegisterTime;
        }

        public int getRoomSource() {
            return RoomSource;
        }

        public void setRoomSource(int RoomSource) {
            this.RoomSource = RoomSource;
        }

        public String getUserDescription() {
            return UserDescription;
        }

        public void setUserDescription(String UserDescription) {
            this.UserDescription = UserDescription;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public int getUserLevel() {
            return UserLevel;
        }

        public void setUserLevel(int UserLevel) {
            this.UserLevel = UserLevel;
        }

        public String getUserPortrait() {
            return UserPortrait;
        }

        public void setUserPortrait(String UserPortrait) {
            this.UserPortrait = UserPortrait;
        }

        public int getVNums() {
            return VNums;
        }

        public void setVNums(int VNums) {
            this.VNums = VNums;
        }

        public String getYxToken() {
            return YxToken;
        }

        public void setYxToken(String YxToken) {
            this.YxToken = YxToken;
        }

        public List<?> getWeekStarRankGift() {
            return WeekStarRankGift;
        }

        public void setWeekStarRankGift(List<?> WeekStarRankGift) {
            this.WeekStarRankGift = WeekStarRankGift;
        }

        public List<?> getList() {
            return list;
        }

        public void setList(List<?> list) {
            this.list = list;
        }

        public List<?> getMsgList() {
            return msgList;
        }

        public void setMsgList(List<?> msgList) {
            this.msgList = msgList;
        }

        public List<?> getRechargeList() {
            return rechargeList;
        }

        public void setRechargeList(List<?> rechargeList) {
            this.rechargeList = rechargeList;
        }
    }
}
