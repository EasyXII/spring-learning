package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;
import model.userDaoSQLSeverImpl;

/**
 * Servlet implementation class UserCLServlet
 */
@WebServlet("/UserCLServlet")
public class UserCLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag=request.getParameter("flag");
		if(flag.equals("fenye")) {
			String s_pageNow = request.getParameter("pageNow");
	        int pageNow = Integer.parseInt(s_pageNow);
	        userDaoSQLSeverImpl userdao = new userDaoSQLSeverImpl();
	        List<HashMap> lists=new ArrayList<HashMap>();
	        lists=userdao.search((pageNow-1)*3, 3);
	        int pageCount = userdao.searchCount();
	       
	        request.setAttribute("result",lists);
	        request.setAttribute("pageCount", pageCount+"");
	        request.setAttribute("pageNow", pageNow+"");
	        request.getRequestDispatcher("Welcome.jsp").forward(request,response);
		}else if(flag.equals("delUser")) {
			//完成删除
			//得到要删除的Id号
			int index=Integer.parseInt(request.getParameter("userId"));
			userDaoSQLSeverImpl userdao=new userDaoSQLSeverImpl();
			if (userdao.delete(index)==1) {
			    request.getRequestDispatcher("success.jsp").forward(request, response);
			}else {
			    request.getRequestDispatcher("err.jsp").forward(request, response);
			}
		}else if(flag.equals("adduser")) {
			//完成添加
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String s_grade=request.getParameter("grade");
			int grade=Integer.parseInt(s_grade);
			Users user=new Users();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
		    user.setGrade(grade);
		    userDaoSQLSeverImpl userdao=new userDaoSQLSeverImpl();
			if (userdao.insert(user)==1) {
			    request.getRequestDispatcher("success.jsp").forward(request, response);
			}else {
			    request.getRequestDispatcher("err.jsp").forward(request, response);
			}
			
		}else if(flag.equals("updateuser")) {
			//完成修改
			Users user=new Users();
			String s_userID=(String)request.getParameter("userID");
			int userID = Integer.parseInt(s_userID);
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String s_grade=request.getParameter("grade");
			int grade = Integer.parseInt(s_grade);
			user.setUserID(userID);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setGrade(grade);
			userDaoSQLSeverImpl userdao=new userDaoSQLSeverImpl();
			if(userdao.update(user)==1) {
			   request.getRequestDispatcher("success.jsp").forward(request, response);	
			}else {
				request.getRequestDispatcher("err.jsp").forward(request, response);
			}
			//完成添加
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
