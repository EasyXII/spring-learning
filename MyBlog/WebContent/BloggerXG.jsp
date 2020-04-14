<%@ page import="blog.vo.*" %>
<%@ page import="blog.util.*" %>
<%@ page import="java.util.*"%>
<%@ page import="blog.dao.*" %>
<%@ page import="blog.daoImpl.*" %>
<%@ page import="blog.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改个人资料</title>
	<style>
* {
	margin: 0;
	padding: 0;
}
html{
	background:url("b2.jpg");

}
button, input {
	outline: none;
}

button, .login {
	width: 120px;
	height: 42px;
	background: #f40;
	color: #fff;
	border: none;
	border-radius: 6px;
	display: block;
	margin: 20px auto;
	cursor: pointer;
}

button a{
text-decoration: none;
color:white;
}
.popOutBg {
	width: 100%;
	height: 100%;
	position: fixed;
	left: 0;
	top: 0;
	background: rgba(0, 0, 0, .6);
	display: none;
}

.popOut {
	position: fixed;
	width: 600px;
	height: 500px;
	top: 40%;
	left: 50%;
	margin-top: -150px;
	margin-left: -300px;
	background: #fff;
	border-radius: 8px;
	overflow: hidden;
	display: none;
}

.popOut>span {
	position: absolute;
	right: 10px;
	top: 0;
	height: 42px;
	line-height: 42px;
	color: #000;
	font-size: 30px;
	cursor: pointer;
}

.popOut table {
	display: block;
	margin: 42px auto 0;
	width: 520px;
}

.popOut caption {
	width: 520px;
	text-align: center;
	color: #f40;
	font-size: 18px;
	line-height: 42px;
}

.popOut table tr td {
	color: #666;
	padding: 6px;
	font-size: 14px;
}

.popOut table tr td:first-child {
	text-align: right;
}

.inp {
	width: 280px;
	height: 30px;
	line-height: 30px;
	border: 1px solid #999;
	padding: 5px 10px;
	color: #000;
	font-size: 14px;
	border-radius: 6px;
}

.inp:focus {
	border-color: #f40;
}

@
keyframes ani {
from { transform:translateX(-100%)rotate(-60deg)scale(.5);
 }
50%{transform:translateX(0)
rotate(0)
scale(1);
}
90%{
transform:translateX(20px)
rotate(0)
scale(.8);
}
to {
	transform: translateX(0) rotate(0) scale(1);
}

}
.ani {
	animation: ani .5s ease-in-out;
}
</style>
</head>
<body>
<center>
<table border="1"  width="80%" height="500px">
				<%
					BloggerDAO blogger = new BloggerDAOImpl();
					List<Blogger> list = null;
					list = blogger.findAll();
					for (Blogger blg : list) {
				%>
				   <br> <tr> 
				        <td align="center">ID</td>
						<td><%=blg.getId()%></td>	
				    </tr>	
				   <br> <tr>
				        <td align="center">博主昵称</td>		
						<td><%=blg.getName()%></td>
				    </tr>	
				   <br> <tr>
				        <td align="center">博主邮箱</td>			
						<td><%=blg.getEmail()%></td>	
					</tr>				
				   <br> <tr>
				        <td align="center">个性签名</td>
						<td><%=blg.getSignature()%></td>
					</tr>										
				   <br> <tr>
				        <td align="center">头像</td>	
					    <td><img src="<%=blg.getImage()%>"></td>
					</tr>

				<%} %>
  </table>
</center>
	<button type="button">点我修改信息</button>
    <button type="button"><a href="Main.jsp">返回</a></button>
	
	<div class="popOutBg"></div>
	<div class="popOut">
		<span title="关闭"> x </span>
		<form action="UpdateBloggerServlet" method="post">
		<table>
			<caption>修改信息</caption>
			<tr>
				<td width="120">昵称</td>
				<td><input type="text"  name="name" class="inp" placeholder="请输入昵称" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="email" name="email" class="inp" placeholder="请输入邮箱" /></td>
			</tr>
			<tr>
				<td>修改签名</td>
				<td><input type="text" name="signature" class="inp" placeholder="再次输入新签名" /></td>
			</tr>
			<tr>
			<td>修改头像</td>
				<td><input type="file" name="image" size="30"></td>
			</tr>
			<tr>
			    <td><font color=red>注意：头像文件大小不得超过10K</font></td>	
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="login" value="修改" /></td>
			</tr>
		</table>
		</form>
	</div>
	<script type="text/javascript">
		function $(param) {
			if (arguments[1] == true) {
				return document.querySelectorAll(param);
			} else {
				return document.querySelector(param);
			}
		}
		function ani() {
			$(".popOut").className = "popOut ani";
		}
		$("button").onclick = function() {
			$(".popOut").style.display = "block";
			ani();
			$(".popOutBg").style.display = "block";
		};
		$(".popOut > span").onclick = function() {
			$(".popOut").style.display = "none";
			$(".popOutBg").style.display = "none";
		};
		$(".popOutBg").onclick = function() {
			$(".popOut").style.display = "none";
			$(".popOutBg").style.display = "none";
		};
	</script>
</body>
</html>