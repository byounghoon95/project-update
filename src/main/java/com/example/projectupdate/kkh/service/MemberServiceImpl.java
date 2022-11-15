package com.example.projectupdate.kkh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.Member;
import com.example.projectupdate.kkh.repository.MemberRepository;
@Service
public class MemberServiceImpl implements MemberService {

	
	private final MemberRepository memberRepository;
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public Member memberLogin(String id) {
		System.out.println("MemberServiceImpl memberLogin start");
		Member member = memberRepository.memberLogin(id);
		
		return member;
	}

	@Override
	public int register(Member member) {
		System.out.println("MemberServiceImpl register start");
		int result = memberRepository.register(member);
		return result;
	}
	
	@Override
	public int idCheck(Member member) {
		int result = 0;
		System.out.println("MemberServiceImpl idCehck start");
		result = memberRepository.idCheck(member);
		
		return result;
	}
	
	@Override
	public List<Common> selectLocList() {
		System.out.println("MemberServiceImpl selectLocList start");
		List<Common> selectLocList = memberRepository.selectLocList();
		return selectLocList;
	}

	@Override
	public Member memberSelect(Member member) {
		System.out.println("MemberServiceImpl memberSelect start");
		System.out.println("MemberServiceImpl memberSelect name -> " + member.getName());
		System.out.println("MemberServiceImpl memberSelect email -> " + member.getEmail());
		Member dbmember = memberRepository.memberSelect(member);
		
		return dbmember;
	}

//	@Override
//	public Member adminChk(String id) {
//		System.out.println("MemberServiceImpl memberLogin start");
//		Member member = memberRepository.adminLogin(id);
//		
//		return member;
//	}
	
}
