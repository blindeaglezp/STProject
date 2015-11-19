package com.be.service;

import java.util.List;

import com.be.model.County;

/**
 * 县业务逻辑接口
 * @author blindeagle
 * @version 1.0
 */
public interface CountyServiceI {
	
	/**
	 * 根据市id号查询县信息
	 * @author blindeagle
	 * @param cityId 市id号
	 * @return List<County> 县集合
	 */
	public List<County> queryCountyByCityId(int cityId);
	
	/**
	 * 添加县信息
	 * @author blindeagle
	 * @param countyName 县名
	 * @param cityId 市id号
	 * @return String 县已存在返回isExist，添加成功返回success，添加失败返回error
	 */
	public String insertCounty(String countyName, int cityId);
	
}
