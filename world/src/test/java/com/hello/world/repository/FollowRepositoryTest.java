package com.hello.world.repository;

import com.hello.world.entity.Follow;
import com.hello.world.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FollowRepositoryTest {
    @Autowired
    FollowRepository followRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveFollow(){
        User follower = new User("merve","merve@gmail.com","merve..","Hi i am merve");
        userRepository.save(follower);
        User following = new User("ceyda","ceyda@gmail.com","ceyda..","Hi i am ceyda");
        userRepository.save(following);
        Follow follow = new Follow(follower,following);
        assertNotNull(follow.getFollowerUser());
        assertNotNull(follow.getFollowingUser());
        followRepository.save(follow);
    }
    @Test
    public void updateByFollowing(){
        User follower = new User("sevde","sevde@gmail.com","sevde..","Hi i am sevde");
        userRepository.save(follower);
        User following = new User("şeyda","şeyda@gmail.com","şeyda..","Hi i am şeyda");
        userRepository.save(following);
        Follow follow = new Follow(follower,following);
        Follow updatedFollow = new Follow();
        updatedFollow.setId(follow.getId());
        updatedFollow.setFollowerUser(follow.getFollowingUser());
        updatedFollow.setFollowingUser(follow.getFollowerUser());
        updatedFollow.setUpdatedAt(follow.getUpdatedAt());
        updatedFollow.setCreatedAt(follow.getCreatedAt());
        updatedFollow.setDeleted(follow.isDeleted());
        assertEquals(follow.getId(),updatedFollow.getId());
        followRepository.save(updatedFollow);
    }
    @Test
    public void deleteById(){
        User follower = new User("kaylie","kaylie@gmail.com","kaylie..","Hi i am kaylie");
        userRepository.save(follower);
        User following = new User("jennier","jennier@gmail.com","jennier..","Hi i am jennier");
        userRepository.save(following);
        Follow follow = new Follow(follower,following);
        followRepository.save(follow);
        followRepository.deleteById(follow.getId());
        Follow deletedFollow = followRepository.findById(follow.getId()).orElse(null);
        assertNull(deletedFollow);
    }
    @Test
    public void getByFollowingUser(){
        User follower = new User("buseff","busffe@gmail.com","bufsef..","Hi i am buse");
        userRepository.save(follower);
        User following = new User("beriflf","beriffl@gmail.com","beffril..","Hi i am beril");
        userRepository.save(following);
        Follow follow = new Follow(follower,following);
        followRepository.save(follow);
        int count = followRepository.getByFollowingUser(follow.getFollowingUser().getId(),follow.getFollowingUser().isDeleted());
        assertNotEquals(count,0);
    }

}