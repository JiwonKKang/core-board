package com.core.corebackboard.post.service;

import com.core.corebackboard.user.service.UserDomain;

public interface PostRepository {
    Long save(PostInfo info, UserDomain user);

    PostDomain findById(Long postId);

    void update(PostDomain domain);
}
