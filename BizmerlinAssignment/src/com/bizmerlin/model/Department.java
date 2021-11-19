package com.bizmerlin.model;

public class Department {
	
	public int departmentID;
	public String name;
	public String description;
	
	
	
	
	
	public Department(int departmentID, String name, String description) {
		super();
		this.departmentID = departmentID;
		this.name = name;
		this.description = description;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
