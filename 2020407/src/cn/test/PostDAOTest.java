package cn.test;

import org.junit.jupiter.api.Assertions;

import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import cn.dao.PostDAO;
import cn.domain.Post;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
class PostDAOTest {
    @Autowired
    private PostDAO postDAO;
    private InputStream input;
	@Test
	void insertPostTest() {
		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		byte[] b = {1};
		Post post1 = new Post(1,"项目1","spring..",b,time1,"ax");
		int n1 = postDAO.insertPost(post1);
		assertEquals(1,n1);
	}
	@Test
	void deletePostTest() {
		int n2 = postDAO.deletePost(1);
		assertEquals(1,n2);
	}
	@Test
	void getPostByIdTest() {
		Post post = postDAO.getPostById(2);
		System.out.println(post.toString());
	}
    @Test
    void updatePostTest() {
    	Timestamp time2 = new Timestamp(System.currentTimeMillis());
    	byte[] a = {5};
        Post post2 = new Post(1,"项目2","spring..",a,time2,"ax",2);
        int n3 = postDAO.updatePost(post2);
        assertEquals(1,n3);
    }
    @Test
    void getPostsByForumIdTest() {
    	List<Post> post = postDAO.getPostsByForumId(1);
    	for(Post post11 : post) {
    		System.out.println(post11.toString());
    	}
    }
    @Test
    void getCountByForumIdTest() {
    	int count = postDAO.getCountByForumId(1);
    	System.out.println("一共有: "+count+"个帖子");
    }
}
