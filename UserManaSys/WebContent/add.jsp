<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>

 添加用户
 <hr/>
 <h1>请输入用户信息</h1>
<form action="UserCLServlet?flag=adduser"  method="post">
 <table border="1">
 <tr><td>用户名：</td><td><input type="text" name="username"></input></td></tr>
 <tr><td>密码：</td><td><input type="text" name="password"></input></td></tr>
 <tr><td>Email：</td><td><input type="text" name="email"></input></td></tr>
 <tr><td>grade：</td><td><input type="text" name="grade"></input></td></tr>
  <tr><td><input type="submit" value="添加用户"></input></td><td><input type="reset" value="重置"></input></td></tr>
 
 </table>
</form>
</center>
</body>
</html>