package com.zhangshuo.user.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangshuo.db.MD5_Encoding;

/**
 * 
 * ajax进行登录系统时验证登录信息
 *
 */
public class LoginJudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userId = request.getParameter("id");				
		String userPassword = request.getParameter("password");	
		
		MD5_Encoding  md5 = new MD5_Encoding();					//密码加密
		String password = md5.getMD5ofStr(userPassword);
		
//		UserLogin login = new LoginImpls();						//初始化用户登录的类
//		User user = null;
//		try {
//			user = login.getUser(userId);
//		} catch (Exception e) {
//			response.sendRedirect("404.html");
//		}
//		
//		PrintWriter out = response.getWriter();
//		int code;
//		if(user != null){							//通过
//			
//			if(user.getPassword().equalsIgnoreCase(password)){
//				code = 1;							//用户名与密码匹配
//				out.println(code);
//			}else{
//				code = 0;							//用户名与密码不匹配					
//				out.println(code);
//			}
//			
//		}else{
//			code = -1;								//用户不存在
//			out.print(code);
////		}
//		out.flush();
//		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
