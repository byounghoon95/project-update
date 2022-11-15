package com.example.projectupdate.kkh.repository;

import java.util.List;

import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.Member;

public interface MemberRepository {
	Member memberLogin(String id);

	int register(Member member);

	int idCheck(Member member);

	List<Common> selectLocList();

	Member memberSelect(Member member);

//	Member adminLogin(String id);
	
}
