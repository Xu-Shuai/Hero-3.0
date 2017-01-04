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
					ArrayList<Hero_yx> oneheros_yxs = new ArrayList<Hero_yx>();
					oneheros_yxs = (ArrayList<Hero_yx>) request.getAttribute("oneheros_yx1");
				%>
				
				<c:set value="<%=oneheros_yxs%>" var="oneheros_yx" />

				<c:forEach items="${oneheros_yx }" var="oneheros_yx">
					<div id="A">
						<table>
							<tr>
								<td><img src="<c:url value='${oneheros_yx.herosImgB }' />" width="150" height="271"  /></td>
							</tr>
							<tr>
								<td><font size="5" color="greenyellow">LOL <c:out value="${oneheros_yx.herosName }" /></font></td>
							</tr>
							<tr>
								<td><font size="3" color="yellow">称号：</font><c:out value="${oneheros_yx.herosNickName }" /></td>
							</tr>
							<tr>
								<td>
								  <div id="a" style="margin-left:100px; width: 700px; text-align: left;">
								    <font size="3" color="yellow">英雄背景：</font><c:out value="${oneheros_yx.herosDesc }" />
								  </div>
								</td>
							</tr>
							<tr>
							    <td></td>
							</tr>
							<tr>
							    <td><form action="<c:url value='/yx' />" method="get">
                                       <button type="submit">返回</button> 
                                    </form>
                                </td>
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
