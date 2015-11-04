package com.zp.dao;

import java.util.List;

import com.zp.model.FriendLink;
/**
 * 对友情链接信息进行增删改查
 * @author fer
 * @version 1.0
 */
public interface FriendLinkDaoI {
	
	/**
	 * 对友情链接进行添加
	 * @author fer
	 * @param friendLink 友情链接对象
	 * @return 受影响的条数
	 */
	public int addFriendLink(FriendLink friendLink);
	
	/**
	 * 对友情链接进行删除
	 * @author fer
	 * @param id ID号
	 * @return 受影响的条数
	 */
	public int deleteFriendLink(int id);
	
	/**
	 * 对友情链接进行修改
	 * @author fer
	 * @param id ID号
	 * @return 受影响的条数
	 */
	public int updateFriendLink(FriendLink friendLink);
	
	/**
	 * 对友情链接进行查询
	 * @author fer
	 * @param friendLink 友情链接对象
	 * @return 结果集
	 */
	public List<FriendLink> queryAllFriendLink();
	
}
