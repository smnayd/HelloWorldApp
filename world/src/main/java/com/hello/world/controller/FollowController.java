package com.hello.world.controller;

import com.hello.world.entity.Follow;
import com.hello.world.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/follows")
public class FollowController {
    private FollowService followService;
    @Autowired
    public FollowController(FollowService followService){
        this.followService = followService;
    }
    @PostMapping
    public ResponseEntity<Follow> createFollow(@RequestBody Follow follow){
        try{
            Follow createdFollow = followService.createFollow(follow);
            return new ResponseEntity<>(createdFollow, HttpStatus.CREATED);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateByFollowing(@RequestBody Follow follow, @PathVariable("id") int id){
        try{
            int followingUser = follow.getFollowingUser().getId();
            int followerUser = follow.getFollowerUser().getId();
            followService.updateByFollowing(followingUser,followerUser);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollowById(@PathVariable("id") int id){
        try{
            followService.deleteFollowById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Integer> getByFollowingUser(@PathVariable("id")int id){
        try{
            int count = followService.getByFollowingUser(id);
            return new ResponseEntity<>(count,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/allFollows")
    public ResponseEntity<List<Follow>> getAll(){
        try{
            List<Follow> follows = followService.getAll();
            return new ResponseEntity<>(follows,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
















