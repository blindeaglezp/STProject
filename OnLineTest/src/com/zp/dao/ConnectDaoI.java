package com.zp.dao;

import java.util.List;

import com.zp.model.Connect;

/**
 * 联系方式数据库操作类
 * @author blindeagle
 * @version 1.0
 */
public interface ConnectDaoI {

	/**
	 * 查询服务端联系方式
	 * @author blindeagle
	 * @return	服务端联系方式集合
	 */
	public List<Connect> queryConnect();
	
}
