package com.hello.world.repository;

import com.hello.world.entity.Post;
import com.hello.world.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    public void savePost(){
        User user = userRepository.getById(2);
        if(user != null){
            Post post = new Post(user,"text","text record");
            postRepository.save(post);
        }
        else
            fail("There is no user with this id");
    }
    @Test
    public void updateById(){
        boolean check = postRepository.existsById(4);
        if(check == true){
            postRepository.updateById("media",4);
        }
        else
            fail("There is no post with this id");
    }
    @Test
    public void deleteById(){
        boolean check = postRepository.existsById(4);
        if(check == true){
            postRepository.deleteById(true,4);
        }
        else
            fail("There is no post with this id.");
    }
    @Test
    public void getPostByCommentsAndUsername(){
        List<Post> postList = postRepository.getPostByCommentsAndUsername();
        System.out.println(postList.get(0).toString());
    }

}