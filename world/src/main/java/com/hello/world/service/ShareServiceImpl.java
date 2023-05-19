package com.hello.world.service;

import com.hello.world.entity.Share;
import com.hello.world.repository.ShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShareServiceImpl implements ShareService{
    private ShareRepository shareRepository;
    @Autowired
    public ShareServiceImpl(ShareRepository shareRepository){
        this.shareRepository = shareRepository;
    }
    @Override
    public Share createShare(Share share){
        return shareRepository.save(share);
    }
    @Override
    public void deleteShareById(int id){
        shareRepository.deleteById(id);
    }
    @Override
    public Share getShareById(int id){
        return shareRepository.findById(id).orElse(null);
    }
}
