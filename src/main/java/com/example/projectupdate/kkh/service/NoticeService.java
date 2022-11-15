package com.example.projectupdate.kkh.service;

import java.util.List;

import com.example.projectupdate.entity.Notice;

public interface NoticeService {

	List<Notice> noticeSelect(Notice notice);

	int total();

	Notice noticeView(int boardno);

}
