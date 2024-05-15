package com.core.corebackboard.comment.api;

import com.core.corebackboard.comment.dto.CommentResponse;
import com.core.corebackboard.comment.dto.CreateCommentRequest;
import com.core.corebackboard.comment.service.CommentDomain;
import com.core.corebackboard.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<Void> writeComment(@RequestBody CreateCommentRequest request) {
        commentService.writeComment(
                request.content(),
                request.userId(),
                request.postId()
        );

        return ResponseEntity.ok().build();
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentResponse>> getComments(@RequestParam Long postId) {
        List<CommentDomain> commentDomains = commentService.readComments(postId);

        List<CommentResponse> res = commentDomains.stream()
                .map(CommentResponse::from)
                .toList();

        return ResponseEntity.ok().body(res);
    }

}
