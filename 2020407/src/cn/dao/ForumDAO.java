package cn.dao;

import java.util.List;

import cn.domain.Forum;

/**
 * ��̳DAO�ӿ�
 */
public interface ForumDAO {
   /**
            *  �½�һ����̳��Ϣ
    * @param forum
    * @return ��Ӱ��ļ�¼����  
    */
	int insertForum(Forum forum);
	
	/**
	    *  ��ȡ������̳��Ϣ
	 * @return ��̳����  
	 */
	List<Forum> getAllForums();
}
