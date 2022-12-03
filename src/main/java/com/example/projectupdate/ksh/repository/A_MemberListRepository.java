package com.example.projectupdate.ksh.repository;

import java.util.List;

import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.MemberEntity;

public interface A_MemberListRepository {
	int total();
	List<MemberEntity> listMember(MemberEntity member);
	MemberEntity detail(String id);
	int update(MemberEntity member);
	List<MemberEntity> A_Mkeyword(MemberEntity member);
	int totalKeyword(MemberEntity member);
	int delete(MemberEntity member);
	List<Common> StatusList(Common common);
	
	
}
