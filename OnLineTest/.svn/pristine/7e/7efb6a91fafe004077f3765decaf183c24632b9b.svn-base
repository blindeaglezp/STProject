package com.zp.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 数据类型转化操作工具类
 * @author blindeagle
 * @version 1.0
 */
public class DataTypeConvert {
	private static DateFormat format = null;
	
	/**
	 * 将Date类型数据转化为String类型
	 * @author blindeagle
	 * @param date 时间数据
	 * @return String 转化成String类型的数据
	 */
	public static String dateToString(Date date) {
		format = SimpleDateFormat.getInstance();
		return format.format(date);
	}
	
	/**
	 * 将String类型的数组转换成int类型的数组
	 * @author blindeagle
	 * @param params 将要转化的String类型数组
	 * @return 转换后的int类型数组
	 */
	public static int[] stringArrayToIntArray(String[] params) {
		int[] result = {};
		for (int i = 0; i < params.length; i++) {
			result[i] = Integer.parseInt(params[i]);
		}
		System.out.println(result);
		return result;
	}

}
