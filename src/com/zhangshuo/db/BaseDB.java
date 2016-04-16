package com.zhangshuo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zhangshuo.common.ProjectConstant;

/**
 * 数据库增加，查询，修改
 */
public class BaseDB {
	//加载驱动
	private static final String DRIVER = ProjectConstant.DB_DRIVER;
	//数据库的链接
	private static final String URL = ProjectConstant.DB_URL;
	//数据库用户名			`	
	private static final String USER = ProjectConstant.DB_USER_NAME;
	//数据库password
	private static final String PASSWORD = ProjectConstant.DB_PASSWORD;
	
	
	//获取链接
	public Connection conn = null;
	//操作
	public PreparedStatement pstmt = null;
	//数据库结果集
	public ResultSet res = null;
	public Statement stmt = null;
	
	/**
	 *  连接数据库
	 * @return
	 */
	public Connection getConn() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 关闭数据库
	 * @param res
	 */
	public void closeConn(){
			
			try{
				if(this.res!=null){
					this.res.close();
					this.res=null;
				}
				if(this.pstmt!=null){
					this.pstmt.close();
					this.pstmt = null;
				}
				if(this.conn!=null){
					this.conn.close();
					this.conn=null;
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
	
	/**
	 * 查询
	 * @param sql
	 * @param obj
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object... obj){
		
		this.conn = this.getConn();
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			for(int i=0;i<obj.length; i++){
				this.pstmt.setObject(i+1, obj[i]);
			} 
			return this.pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  null;
	}
	

	/**
	 * 添加  更新 修改
	 * @param sql
	 * @param obj
	 */
	public int executeUpdate(String sql,Object... obj){
		
		try {
			this.stmt = this.getConn().createStatement();
			return this.stmt.executeUpdate(sql);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		this.closeConn();
		return 0 ;
	}
}
