package net.roseindia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

/**
 * @author Deepak Kumar Web: http://www.roseindia.net
 * https://www.roseindia.net/hibernate/hibernate4.3/Hibernate-4-hello-world-example.shtml
 */
public class EmployeeShrunk implements Serializable {

 
	private int id;

 	private String empName;

	private String empAddress;

	private String empMobileNos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpMobileNos() {
		return empMobileNos;
	}

	public void setEmpMobileNos(String empMobileNos) {
		this.empMobileNos = empMobileNos;
	}

}