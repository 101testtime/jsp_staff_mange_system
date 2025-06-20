package com.cn.Servert;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cn.dao.EmployeeDAO;
import com.cn.model.Employee;

/**
 * Servlet implementation class findAllServlet
 */
@WebServlet("/findAllServlet")
public class findAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO EmployeeDAO = new EmployeeDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Employee> all =EmployeeDAO.getAllEmployees();
			request.getSession().setAttribute("list", all);
			request.getRequestDispatcher("listall.jsp").forward(request,response);
		    //response.sendRedirect("listall.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
