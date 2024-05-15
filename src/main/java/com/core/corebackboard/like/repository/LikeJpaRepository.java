package com.core.corebackboard.like.repository;

import com.core.corebackboard.like.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikeJpaRepository extends JpaRepository<Like, Long> {

    boolean existsByPost_IdAndUser_Id(Long postId, Long userId);

    void deleteByPost_IdAndUser_Id(Long postId, Long userId);

    long countByPost_Id(Long postId);
}
