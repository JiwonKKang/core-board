package com.core.corebackboard.post.api;

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
