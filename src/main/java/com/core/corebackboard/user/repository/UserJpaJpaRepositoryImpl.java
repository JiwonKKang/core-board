package com.core.corebackboard.user.repository;

import com.core.corebackboard.user.entity.User;
import com.core.corebackboard.user.service.UserDomain;
import com.core.corebackboard.user.service.UserInfo;
import com.core.corebackboard.user.service.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJpaJpaRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Long save(UserInfo userInfo) {

        User user = User.builder()
                .name(userInfo.name())
                .email(userInfo.email())
                .password(userInfo.password())
                .build();

        return userJpaRepository.save(user).getId();
    }

    @Override
    public UserDomain findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(User::toDomain)
                .orElseThrow(
                        () -> new EntityNotFoundException("User not found"));
    }

    @Override
    public UserDomain findByUserId(Long userId) {
        return userJpaRepository.findById(userId)
                .map(User::toDomain)
                .orElseThrow(
                        () -> new EntityNotFoundException("User not found"));
    }
}
