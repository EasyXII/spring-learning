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
import javax.servlet.http.HttpSession;

import model.Notes;
import model.userDaoSQLSeverImpl;

/**
 * Servlet implementation class LoginCLServlet
 */
@WebServlet("/LoginCLServlet")
public class LoginCLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String password = request.getParameter("upass");
		Notes person = new Notes();
		person.setName(name);
		person.setPassword(password);
		System.out.println(name+password+1);
		userDaoSQLSeverImpl userdao = new userDaoSQLSeverImpl();
		HttpSession hs = request.getSession(true);
		List<HashMap> lists = new ArrayList<HashMap>();
		if(userdao.findUser(person)) {
			lists = userdao.search(0, 3);
			int pageCount=userdao.searchCount();
			request.setAttribute("result", lists);
			request.setAttribute("pageNow", "1");
			request.setAttribute("pageCount",pageCount+"");
			hs.setAttribute("name", person.getName());
	    if(name.equals("manager")) {
			request.getRequestDispatcher("admin/welcomemanager.jsp").forward(request,response);
			}else {
			   request.getRequestDispatcher("admin/welcomeuser.jsp").forward(request,response);
			}
		}else {
			response.sendRedirect("login.jsp");
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
