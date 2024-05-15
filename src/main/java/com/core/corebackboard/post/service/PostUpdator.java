package com.core.corebackboard.post.service;

import com.core.corebackboard.post.entity.Post;
import com.core.corebackboard.user.service.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostUpdator {

    private final PostRepository postRepository;


    public void update(PostDomain postDomain) {
        postRepository.update(postDomain);
    }

    public void update(PostDomain post, UpdatedPostInfo updatedPostInfo) {
        post.update(updatedPostInfo);
        postRepository.update(post);
    }
}
