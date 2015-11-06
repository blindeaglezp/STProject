package com.zp.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 存放试题的临时信息
 * @author blindeagle
 * @version 1.0
 */
public class TestPaperData {
	
	// 选择题总数
	public int choiceQuestionCount; 
	
	// 判断题总数
	public int judgeQuestionCount; 
	
	// 填空题总数
	public int fillBlanksQuestionCount; 

	// 存放学生答案的Map集合
	public Map<Integer, Object> answers = new HashMap<Integer, Object>();
	
}
