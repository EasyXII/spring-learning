package cn.dao;

import java.util.List;

import cn.domain.Post;

/**
 *  ���ӵ�DAO�ӿ�
 */
public interface PostDAO {
    /**
               * ����һ������
     * @param post
     * @return 
     */
	int insertPost(Post post);
	
	/**
	 * ɾ������Ϊpost_id������
	 * @param post_id
	 * @return 
	 */
	int deletePost(int post_id);
	
	/**
	 * ����������ȡ������Ϣ
	 * @param post_id
	 * @return post����
	 */
	Post getPostById(int post_id);
	
	/**
	 * �޸�������Ϣ
	 * @param post
	 * @return
	 */
	int updatePost(Post post);
	
	/**
	 * ��ȡָ����̳���������ӵ���Ϣ
	 * @param forum_id
	 * @return ���Ӽ���
	 */
	List<Post> getPostsByForumId(int forum_id);
	
	/**
	 * ͳ��ָ����̳����������
	 * @param forum_id
	 * @return
	 */
	int getCountByForumId(int forum_id);
}
