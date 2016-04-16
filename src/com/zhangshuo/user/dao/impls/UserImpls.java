package com.zhangshuo.user.dao.impls;

import java.sql.SQLException;

import com.zhangshuo.db.BaseDB;
import com.zhangshuo.user.dao.UserDao;
import com.zhangshuo.user.domain.User;

/**
 * 用户添加等
 */
public class UserImpls extends BaseDB implements UserDao{
	public static final String USER_TABLE = "user";
	
	/**
	 * 添加用户
	 * @param user
	 */
	public int add(User user) {

		String sql = "insert into "+USER_TABLE+"(userName,userEmail,userPassword,checkCode)"
			+"values('"
					+user.getUserName()+"','"
					+user.getUserEmail()+"','"
					+user.getPassword()+"','"
					+user.getCheckCode()+"')";
		System.out.println(sql);
		return super.executeUpdate(sql);
	}
	
	/**
	 * 由身份（邮箱或用户名）获取用户，在修改密码时，通过用户名查找邮箱或判断输入的邮箱是否存在
	 * @param LoginIdentity
	 * @return
	 */
	public User getEmail(String LoginIdentity){
		User user = null;
		String sql = "select * from "+USER_TABLE+" where userEmail=  ?  or userName=?"; 
		super.res = super.executeQuery(sql,LoginIdentity,LoginIdentity);
		if(LoginIdentity.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")){
			try {
				if(super.res.next()){
					user =new User();
					user.setUserEmail(LoginIdentity);
					user.setUserName(super.res.getString("userName"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			try {
				if(super.res.next()){
					user =new User();
					user.setUserName(LoginIdentity);
					user.setUserEmail(super.res.getString("userEMail"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		super.closeConn();
		return user;
	}
	/**
	 * 重置密码
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public int resetPassword(String userName, String userPassword) {
		int flag = 0;
		String sql = "update "+USER_TABLE+" set userPassword='"
					+userPassword+"' where userName='"+userName+"'";
		try{
			super.executeUpdate(sql);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * 检验校验码
	 * @param checkCode
	 * @param userName
	 * @return
	 */
	@Override
	public boolean checkUserCode(String checkCode, String userName) {
		String sql = "select * fom"+USER_TABLE+"where userName = ?";
		super.res = super.executeQuery(sql, userName);
		try {
			if (super.res.next()) {
				String checkCodeDb = super.res.getString("checkCode");
				return checkCode.equals(checkCodeDb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
