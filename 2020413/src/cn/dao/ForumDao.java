package cn.dao;

import java.io.IOException;
import java.util.List;

import cn.domain.Forum;

public interface ForumDao {
	/**
	 * ����һ����̳��Ϣ
	 * @param forum
	 * @return ��Ӱ��ļ�¼����
	 */
	int insertForum(Forum forum)throws IOException;
	/**
	 * ��ȡ������̳��Ϣ
	 * @return ��̳����
	 */
	List<Forum> getAllForums();

}
