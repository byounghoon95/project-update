//package com.example.projectupdate.ksh.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.projectupdate.entity.Common;
//import com.example.projectupdate.entity.MemberEntity;
//import com.example.projectupdate.ksh.repository.A_MemberListRepository;
//
//
//@Service
//public class A_MemberListServiceImpl implements A_MemberListService {
//	@Autowired
//	private A_MemberListRepository mr; //Repository와 연결
//
//	@Override
//	public int total() {
//		System.out.println("A_MemberListServiceImpl Start total..");
//		int totCnt = mr.total();
//		System.out.println("A_MemberListServiceImpl total totCnt->"+totCnt);
//		return totCnt;
//	}
//
//	@Override
//	public List<MemberEntity> listMember(MemberEntity member) {
//		List<MemberEntity> memberList = null;
//		System.out.println("A_MemberListServiceImpl listMember Start..");
//		memberList = mr.listMember(member);
//		System.out.println("A_MemberListServiceImpl listMember memberList.size() ->" + memberList.size());
//		return memberList;
//	}
//
//	@Override
//	public MemberEntity detail(String id) {
//		System.out.println("A_MemberListServiceImpl detail...");
//		MemberEntity member = null;
//		member = mr.detail(id);
//		return member;
//	}
//
//
//	@Override public int update(MemberEntity member) {
//
//	  System.out.println("A_MemberListServiceImpl update ...");
//	  int kkk = 0;
//	  kkk =mr.update(member);
//	  return kkk;
//	  }
//
//	@Override
//	public List<MemberEntity> A_Mkeyword(MemberEntity member) {
//		List<MemberEntity> A_Mkeyword = null;
//		System.out.println("A_MemberListServiceImpl A_Mkeyword Start..");
//		A_Mkeyword = mr.A_Mkeyword(member);
//		System.out.println("A_MemberListServiceImpl A_Mkeyword memberList.size() ->" + A_Mkeyword.size());
//		return A_Mkeyword;
//	}
//
//	@Override
//	public int totalKeyword(MemberEntity member) {
//		System.out.println("A_MemberListServiceImpl totalKeyword Start ..");
//		int totCnt = mr.totalKeyword(member);
//		System.out.println("A_MemberListServiceImpl totalKeyword totCnt->"+totCnt);
//		return totCnt;
//	}
//
//	@Override
//	public int delete(MemberEntity member) {
//		System.out.println("A_MemberListServiceImpl delete Start");
//		int result = 0;
//		result = mr.delete(member);
//		return result;
//	}
//
//
//	@Override
//	   public List<Common> StatusList(Common common) {
//	      System.out.println("A_MemberListServiceImpl StatusList Start....");
//	      List<Common> memberStatusList= null;
//	      memberStatusList = mr.StatusList(common);
//	      for(Common memberStatus : memberStatusList)
//          { System.out.println("A_MemberListServiceImpl StatusList   memberStatus.getMcd()->" + memberStatus.getMcd() );
//            System.out.println("A_MemberListSeadminCatListrviceImpl StatusList memberStatus.getContent())->" + memberStatus.getContent() );
//          }
//	      return memberStatusList;
//	   }
//
//
//}
