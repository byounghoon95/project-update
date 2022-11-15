package com.example.projectupdate.ksh.service;




import java.util.List;

import com.example.projectupdate.entity.Warning;

public interface A_WarningService {

	int total();

	List<Warning> listWarning(Warning warning);

	Warning detail(int warno);

	/* Warning warnCatNameSelect(Warning warning); */

	int wsupdate(Warning warning);

	



}
