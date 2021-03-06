package com.test02.dto;

public class MyTestDto {
	private int mno;
	private String mname;
	private String nickname;
	
	//생성자(기본,매개변수),getter&setter, toString
	public MyTestDto() {
		super();
	}
	
	public MyTestDto(int mno, String mname, String nickname) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.nickname = nickname;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "MyTestDto [mno=" + mno + ", mname=" + mname + ", nickname=" + nickname + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
