package com.example.projectupdate.kkh.repository;

import java.util.List;

import com.example.projectupdate.entity.AdminQList;

public interface AdminQListRepository {

	int total();

	List<AdminQList> adminQListSelect(AdminQList adminqlist);

	int adminQListWrite(AdminQList adminqlist);

	AdminQList adminQListDetail(int boardno);

	int adminQListUpdate(AdminQList adminqlist);

	int adminQListDelete(AdminQList adminqlist);

}
