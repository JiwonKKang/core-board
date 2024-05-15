package com.core.corebackboard.comment.entity;

import com.core.corebackboard.comment.service.CommentDomain;
import com.core.corebackboard.post.entity.Post;
import com.core.corebackboard.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private LocalDateTime createdAt;

    public CommentDomain toDomain() {
        return new CommentDomain(
                id,
                content,
                writer.toDomain(),
                createdAt
        );
    }

}
