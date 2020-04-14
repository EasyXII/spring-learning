<%@page import="blog.util.SplitPage"%>
<%@ page import="java.util.*" %>
<%@ page import="blog.vo.*" %>
<%@ page import="blog.dao.*" %>
<%@ page import="blog.daoImpl.*" %>
<%@ page import="blog.factory.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<title>head</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.nav {
	margin: 0;
	list-style: none;
	width: 100%;
}

.ch {
	background: #FF4040;
	text-align: center;
	padding: 20px;
}

.ch a {
	color: white;
	text-decoration: none;
    transition: all 0.4s linear;
    
    
}

.ch a:hover {
	color: gold;
	transform: scale(1.2);  
	padding-left: 20px;
	font-size:40px;
}


form {
	top: -55px;
	position: relative;
	width: 1300px;
}

input, button {
	border: none;
	outline: none;
}

input {
	height: 42px;
	padding-left: 5px;
}

button {
	height: 42px;
	cursor: pointer;
	position: absolute;
}

.bar input {
	width: 550px;
	border-radius: 42px;
	border: 2px solid #324B4E;
	background: #F9F0DA;
	float: right;
}

.bar button {
	background: none;
	font-size: 15px;
	top: 6px;
	right: 25px;
}

.bar button:before {
	content: "Go";
	color: #324b4e;
}

.dh {
	width: 100%;
	background-color: #252525;
}

.lh {
	width: 80%;
}

/* 通用样式 */
.menu, .menu ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

.menu {
	height: 58px;
}

.menu li {
	background: -moz-linear-gradient(#292929, #252525);
	background: -ms-linear-gradient(#292929, #252525);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #292929),
		color-stop(100%, #252525));
	background: -webkit-linear-gradient(#292929, #252525);
	background: -o-linear-gradient(#292929, #252525);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#292929',
		endColorstr='#252525');
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr='#292929', endColorstr='#252525')";
	background: linear-gradient(#292929, #252525);
	border-bottom: 2px solid #181818;
	border-top: 2px solid #303030;
	min-width: 160px;
}

.menu>li {
	display: block;
	float: left;
	position: relative;
}

.menu>li:first-child {
	border-radius: 5px 0 0;
}

.menu a {
	border-left: 3px solid rgba(0, 0, 0, 0);
	color: #808080;
	display: block;
	font-family: 'Lucida Console';
	font-size: 18px;
	line-height: 54px;
	padding: 0 25px;
	text-decoration: none;
	text-transform: uppercase;
}

/* 悬停时的样式 */
.menu li:hover {
	background-color: #1c1c1c;
	background: -moz-linear-gradient(#1c1c1c, #1b1b1b);
	background: -ms-linear-gradient(#1c1c1c, #1b1b1b);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #1c1c1c),
		color-stop(100%, #1b1b1b));
	background: -webkit-linear-gradient(#1c1c1c, #1b1b1b);
	background: -o-linear-gradient(#1c1c1c, #1b1b1b);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#1c1c1c',
		endColorstr='#1b1b1b');
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr='#1c1c1c', endColorstr='#1b1b1b')";
	background: linear-gradient(#1c1c1c, #1b1b1b);
	border-bottom: 2px solid #222222;
	border-top: 2px solid #1B1B1B;
}

.menu li:hover>a {
	border-radius: 5px 0 0 0;
	border-left: 3px solid #C4302B;
	color: #C4302B;
}

/* 子菜单样式 */
.submenu {
	left: 0;
	max-height: 0;
	position: absolute;
	top: 100%;
	z-index: 0;
	-webkit-perspective: 400px;
	-moz-perspective: 400px;
	-ms-perspective: 400px;
	-o-perspective: 400px;
	perspective: 400px;
}

.submenu li {
	opacity: 0;
	-webkit-transform: rotateY(90deg);
	-moz-transform: rotateY(90deg);
	-ms-transform: rotateY(90deg);
	-o-transform: rotateY(90deg);
	transform: rotateY(90deg);
	-webkit-transition: opacity .4s, -webkit-transform .5s;
	-moz-transition: opacity .4s, -moz-transform .5s;
	-ms-transition: opacity .4s, -ms-transform .5s;
	-o-transition: opacity .4s, -o-transform .5s;
	transition: opacity .4s, transform .5s;
}

.menu .submenu li:hover a {
	border-left: 3px solid #454545;
	border-radius: 0;
	color: #ffffff;
}

.menu>li:hover .submenu, .menu>li:focus .submenu {
	max-height: 2000px;
	z-index: 10;
}

.menu>li:hover .submenu li, .menu>li:focus .submenu li {
	opacity: 1;
	-webkit-transform: none;
	-moz-transform: none;
	-ms-transform: none;
	-o-transform: none;
	transform: none;
}

/* CSS3 过渡效果的延迟 */
.menu li:hover .submenu li:nth-child(1) {
	-webkit-transition-delay: 0s;
	-moz-transition-delay: 0s;
	-ms-transition-delay: 0s;
	-o-transition-delay: 0s;
	transition-delay: 0s;
}

.menu li:hover .submenu li:nth-child(2) {
	-webkit-transition-delay: 50ms;
	-moz-transition-delay: 50ms;
	-ms-transition-delay: 50ms;
	-o-transition-delay: 50ms;
	transition-delay: 50ms;
}

.menu li:hover .submenu li:nth-child(3) {
	-webkit-transition-delay: 100ms;
	-moz-transition-delay: 100ms;
	-ms-transition-delay: 100ms;
	-o-transition-delay: 100ms;
	transition-delay: 100ms;
}

.menu li:hover .submenu li:nth-child(4) {
	-webkit-transition-delay: 150ms;
	-moz-transition-delay: 150ms;
	-ms-transition-delay: 150ms;
	-o-transition-delay: 150ms;
	transition-delay: 150ms;
}

.menu li:hover .submenu li:nth-child(5) {
	-webkit-transition-delay: 200ms;
	-moz-transition-delay: 200ms;
	-ms-transition-delay: 200ms;
	-o-transition-delay: 200ms;
	transition-delay: 200ms;
}

.menu li:hover .submenu li:nth-child(6) {
	-webkit-transition-delay: 250ms;
	-moz-transition-delay: 250ms;
	-ms-transition-delay: 250ms;
	-o-transition-delay: 250ms;
	transition-delay: 250ms;
}

.menu li:hover .submenu li:nth-child(7) {
	-webkit-transition-delay: 300ms;
	-moz-transition-delay: 300ms;
	-ms-transition-delay: 300ms;
	-o-transition-delay: 300ms;
	transition-delay: 300ms;
}

.menu li:hover .submenu li:nth-child(8) {
	-webkit-transition-delay: 350ms;
	-moz-transition-delay: 350ms;
	-ms-transition-delay: 350ms;
	-o-transition-delay: 350ms;
	transition-delay: 350ms;
}

.submenu li:nth-child(1) {
	-webkit-transition-delay: 350ms;
	-moz-transition-delay: 350ms;
	-ms-transition-delay: 350ms;
	-o-transition-delay: 350ms;
	transition-delay: 350ms;
}

.submenu li:nth-child(2) {
	-webkit-transition-delay: 300ms;
	-moz-transition-delay: 300ms;
	-ms-transition-delay: 300ms;
	-o-transition-delay: 300ms;
	transition-delay: 300ms;
}

.submenu li:nth-child(3) {
	-webkit-transition-delay: 250ms;
	-moz-transition-delay: 250ms;
	-ms-transition-delay: 250ms;
	-o-transition-delay: 250ms;
	transition-delay: 250ms;
}

.submenu li:nth-child(4) {
	-webkit-transition-delay: 200ms;
	-moz-transition-delay: 200ms;
	-ms-transition-delay: 200ms;
	-o-transition-delay: 200ms;
	transition-delay: 200ms;
}

.submenu li:nth-child(5) {
	-webkit-transition-delay: 150ms;
	-moz-transition-delay: 150ms;
	-ms-transition-delay: 150ms;
	-o-transition-delay: 150ms;
	transition-delay: 150ms;
}

.submenu li:nth-child(6) {
	-webkit-transition-delay: 100ms;
	-moz-transition-delay: 100ms;
	-ms-transition-delay: 100ms;
	-o-transition-delay: 100ms;
	transition-delay: 100ms;
}

.submenu li:nth-child(7) {
	-webkit-transition-delay: 50ms;
	-moz-transition-delay: 50ms;
	-ms-transition-delay: 50ms;
	-o-transition-delay: 50ms;
	transition-delay: 50ms;
}

.submenu li:nth-child(8) {
	-webkit-transition-delay: 0s;
	-moz-transition-delay: 0s;
	-ms-transition-delay: 0s;
	-o-transition-delay: 0s;
	transition-delay: 0s;
}

.nav .search input {
	margin-top: 6px;
	margin-left: 30px;
	display: block;
	width: 440px;
}
</style>
</head>
<body>
	<div class="nav">
		<div class="ch">
			<h1>
			   <%
			   BloggerDAO bloggerdao = new BloggerDAOImpl();
			   Blogger blogger = new Blogger();
			   ArrayList<Blogger> list = bloggerdao.findAll();
			   for(Blogger blogger1:list){
			   %>
				<a href="login.html"><%=blogger1.getName()%></a> 的个人博客
				<%} %>
			</h1>
		</div>
		<div class="dh">
			<div class="lh">
				<ul class="menu">
					<li><a href="HomePage.jsp">首页</a></li>
					<li class="active"><a href="#">生活笔记</a>
						<ul class="submenu">
							<li><a href="SelectBlogServlet2?parm=个人笔记">个人笔记</a></li>
							<li><a href="ShowImageServlet">个人相册</a></li>
						</ul></li>
					<li><a href="#">技术杂谈</a>
						<ul class="submenu">
							<li><a href="SelectBlogServlet2?parm=Java">Java</a></li>
							<li><a href="SelectBlogServlet2?parm=MySql">MySql</a></li>
							<li><a href="SelectBlogServlet2?parm=HTML">HTML</a></li>
						</ul></li>
					<li><a href="MessageBoard.jsp">给我留言</a></li>
					<li><a href="Blogger.jsp">关于博主</a></li>
				</ul>
			</div>
			<div class="search bar">
			<form  action="SelectBlogServlet" method="post">
				<input type="text" name="select"  placeholder="请输入关键词/分类/标题">
				<button type="submit"></button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>