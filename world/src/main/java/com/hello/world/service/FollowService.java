package com.hello.world.service;

import com.hello.world.entity.Follow;

import java.util.List;

public interface FollowService {
    Follow createFollow(Follow follow);
    void updateByFollowing(int followingUser, int followerUser);
    void deleteFollowById(int id);
    int getByFollowingUser(int followingId);
    List<Follow> getAll();
}
