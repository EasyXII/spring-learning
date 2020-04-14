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
import note.util.Mail;
import note.vo.Person;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		out.println("<html>");
		out.println("<body><center><h3>");
		String name = request.getParameter("name");
		String password  = request.getParameter("password");
		String passwordok = request.getParameter("passwordok");
		String email = request.getParameter("email");
		String flag = request.getParameter("flag");
		String avatar = request.getParameter("images");
		Person person = new Person();
		person.setName(name);
		person.setPassword(password);
		person.setEmail(email);
		person.setFlag(flag);
		person.setActive("0");
		person.setImage(avatar);
		HttpSession session = request.getSession();
		try {
			if(!DAOFactory.getPersonDAOInstance().checkUser(person)) {
				if(password.equals(passwordok)) {
					DAOFactory.getPersonDAOInstance().register(person);
		            person.setId(DAOFactory.getPersonDAOInstance().QueryId(person));
		            new Mail(person);
		            int i = email.indexOf("@");
		            out.println("注册成功！！注册邮件已发往您的邮箱！！");
		            out.println("<a href='http://mail."+email.substring(i+1)+"'>请进入注册邮箱激活账号！！</a>");
		            response.setContentType("text/html");
	            	response.setCharacterEncoding("UTF-8");
	            	PrintWriter out1 = response.getWriter();
	            	out1.println("<html>");
	            	out1.println("<body><center><h3>");
	            	out1.println("注册成功！！！");
	            	out1.println("<a href='register.jsp'></a>");
	            	out1.println("</h3></center></body>");
	            	out1.println("</html>");
				}else {
					response.setContentType("text/html");
	            	response.setCharacterEncoding("UTF-8");
	            	PrintWriter out1 = response.getWriter();
	            	out1.println("<html>");
	            	out1.println("<body><center><h3>");
	            	out1.println("两次密码不正确！");
	            	out1.println("<a href='register.jsp'></a>");
	            	out1.println("</h3></center></body>");
	            	out1.println("</html>");
				}
			}else {
				response.setContentType("text/html");
            	response.setCharacterEncoding("UTF-8");
            	PrintWriter out1 = response.getWriter();
            	out1.println("<html>");
            	out1.println("<body><center><h3>");
            	out1.println("此用户已被注册过，请注册其他账号！");
            	out1.println("<a href='register.jsp'></a>");
            	out1.println("</h3></center></body>");
            	out1.println("</html>");
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.println("</h3></center></body>");
		out.println("</html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
