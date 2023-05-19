package com.hello.world.service;

import com.hello.world.entity.Like;
import com.hello.world.entity.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LikeService {
    Like createLike(Like like);
    void updateLikeByPostId(int postId, int id);
    void deleteLikeById(int id);
    List<Like> getLikeByPostId(int id);
    List<Post> getLikeByCreatedAt(LocalDate time);
}
