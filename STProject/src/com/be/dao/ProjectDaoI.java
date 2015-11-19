package com.be.dao;

import java.util.List;

import com.be.model.Project;

/**
 * 项目操作数据库接口
 * @author gaohailong
 * @version 1.0
 *
 */
public interface ProjectDaoI {
	/**
	 * 根据市id号查询项目信息
	 * @author gaohailong
	 * @param proId  项目id
	 * @return List<Project> 项目集合
	 */
	public List<Project> queryProjectByCityId(int cityId);
}
