<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎来到英雄联盟！</title>
<link rel="stylesheet" href="../css/hero_01.css" />
<script type="text/javascript">
function mycheck()
{
	if(form1.userName.value==""){
		alert("用户名不能为空，请输入用户名！");
		form1.userName.focus();
		return;
	}
	if(form1.password.value==""){
		alert("密码不能为空，请输入密码！");
		form1.password.focus();
		return;
	}
	if(form1.validationCode.value==""){
		alert("验证码不能为空，请输入验证码！");
		form1.validationCode.focus();
		return;
	}
	if(form1.validationCode.value!=form1.validationCode1.value){
		alert("请输入正确的验证码！");
		form1.validationCode.focus();
		return;
	}
	form1.submit1();
	}
</script>
</head>
	<body>
        	<div id="star_bg">
        		<div id="star_img_dv"><img id="star_img" src="../img/star.jpg" /></div>
        		<div id="line"><img id="line_img" src="../img/line.jpg"/></div>
        		<div id="login">

        		</div>
        		<div id="login_desc">
        			<form name="form1" method="post" action="hero_01.jsp">
        			  <br />
        			  <h1>英雄，去超越！</h1>
        			  <bb>用&nbsp;&nbsp;&nbsp; 户：</bb><input type="text" name="userName"/>
        			  <br />
        			  <br />
        			  <bb>密&nbsp;&nbsp;&nbsp; 码：</bb><input type="password" name="password"/>
        			  <br />
        			  <br />
        			  <bb>验证码： </bb><input type="text" name="validationCode" 
        			  onKeyDown="if(event.keyCode==13){form1.submit.focus();}" size="4"/>　　　　　　　　　　　
                      <%
                      int intmethod1=(int)((((Math.random())*11))-1);
                      int intmethod2=(int)((((Math.random())*11))-1);
                      int intmethod3=(int)((((Math.random())*11))-1);
                      int intmethod4=(int)((((Math.random())*11))-1);
                      String intsum=intmethod1+""+intmethod2+intmethod3+intmethod4;
                      %>
                      <input type="hidden" name="validationCode1" value="<%=intsum%>">

        			  <br />
        			  <br />
        			  <bb>
        			     <cc onclick="mycheck()"><img id="c1" src="../img/login.jpg"/></cc>&nbsp;&nbsp;&nbsp;
        			  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <a href="zhuce.jsp"><img id="c1" src="../img/register.jpg"></a>
                      </bb>
                      </form>
         
        		</div>
        		<div id="yz">
                  <img src="../img/<%=intmethod1 %>.gif">
                  <img src="../img/<%=intmethod2 %>.gif">
                  <img src="../img/<%=intmethod3 %>.gif">
                  <img src="../img/<%=intmethod4 %>.gif">
                </div>
        			
        		<div id="logo"><img id="logo_img" src="../img/min_logo.png"/></div>
        	
        		
        		
        	</div>
	</body>
</html>