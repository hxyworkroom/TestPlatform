package cn.hy.testplatform.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.hy.testplatform.manage.service.HttpClientService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("HttpClient")
public class HttpClientTestController {
	
	@Autowired
	private HttpClientService httpClientService;
	
	@RequestMapping("/index")
	public String restfulpage(HttpServletRequest request){
		return "httpclientpage";
	}
	
	@RequestMapping(value="/GetA", method=RequestMethod.POST)
	@ResponseBody 
	//发起一次get请求带参数和不带参数都可以
	public JSONObject testHttpClient_send(@RequestBody String URLs){
		return httpClientService.testHttpClient_GetSend(URLs);
	}
	
	@RequestMapping(value="/GetHtml", method=RequestMethod.POST)
	@ResponseBody 
	//发起一次get请求获取页面html代码
	public JSONObject testHttpClient_getHtml(@RequestBody String URLs){
		return httpClientService.testHttpClient_GetHtml(URLs);
	}
	
	@RequestMapping(value="/GetMoreParamTest", method=RequestMethod.POST)
	@ResponseBody 
	//发起批量不同参数get请求
	public JSONObject GetMoreParamTest(@RequestBody String URLs){
		System.out.println("多参数进来没");
		return httpClientService.GetMoreParamTest(URLs);
	}
	
	@RequestMapping(value="/PostTest", method=RequestMethod.POST)
	@ResponseBody 
	//发起批量不同参数get请求
//	public JSONObject PostTest(@RequestBody String URLs){
	public String PostTest(@RequestBody String URLs){
		System.out.println("post测试开始");
		httpClientService.PostTest(URLs);
//		return httpClientService.PostTest(URLs);
		return "ok";
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
