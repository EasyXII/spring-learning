package cn.dao;

import java.io.IOException;
import java.util.List;

import cn.domain.Forum;

public interface ForumDao {
	/**
	 * 新增一个论坛信息
	 * @param forum
	 * @return 受影响的记录条数
	 */
	int insertForum(Forum forum)throws IOException;
	/**
	 * 获取所有论坛信息
	 * @return 论坛集合
	 */
	List<Forum> getAllForums();

}
