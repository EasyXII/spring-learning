
<%@page import="blog.util.SplitPage"%>
<%@ page import="java.util.*"%>
<%@ page import="blog.vo.*"%>
<%@ page import="blog.dao.*"%>
<%@ page import="blog.daoImpl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言板</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<style type="text/css">
<style type ="text /css">
html,body {
	height: 100%;
}

.content {
	background: url("b2.jpg");
	width: 100%;
	height:900px;
}
#table{
overflow:hidden;
top:-20%;
}
#foot {
	position: relative;
	bottom: 0;
	text-align: center;
	width: 100%;
	height: 61px;
}
</style>
</head>
<body>
	<center>
		<div id="head"></div>
		<div class="content">
			<article>
				<section>
					<jsp:useBean id="spage" class="blog.util.SplitPage"></jsp:useBean>
					
					<table width="80%" height="500px" border="1" cellpadding="0" align="center"  id="table">
						<tr>
							<td align="center">留言人</td>
							<td align="center">内容</td>
							<td align="center">回复</td>
							<td align="center">留言时间</td>
						</tr>
						<%
							String flag = request.getParameter("flag");//翻页时的方向值，即是SplitSpage中的请求标注
							//每次刷新页面时都应当重新获得表中的记录数，因为翻页时
							int totalRows = 0;//总的记录数
							int currentPage = 0;//当前页
							SplitPage sPage = new SplitPage();
							List<Messageboard> list = null;
							MessageBoardDAO Messageboard = new MessageBoardDAOImpl();
							totalRows = Messageboard.getRow();
							System.out.println(totalRows);
							sPage.setTotalRows(totalRows);
							currentPage = sPage.confirmPage(flag);
							System.out.println(currentPage);
							sPage.setCurrentPage(currentPage);
							list = Messageboard.queryBylike(sPage);
							for (Messageboard mb : list) {
						%>
						<br>
						<tr>
							<td><%=mb.getName()%></td>
							<td><%=mb.getContent()%></td>
							<td><%=mb.getReply()%></td>
							<td><%=mb.getTime()%></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td colspan="5" align="center"><a
								href="MessageBoard.jsp?flag=<%=SplitPage.FIRSTPAGE%>">首页</a> <a
								href="MessageBoard.jsp?flag=<%=SplitPage.PREVIOUSEPAGE%>">上一页</a>
								<a href="MessageBoard.jsp?flag=<%=SplitPage.NEXTPAGE%>">下一页</a>
								<a href="MessageBoard.jsp?flag=<%=SplitPage.LASTPAGE%>">尾页</a></td>
						</tr>
						<tr>
							<form action="LeaveWordServlet" method="post">
								<td>用户名<input type="text" id="name" name="name"></td>
								<td>
								<td>内容<input type="text" id="content" name="content"></td>
								</td>
								<td><input type="submit" value="留言"></td>
							</form>
						</tr>

					</table>
				</section>
			</article>
			</div>
			<div id="foot"></div>
			<script type="text/javascript">
				$("#head").load("head.jsp");
				$("#foot").load("foot.html");
			</script>
</body>
</html>