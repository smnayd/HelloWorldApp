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
        User user = new User("kübra","kübra@gmail.com","kübra","hi,i am kübra. whats up?");
        userRepository.save(user);
        User find = userRepository.findById(user.getId()).orElse(null);
        assertNotNull(find);
    }

    @Test
    public void updateById(){
        User user = new User("zehra","zehra.@gmail.com","zehra","hii");
        userRepository.save(user);
        User updatedUser = new User();
        updatedUser.setId(user.getId());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword("zehra..");
        updatedUser.setBio(user.getBio());
        userRepository.save(updatedUser);
        assertEquals(user.getEmail(),updatedUser.getEmail());
    }

    @Test
    public void deleteById(){
        User user = new User("bulut","bulut.@gmail.com","bulut..","hii");
        userRepository.save(user);
        userRepository.deleteById(user.getId());
        User find = userRepository.findById(user.getId()).orElse(null);
        assertNull(find);
    }
    @Test
    public void getById(){
        User user = new User("yagmur","yagmur.@gmail.com","yagmur","hii");
        userRepository.save(user);
        User find = userRepository.getById(user.getId());
        assertEquals(find.getId(),user.getId());
    }
    @Test
    public void findByUsername(){
        User user = new User("ales","ales.@gmail.com","ales","hii");
        userRepository.save(user);
        User find = userRepository.findByUsername(user.getUsername());
        assertEquals(find.getUsername(),user.getUsername());
    }
}
