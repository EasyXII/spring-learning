package cn.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import cn.dao.PostDao;
import cn.dao.impl.PostDaoImpl;
import cn.domain.Post;
import cn.utils.MybatisUtils;

class PostDaoTest {
	PostDao postdao = new PostDaoImpl();
	@Test//����
    public void insertPost() throws  Exception{
       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
       byte[] a = {1}; 
       Post post=new Post();
       post.setForum_id(6);
       post.setTitle("hello");
       post.setContent("hello file");
       post.setThumbnail(a);
       post.setPost_time(timestamp);
       post.setAccount("1000000");
       //ִ�����ӷ���
       postdao.insertPost(post);
       
    }
    @Test//ɾ��
    public void deletePost()throws IOException {
        postdao.deletePost(3);
    }
    @Test//��ѯforum_id����
    public void findById() throws IOException {
      int count = postdao.getCountByForumId(1);
      System.out.println(count);
    }

    @Test//��ѯ����
    public void getPostsByForumId() throws  Exception{
       List <Post> posts=postdao.getPostsByForumId(1);
        System.out.println(posts.toString());
    }
    @Test//�޸�
    public void updatePost() throws  Exception{
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        byte[] a = {2};
        Post post=new Post();
        post.setPost_id(10);
        post.setTitle("mybatis");
        post.setContent("hahahaha");
        post.setThumbnail(a);
        post.setPost_time(timestamp);
        post.setAccount("200000");
        postdao.updatePost(post); 
    }
}