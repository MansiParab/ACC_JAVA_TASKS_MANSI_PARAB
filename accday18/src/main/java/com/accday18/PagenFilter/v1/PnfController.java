package com.accday18.PagenFilter.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PnfController {

	@Autowired
	private PnfServiceImpl pfs;

	@GetMapping("/orders")
	public List<PnfModel> getalldetail() {
		return pfs.getalldetails();
	}

	@GetMapping("/orders/status")
	public List<PnfModel> getsomedetail(@RequestParam String status) {
		return pfs.getsomedetail(status);
	}
	
	@GetMapping("/orders/page")
	public Page<PnfModel> getdetails(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		return pfs.getdetail(pageNo, pageSize);
	}
}
