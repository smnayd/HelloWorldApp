package com.hello.world.controller;

import com.hello.world.entity.Share;
import com.hello.world.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shares")
public class ShareController {
    private ShareService shareService;
    @Autowired
    public ShareController(ShareService shareService){
        this.shareService = shareService;
    }
    @PostMapping
    public ResponseEntity<Share> createShare(@RequestBody Share share){
        try{
            Share createdShare = shareService.createShare(share);
            return new ResponseEntity<>(createdShare, HttpStatus.CREATED);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShareById(@PathVariable("id")int id){
        try{
            shareService.deleteShareById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Share> getShareById(@PathVariable("id")int id){
        try{
            Share share = shareService.getShareById(id);
            return new ResponseEntity<>(share,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
