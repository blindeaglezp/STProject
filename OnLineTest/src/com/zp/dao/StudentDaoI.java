package com.zp.dao;

import com.zp.model.Student;

/**
 * 学生数据库操作类
 * @author blindeagle
 * @version 1.0
 */
public interface StudentDaoI {

	/**
	 * 操作数据库检查学生是否存在
	 * @author blindeagle
	 * @param username	学生用户名
	 * @param password	学生密码
	 * @return	若用户存在，返回学生对象，否则返回null
	 */
	public Student checkLogin(String username, String password);
	
	/**
	 * 更新学生密码
	 * @author blindeagle
	 * @param id						学号
	 * @param newPassword		学生新密码
	 * @return	若修改成功，返回true，否则返回false
	 */
	public boolean updatePassword(String id, String newPassword);
	
}
