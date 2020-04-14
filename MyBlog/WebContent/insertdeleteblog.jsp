<%@page import="blog.util.*"%>
<%@ page import="java.util.*" %>
<%@ page import="blog.vo.*" %>
<%@ page import="blog.dao.*" %>
<%@ page import="blog.daoImpl.*" %>
<%@ page import="blog.factory.*" %>
<%@ page import="blog.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加杂谈</title>
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
<section>
       <form action="InsertBlogServlet" method="post">
          <tr>
              <th><label for="author">作者</label></th>
              <td><input type="text" id="author" name="author"></td>
          </tr>
          <br>
          <tr>
              <th><label for="content">内容</label></th>
              <td><input type="text" id="content" name="content"></td>
          </tr>
          <br>
          <tr>
              <th><label for="title">题目</label></th>
              <td><input type="text" id="title" name="title"></td>
          </tr>
          <br>
          <tr>
              <th><lable for="type">类型</lable></th>
              <td><select name="type">
                 <option>Java</option>
                 <option>MySql</option>
                 <option>HTML</option>
                 <option>个人笔记</option>
               </select></td>
          </tr>
          <br>
          <tr>
              <td><input type="submit" value="添加"></td>
          </tr>
     </form>
   </section>
  <br> <section>
      <table border="1">
                        <tr>   
                            <td>博客ID</td>
							<td>作者</td>
							<td>题目</td>
							<td>类型</td>
							<td>发表时间</td>
						</tr>
		<%
		ArrayList<Blog> list = null;
		BlogDAO Blog = new BlogDAOImpl();
		list = Blog.queryAll();
		for(Blog b:list){
		%> 
		         <tr>
		             <td><%=b.getId()%></td>
		             <td><%=b.getAuthor()%></td>
		             <td><%=b.getTitle()%></td>
		             <td><%=b.getType()%></td>
		             <td><%=b.getTime()%></td>
		         </tr>
		  <%} %>
      </table>
   </section>
   <br><section>
     <form action="DeleteBlogServlet" method="post">
         <th><lable for="id">请输入删除博客ID：</lable></th>
         <td><input type="text" name="id"></td>
         <td><input type="submit" value="删除"></td>
     </form>
   </section>
</center>
</body>
</html>