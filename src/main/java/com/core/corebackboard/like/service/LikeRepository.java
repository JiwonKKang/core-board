package com.core.corebackboard.like.service;

import com.core.corebackboard.like.api.LikeDomain;

public interface LikeRepository {

    boolean isLiked(LikeDomain likeDomain);

    void delete(LikeDomain likeDomain);

    void save(LikeDomain likeDomain);

    long count(LikeDomain likeDomain);
}
