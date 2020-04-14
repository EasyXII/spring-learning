<%@page import="blog.util.*"%>
<%@ page import="java.util.*"%>
<%@ page import="blog.vo.*"%>
<%@ page import="blog.dao.*"%>
<%@ page import="blog.daoImpl.*"%>
<%@ page import="blog.factory.*"%>
<%@ page import="blog.servlet.*"%>
<%@ page import="blog.util.SplitPage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<style type="text/css">
html, body {
	height: 100%;
	background: url("b2.jpg");
	=
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
	<div class="box">
		<div id="head"></div>
		<article>
			<section>
				<center>
					<table width="80%" height="600px" border="1" cellpadding="0"
						>
						<tr>
							<td align="center">作者</td>
							<td align="center">内容</td>
							<td align="center">题目</td>
							<td align="center">类型</td>
							<td align="center">发表时间</td>
						</tr>
						<%
							request.setCharacterEncoding("UTF-8");
							response.setContentType("text/html");
							int totalRows = 0;
							int currentPage = 0;
							String flag = request.getParameter("flag");
							String select = request.getParameter("select");
							BlogDAO blog = new BlogDAOImpl();
							SplitPage sPage = new SplitPage();
							ArrayList<Blog> list = null;
							if (select != null) {
								totalRows = blog.getRows(select);
								sPage.setTotalRows(totalRows);
								currentPage = sPage.confirmPage(flag);
								list = DAOFactory.getBlogDAOImpl().queryByLike(select, sPage);
							} else {
								totalRows = blog.getRows(select);
								sPage.setTotalRows(totalRows);
								currentPage = sPage.confirmPage(flag);
								list = DAOFactory.getBlogDAOImpl().queryAll();
							}
							for (Blog b : list) {
						%>
						<tr>
							<br>
							<td><%=b.getAuthor()%></td>
							<td><%=b.getContent()%></td>
							<td><%=b.getTitle()%></td>
							<td><%=b.getType()%></td>
							<td><%=b.getTime()%></td>
						</tr>
						<%
							}
						%>
					</table>
				</center>
			</section>
			<section>
				<tr>
					<center>
						<td colspan="5" align="center"><a
							href="HomePage.jsp?flag=<%=SplitPage.FIRSTPAGE%>?select=<%=select%>">首页</a>
							<a
							href="HomePage.jsp?flag=<%=SplitPage.PREVIOUSEPAGE%>?select=<%=select%>">上一页</a>
							<a
							href="HomePage.jsp?flag=<%=SplitPage.NEXTPAGE%>?select=<%=select%>">下一页</a>
							<a
							href="HomePage.jsp?flag=<%=SplitPage.LASTPAGE%>?select=<%=select%>">尾页</a>
						</td>
					</center>
				</tr>
			</section>
		</article>
		<div id="foot"></div>
		<script type="text/javascript">
			$("#head").load("head.jsp");
			$("#foot").load("foot.html");
		</script>
	</div>
</body>
</html>