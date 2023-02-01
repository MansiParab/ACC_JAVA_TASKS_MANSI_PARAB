package com.accday17.joins.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private joinservicesimpl js;
	
	@GetMapping("/left")
	public List<custorderdto> getLeftJoin() {
		return (List<custorderdto>) (js.getLeftJoin());
	}

	@GetMapping("/right")
	public List<custorderdto> getRightJoin() {
		return (List<custorderdto>) (js.getRightJoin());
	}

	@GetMapping("/inner")
	public List<custorderdto> getInnerJoin() {
		return (List<custorderdto>) (js.getInnerJoin());
	}

	@GetMapping("/cross")
	public List<custorderdto> getCrossJoin() {
		return (List<custorderdto>) (js.getCrossJoin());
	}
}
