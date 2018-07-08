<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<title>Jsoup页面</title>
	<link rel="stylesheet" href="../css/systemteststyle.css" type="text/css"/>
	<script type="text/javascript" src="../js/sendandget.js"></script>
</head>
<body>
	<h1>Jsoup测试页面</h1>
	<hr/>
	<p><button id="buttontest" class="buttons">测试js生效否</button><br/></p>
	<p><a class="jstest" href="javascript:void(0)">js测试</a><br/></p>
	<hr/>
	<div>
		<span>
			<p>Urls:　<input type="text" id="jsoupUrlGetHtml"/></p>
			<p>Save:　<input type="text" id="saveLocation"/><span id="yz3"></span></p>
			<p><button id="getHtml"  class="buttons">获取html</button><br/></p>
		</span>
	</div>
	<hr/>
<!-- --------------------------------------------------------------------------------------------------- -->
	<div>
		<span>
			<p>GetImgUrls:　<input type="text" id="GetImgUrls"/><span id="yz3"></span></p>
			<p>GetImgSave:　<input type="text" id="GetImgSave"/></p>
			<p><button id="getImg"  class="buttons">获取页面图片</button><br/></p>
		</span>
	</div>
	<hr/>
</body>
</html>