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
		//��person��active�е�ֵ��0�ĳ�1
		String id = request.getParameter("id");
		String active = request.getParameter("active");
		out.println("<html>");
		out.println("<body><center><h3>");
		try {
			if(DAOFactory.getPersonDAOInstance().checkUserById(id)) {
				if(DAOFactory.getPersonDAOInstance().checkPersonById(id).getActive().equals("0")) {
					DAOFactory.getPersonDAOInstance().update(id);
					out.println("�˺ż���ɹ���<a href='http://localhost:8080/Board/login.html'>���¼</a>");
				}else {//ֱ��ת���¼ҳ��
					out.println("�˺�����ʧ��<a href='http://localhost:8080/Board/login.html'>���¼</a>");
				}
			}else {
				out.println("�˺ż���ʧ�ܣ���<a href='register.jsp'>������ע�ᣡ��</a>");
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
