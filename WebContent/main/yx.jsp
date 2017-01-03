<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Hero_yx"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>英雄联盟助手_V3.0</title>
<link rel="stylesheet" href="<c:url value='/css/hero_hd.css' />" />
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
	<div id="star_bg">
		<div id="star_img_dv">
			<img id="star_img" src="<c:url value='/img/star.jpg' />" />
		</div>
		<div id="daohang"></div>
	</div>
	<div id="c1" class="dv_top">
		<a href="#">首页</a>
	</div>
	<div id="c2" class="dv_top">
		<a href="#">英雄属性</a>
	</div>
	<div id="c3" class="dv_top">
		<a href="#">英雄信息</a>
	</div>
	<div id="c4" class="dv_top">
		<a href="#">英雄装备</a>
	</div>
	<div id="c5" class="dv_top">
		<a href="#">关于其他</a>
	</div>

	<div id="lo">
		<img id="loimg" src="<c:url value='/img/min_logo.png' />"
			height="130px" width="220px" />
	</div>

	<div id="main_desc">
		<img src="<c:url value='/img/ty_x.png' />" width="1020px"
			height="650px" />
		<!-- 这是写自己的主要内容的地方 -->
		<div id="desc">
			<div id="yx">

				<%
					ArrayList<Hero_yx> heros_yx = new ArrayList<Hero_yx>();
					heros_yx = (ArrayList<Hero_yx>) request.getAttribute("heros_yx");
				%>
				<c:set value="<%=heros_yx%>" var="hero_yx" />

				<c:forEach items="${hero_yx }" var="hero_yx1">
				    <div id="tip_htext" style="display:none;position:absolute;z-index:1;width: 250px;
    	            height: 150px; background-color: #285E8E;opacity: 0.9;">
		            <img src="<c:url value='${hero_yx1.herosImgM}' />">
		            <font color="greenyellow" size="5">LOL维克兹</font><br />
		        	<font size="3" color="yellow">称号:虚空之眼</font><br />
		        	<strong>点券:4500&nbsp;金币:7800<br />
			        “教会别人取火，等于教会了别人纵火。”——维克兹。</strong>
	                </div>
					<div id="A">
						<table>
							<tr>
								<td><a href="#"><img src="<c:url value='${hero_yx1.herosImgM }' />" width="80" height="80" onmousemove="showPic();" onmouseout="hiddenPic();" /></a></td>
							</tr>
							<tr>
								<td><a href="#"><c:out value="${hero_yx1.herosName }" /></a></td>
							</tr>

						</table>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<div id="menu1">
		<a href="#">我的专区</a>
	</div>
	<div id="menu2">
		<a href="#">英雄社区</a>
	</div>
	<div id="menu3">
		<a href="#">好友动态</a>
	</div>
	<div id="menu4">
		<a href="#">热门资讯</a>
	</div>
	<div id="menu5">
		<a href="#">赛季信息</a>
	</div>

	</div>

</body>
</html>
