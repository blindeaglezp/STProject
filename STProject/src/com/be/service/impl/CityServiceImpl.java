package com.be.service.impl;

import java.util.List;

import com.be.dao.impl.CityDaoImpl;
import com.be.model.City;
import com.be.service.CityServiceI;

/**
 * 市业务逻辑实现类
 * @author blindeagle
 * @version 1.0
 */
public class CityServiceImpl implements CityServiceI {

	@Override
	public List<City> queryAllCity() {
		return new CityDaoImpl().queryAllCity();
	}

}
