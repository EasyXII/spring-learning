<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改</title>
</head>
<body bgcolor="#CED3FE">
<img src="images/1.gif" />
<hr/>
<center>

 修改用户
 <hr/>
 <h1>请输入用户信息</h1>
<form action="UserCLServlet?flag=updateuser"  method="post">
 <table border="1">
 
 
 <tr><td>用户ID：</td><td><input type="text" readonly="readonly" name="userID" value="<%=request.getParameter("userID") %>" /></td></tr>
 <tr><td>用户名：</td><td><input type="text" name="username" value="<%=request.getParameter("username") %>"/></td></tr>
 <tr><td>密码：</td><td><input type="text" name="password" value="<%=request.getParameter("password") %>"/></td></tr>
 <tr><td>Email：</td><td><input type="text" name="email" value="<%=request.getParameter("email") %>"/></td></tr>
 <tr><td>grade：</td><td><input type="text" name="grade" value="<%=request.getParameter("grade") %>"/></td></tr>
 <tr><td><input type="submit" value="修改用户"></input></td><td><input type="reset" value="重置"/></td></tr>
 </table>
</form>
</center>
 <hr></hr>   
   <img src="images/1.gif" />  

</body>
</html>