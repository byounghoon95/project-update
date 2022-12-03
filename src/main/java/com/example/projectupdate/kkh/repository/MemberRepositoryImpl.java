//package com.example.projectupdate.kkh.repository;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.example.projectupdate.entity.Common;
//import com.example.projectupdate.entity.MemberEntity;
//
//@Repository
//public class MemberRepositoryImpl implements MemberRepository {
//
//	@Autowired
//	private SqlSession		session;
//
//	@Override
//	public MemberEntity memberLogin(String id) {
//		MemberEntity member = null;
//		System.out.println("MemberRepositoryImpl memberLogin start");
//		System.out.println("MemberRepositoryImpl memberLogin id -> " + id);
//
//		try {
//			member = session.selectOne("kkhGetIdPass",id);
//			System.out.println("MemberRepositoryImpl id -> " + member.getId());
//			System.out.println("MemberRepositoryImpl pw -> " + member.getPw());
//		}catch (Exception e) {
//			System.out.println("MemberRepositoryImpl memberLogin exception-> " + e.getMessage());
//		}
//		return member;
//	}
//
//	@Override
//	public int register(MemberEntity member) {
//		int result = 0;
//		System.out.println("MemberRepositoryImpl register start");
//		try {
//			result = session.insert("kkhregister",member);
//		}catch (Exception e) {
//			System.out.println("MemberRepositoryImpl register exception -> " + e.getMessage());
//		}
//		return result;
//	}
//
//	@Override
//	public int idCheck(MemberEntity member) {
//		int result = 0;
//		System.out.println("MemberRepositoryImpl idCheck start");
//		try {
//			result = session.selectOne("kkhidCheck",member);
//		}catch (Exception e) {
//			System.out.println("MemberRepositoryImpl idCheck exception -> " + e.getMessage());
//		}
//		return result;
//	}
//
//	@Override
//	public List<Common> selectLocList() {
//
//		List<Common> selectLocList = null;
//
//		System.out.println("MemberRepositoryImpl selectLocList start");
//		try {
//			selectLocList = session.selectList("kkhselectLocList");
//		}catch (Exception e) {
//			System.out.println("MemberRepositoryImpl selectLocList exception -> " + e.getMessage());
//		}
//		return selectLocList;
//	}
//
//	@Override
//	public MemberEntity memberSelect(MemberEntity member) {
//		System.out.println("MemberRepositoryImpl memberSelect start");
//		MemberEntity dbmember = null;
//		MemberEntity nullmember = new MemberEntity();
//		int chk = 0;
//
//		int cnt = session.selectOne("kkhmemberSelectCnt",member);
//		System.out.println("cnt -> " + cnt);
//		try {
//			if (cnt == 1) {
//				chk = 1;
//				dbmember = session.selectOne("kkhmemberSelect",member);
//				dbmember.setChk(chk);
//			}else {
//				dbmember = nullmember;
//				dbmember.setChk(chk);
//			}
//		}catch (Exception e) {
//			System.out.println("MemberRepositoryImpl memberSelect exception -> " + e.getMessage());
//		}
//		return dbmember;
//	}
//
////	@Override
////	public Member adminLogin(String id) {
////		Member member = null;
////		System.out.println("MemberRepositoryImpl adminLogin start");
////		System.out.println("MemberRepositoryImpl adminLogin id -> " + id);
////
////		try {
////			member = session.selectOne("kkhGetIdPass",id);
////			System.out.println("MemberRepositoryImpl id -> " + member.getId());
////			System.out.println("MemberRepositoryImpl pw -> " + member.getPw());
////		}catch (Exception e) {
////			System.out.println("MemberRepositoryImpl memberLogin exception-> " + e.getMessage());
////		}
////		return member;
////	}
//
//}
