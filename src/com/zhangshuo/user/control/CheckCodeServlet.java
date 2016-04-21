package com.zhangshuo.user.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangshuo.user.dao.UserDao;
import com.zhangshuo.user.dao.impls.UserImpls;
import com.zhangshuo.user.domain.User;

public class CheckCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String email= request.getParameter("email");
		String checkCode = request.getParameter("checkCode");
		String method = request.getParameter("method");
		System.out.println("email:"+email +" checkCode:"+checkCode+" method:"+ method);
		UserDao userDao = new UserImpls();
		User user = userDao.getDbUser(email);
		if (user == null) {
			System.out.println("用户不存在");
			response.getOutputStream().write("1".getBytes("UTF-8"));
		}else {
			if ("set".equals(method)) {
				updateCheckCode(response,userDao,email, checkCode);
			}else if("check".equals(method)){
				isCheckCode(response,userDao,email, checkCode);
			}
			
		}
	}


	private void isCheckCode(HttpServletResponse response, UserDao userDao,
			String email, String checkCode) throws IOException {
		if(userDao.isCheckCode(email, checkCode)){
			System.out.println("正确的验证码");
			response.getOutputStream().write("2".getBytes("UTF-8"));
		}else {
			System.out.println("验证码错误");
			response.getOutputStream().write("3".getBytes("UTF-8"));
		}
	}


	private void updateCheckCode(HttpServletResponse response, UserDao userDao, String email, String checkCode) 
			throws  IOException {
	
		int result = userDao.updateCheckCode(email, checkCode);
		if (result == 1) {
			System.out.println("更新成功");
			response.getOutputStream().write("2".getBytes("UTF-8"));
			MailSent mailSent = new MailSent();
			mailSent.sendCheckCodeMail(email, checkCode);
		}else {
			System.out.println("更新失败");
			response.getOutputStream().write("3".getBytes("UTF-8"));
		}
	}

}
