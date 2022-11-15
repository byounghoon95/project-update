package com.example.projectupdate.lbh.repository;

import java.util.List;

import com.example.projectupdate.entity.Board;
import com.example.projectupdate.entity.Warning;

public interface BoardRepository {
	List<Board> boardSelect(Board board);
	int total(Board board);
	int boardWrite(Board board);
	Board boardDetail(int boardno);
	int boardReply(Board board);
	int replyShape(Board board);
	int boardUpdate(Board board);
	int boardDelete(Board board, Warning warning);
	List<Board> boardReplyList(int ref);
	Board boardReplyOne(int boardno);
	int boardReplyCnt(int boardno);
	int boardReplyUpdate(Board board);
	int boardReplyDelete(Board board);
}
