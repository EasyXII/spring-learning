package blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.factory.DAOFactory;
import blog.vo.Messageboard;

/**
 * Servlet implementation class LeaveWordServlet
 */
@WebServlet("/LeaveWordServlet")
public class LeaveWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	    String name = request.getParameter("name");
	    String content = request.getParameter("content");
	    Messageboard mb = new Messageboard();
	    mb.setName(name);
	    mb.setContent(content);
	    try {
	    	if(name != null || content != null) {
	        DAOFactory.getMessageBoardDAOImpl().insert(mb);
	        out.print("<html>");
			out.print("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head>");
			out.print("<script language=javascript>alert('留言成功！！！');" +
					"window.location.href='MessageBoard.jsp';</script>");
			out.print("</html>");
	    	}
	    }catch (Exception e) {
			e.printStackTrace();
		}
	}

}
