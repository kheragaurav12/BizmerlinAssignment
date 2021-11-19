package com.bizmerlin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bizmerlin.model.Department;
import com.bizmerlin.model.User;

public class DB {
	
	private String URL="jdbc:mysql://localhost/bizmerlin?useSSL=false";
	private String Username ="root";
	private String password="gaurav786";
	
	private static final String INSERT_STUDENTS_SQL=" INSERT INTO students (name, address, phoneNo, emailID, gender, departmentID) VALUES (?, ?, ?, ?, ?, ?);";
	
	private static final String SELECT_STUDENTS_BY_ID="select * from students where studentID=?";
	private static final String SELECT_ALL_STUDENTS ="select * from students";
	private static final String DELETE_STUDENTS_SQL= "delete from students where studentID=?";
	private static final String UPDATE_STUDENTS_SQL="update students set name=?, address=?, emailID=?, PhoneNO=?, gender=? where id=?";
	private static final String STUDENT_DEPARTMENTS ="select * from department";
	
	protected Connection getconnection() {
		
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(URL, Username, password);
			System.out.println("Connection Created");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connection;
	}


	//INSERT_METHOD
	// In this method we take User as inpput and save the data using JDBC
	public void insertUser(User User) throws SQLException{
		
		
		try(Connection connection = getconnection())
		{
			PreparedStatement PreparedStatement= connection.prepareStatement(INSERT_STUDENTS_SQL);
			PreparedStatement.setString(1, User.getName());
			PreparedStatement.setString(2, User.getAddress());
			PreparedStatement.setString(4, User.getEmail());
			PreparedStatement.setString(3, User.getPhoneNo());
			PreparedStatement.setString(5, User.getGender());	
			PreparedStatement.setInt(6, User.getDepartmentID());
			PreparedStatement.execute();
		}catch (Exception e) {

			e.printStackTrace();
		
		}
	
	
		}
	
	//UPDATE_STUDENTS
	
	public boolean updatestudents(User User) throws SQLException{
		boolean rowUpdated;
		
		try(Connection connection = getconnection();
				PreparedStatement statement= connection.prepareStatement(UPDATE_STUDENTS_SQL);){
			
			statement.setString(1, User.getName());
			statement.setString(2, User.getAddress());
			statement.setString(3, User.getEmail());
			statement.setString(4, User.getPhoneNo());
			statement.setString(5, User.getGender());	
			rowUpdated=statement.executeUpdate()>0;
					
					
	}
			return rowUpdated;
	
}

	//SelectStudents_BY_ID
	public User selectUser(int StudentID) {
		User User = null;
		try(Connection connection = getconnection();
				// create statement using connection object
				PreparedStatement preparedStatement= connection.prepareStatement(SELECT_STUDENTS_BY_ID);) {
			preparedStatement.setInt(1, StudentID);
			System.out.println(preparedStatement);
			
			//execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// process the ResultSet object
			while(rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String email = rs.getString("emailID");
				String phoneNO = rs.getString("phoneNo");
				String gender = rs.getString("gender");
				int departmentID = rs.getInt("departmentID");
				User = new User(StudentID, name, address, email, phoneNO, gender, departmentID);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return User;
	}
	
	
	//Select ALL Students
	public List<User> selectAllUser() {
		System.out.println("Fetching Students");
		List<User> users = new ArrayList<User>();
		try {
			Connection connection = getconnection();
			PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_STUDENTS);
			System.out.println(preparedStatement);
			
			//execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// process the ResultSet object
			while(rs.next()) {
				int studentID = rs.getInt("studentID");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String email = rs.getString("emailID");
				String phoneNO = rs.getString("phoneNo");
				String gender = rs.getString("gender");
				int departmentID = rs.getInt("departmentID");
				
				User user = new User(studentID, name, address, email, phoneNO, gender, departmentID );
				System.out.println(user);
				users.add(user);		
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
	}
	
	// Delete User
	
	public boolean deleteUser(int StudentID) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getconnection();
				
				// create statement using connection object
				PreparedStatement statement= connection.prepareStatement(DELETE_STUDENTS_SQL);) {
				statement.setInt(1, StudentID);
			
			rowDeleted=statement.executeUpdate()>0;
		}
	
		return rowDeleted;
	}
	
	//STUDENT_DEPARTMENTS
	public List<Department> selectAllDepartments() {
		List<Department> departments = new ArrayList<Department>();
		try {
				Connection connection = getconnection();
				
				// create statement using connection object
				PreparedStatement preparedStatement= connection.prepareStatement(STUDENT_DEPARTMENTS); 
			System.out.println(preparedStatement);
			
			//execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int departmentID = rs.getInt("departmentID");
				String name = rs.getString("name");
				String description = rs.getString("description");
				
				Department department = new Department(departmentID, name, description);
				departments.add(department);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return departments;
	}
	
}