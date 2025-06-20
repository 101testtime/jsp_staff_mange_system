package com.cn.Servert;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.UserDAO;
import com.cn.model.User;

/**
 * Servlet implementation class Userregister
 */
@WebServlet("/Userregister")
public class Userregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO UserDAO = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userregister() {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}

		String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");

//        // 输入验证
//        if (userName == null || userName.isEmpty() || userPwd == null || userPwd.isEmpty()) {
//            req.setAttribute("error", "用户名或密码不能为空！");
//            req.getRequestDispatcher("register.jsp").forward(req, resp);
//            return;
//        }

        User user = new User();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        if (UserDAO.register(user)) {
            resp.sendRedirect("Login.jsp");
        } else {
            req.setAttribute("error", "注册失败！");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }

}
