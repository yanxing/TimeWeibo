package com.yanxing.sortlistviewlibrary;

public class GroupMemberBean {

	private String name;   //显示的数据
	private String sortLetters;  //显示数据拼音的首字母
	private String headURL;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSortLetters() {
		return sortLetters;
	}
	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}

	public String getHeadURL() {
		return headURL;
	}

	public void setHeadURL(String headURL) {
		this.headURL = headURL;
	}
}
