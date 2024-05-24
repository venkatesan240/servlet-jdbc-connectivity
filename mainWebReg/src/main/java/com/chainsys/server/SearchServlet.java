package com.chainsys.server;

import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbConnection.Crud;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
    private Crud crud = new Crud(); // Assuming you have a Crud class for database operations

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
//		  String query = request.getParameter("query"); List<Register> result = null;
//		  try { result = crud.search(query); } catch (ClassNotFoundException |
//		  SQLException e) { e.printStackTrace(); // Optionally, set an error message in
//		  request.setAttribute("error", "An error occurred while processing your search request."); }
//		  request.setAttribute("results", result); RequestDispatcher dispatcher =
//		  request.getRequestDispatcher("Delete.jsp"); dispatcher.forward(request,
//		  response);
		 
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Crud crud = new Crud();
            ArrayList<Register> formDataList = null;
			try {
				formDataList = crud.search(name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            request.setAttribute("allFormDataList", formDataList);
        request.getRequestDispatcher("table.jsp").forward(request, response);
    }

}
