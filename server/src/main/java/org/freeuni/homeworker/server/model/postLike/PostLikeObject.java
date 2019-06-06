package org.freeuni.homeworker.server.model.postLike;

import org.codehaus.jackson.annotate.JsonProperty;
import org.freeuni.homeworker.server.utils.StringUtils;

import java.io.Serializable;

public class PostLikeObject implements Serializable {

    @JsonProperty("id")
    private long id;

    @JsonProperty("userID")
    private long userID;

    @JsonProperty("postID")
    private long postID;

    @JsonProperty("liked")
    private boolean liked;

    /**
     * Constructs PostLike Object, Which Contains Information, That
     * usedeID Liked Post Which Id Is postID, Or Opposite
     * @param id user ID
     * @param userID User ID
     * @param postID Post ID
     * @param liked Shows Whether User Liked, Or Disliked The Post
     */
    public PostLikeObject(long id, int userID, int postID, boolean liked) {
        this.id = id;
        this.userID = userID;
        this.postID = postID;
        this.liked = liked;
    }

    public long getId() {
        return id;
    }

    public long getUserID() {
        return userID;
    }

    public long getPostID() {
        return postID;
    }

    public boolean isLiked() {
        return liked;
    }


}
