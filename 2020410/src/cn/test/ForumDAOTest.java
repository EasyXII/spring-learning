package cn.test;

import org.junit.jupiter.api.Assertions;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cn.dao.ForumDAO;
import cn.domain.Forum;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
class ForumDAOTest {
	@Autowired
	private ForumDAO forumDAO;
	
	@Test
	void insertForumTest() {
		Forum forum = new Forum("spring论坛","spring项目交流","图片1");
	    forumDAO.insertForum(forum);
	}
	
	@Test
	void getAllForumsTest() {
		List<Forum> forum = forumDAO.getAllForums();
		for (Forum forum11 : forum) {
			System.out.println(forum11.toString());
		}
	}

}
