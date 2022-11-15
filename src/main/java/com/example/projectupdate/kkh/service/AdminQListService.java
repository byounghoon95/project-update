package com.example.projectupdate.kkh.service;

import java.util.List;

import com.example.projectupdate.entity.AdminQList;

public interface AdminQListService {

	int total();

	List<AdminQList> adminQListSelect(AdminQList adminqlist);

	int adminQListWrite(AdminQList adminqlist);

	AdminQList adminQListDetail(int boardno);

	int adminQListUpdate(AdminQList adminqlist);

	int adminQListDelete(AdminQList adminqlist);

}
