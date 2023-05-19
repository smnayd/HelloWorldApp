package com.hello.world.service;

import com.hello.world.entity.Post;
import com.hello.world.entity.Share;

public interface ShareService {
    Share createShare(Share share);
    void deleteShareById(int id);
    Share getShareById(int id);
}
