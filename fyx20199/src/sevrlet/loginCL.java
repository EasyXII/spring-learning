package sevrlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;
import model.userDaoSQLSeverImpl;

/**
 * Servlet implementation class loginCL
 */
@WebServlet("/loginCL")
public class loginCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    //接收Form表单中标签的内容
		String username = request.getParameter("uname");
		String password = request.getParameter("upass");
		Users user =new Users();
		user.setUsername(username);
		user.setPassword(password);
		System.out.println(username+password+1);
		userDaoSQLSeverImpl userdao = new userDaoSQLSeverImpl();
		HttpSession hs = request.getSession(true);
		if(userdao.findUser(user)) {
			hs.setAttribute("username", user.getUsername());
			request.getRequestDispatcher("Welcome").forward(request,response);
			//response.sendRedirect("Welcome?username="+username+"&password="+password);
		}else {
			response.sendRedirect("login");
		}
		/*if("fyx".equals(username)&&"123".equals(password)) {
			response.sendRedirect("Welcome?username="+username+"&password="+password);
		}else {
			response.sendRedirect("login");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
