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
	$("#return").hide();
	$("#delete").click(function(){
		$("#add").hide();
		$("#delete").hide();
		$("#return").show();
		$("button").show();
	});
});

$(function(){
	$("#return").click(function(){
		$("#add").show();
		$("#delete").show();
		$("button").hide();
		$("#return").hide();
	});
	$("#addhero").hide();
	$("#add").click(function(){
		$("#addhero").show();
		$("#yx").hide();
	});
	$("#queren").click(function(){
		$("#myform").submit();
		
	});
});

</script> 
<SCRIPT language=JavaScript type=text/JavaScript>
var XMLHttpReq = false;
function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
       XMLHttpReq = new XMLHttpRequest();
    }else if(window.ActiveXObject){
       try{
           XMLHttpReq = new ActiveXObject("MSXML2.XMLHTTP");
       }catch(e){
           try{
              XMLHttpReq = new ActiveXObject("Mircsoft.XMLHTTP");
           }catch(e1){}
       }
    }
}
function sendRequest(url){
    createXMLHttpRequest();
    XMLHttpReq.open("GET",url,true);
    XMLHttpReq.onreadystatechange = processResponse;
    XMLHttpReq.send(null);
}
function userCheck(){
    var herosName = document.myform.herosName.value;
    if(herosName == ""){
       window.alert("用户名不能为空");
       document.myform.herosName.focus();
       return false;
    }else{
       sendRequest("yx?herosName="+herosName);
    }
}
</SCRIPT>
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
					int currentPage=0;
					for(Hero_yx ceshi:heros_yx){
						currentPage=ceshi.getCurrentPage();
					}
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
				   
				    <script language="javascript">
	 function openPage(curpage){
	  document.form1.cp.value=curpage;
	  document.form1.submit();
 }
	 function openPage1(curpage){
		  document.form1.cp.value=curpage-1;
		  document.form1.submit();
	 }
	 function openPage2(curpage){
		  document.form1.cp.value=curpage+1;
		  document.form1.submit();
	 }
 </script>
				   <div style="position: relative;bottom: -200px;left:280px;float: left;">
				      <form action="<c:url value='/yx' />" method="get" name="form1">
					    <input name="button1" type="button" value="首页"onClick="openPage(1)">				
					    <input name="button2" type="button" value="上一页" onClick="openPage1(<%=currentPage %>)">
				        <input name="button3" type="button" value="下一页" onClick="openPage2(<%=currentPage %>)">
				        <input name="button4" type="button" value="尾页">
				        <input name="cp" type="hidden" value="" />
				     </form>
				  </div>
				
				   <div id="B" style="float:left; padding-top: 10px;padding-left: 380px">
				   <img id="add" src="image-yx/add.jpg" width="80" height="80" style="padding-left: 50px"/>
				   <br />
				   <br />
				        <img id="delete" src="image-yx/delete.jpg"  />&nbsp;&nbsp;&nbsp;
				        <img id="return" src="image-yx/return.jpg"  />
				   </div>

			</div>
							 <!-- 添加  -->
				 <div id="addhero" style="width: 100%; height: 80%;text-align: center;">
                     <form action="<c:url value='/yx' />" method="post" name="myform" id="myform">
                     <h1><font color="red">英雄人物添加</font></h1>
                        <p><font color="red">英雄名字：</font> <input name="herosName" onblur="userCheck()"></p>
                        <p><font color="red">英雄称号： </font><input name="herosNickName"> </p>
                        <p><font color="red">英雄图标： </font><input type="file" name="herosImgM"></p>
                        <p><font color="red">英雄图片： </font><input type="file" name="herosImgB"></p> 
                        <p><font color="red">英雄背景：</font> <textarea rows="10" cols="20" name="herosDesc"></textarea></p> 
                        <p><img id="queren" alt="" src="<c:url value='/img/sure.jpg' />"></p>
                     </form>
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
