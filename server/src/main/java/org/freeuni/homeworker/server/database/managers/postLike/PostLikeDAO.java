package org.freeuni.homeworker.server.database.managers.postLike;

import org.freeuni.homeworker.server.model.postLike.PostLikeObject;

public interface PostLikeDAO {

    boolean like(PostLikeObject postLikeObject); // User Like Method
    boolean unLike(PostLikeObject postLikeObject); // User Unlike Method

}