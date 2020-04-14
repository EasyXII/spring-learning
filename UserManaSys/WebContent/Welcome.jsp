<%@ page language="java" import="java.util.*" import="java.io.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<script type="text/javascript">
	function check() {
		return window.confirm("你真的要删除吗？");
	}
</script>
</head>
<body>
登录成功  恭喜你！！<%=(String)session.getAttribute("username") %><br>
<%//if(session.getAttribute("username")==null)
	//response.sendRedirect("login2.jsp");
	%>
	
   登录成功 恭喜你！！<%=request.getParameter("uname") %>
   
   <br><a href="login.jsp" >重新登录</a> &nbsp;&nbsp;&nbsp; <a href="main.jsp" >返回主界面</a>
   <!-- 添加网页访问次数的功能，先都文件的内容，加1，写入文件 -->
   <%
   //读取文件
   //创建一个FileReader
		FileReader f = new FileReader("f:\\11.txt");
		BufferedReader bw = new BufferedReader(f);
		//读出一行数据
		String numVal = bw.readLine();
		bw.close();
		//加1
		int times = Integer.parseInt(numVal);
        times++;
		%>
   <hr>
   <%
   List<HashMap> lists=new ArrayList<HashMap>();
   lists=(ArrayList)request.getAttribute("result");
   %>
  
   <table border=1>
   <tr><td>用户Id</td><td>用户名</td><td>用户密码</td><td>用户级别</td>
   <td>修改用户</td><td>删除用户</td></tr> 
 <%for(int i=0;i<lists.size();i++){ %>
       <%
       int index = (Integer)lists.get(i).get("userID");
       %>
       <tr>
       <td><%=lists.get(i).get("userID") %></td>
       <td><%=lists.get(i).get("username") %></td>
       <td><%=lists.get(i).get("password") %></td>
       <td><%=lists.get(i).get("grade") %></td>
        <td><a href="updateUser.jsp?username=<%=lists.get(i).get("username") %>&password=<%=lists.get(i).get("password") %>
        &email=<%=lists.get(i).get("email") %>&grade=<%=lists.get(i).get("grade") %>&userID=<%=lists.get(i).get("userID") %>">修改用户</a></td>
        <td><a href=UserCLServlet?flag=delUser&userId=<%=index%>  onclick="return check();">删除用户</a></td>
     
       </tr>
       
 <% } %> 
</table><br>
<%

String s_pageNow = (String)request.getAttribute("pageNow");
int pageNow=Integer.parseInt(s_pageNow);
if(pageNow!=1){
	out.println("<a href=UserCLServlet?flag=fenye&pageNow="+(pageNow-1)+">上一页</a>");
}
String s_pageCount=(String)request.getAttribute("pageCount");
int pageCount=Integer.parseInt(s_pageCount);
for(int i=1;i<pageCount;i++){
	out.println("<a href = UserCLServlet?flag = fanye&pageNow="+i+">["+i+"]</a>");
}
if(pageNow!=pageCount){
	out.println("<a href=UserCLServlet?flag=fenye&pageNow="+(pageNow+1)+">下一页</a>");
}

%>
<form action="UserCLServlet?flag=fenye" method="post">
<input type="text" name=pageNow>
<input type="submit" value="go">
</form>
<br>
<%
  out.println("该网页访问了"+this.getServletContext().getAttribute("visitTimes")+"次");
%>
</body>
</html>