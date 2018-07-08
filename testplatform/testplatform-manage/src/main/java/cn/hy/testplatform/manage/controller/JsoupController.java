package cn.hy.testplatform.manage.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hy.testplatform.manage.service.JsopuService;
import cn.hy.testplatform.manage.service.UserService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("Jsoup")
public class JsoupController {
	@Autowired
	private JsopuService jsopuService;
	
	@RequestMapping("/index")
	public String restfulpage(HttpServletRequest request){
		System.out.println("进入Jsoup测试页面！");
		
		String ip=UserController.getIpAddr(request);
		System.out.println(ip);
		
		return "Jsoup";
	}
	@RequestMapping(value = "getHtml",method =RequestMethod.POST)
	@ResponseBody
	public String getHtml(@RequestBody String param){
        JSONObject object = JSONObject.fromObject(param);
        
        String url=(String) object.get("getHtmlUrl");
        String savelocation=(String) object.get("saveLocation");
		
		return jsopuService.getHtml(url,savelocation);
	}
	
	@RequestMapping(value = "getImgs",method =RequestMethod.POST)
	@ResponseBody
	public String getImgs(@RequestBody String param) throws Exception{
        JSONObject object = JSONObject.fromObject(param);
        
        String url=(String) object.get("GetImgUrls");
        String savelocation=(String) object.get("GetImgSave");
		
		return jsopuService.getImg(url,savelocation);
	}

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












