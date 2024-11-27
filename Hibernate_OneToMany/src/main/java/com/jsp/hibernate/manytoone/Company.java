package com.jsp.hibernate.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	private int companyId;
	private String companyName;
	

	public int getCompanyId() {
		return companyId;
	}

	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
