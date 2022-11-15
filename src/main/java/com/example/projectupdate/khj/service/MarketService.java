package com.example.projectupdate.khj.service;

import java.util.List;

import com.example.projectupdate.entity.Item;

public interface MarketService {

	List<Item> marketBestList(Item item);
	List<Item> marketAllList(Item item);
	int total();
	
}
