package com.zp.dao;

import com.zp.model.Admin;

/**
 * 管理员数据库操作类抽象
 * @author blindeagle
 * @version 1.0
 */
public interface AdminDaoI {

	/**
	 * 查询数据库检查管理员是否存在
	 * @author blindeagle
	 * @param	username		管理员用户名
	 * @param	password		管理员密码
	 * @return	若用户存在，返回管理员对象，否则返回null
	 */
	public Admin checkLogin(String username, String password);
	
	/**
	 * 更新数据库管理员密码
	 * @author blindeagle
	 * @param id						管理员号
	 * @param newPassword		管理员新密码
	 * @return	若修改成功，返回true，否则返回false
	 */
	public boolean updatePassword(String id, String newPassword);
	
}
