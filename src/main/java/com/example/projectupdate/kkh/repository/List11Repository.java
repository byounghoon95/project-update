package com.example.projectupdate.kkh.repository;

import java.util.List;

import com.example.projectupdate.entity.List11;

public interface List11Repository {

	int total();


	List<List11> List11Select(List11 list11);


	List11 list11Detail(int inqno);


	int list11Write(List11 list11);


	int list11Update(List11 list11);


	int list11Delete(List11 list11);


	int list11ReplyCnt(int inqno);


	List<List11> list11ReplyList(int ref);

}
