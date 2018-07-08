<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<title>HttpClient模式测试页面</title>
	<link rel="stylesheet" href="../css/systemteststyle.css" type="text/css"/>
	<script type="text/javascript" src="../js/sendandget.js"></script>
</head>
<body>
	<h1>HttpClient模式测试页面</h1>
	<hr/>
	<p><button id="buttontest" class="buttons">测试js生效否</button><br/></p>
	<hr/>
	<!-- 发起get请求 -->
	<div>
		<span>
			<div>
				<p>
					<h>URLMigs：<input type="text" class="putin" name="get_request_url_a" id="g_url_a"></input><span id="yz1"></span></h>
					<h>PARS：<input type="text" class="putin" name="get_request_par_a" id="p_url_a"></input></h>
					<h><button id="getRequestA"  class="buttons">发送get请求</button><button id="getRequestAhtml"  class="buttons">获取页面代码</button><br/></h>
				</p>
				<p>
					<h>COOKies：<input type="text" class="putin" name="get_request_url_a" id="g_url_cookie"></input></h>
					<h>RAFR：<input type="text" class="putin" name="get_request_par_a" id="p_url_refer"></input></h>
				</p>
			
			</div>
		</span>
		<span class="headmassage"></span>
		<span class="getAhtml"></span>
	</div>
<!--  ·············································· 分割线 ·············································· -->
<!--  ·············································· 分割线 ·············································· -->
	<hr/>
		<p>多参数Get提交 </p>
		<div>
			<span>
				<div>
					<p>
						<h>URLMigs：<input type="text" class="putin" name="get_request_url_am" id="g_url_am"></input><span id="yz2"></span></h>
						<h>PARS：<input type="text" class="putin" name="get_request_par_am" id="p_url_am" placeholder="统一在文件中添加配置"></input></h>
						<h><button id="getRequestAM"  class="buttons">进行get测试</button><br/></h>
					</p>
					<p>
						<h>COOKies：<input type="text" class="putin" name="get_request_url_am" id="g_url_cookiem"></input></h>
						<h>RAFR：<input type="text" class="putin" name="get_request_par_am" id="p_url_referm"></input></h>
						<h>Template_File_Localtion：<input type="text" class="putin" name="get_request_par_am" id="p_url_location"></input></h>
						<h>Resultss_File_Localtion：<input type="text" class="putin" name="get_request_par_am" id="R_url_location"></input></h>
					</p>
					<p>测试结果保存在参数文件处</p>
				</div>
			</span>
			<span class="headmassagem"></span>
		</div>
	<hr/>
<!--  ·············································· 分割线 ·············································· -->
	<div>
		<p>Post提交测试</p>
		<div>
			<p>
				<h>URLMigs：<input type="text" class="putin" name="post_request_url_am" id="g_url_post"></input><span id="yz3"></span></h>
				<h>PARS：<input type="text" class="putin" name="post_request_par_am" id="p_url_post"></input></h>
				<h><button id="postRequest"  class="buttons">进行Post测试</button><br/></h>
			</p>
		</div>
<!--  ·············································· 分割线 ·············································· -->
	<hr/>

</body>
</html>