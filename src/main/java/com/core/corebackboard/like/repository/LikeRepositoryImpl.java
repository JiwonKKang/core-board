package com.core.corebackboard.like.repository;

import com.core.corebackboard.like.service.LikeDomain;
import com.core.corebackboard.like.entity.Like;
import com.core.corebackboard.like.service.LikeRepository;
import com.core.corebackboard.post.entity.Post;
import com.core.corebackboard.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class LikeRepositoryImpl implements LikeRepository {

    private final LikeJpaRepository likeJpaRepository;

    @Override
    public boolean isLiked(LikeDomain likeDomain) {
        return likeJpaRepository.existsByPost_IdAndUser_Id(likeDomain.postId(), likeDomain.userId());
    }

    @Override
    @Transactional
    public void delete(LikeDomain likeDomain) {
        likeJpaRepository.deleteByPost_IdAndUser_Id(likeDomain.postId(), likeDomain.userId());
    }

    @Override
    public long count(LikeDomain likeDomain) {
        return likeJpaRepository.countByPost_Id(likeDomain.postId());
    }

    @Override
    public void save(LikeDomain likeDomain) {

        Like like = Like.builder()
                .user(User.from(likeDomain.userId()))
                .post(Post.from(likeDomain.postId()))
                .build();
        likeJpaRepository.save(like);
    }
}
