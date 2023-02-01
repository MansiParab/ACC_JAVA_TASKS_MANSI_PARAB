package com.accday17.joins.v1;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class ordermodel {

	@Id
	@Column(name = "oid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oid;

	@Column(name = "oproduct")
	private String oproduct;
	
	@Column(name = "odate")
	private String odate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private customermodel cust;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "cid")
//	private customermodel cust;

	public Integer getId() {
		return oid;
	}

	public void setId(Integer id) {
		this.oid = id;
	}

	public String getProduct() {
		return oproduct;
	}

	public void setProduct(String product) {
		this.oproduct = product;
	}

	public String getDate() {
		return odate;
	}

	public void setDate(String date) {
		this.odate = date;
	}

	public customermodel getCust() {
		return cust;
	}

	public void setCust(customermodel cust) {
		this.cust = cust;
	}
//	private Integer cid;

}
