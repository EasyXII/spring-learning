<%@page import="java.util.ArrayList"%>
<%@ page import="blog.util.*"%>
<%@ page import="blog.util.SplitPage" %>
<%@ page import="blog.vo.*" %>
<%@ page import="blog.dao.*" %>
<%@ page import="blog.daoImpl.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>type</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<style type="text/css">
.body {
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
    <center>
<h1><strong>这里是<%=request.getParameter("parm")%>的专区</strong></h1>
</center>
<table width="80%"  height="500px" border="1" cellpadding="0" align="center">
	                   <tr>
							<td align="center">作者</td>
							<td align="center">内容</td>
							<td align="center">题目</td>
							<td align="center">类型</td>
							<td align="center">发表时间</td>
						</tr>
<%
    String type = request.getParameter("parm");
    BlogDAO blogDAO = new BlogDAOImpl();
 	ArrayList<Blog> list =blogDAO.queryByType(type);
 	 for(Blog blog:list){
%>
    <br><tr >
        <td><%=blog.getAuthor()%></td>
        <td><%=blog.getContent()%></td>
        <td><%=blog.getTitle()%></td>
        <td><%=blog.getType()%></td>
        <td><%=blog.getTime()%></td>
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