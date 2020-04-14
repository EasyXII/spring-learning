package blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.daoImpl.BloggerDAOImpl;
import blog.factory.DAOFactory;
import blog.vo.Blogger;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		Blogger blogger = new Blogger();
		blogger.setId(id);
		blogger.setPassword(password);
		HttpSession session = request.getSession();
		String rand = (String) session.getAttribute("rand");
		String input = request.getParameter("verify");
		String path = null;
		try {
			if(DAOFactory.getBloggerDAOImpl().login(blogger) && input.equals(rand)) {
				session.setAttribute("name", blogger.getName());
				session.setAttribute("email", blogger.getImage());
				session.setAttribute("signature", blogger.getSignature());
				session.setAttribute("image", blogger.getImage());
				System.out.println(11111);
				path = "Main.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}else {
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<body><center><h3>");
				out.println("登录不成功");
				out.println("<a href='login.html'>返回</a>");
				out.println("</h3></center></body>");
				out.println("</html>");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
