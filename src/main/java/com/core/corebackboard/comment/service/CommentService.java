package com.core.corebackboard.comment.service;

import com.core.corebackboard.comment.entity.Comment;
import com.core.corebackboard.post.service.PostDomain;
import com.core.corebackboard.post.service.PostReader;
import com.core.corebackboard.user.service.UserDomain;
import com.core.corebackboard.user.service.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentAppender commentAppender;
    private final UserReader userReader;
    private final PostReader postReader;
    private final CommentFinder commentFinder;

    public void writeComment(String content, Long userId, Long postId) {
        UserDomain user = userReader.read(userId);
        PostDomain post = postReader.read(postId);
        commentAppender.append(content, user, post);
    }

    public List<CommentDomain> readComments(Long postId) {
        return commentFinder.find(postId);
    }
}
