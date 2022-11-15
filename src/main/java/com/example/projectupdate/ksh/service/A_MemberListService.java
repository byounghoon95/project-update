package com.example.projectupdate.ksh.service;

import java.util.List;

import com.example.projectupdate.entity.Member;
import com.example.projectupdate.entity.Common;

public interface A_MemberListService {
	int total();
	List<Member> listMember(Member member);
	Member detail(String id);
	int update(Member member);
	List<Member> A_Mkeyword(Member member);
	int totalKeyword(Member member);
	int delete(Member member);
	List<Common> StatusList(Common common);
	
	
	
}
