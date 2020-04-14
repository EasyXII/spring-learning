<%@ page import="blog.vo.*"%>
<%@ page import="java.util.*"%>
<%@ page import="blog.dao.*"%>
<%@ page import="blog.daoImpl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>关于博主</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<style type="text/css">
html, body {
	height: 100%;
}

.about {
	height: 100%;
}

#foot {
	position: relative;
	bottom: 0;
	text-align: center;
	width: 100%;
	height: 61px;
}
</style>
</head>
<body>
	<center>
		<div id="head"></div>
		<table border="1" width="80%" height="600px">
			<%
					BloggerDAO blogger = new BloggerDAOImpl();
					ArrayList<Blogger> list = null;
					list = blogger.findAll();
					for (Blogger blg : list) {
				%>
				<br>
				<tr>
					<td align="center">博主ID</td>
					<td><%=blg.getId()%></td>
				</tr>
				<br>
				<tr>
					<td align="center">博主昵称</td>
					<td><%=blg.getName()%></td>
				</tr>
				<br>
				<tr>
					<td align="center">博主邮箱</td>
					<td><%=blg.getEmail()%></td>
				</tr>
				<br>
				<tr>
					<td align="center">个性签名</td>
					<td><%=blg.getSignature()%></td>
				</tr>
				<br>
				<tr>
					<td align="center">头像</td>
					<td><img src="<%=blg.getImage()%>"></td>
				</tr>
			<%} %>
		</table>
		<div id="foot"></div>
		<script type="text/javascript">
			$("#head").load("head.jsp");
			$("#foot").load("foot.html");
		</script>
	</center>
</body>
</html>