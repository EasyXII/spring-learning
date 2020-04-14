package blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.factory.DAOFactory;
import blog.vo.Blog;

/**
 * Servlet implementation class InsertBlogServlet
 */
@WebServlet("/InsertBlogServlet")
public class InsertBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBlogServlet() {
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
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		Blog blog = new Blog();
		blog.setAuthor(author);
		blog.setContent(content);
		blog.setTitle(title);
		blog.setType(type);
		try {
			if(author != null || content != null || title != null || type != null) {
				DAOFactory.getBlogDAOImpl().insert(blog);
				out.print("<html>");
				out.print("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head>");
				out.print("<script language=javascript>alert('添加成功！！！');" +
						"window.location.href='insertdeleteblog.jsp';</script>");
				out.print("</html>");
			}
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}

}
