<%@ page import="java.util.*" %>
<%@ page import="note.dao.*" %>
<%@ page import="note.daoImpl.*" %>
<%@ page import="note.servlet.*" %>
<%@ page import="note.vo.*" %>
<%@ page import="note.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言板</title>
 <script type="text/javascript">
        function go(){
            var goPage=document.all.selectpage.value;
            alert("我们将去页面:list_notes.jsp?flag="+goPage);
            document.open("list_notes.jsp?flag="+goPage,"_self","");
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
 <h3><a href="list_note.jsp?flag=first">显示所有留言</a></h3>
 <form action="list_note.jsp?flag=first" metho>
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
 
 <% if(session.getAttribute("me")!=null){  %>
	 <jsp:useBean id="spage" class="note.util.SplitPage" scope="session"></jsp:useBean>
	 <%
	 NoteDAO note = new NoteDAOImpl();
	 String flag = request.getParameter("flag");//翻页时的方向值，即是SplitSpage中的请求标注
	 //每次刷新页面时都应当重新获得表中的记录数，因为翻页时
	 int totalRows = 0;//总的记录数
	 int currentPage = 0;
	 %>
 <table width="80%" border="1" cellpadding="0" align="center">
      <tr>
          <td>留言ID</td>
          <td>标题</td>
          <td>作者</td>
          <td>内容</td>
          <td>删除</td>
      </tr> 
      
      <%
         request.setCharacterEncoding("UTF-8");
         String strItem = request.getParameter("item");
         String strContent = request.getParameter("content");
         List<Note> list = null;
         HashMap<String,String> tm = new HashMap<>();
         if(strContent==null){//没有搜索
        	 totalRows = note.getRows(tm);
        	 spage.setTotalRows(totalRows);
        	 currentPage = spage.confirmPage(flag);
        	 list=note.queryByLike(tm,spage);
         }else{//使用了搜素
        	 tm.put(strItem,strContent);
             totalRows = note.getRows(tm);
             spage.setTotalRows(totalRows);
             currentPage = spage.confirmPage(flag);
             list = note.queryByLike(tm,spage);
         }
         list = note.findAll(spage);
         for(Note n:list){
      %>  
      <tr>
          <td><%=n.getId()%></td>
          <td><%=n.getTitle()%></td>
          <td><%=n.getAuthor()%></td>
          <td><%=n.getContent()%></td>
          <td>删除</td>
      </tr>	 
     <% 
     }
 %>
      <tr>
         <td colspan="5" align="right">
         <a href="list_notes.jsp?flag=<%=SplitPage.FIRSTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">首页</a>
         <a href="list_notes.jsp?flag=<%=SplitPage.PREVIOUSEPAGE%>&item=<%=strItem%>&content=<%=strContent%>">上一页</a>
         <a href="list_notes.jsp?flag=<%=SplitPage.NEXTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">下一页</a>
         <a href="list_notes.jsp?flag=<%=SplitPage.LASTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">尾页</a>
         <select id="selectpage" name="goPage" onchange="javaScript:go()">
                 <%for(int i=1;i<=spage.getTotalPages();i++){%>
                 <option value="<%=i%>" <%=(spage.getCurrentPage()==1)?"selected='selected'":""%>><%=i%>/<%=spage.getTotalPages()%></option>
                 <%}%>
         </select>
         </td>
      </tr>
 
 </table>
  <% 
     }
 %>
</center>
</body>
</html> 