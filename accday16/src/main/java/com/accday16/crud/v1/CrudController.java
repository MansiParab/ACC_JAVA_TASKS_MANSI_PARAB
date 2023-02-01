package com.accday16.crud.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {

	@Autowired
	private crudopservices cs;

	@PostMapping("/operations")
	public crudopmodel saveDetail(@RequestBody crudopmodel cp)
	{
		return cs.saveDetail(cp);
	}
	
	@GetMapping("/operations")
	public List<crudopmodel> fetchdetaillist()
	{
		return cs.fetchdetaillist();
	}
	
	@GetMapping("/operations/{id}")
	public Optional<crudopmodel> getonedetail(@PathVariable("id") Integer id) 
	{
		return cs.getonedetail(id);
	}

	@PutMapping("/operations/{id}")
	public crudopmodel updatedetail(@RequestBody crudopmodel cp1, @PathVariable("id") Integer id) 
	{
		return cs.updatedetail(cp1, id);
	}
	
	@DeleteMapping("/operations/{id}")
	public String deleterecord(@PathVariable("id") Integer id)
	{
		cs.deleterecord(id);
		return "Record Successfully Deleted";
	}
}
