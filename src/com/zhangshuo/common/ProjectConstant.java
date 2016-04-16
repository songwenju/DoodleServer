package com.zhangshuo.common;

/**
 * 项目用到的常数
 *
 */
public class ProjectConstant {

	//发送邮件相关
	//发送邮箱的地址
	public static final String EMAIL_FROM = "XXX@163.com";
	//发送邮箱的名称，@之前
	public static final String EMAIL_USER = "XXX";
	//发送邮箱的密码
	public static final String EMAIL_PWD = "XXX";
	public static final String EMAIL_REGISTER_TEXT = 
			"<p>亲爱的用户，您好！感谢您注册随手涂鸦，希望我们的产品能带给您快乐，让您的生活更加的多姿多彩。</p><p>随手涂鸦</p>";
	public static final String EMAIL_REGISTER_TITLE = "[随手涂鸦]APP注册";
	public static final String EMAIL_FINDPWD_TEXT = "<p> 亲爱的用户：您好！您现在在找回密码阶段，您的校验码为：</p><br />";
	public static final String EMAIL_FINDPWD_TITLE = "[随手涂鸦]APP找回密码";
	public static final String EMAIL_PORT = "smtp.163.com";//或smtp.qq.com

	//数据库相关
	
	//加载驱动
	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	//数据库的链接
	public static final String DB_URL = "jdbc:mysql://localhost:3306/doodle";
	//数据库用户名			`	
	public static final String DB_USER_NAME = "xxx";
	//数据库password
	public static final String DB_PASSWORD = "xxx";

}
