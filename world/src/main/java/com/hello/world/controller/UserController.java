package com.hello.world.controller;


import com.hello.world.entity.User;
import com.hello.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        try{
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody Map<String, Object> request, @PathVariable("id") int id){
        try{
            String username = (String) request.get("username");
            User updatedUser = userService.updateUserById(username,id);
            return new ResponseEntity<>(updatedUser,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@RequestBody Map<String, Object> request, @PathVariable("id") int id){
        try{
            boolean isDeleted = (boolean) request.get("deleted");
            userService.deleteUserById(isDeleted,id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        try{
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getusername/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable("username") String username){
        try{
            User user = userService.findUserByUsername(username);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
