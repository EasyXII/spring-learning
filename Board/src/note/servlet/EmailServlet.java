package note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import note.factory.DAOFactory;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
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
		//把person的active列的值由0改成1
		String id = request.getParameter("id");
		String active = request.getParameter("active");
		out.println("<html>");
		out.println("<body><center><h3>");
		try {
			if(DAOFactory.getPersonDAOInstance().checkUserById(id)) {
				if(DAOFactory.getPersonDAOInstance().checkPersonById(id).getActive().equals("0")) {
					DAOFactory.getPersonDAOInstance().update(id);
					out.println("账号激活成功！<a href='http://localhost:8080/Board/login.html'>请登录</a>");
				}else {//直接转向登录页面
					out.println("账号连接失败<a href='http://localhost:8080/Board/login.html'>请登录</a>");
				}
			}else {
				out.println("账号激活失败！！<a href='register.jsp'>请重新注册！！</a>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.println("</h3></center></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
