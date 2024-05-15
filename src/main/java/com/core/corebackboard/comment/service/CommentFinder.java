package com.core.corebackboard.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentFinder {

    private final CommentRepository commentRepository;

    public List<CommentDomain> find(Long postId) {
        return commentRepository.find(postId);
    }

}
