<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

    <form action="<c:url value='/xsUpdate' />" method="get">
    <input name="cp" value="1">
    <button type="submit">提交</button> 
    </form>
    <form action="<c:url value='/yx' />" method="get">
    <button type="submit">提交2</button> 
    </form>
</body>
</html>
