package cn.dao;

import java.io.IOException;
import java.util.List;

import cn.domain.Post;

public interface PostDao {
	/**
	 * ����һ������
	 * @param post
	 * @return
	 */
	int insertPost(Post post)throws IOException;
	/**
	 *ɾ������Ϊpost_id������
	 *@param post_id
	 *@return 
	 */
	int deletePost(int post_id)throws IOException;
	/**
	 * ����������ȡ������Ϣ
	 *@param post_id
	 *@return
	 */
	Post getPostById(int post_id)throws IOException;
	/**
	 * �޸�������Ϣ
	 * @param post
	 * @return
	 */
	int updatePost(Post post)throws IOException;
	/**
	 * ��ȡָ����̳������������Ϣ
	 * @param forum_id
	 * @return ���Ӽ���
	 */
	List<Post> getPostsByForumId(int forum_id)throws IOException;
	/**
	 * ͳ��ָ����̳����������
	 * @param forum����id
	 * @return
	 */
	int getCountByForumId(int forum_id)throws IOException;
	
	
}
