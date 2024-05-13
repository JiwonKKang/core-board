package com.core.corebackboard.user.repository;

import com.core.corebackboard.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
