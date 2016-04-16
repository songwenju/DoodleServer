package com.zhangshuo.user.dao;

import com.zhangshuo.user.domain.User;


/**
 * 用户添加等
 * interface
 */
public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 */
	public int add(User user);
	
	
	/**
	 * 由身份获取用户
	 * @param LoginIdentity
	 * @return
	 */
	public User getEmail(String LoginIdentity);
	/**
	 * 重新输入密码
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public int resetPassword(String userName,String userPassword);

	/**
	 * 检验校验码
	 * @param checkCode
	 * @param userName
	 * @return
	 */
	public boolean checkUserCode(String checkCode,String userName);
}
