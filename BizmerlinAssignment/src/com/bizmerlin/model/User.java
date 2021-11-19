package com.bizmerlin.model;

public class User {

	public int StudentID;
	public String name;
	public String address;
	public String email;
	public String phoneNo;
	public String gender;
	public int departmentID;
	

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String address, String email, String phoneNo, String gender) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.departmentID=departmentID;
	}
	public User(int studentID, String name, String address, String email, String phoneNo, String gender, int departmentID) {
		super();
		StudentID = studentID;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.departmentID=departmentID;
	}
	public int getStudentID() {
		return StudentID;
	}
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		phoneNo = phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	
	
	
	
}
