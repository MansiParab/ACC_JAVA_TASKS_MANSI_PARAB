package com.accday16.crud.v1;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class crudopservicesimpl implements crudopservices {

	@Autowired
	private crudoprepo r;
	
	@Override
	public crudopmodel saveDetail(crudopmodel detail) {
		// TODO Auto-generated method stub
		return r.save(detail);
	}

	@Override
	public List<crudopmodel> fetchdetaillist() {
		// TODO Auto-generated method stub
		return (List<crudopmodel>) r.findAll();
	}

	@Override
	public crudopmodel updatedetail(crudopmodel detail, Integer id) {
		// TODO Auto-generated method stub
		crudopmodel c = r.findById(id).get();
		
		if(Objects.nonNull(detail.getName())&&!"".equalsIgnoreCase(detail.getName())) 
		{
			c.setName(detail.getName());
		}

		if (Objects.nonNull(detail.getLocation()) && !"".equalsIgnoreCase(detail.getLocation())) {
			c.setLocation(detail.getLocation());
		}

		return r.save(c);
	}

	@Override
	public void deleterecord(Integer id) {
		// TODO Auto-generated method stub
		r.deleteById(id);
	}

	@Override
	public Optional<crudopmodel> getonedetail(Integer id) {
		// TODO Auto-generated method stub
		return r.findById(id);
	}

}
