package blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.factory.DAOFactory;
import blog.vo.Blogger;

/**
 * Servlet implementation class UpdateBloggerServlet
 */
@WebServlet("/UpdateBloggerServlet")
public class UpdateBloggerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBloggerServlet() {
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
		PrintWriter out=response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String signature = request.getParameter("signature");
		String image = request.getParameter("image");
		Blogger blogger = new Blogger();
		blogger.setName(name);
		blogger.setEmail(email);
		blogger.setSignature(signature);
		blogger.setImage(image);
		try {
			if(name != null || email != null || signature != null || image != null) {
				DAOFactory.getBloggerDAOImpl().update(blogger);
				out.print("<html>");
				out.print("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head>");
				out.print("<script language=javascript>alert('信息修改成功！！！');" +
						"window.location.href='BloggerXG.jsp';</script>");
				out.print("</html>");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
