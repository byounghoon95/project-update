package com.example.projectupdate.kkh.repository;

import java.util.List;

import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.MemberEntity;

public interface MemberRepository {
	MemberEntity memberLogin(String id);

	int register(MemberEntity member);

	int idCheck(MemberEntity member);

	List<Common> selectLocList();

	MemberEntity memberSelect(MemberEntity member);

//	Member adminLogin(String id);
	
}
