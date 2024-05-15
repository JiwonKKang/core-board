package com.core.corebackboard.post.entity;

import ch.qos.logback.classic.spi.LoggingEventVO;
import com.core.corebackboard.post.service.PostDomain;
import com.core.corebackboard.post.service.PostInfo;
import com.core.corebackboard.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Long viewCount;

    private Long likeCount;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private User writer;

    public static Post from(PostDomain post) {
        return Post.builder()
                .id(post.getId())
                .title(post.getPostInfo().title())
                .content(post.getPostInfo().content())
                .viewCount(post.getViewCount())
                .writer(User.from(post.getUser()))
                .build();
    }

    public static Post from(Long postId) {
        return Post.builder()
                .id(postId)
                .build();
    }

    public PostDomain toDomain() {
        return new PostDomain(
                id,
                new PostInfo(title, content),
                viewCount,
                writer.toDomain()
        );
    }

}
