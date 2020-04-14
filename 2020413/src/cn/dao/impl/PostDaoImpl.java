package cn.dao.impl;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import cn.dao.PostDao;
import cn.domain.Post;
import cn.utils.MybatisUtils;
public class PostDaoImpl implements PostDao {
	SqlSession session;
    @Override
    public int insertPost(Post post) throws IOException{
        session=MybatisUtils.getSession();
        int n=session.insert("insertPost",post);
        session.commit();//手动提交事务
        session.close();
        return n;
    }
    @Override
    public int deletePost(int post_id) throws IOException{
        session=MybatisUtils.getSession();
        int n=session.delete("deletePost",post_id);
        session.commit();
        session.close();
        return n;
    }
    @Override
    public Post getPostById(int post_id)throws IOException{
        session=MybatisUtils.getSession();
        Post post = session.selectOne("findById", 1);
        session.close();
        return post;
    }
    @Override
    public int updatePost(Post post)throws IOException {
        session=MybatisUtils.getSession();
        int n=session.update("updatePost",post);
        session.commit();//手动提交事务
        session.close();
        return n;
    }
    @Override
    public List<Post> getPostsByForumId(int forum_id)throws IOException {
        session=MybatisUtils.getSession();
        List<Post> posts=session.selectList("getPostsByForumId",forum_id);
        return posts;
    }
    @Override
    public int getCountByForumId(int forum_id)throws IOException {
        session=MybatisUtils.getSession();
        int count=session.selectOne("getCountByForumId",forum_id);
        return count;
    }
}
