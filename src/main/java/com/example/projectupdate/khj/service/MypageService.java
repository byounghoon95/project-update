package com.example.projectupdate.khj.service;

import java.util.List;

import com.example.projectupdate.entity.Board;
import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.Item;
import com.example.projectupdate.entity.Member;
import com.example.projectupdate.entity.Reservation;

public interface MypageService {

	Member memberMypage(Member member);
	String memberLocNameSelect(String id);
	List<Board> mypageBoardSelect(Board board);
	List<Item> mypageWishList(Item item);
	List<Item> mypageBuyList(Item item);
	List<Item> mypageSellList(Item item);
	int totalSellCount(Item item);
	int totalSellCost(Item item);
	int mypagePrfUpdate(Member member);
	List<Reservation> mypageCommentSelect(Reservation reservation);
	List<Common> selectLocList();
	Member memberMypage(String id);
	List<Item> mypageOtherSellList(Item item);
	List<Item> mypageSellList2(Item item);

}
