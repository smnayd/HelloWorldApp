package com.hello.world.controller;

import com.hello.world.entity.Post;
import com.hello.world.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        try{
            Post createdPost = postService.createPost(post);
            return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePostById(@RequestBody Map<String, Object> request, @PathVariable("id") int id){
        try{
            String type = (String) request.get("type");
            postService.updatePostById(type,id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable("id")int id){
        try{
            postService.deletePostById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id")int id){
        try{
            Post post = postService.getPostById(id);
            return new ResponseEntity<>(post,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Post>> getPostByCommentsAndUsername(){
        try{
            List<Post> posts = postService.getPostByCommentsAndUsername();
            return new ResponseEntity<>(posts,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}









