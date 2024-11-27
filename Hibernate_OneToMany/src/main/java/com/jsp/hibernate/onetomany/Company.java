package com.jsp.hibernate.onetomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {

	@Id
	private int companyId;
	private String companyName;
	
	@OneToMany(mappedBy = "company")
	private List<Employee> employees;

	public int getCompanyId() {
		return companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
