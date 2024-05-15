package com.core.corebackboard.comment.service;

import com.core.corebackboard.user.service.UserDomain;

import java.time.LocalDateTime;

public record CommentDomain(
        Long id,
        String content,
        UserDomain user,
        LocalDateTime createdAt
) {
}
