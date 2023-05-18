package com.hello.world.service;

import com.hello.world.entity.Comment;
import com.hello.world.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    private CommentRepository commentRepository;
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }
    public void updateCommentById(String comment, int id){
        commentRepository.updateById(comment,id);
    }
    @Override
    public void deleteCommentById(int id){
        commentRepository.deleteById(id);
    }
    @Override
    public List<Comment> getByPostId(int id){
        return commentRepository.getByPostId(id);
    }
    @Override
    public Comment getCommentById(int id){
        return commentRepository.findById(id).orElse(null);
    }

}
