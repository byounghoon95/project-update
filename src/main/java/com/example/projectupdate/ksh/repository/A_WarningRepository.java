package com.example.projectupdate.ksh.repository;

import java.util.List;

import com.example.projectupdate.entity.Warning;

public interface A_WarningRepository {

	int total();

	List<Warning> listWarning(Warning warning);

	Warning detail(int warno);

	/* Warning warnCatNameSelect(Warning warning); */

	int wsupdate(Warning warning);

}
