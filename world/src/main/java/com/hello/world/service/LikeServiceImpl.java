package com.hello.world.service;

import com.hello.world.entity.Like;
import com.hello.world.entity.Post;
import com.hello.world.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LikeServiceImpl implements LikeService{
    private LikeRepository likeRepository;
    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }
    @Override
    public Like createLike(Like like){
        return likeRepository.save(like);
    }
    @Override
    public void updateLikeByPostId(int postId, int id){
        likeRepository.updateById(postId,id);
    }
    @Override
    public void deleteLikeById(int id){
        likeRepository.deleteById(id);
    }
    @Override
    public List<Like> getLikeByPostId(int id){
        return likeRepository.getByPostId(id);
    }
    @Override
    public List<Post> getLikeByCreatedAt(LocalDate time){
        return likeRepository.getLikeByCreatedAt(time);
    }
}











