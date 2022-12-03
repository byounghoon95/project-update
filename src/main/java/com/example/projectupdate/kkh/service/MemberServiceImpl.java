//package com.example.projectupdate.kkh.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.projectupdate.entity.Common;
//import com.example.projectupdate.entity.MemberEntity;
//import com.example.projectupdate.kkh.repository.MemberRepository;
//@Service
//public class MemberServiceImpl implements MemberService {
//
//
//	private final MemberRepository memberRepository;
//	@Autowired
//	public MemberServiceImpl(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//	}
//
//	@Override
//	public MemberEntity memberLogin(String id) {
//		System.out.println("MemberServiceImpl memberLogin start");
//		MemberEntity member = memberRepository.memberLogin(id);
//
//		return member;
//	}
//
//	@Override
//	public int register(MemberEntity member) {
//		System.out.println("MemberServiceImpl register start");
//		int result = memberRepository.register(member);
//		return result;
//	}
//
//	@Override
//	public int idCheck(MemberEntity member) {
//		int result = 0;
//		System.out.println("MemberServiceImpl idCehck start");
//		result = memberRepository.idCheck(member);
//
//		return result;
//	}
//
//	@Override
//	public List<Common> selectLocList() {
//		System.out.println("MemberServiceImpl selectLocList start");
//		List<Common> selectLocList = memberRepository.selectLocList();
//		return selectLocList;
//	}
//
//	@Override
//	public MemberEntity memberSelect(MemberEntity member) {
//		System.out.println("MemberServiceImpl memberSelect start");
//		System.out.println("MemberServiceImpl memberSelect name -> " + member.getName());
//		System.out.println("MemberServiceImpl memberSelect email -> " + member.getEmail());
//		MemberEntity dbmember = memberRepository.memberSelect(member);
//
//		return dbmember;
//	}
//
////	@Override
////	public Member adminChk(String id) {
////		System.out.println("MemberServiceImpl memberLogin start");
////		Member member = memberRepository.adminLogin(id);
////
////		return member;
////	}
//
//}
