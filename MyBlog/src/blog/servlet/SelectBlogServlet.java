package blog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.dao.BlogDAO;
import blog.daoImpl.BlogDAOImpl;
import blog.factory.DAOFactory;
import blog.vo.Blog;
import blog.util.SplitPage;


/**
 * Servlet implementation class SelectBlogServlet
 */
@WebServlet("/SelectBlogServlet")
public class SelectBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBlogServlet() {
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
		int totalRows = 0;
		int currentPage = 0;
		String flag = request.getParameter("flag");
		String select = request.getParameter("select");
		BlogDAO blog = new BlogDAOImpl();
		SplitPage sPage = new SplitPage();
        try {
        	if(select != null) {
        		totalRows = blog.getRows(select);
        		sPage.setTotalRows(totalRows);
        		currentPage = sPage.confirmPage(flag);
        		DAOFactory.getBlogDAOImpl().queryByLike(select, sPage);
        	}else {
        		totalRows = blog.getRows(select);
        		sPage.setTotalRows(totalRows);
        		currentPage = sPage.confirmPage(flag);
        		DAOFactory.getBlogDAOImpl().queryAll();
        	}
        	request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
        }catch (Exception e) {
			e.printStackTrace();
		}
	}

}
