package com.example.projectupdate.khj.repository;

import java.util.List;

import com.example.projectupdate.entity.Item;

public interface MarketRepository {

	List<Item> marketBestSelect(Item item);
	List<Item> marketAllSelect(Item item);
	int total();

}
