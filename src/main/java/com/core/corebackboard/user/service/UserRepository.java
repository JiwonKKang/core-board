package com.core.corebackboard.user.service;

import com.core.corebackboard.user.entity.User;

public interface UserRepository {

    Long save(UserInfo userInfo);

    UserDomain findByEmail(String email);

    UserDomain findByUserId(Long userId);

    UserDomain findByUsername(String username);
}
