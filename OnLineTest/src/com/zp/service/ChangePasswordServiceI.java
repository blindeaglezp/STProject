package com.zp.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 更改密码业务逻辑
 * @author blindeagle
 * @version 1.0
 */
public interface ChangePasswordServiceI {

	/**
	 * 修改密码
	 * @param request 请求对象
	 * @param oldPassword 原密码
	 * @param newPassword 新密码
	 * @param reNewPassword 重复新密码
	 * @return 修改成功，返回true；修改失败，返回false
	 */
	public boolean changePassword(HttpServletRequest request, String oldPassword, String newPassword, String reNewPassword);
	
}
