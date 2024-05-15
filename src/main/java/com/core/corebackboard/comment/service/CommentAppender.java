package com.core.corebackboard.comment.service;

import com.core.corebackboard.post.service.PostDomain;
import com.core.corebackboard.user.service.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentAppender {

    private final CommentRepository commentRepository;

    public void append(String content, UserDomain user, PostDomain post) {
        commentRepository.save(content, user, post);
    }
}
