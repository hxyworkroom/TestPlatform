package cn.hy.testplatform.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class HttpClientSendTestUtlis {
	private Map map;
	private BufferedReader in = null; 
	private FileWriter out = null;  
	private byte[] hz = new byte[1024];        
	private String line;
	public Map getSubmit(String url) throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();//获取httpclient对象
		HttpGet httpGet = new HttpGet(url);//发起一个httpClientGET请求，创建一个get请求对象
		CloseableHttpResponse response = httpclient.execute(httpGet);//发起请求
		try {
		    System.out.println(response.getStatusLine());//这里获取的是返回头信息  获取响应状态
		    System.out.println(response.toString());
		    
			HeaderIterator head= response.headerIterator();
			map =new HashMap<String, String>(); 
			while(head.hasNext()){
				String str[]=(head.next().toString()).split(":");
//				System.out.println("第一个："+str[0]+","+"第二个："+str[1]);	
				map.put(str[0],str[1]);
			}
			map.put("请求状态",response.getStatusLine().toString());
		    System.out.println("查看map："+map.toString());
		    System.out.println("查看map大小："+map.size());
		} finally {
		    response.close();
		}
		return map;
	}
	public Map getSubmit(String url,String cookie,String refer) throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();//获取httpclient对象
		HttpGet httpGet = new HttpGet(url);//发起一个httpClientGET请求，创建一个get请求对象
		
		httpGet.setHeader("Cookie",cookie);     
		httpGet.setHeader("refer",refer);
		
		CloseableHttpResponse response = httpclient.execute(httpGet);//发起请求
		try {
		    System.out.println(response.getStatusLine());//这里获取的是返回头信息  获取响应状态
		    System.out.println(response.toString());
		    
			HeaderIterator head= response.headerIterator();
			map =new HashMap<String, String>(); 
			while(head.hasNext()){
				String str[]=(head.next().toString()).split(":");
//				System.out.println("第一个："+str[0]+","+"第二个："+str[1]);	
				map.put(str[0],str[1]);
			}
			map.put("请求状态",response.getStatusLine().toString());
		    System.out.println("查看map："+map.toString());
		    System.out.println("查看map大小："+map.size());
		} finally {
		    response.close();
		}
		return map;
	}
	public Map<String,String> getHtml(String url) throws Exception{
		Map map=new HashMap();
		HttpGet httpGet = new HttpGet(url);//
		//创建访问对象
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
		//socket超时 //connect超时
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
		//创建httpclient对象，并添加时间限制
				
		CloseableHttpResponse response = httpClient.execute(httpGet);
		 //发起请求
		 
		String htmls=EntityUtils.toString(response.getEntity(), "utf-8");
		map.put("html",htmls);
		return map;
	}
	
	public Boolean GetMoreParamTest(String fileLocation,String resultLocation,String url,String cookie,String refer) throws Exception {
		if (new File(fileLocation).isFile()) {
			File resultfile = new File(resultLocation);
			//创建结果输出文件
			try {
				resultfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			try {
				in = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocation),"UTF-8"));
	            out = new FileWriter(resultLocation, true);     
				while ((line = in.readLine()) != null) {
					String testUrl = url + line;
					String title = testUrl+"测试结果是:";
					out.write(title);
					out.write("\r\n");
					String result = null;
					if (cookie=="" && refer=="") {
						result = getMoreParamSubmit(testUrl);
					}else {
						result = getMoreParamSubmitWithHead(testUrl,cookie,refer);
					}
					System.out.println("~~第二段打印~~："+result.toString());
					out.write(result);
					out.write("\r\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally {
				out.close();
				in.close();
			}
			return true;
		}else {
			return false;
		}
	}
	public String getMoreParamSubmit(String url) throws Exception{
		String result;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		try {
			result = new String(response.toString());
		} finally {
			response.close();
		}
		return result;
	}
	public String getMoreParamSubmitWithHead(String url,String cookie,String refer) throws Exception{
		String result;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Cookie",cookie);  
		httpGet.setHeader("refer",refer);  
		CloseableHttpResponse response = httpclient.execute(httpGet);
		try {
			result = new String(response.toString());
		} finally {
			response.close();
		}
		return result;
	}
//post请求用于请求json格式的参数
	public String postSendSubmitJson(String url,String params) {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost request = new HttpPost(url);  
		request.setHeader("Accept", "application/json");   
		request.setHeader("Content-Type", "application/json");  
        String charSet = "UTF-8";  
        StringEntity entity = new StringEntity(params, charSet); 
        request.setEntity(entity); 
		try {
            response = httpclient.execute(request);  
            StatusLine status = response.getStatusLine();  
            int state = status.getStatusCode(); 
            if (state == HttpStatus.SC_OK) {  
                HttpEntity responseEntity = response.getEntity();  
                String jsonString = EntityUtils.toString(responseEntity);  
                return jsonString;  
            }  
            else{  
                 return "请求返回:"+state+"("+url+")";  
            }  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {  
            if (response != null) {  
                try {  
                    response.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;   
	}
	
}
