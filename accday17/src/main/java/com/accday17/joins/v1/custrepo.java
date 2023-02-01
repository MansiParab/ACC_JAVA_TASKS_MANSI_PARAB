package com.accday17.joins.v1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface custrepo extends JpaRepository<customermodel, Integer> {

//	@Query(value = "SELECT * FROM customer", nativeQuery = true)
//	List<customermodel> LeftJoin();
//	@Query("SELECT new com.accday17.joins.v1.custorderdto(c.cname,c.cphn)" + "FROM customermodel c")
//	List<custorderdto> LeftJoin();

	@Query("SELECT new com.accday17.joins.v1.custorderdto(c.cname,c.cphn,c.cemail,c.clocation,o.oproduct,o.odate) FROM customermodel c LEFT JOIN ordermodel o ON c.cid=o.cust")
	List<custorderdto> LeftJoin();

	@Query("SELECT new com.accday17.joins.v1.custorderdto(c.cname,c.cphn,c.cemail,c.clocation,o.oproduct,o.odate) FROM customermodel c RIGHT JOIN ordermodel o ON c.cid=o.cust")
	List<custorderdto> RightJoin();
}
