package com.accday17.joins.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class joinservicesimpl implements joinservices {

	@Autowired
	private custrepo c;
	@Autowired
	private orderrepo o;


	public List<custorderdto> getLeftJoin() {

		List<custorderdto> list = c.LeftJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}


	public List<custorderdto> getRightJoin() {

		List<custorderdto> list = c.RightJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	public List<custorderdto> getInnerJoin() {

		List<custorderdto> list = o.InnerJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	public List<custorderdto> getCrossJoin() {

		List<custorderdto> list = o.CrossJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

}
