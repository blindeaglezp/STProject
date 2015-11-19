package com.be.dao;

import java.util.List;

import com.be.model.Subject;

/**
 * 科目数据库接口
 * @author blindeagle
 * @version 1.0
 */
public interface SubjectDaoI {

	/**
	 * 添加科目
	 * @author blindeagle
	 * @param name 科目名
	 * @return int 受影响的记录条数
	 */
	public int addSubject(String name);
	
	/**
	 * 查询所有科目
	 * @author blindeagle
	 * @return List<Subject> 科目集合
	 */
	public List<Subject> queryAllSubject();
	
	/**
	 * 根据科目id删除科目
	 * @author blindeagle
	 * @param id 科目id
	 * @return int 受影响的记录条数
	 */
	public int deleteSubjectById(int id);
	
	/**
	 * 根据科目id更新科目信息
	 * @author blindeagle
	 * @param id 科目id
	 * @param name 科目名
	 * @return int 受影响的记录条数
	 */
	public int updateSubjectById(int id, String name);
	
}
