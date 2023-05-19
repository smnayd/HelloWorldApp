package com.hello.world.controller;

import com.hello.world.entity.Like;
import com.hello.world.entity.Post;
import com.hello.world.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;
    @Autowired
    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }
    @PostMapping
    public ResponseEntity<Like> createLike(@RequestBody Like like){
        try{
            Like createdLike = likeService.createLike(like);
            return new ResponseEntity<>(createdLike, HttpStatus.CREATED);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLikeByPostId(@RequestParam("postId") int postId, @PathVariable("id")int id){
        try{
            likeService.updateLikeByPostId(postId,id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLikeById(@PathVariable("id") int id){
        try{
            likeService.deleteLikeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Like>> getLikeByPostId(@PathVariable("id")int id){
        try{
            List<Like> likes = likeService.getLikeByPostId(id);
            return new ResponseEntity<>(likes,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/time/{time}")
    public ResponseEntity<List<Post>> getLikeByCreatedAt(@PathVariable("time") String time){
        try{
            LocalDate localDate = LocalDate.parse(time);
            List<Post> posts = likeService.getLikeByCreatedAt(localDate);
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}














