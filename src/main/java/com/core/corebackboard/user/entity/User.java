package com.core.corebackboard.user.entity;

import com.core.corebackboard.user.service.UserDomain;
import com.core.corebackboard.user.service.UserInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    public UserDomain toDomain() {
        return new UserDomain(
                id,
                new UserInfo(
                        email,
                        password,
                        name
                )
        );
    }

    public static User from(UserDomain domain) {
        return User.builder()
                .id(domain.id())
                .name(domain.info().name())
                .email(domain.info().email())
                .password(domain.info().password())
                .build();
    }

    public static User from(Long userId) {
        return User.builder()
                .id(userId)
                .build();
    }
}
