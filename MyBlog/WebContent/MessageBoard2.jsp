<%@ page import="java.util.ArrayList"%>
<%@ page import="blog.util.*"%>
<%@ page import="blog.util.SplitPage"%>
<%@ page import="blog.vo.*"%>
<%@ page import="blog.dao.*"%>
<%@ page import="blog.daoImpl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回复留言板</title>
<script type="text/javascript" src="public.js"></script>
<style type="text/css">
/*通用设置*/
* {
	margin: 0;
	padding: 0;
}
html{
	background:url("b2.jpg");
}
.body {
	height: 100%;
}

.main {
	width: 100%;
}

.content {
	color: black;
	float: right;
	width: 84%;
}

.header {
	height: 30px;
	width: 100%;
	text-align: center;
}

a:link, a:visited {
	text-decoration: none;
}

/*菜单设置*/
.box {
	width: 16%;
	position: absolute;
	top: 0;
	left: 0;
	height: 100%;
	padding: .4em 0;
	background: #E0EEE0;
	color: white;
	text-align: center;
	font-size: 0;
	position: absolute;
}

.box ul {
	list-style: none;
	text-align: left;
}
/*一级菜单*/
.menu li.level1 a {
	display: block;
	line-height: 31px;
	height: 31px;
	padding-left: 50px;
	font-size: 12px;
	color: black;
	background: #E0EEE0;
}
/*一级菜单两态样式,供JS调用*/
.menu li.level1 a.hove {
	background-position: left -31px;
}

.menu li.level1 a.cur {
	background-position: left -62px;
}

/*二级菜单*/
.menu li ul {
	padding-left: 10px;
	overflow: hidden;
}

.menu li ul.level2 {
	width: 180px;
	display: none;
}

.menu li ul.level2 li {
	height: 26px;
	line-height: 26px;
}

.menu li ul.level2 li a {
	display: block;
	height: 26px;
	line-height: 26px;
	background: #E7E3E7;
	padding-left: 50px;
	color: #42556B;
	border-top: 1px #B8C2CB solid;
	overflow: hidden;
}
/*二级菜单两态样式,供JS调用*/
.menu li ul.level2 li a.hove1 {
	background: #FFE4B5;
}
</style>
<script type="text/javascript" src="public.js">
</script>
</head>
<body>
	<center>
	<div class="main">
		<div class="box">
			<ul class="menu">
				<li class="level1"><a href="Main.jsp">管理首页</a></li>
				<li class="level1"><a href="#">我的作品</a>
					<ul class="level2">
						<li><a href="insertimage.jsp">发布照片</a></li>
						<li><a href="insertdeleteblog.jsp">更新/删除博客</a></li>
					</ul></li>
				<li class="level1"><a href="#">留言</a>
					<ul class="level2">
						<li><a href="MessageBoard2.jsp">留言板</a></li>
					</ul></li>
				<li class="level1"><a href="#">设置</a>
					<ul class="level2">
						<li><a href="BloggerXG.jsp">个人资料修改</a></li>
						<li><a href="XG.html">修改密码</a></li>
					</ul></li>
					<li class="level1"><a href="HomePage.jsp">退出登录</a></li>
			</ul>
		</div>
		</div>
		<%
			ArrayList<Messageboard> list = null;
			MessageBoardDAO Messageboard = new MessageBoardDAOImpl();
			list = Messageboard.queryAll();
		%>
		<table width="60%" border="1" cellpadding="0" align="center">
			<tr>
				<td align="center">留言ID</td>
				<td align="center">留言人</td>
				<td align="center">内容</td>
				<td align="center">回复</td>
				<td align="center">留言时间</td>
			</tr>
			<%
				for (Messageboard mb : list) {
			%>
			<br>
			<tr>
				<td><%=mb.getId()%></td>
				<td><%=mb.getName()%></td>
				<td><%=mb.getContent()%></td>
				<td><%=mb.getReply()%></td>
				<td><%=mb.getTime()%></td>
			</tr>
			<%
				}
			%>
		</table>


	<br><section>
			<form action="DeleteMessageServlet" method="post">
				<tr>
					<th><label for="replycontent">请输入需要删除的评论的ID</label></th>
					<td><input type="text" name="deleteId"></td>
					<td><input type="submit" value="删除"></td>
				</tr>
			</form>
		</section>
		<br><form action="ReplyMessageServlet" method="post">
			<tr>
				<th><label for="id">回复ID</label></th>
				<td><input type="text" id="id" name="id"></td>
			</tr>
			<br>
			<tr>
				<th><label for="replycontent">回复内容</label></th>
				<td><input type="text" id="replycontent" name="reply"></td>
			</tr>
			<br>
			<tr>
				<td><input type="submit" value="回复"></td>
			</tr>
		</form>
	</center>
</body>
</html>