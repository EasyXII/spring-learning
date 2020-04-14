package note.util;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.*;


import note.vo.Person;
/**\
 * 
 * ʹ��JavaMail�����ʼ�
 *
 */
public class Mail {
	public Mail(Person  person) {
		try {
			// ������ԣ�������Session����
			Properties props = new Properties();
			Session sendsession;
			Transport transport;
			sendsession = Session.getInstance(props, null);
			// ��������д��SMTP�������ĵ�ַ
			props.put("mail.smtp.host", "smtp.qq.com");
			// ����SMTP��������ҪȨ����֤
			props.put("mail.smtp.auth", "true");
			//MyAuthenticator myauth = new MyAuthenticator("workniit@163.com", "99081035c");
			// �������������Ϣ
			sendsession.setDebug(true);
			// ����Session����Message����
			Message message = new MimeMessage(sendsession);
			// ���÷����˵�ַ
			message.setFrom(new InternetAddress("1095580075@qq.com"));
			// ���������˵�ַ
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(person.getEmail()));
			// ����e-mail����
			message.setSubject("���ã���л��ע�ᣡ");
			// ����e-mail����ʱ��
			message.setSentDate(new Date());
			// ����e-mail����			
			message.setContent(person.getName()+"���뾭�����ʱ���վ��" +
					"  <br><a href='http://localhost:8080/Board/EmailServlet?id="+person.getId()+"&active="+person.getActive()+"'>���������ʺ�</a>", "text/html;charset=UTF-8");
			//message.setContent(person.getName()+"����ϲ��ע��ɹ����뾭�����ʱ���վ��" +
			//		"  <br><script type='text/javascript'>function goToClient(){window.location.href='verify.jsp?id="+person.getId()+";} </script>"+ 
            //"<a href='#' onclick='javascript:goToClient();'>���������ʺ�</a> ", "text/html;charset=gbk");
			// �������Email.���޸�
			message.saveChanges();
			// ����Session����Transport����
			transport = sendsession.getTransport("smtp");
			// ���ӵ�SMTP������
			transport.connect("smtp.qq.com", "1095580075", "ypewqlbjoosrhhff");// !!!!!******ע���޸�************
			// ����e-mail
			transport.sendMessage(message, message.getAllRecipients());
			// �ر�Transport����
			transport.close();

		} catch (MessagingException me) {
			me.printStackTrace();
		}

	}

}
