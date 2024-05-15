package com.core.corebackboard.post.service;

import com.core.corebackboard.user.service.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostDomain {
    private Long id;
    private PostInfo postInfo;
    private Long viewCount;
    private UserDomain user;

    public void increaseViewCount() {
        viewCount++;
    }

    public void update(UpdatedPostInfo updatedPostInfo) {
        this.postInfo = updatedPostInfo.postInfo();
    }
}
