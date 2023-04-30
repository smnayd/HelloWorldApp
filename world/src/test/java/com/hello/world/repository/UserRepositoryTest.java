package com.hello.world.repository;

import com.hello.world.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser(){
        User user = new User("rabiayagci","rabiayagci@gmail.com","rabiaa","hi,i am rabia. whats up?");
        userRepository.save(user);
    }

    @Test
    public void updateById(){
        boolean check = userRepository.existsById(606);
        if(check == true){
           userRepository.updateById("saturn",606);
        }
        else
            fail("There is no user with this id.");
    }

    @Test
    public void deleteById(){
        boolean check = userRepository.existsById(1);
        if(check == true){
            userRepository.deleteById(true,1);
        }
        else
            fail("There is no user with this id.");
    }
    @Test
    public void getById(){
        boolean check = userRepository.existsById(598);
        if(check == true){
            User user = userRepository.getById(598);
            System.out.println(user);
        }
        else{
            fail("There is no user with this id.");
        }
    }
    @Test
    public void findByUsername(){
        boolean check = userRepository.existsByUsername("saturn");
        if(check == true){
            User user = userRepository.findByUsername("saturn");
            System.out.println("User: " + user);
        }
        else
            fail("User could not find");
    }
}
