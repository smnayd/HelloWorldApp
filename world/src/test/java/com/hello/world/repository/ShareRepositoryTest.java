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
        User user = userRepository.getById(1);
        Post post = postRepository.getById(4);
        if((user != null) && (post != null)){
            Share share = new Share(user,post,"www.whatsapp.com");
            shareRepository.save(share);
        }
        else
            fail("There is no such user or post.");
    }
    @Test
    public void deleteById(){
        boolean check = shareRepository.existsById(1);
        if(check == true){
            shareRepository.deleteById(true,1);
        }
        else
            fail("There is no share");
    }

}