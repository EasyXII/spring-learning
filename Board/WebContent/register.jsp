<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面</title>
</head>
<body bgcolor = #ACC4FF>
<center>
<form action="RegisterServlet" method = post>
<table border="1">
<tr>
<td colspan="2" align="center">用户注册</td>
</tr>
<tr>
<td height="40" align="right">用户名：</td>
<td width="200" align="left" valign="middle">&nbsp;<input type="text" name="name" size="20" /></td>
</tr>
<tr>
<td height="40" align="right">头像：</td>
<td width="46%">
<select name = images size = 1 onChange="document.images['avatar'].src=options[selectedIndex].value">
       <option value="images/face/Image1.gif">头像1</option>
       <option value="images/face/Image2.gif">头像2</option>
       <option value="images/face/Image3.gif">头像3</option>
       <option value="images/face/Image4.gif">头像4</option>
       <option value="images/face/Image5.gif">头像5</option>
       <option value="images/face/Image6.gif">头像6</option>
       <option value="images/face/Image7.gif">头像7</option>
       <option value="images/face/Image8.gif">头像8</option>
       <option value="images/face/Image9.gif">头像9</option>
       <option value="images/face/Image10.gif">头像10</option>
</select>
<img src="images/face/Image1.gif" alt=个人形象代表 name="avatar" width="32" height="32" id=avatar>
</td>
</tr>
<tr>
<td height="40" align="right">注册密码：</td>
<td width="200" align="left" valign="middle">&nbsp;<input type="password" name="password" size="20" /></td>
</tr>
<tr>
<td height="40" align="right">确认密码：</td>
<td width="200" align="left" valign="middle">&nbsp;<input type="password" name="passwordok" size="20" /></td>
</tr>
<tr>
<td height="40" align="right">邮箱：</td>
<td width="200" align="left" valign="middle">&nbsp;<input type="text" name="email" size="20" /></td>
</tr>
<td><input type="hidden" name="flag" value="0"></td>
  <tr>
   <td height="40" colspan="2" align="center"><input type="submit" value=" 确定 " />
    &nbsp;<input type="reset" value=" 重置 " /></td>
  </tr>
</table>
</form>
</center>
</body>
</html>