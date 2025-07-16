package com.example.demo.EmployeeBean;

public class Employee {
	private String empName;
	private int empAge, empId;
	private double empExp;
	
	
	public Employee(String empName, int empAge, double empExp) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.empExp = empExp;
	}
	
	
	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getEmpExp() {
		return empExp;
	}
	public void setEmpExp(double empExp) {
		this.empExp = empExp;
	}


	public Employee() {
		super();
	}


	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empAge=" + empAge +  ", empExp=" + empExp + "]";
	}
	
	
	

}
