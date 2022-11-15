package com.example.projectupdate.kkh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectupdate.entity.QList;
import com.example.projectupdate.kkh.repository.QListRepository;

@Service
public class QListServiceImpl implements QListService {
	
	private final QListRepository qlistRepository;
	@Autowired
	public QListServiceImpl(QListRepository qlistRepository) {
		this.qlistRepository = qlistRepository;
	}
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("QListServiceImpl total start");
		total = qlistRepository.total();
		return total;
	}

	@Override
	public List<QList> qlistSelect(QList qlist) {
		System.out.println("QListServiceImpl listqlist");
		List<QList> listQList = null;
		listQList = qlistRepository.qlistSelect(qlist);
		return listQList;
	}

	@Override
	public QList qlistDetail(int boardno) {
		System.out.println("QListServiceImpl qlistDetail Start");
		QList qlist = null;
		qlist = qlistRepository.qlistDetail(boardno);

		return qlist;
	}

	

}
