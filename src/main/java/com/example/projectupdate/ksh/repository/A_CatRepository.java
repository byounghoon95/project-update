package com.example.projectupdate.ksh.repository;

import java.util.List;

import com.example.projectupdate.entity.Common;

public interface A_CatRepository {

	List<Common> listAcat(Common common);

	Common commBcdSelect(int i);

	int adminCatWrite(Common common);

	List<Common> CatList(Common common);

	int total_1900();

}
