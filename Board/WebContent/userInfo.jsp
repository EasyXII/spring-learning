<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改头像</title>
</head>
<body>
<%
  String id = (String)session.getAttribute("id");
  String name = (String)session.getAttribute("me");
%>
<center>
<form action="uploadImage" method="post" enctype="multipart/form-data">
    <table>
         <tr>
             <td colspan="2"><h1>修改头像</h1></td>
         </tr>
         <tr>
             <td>用户名：<%=name%></td>
         </tr>
         <tr>
             <td><div align="center">
                                                     上传头像图片：<input type="file" name="file" size="30">未选择任何文件
                 </div>
             </td>
         </tr>
         <tr>
             <td><font color="red">注意：头像大小不得超过10k</font></td>
         </tr>
         <tr>
             <td colspan="2"><input type="hidden" name="id" value="<%=id%>"></td>
             <div align="center"><input type="submit" value="提交"></div>
         </tr>
    </table>
</form>
</center>
</body>
</html>