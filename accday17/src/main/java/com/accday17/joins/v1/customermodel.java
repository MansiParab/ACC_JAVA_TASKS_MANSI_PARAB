package com.accday17.joins.v1;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class customermodel {
	
	@Id
	@Column(name = "cid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cid;

	@Column(name = "cname")
	private String cname;

	@Column(name = "cphn")
	private String cphn;

	@Column(name = "cemail")
	private String cemail;

	@Column(name = "clocation")
	private String clocation;

	@OneToMany(targetEntity = ordermodel.class, mappedBy = "oid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ordermodel> orders;
	
//	@OneToOne
//	@JoinColumn(name="cid")
//	private ordermodel orders;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCphn() {
		return cphn;
	}

	public void setCphn(String cphn) {
		this.cphn = cphn;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getClocation() {
		return clocation;
	}

	public void setClocation(String clocation) {
		this.clocation = clocation;
	}

//	public Set<ordermodel> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<ordermodel> orders) {
//		this.orders = orders;
//	}
	
	
}
