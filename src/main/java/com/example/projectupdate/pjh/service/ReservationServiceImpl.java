package com.example.projectupdate.pjh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectupdate.entity.Item;
import com.example.projectupdate.entity.Reservation;
import com.example.projectupdate.pjh.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private final ReservationRepository reservationRepository;
	@Autowired
	public ReservationServiceImpl(ReservationRepository reservationRepository) {
		this.reservationRepository  = reservationRepository;
	}
	//insert
	@Override
	public int reservation(Reservation reser) {
		int result =0;
		System.out.println("ReservationServiceImpl Start..");
		result = reservationRepository.reservation(reser);
		
		return result;
	}
	@Override
	public Reservation reservationForm(int itemno) {
		System.out.println("ReservationServiceImpl reservationForm");
		Reservation reserItem = null ;
		reserItem = reservationRepository.reservationForm(itemno);
		return reserItem;
	}
	
	@Override
	public int total() {
		int total = 0;
		System.out.println("ReservationServiceImpl total start..");
		total = reservationRepository.total();
		
		return total;
	}

	@Override
	public List<Item> reserSelect(Item item) {
		System.out.println("ReservationServiceImpl reservItemList");
		List<Item> reserItemList = null;
		reserItemList = reservationRepository.reserItemSelect(item);
		return reserItemList;
	}
	@Override
	public Reservation reservationDetail(int itemno) {
		System.out.println("ReservationServiceImpl reservationDetail");
		Reservation reserItem = null ;
		reserItem = reservationRepository.reservationDetail(itemno);
		return reserItem;
	}
	@Override
	public int reservationUpdate(Reservation reser) {
		System.out.println("ReservationServiceImpl reservationUpdate");
		int result =0;
		result = reservationRepository.reservationUpdate(reser);
		return result;
	}
	@Override
	public int reservationDelete(Reservation reser) {
		System.out.println("ReservationServiceImpl reservationDelet Start");
		int result =0;
		result = reservationRepository.reservationDelete(reser);
		
		return result;
	}
	@Override
	public int dealComment(Reservation reser) {
		System.out.println("ReservationServiceImpl dealComment Start");
		int result =0;
		result = reservationRepository.dealComment(reser);
		return result;
	}
	@Override
	public int dealCompl(Reservation reser) {
		System.out.println("ReservationServiceImpl dealCompl Start");
		int result = 0;
		result = reservationRepository.dealCompl(reser);
		
		return result;
	}
	@Override
	public Reservation dealCommentDetail(int itemno) {
		System.out.println("ReservationServiceImpl dealCommentDetail start");
		Reservation reserItem = null ;
		reserItem = reservationRepository.dealCommentDetail(itemno);
		return reserItem;
	
	}
	@Override
	public Reservation dealcs(int itemno) {
		System.out.println("ReservationServiceImpl dealcs start");
		Reservation dealcommentsend = null;
		dealcommentsend = reservationRepository.dealcs(itemno);

		return dealcommentsend;
	}
	@Override
	public Reservation dealCommentGetDetail(int itemno) {
		System.out.println("ReservationServiveImpl dealCommentGetDetail start...");
		Reservation reserItem =null;
		reserItem = reservationRepository.dealCommentGetDetail(itemno);
		return reserItem;
	}



}
