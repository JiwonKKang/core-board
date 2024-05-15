package com.core.corebackboard.like.service;

import com.core.corebackboard.like.api.LikeDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeAppender {

    private final LikeRepository likeRepository;

    public void append(LikeDomain likeDomain) {
        likeRepository.save(likeDomain);
    }
}
