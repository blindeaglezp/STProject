package com.zp.dao;

import com.zp.model.Teacher;

/**
 * 教师管理员操作类
 * @author blindeagle
 * @version 1.0
 */
public interface TeacherDaoI {

	/**
	 * 操作数据库检查教师是否存在
	 * @author blindeagle
	 * @param username	教师用户名
	 * @param password	教师密码
	 * @return	若用户存在，返回教师对象，否则返回null
	 */
	public Teacher checkLogin(String username, String password);
	
	/**
	 * 更新教师密码
	 * @author blindeagle
	 * @param id						教师号
	 * @param newPassword		教师新密码
	 * @return	若修改成功，返回true，否则返回false
	 */
	public boolean updatePassword(String id, String newPassword);
	
}
