package com.example.projectupdate.kkh.repository;

import java.util.List;

import com.example.projectupdate.entity.AdminList11;

public interface AdminList11Repository {

	int total();

	List<AdminList11> adminList11Select(AdminList11 adminList11);

	AdminList11 adminList11Detail(int inqno);

	int adminList11Delete(AdminList11 adminList11);

	int adminList11Reply(AdminList11 adminList11);

	List<AdminList11> adminList11ReplyList(int ref);

	AdminList11 adminList11ReplyOne(int inqno);

	int adminList11ReplyCnt(int inqno);



}
