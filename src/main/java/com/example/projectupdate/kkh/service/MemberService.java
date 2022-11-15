package com.example.projectupdate.kkh.service;

import java.util.List;

import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.Member;

public interface MemberService {
	Member memberLogin(String id);
	int register(Member member);
	int idCheck(Member member);
	List<Common> selectLocList();
	Member memberSelect(Member member);
//	Member adminChk(String id);
	
}
