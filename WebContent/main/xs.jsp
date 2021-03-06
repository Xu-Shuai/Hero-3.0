<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.MyEquipment"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>英雄联盟助手_V3.0</title>
<link rel="stylesheet" href="<c:url value='/css/hero_hd.css' />" />
<script src="<c:url value='/js/jquery-1.8.3.js' />"></script>

<script type="text/javascript">
$(function(){
	$("#tab2").hide();
	$("#tab3").hide();
	$("#btn").click(function(){
		$("#tab1").hide();
		$("#tab2").show();
		$(this).remove();
		
	});
	$("#btn2").click(function(){
		$("#form").submit();
	});
	$("#add").click(function(){
		$("#tab3").show();
		$("#tab1").hide();
	});
	$("#queren").click(function(){
		$("#myform").submit();
		
	});
	$("#select").click(function(){
		$("#oneSelect").submit();
		
	});
})

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
    var name = document.myform.name.value;
   
    if(name == ""){
       window.alert("装备名不能为空");
       
       document.myform.name.focus();
       return false;
    }else{
       sendRequest("xs?id="+name);
    }
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
			<!-- 显示所有装备 -->
			<div id="xs01" align="center">
				<%
					ArrayList<MyEquipment> myEquipments = new ArrayList<MyEquipment>();
					myEquipments = (ArrayList<MyEquipment>) request.getAttribute("myEquipments");
					int currentPage=0;
					for(MyEquipment cheshi:myEquipments){
						currentPage=cheshi.getCurrentPage();
					}
				%>
				<c:set value="${myEquipments}" var="Equipments" />

				<c:forEach items="${Equipments }" var="myEquipment">
					<div id="tab">
						<table>
							<tr>
								<td><a
									href="http://localhost/Hero/xs?id=<c:url value='${myEquipment.id }' />"><img
										src="<c:url value='${myEquipment.imgId }' />"
										style="width: 50px; height: 50px;" /></a></td>
							</tr>
	
							<tr>
								<td align="center"><a
									href="http://localhost/Hero/xs?id=<c:url value='${myEquipment.id }' />"><c:out
											value="${myEquipment.name }" /></a></td>
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
 <div style="position: relative;bottom: -90px;left:100px;float: left;">
 <form action="<c:url value='/OneSelect' />" id="oneSelect">
<p> 
<input type="text" name="name" style="width: 150px;height: 30px;position: relative;top: -10px"> 
<img id="select" alt="" src="<c:url value='/img/select.jpg' />" style="width: 120px;height: 30px;">
<img id="add" alt="" src="<c:url value='/img/add.jpg' />" style="width: 120px;height: 30px;">
</p>
 </form>
				<form action="<c:url value='/xsUpdate' />" method="get" name="form1">
					<input name="button1" type="button" value="首页"onClick="openPage(1)">				
					<input name="button2" type="button" value="上一页" onClick="openPage1(<%=currentPage %>)">
				    <input name="button3" type="button" value="下一页" onClick="openPage2(<%=currentPage %>)">
				    <input name="button4" type="button" value="尾页">
				    <input name="cp" type="hidden" value="" />
				</form>
				</div>
			</div>
			<!-- 显示一个装备的信息-->
			<div id="xs02" align="center">
				<%
					ArrayList<MyEquipment> oneEquipments = new ArrayList<MyEquipment>();
					oneEquipments = (ArrayList<MyEquipment>) request.getAttribute("oneEquipments");
				%>
				<c:set value="${oneEquipments}" var="oneEquipments" />

				<c:forEach items="${oneEquipments }" var="oneEquipment">
					<div id="tab1" style="width: 100%; height: 90%;">
						<table>
							<tr>
								<td>
									<div
										style="border-left: 30px solid black; border-top: 30px solid black; float: left;"
										align="center">
										<a href="#"><img
											src="<c:url value='${oneEquipment.imgId }' />" /></a>
									</div>
									<div
										style="border-left: 20px solid black; border-top: 30px solid black; float: left;">
										<a href="#"><c:out value="${oneEquipment.name }" /></a><br />

										<c:set value="${fn:split(oneEquipment.sx ,' ') }" var="strs" />
										<c:forEach items="${strs }" var="str">
											<a href="#"><c:out value="${str }" /></a>
											<br />
										</c:forEach>

									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div>
										<c:set value="${fn:split(oneEquipment.bd ,' ') }" var="strs01" />
										<c:forEach items="${strs01 }" var="str01">
											<a href="#"><c:out value="${str01 }" /></a>
											<br />
										</c:forEach>
										
									</div>
								</td>
							</tr>

						</table>
						<br/>
						<br/>
						<br/><br/>
						<p><img id="btn"  src="<c:url value='/img/update.jpg' />" style="width: 120px;height: 30px;">
						<img id="add" alt="" src="<c:url value='/img/add.jpg' />" style="width: 120px;height: 30px;">
						</p>
					</div>
				</c:forEach>
				<!-- 修改 -->

				<c:set value="${oneEquipments}" var="Equipmentsxg" />

				<c:forEach items="${Equipmentsxg }" var="Equipmentsxg">
					<div id="tab2" style="width: 100%; height: 90%;">
						<form action="<c:url value='/xsUpdate' />" method="post" id="form">
							<table>
								<tr>
									<td>
										<div
											style="border-left: 30px solid black; border-top: 30px solid black; float: left;"
											align="center">
											<a href="#"><img
												src="<c:url value='${Equipmentsxg.imgId }' />" /></a>
										</div>
										<div
											style="border-left: 20px solid black; border-top: 30px solid black; float: left;">
											<a href="#"> <input
												value="<c:out value='${Equipmentsxg.name}' />" name="name"></a><br />
											<input name="id"
												value="<c:out value='${Equipmentsxg.id }' />" type="hidden" />


											<a href="#"><input
												value="<c:out value='${Equipmentsxg.sx}' />" name="sx"></a><br />


										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div>

											<textarea
												style="width: 80%; height: 120px; background: black; color: yellow;"
												name="bd"><c:out value="${Equipmentsxg.bd }" />
								</textarea>
										</div>
									</td>
								</tr>

							</table>
							<br /> <br /> <br /> <br /> <br /> <br />
							<img id="btn2" alt="" src="<c:url value='/img/sure.jpg' />" >
						</form>
						
					</div>
				</c:forEach>

         <!-- 添加  -->
         <div id="tab3" style="width: 100%; height: 90%;">
         <form action="<c:url value='/xs' />" method="post" name="myform" id="myform">
        <p>装备名字： <input name="name" onblur="userCheck()"></p>
        <p>装备图片： <input type="file" name="image"> </p>
        <p>装备属性： <textarea rows="5" cols="20" name="sx"></textarea></p>
        <p>装备被动： <textarea rows="10" cols="20" name="bd"></textarea></p>
        <p><img id="queren" alt="" src="<c:url value='/img/sure.jpg' />" style="width: 120px;height: 30px;"></p>
         </form>
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
