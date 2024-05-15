package com.core.corebackboard.comment.dto;

public record CreateCommentRequest(
        Long userId,
        Long postId,
        String content
) {

}
