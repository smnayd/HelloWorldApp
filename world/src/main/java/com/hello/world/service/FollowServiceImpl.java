package com.hello.world.service;

import com.hello.world.entity.Follow;
import com.hello.world.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FollowServiceImpl implements FollowService{
    private FollowRepository followRepository;
    @Autowired
    public FollowServiceImpl(FollowRepository followRepository){
        this.followRepository = followRepository;
    }
    @Override
    public Follow createFollow(Follow follow){
        return followRepository.save(follow);
    }
    @Override
    public void updateByFollowing(int followingUser, int followerUser){
        followRepository.updateByFollowing(followingUser, followerUser);
    }
    @Override
    public void deleteFollowById(int id){
        followRepository.deleteById(id);
    }
    @Override
    public int getByFollowingUser(int followingId){
        return followRepository.getByFollowingUser(followingId);
    }
    @Override
    public List<Follow> getAll(){
        return followRepository.getAll();
    }

}













