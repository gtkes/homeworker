package org.freeuni.homeworker.server;

import org.freeuni.homeworker.server.database.managers.postLike.PostLikeDAO;
import org.freeuni.homeworker.server.database.managers.postLike.PostLikeDAOSQL;
import org.freeuni.homeworker.server.database.source.ConnectionPool;
import org.freeuni.homeworker.server.database.source.ConnectionPoolFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PostLikeServletListener implements ServletContextListener {

    private static final int NUMBER_OF_CONNECTIONS_IN_POST_LIKE_DAO = 20;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext servletContext = servletContextEvent.getServletContext();
            ConnectionPool connectionList = ConnectionPoolFactory.buildConnectionPool(NUMBER_OF_CONNECTIONS_IN_POST_LIKE_DAO);
            PostLikeDAO postLikeManager = new PostLikeDAOSQL(connectionList);
            servletContext.setAttribute(Constants.POST_LIKE_DAO, postLikeManager);
        } catch (Exception e) {
            throw new IllegalStateException("Error At PostLikeServletListener");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
