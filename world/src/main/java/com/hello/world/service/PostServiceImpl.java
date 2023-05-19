package com.hello.world.service;

import com.hello.world.entity.Post;
import com.hello.world.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public Post createPost(Post post){
        return postRepository.save(post);
    }
    @Override
    public void updatePostById(String type, int id){
        postRepository.updateById(type,id);
    }
    @Override
    public void deletePostById(int id){
        postRepository.deleteById(id);
    }
    @Override
    public Post getPostById(int id){
        return postRepository.getById(id);
    }
    @Override
    public List<Post> getPostByCommentsAndUsername(){
        return postRepository.getPostByCommentsAndUsername();
    }
}

















