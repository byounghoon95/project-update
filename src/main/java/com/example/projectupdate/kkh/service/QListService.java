package com.example.projectupdate.kkh.service;

import java.util.List;

import com.example.projectupdate.entity.QList;

public interface QListService {

	int total();

	List<QList> qlistSelect(QList qlist);

	QList qlistDetail(int boardno);

}
