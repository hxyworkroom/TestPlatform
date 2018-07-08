package cn.hy.testplatform.manage.pojo;

public class HttpClientPost {
	private String Content_type;
	private String Cookie;
	private String User_Agent;
	private String url;
	private String params;
	
	public HttpClientPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getContent_type() {
		return Content_type;
	}
	public void setContent_type(String content_type) {
		Content_type = content_type;
	}
	public String getCookie() {
		return Cookie;
	}
	public void setCookie(String cookie) {
		Cookie = cookie;
	}
	public String getUser_Agent() {
		return User_Agent;
	}
	public void setUser_Agent(String user_Agent) {
		User_Agent = user_Agent;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "HttpClientPost [Content_type=" + Content_type + ", Cookie=" + Cookie + ", User_Agent=" + User_Agent
				+ ", url=" + url + ", params=" + params + "]";
	}
}
