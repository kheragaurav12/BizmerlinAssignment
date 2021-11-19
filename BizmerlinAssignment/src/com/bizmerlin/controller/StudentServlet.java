package com.bizmerlin.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizmerlin.dao.DB;
import com.bizmerlin.model.User;

/**
 *
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private DB db ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
    	
    	this.db = new DB();
    	
       
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		this.doGet(request, response);
//		
//	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
		System.out.println(action);
		
		switch(action) {
		
		case"/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {
				System.out.println("Passing to Insert");
				insertUser(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteUser(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
		case "/update":
			try {
				updatestudents(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				
				listUser(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();			}
			
			
			break;
		}
		
	}

	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response )
	throws ServletException, IOException{
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("user-form.jp");
		dispatcher.forward(request, response);
		
	}
	
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response )
			throws  IOException, SQLException{
		System.out.println("Inserting Start");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email =request.getParameter("email");
		System.out.println("before");
		
		String phoneNo = request.getParameter("phoneNO");
		System.out.println("after");
		String gender = request.getParameter("gender");
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		
		User newUser= new User();
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setAddress(address);
		newUser.setPhoneNo(phoneNo);
		newUser.setGender(gender);
		newUser.setDepartmentID(departmentID);
		
		System.out.println(newUser);
		db.insertUser(newUser);
		
//		
		response.sendRedirect("user-list.jsp");
		
	}
	
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response )
			throws  IOException, SQLException{
		
		int studentID = Integer.parseInt(request.getParameter("studentID"));		
	
		db.deleteUser(studentID);
		
//		
		response.sendRedirect("user-list.jsp");
		
	}


	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws  IOException, SQLException, ServletException{
		
		int studentID = Integer.parseInt(request.getParameter("studentID"));	
		
		User existingUser = db.selectUser(studentID);
		System.out.println(existingUser.toString());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-user-form.jsp");
		request.setAttribute("User", existingUser);
		dispatcher.forward(request, response);
		
		
		
	}
	
	
	private void updatestudents(HttpServletRequest request, HttpServletResponse response )
			throws  IOException, SQLException{
		
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email =request.getParameter("email");
		String phoneNO = request.getParameter("phoneNO");
		String gender = request.getParameter("gender");
		
		User newUser= new User(name, address, email, phoneNO,gender);
		db.updatestudents(newUser);
		
//		
		response.sendRedirect("user-list.jsp");
	}
	
	
	private void listUser(HttpServletRequest request, HttpServletResponse response )
			throws  IOException, SQLException, ServletException{
		
		List<User> listUser = db.selectAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
			
}
}

