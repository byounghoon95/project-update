package com.example.projectupdate.lbh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.projectupdate.entity.Board;
import com.example.projectupdate.entity.Member;
import com.example.projectupdate.entity.Warning;
import com.example.projectupdate.lbh.service.BoardService;
import com.example.projectupdate.lbh.service.Paging;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	

	// Board 전체 리스트 불러오기
	   @GetMapping("/board")
	   public String board(Board board,String currentPage, Model model, HttpServletRequest request, Member member) {
	      System.out.println("BoardController board Start...");
	      
	      // 세션에서 id 가져오기
	      HttpSession session = request.getSession();
	      String id = (String) session.getAttribute("id");
	      session.setAttribute("id", id);
	      model.addAttribute("id", id);
	      
	      
	      int total = bs.total(board); /* ()에서 (board) 추가함 */
	      System.out.println("BoardController total ->" +total);
	      Paging pg = new Paging(total, currentPage);
	      board.setStart(pg.getStart());
	      board.setEnd(pg.getEnd());
	      List<Board> boardList = bs.boardSelect(board);
	      System.out.println("BoardController board boardList.size()->"+boardList.size());
	      
	      int replycnt = bs.boardReplyCnt(board.getRef());
	      
	      model.addAttribute("replycnt ", replycnt );
	      model.addAttribute("boardList", boardList);
	      model.addAttribute("bdkeyword", board.getBdkeyword());   /* <- 창현 추가(게시물검색) */
	      model.addAttribute("pg", pg);
	      model.addAttribute("total", total);
	      return "board";
	   }
	// 글 작성하기 클릭 후 새글 작성 페이지로 이동
	@GetMapping("/boardWriteForm")
	public String boardWriteForm(String id, Model model, HttpServletRequest request) {
		System.out.println("BoardController boardWriteForm Start...");
//		model.addAttribute("id",id); id 넘길 것으로 예상
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		id = (String) session.getAttribute("id");
		System.out.println("BoardController boardWriteForm id->"+id);
		model.addAttribute("id",id); 
		
		return "boardWriteForm";
	}
	// 글 등록 후 board 페이지로 전환
	@GetMapping("/boardWrite")
	public String boardWrite(Board board, Model model, HttpServletRequest request) {
		System.out.println("BoardController boardWrite Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		board.setSessionId(id);
		System.out.println("BoardController boardWrite id->"+id);
		
		int result = bs.boardWrite(board);
		model.addAttribute("result",result);
		return "boardWritePro";
	}
	@GetMapping("/boardDetail")
	public String boardDetail(int boardno, Model model) {
		System.out.println("BoardController boardDetail Start...");
		List<Board> boardReplyList = null;
		int replycnt = bs.boardReplyCnt(boardno);
		Board board = bs.boardDetail(boardno);
		boardReplyList = bs.boardReplyList(board.getRef());
		model.addAttribute("boardReplyList",boardReplyList);
		model.addAttribute("board",board);
		model.addAttribute("replycnt",replycnt);
		return "boardDetail";
	}
	
	@GetMapping(value="boardUpdateForm")
	public String updateForm(Model model, Board board) {
		System.out.println("BoardController updateForm Start...");
		System.out.println("board.getBoardno() -> " + board.getBoardno());
		board = bs.boardDetail(board.getBoardno());
		model.addAttribute("board",board);

		return "boardUpdateForm";
	}
	//게시판 상세 수정
	@PostMapping(value="boardUpdate")
	public String boardUpdate(Board board, Model model) {
		System.out.println("BoardController boardUpdate Start...");
		int result = bs.boardUpdate(board);
		model.addAttribute("result", result);
		return "boardUpdatePro";
	}
	//게시판 상세 삭제
	@GetMapping(value="boardDelete")
	public String boardDelete(Board board,Warning warning, Model model) {
		System.out.println("BoardController boardUpdate Start...");
		int result = bs.boardDelete(board, warning);
		model.addAttribute("result", result);
		return "boardDeletePro";
	}
	//리뷰
	@GetMapping("/reply")
	public String reply(Board board, Model model, String comment, HttpServletRequest request) {
		System.out.println("BoardController reply Start...");
		
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		board.setSessionId(id);
		System.out.println("BoardController reply id->"+id);
		
		board.setBoardcontent(comment);
		int result = bs.boardReply(board);
		model.addAttribute("result",result);
		model.addAttribute("board",board);
		return "boardReplyPro";
	}
	//리뷰 수정
//	@GetMapping("/replyUpdate")
//	public String replyUpdate(Board board, Model model, String comment) {
//		System.out.println("BoardController replyUpdate Start...");
//		
//		board.setBoardcontent(comment);
//		int result = bs.boardReply(board);
//		model.addAttribute("result",result);
//		model.addAttribute("board",board);
//		return "boardReplyPro";
//	}
	// 대댓글
	@GetMapping("/rereply")
	public String rereply(int boardno, Model model, String comment) {
		System.out.println("BoardController rereply Start...");
		Board board = bs.boardReplyOne(boardno);
		int before_boardno = board.getRef();
		board.setBoardcontent(comment);
		int result = bs.boardReply(board);
		model.addAttribute("board",before_boardno);
		model.addAttribute("result",result);
		return "boardReReplyPro";
	}
	@PostMapping("/replyUpdate")
	@ResponseBody
	public int replyUpdate(Board board, Model model) {
		System.out.println("BoardController replyUpdate Start...");
		System.out.println("boardno -> " + board.getBoardno());
		System.out.println("boardcontent ->" + board.getBoardcontent());
		int result = bs.boardReplyUpdate(board);
		
		return result;
	}
	@PostMapping("/replydelete")
	@ResponseBody
	public int replydelete(Board board, Model model) {
		System.out.println("BoardController replydelete Start...");
		System.out.println("boardno -> " + board.getBoardno());
		int result = bs.boardReplyDelete(board);
		
		return result;
	}
	
	// 승혜
	//관리자 게시판디테일
	@GetMapping("/A_BoardDetail")
	public String A_BoardDetail(int boardno,int warno, Model model) {
		System.out.println("BoardController boardDetail Start...");
		List<Board> boardReplyList = null;
		Board board = bs.boardDetail(boardno);
		boardReplyList = bs.boardReplyList(board.getRef());
		model.addAttribute("boardReplyList",boardReplyList);
		model.addAttribute("board",board);
		model.addAttribute("warno",warno);
		return "A_BoardDetail";
	}
	
	//관리자게시글삭제
	@GetMapping(value="A_BoardDeletePro")
	public String A_BoardDeletePro(Board board,Warning warning, int warno ,  Model model) {
		System.out.println("BoardController A_BoardDeletePro Start...");
		System.out.println("BoardController A_BoardDeletePro warno->"+warno);
		int delStatus = bs.boardDelete(board,warning);
		model.addAttribute("delStatus", delStatus);

		return "redirect:adminWarList";
	}
	
}