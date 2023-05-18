package com.hello.world.service;

import com.hello.world.entity.User;

public interface UserService {
    User createUser(User user);
    User updateUserById(String username, int id);
    void deleteUserById(boolean isDeleted,int id);
    User getUserById(int id);
    User findUserByUsername(String username);
}
