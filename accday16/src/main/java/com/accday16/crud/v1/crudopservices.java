package com.accday16.crud.v1;

import java.util.List;
import java.util.Optional;

public interface crudopservices {
	
	crudopmodel saveDetail(crudopmodel detail);
	
	List<crudopmodel> fetchdetaillist();

	crudopmodel updatedetail(crudopmodel detail, Integer id);

	void deleterecord(Integer id);

	Optional<crudopmodel> getonedetail(Integer id);
}
