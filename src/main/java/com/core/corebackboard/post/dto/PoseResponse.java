package com.core.corebackboard.post.dto;

import com.core.corebackboard.user.dto.UserResponse;

public record PoseResponse(
        Long postId,
        String title,
        String content,
        Long viewCount,
        UserResponse user
) {
}
