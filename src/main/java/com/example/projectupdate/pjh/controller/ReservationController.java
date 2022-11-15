package com.example.projectupdate.pjh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.projectupdate.entity.Item;
import com.example.projectupdate.entity.Member;
import com.example.projectupdate.entity.Reservation;
import com.example.projectupdate.pjh.service.ReservationService;

;

@Controller
public class ReservationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService rs;
	
	 @GetMapping("/reservationList")
	 public String reservationList(Reservation reser, String currentPage, Model model, Item item, HttpServletRequest request) {
		 System.out.println("ReservationController list Start..");
		 int total = rs.total();
		 System.out.println("ReservationController total - >"+ total);
		 
		// 세션에서 id 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		item.setSessionId(id);
		System.out.println("ReservationController reservationList id->"+id);
		 
		 List<Item> reserItemList = rs.reserSelect(item);
		 
		 
//		 for(Item rItem : reserItemList) {
//			 System.out.println("ReservationController rItem.getItemtitle()->"+ rItem.getItemtitle());
//			 System.out.println("ReservationController rItem.getContent()->"+ rItem.getContent());
//			 System.out.println("ReservationController rItem.getItemcost()->"+ rItem.getItemcost());
		 //asdfahsdfhsad
//		 }
		
		 System.out.println("ReservationController reservItemList.size()"+ reserItemList.size());
		 
		 model.addAttribute("reservationList", reserItemList);
		 
		 model.addAttribute("total",total);
		 
		 return "reservationList";
	 }

	@GetMapping("/reservationDetail")
	public String reservatoinDetail(int itemno, Model model) {
		System.out.println("ReservationController Detail Start");
		Reservation reserItem=null;
		reserItem = rs.reservationDetail(itemno);
		
		System.out.println("ReservationDetail itemno");
		model.addAttribute("reseritem", reserItem);
		
		return "reservationDetail";
	}
	
	@GetMapping("/reservationForm")
	public String ReservationForm(int itemno, Reservation reser, Model model) {
		System.out.println("ReservationController reservationForm Start...");
		reser = rs.reservationForm(reser.getItemno());
		model.addAttribute("reser", reser);
		System.out.println("ReservationForm itemno->"+ reser.getItemno());
		model.addAttribute("itemno", itemno);
		return "reservationForm";
	}
	
	//reservation등록
	@GetMapping("/reservation")
	public String Reservation(Reservation reser, Model model, HttpServletRequest request ) {
		System.out.println("Reservation 등록Start...");
		int itemno = reser.getItemno();			//getItemno를 
		/* reser.setItemno(itemno); */
		
		String id = (String) request.getSession().getAttribute("id");
		
	//	String id = "kanghj";
		reser.setSessionId(id);
		
		int result = rs.reservation(reser);
		model.addAttribute("result", result);
		model.addAttribute("itemno", itemno);
		
		System.out.println("itemno  "+ reser.getItemno());
		System.out.println("id  "+ reser.getId());
		System.out.println("Resdate  "+ reser.getResdate());
		System.out.println("Restime  "+ reser.getRestime());
		System.out.println("Resloc  "+ reser.getResloc());
		System.out.println("Dealcontent  "+ reser.getDealcontent());
		System.out.println("Score  "+ reser.getScore());
		System.out.println("Bcd  "+ reser.getBcd());
		System.out.println("Mcd  "+ reser.getMcd()) ;
		
		return "reservationPro";
		
		}
	//reservation 수정form 문
		@GetMapping(value="reservationUpdateForm")
		public String updateForm(Model model, Reservation reser) {
			System.out.println("ReservationController UpdateStart...");
			System.out.println("resr.getItemno() -> " + reser.getItemno());
			reser = rs.reservationDetail(reser.getItemno());
			model.addAttribute("reser", reser);
			
			return "reservationUpdateForm";
		}
		
	//reservation update	
		@PostMapping(value="reservationUpdate")
		public String boardUpdate(Reservation reser, Model model, HttpServletRequest request) {
			System.out.println("ReservationController UpdateStart...");
			
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			reser.setSessionId(id);
			
			int itemno = reser.getItemno();
			
			int result = rs.reservationUpdate(reser);
			model.addAttribute("result", result);
			model.addAttribute("itemno", itemno);
			System.out.println("Itemno->" +reser.getItemno());
			
			
			return "reservationUpdatePro";
		}
		@GetMapping(value="reservationDelete")
		public String reservationDelete(Reservation reser, Model model) {
			System.out.println("ReservationController reserDelete Start...");
			int result =rs.reservationDelete(reser);	
			
			
			model.addAttribute("result", result);
			
	
			return  "reservationDeletePro";
		}
	 
	
		//후기 update
		@GetMapping(value="dealCommentForm")
		public String dealCommentForm(Reservation reser, Model model, Item item,Member member ,HttpServletRequest request) {
			System.out.println("ReservationControlloer dealCommentForm Start..");
			String id = null;
			String nickname = null;
			Reservation dealcommentsend=null;
			
			int itemno = item.getItemno();
			dealcommentsend = rs.dealcs(itemno);
			
			HttpSession session = request.getSession();
			id = (String) session.getAttribute("id");
			
			nickname = (String) session.getAttribute("nickname");
			reser.setId(id);
			reser.setNickname(nickname);
			
			model.addAttribute("dealcommentsend", dealcommentsend);
			model.addAttribute("itemno", itemno);
			model.addAttribute("reser", reser);
			model.addAttribute("item", item);
			
			System.out.println("ReservationController dealComment itemno  "+ reser.getItemno());
			System.out.println("id  "+ reser.getId());

			
			return "dealCommentForm";
		}
		@PostMapping(value="dealComment")
		public String dealCommernt(Reservation reser, Model model, HttpServletRequest request) {
			System.out.println("ReservationController dealComment Start...");
			
			
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			reser.setSessionId(id);
			
			int smcd = reser.getSmcd();
			int itemno = reser.getItemno();
			int score = reser.getScore();
			
			reser.setScore(score);
			reser.setSmcd(smcd);
			
			int result = rs.dealComment(reser);
			
			model.addAttribute("result", result);
			model.addAttribute("itemno", itemno);
			
			System.out.println("deal");
			System.out.println("Itemno->" +reser.getItemno());
			
			return "forward:dealCommentDetail";
		}
		
		@PostMapping("/dealCommentDetail") 
		public String dealCommentDetail (int itemno, Model model) {
			System.out.println("ReservationController dealCommentDetail Start");
			Reservation reseritem= null;
			reseritem = rs.dealCommentDetail(itemno);
			model.addAttribute("reseritem", reseritem);
			System.out.println("dealCommentDetail itemno" + itemno);
			return "dealCommentDetail";
		}
		
		@GetMapping("/dealCommentGetDetail") 
		public String dealCommentGetDetail (int itemno, Model model) {
			System.out.println("ReservationController dealCommentGetDetail Start");
			Reservation reseritem= null;
			
			reseritem = rs.dealCommentGetDetail(itemno);
			model.addAttribute("reseritem", reseritem);
			System.out.println("dealCommentGetDetail itemno->" + itemno);
			
			return "dealCommentGetDetail";
		}
		
		
		//거래완료 update
		@GetMapping(value="dealCompl")
		public String dealCompl(Reservation reser, Model model) {
			System.out.println("ReservationController dealCompl Start...");
			int result = rs.dealCompl(reser);
			model.addAttribute("result", result);
			
			return "forward:reservationList";
		}
		

}

