package com.example.projectupdate.lbh.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projectupdate.entity.Board;
import com.example.projectupdate.entity.Warning;
@Repository
public class BoardRepositoryImpl implements BoardRepository{
	
	@Autowired
	private SqlSession		session;
	
	//Board 전체 리스트 조회
	   @Override
	   public List<Board> boardSelect(Board board) {
	      List<Board> listBoard = null;
	      System.out.println("BoardRepositoryImpl boardSelect start...");
	      if (board.getBdkeyword()== null) board.setBdkeyword("%");   /* <- 창현 추가(게시물검색) */
	      System.out.println("BoardRepositoryImpl boardSelect bdkeyword->"+board.getBdkeyword());   /* <- 창현 추가(게시물검색) */
	      try {
	         listBoard = session.selectList("lbhListBoard",board);   /*lbhListBoard 옆에  ,board 추가함(창현)*/
	         System.out.println("BoardRepositoryImpl boardSelect listBoard.size() -> " + listBoard.size());
	      } catch (Exception e) {
	         System.out.println("BoardRepositoryImpl boardSelect Exception->"+e.getMessage());
	      }
	      return listBoard;
	   }
	   //Board 댓글을 제외한 나머지 count
	   @Override
	   public int total(Board board) {   /* ()에서 (Board board) 추가함 */
	      int total = 0;
	      System.out.println("BoardRepositoryImpl total start...");
	      if (board.getBdkeyword()== null) board.setBdkeyword("%");   /* <- 창현 추가(게시물검색) */
	      System.out.println("BoardRepositoryImpl total bdkeyword->"+board.getBdkeyword());   /* <- 창현 추가(게시물검색) */
	      try {
	         total = session.selectOne("lbhBoardCount", board); /*lbhBoardCount 옆에 ,board 추가함(창현)*/
	         System.out.println("BoardRepositoryImpl total -> " + total);
	      } catch (Exception e) {
	         System.out.println("BoardRepositoryImpl total() Exception->"+e.getMessage());
	      }
	      return total;
	   }

	@Override
	public int boardWrite(Board board) {
		int result = 0;
		System.out.println("BoardRepositoryImpl boardWrite Start");
		try {
			result = session.insert("lbhBoardWrite",board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardWrite Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public Board boardDetail(int boardno) {
		System.out.println("BoardRepositoryImpl boardDetail Start");
		upHit(boardno);
		Board board = null;
		try {
			board = session.selectOne("lbhBoardDetail",boardno);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardDetail Exception -> " + e.getMessage());
		}
		return board;
	}
	private void upHit(int boardno) {
		System.out.println("BoardRepositoryImpl upHit Start");
		try {
			int result = session.update("lbhupHit",boardno);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl upHit Exception -> " + e.getMessage());
		}
	}
	
	//리뷰 등록
	//삭제할것
	@Override
	public int boardReply(Board board) {
		System.out.println("BoardRepositoryImpl boardReply Start");
		int result = 0;
		replyShape(board);
		try {
			System.out.println("board.getRef()->"+board.getRef());
			System.out.println("board.getRef_level()->"+board.getRef_level());
			System.out.println("board.getRef_step()->"+board.getRef_step());
			System.out.println("board.getBoardtitle()->"+board.getBoardtitle());
			if (board.getBoardtitle() == null) {
				System.out.println("board.getBoardtitle() is NULL");
			}
			result = session.insert("lbhReplyWrite",board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardReply Exception -> " + e.getMessage());
		}
		System.out.println("boardDao boardReply result->"+result);
		return result;
	}
	//댓글 대댓글 구분
	@Override
	public int replyShape(Board board) {
		System.out.println("BoardRepositoryImpl replyShape Start");
		int result = 0;
		try {
			result = session.update("lbhReplyShape", board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl replyShape Exception -> " + e.getMessage());
		}
		return result;
	}
	@Override
	public int boardUpdate(Board board) {
		System.out.println("BoardRepositoryImpl boardUpdate Start");
		int result = 0;
		try {
			System.out.println("boardno -> " + board.getBoardno());
			result = session.update("lbhboardUpdate", board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardUpdate Exception -> " + e.getMessage());
		}
		return result;
	}
	@Override
	public int boardDelete(Board board, Warning warning) {
		System.out.println("BoardRepositoryImpl boardDelete Start");
		int result = 0;
		int result3 = 0;
		int warnRowCnt = 0;
		try {
			result = session.delete("lbhboardDelete", board);
			System.out.println("warning boardno->"+warning.getBoardno());
			System.out.println("warning itemno->"+ warning.getItemno());
			warnRowCnt = session.selectOne("kjhWarnRowCntBoard", warning);
			System.out.println("BoardRepositoryImpl boardDelete result-->"+result);
			System.out.println("BoardRepositoryImpl boardDelete warnRowCnt-->"+warnRowCnt);
			// warning의 itemno가 유일하다는 전제에 수행
			if (result>0) {
				if (warnRowCnt>0) { //Warning 테이블에 삭제하려는  itemno또는 boardno가 있을 때만 WarningUpdate진행
					result3 = session.update("kshWarningUpadate", board.getBoardno());
					System.out.println("BoardRepositoryImpl boardDelete WarningUpdate result3-->"+result3);
					result = result3;
					}
				}	
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardDelete Exception -> " + e.getMessage());
		}
		return result;
		
		
	}
	@Override
	public List<Board> boardReplyList(int ref) {
		System.out.println("BoardRepositoryImpl boardReplyList Start");
		List<Board> boardReplyList = null;
		try {
			boardReplyList = session.selectList("lbhboardReplyList",ref);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardReplyList Exception -> " + e.getMessage());
		}
		return boardReplyList;
	}
	@Override
	public Board boardReplyOne(int boardno) {
		System.out.println("BoardRepositoryImpl boardReplyOne Start");
		Board board = null;
		try {
			board = session.selectOne("lbhReplyOne",boardno);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardReplyOne Exception -> " + e.getMessage());
		}
		return board;
	}
	@Override
	public int boardReplyCnt(int boardno) {
		System.out.println("BoardRepositoryImpl boardReplyCnt Start");
		int cnt = 0;
		try {
			cnt = session.selectOne("lbhboardReplycnt",boardno);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardReplyCnt Exception -> " + e.getMessage());
		}
		return cnt;
	}
	@Override
	public int boardReplyUpdate(Board board) {
		System.out.println("BoardRepositoryImpl boardReplyUpdate Start");
		int result = 0;
		try {
			result = session.update("lbhboardReplyUpdate",board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardReplyUpdate Exception -> " + e.getMessage());
		}
		return result;
	}
	@Override
	public int boardReplyDelete(Board board) {
		System.out.println("BoardRepositoryImpl boardReplyDelete Start");
		int result = 0;
		try {
			result = session.delete("lbhboardReplyDelete",board);
		}catch (Exception e) {
			System.out.println("BoardRepositoryImpl boardReplyDelete Exception -> " + e.getMessage());
		}
		return result;
	}
}
