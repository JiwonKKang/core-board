package com.core.corebackboard.post.dto;

import com.core.corebackboard.post.service.PostInfo;
import com.core.corebackboard.post.service.UpdatedPostInfo;

public record UpdatePostRequest(
        Long id,
        String title,
        String content,
        Long userId
) {
    public UpdatedPostInfo toUpdatedPost(Long postId) {
        return new UpdatedPostInfo(
                postId,
                new PostInfo(title, content),
                userId
        );
    }

}
