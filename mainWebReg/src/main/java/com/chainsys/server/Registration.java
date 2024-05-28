package com.chainsys.server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbConnection.Crud;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
    Crud crud=new Crud();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Register regi=new Register();
		String name=request.getParameter("name");
		regi.setName(name);
		String email = request.getParameter("email");
		regi.setEmail(email);
		Long mobile = Long.parseLong(request.getParameter("mobile"));
		regi.setMobile(mobile);
		try {
			crud.insertRegister(regi);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", regi);
		ArrayList<Register> list = null;
		try {
			list = crud.getAllUsers();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list",list);
        request.getRequestDispatcher("Delete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("Delete")) {
					int id = Integer.parseInt(request.getParameter("deleteid"));
			try {
				crud.deleteUser(id);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ArrayList<Register> list = null;
			try {
				list= crud.getAllUsers();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("list",list);
	        request.getRequestDispatcher("Delete.jsp").forward(request, response);
			
		}
	}

}
