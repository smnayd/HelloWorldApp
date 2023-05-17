package com.hello.world.repository;

import com.hello.world.entity.Post;
import com.hello.world.entity.Share;
import com.hello.world.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShareRepositoryTest {
    @Autowired
    ShareRepository shareRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveShare(){
        User user = new User("mehmet","mehmet@gmail.com","mehmet..","Hi, i am mehmet");
        userRepository.save(user);
        Post post = new Post(user,"image","image.com");
        postRepository.save(post);
        Share share = new Share(user,post,"www.instagram.com");
        shareRepository.save(share);
        assertEquals("www.instagram.com",share.getUrl());
    }
    @Test
    public void deleteById(){
        User user = new User("sema","sema@gmail.com","sema..","Hi, i am sema");
        userRepository.save(user);
        Post post = new Post(user,"image","image.com");
        postRepository.save(post);
        Share share = new Share(user,post,"www.whatsapp.com");
        shareRepository.save(share);
        shareRepository.deleteById(share.getId());
        Share find = shareRepository.findById(share.getId()).orElse(null);
        assertNull(find);
    }

}