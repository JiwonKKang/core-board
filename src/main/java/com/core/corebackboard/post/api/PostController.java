package com.core.corebackboard.post.api;

import com.core.corebackboard.post.dto.CreatePostRequest;
import com.core.corebackboard.post.dto.PostResponse;
import com.core.corebackboard.post.dto.UpdatePostRequest;
import com.core.corebackboard.post.service.PostDomain;
import com.core.corebackboard.post.service.PostService;
import com.core.corebackboard.user.service.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Long> createPost(@RequestBody CreatePostRequest postRequest, @AuthenticationPrincipal UserDomain userDomain) {
        Long createdPostId = postService.writePost(postRequest.toPostInfo(), userDomain.id());
        return ResponseEntity.ok(createdPostId);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> readPost(@PathVariable Long postId) {
        PostDomain post = postService.readPost(postId);
        return ResponseEntity.ok(PostResponse.from(post));
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePost(updatePostRequest.toUpdatedPost(postId));
        return ResponseEntity.ok().build();
    }
}
