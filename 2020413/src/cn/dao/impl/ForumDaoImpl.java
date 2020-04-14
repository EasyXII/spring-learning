package cn.dao.impl;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import cn.dao.ForumDao;
import cn.domain.Forum;
import cn.utils.MybatisUtils;

public class ForumDaoImpl implements ForumDao {

	SqlSession session;

	@Override
	public int insertForum(Forum forum) throws IOException{
		session=MybatisUtils.getSession();
		int result=session.insert("insertForum",forum);
		session.commit();
		session.close();
		 session.commit();
	     session.close();
		return result;
	
	}

	@Override
	public List<Forum> getAllForums() {
		session=MybatisUtils.getSession();
		List<Forum> forums=session.selectList("getAllForums");
        return forums;
	}

}
