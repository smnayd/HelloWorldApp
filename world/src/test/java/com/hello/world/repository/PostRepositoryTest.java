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
        User user = new User("atakan","atakan@gmail.com","atakan..","Hi, i am atakan");
        userRepository.save(user);
        Post post = new Post(user,"video","C:\\Users\\masaüstü\\file.mp4");
        postRepository.save(post);
        Post findPost = postRepository.findById(post.getId()).orElse(null);
        assertNotNull(findPost);
        assertEquals(post.getUser().getId(),user.getId());

    }
    @Test
    public void updateById(){
        User user = new User("özlem","özlem@gmail.com","özlem..","Hi, i am özlem");
        userRepository.save(user);
        Post post = new Post(user,"video","C:\\Users\\masaüstü\\file.mp4");
        postRepository.save(post);
        Post createdPost = new Post();
        createdPost.setId(post.getId());
        createdPost.setCreatedAt(post.getCreatedAt());
        createdPost.setUpdatedAt(post.getUpdatedAt());
        createdPost.setDeleted(post.isDeleted());
        createdPost.setFile("C:\\Users\\smayd\\video.mp4");
        createdPost.setComments(post.getComments());
        createdPost.setLikes(post.getLikes());
        createdPost.setShares(post.getShares());
        createdPost.setType(post.getType());
        createdPost.setUser(post.getUser());
        postRepository.save(createdPost);
        assertEquals(post.getId(),createdPost.getId());
        Post find = postRepository.findById(createdPost.getId()).orElse(null);
        assertNotNull(find);
    }
    @Test
    public void deleteById(){
        User user = new User("eyüp","eyüp@gmail.com","eyüp..","Hi, i am eyüp");
        userRepository.save(user);
        Post post = new Post(user,"video","C:\\Users\\masaüstü\\file.mp4");
        postRepository.save(post);
        postRepository.deleteById(post.getId());
        Post find = postRepository.findById(post.getId()).orElse(null);
        assertNull(find);
    }
    @Test
    public void getPostByCommentsAndUsername(){
        List<Post> postList = postRepository.getPostByCommentsAndUsername();
        assertNotNull(postList);
    }

}