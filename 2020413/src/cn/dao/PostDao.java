package cn.dao;

import java.io.IOException;
import java.util.List;

import cn.domain.Post;

public interface PostDao {
	/**
	 * 新增一条帖子
	 * @param post
	 * @return
	 */
	int insertPost(Post post)throws IOException;
	/**
	 *删除主键为post_id的帖子
	 *@param post_id
	 *@return 
	 */
	int deletePost(int post_id)throws IOException;
	/**
	 * 根据主键获取帖子信息
	 *@param post_id
	 *@return
	 */
	Post getPostById(int post_id)throws IOException;
	/**
	 * 修改帖子信息
	 * @param post
	 * @return
	 */
	int updatePost(Post post)throws IOException;
	/**
	 * 获取指定论坛的所有帖子信息
	 * @param forum_id
	 * @return 帖子集合
	 */
	List<Post> getPostsByForumId(int forum_id)throws IOException;
	/**
	 * 统计指定论坛的帖子数量
	 * @param forum——id
	 * @return
	 */
	int getCountByForumId(int forum_id)throws IOException;
	
	
}
