package com.zp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zp.dao.FriendLinkDaoI;
import com.zp.model.FriendLink;
import com.zp.util.JdbcUtil;


public class FriendLinkDaoImpl extends JdbcUtil implements FriendLinkDaoI{
	
	@Override
	public int addFriendLink(FriendLink friendLink) {
		String sql = "insert into friendlink(url,name,imgPath) values(?,?)";
		String[] params = new String[]{friendLink.getUrl(), friendLink.getName(), friendLink.getImgPath()};
		return getUpdate(sql, params);
	}
	
	
	@Override
	public int deleteFriendLink(int id) {
		String sql = "delete from friendlink where id=?";
		Integer[] params = new Integer[]{id};
		return getUpdate(sql, params);
	}
	
	
	@Override
	public int updateFriendLink(FriendLink friendLink) {
		
		return 0;
	}
	
	
	@Override
	public List<FriendLink> queryAllFriendLink() {
		List<FriendLink> friendLinkList = new ArrayList<FriendLink>();
		FriendLink friendLink = null;
		String sql = "select url,name,imgPath from friendlink";
		rs = getQuery(sql, null);
		try {
			while(rs.next()){
				friendLink = new FriendLink();
				friendLink.setName(rs.getString("name"));
				friendLink.setUrl(rs.getString("url"));
				friendLink.setImgPath(rs.getString("imgPath"));
				friendLinkList.add(friendLink);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return friendLinkList;
	}

}
