package note.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import note.dao.NoteDAO;
import note.daoImpl.NoteDAOImpl;
import note.util.SplitPage;
import note.vo.Note;

public class ShowNoteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		SplitPage sPage = new SplitPage();
		NoteDAO note = new NoteDAOImpl();
		String flag = request.getParameter("flag");// ��ҳʱ�ķ���ֵ������SplitSpage�е������ע
		// ÿ��ˢ��ҳ��ʱ��Ӧ�����»�ñ��еļ�¼������Ϊ��ҳʱ
		int totalRows = 0;// �ܵļ�¼��
		int currentPage = 0;
		String strItem = request.getParameter("item");
		String strContent = request.getParameter("content");
		List<Note> list = null;
		HashMap<String, String> tm = new HashMap<>();
		try {
			if (strContent == null || strContent.equals("") || strContent.equals("null")) {
				totalRows = note.getRows(tm);
				sPage.setTotalRows(totalRows);
				currentPage = sPage.confirmPage(flag);
				list = note.queryByLike(tm, sPage);
			} else {// ʹ��������
				tm.put(strItem, strContent);
				totalRows = note.getRows(tm);
				sPage.setTotalRows(totalRows);
				currentPage = sPage.confirmPage(flag);
				list = note.queryByLike(tm, sPage);
			}
			//�������ݲ���ת
			request.setAttribute("notes", list);
			request.getSession().setAttribute("spage", sPage);
			request.setAttribute("strItem", strItem);
			request.setAttribute("strContent", strContent);
			request.getRequestDispatcher("list_note_new.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
