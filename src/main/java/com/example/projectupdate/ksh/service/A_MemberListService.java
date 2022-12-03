package com.example.projectupdate.ksh.service;

import java.util.List;

import com.example.projectupdate.entity.MemberEntity;
import com.example.projectupdate.entity.Common;

public interface A_MemberListService {
	int total();
	List<MemberEntity> listMember(MemberEntity member);
	MemberEntity detail(String id);
	int update(MemberEntity member);
	List<MemberEntity> A_Mkeyword(MemberEntity member);
	int totalKeyword(MemberEntity member);
	int delete(MemberEntity member);
	List<Common> StatusList(Common common);
	
	
	
}
