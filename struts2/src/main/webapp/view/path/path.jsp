<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>path</title>
</head>
<body>
path

<a href="index.html">index</a>
<p>中方乱码  
<form action="user/user!add" method="post">
	<input type="text" name="user.name">
	<input type="submit" value="submit"/>
</form>
</body>
</html>