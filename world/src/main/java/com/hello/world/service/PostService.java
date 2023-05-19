package com.hello.world.service;

import com.hello.world.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    void updatePostById(String type, int id);
    void deletePostById(int id);
    Post getPostById(int id);
    List<Post> getPostByCommentsAndUsername();
}
