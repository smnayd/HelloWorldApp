package com.hello.world.repository;

import com.hello.world.entity.Follow;
import com.hello.world.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FollowRepositoryTest {
    @Autowired
    FollowRepository followRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveFollow(){
        boolean followerCheck = userRepository.existsById(123);
        boolean followingCheck = userRepository.existsById(34);
        if((followerCheck == true) && (followingCheck == true)){
            User follower = userRepository.getById(123);
            User following = userRepository.getById(34);
            Follow follow = new Follow(follower,following);
            followRepository.save(follow);
        }
        else
            fail("The user absent.");
    }
    @Test
    public void updateByFollowing(){
        boolean followerCheck = userRepository.existsById(606);
        boolean followingCheck = userRepository.existsById(608);
        if((followerCheck == true) && (followingCheck == true)) {
            followRepository.updateByFollowing(608,606);

        }
        else
            fail("The user absent.");
    }
    @Test
    public void deleteById(){
        boolean check = followRepository.existsById(2);
        if(check == true){
            followRepository.deleteById(true,2);
        }
        else
            fail("There is no follow with this id.");
    }
    @Test
    public void getByFollowingUser(){
        int count = followRepository.getByFollowingUser(2,false);
        System.out.println(count);
    }

}