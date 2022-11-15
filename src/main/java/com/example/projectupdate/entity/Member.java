package com.example.projectupdate.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

	
	private String id;
	private String nickname;
	private String name;
	private String pw;
	private String email;
	private String phone;
	private int locno;
	private String userImg;
	private Date joindate;
	private int participation;
	private int warningcnt;
	private int bcd;
	private int mcd;
	
	//join
	private String content;
	
	private int chk;
	
	private int start;
	private int end;
	private String keyword;
	private String search;


//	private String userimg;
	

}
