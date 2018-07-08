package cn.hy.testplatform.manage.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hy.testplatform.manage.pojo.User;
import cn.hy.testplatform.manage.service.UserService;

@Controller
@RequestMapping("User")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String restfulpage(HttpServletRequest request){
		System.out.println("进入restful测试页面！");
		
		String ip=UserController.getIpAddr(request);
		System.out.println(ip);
		
		return "systemtestpage";
	}
	
	//查询所有用户
	@RequestMapping(value = "findAllUser",produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<User> findAllUser(){
		return userService.findAllUser();
	}
	
	//按条件查询用户
	@ResponseBody
	@RequestMapping(value ="/findUserByCondition", method =RequestMethod.POST) 
	public List<User> findAllUserByCondition(@RequestBody String param) throws Exception{
		param=URLDecoder.decode(param, "UTF-8");
        JSONObject object = JSONObject.fromObject(param);
        String tj=(String) object.get("tj");
        String datas=(String) object.get("datas");
        List<User> users=userService.findAllUserByCondition(tj,datas);
//		JSONObject json = JSONObject.fromObject(user);//将java对象转换为json对象
//		String str = json.toString();//将json对象转换为字符串
		return users;
	}

	//添加用户
	@RequestMapping(value="/TYsaveUser", method=RequestMethod.POST)
	@ResponseBody
	public String TYfindByUserId(User user){
		System.out.println(user.toString());
		int result = userService.TYfindByUserId(user);
		System.out.println(result);
		if (result==1) {
			String f="insert user success!";
			return f;
		}else{	
			return "fail to insert user!";
		}
	}

	//删除用户
	@RequestMapping("/TYdeleteUser")
	@ResponseBody
	public String deleteUser(@RequestBody String param){
		try {
			param=URLDecoder.decode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject object = JSONObject.fromObject(param);
        String tj=(String) object.get("tjd");
        String data=(String) object.get("datad");
        System.out.println(tj+"~~~~"+data);
        
        List<User> users=userService.findAllUserByCondition(tj,data);
		System.out.println(users.get(0).toString());
		
		int result = userService.TYdeleteUser(users.get(0));
		if (result==1) {
			return "delete user success!";
		}else{	
			return "fail to delete user!";
		}
	}
//---------------------------------------------------------分割线---------------------------------------------------------
	//更新用户信息
	@RequestMapping(value="/TYupdateUser", method=RequestMethod.POST)
	@ResponseBody
	public String updateUser(User user){
		if (user.getUid()==null || user.getUname()==null) {
			return "fail to update user!";
		}
		int result=userService.TYupdateUser(user);
		if (result==1) {
			return "update user success!";
		}else{	
			return "fail to update user!";
		}	
	}
//---------------------------------------------------------分割线---------------------------------------------------------
//获取来访者的ip
	public static String getIpAddr(HttpServletRequest request) {  
	    String ip = request.getHeader("x-forwarded-for");  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getRemoteAddr();  
	    }  
	    return ip;  
	}  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}












