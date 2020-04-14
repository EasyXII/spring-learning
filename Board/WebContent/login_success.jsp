<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
</head>
<body bgcolor = #ACC4FF>
<center>
 <p1><strong>JSP学习论坛留言板</strong></p1>
 <hr>
 <br>
 <c:if test="${me != null }">
 <!-- +session.getAttribute("me")+ -->
欢迎${me}进入论坛！！！！ 
 </c:if>
 <c:if test="${me = null}">
  您还没有登录，3秒钟自动跳到登录界面！！
 </c:if>
 <%response.setHeader("refresh", "3;URL=login.html"); %> 
  <%
//页面访问次数
 String str_counter = (String)application.getAttribute("counter");
 if(str_counter!=null){
	int counter = Integer.parseInt(str_counter);
	counter++;
	application.setAttribute("counter",counter+"");
 }else{
 //第一次访问
 application.setAttribute("counter", "1");
 str_counter = "1";
 }
 %>
 
 <p>
 <p>

 <h3>您是第${counter}位访客！！</h3>
 <p>
 <br><a href="???">用户管理</a>${me}
 <a href="showNotes">进入留言板</a> 
 <hr><img src="images/1.gif">
</center>
</body>
</html>