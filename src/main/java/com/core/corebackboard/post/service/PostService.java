package com.core.corebackboard.post.service;

import com.core.corebackboard.user.service.UserDomain;
import com.core.corebackboard.user.service.UserReader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostAppender postAppender;
    private final UserReader userReader;
    private final PostReader postReader;
    private final PostUpdator postUpdator;
    private final PermissionValidator permissionValidator;

    public Long writePost(PostInfo postInfo, Long userId) {
        UserDomain user = userReader.read(userId);
        return postAppender.append(postInfo, user);
    }

    public PostDomain readPost(Long postId) {
        return postReader.read(postId);
    }

    public void updatePost(UpdatedPostInfo updatedInfo) {
        UserDomain user = userReader.read(updatedInfo.userId());
        PostDomain post = postReader.read(updatedInfo.postId());
        permissionValidator.validate(post, user);
        postUpdator.update(post, updatedInfo);
    }
}
