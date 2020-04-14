package note.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import note.factory.DAOFactory;
import note.vo.Person;
import com.jspsmart.upload.*;
@WebServlet("/uploadImage")

public class uploadImageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session=req.getSession();
		PrintWriter out=resp.getWriter();
		JspFactory fac=JspFactory.getDefaultFactory();
		PageContext pageContext=fac.getPageContext(this, req,resp, null, false, JspWriter.NO_BUFFER, true);
		com.jspsmart.upload.File file = null;
		
		String id=(String)session.getAttribute("id");
		out.println("<html>");		
		out.println("<body><center><h3>");	
		//System.out.println("<%=id%>"+id);
		//�½��ϴ�����
		SmartUpload su=new SmartUpload();
		// �ϴ���ʼ��
		su.initialize(pageContext);
		// �趨�ϴ�����
		// ����ÿ���ϴ��ļ�����󳤶ȡ�
		 su.setMaxFileSize(20000);
		// �������ϴ����ݵĳ��ȡ�
		// su.setTotalMaxFileSize(20000);
		//ͨ����չ�������趨�����ϴ����ļ�,���������doc,txt�ļ���
		 su.setAllowedFilesList("gif,bmp,jpg");
		// ͨ����չ�������趨��ֹ�ϴ����ļ�,��ֹ�ϴ�����exe,bat,jsp,htm,html��չ�����ļ���û����չ�����ļ���
		// su.setDeniedFilesList("exe,bat,jsp,htm,html,,");
		// ʵ���ļ��ϴ�
		try {
			su.upload();
		
		// ���ϴ��ļ�ȫ�����浽ָ��Ŀ¼,���뱣֤uploadĿ¼��Ӧ�ó�����ļ����д���
		su.save("/images/face", su.SAVE_VIRTUAL);
		//��ʾ�ɹ��ϴ��ļ�����
		//out.println(count+"���ļ��ϴ��ɹ���<br>");
		// ��һ��ȡ�ϴ��ļ���Ϣ��ͬʱ�ɱ����ļ���
		for (int i=0;i<su.getFiles().getCount();i++)
		{
			file = su.getFiles().getFile(i);
			// ���ļ������������
			if (file.isMissing()) continue;
			// ��ʾ��ǰ�ļ���Ϣ
			//out.println("<br>�ļ�����" + file.getSize());
			//out.println("<br>�ļ�����" + file.getFileName()+"�����ȣ�"+file.getSize());
		}
		Person person=new Person();
		person.setId(id);
		System.out.println("file name"+file.getFileName());
		person.setImage("images/face/"+file.getFileName());
		DAOFactory.getPersonDAOInstance().update(person);
		session.setAttribute("image",person.getImage());
		out.print("<script language=javascript>alert('ͷ���ϴ��ɹ�������');" +
				"window.location.href='list_notes.jsp';</script>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("<script language=javascript>alert('ͷ���ϴ�ʧ�ܣ����������ļ���ʽ�ʹ�С��');" +
					"window.location.href='userInfor.jsp';</script>");
		}
		out.println("</h3></center></body></html>");
	}
	

}
