package sevrlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
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
		
		//String username = request.getParameter("username");
		//String password = request.getParameter("password");
		HttpSession hs=request.getSession(true);
		
		String username = (String)hs.getAttribute("username");
		String password = (String)hs.getAttribute("password");
		if(username!=null) {
			out.println("欢迎"+username);
			out.println("您的密码是："+password);
			out.println("<img src=images/1.gif>");
			out.println("<form action=InsertCL method=post>");
			out.println("<input type=submit value=添加><br>");
			out.println("</form></center><hr>");
			out.println("<form action=DeleteCL method=post>");
			out.println("<input type=submit value=删除><br>");
			out.println("</form></center><hr>");
			out.println("<form action=SearchCL method=post>");
			out.println("<input type=submit value=查询人数><br>");
			out.println("</form></center><hr>");
		}else {
			response.sendRedirect("login");
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
