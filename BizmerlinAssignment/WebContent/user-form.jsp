<%@page import="com.bizmerlin.model.User"%>
<%@page import="com.bizmerlin.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.bizmerlin.dao.DB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-primary"
			>
			<div>
				<a class="navbar-brand text-light"> BizmerlinAssignment </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="user-list.jsp"	
					class="nav-link">Students</a></li>
			</ul>
		</nav>
	</header>
	
	<br>
	<br>
	
	
	<div class="container">
	<form action="insert" method ="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="name">Name</label>
      <input type="text" class="form-control" name="name" id="name" placeholder="Enter Name">
    </div>
    <div class="form-group col-md-6">
      <label for="address">Address</label>
      <input type="text" class="form-control" name="address" id="address" placeholder="Enter Address">
    </div>
  </div>
  <div class="form-group">
    <label for="phoneNO">Phone Number</label>
    <input type="tel" class="form-control" name="phoneNo" id="phoneNo" placeholder="Enter Phone Number">
  </div>
  <div class="form-group">
    <label for="gender">Gender</label>
    <input type="text" class="form-control" name="gender" id="gender" placeholder="Gender">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="email">Email</label>
      <input type="email" class="form-control" name="email" id="email" placeholder="Enter Email">
    </div>
    <div class="form-group col-md-4">
      <label for="departments">Choose a Department</label>
      <select name="departmentID" id="departmentID" class="form-control">
      
      <%
			DB db = new DB();
			List<Department> departments = db.selectAllDepartments();
			
			for(Department department: departments){
				
		%>
        <option value="<%= department.departmentID%>">
		 	<%= department.name%>
		 </option>
		 
		 <%		
			}
		%>
		 
		 
      </select>
      
    </div>
 
 
 
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>	
	

	
	
	
	
	
	
</body>
</html>