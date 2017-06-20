package org.global.fairy.cms.admin.dao;

import org.global.fairy.cms.admin.dao.beans.UserInfoBean;
import org.springframework.stereotype.Repository;
@Repository
public interface UserInfoMapper {

	public UserInfoBean getUserInfo();

	public int insertUserInfo(UserInfoBean userInfo);

	public int deleteUserInfo(long id);

}
