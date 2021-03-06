package com.zp.dao;

import java.util.List;

import com.zp.model.Score;

/**
 * 对分数进行增删改查
 * @author fer
 * @version 1.0
 */
public interface ScoreDaoI {
	
	/**
	 * 增加分数
	 * @author fer
	 * @param score 分数对象
	 * @return int	受影响的条数
	 */
	public int insertScore(Score score);
	
	/**
	 * 删除分数
	 * @author fer
	 * @param id ID号
	 * @return int	受影响的条数
	 */
	public int deleteScore(int id);
	
	/**
	 * 更新分数
	 * @author fer
	 * @param score 分数对象
	 * @return int 受影响的条数
	 */
	public int updateScore(Score score);
	
	/**
	 * 根据学号和试卷号查询试卷分数
	 * @author fer
	 * @param studnetId 学号
	 * @param testPaperId 试卷号
	 * @return Score 查询到的分数对象 
	 */
	public Score queryScoreByStudentIdAndTestPaperId(String studentId, String testPaperId);
	
	/**
	 * 根据学号查询试卷分数
	 * @author fer
	 * @param studnetId 学号
	 * @return List<Score> 分数集合
	 */
	public List<Score> queryScoreByStudentId(String studentId);
	
}
