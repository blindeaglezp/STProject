package com.be.service;

import java.util.List;

import com.be.model.City;

/**
 * 市业务逻辑接口
 * @author blindeagle
 * @version 1.0
 */
public interface CityServiceI {

	/**
	 * 查询所有市
	 * @author blindeagle
	 * @return List<City> 市集合
	 */
	public List<City> queryAllCity();
	
}
