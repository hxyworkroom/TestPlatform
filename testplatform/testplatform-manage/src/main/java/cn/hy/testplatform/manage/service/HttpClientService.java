package cn.hy.testplatform.manage.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hy.testplatform.common.utils.HttpClientSendTestUtlis;
import net.sf.json.JSONObject;

@Service
public class HttpClientService {
	
	@Autowired
	private HttpClientSendTestUtlis hcstu;
	
	Map map=null;
	String urls="";
    String cookie="";
    String refer="";
    String rdz="";
    String wdz="";
	public JSONObject testHttpClient_GetSend(String URLs) {
		try {
			URLs=URLDecoder.decode(URLs, "UTF-8");
			JSONObject object = JSONObject.fromObject(URLs);
	        String url=(String) object.get("url_complete");
	        String param=(String) object.get("param_complete");
	        cookie=(String) object.get("cookie_complete");
	        refer=(String) object.get("refer_complete");
			urls=url+"?"+param;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        try {
        	if (cookie=="" && refer=="") {		
        		map = hcstu.getSubmit(urls);
			}else {
				map = hcstu.getSubmit(urls,cookie,refer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject jsonObject = JSONObject.fromObject(map);  
		return jsonObject;
	}
	
	public JSONObject testHttpClient_GetHtml(String URLs) {
		try {
			URLs=URLDecoder.decode(URLs, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//第二次迭代进行异常处理
		}
        JSONObject object = JSONObject.fromObject(URLs);
        String url=(String) object.get("url_complete");
        String param=(String) object.get("param_complete");
        cookie=(String) object.get("cookie_complete");
        refer=(String) object.get("refer_complete");
        if (param=="") {
			urls=url;
		}else {
			urls=url+"?"+param;
		}
    	try {
			map = hcstu.getHtml(urls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//第二次迭代进行异常处理
		}
	    JSONObject jsonObject = JSONObject.fromObject(map);  
		return jsonObject;
	}
	
	public JSONObject GetMoreParamTest(String URLs){
		map = new HashMap();
		try {
			URLs=URLDecoder.decode(URLs, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//第二次迭代进行异常处理
		}
        JSONObject object = JSONObject.fromObject(URLs);
        System.out.println(object.toString());
        String url=(String) object.get("url_complete");
        cookie=(String) object.get("cookie_complete");
        refer=(String) object.get("refer_complete");
        rdz=(String) object.get("location_complete");
        wdz=(String) object.get("result_complete");
        Boolean f = null;
        try {
			f = hcstu.GetMoreParamTest(rdz,wdz,url,cookie,refer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			f = false;
		}
		if(f) {
			map.put("result", "ok");
		    JSONObject jsonObject = JSONObject.fromObject(map);  
			return jsonObject;
		}else {
			map.put("result", "false");
		    JSONObject jsonObject = JSONObject.fromObject(map);  
			return jsonObject;
		}
	}
	
	public void PostTest(String urls) {
//		public JSONObject PostTest(String urls) {
		map = new HashMap();
        JSONObject object = JSONObject.fromObject(urls);
        System.out.println(object.toString());
        String url=(String) object.get("url_complete");
        String params = (String) object.get("params_complete");
		String result = hcstu.postSendSubmitJson(url, params);
		map.put("postResults", result);
//		return JSONObject.fromObject(map); 
		System.out.println("已经获取到结果啦");
	}
	
	
	
	
}






























