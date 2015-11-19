package com.be.dao;

import java.util.List;

import com.be.model.City;

/**
 * 市操作数据库接口
 * @author blindeagle
 * @version 1.0
 */
public interface CityDaoI {
	
	/**
	 * 查询所有市
	 * @author blindeagle
	 * @return List<City> 市集合
	 */
	public List<City> queryAllCity();
	
}
