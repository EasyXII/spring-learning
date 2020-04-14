package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

import model.Users;
import model.userDaoSQLSeverImpl;

/**
 * Servlet implementation class LoginCLServlet
 */
@WebServlet("/LoginCLServlet")
public class LoginCLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() {
		try {
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
			this.getServletContext().setAttribute("visitTimes",numVal);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
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
		String username = request.getParameter("uname");
		String password = request.getParameter("upass");
		Users user =new Users();
		user.setUsername(username);
		user.setPassword(password);
		userDaoSQLSeverImpl userdao = new userDaoSQLSeverImpl();
		HttpSession hs = request.getSession(true);
		String times = this.getServletContext().getAttribute("visitTimes").toString();
		this.getServletContext().setAttribute("visitTimes", (Integer.parseInt(times)+1)+""); 
		
		List<HashMap> lists = new ArrayList<HashMap>();
		if(userdao.findUser(user)) {
			lists = userdao.search(0, 3);
			int pageCount=userdao.searchCount();
			request.setAttribute("result", lists);
			request.setAttribute("pageNow", "1");
			request.setAttribute("pageCount",pageCount+"");
			hs.setAttribute("username", user.getUsername());
			request.getRequestDispatcher("main.jsp").forward(request,response);
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

	public void destory() {
		try {
			//写回文件
			//创建一个FileWriter
			FileWriter q = new FileWriter("f:\\11.txt");
			BufferedWriter cw = new BufferedWriter(q);
			cw.write(this.getServletContext().getAttribute("visitTimes").toString());
			cw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
}
}
