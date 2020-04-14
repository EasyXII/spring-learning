package note.dao;

import note.vo.Person;

public interface PersonDAO {
   //��¼��֤
	public boolean login(Person person) throws Exception;
   //�û�ע��
	public boolean register(Person person) throws Exception;
   //���ע���û��Ƿ����
	public boolean checkUser(Person person) throws Exception;
   //��ѯ�û�id
	public String QueryId(Person person) throws Exception;
   //����id��ѯ�û�
	public boolean checkUserById(String id) throws Exception;
   //����id�����û���Ϣ
	public Person checkPersonById(String id) throws Exception;
   //�޸���ͨ���ʼ����м����û�
	public void update(String id) throws Exception;
	//�޸��û���Ϣ
  	public void update(Person person ) throws Exception;
}
