package cn.dao;

import java.util.List;

import cn.domain.Forum;

/**
 * 论坛DAO接口
 */
public interface ForumDAO {
   /**
            *  新建一个论坛信息
    * @param forum
    * @return 受影响的记录行数  
    */
	int insertForum(Forum forum);
	
	/**
	    *  获取所有论坛信息
	 * @return 论坛集合  
	 */
	List<Forum> getAllForums();
}
