package com.example.projectupdate.kjh.service;

import java.util.List;

import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.Item;
import com.example.projectupdate.entity.Warning;

public interface ItemService {

	int itemReg(Item item);

	List<Common> itemCategorySelect();

	List<Common> reportCategorySelect();

	String memberLocNameSelect(String id);

	String warnNicknameSelect(Warning warning);

	int reportReg(Warning warning);

	Item itemDetail(Item item);

	String locName(Item item);

	List<Item> sellerItemList(Item item);

	int wishCheck(Item item);

	int itemUpdate(Item item);

	int itemDelete(Item item, Warning warning);

	void changeHeart(Item item);

	String resStat(Item item);

	

}
