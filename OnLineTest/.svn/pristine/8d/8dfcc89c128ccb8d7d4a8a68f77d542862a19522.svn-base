package com.zp.service.impl;

import java.util.List;

import com.zp.dao.FriendLinkDaoI;
import com.zp.dao.impl.FriendLinkDaoImpl;
import com.zp.model.FriendLink;
import com.zp.service.FriendLinkServiceI;

public class FriendLinkServiceImpl implements FriendLinkServiceI{
	private FriendLinkDaoI friendLinkDao = new FriendLinkDaoImpl();
	@Override
	public int addFriendLink(FriendLink friendLink) {
		return friendLinkDao.addFriendLink(friendLink);
	}

	@Override
	public int deleteFriendLink(int id) {
		return friendLinkDao.deleteFriendLink(id);
	}

	@Override
	public int updateFriendLink(FriendLink friendLink) {
		return 0;
	}

	@Override
	public List<FriendLink> queryAllFriendLink() {
		return friendLinkDao.queryAllFriendLink();
	}

}
