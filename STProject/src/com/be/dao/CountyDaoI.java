package com.be.dao;

import java.util.List;

import com.be.model.County;

/**
 * 县操作数据库接口
 * @author blindeagle
 * @version 1.0
 */
public interface CountyDaoI {

	/**
	 * 根据市id号查询县信息
	 * @author blindeagle
	 * @param cityId 市id号
	 * @return List<County> 县集合
	 */
	public List<County> queryCountyByCityId(int cityId);
	
	/**
	 * 插入县信息
	 * @author blindeagle
	 * @param name 县名
	 * @param cityId 市id
	 * @param stateId 状态号
	 * @return int 数据库受影响的记录条数
	 */
	public int insertCounty(String name, int cityId, int stateId);
	
	/**
	 * 根据市id号和县名查询县信息
	 * @author blindeagle
	 * @param cityId 市id号
	 * @param countyName 县名
	 * @return County 县对象
	 */
	public County queryCountyByCityIdAndCountyName(int cityId, String countyName);
	
}
