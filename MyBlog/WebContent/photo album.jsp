<%@page import="java.util.ArrayList"%>
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
<title>个人相册</title>
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

ul, li {
	list-style: none;
}

a {
	text-decoration: none;
	color: black;
}

.box {
	width: 1000px;
	height: 700px;
	margin: 20px auto;
	overflow: hidden;
	position: relative;
}

.box-1 ul li {
	width: 1000px;
	height: 700px;
	position: relative;
	overflow: hidden;
}

.box-1 ul li img {
	display: block;
	width: 1000px;
	height: 700px;
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
	font-family: "宋体";
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

.img {
	
}
</style>
<script type="text/javascript">
	window.onload = function() {
		function $(param) {
			if (arguments[1] == true) {
				return document.querySelectorAll(param);
			} else {
				return document.querySelector(param);
			}
		}
		var $box = $(".box");
		var $box1 = $(".box-1 ul li", true);
		var $box2 = $(".box-2 ul");
		var $box3 = $(".box-3");
		var $length = $box1.length;

		var str = "";
		for (var i = 0; i < $length; i++) {
			if (i == 0) {
				str += "<li class='on'>" + (i + 1) + "</li>";
			} else {
				str += "<li>" + (i + 1) + "</li>";
			}
		}
		$box2.innerHTML = str;

		var current = 0;

		var timer;
		timer = setInterval(go, 1000);
		function go() {
			for (var j = 0; j < $length; j++) {
				$box1[j].style.display = "none";
				$box2.children[j].className = "";
			}
			if ($length == current) {
				current = 0;
			}
			$box1[current].style.display = "block";
			$box2.children[current].className = "on";
			current++;
		}

		for (var k = 0; k < $length; k++) {
			$box1[k].onmouseover = function() {
				clearInterval(timer);
			}
			$box1[k].onmouseout = function() {
				timer = setInterval(go, 1000);
			}
		}
		for (var p = 0; p < $box3.children.length; p++) {
			$box3.children[p].onmouseover = function() {
				clearInterval(timer);
			};
			$box3.children[p].onmouseout = function() {
				timer = setInterval(go, 1000);
			}
		}

		for (var u = 0; u < $length; u++) {
			$box2.children[u].index = u;
			$box2.children[u].onmouseover = function() {
				clearInterval(timer);
				for (var j = 0; j < $length; j++) {
					$box1[j].style.display = "none";
					$box2.children[j].className = "";
				}
				this.className = "on";
				$box1[this.index].style.display = "block";
				current = this.index + 1;
			}
			$box2.children[u].onmouseout = function() {
				timer = setInterval(go, 1000);
			}
		}

		$box3.children[0].onclick = function() {
			back();
		}
		$box3.children[1].onclick = function() {
			go();
		}
		function back() {
			for (var j = 0; j < $length; j++) {
				$box1[j].style.display = "none";
				$box2.children[j].className = "";
			}
			if (current == 0) {
				current = $length;
			}
			$box1[current - 1].style.display = "block";
			$box2.children[current - 1].className = "on";
			current--;
		}
	}
</script>
</head>
<body>

	<div id="head"></div>
	<br>
	<div class="img">
		<%
			BloggerDAO bloggerDAO = new BloggerDAOImpl();
			ArrayList<Image> list = bloggerDAO.album();
			for (Image ig : list) {
		%>
		<img width="100%" height="auto" src="<%=ig.getImage()%>">

		<%
			}
		%>
	</div>
	<div id="foot"></div>
	<script type="text/javascript">
		$("#head").load("head.jsp");
		$("#foot").load("foot.html");
	</script>

</body>
</html>