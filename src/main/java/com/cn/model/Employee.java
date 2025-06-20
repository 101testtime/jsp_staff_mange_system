package com.cn.model;

import java.util.Date;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String employeeSex;
    private Date employeeDate;
    private double employeeSalary;
    private String employeePosition;
    
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}
	public Date getEmployeeDate() {
		return employeeDate;
	}
	public void setEmployeeDate(Date employeeDate) {
		this.employeeDate = employeeDate;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeePosition() {
		return employeePosition;
	}
	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

    // Getter 和 Setter
}
