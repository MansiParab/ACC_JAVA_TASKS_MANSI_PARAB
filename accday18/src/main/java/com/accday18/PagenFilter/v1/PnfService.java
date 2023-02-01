package com.accday18.PagenFilter.v1;

import java.util.List;

import org.springframework.data.domain.Page;

public interface PnfService {

	List<PnfModel> getalldetails();

	List<PnfModel> getsomedetail(String s);

	Page<PnfModel> getdetail(Integer pageNo, Integer pageSize);


}
