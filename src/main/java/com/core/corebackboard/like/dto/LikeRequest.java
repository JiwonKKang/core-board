package com.core.corebackboard.like.dto;

import com.core.corebackboard.like.service.LikeDomain;

public record LikeRequest(
        Long userId,
        Long postId
) {

    public LikeDomain toLikeDomain() {
        return new LikeDomain(
                userId,
                postId
        );
    }
}
