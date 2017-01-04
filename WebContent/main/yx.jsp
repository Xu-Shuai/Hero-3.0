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
<script src="<c:url value='/js/jquery-1.8.3.js' />"></script>

<script type="text/javascript">
$(function(){
	$("#delete").click(function(){
		$("button").show();
	});
});

$(function(){
	$("#return").click(function(){
		$("button").hide();
	});
})

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
					<div id="A">
						<table>
							<tr>
								<td><a href="hero_delete?herosID=<c:url value='${hero_yx1.herosID }' />"><img src="<c:url value='${hero_yx1.herosImgM }' />" width="80" height="80" onmousemove="showPic();" onmouseout="hiddenPic();" /></a></td>
							</tr>
							<tr>
								<td><a href="hero_delete?herosID=<c:url value='${hero_yx1.herosID }' />"><c:out value="${hero_yx1.herosName }" /></a></td>
							</tr>
							<tr>
							
							    <td>
							    <form action="<c:url value='/hero_delete' />" method="post">
							    <input value="<c:url value='${hero_yx1.herosID }' />" type="hidden" name="herosID">
							    <button style="display: none;" type="submit">删除</button>
							    </form>
							    </td>
							</tr>
						</table>
					</div>
				</c:forEach>
				<img id="add" src="image-yx/add.jpg" width="80" height="80" style="float: left;padding-left: 25px;padding-top: 35px"  />
				<div style="float:left; padding-top: 50px;padding-left: 270px">
				<img id="delete" src="image-yx/delete.jpg"  />&nbsp;&nbsp;&nbsp;
				<img id="return" src="image-yx/return.jpg"  />
				</div>
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
