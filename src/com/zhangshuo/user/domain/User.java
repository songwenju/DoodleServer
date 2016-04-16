package com.zhangshuo.user.domain;

/**
 * 用户信息
 */
public class User {
	public User(){}
	private int id;						
	private String userEmail;		    //用户邮箱，保持唯一
	private String userName;			//用户昵称，保证唯一（如果想用它进行登录的话）
	private String password;			//用户密码，用MD5加密		
	private String CheckCode;			//用户找回密码时的校验码	

	public User(int id, String userEmail, String userName, String password,
			String checkCode) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.userName = userName;
		this.password = password;
		CheckCode = checkCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getCheckCode() {
		return CheckCode;
	}

	public void setCheckCode(String checkCode) {
		CheckCode = checkCode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userEmail=" + userEmail + ", userName="
				+ userName + ", password=" + password + ", CheckCode=" + CheckCode + "]";
	}
	
}

