<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>英雄大全</title>
<script type="text/javascript"> 
function showPic(){
var x,y; 
x = event.clientX; 
y = event.clientY;
document.getElementById("tip_htext").style.left = x; 
document.getElementById("tip_htext").style.top = y; 
document.getElementById("tip_htext").style.display = "block"; 
} 
function hiddenPic(){
document.getElementById("tip_htext").style.display = "none"; 
} 
</script> 

</head>
<body>

    <div id="tip_htext" style="display:none;position:absolute;z-index:1;width: 250px;
    	height: 150px; background-color: #285E8E;opacity: 0.9;">
		<img src="../image-yx/s003.jpg"><font color="greenyellow" size="5">LOL维克兹</font><br />
			<font size="3" color="yellow">称号:虚空之眼</font><br />
			<strong>点券:4500&nbsp;金币:7800<br />
			“教会别人取火，等于教会了别人纵火。”——维克兹。</strong>
	</div>
    <img id="1" src="../image-yx/s001.jpg" width="50" height="50" onMouseMove="showPic();" onMouseOut="hiddenPic();"><br />
    <br /><br />
	<img id="2" src="../image-yx/s002.jpg" width="50" height="50" onMouseMove="showPic();" onMouseOut="hiddenPic();"><br /> 
	<br /><br />
	<img id="3" src="../image-yx/s003.jpg" width="50" height="50" onMouseMove="showPic();" onMouseOut="hiddenPic();"><br />
	<br /><br />
	<img id="4" src="../image-yx/s004.jpg" width="50" height="50" onMouseMove="showPic();" onMouseOut="hiddenPic();"> 
</body>
</html>