package cn.hy.testplatform.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hy.testplatform.manage.mapper.UserMapper;
import cn.hy.testplatform.manage.pojo.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userMapper.findAllUser();
	}
	@Override
	public List<User> findAllUserByCondition(String tj,String datas){

		switch (tj) {
			case "uid":
				int data=Integer.valueOf(datas);
				return userMapper.findAllUserByConditionByid(data);
			case "uname":
				return userMapper.findAllUserByConditionByname(datas);
			case "usex":
				return userMapper.findAllUserByConditionByusex(datas);
			case "uage":
				int dataage=Integer.valueOf(datas);
				return userMapper.findAllUserByConditionByuage(dataage);
			case "ueducate":
				return userMapper.findAllUserByConditionByueducate(datas);
			case "umajor":

				return userMapper.findAllUserByConditionByumajor(datas);
			case "ulocal":

				return userMapper.findAllUserByConditionByulocal(datas);
			case "udepartment":

				return userMapper.findAllUserByConditionByudepartment(datas);
			case "uphone":

				return userMapper.findAllUserByConditionByuphone(datas);
		}
		return null;
	}
	@Override
	public int TYfindByUserId(User user){
		int result=userMapper.insert(user);
		return result;
	}
	
	@Override
	public int TYdeleteUser(User user) {
		// TODO Auto-generated method stub
		int result=userMapper.delete(user);
		
		return result;
	}
//-------------------------------------------------------------分割线--------------------------------------------------------	
	@Override
	public int TYupdateUser(User user) {


		//使用这个方法会把null值也更新了
//		int result=userMapper.updateByPrimaryKey(user);
		//使用这个方法如果是null值，会报错
		User userold=userMapper.selectByPrimaryKey(user);
		System.out.println("这是查出来的user:"+userold.toString());
		
		if (user.getUname()=="") {
			user.setUname(userold.getUname());
			System.out.println("~~1~~");
		}
		if (user.getUsex()=="") {
			user.setUsex(userold.getUsex());
			System.out.println("~~2~~");
		}
		if (user.getUage()+""=="") {
			user.setUage(userold.getUage());
			System.out.println("~~3~~");
		}
		if (user.getUeducate()=="") {
			user.setUeducate(userold.getUeducate());
			System.out.println("~~4~~");
		}
		if (user.getUmajor()=="") {
			user.setUmajor(userold.getUmajor());
			System.out.println("~~5~~");
		}
		if (user.getUlocal()=="") {
			user.setUlocal(userold.getUlocal());
			System.out.println("~~6~~");
		}
		if (user.getUdepartment()=="") {
			user.setUdepartment(userold.getUdepartment());
			System.out.println("~~7~~");
		}
		if (user.getUphone()=="") {
			user.setUphone(userold.getUphone());
			System.out.println("~~8~~");
		}
		System.out.println("这是进行更新的user："+user.toString());
		int result =userMapper.updateByPrimaryKeySelective(user);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	













}
