package com.be.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * Jdbc操作数据库工具类
 * @author blindeagle
 * @version 1.0
 */
public class JdbcUtil {
	
	private static ThreadLocal<Connection> connThread = new ThreadLocal<Connection>();
	private static Properties pros = System.getProperties();
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	static {
		try {
			InputStream is = JdbcUtil.class.getResourceAsStream("/jdbc.properties");
			pros.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取数据库连接
	 * @author blindeagle
	 * @return void
	 */
	public static void getConnection() {
		conn = connThread.get();
		if(conn == null){
		    try{
		    	DataSource ds = BasicDataSourceFactory.createDataSource(pros);
		    	conn = ds.getConnection();
		    	connThread.set(conn);
		    }catch(SQLException se){
		    	se.printStackTrace();
		    	throw new RuntimeException(se);
		    } catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 查询的公共方法
	 * @author blindeagle
	 * @param sql 执行的sql语句
	 * @param params 参数列表
	 * @return ResultSet 结果集
	 */
	public static ResultSet getQuery(String sql, Object[] params) {
		try {
			getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 数据的增删改操作的公共方法
	 * @author blindeagle
	 * @param sql 执行的sql语句
	 * @param params 参数列表
	 * @return int 受影响的记录条数
	 */
	public static int getUpdate(String sql, Object[] params) {
		int result = 0;
		getConnection();
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			result = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			releaseConnection();
		}
		return result;
	}

	/**
	 * 释放数据库连接
	 * @author blindeagle
	 * @return void
	 */
	public static void releaseConnection() {
		try {
			if (rs != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		connThread.set(null);
	}
	
}
