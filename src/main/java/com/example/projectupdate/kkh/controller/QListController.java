package com.example.projectupdate.kkh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.projectupdate.entity.QList;
import com.example.projectupdate.kkh.service.Paging;
import com.example.projectupdate.kkh.service.QListService;

@Controller
public class QListController {

	@Autowired
	private QListService qs;
	
	@GetMapping("/footer_qlist")
	public String footer_qlist(QList qlist, String currentPage, Model model) {
		System.out.println("QListController qlist start");
		int total = qs.total();
		System.out.println("QListController total ->"+total);
		Paging pg = new Paging(total, currentPage);
		qlist.setStart(pg.getStart());
		qlist.setEnd(pg.getEnd());
		List<QList> qlistList = qs.qlistSelect(qlist);
		System.out.println("QListController qlit qlitList.size()->"+qlistList.size());
		
		model.addAttribute("qlistList", qlistList);
		model.addAttribute("pg", pg);
		model.addAttribute("total", total);
		return "footer_qlist";
		
	}
	@GetMapping("/footer_qlistDetail")
	public String footer_qlistDetail(int boardno, Model model) {
		System.out.println("QListController qlistDetail Start");
		QList qlist = null;
		qlist = qs.qlistDetail(boardno);
		model.addAttribute("qlist", qlist);
		return "footer_qlistDetail";
	}


}
