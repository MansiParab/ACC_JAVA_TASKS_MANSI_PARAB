package com.accday17.joins.v1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface orderrepo extends JpaRepository<ordermodel, Integer> {

	@Query("SELECT new com.accday17.joins.v1.custorderdto(c.cname,c.cphn,c.cemail,c.clocation,o.oproduct,o.odate) FROM customermodel c INNER JOIN ordermodel o ON c.cid=o.cust")
	List<custorderdto> InnerJoin();

	@Query("SELECT new com.accday17.joins.v1.custorderdto(c.cname,c.cphn,c.cemail,c.clocation,o.oproduct,o.odate) FROM customermodel c, ordermodel o")
	List<custorderdto> CrossJoin();
}
