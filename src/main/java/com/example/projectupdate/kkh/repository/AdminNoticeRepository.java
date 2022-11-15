package com.example.projectupdate.kkh.repository;

import java.util.List;

import com.example.projectupdate.entity.AdminNotice;

public interface AdminNoticeRepository {
	int total();
	List<AdminNotice> adminNoticeSelect(AdminNotice adminnotice);
	int adminNoticeWrite(AdminNotice adminnotice);
	AdminNotice adminNoticeDetail(int boardno);
	int adminNoticeUpdate(AdminNotice adminnotice);
	int adminNoticeDelete(AdminNotice adminnotice);
	
}
