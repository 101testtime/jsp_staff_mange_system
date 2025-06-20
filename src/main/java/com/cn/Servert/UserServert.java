package com.cn.Servert;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cn.dao.UserDAO;
import com.cn.model.User;
/**
 * Servlet implementation class UserServert
 */
@WebServlet("/UserServert")
public class UserServert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 UserDAO UserDAO = new UserDAO(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userName = request.getParameter("user");
	     String userPwd = request.getParameter("password");

	        // 校验用户名和密码是否为空
	        if (userName == null || userName.isEmpty() || userPwd == null || userPwd.isEmpty()) {
	        	request.setAttribute("error", "用户名或密码不能为空！");
	        	request.getRequestDispatcher("Login.jsp").forward(request, response);
	            return;
	        }

	        User user = new User();
	        user.setUserName(userName);
	        user.setUserPwd(userPwd);

	        // 验证用户名和密码是否正确
	        User validUser = UserDAO.login(user);
	        if (validUser != null) {
	         
	        	request.getRequestDispatcher("welcome.jsp").forward(request, response);
	        } else {
	            // 登录失败，返回错误信息
	        	request.setAttribute("error", "账号或密码错误！");
	        	request.getRequestDispatcher("Login.jsp").forward(request, response);
	        }
	}

}
