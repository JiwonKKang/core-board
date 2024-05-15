package com.core.corebackboard.user.api;

import com.core.corebackboard.user.dto.LoginRequest;
import com.core.corebackboard.user.dto.SignUpRequest;
import com.core.corebackboard.user.dto.UserResponse;
import com.core.corebackboard.user.service.UserDomain;
import com.core.corebackboard.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Long> signUp(@RequestBody SignUpRequest signUpRequest) {
        Long createdUserId = userService.signUp(signUpRequest.toUserInfo());
        return ResponseEntity.ok(createdUserId);
    }

    @GetMapping("/users")
    public ResponseEntity<UserResponse> login(LoginRequest request) {
        UserDomain domain = userService.login(request.email(), request.password());
        UserResponse response = UserResponse.from(domain);
        return ResponseEntity.ok(response);
    }
}
