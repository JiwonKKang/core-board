package com.core.corebackboard.user.service;

public interface UserRepository {

    Long save(UserInfo userInfo);

    UserDomain findByEmail(String email);

    UserDomain findByUserId(Long userId);
}
