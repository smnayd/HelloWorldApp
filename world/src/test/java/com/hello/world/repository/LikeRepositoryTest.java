package com.hello.world.repository;

import com.hello.world.entity.Like;
import com.hello.world.entity.Post;
import com.hello.world.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LikeRepositoryTest {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Test
    public void saveLike(){
        User user = new User("Kurtulus","kurtulus@gmail.com","kurtulus..","Hi, I am kurtulus");
        userRepository.save(user);
        Post post = new Post(user,"text","C:\\Users\\masaüstü\\text.txt");
        postRepository.save(post);
        Like like = new Like(user,post);
        assertNotNull(like);
    }
    @Test
    public void updateById(){
        User user = new User("Sueda","sueda@gmail.com","sueda..","Hi, I am sueda");
        userRepository.save(user);
        User user2 = new User("Cansel","cansell@gmail.com","cansell..","Hi, i am cansel");
        userRepository.save(user2);
        Post post = new Post(user,"text","C:\\Users\\masaüstü\\text.txt");
        postRepository.save(post);
        Like like = new Like(user,post);
        likeRepository.save(like);
        Like updatedLike = new Like();
        updatedLike.setId(like.getId());
        updatedLike.setCreatedAt(like.getCreatedAt());
        updatedLike.setUser(user2);
        updatedLike.setPost(like.getPost());
        updatedLike.setDeleted(like.isDeleted());
        assertEquals(like.getPost().getId(),updatedLike.getPost().getId());
        likeRepository.save(updatedLike);
    }
    @Test
    public void deleteById(){
        User user = new User("Goktugg","goktugg@gmail.com","goktugg..","Hi, I am goktugg");
        userRepository.save(user);
        Post post = new Post(user,"text","C:\\Users\\blabla\\text.txt");
        postRepository.save(post);
        Like like = new Like(user,post);
        likeRepository.save(like);
        likeRepository.deleteById(like.getId());
        Like likee = likeRepository.findById(like.getId()).orElse(null);
        assertNull(likee);
    }
    @Test
    public void getByPostId(){
        User user = new User("sevinc","sevinc@gmail.com","sevinc..","Hi, I am sevinc");
        userRepository.save(user);
        Post post = new Post(user,"video","C:\\Users\\masaüstü\\file.mp4");
        postRepository.save(post);
        Like like = new Like(user,post);
        likeRepository.save(like);
        List<Like> likes = likeRepository.getByPostId(like.getPost().getId());
        assertNotNull(likes);
    }
    @Test
    public void getLikeByCreatedAt(){
        LocalDateTime time = LocalDateTime.now().minusDays(3);
        List<Post> likeList = (likeRepository.getLikeByCreatedAt(time));
        assertNotNull(likeList);
    }

}