package com.accday18.PagenFilter.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PnfServiceImpl implements PnfService {

	@Autowired
	private PnfRepo pf;

	@Override
	public List<PnfModel> getalldetails() {
		return (List<PnfModel>) pf.findAll();
	}

	@Override
	public List<PnfModel> getsomedetail(String s) {
		return pf.findByStatus(s);
	}

	@Override
	public Page<PnfModel> getdetail(Integer pageNo, Integer pageSize) {
		Pageable p = PageRequest.of(pageNo, pageSize);
		return pf.findAll(p);
	}

}
