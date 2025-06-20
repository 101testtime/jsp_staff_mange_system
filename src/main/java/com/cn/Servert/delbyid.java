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
 * Servlet implementation class delbyid
 */
@WebServlet("/delbyid")
public class delbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO EmployeeDAO = new EmployeeDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	       String bh=request.getParameter("bh");
		   int sno=Integer.parseInt(bh);
	       boolean flag=false;
			try {
				flag=EmployeeDAO.deleteEmployee(sno);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flag)
			{
				request.getSession().setAttribute("info", "删除成功");
			}else
			{
				
				request.getSession().setAttribute("info","删除失败");
			}
			response.sendRedirect("success.jsp");
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
