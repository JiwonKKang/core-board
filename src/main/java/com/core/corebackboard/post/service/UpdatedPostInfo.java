package com.core.corebackboard.post.service;

public record UpdatedPostInfo(
        Long postId,
        PostInfo postInfo,
        Long userId
) {
}
