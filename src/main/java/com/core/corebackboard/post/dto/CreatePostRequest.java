package com.core.corebackboard.post.dto;

import com.core.corebackboard.post.service.PostInfo;

public record CreatePostRequest(
        String title,
        String content,
        Long userId
) {

    public PostInfo toPostInfo() {
        return new PostInfo(
                title,
                content
        );
    }

}
