package blog.factory;

import blog.dao.BlogDAO;
import blog.dao.BloggerDAO;
import blog.dao.MessageBoardDAO;
import blog.daoImpl.BlogDAOImpl;
import blog.daoImpl.BloggerDAOImpl;
import blog.daoImpl.MessageBoardDAOImpl;
import blog.vo.Messageboard;

public class DAOFactory {
	public static BloggerDAO getBloggerDAOImpl() {
  	  return new BloggerDAOImpl();
    }
	public static MessageBoardDAO getMessageBoardDAOImpl() {
		return new MessageBoardDAOImpl();
	}
	public static BlogDAO getBlogDAOImpl() {
		return new BlogDAOImpl();
	}
}
