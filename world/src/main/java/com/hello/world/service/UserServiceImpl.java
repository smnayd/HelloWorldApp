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
    public void updateUserById(String username,int id){
        userRepository.updateById(username,id);
    }
    @Override
    public void deleteUserById(int id){
        userRepository.deleteById(id);
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
