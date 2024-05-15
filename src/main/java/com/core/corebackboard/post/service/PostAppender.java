package com.core.corebackboard.post.service;

import com.core.corebackboard.user.service.UserDomain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostAppender {

    private final PostRepository postRepository;

    public Long append(PostInfo postInfo, UserDomain user) {
        return postRepository.save(postInfo, user);
    }
}
