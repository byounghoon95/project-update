package com.example.projectupdate.pjh.service;

import java.util.List;

import com.example.projectupdate.entity.Item;
import com.example.projectupdate.entity.Reservation;


public interface ReservationService {
	int reservation(Reservation reser);
	Reservation reservationForm(int itemno);
	int total();
	
	List<Item> reserSelect(Item item);
	
	Reservation reservationDetail(int itemno);
	
	int reservationUpdate(Reservation reser);

	int reservationDelete(Reservation reser);

	int dealComment(Reservation reser);

	int dealCompl(Reservation reser);

	Reservation dealCommentDetail(int itemno);

	Reservation dealcs(int itemno);

	Reservation dealCommentGetDetail(int itemno);

	




}
