package com.zp.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 存放试卷试题的临时类
 * @author blindeagle
 * @version 1.0
 */
public class TestPaperData {

	// 存放试题的Map集合
	public static Map<Integer, Object> questions = new HashMap<Integer, Object>();
	
	// 存放学生答案的Map集合
	public static Map<Integer, Object> answers = new HashMap<Integer, Object>();
	
}
