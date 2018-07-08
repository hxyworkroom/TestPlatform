package cn.hy.testplatform.manage.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hy.testplatform.manage.pojo.User;
import tk.mybatis.mapper.common.Mapper;

@Repository 
public interface UserMapper extends Mapper<User> {
	List<User> findAllUser();
	List<User> findAllUserByConditionByid(int datas);
	List<User> findAllUserByConditionByname(String datas);
	List<User> findAllUserByConditionByusex(String datas);
	List<User> findAllUserByConditionByuage(int datas);
	List<User> findAllUserByConditionByueducate(String datas);
	List<User> findAllUserByConditionByumajor(String datas);
	List<User> findAllUserByConditionByulocal(String datas);
	List<User> findAllUserByConditionByudepartment(String datas);
	List<User> findAllUserByConditionByuphone(String datas);	
//-------------------------------------------------------------分割线--------------------------------------------------------	

	
	
	
	
	
	
	
	
	
	
	

}
