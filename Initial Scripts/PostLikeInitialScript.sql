
USE homeworker;

DROP PostLike

CREATE TABLE PostLike(
    id PRIMARY KEY,
    userID NUMBER NOT NULL,
    postID NUMBER NOT NULL,
    liked BOOLEAN NOT NULL
);