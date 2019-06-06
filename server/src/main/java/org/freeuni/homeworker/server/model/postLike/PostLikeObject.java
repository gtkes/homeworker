package org.freeuni.homeworker.server.model.postLike;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_NULL) // annotation to include null values when converted to json
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

    public void setId(long id) {
        this.id = id;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("id : " + getId() + " ");
        toString.append("User ID : " + getUserID() + " ");
        toString.append("Post ID : " + getPostID() + " ");
        toString.append("Is Liked : " + isLiked());

        return toString.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserID(), getPostID(), isLiked());
    }

    @Override
    public boolean equals(Object other) {
        if(this == other){
            return true;
        }
        if( !(other instanceof PostLikeObject) ){
            return false;
        }

        PostLikeObject that = (PostLikeObject) other;
        return this.getId() == that.getId() &&
                this.getPostID() == that.getPostID() &&
                this.getUserID() == that.getUserID() &&
                this.isLiked() == that.isLiked();
    }
}
