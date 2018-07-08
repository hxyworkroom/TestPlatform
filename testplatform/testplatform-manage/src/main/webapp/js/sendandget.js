$(document).ready(function(){
  $("#buttontest").click(function(){
    alert("hello world");	
  });
});
//-----------------------------------------------------------------分割线---------------------------------------------------------

$(document).ready(function(){
  $(".jstest").click(function(){
    alert("成功！！！");	
  });
});

//-----------------------------------------------------------------分割线---------------------------------------------------------
//这个是ajax点击事情进行接收数据
$(document).ready(function(){ 
	$("#findAllUser").click(function(){
		var xmlhttp;
		if (window.XMLHttpRequest)
		{// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp=new XMLHttpRequest();
		}
		else
		{// IE6, IE5 浏览器执行代码
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				var userdata= eval("("+xmlhttp.responseText+")");
				//前端代码简直就是神经病啊！！！！！！！！！！！！！  非要加个eval才可以！！！！！！！神经病啊！！！！！！！！！！！！！！			
				for (var i = 0; i < userdata.length; i++) {
					var row=document.createElement('tr');
					var cro= document.createElement('td');
						cro.innerHTML =userdata[i].uid;					
					var cro1= document.createElement('td');
						cro1.innerHTML =userdata[i].uname;					
					var cro2= document.createElement('td');
						cro2.innerHTML =userdata[i].usex;						
					var cro3= document.createElement('td');
						cro3.innerHTML =userdata[i].uage;						
					var cro4= document.createElement('td');
						cro4.innerHTML =userdata[i].ueducate;						
					var cro5= document.createElement('td');
						cro5.innerHTML =userdata[i].umajor;						
					var cro6= document.createElement('td');
						cro6.innerHTML =userdata[i].ulocal;					
					var cro7= document.createElement('td');
						cro7.innerHTML =userdata[i].udepartment;				
					var cro8= document.createElement('td');
						cro8.innerHTML =userdata[i].uphone;
							row.appendChild(cro);
					row.appendChild(cro1);
					row.appendChild(cro2);
					row.appendChild(cro3);
					row.appendChild(cro4);
					row.appendChild(cro5);
					row.appendChild(cro6);
					row.appendChild(cro7);
					row.appendChild(cro8);
					var tbody= document.getElementById('tbmain');
					tbody.appendChild(row);
				}
			}
		}
		xmlhttp.open("GET","findAllUser",true,"json");
		xmlhttp.send();
	});
});
//-----------------------------------------------------------------分割线---------------------------------------------------------
//ajax带参数请求数据
$(document).ready(function(){ 
	$("#tjcxfindUserButton").click(function(){
		var condition=$("#tjfindUser").val();
		var data=$("#tjcxfindUser").val();
		$.ajax({  
            type : "POST",  
            url : "findUserByCondition",  
            data :JSON.stringify({"tj":condition,"datas":data}),  
            contentType : "application/json",  
            dataType : "json",  
            complete:function(msg) {  
            	var jsonData = eval("("+msg.responseText+")");
 				for (var i = 0; i < jsonData.length; i++) {
					var row=document.createElement('tr');
					var cro= document.createElement('td');
						cro.innerHTML =jsonData[i].uid;					
					var cro1= document.createElement('td');
						cro1.innerHTML =jsonData[i].uname;					
					var cro2= document.createElement('td');
						cro2.innerHTML =jsonData[i].usex;						
					var cro3= document.createElement('td');
						cro3.innerHTML =jsonData[i].uage;						
					var cro4= document.createElement('td');
						cro4.innerHTML =jsonData[i].ueducate;						
					var cro5= document.createElement('td');
						cro5.innerHTML =jsonData[i].umajor;						
					var cro6= document.createElement('td');
						cro6.innerHTML =jsonData[i].ulocal;					
					var cro7= document.createElement('td');
						cro7.innerHTML =jsonData[i].udepartment;				
					var cro8= document.createElement('td');
						cro8.innerHTML =jsonData[i].uphone;
							row.appendChild(cro);
					row.appendChild(cro1);
					row.appendChild(cro2);
					row.appendChild(cro3);
					row.appendChild(cro4);
					row.appendChild(cro5);
					row.appendChild(cro6);
					row.appendChild(cro7);
					row.appendChild(cro8);
					var tbody= document.getElementById('tbmain1');
					tbody.appendChild(row);
            	} 
            } 
        });  
	});
});
//-----------------------------------------------------------------分割线---------------------------------------------------------
//ajax发起get请求
$(document).ready(function(){ 
	$("#deleteUserButton").click(function(){
		var condition=$("#deleteUser").val();
		var data=$("#DeleteUser").val();
		$.ajax({  
            type : "POST",  
            url : "TYdeleteUser",  
            data :JSON.stringify({"tjd":condition,"datad":data}),  
            contentType : "application/json",  
            dataType :"String",  
            complete:function(msg) {  
            	//var jsonData = eval("("+msg.responseText+")");
				alert(msg.responseText);
            } 
        });  
	});
});
//-----------------------------------------------------------------分割线---------------------------------------------------------
//没有使用responsebody，只是通过ajax接收，返回字符串，也可以实现接收到str数据
//进行一次get请求
$(document).ready(function(){ 
	$("#getRequestA").click(function(){
		var url=$("#g_url_a").val();
		var param=$("#p_url_a").val();
		var cookie=$("#g_url_cookie").val();
		var refer=$("#p_url_refer").val();
		if (url==="") {
			$("#yz1").html("URL不可以为空！");
		}else{
			$("#yz1").html(" ");	
		}
		var u=url+"?"+param;
		alert("url是："+u);
		alert("cookie是:"+cookie+"~~~"+"refer是:"+refer);
		$.ajax({  
            type : "POST",  
            url : "GetA",  
            data :JSON.stringify({"url_complete":url,"param_complete":param,"cookie_complete":cookie,"refer_complete":refer}),  
            contentType : "application/json",  
            dataType : "json",  
            complete:function(msg) {  
            	var headmsg = eval("("+msg.responseText+")");                                                                                                                                                    
            	var nr = "<ul>";    
            	$.each(headmsg,function(name,value) {
            		nr = nr + "<li>"+ name + ":" + value +"</li>";
            	});
            	nr = nr + "</ul>";
            	$(".headmassage").html(nr);
            } 
        });  
	});
});
//-----------------------------------------------------------------分割线---------------------------------------------------------
//httpclient get 获取页面html代码
$(document).ready(function(){ 
	$("#getRequestAhtml").click(function(){
		alert("test");
		var url=$("#g_url_a").val();
		var param=$("#p_url_a").val();
		var cookie=$("#g_url_cookie").val();
		var refer=$("#p_url_refer").val();
		if (url==="") {
			$("#yz1").html("URL不可以为空！");
		}else{
			$("#yz1").html(" ");	
		}
		$.ajax({  
            type : "POST",  
            url : "GetHtml",  
            data :JSON.stringify({"url_complete":url,"param_complete":param,"cookie_complete":cookie,"refer_complete":refer}),  
            contentType : "application/json",  
            dataType : "json",  
            complete:function(msg) {  
            	var headmsg = eval("("+msg.responseText+")");                                                                                                                                                    
            	$(".getAhtml").html(headmsg.html);
            } 
        });  
	});
});
//-----------------------------------------------------------------分割线---------------------------------------------------------
//进行多参数测试
$(document).ready(function(){ 
	$("#getRequestAM").click(function(){
		alert("test");
		var url=$("#g_url_am").val();
		var cookie=$("#g_url_cookiem").val();
		var refer=$("#p_url_referm").val();
		var dz=$("#p_url_location").val();
		var rf=$("#R_url_location").val();
		if (url==="") {
			$("#yz2").html("URL不可以为空！");
		}else{
			$("#yz2").html(" ");	
		}
		$.ajax({  
            type : "POST",  
            url : "GetMoreParamTest",  
            data :JSON.stringify({"url_complete":url,"cookie_complete":cookie,"refer_complete":refer,"location_complete":dz,"result_complete":rf}),  
            contentType : "application/json",  
            dataType : "json",  
            complete:function(msg) { 
            	var msge = eval("("+msg.responseText+")"); 
            	if (msge.result==="ok") {					
            		alert("测试结束,请查看结果文档");
				}else{
					alert("好像发生了什么异常，请检查后，再次测试");					
				}
            } 
        });  
	});
});
//-----------------------------------------------------------------分割线---------------------------------------------------------
//Jsoup  获取html页面
$(document).ready(function(){ 
	$("#getHtml").click(function(){
		alert("test");
		var url=$("#jsoupUrlGetHtml").val();
		var location=$("#saveLocation").val();

		if (url==="") {
			$("#yz3").html("URL不可以为空！");
		}else{
			$("#yz3").html(" ");	
		}
		$.ajax({  
            type : "POST",  
            url : "getHtml",  
            data :JSON.stringify({"getHtmlUrl":url,"saveLocation":location}),  
            contentType : "application/json",  
            dataType : "txt",  
            complete:function(msg) { 
            	var msge = eval("("+msg.responseText+")"); 
            	if (msge.result==="ok") {					
            		alert("测试结束,请查看结果文档");
				}else{
					alert("好像发生了什么异常，请检查后，再次测试");					
				}
            } 
        });  
	});
});
//-----------------------------------------------------------------分割线---------------------------------------------------------
//Jsoup 获取页面图片
$(document).ready(function(){ 
	$("#getImg").click(function(){
		alert("test");
		var url=$("#GetImgUrls").val();
		var location=$("#GetImgSave").val();

		if (url==="") {
			$("#yz3").html("URL不可以为空！");
		}else{
			$("#yz3").html(" ");	
		}
		$.ajax({  
            type : "POST",  
            url : "getImgs",  
            data :JSON.stringify({"GetImgUrls":url,"GetImgSave":location}),  
            contentType : "application/json",  
            dataType : "txt",  
            complete:function(msg) { 
            	var msge = eval("("+msg.responseText+")"); 
            	if (msge.result==="ok") {					
            		alert("测试结束,请查看结果文档");
				}else{
					alert("好像发生了什么异常，请检查后，再次测试");					
				}
            } 
        });  
	});
});



















//-----------------------------------------------------------------分割线---------------------------------------------------------






