package com.example.projectupdate.kkh.repository;

import java.util.List;

import com.example.projectupdate.entity.Notice;

public interface NoticeRepository {
	List<Notice> noticeSelect(Notice notice);
	int total();
	Notice noticeView(int boardno);
	
}
