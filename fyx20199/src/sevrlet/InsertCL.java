package sevrlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;
import model.userDaoSQLSeverImpl;

/**
 * Servlet implementation class InsertCL
 */
@WebServlet("/InsertCL")
public class InsertCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		String userid = request.getParameter("uid");
		String username = request.getParameter("uname");
		String password = request.getParameter("upass");
		Users user = new Users();
		user.setUserID(userid);
		user.setUsername(username);
		user.setPassword(password);
		userDaoSQLSeverImpl userdao = new userDaoSQLSeverImpl();
		if(userdao.findUser(user)) {
			System.out.println("用户已存在！！！");
			response.sendRedirect("Welcome");
		}else {
			userdao.insert(user);
			response.sendRedirect("Welcome");
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
