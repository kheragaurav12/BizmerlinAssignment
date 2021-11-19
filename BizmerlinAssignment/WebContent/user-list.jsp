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
				<a href="<%=request.getContextPath()%>/user-list.jsp" class="navbar-brand text-light"> BizmerlinAssignment </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/user-form.jsp"
					class="nav-link">Students</a></li>
			</ul>
		</nav>
	</header>
	
	<br>
	<br>
	
<div class ="container">
<table class="table">
  <thead>
    <tr>
      <th scope="col">DepartmentID</th>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      
    </tr>
  </thead>
  <tbody>
    
    
       <%
			DB db = new DB();
			List<Department> departments = db.selectAllDepartments();
			
			for(Department department: departments) {
				
		%>
		
		<tr>
      		<td> <%= department.departmentID %> </td>
           <td> <%= department.name %> </td>
           <td> <%= department.description %> </td>
          
    	</tr>
    	<% } %>
  </tbody>
</table>

</div>

<br>
<br>

<div class ="container">
<table class="table">
  <thead>
    <tr>
      <th scope="col">StudentID</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">PhoneNo</th>
      <th scope="col">Email</th>
      <th scope="col">Gender</th>
      <th scope="col">Department Id</th>
	<th scope="col">EDIT</th>      
	<th scope="col">DELETE Id</th>
      
    </tr>
  </thead>
  <tbody>
    
    <%
		List<User> users = db.selectAllUser();
		for(User user: users) { 
	%>
    
    	<tr>
      		<td> <%= user.getStudentID() %> </td>
           <td> <%= user.getName() %> </td>
           <td> <%= user.getAddress() %> </td>
          <td> <%= user.getPhoneNo() %> </td>
          <td> <%= user.getEmail() %> </td>
          <td> <%= user.getGender() %> </td>
          <td> <%= user.getDepartmentID() %> </td>
          <td> <a href="<%=request.getContextPath()%>/edit?studentID=<%= user.getStudentID()%>">EDIT</a>
          <td> <a href="<%=request.getContextPath()%>/delete?studentID=<%= user.getStudentID()%>">DELETE</a>
    	</tr>
    	
    	<% } %>
    
  </tbody>
</table>

</div>


</body>
</html>