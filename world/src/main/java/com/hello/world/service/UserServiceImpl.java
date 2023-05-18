package com.hello.world.service;

import com.hello.world.entity.User;
import com.hello.world.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }
    @Override
    public User updateUserById(String username,int id){
        User user = userRepository.getById(id);
        user.setUsername(username);
        return userRepository.save(user);
    }
    @Override
    public void deleteUserById(boolean isDeleted, int id){
        User user = userRepository.getById(id);
        user.setDeleted(isDeleted);
        userRepository.save(user);
    }
    @Override
    public User getUserById(int id){
        return userRepository.getById(id);
    }
    @Override
    public User findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
