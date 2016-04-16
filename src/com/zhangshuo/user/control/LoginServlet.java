package com.zhangshuo.user.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录业务逻辑类
 * 判断用户登录
 * 
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String loginName= request.getParameter("loginName");
		//request.getSession().setAttribute("userName", loginName);
		String loginPass = request.getParameter("loginPwd");
		if ("swj".equals(loginName) && "123".equals(loginPass)) {
			response.sendRedirect("loginSuccess.jsp");			
		}else {
			response.sendRedirect("loginFail.jsp");			
			
		}
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
