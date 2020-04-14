package cn.dao;

import java.util.List;

import cn.domain.Post;

/**
 *  帖子的DAO接口
 */
public interface PostDAO {
    /**
               * 新增一条帖子
     * @param post
     * @return 
     */
	int insertPost(Post post);
	
	/**
	 * 删除主键为post_id的帖子
	 * @param post_id
	 * @return 
	 */
	int deletePost(int post_id);
	
	/**
	 * 根据主键获取帖子信息
	 * @param post_id
	 * @return post对象
	 */
	Post getPostById(int post_id);
	
	/**
	 * 修改贴子信息
	 * @param post
	 * @return
	 */
	int updatePost(Post post);
	
	/**
	 * 获取指定论坛的所有贴子的信息
	 * @param forum_id
	 * @return 贴子集合
	 */
	List<Post> getPostsByForumId(int forum_id);
	
	/**
	 * 统计指定论坛的帖子数量
	 * @param forum_id
	 * @return
	 */
	int getCountByForumId(int forum_id);
}
