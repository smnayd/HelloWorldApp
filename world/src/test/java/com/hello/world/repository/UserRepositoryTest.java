package com.hello.world.repository;

import com.hello.world.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser(){
        User user = new User("cansel","canselilay@gmail.com","hello","hi,i am cansel");
        userRepository.save(user);
    }

    @Test
    public void updateUser(){
        userRepository.updateUser("cansel",603);

    }
    @Test
    public void printUserByUsername(){
        List<User> users = userRepository.findByUsername("smaydnr");
        System.out.println(users);
    }
}
