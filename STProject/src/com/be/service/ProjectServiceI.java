package com.be.service;

import java.util.List;

import com.be.model.Project;

/**
 * 项目业务逻辑接口
 * @author blindeagle
 * @version 1.0
 */
public interface ProjectServiceI {

	/**
	 * 根据市id号查询项目
	 * @author blindeagle
	 * @param cityId 市id号
	 * @return List<Project> 项目集合
	 */
	public List<Project> queryProjectByCityId(int cityId);
	
}
