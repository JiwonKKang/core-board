package com.core.corebackboard.like.service;

import com.core.corebackboard.like.api.LikeDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeReader {

    private final LikeRepository likeRepository;

    public boolean isLiked(LikeDomain likeDomain) {
        return likeRepository.isLiked(likeDomain);
    }

    public long count(LikeDomain likeDomain) {
        return likeRepository.count(likeDomain);
    }

}
