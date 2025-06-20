package com.cn.Servert;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.EmployeeDAO;
import com.cn.model.Employee;

/**
 * Servlet implementation class findbyname
 */
@WebServlet("/findbyname")
public class findbyname extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO EmployeeDAO = new EmployeeDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findbyname() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bh=request.getParameter("bh");
		
			try {
				Employee emp=EmployeeDAO.getEmployeeByName(bh);
	        if (emp!=null)
	        {
	         request.getSession().setAttribute("emp", emp) ;
	        }else
	        {
	        request.getSession().setAttribute("error", "查无此人");	
	        }
	        response.sendRedirect("findbyname.jsp");
	        	
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
