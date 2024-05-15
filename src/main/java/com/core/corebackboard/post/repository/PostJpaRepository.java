package com.core.corebackboard.post.repository;


import com.core.corebackboard.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
}
