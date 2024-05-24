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
 * Servlet implementation class UpdateRegister
 */
@WebServlet("/UpdateRegister")
public class UpdateRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Register regi=new Register();
    Crud crud=new Crud();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		String email = request.getParameter("email");
		int mobile = Integer.parseInt(request.getParameter("mobile"));
		System.out.println(request.getParameter("editid"));
		int id = Integer.parseInt(request.getParameter("editid"));
		Register register=new Register();
		register.setName(name);
		register.setEmail(email);
		register.setMobile(mobile);
		register.setId(id);
		System.out.println(name);
		System.out.println(email);
		System.out.println(mobile);
		ArrayList<Register> list = null;
		try {
			crud.updateUser(register);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
