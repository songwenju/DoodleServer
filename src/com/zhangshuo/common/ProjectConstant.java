package com.zhangshuo.common;

/**
 * 项目用到的常数
 *
 */
public class ProjectConstant {

	//发送邮件相关
	//发送邮箱的地址
	public static final String EMAIL_FROM = "@163.com";
	//发送邮箱的名称，@之前
	public static final String EMAIL_USER = "";
	//发送邮箱的密码
	public static final String EMAIL_PWD = "";
	public static final String EMAIL_REGISTER_TEXT = 
			"<p>亲爱的用户，您好！感谢您注册随手涂鸦，希望我们的产品能带给您快乐，让您的生活更加的多姿多彩。</p><p>随手涂鸦</p>";
	public static final String EMAIL_REGISTER_TITLE = "随手涂鸦:注册";
	public static final String EMAIL_FINDPWD_TEXT = "亲爱的用户：您好！您此次重置密码的验证码如下，如非本人操作，请忽略此文件</ br>";
	public static final String EMAIL_FINDPWD_TITLE = "随手涂鸦:找回密码校验码";
	public static final String EMAIL_PORT = "smtp.163.com";//或smtp.qq.com

	//数据库相关
	
	//加载驱动
	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	//数据库的链接
	public static final String DB_URL = "";
	//数据库用户名	
	public static final String DB_USER_NAME = "";
	//数据库password
	public static final String DB_PASSWORD = "";
	//数据库表名
	public static final String USER_TABLE = "doodle_user";
	

}
