package com.core.corebackboard.comment.service;

import com.core.corebackboard.post.service.PostDomain;
import com.core.corebackboard.user.service.UserDomain;

import java.util.List;

public interface CommentRepository {

    void save(String content, UserDomain user, PostDomain post);

    List<CommentDomain> find(Long postId);
}
