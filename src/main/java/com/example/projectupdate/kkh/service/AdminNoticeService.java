package com.example.projectupdate.kkh.service;

import java.util.List;

import com.example.projectupdate.entity.AdminNotice;

public interface AdminNoticeService {


	int total();

	List<AdminNotice> adminNoticeSelect(AdminNotice adminnotice);

	int adminNoticeWrite(AdminNotice adminnotice);

	AdminNotice adminNoticeDetail(int boardno);

	int adminNoticeUpdate(AdminNotice adminnotice);

	int adminNoticeDelete(AdminNotice adminnotice);

}
