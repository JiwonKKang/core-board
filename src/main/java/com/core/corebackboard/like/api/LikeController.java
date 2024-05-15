package com.core.corebackboard.like.api;

import com.core.corebackboard.like.dto.LikeRequest;
import com.core.corebackboard.like.dto.LikeStatus;
import com.core.corebackboard.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/likes")
    public ResponseEntity<LikeStatus> flipLike(LikeRequest request) {
        LikeStatus likeStatus = likeService.flipLike(request.toLikeDomain());
        return ResponseEntity.ok(likeStatus);
    }

    @GetMapping("/likes")
    public ResponseEntity<Boolean> isLiked(LikeRequest request) {
        boolean isLiked = likeService.isLiked(request.toLikeDomain());
        return ResponseEntity.ok(isLiked);
    }

    @GetMapping("/likes/count")
    public ResponseEntity<Long> count(LikeRequest request) {
        return ResponseEntity.ok(likeService.count(request.toLikeDomain()));
    }

}
