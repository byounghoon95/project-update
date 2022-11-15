package com.example.projectupdate.kkh.repository;

import java.util.List;

import com.example.projectupdate.entity.QList;

public interface QListRepository {

	int total();

	List<QList> qlistSelect(QList qlist);

	QList qlistDetail(int boardno);

}
