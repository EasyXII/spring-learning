package cn.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import cn.dao.ForumDao;
import cn.dao.impl.ForumDaoImpl;
import cn.domain.Forum;

class ForumDaoTest {
	ForumDao  forumdao = new ForumDaoImpl();
	@Test
    public void insertForum() throws IOException {
        //执行添加方法
        Forum forum=new Forum();
        forum.setName("这是名字");
        forum.setDescription("这是简介");
        forum.setImage("这是图片");
        forumdao.insertForum(forum);
       
    }
    @Test
    public void getAllForums() throws IOException {
        List<Forum> forums = forumdao.getAllForums();
        System.out.println(forums.toString());
    }
}

