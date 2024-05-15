package com.core.corebackboard.post.dto;

import com.core.corebackboard.post.service.PostDomain;
import com.core.corebackboard.user.dto.UserResponse;

public record PostResponse(
        Long postId,
        String title,
        String content,
        Long viewCount,
        UserResponse user
) {

    public static PostResponse from(PostDomain domain) {
        return new PostResponse(
                domain.getId(),
                domain.getPostInfo().title(),
                domain.getPostInfo().content(),
                domain.getViewCount(),
                UserResponse.from(domain.getUser())
        );
    }

}
