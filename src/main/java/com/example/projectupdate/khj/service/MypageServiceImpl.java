package com.example.projectupdate.khj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectupdate.entity.Board;
import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.Item;
import com.example.projectupdate.entity.Member;
import com.example.projectupdate.entity.Reservation;
import com.example.projectupdate.khj.repository.MypageRepository;

@Service
public class MypageServiceImpl implements MypageService {
	
	private final MypageRepository mypageRepository;
	@Autowired
	public MypageServiceImpl(MypageRepository mypageRepository) {
		this.mypageRepository = mypageRepository;
	}

	@Override
	public Member memberMypage(Member member) {
		System.out.println("MypageServiceImpl memberMypage Start...");
		member = mypageRepository.memberMypage(member);
		return member;
	}

	@Override
	public String memberLocNameSelect(String id) {
		 System.out.println("MypageServiceImpl memberLocNameSelect Start....");
	     String memberLocName = null;
	     memberLocName = mypageRepository.memberLocNameSelect(id);
	     return memberLocName;
	}

	@Override
	public List<Board> mypageBoardSelect(Board board) {
		System.out.println("MypageServiceImpl mypageBoardSelect ...");
		List<Board> mypageBoardSelect = null;
		mypageBoardSelect = mypageRepository.mypageBoardSelect(board);
		return mypageBoardSelect;
	}

	@Override
	public List<Item> mypageWishList(Item item) {
		System.out.println("MypageServiceImpl mypageWishList ...");
		List<Item> mypageWishSelect = null;
		mypageWishSelect = mypageRepository.mypageWishSelect(item);
		return mypageWishSelect;
	}
	
	@Override
	public List<Item> mypageBuyList(Item item) {
		System.out.println("MypageServiceImpl mypageBuyList ...");
		List<Item> mypageBuySelect = null;
		mypageBuySelect = mypageRepository.mypageBuySelect(item);
		return mypageBuySelect;
	}

	@Override
	public List<Item> mypageSellList(Item item) {
		System.out.println("MypageServiceImpl mypageSellList ...");
		List<Item> mypageSellSelect = null;
		mypageSellSelect = mypageRepository.mypageSellSelect(item);
		return mypageSellSelect;
	}

	@Override
	public List<Item> mypageSellList2(Item item) {
		System.out.println("MypageServiceImpl mypageSellList2 ...");
		List<Item> mypageSellList2 = null;
		mypageSellList2 = mypageRepository.mypageSellSelect2(item);
		return mypageSellList2;
	}
	
	@Override
	public int totalSellCount(Item item) {
		System.out.println("MypageServiceImpl totalSellCount Start....");
	    int totalSellCount = 0;
	    totalSellCount = mypageRepository.totalSellCount(item);
	    return totalSellCount;
		
	}

	@Override
	public int totalSellCost(Item item) {
		System.out.println("MypageServiceImpl totalSellCost Start....");
	    int totalSellCost = 0;
	    totalSellCost = mypageRepository.totalSellCost(item);
	    return totalSellCost;
	}

	@Override
	public int mypagePrfUpdate(Member member) {
		System.out.println("MypageServiceImpl mypagePrfUpdate Start...");
		int result = 0;
		result = mypageRepository.mypagePrfUpdate(member);
		return result;
	}

	@Override
	public List<Reservation> mypageCommentSelect(Reservation reservation) {
		System.out.println("MypageServiceImpl mypageCommentSelect ...");
		List<Reservation> mypageCommentSelect = null;
		mypageCommentSelect = mypageRepository.mypageCommentSelect(reservation);
		return mypageCommentSelect;
	}

	@Override
	public List<Common> selectLocList() {
		System.out.println("MypageServiceImpl selectLocList start");
		List<Common> selectLocList = mypageRepository.selectLocList();
		return selectLocList;
	}

	@Override
	public Member memberMypage(String id) {
		System.out.println("MypageServiceImpl memberMypage Start...");
		Member member = null;
		member = mypageRepository.memberMypage(id);
		return member;
	}

	@Override
	public List<Item> mypageOtherSellList(Item item) {
		System.out.println("MypageServiceImpl mypageOtherSellList ...");
		List<Item> mypageOtherSellList = null;
		mypageOtherSellList = mypageRepository.mypageOtherSellList(item);
		return mypageOtherSellList;
	}

	
	
//	@Override
//	public int mypagePrfUpdatePro(Member member) {
//		System.out.println("MypageServiceImpl mypagePrfUpdatePro Start...");
//		int result = 0;
//		result = mypageRepository.mypagePrfUpdate(member);
//		return result;
//	}




}
