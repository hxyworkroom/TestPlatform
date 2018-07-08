function getQuickStart()
{
	var h = $(window).height();
	var hin = h*0.82+40;
	document.getElementById("r").innerHTML="<iframe style='height:"+ hin + "px' class='ifsx' src='../testplatform-manage/quickstart.html'></iframe>";
	document.getElementById("r").style.height=hin+"px";
}
function getSystemTest()
{
	var h = $(window).height();
	var hin = h*0.82+40;
	document.getElementById("r").innerHTML="<iframe style='height:"+ hin + "px' class='ifsx' src='../testplatform-manage/system.html'></iframe>";
	document.getElementById("r").style.height=hin+"px";
}

function getHttpClientTest()
{
	var h = $(window).height();
	var hin = h*0.82+40;
	document.getElementById("r").innerHTML="<iframe style='height:"+ hin + "px'  class='ifsx' src='../testplatform-manage/httpclient.html'></iframe>";
	document.getElementById("r").style.height=hin+"px";
}

function getJsoupTest()
{
	var h = $(window).height();
	var hin = h*0.82+40;
	document.getElementById("r").innerHTML="<iframe style='height:"+ hin + "px'  class='ifsx' src='../testplatform-manage/Jsoup.html'></iframe>";
	document.getElementById("r").style.height=hin+"px";
}

