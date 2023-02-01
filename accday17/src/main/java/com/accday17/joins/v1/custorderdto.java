package com.accday17.joins.v1;

public class custorderdto {
	
	private String cname;
	private String cphn;
	private String cemail;
	private String clocation;
	private String product;
	private String date;

	public custorderdto(String cname, String cphn, String cemail, String clocation, String product, String date) {
		super();
		this.cname = cname;
		this.cphn = cphn;
		this.cemail = cemail;
		this.clocation = clocation;
		this.product = product;
		this.date = date;
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "custorderdto [cname=" + cname + ", cphn=" + cphn + ", cemail=" + cemail + ", clocation=" + clocation
				+ ", product=" + product + ", date=" + date + "]";
	}
}
