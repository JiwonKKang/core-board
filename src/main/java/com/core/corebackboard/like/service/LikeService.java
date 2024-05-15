package com.core.corebackboard.like.service;

import com.core.corebackboard.like.dto.LikeStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeAppender likeAppender;
    private final LikeRemover likeRemover;
    private final LikeReader likeReader;

    public LikeStatus flipLike(LikeDomain likeDomain) {
        if (likeReader.isLiked(likeDomain)) {
            likeRemover.remove(likeDomain);
            return LikeStatus.UNLIKE;
        }

        likeAppender.append(likeDomain);
        return LikeStatus.LIKE;
    }

    public boolean isLiked(LikeDomain likeDomain) {
        return likeReader.isLiked(likeDomain);
    }

    public long count(LikeDomain likeDomain) {
        return likeReader.count(likeDomain);
    }
}
