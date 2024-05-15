package com.core.corebackboard.like.api;

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
