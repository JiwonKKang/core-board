package com.core.corebackboard.post;

import com.core.corebackboard.post.entity.Post;
import com.core.corebackboard.post.repository.PostJpaRepository;
import com.core.corebackboard.post.service.PostDomain;
import com.core.corebackboard.post.service.PostInfo;
import com.core.corebackboard.post.service.PostRepository;
import com.core.corebackboard.user.entity.User;
import com.core.corebackboard.user.service.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostJpaRepository postJpaRepository;

    @Override
    public Long save(PostInfo info, UserDomain user) {
        Post post = Post.builder()
                .title(info.title())
                .content(info.content())
                .writer(User.from(user))
                .viewCount(0L)
                .build();

        return postJpaRepository.save(post).getId();
    }

    @Override
    public PostDomain findById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("Post not found")
        );

        return post.toDomain();
    }

    @Override
    public void update(PostDomain domain) {
        Post post = Post.builder()
                .id(domain.getId())
                .writer(User.from(domain.getUser()))
                .viewCount(domain.getViewCount())
                .content(domain.getPostInfo().content())
                .title(domain.getPostInfo().title())
                .build();

        postJpaRepository.save(post);
    }
}
