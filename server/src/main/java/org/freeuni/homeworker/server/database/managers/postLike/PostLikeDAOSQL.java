package org.freeuni.homeworker.server.database.managers.postLike;

import org.freeuni.homeworker.server.database.source.ConnectionPool;
import org.freeuni.homeworker.server.model.postLike.PostLikeObject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PostLikeDAOSQL implements PostLikeDAO {

    private final String DELETE_QUERY = "DELETE FROM PostLikeTable WHERE userID = ? AND postID = ?;";
    private final String ADD_QUERY = "INSERT INTO PostLikeTable (?, ?);";
    private final ConnectionPool connectionsPool;

    public PostLikeDAOSQL(ConnectionPool connectionsPool){
        this.connectionsPool = connectionsPool;
    }

    /**
     * Adds Like Information In DataBase
     * @param postLikeObject Like Information(userID, postID)
     * @return true If Added Successfully
     */
    public boolean like(PostLikeObject postLikeObject) {
        return doOrder(postLikeObject, ADD_QUERY);
    }

    /**
     * Executes Given Query
     * @param postLikeObject Information To Based On To Execute(postId, UserID)
     * @param addQuery query
     */
    private void executeSQLQuery(PostLikeObject postLikeObject, String addQuery, Connection connection) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
        preparedStatement.setLong(1, postLikeObject.getUserID());
        preparedStatement.setLong(2, postLikeObject.getPostID());
        preparedStatement.execute();
    }

    /**
     * Removes Post Like Information From DataBase
     * @param postLikeObject UnLike Information(userID, postID)
     * @return true If Removed Successfully
     */
    public boolean unLike(PostLikeObject postLikeObject) {
        return doOrder(postLikeObject, DELETE_QUERY);
    }

    /**
     * Does query given
     * @param postLikeObject Object Which It Affects
     * @param query Query
     * @return true If Query Executed Successfully
     */
    private boolean doOrder(PostLikeObject postLikeObject, String query) {
        boolean queryExecuted;
        Connection connection = null;
        try {
            connection = connectionsPool.acquireConnection();
            executeSQLQuery(postLikeObject, query, connection);
            queryExecuted = true;
        } catch (Exception e) {
            e.printStackTrace();
            queryExecuted = false;
        } finally {
            if (connection != null) {
                connectionsPool.putBackConnection(connection);
            }
        }
        return queryExecuted;
    }

}