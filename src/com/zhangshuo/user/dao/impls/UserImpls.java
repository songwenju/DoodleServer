package com.zhangshuo.user.dao.impls;

import java.sql.SQLException;

import com.zhangshuo.common.ProjectConstant;
import com.zhangshuo.db.BaseDB;
import com.zhangshuo.user.dao.UserDao;
import com.zhangshuo.user.domain.User;

/**
 * 用户添加等
 */
public class UserImpls extends BaseDB implements UserDao{
	public static final String USER_TABLE = ProjectConstant.USER_TABLE;

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
	public User getDbUser(String LoginIdentity){
		User user = null;
		String sql = "select * from "+USER_TABLE+" where userEmail=  ?  or userName=?"; 
		super.res = super.executeQuery(sql,LoginIdentity,LoginIdentity);
		if(LoginIdentity.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")){
			try {
				if(super.res.next()){
					user =new User();
					user.setUserEmail(LoginIdentity);
					user.setUserName(super.res.getString("userName"));
					user.setPassword(super.res.getString("userPassword"));
					user.setCheckCode(super.res.getString("checkCode"));
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
					user.setPassword(super.res.getString("userPassword"));
					user.setPassword(super.res.getString("userPassword"));
					user.setCheckCode(super.res.getString("checkCode"));
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
	 * @param userEmail
	 * @param userPassword
	 * @return
	 */
	public int resetPassword(String userEmail, String userPassword) {
		int flag = 0;
		String sql = "update "+USER_TABLE+" set userPassword='"
				+userPassword+"' where userEmail='"+userEmail+"'";
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
	 * @param userEmail
	 * @param checkCode
	 * @return
	 */
	@Override
	public boolean isCheckCode(String userEmail,String checkCode) {
		String sql = "select * from "+USER_TABLE+" where userEmail = ?";
		super.res = super.executeQuery(sql, userEmail);
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

	@Override
	public int updateCheckCode(String email, String checkCode) {
		int flag = 0;
		String sql =  "update "+USER_TABLE+" set checkCode = '"
				+checkCode +"' where userEmail = '" +email+"'";
		System.out.println(sql);
		try{
			super.executeUpdate(sql);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

}
