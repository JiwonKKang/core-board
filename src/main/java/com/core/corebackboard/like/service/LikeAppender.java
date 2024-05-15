package com.core.corebackboard.like.service;

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
