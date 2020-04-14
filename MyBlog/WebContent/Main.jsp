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
<title>后台首页</title>
<meta charset="UTF-8">

<style type="text/css">
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

.menu li.level1 a {
	display: block;
	line-height: 31px;
	height: 31px;
	padding-left: 50px;
	font-size: 12px;
	color: black;
	background: #E0EEE0;
}

.menu li.level1 a.hove {
	background-position: left -31px;
}

.menu li.level1 a.cur {
	background-position: left -62px;
}


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

.menu li ul.level2 li a.hove1 {
	background: #FFE4B5;
}




ul, li {
	list-style: none;
}

a {
	text-decoration: none;
	color: black;
}

.box1 {
	width: 85%;
	height: 600px;
	margin: 20px auto;
	overflow: hidden;
	position: relative;
}

.box-1 ul li {
	width: 1200px;
	height: 600px;
	position: relative;
	overflow: hidden;
}

.box-1 ul li img {
	display: block;
	width: 1200px;
	height: 600px;
}

.box-1 ul li h2 {
	position: absolute;
	left: 0;
	bottom: 0;
	height: 40px;
	width: 300px;
	background: rgba(125, 125, 120, .4);
	text-indent: 2em;
	padding-right: 500px;
	font-size: 15px;
	line-height: 40px;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
	font-weight: normal;
	color: ghostwhite
}

.box-2 {
	position: absolute;
	right: 10px;
	bottom: 14px;
}

.box-2 ul li {
	float: left;
	width: 12px;
	height: 12px;
	overflow: hidden;
	margin: 0 5px;
	border-radius: 50%;
	background: rgba(0, 0, 0, 0.5);
	text-indent: 100px;
	cursor: pointer;
}

.box-2 ul .on {
	background: rgba(255, 255, 255, 0.6);
}

.box-3 span {
	position: absolute;
	color: white;
	background: rgba(125, 125, 120, .3);
	width: 50px;
	height: 80px;
	top: 50%;
	font-family: "����";
	line-height: 80px;
	font-size: 60px;
	margin-top: -40px;
	text-align: center;
	cursor: pointer;
}

.box-3 .prev {
	left: 10px;
}

.box-3 .next {
	right: 10px;
}

.box-3 span::selection {
	background: transparent;
}

.box-3 span:hover {
	background: rgba(125, 125, 120, .8);
}

p1{
  font-size:1.6em;
  padding:0 2em;
  cursor:pointer;
  transition:1000ms ease all;
  outline:none;
}
p1:hover{
  color:#1AAB8A;
}
p1:before,p:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:1000ms ease all;
}
p1:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
p1:hover:before,p:hover:after{
  width:100%;
  transition:1000ms ease all;
}

.foot {
	text-align: center;
	background: #444;
	color: white;
	width: 100%;
	height: 50px;
    position: fixed;
    bottom: 0;
}

</style>
<script type="text/javascript" src="main.js">


</script>

</head>
<body>
	<div class="main">
		<div class="box">
			<ul class="menu">
				<li class="level1"><a href="Main.html">管理首页</a></li>
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
		<div class="content">
			<div class="header">
			  <%
			   BloggerDAO bloggerdao = new BloggerDAOImpl();
			   Blogger blogger = new Blogger();
			   ArrayList<Blogger> list = bloggerdao.findAll();
			   for(Blogger blogger1:list){
			   %>
				<p1><strong>欢迎回来：<%=blogger1.getName() %></strong></p1>
				<%} %>
			</div>
			<div class="box1">
				<div class="box-1">
					<ul>
						<li><img src="img3.jpg"></img></li>
						<li><img src="img4.jpg"></img></li>
						<li><img src="img5.jpg"></img></li>
					</ul>
				</div>
				<div class="box-2">
					<ul>

					</ul>
				</div>
				<div class="box-3">
					<span class="prev"> < </span> <span class="next"> > </span>
				</div>
			</div>
		</div>
	<div class="foot">
	<center>
		<p>个人博客</p><p> &copy; 2019, All rights reserved.</p>
	</center>
	</div>
	</div>
</body>
</html>
