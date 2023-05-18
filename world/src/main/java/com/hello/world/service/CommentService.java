package com.hello.world.service;

import com.hello.world.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    void updateCommentById(String comment, int id);
    void deleteCommentById(int id);
    List<Comment> getByPostId(int id);
    Comment getCommentById(int id);
}
