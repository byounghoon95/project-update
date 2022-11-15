package com.example.projectupdate.ksh.service;

import java.util.List;

import com.example.projectupdate.entity.Common;

public interface A_CatService {

	List<Common> listAcat(Common common);

	Common commBcdSelect(int i);

	int adminCatWrite(Common common);

	List<Common> CatList(Common common);

	int total_1900();

}
