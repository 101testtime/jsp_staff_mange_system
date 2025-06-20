package com.cn.Servert;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.EmployeeDAO;
import com.cn.model.Employee;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO EmployeeDAO = new EmployeeDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		boolean flag=false;
		int empno=Integer.parseInt(request.getParameter("empno"));
		String ename=request.getParameter("ename");
		String sex=request.getParameter("sex");
		System.out.print(ename);
		String job=request.getParameter("job");
		String hiredate=request.getParameter("hiredate");
		float sal=Float.parseFloat(request.getParameter("sal"));
		Employee emp=new Employee();
	    emp.setEmployeeId(empno);
	    emp.setEmployeeName(ename);
	    emp.setEmployeeSex(sex);
	    emp.setEmployeePosition(job);
	    emp.setEmployeeSalary(sal);
	    try{
	    emp.setEmployeeDate(new SimpleDateFormat("yyyy-MM-dd").parse(hiredate));
	    flag=EmployeeDAO.addEmployee(emp);	
	    }catch(Exception e)
	    {
	    	System.out.print(e.getMessage());
	    	
	    }
		if (flag)
		{
			request.getSession().setAttribute("info", "操作成功");
			
		}
		else
		{
			request.getSession().setAttribute("info","操作失败");			
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
