package com.example.projectupdate.khj.repository;

import java.util.List;

import com.example.projectupdate.entity.Board;
import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.Item;
import com.example.projectupdate.entity.Member;
import com.example.projectupdate.entity.Reservation;

public interface MypageRepository {

	Member memberMypage(Member member);
	String memberLocNameSelect(String id);
	List<Board> mypageBoardSelect(Board board);
	List<Item> mypageWishSelect(Item item);
	List<Item> mypageBuySelect(Item item);
	List<Item> mypageSellSelect(Item item);
	int totalSellCount(Item item);
	int totalSellCost(Item item);
//	int mypagePrfUpdate(Member member);
	int mypagePrfUpdate(Member member);
	List<Reservation> mypageCommentSelect(Reservation reservation);
	List<Common> selectLocList();
	Member memberMypage(String id);
	List<Item> mypageOtherSellList(Item item);
	List<Item> mypageSellSelect2(Item item);

}
