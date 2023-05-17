package com.hello.world.repository;

import com.hello.world.entity.Comment;
import com.hello.world.entity.User;
import com.hello.world.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Test
    public void save(){
        User user = new User("badel","badell@gmail.com","badell12","Hi, I am Badel");
        userRepository.save(user);
        Post post = new Post(user,"text","C:\\Users\\blabla\\text.txt");
        postRepository.save(post);
        Comment comment = new Comment(user,post,"this text is amazing!");
        commentRepository.save(comment);
        assertEquals("badel ", user.getUsername());
        Comment com = commentRepository.findById(comment.getId()).orElse(null);
        assertEquals(com.getId(),comment.getId());

    }
    @Test
    public void updateById(){
        User user = new User("Açelya","acelyaa@gmail.com","acelyaa..","Hi, I am Açelya!");
        userRepository.save(user);
        Post post = new Post(user,"voice","C:\\Users\\blabla\\voice.file");
        postRepository.save(post);
        Comment comment = new Comment(user,post,"I like it :)");
        Comment newComment = new Comment();
        newComment.setId(comment.getId());
        newComment.setUser(comment.getUser());
        newComment.setPost(comment.getPost());
        newComment.setComment("Great");
        newComment.setCreatedAt(comment.getCreatedAt());
        newComment.setUpdatedAt(comment.getUpdatedAt());
        newComment.setDeleted(comment.isDeleted());
        assertEquals(newComment.getId(),comment.getId());
        assertEquals(newComment.getUser(),comment.getUser());
        assertEquals(newComment.getPost(), comment.getPost());
        assertNotNull(newComment);
        commentRepository.save(newComment);
    }
    @Test
    public void deleteById(){
        User user = new User("Seda","seda@gmail.com","seda..","Hi, I am seda!");
        userRepository.save(user);
        Post post = new Post(user,"image","C:\\Users\\blabla\\image.jpg");
        postRepository.save(post);
        Comment comment = new Comment(user,post,"Looking hilarious...");
        commentRepository.save(comment);
        commentRepository.deleteById(comment.getId());
        Comment com = commentRepository.findById(comment.getId()).orElse(null);
        assertNull(com);
    }
    @Test
    public void getByPostId(){
        User user = new User("Suna","suna@gmail.com","suna..","Hi, I am suna!");
        userRepository.save(user);
        Post post = new Post(user,"image","C:\\Users\\blabla\\image.jpg");
        postRepository.save(post);
        Comment comment = new Comment(user,post,"Looking hilarious...");
        commentRepository.save(comment);
        List<Comment> comments = commentRepository.getByPostId(post.getId());
        assertNotNull(comments);
    }
}