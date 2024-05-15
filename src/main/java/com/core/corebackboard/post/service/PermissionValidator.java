package com.core.corebackboard.post.service;

import com.core.corebackboard.user.service.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissionValidator {

    public void validate(PostDomain postDomain, UserDomain user) {
        if (!postDomain.getUser().id().equals(user.id())) {
            throw new RuntimeException("Permission denied");
        }

    }
}
