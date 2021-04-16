package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.DetailsDao;
import com.web.model.Details;

/**
 * Servlet implementation class GetDetailsController
 */
public class GetDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		DetailsDao dao=new DetailsDao();
		Details d=dao.getDetails(id);
		request.setAttribute("details", d);
		RequestDispatcher rd=request.getRequestDispatcher("showDetails.jsp");
		rd.forward(request, response);
	}

}
