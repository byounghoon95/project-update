package com.example.projectupdate.pch.service;

import java.util.List;

import com.example.projectupdate.entity.Common;
import com.example.projectupdate.entity.Item;

public interface SearchService {
	int				total();
	List<Common> 	listCommon(Common common);
	List<Common> 	listCartegori(Common common);
	int 			totalItemKeyword(Item item);
	List<Item> 		listItemKeyword(Item item);
}
