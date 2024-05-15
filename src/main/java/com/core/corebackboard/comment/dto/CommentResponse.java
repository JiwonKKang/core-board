package com.core.corebackboard.comment.dto;

import com.core.corebackboard.comment.service.CommentDomain;
import com.core.corebackboard.user.dto.UserResponse;

import java.time.LocalDateTime;

public record CommentResponse(
        Long id,
        String content,
        UserResponse user,
        LocalDateTime createdAt
) {

    public static CommentResponse from(CommentDomain commentDomain) {
        return new CommentResponse(
                commentDomain.id(),
                commentDomain.content(),
                UserResponse.from(commentDomain.user()),
                commentDomain.createdAt()
        );
    }

}
