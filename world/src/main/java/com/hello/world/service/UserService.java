package com.hello.world.service;

import com.hello.world.entity.User;

public interface UserService {
    User createUser(User user);
    void updateUserById(String username, int id);
    void deleteUserById(int id);
    User getUserById(int id);
    User findUserByUsername(String username);
}
