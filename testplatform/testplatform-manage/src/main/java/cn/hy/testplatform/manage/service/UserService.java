package cn.hy.testplatform.manage.service;

import java.util.List;

import cn.hy.testplatform.manage.pojo.User;

public interface UserService {
	
	public List<User> findAllUser();
	public List<User> findAllUserByCondition(String tj,String datas);
	
	public int TYfindByUserId(User user);
	public int TYdeleteUser(User user);
	public int TYupdateUser(User user);



}
