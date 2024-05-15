package com.core.corebackboard.like.service;

import com.core.corebackboard.like.api.LikeDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeRemover {

    private final LikeRepository likeRepository;

    public void remove(LikeDomain likeDomain) {
        likeRepository.delete(likeDomain);
    }

}
