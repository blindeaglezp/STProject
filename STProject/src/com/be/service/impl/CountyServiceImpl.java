package com.be.service.impl;

import java.util.List;

import com.be.dao.impl.CountyDaoImpl;
import com.be.model.County;
import com.be.service.CountyServiceI;

/**
 * 县业务逻辑实现类
 * @author blindeagle
 * @version 1.0
 */
public class CountyServiceImpl implements CountyServiceI {

	@Override
	public List<County> queryCountyByCityId(int cityId) {
		return new CountyDaoImpl().queryCountyByCityId(cityId);
	}

	@Override
	public String insertCounty(String countyName, int cityId) {
		if (new CountyDaoImpl().queryCountyByCityIdAndCountyName(cityId, countyName) != null) {
			return "isExist";
		}
		int result = new CountyDaoImpl().insertCounty(countyName, cityId, 1);
		if (result != 0) {
			return "success";
		}
		return "error";
	}

}
