package com.hello.world.repository;

import com.hello.world.entity.Comment;
import com.hello.world.entity.User;
import com.hello.world.entity.Post;
import org.checkerframework.checker.units.qual.C;
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
        User user = userRepository.getById(1);
        Post post = postRepository.getById(4);
        if((user != null) && (post != null) ){
            Comment comment = new Comment(user,post,"you look so gorgeous!");
            commentRepository.save(comment);
        }
        else
            fail("User or post absent, take correct id");
    }
    @Test
    public void updateById(){
        boolean check = commentRepository.existsById(2);
        if(check == true){
            commentRepository.updateById("you look so gorgeous :)",2);
        }
        else
            fail("There is no comment with this id");
    }
    @Test
    public void deleteById(){
        boolean check = commentRepository.existsById(1);
        if(check == true){
            commentRepository.deleteById(1);
        }
        else
            fail("There is no comment with this id");
    }
    @Test
    public void getByPostId(){
        boolean check = postRepository.existsById(4);
        if(check == true){
            List<Comment> comments = commentRepository.getByPostId(4);
            System.out.println("comments: " + comments);
        }
        else
            fail("There is no post");
    }
}