package com.core.corebackboard.comment.repository;

import com.core.corebackboard.comment.entity.Comment;
import com.core.corebackboard.comment.service.CommentDomain;
import com.core.corebackboard.comment.service.CommentRepository;
import com.core.corebackboard.post.entity.Post;
import com.core.corebackboard.post.service.PostDomain;
import com.core.corebackboard.user.entity.User;
import com.core.corebackboard.user.service.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final CommentJpaRepository commentJpaRepository;

    @Override
    public void save(String content, UserDomain user, PostDomain post) {
        Comment comment = Comment.builder()
                .content(content)
                .writer(User.from(user))
                .post(Post.from(post))
                .createdAt(LocalDateTime.now())
                .build();
        commentJpaRepository.save(comment);
    }

    @Override
    public List<CommentDomain> find(Long postId) {
        List<Comment> comments = commentJpaRepository.findByPostId(postId);

        List<CommentDomain> commentDomains = new ArrayList<>();
        for (Comment comment : comments) {
            commentDomains.add(comment.toDomain());
        }

        return commentDomains;
    }
}
