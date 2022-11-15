package com.example.projectupdate.pch.repository;

import java.util.List;

import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.Item;

public interface SearchRepository {
	int 			total();
	List<Common> 	listCommon(Common common);
	List<Common> 	listCartegori(Common common);
	int 			totalItemKeyword(Item item);
	List<Item> 		listItemKeyword(Item item);
} 
