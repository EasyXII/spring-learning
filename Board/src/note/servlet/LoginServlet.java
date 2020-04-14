package note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import note.factory.DAOFactory;
import note.vo.Person;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 取得登录页面的用户名和密码
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String flag = request.getParameter("flag");
		Person person = new Person();
		person.setName(name);
		person.setPassword(password);
		person.setFlag(flag);
		HttpSession session = request.getSession();
		String rand = (String) session.getAttribute("rand");
		String input = request.getParameter("verify");
		String path = null;
		try {
			if (DAOFactory.getPersonDAOInstance().login(person) && input.equals(rand)) {
				session.setAttribute("me", person.getName());
				session.setAttribute("image", person.getImage());
				session.setAttribute("id", person.getId());
				if (person.getActive().equals("1")) {
					path = "login_success.jsp";
					request.getRequestDispatcher(path).forward(request, response);
				} else {
					response.setContentType("text/html");
					response.setCharacterEncoding("UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<html>");
					out.println("<body><center><h3>");
					out.println("您的账号还没有激活，请进入邮箱进行激活！！");
					out.println("<a href='login.html'></a>");
					out.println("</h3></center></body>");
					out.println("</html>");
				}
			} else {
				path = "error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
