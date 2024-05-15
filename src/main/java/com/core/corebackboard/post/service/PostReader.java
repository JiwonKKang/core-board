package com.core.corebackboard.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostReader {

    private final PostRepository postRepository;
    private final PostUpdator postUpdator;

    public PostDomain read(Long postId) {
        PostDomain domain = postRepository.findById(postId);
        domain.increaseViewCount();
        postUpdator.update(domain);
        return domain;
    }
}
