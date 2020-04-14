<%@ page import="java.util.*" %>
<%@ page import="note.dao.*" %>
<%@ page import="note.daoImpl.*" %>
<%@ page import="note.servlet.*" %>
<%@ page import="note.vo.*" %>
<%@ page import="note.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
        function go(){
            var goPage=document.all.selectpage.value;
            alert("我们将去页面:list_note_new.jsp?flag="+goPage);
            document.open("list_note_new.jsp?flag="+goPage,"_self","");
        }
    </script>

<style type="text/css">
body{
color:black
}
</style>
</head>
<body>
<center>
<a href="userInfo.jsp"><img src="<%=session.getAttribute("image")%>" alt="修改头像">

</a>
 &nbsp&nbsp&nbsp JSP学习论坛留言板  <a href="exit.jsp">退出登录</a>
 <hr>
 <h3><a href="showNote?flag=first">显示所有留言</a></h3>
 <form action="showNote?flag=first" method="post">
  <table>
        <tr>
            <td>在</td>
            <td>
               <select name="item">
                 <option value="title">标题</option>
                 <option value="author">作者</option>
                 <option value="content">内容</option>
               </select>中查询
            </td>
            <td><input type="text" name="content"></td>
            <td><input type="submit" name="submit" value="搜素"></td>
        </tr>
  </table>
 </form>
 <h3>
  <a href="">添加新留言</a>
 </h3>
 <c:if test="${me!=null}">
    <table width="80%" border="1" cellpadding="0" align="center">
      <tr>
          <td><font size="2" color="#0000FF">留言ID</font></td>
          <td><font size="2" color="#0000FF">标题</font></td>
          <td><font size="2" color="#0000FF">作者</font></td>
          <td><font size="2" color="#0000FF">内容</font></td>
          <td><font size="2" color="#0000FF">删除</font></td>
      </tr> 
      <c:forEach items="${notes}" var="n">
      <tr>
      <td>${n.id}</td>
      <td>
          <c:if test="${me == n.author}"><a href="update.jsp?id=${n.id}">${n.title}</c:if>
          <c:if test="${me != n.author}">${n.title}</c:if>
      </td>
      <td>${n.author}</td>
      <td>${n.content}</td>
      <td>
          <c:if test="${me == n.author}"><a href="delete.jsp?id=${n.id}">${n.title}</c:if>
          <c:if test="${me != n.author}">${n.title}</c:if>
      </td>
      </tr>
      </c:forEach>
          <tr>
         <td colspan="5" align="right">
         <a href="list_note_new.jsp?flag=first&item=${strItem}&content=${strContent}">首页</a>
         <a href="list_note_new.jsp?flag=previous&item=${strItem}&content=${strContent}">上一页</a>
         <a href="list_note_new.jsp?flag=next&item=${strItem}&content=${strContent}">下一页</a>
         <a href="list_note_new.jsp?flag=last&item=${strItem}&content=${strContent}">尾页</a>
         <select id="selectpage" name="goPage" onchange="javaScript:go()">
         <c:forEach begin="1" end="{sPage.totalPages}" var="i">
                 <option value="${i}" ${spage.currentPage == 1} ?"selected" : "" >${i}/${spage.totalPages}</option>        
         </c:forEach>
         </select>
         </td>
      </tr>
 </table>
 </c:if>
 <c:if test="${me == null}">
     <%
       response.setHeader("refresh", "2;URL=login.jsp");
     %>
     您还没有登录，请登录！！！
  
 </c:if>
</center>
</body>
</html>