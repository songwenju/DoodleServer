package com.zhangshuo.user.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangshuo.user.dao.UserDao;
import com.zhangshuo.user.dao.impls.UserImpls;
import com.zhangshuo.user.domain.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String userName= request.getParameter("userName");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setUserName(userName);
		user.setUserEmail(email);
		user.setPassword(pwd);
		System.out.println(user.toString());
		UserDao userDao = new UserImpls();
		int result = userDao.add(user);
		if (result > 0) {
			MailSent mailSent = new MailSent();
			mailSent.sendRegistMail(email, userName);
			System.out.println("数据保存成功");
		}else {
			System.out.println("数据保存失败");
		}
	}

}
